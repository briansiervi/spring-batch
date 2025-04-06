package com.example.servicereaderjob.reader;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.annotation.AfterChunk;
import org.springframework.batch.core.annotation.BeforeChunk;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.servicereaderjob.domain.ResponseUser;
import com.example.servicereaderjob.domain.User;

@Component
public class UserReader implements ItemReader<User> {
  private RestTemplate restTemplate = new RestTemplate();
  private int page = 1;
  private List<User> users = new ArrayList<>();
  private int userIndex = 0;

  @Value("${chunkSize}")
  private int chunkSize;

  @Value("${pageSize}")
  private int pageSize;

  @Value("${limit}")
  private int limit;

  @Override
  public User read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
    User user;

    if (userIndex < users.size())
      user = users.get(userIndex);
    else
      user = null;

    userIndex++;
    return user;
  }

  @SuppressWarnings("null")
  private List<User> fetchUserDataFromAPI() {
    System.out.println("fetch");
    ResponseEntity<ResponseUser> response = restTemplate
        .getForEntity(String.format("https://gorest.co.in/public/v1/users?page=%d", page), ResponseUser.class);
    List<User> users = response.getBody().getData();
    return users;
  }

  @BeforeChunk
  private void beforeChunk(ChunkContext context) {
    System.out.println("Antes do chunk");
    for (int i = 1; (i <= (chunkSize / pageSize)) && (page <= (limit / pageSize)); i++) {
      users.addAll(fetchUserDataFromAPI());
      page++;
    }
  }

  @AfterChunk
  private void afterChunk(ChunkContext context) {
    System.out.println("Fim do chunk");
    userIndex = 0;
    users = new ArrayList<>();
  }
}