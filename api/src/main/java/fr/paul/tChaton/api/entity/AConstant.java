package fr.paul.tChaton.api.entity;

/**
 * @author Paul
 * @since 1.0.0
 * @version 1.0.0
 */
public abstract class AConstant {

    public static final String DEFAULT_MESSAGE = "Bonjour, que puis-je faire pour vous ?";
    public static final String MESSAGE_HELLO = "Hello";
    public static final String DEFAULT_USER_ID="U001" ;
    public static final String DEFAULT_USER_NAME="NAME_USER" ;
    public static final String SERVER_USER_ID = "S001";
    public static final String SERVER_USER_NAME="SERVER_BOT" ;
    public static final String DEFAULT_CREATION_DATE="01/02/2017/12/30/10" ;
    public static final String DEFAULT_CREATION_DATE2="01/02/2017/12/30/11" ;
    public static final User SERVER_USER = new User(AConstant.SERVER_USER_ID, AConstant.SERVER_USER_NAME);
    public static final User DEFAULT_USER = new User(AConstant.DEFAULT_USER_ID, AConstant.DEFAULT_USER_NAME);

    public static String TYPE_DB = "";
    public static String URL_DB = "";
    public static String PORT_DB = "";
    public static String NAME_DB = "";
}
