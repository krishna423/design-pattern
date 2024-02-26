package com.example.designpattern.logics.jdk13;

public class TextBlock {


    public static void main(String[] args) {


        String jsonDate = "{\"menu\": {\n" +
                "  \"id\": \"file\",\n" +
                "  \"value\": \"File\",\n" +
                "  \"popup\": {\n" +
                "    \"menuitem\": [\n" +
                "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\n" +
                "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\n" +
                "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\n" +
                "    ]\n" +
                "  }\n" +
                "}}";


        String newJsonWay  = """
                {"menu": {
                  "id": "file",
                  "value": "File",
                  "popup": {
                    "menuitem": [
                      {"value": "New", "onclick": "CreateNewDoc()"},
                      {"value": "Open", "onclick": "OpenDoc()"},
                      {"value": "Close", "onclick": "CloseDoc()"}
                    ]
                  }
                }}
                """;

        System.out.println(jsonDate);
        System.out.println(newJsonWay);



        String htmlData = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "\n" +
                "    <h1>My First Heading</h1>\n" +
                "    <p>My first paragraph.</p>\n" +
                "\n" +
                "</body>\n" +
                "</html>";

        String newHtmlData = """
                <!DOCTYPE html>
                <html>
                <body>
                                
                    <h1>My First Heading</h1>
                    <p>My first paragraph.</p>
                                
                </body>
                </html>
                """;

        System.out.println(htmlData);
        System.out.println(newHtmlData);
    }
}
