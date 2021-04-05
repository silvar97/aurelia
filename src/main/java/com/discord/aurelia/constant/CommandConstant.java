package com.discord.aurelia.constant;

public class CommandConstant {
    
  public static final  String GENERAL_REGEX="(^[^0-9A-Za-z])([a-z]+)(?:[^a-zA-Z])?(?:[a-zA-Z]+)?(?: )?(?:<\\B@![0-9]+\\b>)?(?:[^0-9a-zA-Z][a-zA-Z]+[^a-zA-Z0-9][a-zA-Z]+)?(?:[^0-9a-zA-Z][a-zA-Z][a-zA-Z]+)?";
  public static final  String MENTIONLESS_REGEX="(^[^0-9A-Za-z])([a-z]+)(?:[^a-zA-Z])?(?:[a-zA-Z]+)?";
  public static final  String USER_METION_REGEX="(^[^0-9A-Za-z])([a-z]+)(?:[^a-zA-Z])?(?:[a-zA-Z]+)? (<\\B@![0-9]+\\b>)";
  public static final  String CHANNEL_METION_REGEX= "(^[^0-9A-Za-z])([a-z]+)(?:[^a-zA-Z])?(?:[a-zA-Z]+)? (<\\B#[0-9]+\\b>)";
  public static final  String ROLE_METION_REGEX= "(^[^0-9A-Za-z])([a-z]+)(?:[^a-zA-Z])?(?:[a-zA-Z]+)? (<\\B@&[0-9]+\\b>)";


}
