package com.telerikacademy.api.tests;

public class Constants {

    public static final String BASE_URL = "https://api.trello.com";
    public static final String EMAIL = "aneliya.boneva.a50@learn.telerikacademy.com";
    public static final String API_KEY = "";
    public static final String API_TOKEN = "";
    public static  String BOARD_ID = "64d3ef0c9952f44cf00ed37d";
    public static  String LIST_ID = "64d3ef487e3584c65474a4e6";
    public static  String CARD_ID = "64d3ef816688addbd1fc1383";

    public static final String DESCRIPTION = "testing the API";
    public static final String BOARD_TITLE = "My First Trello Board - inetlliJ";
    public static final String CREATE_A_BOARD = "{\n" +
            "\n" +
            "  \"name\": \"" + BOARD_TITLE + "\",\n" +
            "  \n" +
            "  \"desc\": \"" + DESCRIPTION + "\"}";
    public static final String LIST_TITLE = "My first List on a Board";
    public static final String CREATE_A_LIST = "{\n" +
            "\n" +
            "\"name\": \"" + LIST_TITLE + "\",\n" +
            "  \n" +
            "  \"desc\": \"" + DESCRIPTION + " - lists\"}";
    public static final String CARD_TITLE = "a card via intelliJ";
    public static final String CREATE_A_CARD = "{\n" +
            "\n" +
            "  \"name\": \"" + CARD_TITLE + "\",\n" +
            "  \n" +
            "  \"desc\": \"" + DESCRIPTION + "\"}";

    public static final String UPDATED_TITLE = "An Updated card via intelliJ";
    public static final String UPDATED_DESC = "Updated desc - not very clever at 22 pm";
    public static final String UPDATE_A_CARD = "{\n" +
            "\n" +
            "  \"name\": \"" + UPDATED_TITLE + "\",\n" +
            "  \n" +
            "  \"desc\": \"" + UPDATED_DESC + "\"}";

    public static final String TARGET_COLOR = "orange";
    public static final String TARGET_BRIGHTNESS = "light";
    public static final String UPDATE_A_CARD_COLOR = "{\n" +
            "    \"name\": \"my card with color\",\n" +
            "\n" +
            "  \"cover\": {\n" +
            "      \"color\": \"" + TARGET_COLOR + "\",\n" +
            "      \"brightness\": \"" + TARGET_BRIGHTNESS + "\"\n" +
            "  }}";

    public static final String DELETE_BOARD = "{\n" +
            "\n" +
            "  \"id\": {{board_id}}}";
}
