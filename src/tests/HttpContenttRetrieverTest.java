package tests;

import main.*;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;

public class HttpContenttRetrieverTest {
    private HttpContentRetriever httpContenttRetriever;

    @Before
    public void initialize() {
        httpContenttRetriever = new HttpContentRetriever();
    }

    @Test
    public void test0() {
        String responseString = httpContenttRetriever.retrieveContentAsStringFromUri("https://jsonplaceholder.typicode.com/todos/1");
        assertTrue(responseString.equals("{\n" +
                "  \"userId\": 1,\n" +
                "  \"id\": 1,\n" +
                "  \"title\": \"delectus aut autem\",\n" +
                "  \"completed\": false\n" +
                "}"));
    }

    @Test
    public void test1() {
        String responseString = httpContenttRetriever.retrieveContentAsStringFromUri("https://jsonplaceholder.typicode.com/todos/0");
        assertTrue(responseString.equals("{}"));
    }

    @Test
    public void test2() {
        String responseString = httpContenttRetriever.retrieveContentAsStringFromUri("https://jsonplaceholder.typicode.com/comments?postId=1");
        assertTrue(responseString.equals("[\n" +
                "  {\n" +
                "    \"postId\": 1,\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"id labore ex et quam laborum\",\n" +
                "    \"email\": \"Eliseo@gardner.biz\",\n" +
                "    \"body\": \"laudantium enim quasi est quidem magnam voluptate ipsam eos\\ntempora quo necessitatibus\\ndolor quam autem quasi\\nreiciendis et nam sapiente accusantium\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"postId\": 1,\n" +
                "    \"id\": 2,\n" +
                "    \"name\": \"quo vero reiciendis velit similique earum\",\n" +
                "    \"email\": \"Jayne_Kuhic@sydney.com\",\n" +
                "    \"body\": \"est natus enim nihil est dolore omnis voluptatem numquam\\net omnis occaecati quod ullam at\\nvoluptatem error expedita pariatur\\nnihil sint nostrum voluptatem reiciendis et\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"postId\": 1,\n" +
                "    \"id\": 3,\n" +
                "    \"name\": \"odio adipisci rerum aut animi\",\n" +
                "    \"email\": \"Nikita@garfield.biz\",\n" +
                "    \"body\": \"quia molestiae reprehenderit quasi aspernatur\\naut expedita occaecati aliquam eveniet laudantium\\nomnis quibusdam delectus saepe quia accusamus maiores nam est\\ncum et ducimus et vero voluptates excepturi deleniti ratione\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"postId\": 1,\n" +
                "    \"id\": 4,\n" +
                "    \"name\": \"alias odio sit\",\n" +
                "    \"email\": \"Lew@alysha.tv\",\n" +
                "    \"body\": \"non et atque\\noccaecati deserunt quas accusantium unde odit nobis qui voluptatem\\nquia voluptas consequuntur itaque dolor\\net qui rerum deleniti ut occaecati\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"postId\": 1,\n" +
                "    \"id\": 5,\n" +
                "    \"name\": \"vero eaque aliquid doloribus et culpa\",\n" +
                "    \"email\": \"Hayden@althea.biz\",\n" +
                "    \"body\": \"harum non quasi et ratione\\ntempore iure ex voluptates in ratione\\nharum architecto fugit inventore cupiditate\\nvoluptates magni quo et\"\n" +
                "  }\n" +
                "]"));
    }

    @Test
    public void test3() {
        String responseString = httpContenttRetriever.retrieveContentAsStringFromUri("https://jsonplaceholder.typicode.com/posts/1/comments");
        assertTrue(responseString.equals("[\n" +
                "  {\n" +
                "    \"postId\": 1,\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"id labore ex et quam laborum\",\n" +
                "    \"email\": \"Eliseo@gardner.biz\",\n" +
                "    \"body\": \"laudantium enim quasi est quidem magnam voluptate ipsam eos\\ntempora quo necessitatibus\\ndolor quam autem quasi\\nreiciendis et nam sapiente accusantium\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"postId\": 1,\n" +
                "    \"id\": 2,\n" +
                "    \"name\": \"quo vero reiciendis velit similique earum\",\n" +
                "    \"email\": \"Jayne_Kuhic@sydney.com\",\n" +
                "    \"body\": \"est natus enim nihil est dolore omnis voluptatem numquam\\net omnis occaecati quod ullam at\\nvoluptatem error expedita pariatur\\nnihil sint nostrum voluptatem reiciendis et\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"postId\": 1,\n" +
                "    \"id\": 3,\n" +
                "    \"name\": \"odio adipisci rerum aut animi\",\n" +
                "    \"email\": \"Nikita@garfield.biz\",\n" +
                "    \"body\": \"quia molestiae reprehenderit quasi aspernatur\\naut expedita occaecati aliquam eveniet laudantium\\nomnis quibusdam delectus saepe quia accusamus maiores nam est\\ncum et ducimus et vero voluptates excepturi deleniti ratione\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"postId\": 1,\n" +
                "    \"id\": 4,\n" +
                "    \"name\": \"alias odio sit\",\n" +
                "    \"email\": \"Lew@alysha.tv\",\n" +
                "    \"body\": \"non et atque\\noccaecati deserunt quas accusantium unde odit nobis qui voluptatem\\nquia voluptas consequuntur itaque dolor\\net qui rerum deleniti ut occaecati\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"postId\": 1,\n" +
                "    \"id\": 5,\n" +
                "    \"name\": \"vero eaque aliquid doloribus et culpa\",\n" +
                "    \"email\": \"Hayden@althea.biz\",\n" +
                "    \"body\": \"harum non quasi et ratione\\ntempore iure ex voluptates in ratione\\nharum architecto fugit inventore cupiditate\\nvoluptates magni quo et\"\n" +
                "  }\n" +
                "]"));
    }

    @Test(expected = java.lang.IllegalArgumentException.class)
    public void test4() {
        String responseString = httpContenttRetriever.retrieveContentAsStringFromUri("");
    }

}
