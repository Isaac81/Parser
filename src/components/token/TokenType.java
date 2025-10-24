package components.token;

public enum TokenType
{
    /* ########################################
     *
     *                   GENERAL
     *
     * ########################################
     *
     *           VALUES FROM 0 TO 40
     */

    IDENTIFIER                          (0, "identifier (name of functions, components, variables, etc."),
    LINE                                (1, "line"),
    CONST                               (2, "constant"),
    BREAK                               (3, "stop"),
    PASS                                (4, "continue"),
    RETURN                              (5, "return"),
    IS                                  (6, "compare objects"),
    LEN                                 (7, "length"),
    TYPE                                (8, "type of the identifier"),
    DEFAULT                             (9, "default: unknown token"),
    OPEN_BRACKET                        (10, "{"),
    CLOSE_BRACKET                       (11, "}"),
    OPEN_PARENTHESIS                    (12, "("),
    CLOSE_PARENTHESIS                   (13, ")"),
    OPEN_SQUARE_BRACKET                 (14, "["),
    CLOSE_SQUARE_BRACKET                (15, "]"),
    DOT                                 (16, "."),
    COLON                               (17, ":"),
    COMA                                (18, ","),
    SEMICOLON                           (19, ";"),
    ASSIGN                              (20, "="),
    ARROW                               (21, "->"),
    SINGLE_QUOTE                        (22, "'"),
    DOUBLE_QUOTE                        (23, "\""),


    /* ########################################
     *
     *                   COMMENTS
     *
     * ########################################
     *
     *           VALUES FROM 41 TO 42
     */

    COMMENT                             (41, "--"),
    MULTILINE_COMMENT                   (42, "---"),


    /* ########################################
     *
     *                   TYPES
     *
     * ########################################
     *
     *           VALUES FROM 43 TO 60
     */

    BOOL                                (43, "boolean"),

    //          INTEGERS            //
    BYTE                                (44, "-128 to 127"),
    SINT                                (45, "short (-32768 - 32767)"),
    INT                                 (46, "-2,147,483,648 - 2,147,483,647"),
    UINT                                (47, "Unsigned int 0 - 4,294,967,295"),
    BINT                                (48, "Big-int -9,223,372,036,854,775,808 - 9,223,372,036,854,775,807"),

    //          FLOATING            //
    FLOAT                               (49, "float"),
    DOUBLE                              (50, "double"),

    //          CHARACTERS            //
    CHAR                                (53, "char"),
    STR                                 (54, "string"),

    //          OTHERS            //
    VOID                                (55, "void"),


    /* ########################################
     *
     *                  OPERATORS
     *
     * ########################################
     *
     *           VALUES FROM 61 TO 95
     */

    //          LOGIC            //
    OR                                  (61, "or"),
    AND                                 (62, "and"),
    NOT                                 (63, "not"),
    IN                                  (64, "in"),

    //          COMPARATIVE            //
    GREATER_THAN                        (70, ">"),
    GREATER_OR_EQUALS                   (71, ">="),
    LESS_THAN                           (72, "<"),
    LESS_OR_EQUALS                      (73, "<="),
    EQUALS                              (74, "=="),
    DIFFERENT                           (75, "!="),

    //          ARITHMETIC            //
    SUM                                 (76, "+"),
    AUTO_INCREMENT                      (77, "++"),
    SUB                                 (78, "-"),
    AUTO_DECREMENT                      (79, "--"),
    ADD_ASSIGNMENT                      (80, "+="),
    SUB_ASSIGNMENT                      (81, "-="),
    MUL                                 (82, "*"),
    DIV                                 (83, "/"),
    INTEGER_DIV                         (84, "//"),
    POW                                 (85, "**"),
    MOD                                 (86, "%"),


    /* ########################################
     *
     *                  VALUES
     *
     * ########################################
     *
     *           VALUES FROM 96 TO 105
     */

    TRUE                                (96, "ture"),
    FALSE                               (97, "false"),
    NULL                                (98, "null"),
    IS_INT                              (99, "Integer value"),
    IS_FLOAT                            (100, "Float value"),
    IS_STRING                           (101, "String value"),
    IS_COMMENT                          (102, "Comment content"),


    /* ########################################
     *
     *                 STRUCTURES
     *
     * ########################################
     *
     *           VALUES FROM 106 TO 115
     */

    //          CONTROL            //
    IF                                  (106, "if"),
    ELIF                                (107, "elif"),
    ELSE                                (108, "else"),
    SW                                  (109, "switch"),
    CASE                                (110, "case"),

    //          LOOPS            //
    FOR                                 (111, "for"),
    WHILE                               (112, "while"),
    DO_WHILE                            (113, "do while"),


    /* ########################################
     *
     *               CLASSES
     *
     * ########################################
     *
     *           VALUES FROM 200 TO 220
     */

    CLASS                               (200, "class"),
    OBJECT                              (201, "object");


    private final int value;
    private final String description;

    TokenType(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
