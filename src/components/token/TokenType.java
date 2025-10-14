package components.token;

public enum TokenType
{
    /* ########################################
     *
     *                   GENERAL
     *
     * ########################################
     *
     *           VALUES FROM 0 TO 27
     */
    SEMICOLON                           (0, ";"),
    COMA                                (1, ","),
    IDENTIFIER                          (2, "identifier (name of functions, components.variables, etc."),
    LINE                                (3, "line"),
    ASSIGN                              (4, "="),
    CONST                               (5, "constant"),
    BREAK                               (6, "stop"),
    PASS                                (7, "continue"),
    RETURN                              (8, "return"),
    IS                                  (9, "compare the objects"),
    LEN                                 (10, "length"),
    TYPE                                (11, "type of the identifier"),
    DEFAULT                             (12, "default: don't recognize this"),
    OPEN_BRACKET                        (13, "{"),
    CLOSE_BRACKET                       (14, "}"),
    OPEN_PARENTHESIS                    (15, "("),
    CLOSE_PARENTHESIS                   (16, ")"),
    OPEN_SQUARE_BRACKET                 (17, "["),
    CLOSE_SQUARE_BRACKET                (18, "]"),
    DOT                                 (19, "."),
    ARROW                               (20, "->"),
    SINGLE_QUOTE                        (21, "'"),
    DOUBLE_QUOTE                        (22, "\""),
    IS_STRING                           (23, "String value"),
    IS_COMMENT                          (24, "Comment content"),


    /* ########################################
     *
     *                   COMMENTS
     *
     * ########################################
     *
     *           VALUES FROM 28 TO 29
     */
    COMMENT                             (28, "--"),
    MULTILINE_COMMENT                   (29, "---"),


    /* ########################################
     *
     *                   TYPES
     *
     * ########################################
     *
     *           VALUES FROM 30 TO 60
     */

    BOOL                                (30, "boolean"),

    //          INTEGERS            //
    BYTE                                (31, "-128 to 127"),
    SINT                                (32, "short (-32768 - 32767)"),
    INT                                 (33, "-2,147,483,648 - 2,147,483,647"),
    UINT                                (34, "Unsigned int 0 - 4,294,967,295"),
    BINT                                (35, "Big-int -9,223,372,036,854,775,808 - 9,223,372,036,854,775,807"),

    //          FLOATING            //
    FLOAT                               (40, """
        float
        Positive: Min = 1.4E-45,  Max = 3.4028235E38
        Negative: -3.4028235E38 to -1.4E-45
        """),
    DOUBLE                              (41, "double \n Min = −1.7976931348623157×10E308  Max = " +
                                            "1.7976931348623157×10E308"),

    //          CHARACTERS            //
    CHAR                                (42, "char"),
    STR                                 (43, "string"),

    //          OTHERS            //
    VOID                                (60, "void"),


    /* ########################################
     *
     *                  OPERATORS
     *
     * ########################################
     *
     *           VALUES FROM 61 TO 85
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
    SUB                                 (77, "-"),
    MUL                                 (78, "*"),
    DIV                                 (79, "/"),
    INTEGER_DIV                         (80, "//"),
    POW                                 (81, "**"),
    MOD                                 (82, "%"),


    /* ########################################
     *
     *                  VALUES
     *
     * ########################################
     *
     *           VALUES FROM 86 TO 90
     */

    TRUE                                (86, "ture"),
    FALSE                               (87, "false"),
    NULL                                (88, "null"),
    IS_INT                              (89, "Integer value"),
    IS_FLOAT                            (90, "Float value"),


    /* ########################################
     *
     *                 STRUCTURES
     *
     * ########################################
     *
     *           VALUES FROM 91 TO 105
     */

    //          CONTROL            //
    IF                                  (91, "if"),
    ELIF                                (92, "elif"),
    ELSE                                (93, "else"),
    SW                                  (94, "switch"),
    CASE                                (95, "case"),

    //          LOOPS            //
    FOR                                 (96, "for"),
    WHILE                               (97, "while"),
    DO_WHILE                            (98, "do while"),


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
