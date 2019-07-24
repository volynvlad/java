package by.bsu.first.command;

import java.util.Optional;

import java.util.stream.Stream;



public enum CommandType2 {

  GET_BET_INFO("admin", "client", "bookmaker"),

  ADD_USER("admin"),

  GET_RACE_RESULT_GENERATION_PAGE("admin"),

  GET_RACE_MANAGE_PAGE("admin"),

  GENERATE_RACE_RESULT("admin"),

  INVALIDATE_BET("admin"),

  ADD_BALANCE("client"),

  GET_ALL_USERS("admin"),

  DELETE_USER("admin"),

  GET_ADD_USER_PAGE("admin"),

  GET_SET_BOOKMAKER_PAGE("admin"),

  GET_FACTOR_PAGE("bookmaker"),

  GET_BOOKMAKER_PAGE("bookmaker"),

  SET_BOOKMAKER("admin"),

  SET_NEW_FACTORS("bookmaker"),

  SET_BET("client"),

  GET_SUCCESSFUL_BET_PAGE("client"),

  GET_NEW_RACE_PAGE("admin"),

  SET_NEW_RACE("admin"),

  SET_NEW_PARTICIPANT("admin"),

  GET_RACE_SELECT_TO_CHANGE_PAGE("admin"),

  GET_RACE_CHANGE_PAGE("admin"),

  LOG_IN("default"),

  GET_REGAIN_INFO("default"),

  GET_LOGIN_PAGE("default"),

  GET_REGISTER_PAGE("default"),

  GET_EMAIL_ENTER_PAGE("default"),

  GET_NEW_PASS_PAGE("default"),

  LOG_OUT("admin", "client", "bookmaker"),

  SIGN_UP("default"),

  SHOW_RACE_INFO("admin", "client", "bookmaker", "default"),

  GET_ALL_RACES("admin", "client", "bookmaker", "default"),

  GET_USER_BALANCE("client"),

  GET_ALL_BETS( "client"),

  REGAIN_PASS("default"),

  NEW_PASS("default"),

  GET_HOME_PAGE_DATA("admin", "client", "bookmaker", "default"),

  DEFAULT_VALUE("");



  private String[] roles;



  CommandType2(String... roles) {

    this.roles = roles;

  }



  public static Optional<CommandType> fromString(String type) {

    return Stream.of(CommandType.values())

            .filter(e -> e.name().equalsIgnoreCase(type))

            .findFirst();

  }



  public boolean isValidRole(String role) {

    return Stream.of(roles).anyMatch(r -> r.equalsIgnoreCase(role));

  }

}
