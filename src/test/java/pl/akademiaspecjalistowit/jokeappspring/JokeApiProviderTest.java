//package pl.akademiaspecjalistowit.jokeappspring;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import java.io.IOException;
//import java.net.http.HttpClient;
//import java.net.http.HttpResponse;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import pl.akademiaspecjalistowit.jokeappspring.joke.model.Joke;
//import pl.akademiaspecjalistowit.jokeappspring.joke.service.provider.JokeApiProvider;
//import pl.akademiaspecjalistowit.jokeappspring.joke.service.provider.JokeProvider;
//
//class JokeApiProviderTest {
//
//    @Test
//    void should_return_joke_on_get_joke_call() throws IOException, InterruptedException {
//        //given
//        HttpResponse httpResponseMock = Mockito.mock(HttpResponse.class);
//        HttpClient mockHttpClient = Mockito.mock(HttpClient.class);
//
//        Mockito.when(httpResponseMock.body()).thenReturn(getJsonJoke());
//        Mockito.when(mockHttpClient.send(Mockito.any(),Mockito.any()))
//            .thenReturn(httpResponseMock);
//
//        JokeProvider jokeApiProvider = new JokeApiProvider(mockHttpClient);
//
//        //when
//        Joke joke = jokeApiProvider.getJoke();
//
//        //then
//        assertNotNull(joke);
//    }
//
//    private String getJsonJoke() {
//        return "{\n" +
//            "    \"error\": false,\n" +
//            "    \"category\": \"Misc\",\n" +
//            "    \"type\": \"twopart\",\n" +
//            "    \"setup\": \"What do you call a bird sitting with their legs spread?\",\n" +
//            "    \"delivery\": \"A prostitweety.\",\n" +
//            "    \"flags\": {\n" +
//            "        \"nsfw\": true,\n" +
//            "        \"religious\": false,\n" +
//            "        \"political\": false,\n" +
//            "        \"racist\": false,\n" +
//            "        \"sexist\": false,\n" +
//            "        \"explicit\": true\n" +
//            "    },\n" +
//            "    \"id\": 224,\n" +
//            "    \"safe\": false,\n" +
//            "    \"lang\": \"en\"\n" +
//            "}";
//    }
//
//
//}