package analyzers.context;

import components.symbol.SymbolEntryStructure;
import components.symbol.SymbolEntryVariable;
import components.token.Token;

import java.util.*;

public class SyntacticContext {
    List<String> fileContent;
    List<Token> tokensList;
    Map<String, SymbolEntryStructure> symbolTableStruct;
    Map<String, SymbolEntryVariable> symbolTableVar;
    String scope;

    public SyntacticContext() {
        fileContent = new ArrayList<>();
        tokensList = new LinkedList<>();
        symbolTableStruct = new HashMap<>();
        symbolTableVar = new HashMap<>();
        scope = null;
    }

    public SyntacticContext(List<Token> tokensList) {
        this();
        this.tokensList = tokensList;
    }

    public List<String> getFileContent() {
        return fileContent;
    }

    public void setFileContent(List<String> fileContent) {
        this.fileContent = fileContent;
    }

    public List<Token> getTokensList() {
        return tokensList;
    }

    public void setTokensList(List<Token> tokensList) {
        this.tokensList = tokensList;
    }

    public Map<String, SymbolEntryStructure> getSymbolTableStruct() {
        return symbolTableStruct;
    }

    public void setSymbolTableStruct(Map<String, SymbolEntryStructure> symbolTableStruct) {
        this.symbolTableStruct = symbolTableStruct;
    }

    public Map<String, SymbolEntryVariable> getSymbolTableVar() {
        return symbolTableVar;
    }

    public void setSymbolTableVar(Map<String, SymbolEntryVariable> symbolTableVar) {
        this.symbolTableVar = symbolTableVar;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "SyntacticContext{" +
                "fileContent=" + fileContent +
                ", tokensList=" + tokensList +
                ", symbolTableStruct=" + symbolTableStruct +
                ", symbolTableVar=" + symbolTableVar +
                ", scope=" + scope +
                '}';
    }
}
