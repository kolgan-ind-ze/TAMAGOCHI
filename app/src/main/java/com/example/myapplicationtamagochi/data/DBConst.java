package com.example.myapplicationtamagochi.data;

public class DBConst {
    public static final String DATA_BASE_NAME = "tamagochi.db";
    public static final int DATA_BASE_VERSION = 1;
    public static final String TAMAGOCHI_TABLE_NAME = "TamagochiTable";
    public static final String RECORD_ID = "id";
    public static final String RECORD_TIME = "seconds";

    public static final String CREATE_TABLE_TAMAGOCHI = "CREATE TABLE IF NOT EXISTS " +
            TAMAGOCHI_TABLE_NAME + " ( " + RECORD_ID + " INTEGER PRIMARY KEY, " +
            RECORD_TIME + " INTEGER);";
    public static final String DELETE_TABLE_TAMAGOCHI = "DROP TABLE IF EXISTS " +
            TAMAGOCHI_TABLE_NAME;
}
