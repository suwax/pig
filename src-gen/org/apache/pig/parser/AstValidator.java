// $ANTLR 3.4 /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g 2014-07-02 16:22:14

package org.apache.pig.parser;

import org.apache.pig.data.DataType;
import org.apache.pig.impl.util.NumValCarrier;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


/**
 * Grammar file for Pig tree parser (visitor for default data type insertion).
 *
 * NOTE: THIS FILE IS BASED ON QueryParser.g, SO IF YOU CHANGE THAT FILE, YOU WILL
 *       PROBABLY NEED TO MAKE CORRESPONDING CHANGES TO THIS FILE AS WELL.
 */
@SuppressWarnings({"all", "warnings", "unchecked"})
public class AstValidator extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ALL", "AMPERSAND", "AND", "ARROBA", "AS", "ASC", "ASSERT", "BAG", "BIGDECIMAL", "BIGDECIMALNUMBER", "BIGINTEGER", "BIGINTEGERNUMBER", "BOOLEAN", "BY", "BYTEARRAY", "CACHE", "CASE", "CHARARRAY", "COGROUP", "COLON", "COMMA", "CROSS", "CUBE", "DATETIME", "DCOLON", "DEFINE", "DENSE", "DESC", "DIGIT", "DISTINCT", "DIV", "DOLLAR", "DOLLARVAR", "DOUBLE", "DOUBLENUMBER", "DOUBLE_PERIOD", "ELSE", "END", "EQUAL", "EXECCOMMAND", "FALSE", "FAT_ARROW", "FILTER", "FLATTEN", "FLOAT", "FLOATINGPOINT", "FLOATNUMBER", "FOREACH", "FULL", "GENERATE", "GROUP", "ID", "IDENTIFIER", "IF", "IMPORT", "IN", "INNER", "INPUT", "INT", "INTEGER", "INTO", "INVOKE", "IS", "JOIN", "LEFT", "LEFT_BRACKET", "LEFT_CURLY", "LEFT_PAREN", "LETTER", "LIMIT", "LOAD", "LONG", "LONGINTEGER", "MAP", "MAPREDUCE", "MINUS", "ML_COMMENT", "MULTILINE_QUOTEDSTRING", "NOT", "NULL", "NUM_OP_EQ", "NUM_OP_GT", "NUM_OP_GTE", "NUM_OP_LT", "NUM_OP_LTE", "NUM_OP_NE", "ONSCHEMA", "OR", "ORDER", "OTHERWISE", "OUTER", "OUTPUT", "PARALLEL", "PARTITION", "PERCENT", "PERIOD", "PLUS", "POUND", "QMARK", "QUOTEDSTRING", "RANK", "REGISTER", "RETURNS", "RIGHT", "RIGHT_BRACKET", "RIGHT_CURLY", "RIGHT_PAREN", "ROLLUP", "SAMPLE", "SEMI_COLON", "SHIP", "SL_COMMENT", "SPECIALCHAR", "SPLIT", "STAR", "STDERROR", "STDIN", "STDOUT", "STORE", "STREAM", "STR_OP_EQ", "STR_OP_GT", "STR_OP_GTE", "STR_OP_LT", "STR_OP_LTE", "STR_OP_MATCHES", "STR_OP_NE", "THEN", "THROUGH", "TRUE", "TUPLE", "UNION", "USING", "VOID", "WHEN", "WS", "ANY", "BAG_TYPE", "BAG_TYPE_CAST", "BAG_VAL", "BIN_EXPR", "BOOL", "BOOL_COND", "CASE_COND", "CASE_EXPR", "CASE_EXPR_LHS", "CASE_EXPR_RHS", "CAST_EXPR", "COL_RANGE", "EXPR_IN_PAREN", "FIELD_DEF", "FIELD_DEF_WITHOUT_IDENTIFIER", "FOREACH_PLAN_COMPLEX", "FOREACH_PLAN_SIMPLE", "FUNC", "FUNC_EVAL", "FUNC_REF", "INVOKER_FUNC_EVAL", "IN_LHS", "IN_RHS", "JOIN_ITEM", "KEY_VAL_PAIR", "MACRO_BODY", "MACRO_DEF", "MACRO_INLINE", "MAP_TYPE", "MAP_VAL", "NEG", "NESTED_CMD", "NESTED_CMD_ASSI", "NESTED_PROJ", "PARAMS", "QUERY", "REALIAS", "RETURN_VAL", "SPLIT_BRANCH", "STATEMENT", "TOBAG", "TOMAP", "TOTUPLE", "TUPLE_TYPE", "TUPLE_TYPE_CAST", "TUPLE_VAL", "EVAL", "MATCHES"
    };

    public static final int EOF=-1;
    public static final int ALL=4;
    public static final int AMPERSAND=5;
    public static final int AND=6;
    public static final int ARROBA=7;
    public static final int AS=8;
    public static final int ASC=9;
    public static final int ASSERT=10;
    public static final int BAG=11;
    public static final int BIGDECIMAL=12;
    public static final int BIGDECIMALNUMBER=13;
    public static final int BIGINTEGER=14;
    public static final int BIGINTEGERNUMBER=15;
    public static final int BOOLEAN=16;
    public static final int BY=17;
    public static final int BYTEARRAY=18;
    public static final int CACHE=19;
    public static final int CASE=20;
    public static final int CHARARRAY=21;
    public static final int COGROUP=22;
    public static final int COLON=23;
    public static final int COMMA=24;
    public static final int CROSS=25;
    public static final int CUBE=26;
    public static final int DATETIME=27;
    public static final int DCOLON=28;
    public static final int DEFINE=29;
    public static final int DENSE=30;
    public static final int DESC=31;
    public static final int DIGIT=32;
    public static final int DISTINCT=33;
    public static final int DIV=34;
    public static final int DOLLAR=35;
    public static final int DOLLARVAR=36;
    public static final int DOUBLE=37;
    public static final int DOUBLENUMBER=38;
    public static final int DOUBLE_PERIOD=39;
    public static final int ELSE=40;
    public static final int END=41;
    public static final int EQUAL=42;
    public static final int EXECCOMMAND=43;
    public static final int FALSE=44;
    public static final int FAT_ARROW=45;
    public static final int FILTER=46;
    public static final int FLATTEN=47;
    public static final int FLOAT=48;
    public static final int FLOATINGPOINT=49;
    public static final int FLOATNUMBER=50;
    public static final int FOREACH=51;
    public static final int FULL=52;
    public static final int GENERATE=53;
    public static final int GROUP=54;
    public static final int ID=55;
    public static final int IDENTIFIER=56;
    public static final int IF=57;
    public static final int IMPORT=58;
    public static final int IN=59;
    public static final int INNER=60;
    public static final int INPUT=61;
    public static final int INT=62;
    public static final int INTEGER=63;
    public static final int INTO=64;
    public static final int INVOKE=65;
    public static final int IS=66;
    public static final int JOIN=67;
    public static final int LEFT=68;
    public static final int LEFT_BRACKET=69;
    public static final int LEFT_CURLY=70;
    public static final int LEFT_PAREN=71;
    public static final int LETTER=72;
    public static final int LIMIT=73;
    public static final int LOAD=74;
    public static final int LONG=75;
    public static final int LONGINTEGER=76;
    public static final int MAP=77;
    public static final int MAPREDUCE=78;
    public static final int MINUS=79;
    public static final int ML_COMMENT=80;
    public static final int MULTILINE_QUOTEDSTRING=81;
    public static final int NOT=82;
    public static final int NULL=83;
    public static final int NUM_OP_EQ=84;
    public static final int NUM_OP_GT=85;
    public static final int NUM_OP_GTE=86;
    public static final int NUM_OP_LT=87;
    public static final int NUM_OP_LTE=88;
    public static final int NUM_OP_NE=89;
    public static final int ONSCHEMA=90;
    public static final int OR=91;
    public static final int ORDER=92;
    public static final int OTHERWISE=93;
    public static final int OUTER=94;
    public static final int OUTPUT=95;
    public static final int PARALLEL=96;
    public static final int PARTITION=97;
    public static final int PERCENT=98;
    public static final int PERIOD=99;
    public static final int PLUS=100;
    public static final int POUND=101;
    public static final int QMARK=102;
    public static final int QUOTEDSTRING=103;
    public static final int RANK=104;
    public static final int REGISTER=105;
    public static final int RETURNS=106;
    public static final int RIGHT=107;
    public static final int RIGHT_BRACKET=108;
    public static final int RIGHT_CURLY=109;
    public static final int RIGHT_PAREN=110;
    public static final int ROLLUP=111;
    public static final int SAMPLE=112;
    public static final int SEMI_COLON=113;
    public static final int SHIP=114;
    public static final int SL_COMMENT=115;
    public static final int SPECIALCHAR=116;
    public static final int SPLIT=117;
    public static final int STAR=118;
    public static final int STDERROR=119;
    public static final int STDIN=120;
    public static final int STDOUT=121;
    public static final int STORE=122;
    public static final int STREAM=123;
    public static final int STR_OP_EQ=124;
    public static final int STR_OP_GT=125;
    public static final int STR_OP_GTE=126;
    public static final int STR_OP_LT=127;
    public static final int STR_OP_LTE=128;
    public static final int STR_OP_MATCHES=129;
    public static final int STR_OP_NE=130;
    public static final int THEN=131;
    public static final int THROUGH=132;
    public static final int TRUE=133;
    public static final int TUPLE=134;
    public static final int UNION=135;
    public static final int USING=136;
    public static final int VOID=137;
    public static final int WHEN=138;
    public static final int WS=139;
    public static final int ANY=140;
    public static final int BAG_TYPE=141;
    public static final int BAG_TYPE_CAST=142;
    public static final int BAG_VAL=143;
    public static final int BIN_EXPR=144;
    public static final int BOOL=145;
    public static final int BOOL_COND=146;
    public static final int CASE_COND=147;
    public static final int CASE_EXPR=148;
    public static final int CASE_EXPR_LHS=149;
    public static final int CASE_EXPR_RHS=150;
    public static final int CAST_EXPR=151;
    public static final int COL_RANGE=152;
    public static final int EXPR_IN_PAREN=153;
    public static final int FIELD_DEF=154;
    public static final int FIELD_DEF_WITHOUT_IDENTIFIER=155;
    public static final int FOREACH_PLAN_COMPLEX=156;
    public static final int FOREACH_PLAN_SIMPLE=157;
    public static final int FUNC=158;
    public static final int FUNC_EVAL=159;
    public static final int FUNC_REF=160;
    public static final int INVOKER_FUNC_EVAL=161;
    public static final int IN_LHS=162;
    public static final int IN_RHS=163;
    public static final int JOIN_ITEM=164;
    public static final int KEY_VAL_PAIR=165;
    public static final int MACRO_BODY=166;
    public static final int MACRO_DEF=167;
    public static final int MACRO_INLINE=168;
    public static final int MAP_TYPE=169;
    public static final int MAP_VAL=170;
    public static final int NEG=171;
    public static final int NESTED_CMD=172;
    public static final int NESTED_CMD_ASSI=173;
    public static final int NESTED_PROJ=174;
    public static final int PARAMS=175;
    public static final int QUERY=176;
    public static final int REALIAS=177;
    public static final int RETURN_VAL=178;
    public static final int SPLIT_BRANCH=179;
    public static final int STATEMENT=180;
    public static final int TOBAG=181;
    public static final int TOMAP=182;
    public static final int TOTUPLE=183;
    public static final int TUPLE_TYPE=184;
    public static final int TUPLE_TYPE_CAST=185;
    public static final int TUPLE_VAL=186;
    public static final int EVAL=187;
    public static final int MATCHES=188;

    // delegates
    public TreeParser[] getDelegates() {
        return new TreeParser[] {};
    }

    // delegators


    public AstValidator(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public AstValidator(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return AstValidator.tokenNames; }
    public String getGrammarFileName() { return "/home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g"; }



    private static Log log = LogFactory.getLog( AstValidator.class );

    @Override
    protected Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow)
    throws RecognitionException {
        throw new MismatchedTokenException( ttype, input );
    }

    @Override
    public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow)
    throws RecognitionException {
        throw e;
    }

    private void validateSchemaAliasName(Set<String> fieldNames, CommonTree node, String name)
    throws DuplicatedSchemaAliasException {
        if( fieldNames.contains( name ) ) {
            throw new DuplicatedSchemaAliasException( input,
                new SourceLocation( (PigParserNode)node ), name );
        } else {
            fieldNames.add( name );
        }
    }

    private void validateAliasRef(Set<String> aliases, CommonTree node, String alias)
    throws UndefinedAliasException {
        if( !aliases.contains( alias ) ) {
            throw new UndefinedAliasException( input, new SourceLocation( (PigParserNode)node ), alias );
        }
    }

    private void checkDuplication(int count, CommonTree node) throws ParserValidationException {
        if( count > 1 ) {
            throw new ParserValidationException( input, new SourceLocation( (PigParserNode)node ),
                "Duplicated command option" );
        }
    }

    private String lastRel = null;

    private String getLastRel(CommonTree node) throws UndefinedAliasException {
        if (lastRel != null) {
            return lastRel;
        }
        throw new UndefinedAliasException( input, new SourceLocation((PigParserNode)node), "@");
    }

    private Set<String> aliases = new HashSet<String>() {
        @Override
        public boolean add(String e) {
            lastRel = e;
            return super.add(e);
        }
    };



    public static class query_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "query"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:113:1: query : ^( QUERY ( statement )* ) ;
    public final AstValidator.query_return query() throws RecognitionException {
        AstValidator.query_return retval = new AstValidator.query_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUERY1=null;
        AstValidator.statement_return statement2 =null;


        CommonTree QUERY1_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:113:7: ( ^( QUERY ( statement )* ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:113:9: ^( QUERY ( statement )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            QUERY1=(CommonTree)match(input,QUERY,FOLLOW_QUERY_in_query80); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUERY1_tree = (CommonTree)adaptor.dupNode(QUERY1);


            root_1 = (CommonTree)adaptor.becomeRoot(QUERY1_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:113:18: ( statement )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==ASSERT||LA1_0==REGISTER||LA1_0==SPLIT||LA1_0==REALIAS||LA1_0==STATEMENT) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:113:18: statement
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_statement_in_query82);
                	    statement2=statement();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, statement2.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop1;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "query"


    public static class statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "statement"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:116:1: statement : ( general_statement | split_statement | realias_statement | register_statement | assert_statement );
    public final AstValidator.statement_return statement() throws RecognitionException {
        AstValidator.statement_return retval = new AstValidator.statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.general_statement_return general_statement3 =null;

        AstValidator.split_statement_return split_statement4 =null;

        AstValidator.realias_statement_return realias_statement5 =null;

        AstValidator.register_statement_return register_statement6 =null;

        AstValidator.assert_statement_return assert_statement7 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:116:11: ( general_statement | split_statement | realias_statement | register_statement | assert_statement )
            int alt2=5;
            switch ( input.LA(1) ) {
            case STATEMENT:
                {
                alt2=1;
                }
                break;
            case SPLIT:
                {
                alt2=2;
                }
                break;
            case REALIAS:
                {
                alt2=3;
                }
                break;
            case REGISTER:
                {
                alt2=4;
                }
                break;
            case ASSERT:
                {
                alt2=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:116:13: general_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_general_statement_in_statement94);
                    general_statement3=general_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, general_statement3.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:117:13: split_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_statement_in_statement108);
                    split_statement4=split_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, split_statement4.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:118:13: realias_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_realias_statement_in_statement122);
                    realias_statement5=realias_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, realias_statement5.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:119:13: register_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_register_statement_in_statement136);
                    register_statement6=register_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, register_statement6.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:120:13: assert_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_assert_statement_in_statement150);
                    assert_statement7=assert_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, assert_statement7.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "statement"


    public static class split_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_statement"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:123:1: split_statement : split_clause ;
    public final AstValidator.split_statement_return split_statement() throws RecognitionException {
        AstValidator.split_statement_return retval = new AstValidator.split_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.split_clause_return split_clause8 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:123:17: ( split_clause )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:123:19: split_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_split_clause_in_split_statement159);
            split_clause8=split_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, split_clause8.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "split_statement"


    public static class realias_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "realias_statement"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:126:1: realias_statement : realias_clause ;
    public final AstValidator.realias_statement_return realias_statement() throws RecognitionException {
        AstValidator.realias_statement_return retval = new AstValidator.realias_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.realias_clause_return realias_clause9 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:126:19: ( realias_clause )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:126:21: realias_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_realias_clause_in_realias_statement168);
            realias_clause9=realias_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, realias_clause9.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "realias_statement"


    public static class register_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "register_statement"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:129:1: register_statement : ^( REGISTER QUOTEDSTRING ( USING IDENTIFIER AS IDENTIFIER )? ) ;
    public final AstValidator.register_statement_return register_statement() throws RecognitionException {
        AstValidator.register_statement_return retval = new AstValidator.register_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REGISTER10=null;
        CommonTree QUOTEDSTRING11=null;
        CommonTree USING12=null;
        CommonTree IDENTIFIER13=null;
        CommonTree AS14=null;
        CommonTree IDENTIFIER15=null;

        CommonTree REGISTER10_tree=null;
        CommonTree QUOTEDSTRING11_tree=null;
        CommonTree USING12_tree=null;
        CommonTree IDENTIFIER13_tree=null;
        CommonTree AS14_tree=null;
        CommonTree IDENTIFIER15_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:129:20: ( ^( REGISTER QUOTEDSTRING ( USING IDENTIFIER AS IDENTIFIER )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:129:22: ^( REGISTER QUOTEDSTRING ( USING IDENTIFIER AS IDENTIFIER )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            REGISTER10=(CommonTree)match(input,REGISTER,FOLLOW_REGISTER_in_register_statement179); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REGISTER10_tree = (CommonTree)adaptor.dupNode(REGISTER10);


            root_1 = (CommonTree)adaptor.becomeRoot(REGISTER10_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING11=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_register_statement181); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING11_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING11);


            adaptor.addChild(root_1, QUOTEDSTRING11_tree);
            }


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:129:47: ( USING IDENTIFIER AS IDENTIFIER )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==USING) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:129:48: USING IDENTIFIER AS IDENTIFIER
                    {
                    _last = (CommonTree)input.LT(1);
                    USING12=(CommonTree)match(input,USING,FOLLOW_USING_in_register_statement184); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    USING12_tree = (CommonTree)adaptor.dupNode(USING12);


                    adaptor.addChild(root_1, USING12_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER13=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_register_statement186); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER13_tree = (CommonTree)adaptor.dupNode(IDENTIFIER13);


                    adaptor.addChild(root_1, IDENTIFIER13_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    AS14=(CommonTree)match(input,AS,FOLLOW_AS_in_register_statement188); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AS14_tree = (CommonTree)adaptor.dupNode(AS14);


                    adaptor.addChild(root_1, AS14_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER15=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_register_statement190); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER15_tree = (CommonTree)adaptor.dupNode(IDENTIFIER15);


                    adaptor.addChild(root_1, IDENTIFIER15_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "register_statement"


    public static class assert_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assert_statement"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:132:1: assert_statement : assert_clause ;
    public final AstValidator.assert_statement_return assert_statement() throws RecognitionException {
        AstValidator.assert_statement_return retval = new AstValidator.assert_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.assert_clause_return assert_clause16 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:132:18: ( assert_clause )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:132:20: assert_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_assert_clause_in_assert_statement203);
            assert_clause16=assert_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, assert_clause16.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "assert_statement"


    public static class general_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "general_statement"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:135:1: general_statement : ^( STATEMENT ( alias )? op_clause ( parallel_clause )? ) ;
    public final AstValidator.general_statement_return general_statement() throws RecognitionException {
        AstValidator.general_statement_return retval = new AstValidator.general_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STATEMENT17=null;
        AstValidator.alias_return alias18 =null;

        AstValidator.op_clause_return op_clause19 =null;

        AstValidator.parallel_clause_return parallel_clause20 =null;


        CommonTree STATEMENT17_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:135:19: ( ^( STATEMENT ( alias )? op_clause ( parallel_clause )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:135:21: ^( STATEMENT ( alias )? op_clause ( parallel_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STATEMENT17=(CommonTree)match(input,STATEMENT,FOLLOW_STATEMENT_in_general_statement214); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STATEMENT17_tree = (CommonTree)adaptor.dupNode(STATEMENT17);


            root_1 = (CommonTree)adaptor.becomeRoot(STATEMENT17_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:135:34: ( alias )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==IDENTIFIER) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:135:36: alias
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_general_statement218);
                    alias18=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, alias18.getTree());


                    if ( state.backtracking==0 ) { aliases.add( (alias18!=null?alias18.name:null) ); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_op_clause_in_general_statement225);
            op_clause19=op_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, op_clause19.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:135:87: ( parallel_clause )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==PARALLEL) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:135:87: parallel_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_parallel_clause_in_general_statement227);
                    parallel_clause20=parallel_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, parallel_clause20.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "general_statement"


    public static class realias_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "realias_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:138:1: realias_clause : ^( REALIAS alias IDENTIFIER ) ;
    public final AstValidator.realias_clause_return realias_clause() throws RecognitionException {
        AstValidator.realias_clause_return retval = new AstValidator.realias_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REALIAS21=null;
        CommonTree IDENTIFIER23=null;
        AstValidator.alias_return alias22 =null;


        CommonTree REALIAS21_tree=null;
        CommonTree IDENTIFIER23_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:138:16: ( ^( REALIAS alias IDENTIFIER ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:138:18: ^( REALIAS alias IDENTIFIER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            REALIAS21=(CommonTree)match(input,REALIAS,FOLLOW_REALIAS_in_realias_clause240); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REALIAS21_tree = (CommonTree)adaptor.dupNode(REALIAS21);


            root_1 = (CommonTree)adaptor.becomeRoot(REALIAS21_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_realias_clause242);
            alias22=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias22.getTree());


            _last = (CommonTree)input.LT(1);
            IDENTIFIER23=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_realias_clause244); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER23_tree = (CommonTree)adaptor.dupNode(IDENTIFIER23);


            adaptor.addChild(root_1, IDENTIFIER23_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   aliases.add( (alias22!=null?alias22.name:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "realias_clause"


    public static class parallel_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parallel_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:144:1: parallel_clause : ^( PARALLEL INTEGER ) ;
    public final AstValidator.parallel_clause_return parallel_clause() throws RecognitionException {
        AstValidator.parallel_clause_return retval = new AstValidator.parallel_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARALLEL24=null;
        CommonTree INTEGER25=null;

        CommonTree PARALLEL24_tree=null;
        CommonTree INTEGER25_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:144:17: ( ^( PARALLEL INTEGER ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:144:19: ^( PARALLEL INTEGER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARALLEL24=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_parallel_clause261); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARALLEL24_tree = (CommonTree)adaptor.dupNode(PARALLEL24);


            root_1 = (CommonTree)adaptor.becomeRoot(PARALLEL24_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            INTEGER25=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_parallel_clause263); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER25_tree = (CommonTree)adaptor.dupNode(INTEGER25);


            adaptor.addChild(root_1, INTEGER25_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "parallel_clause"


    public static class alias_return extends TreeRuleReturnScope {
        public String name;
        public CommonTree node;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alias"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:147:1: alias returns [String name, CommonTree node] : IDENTIFIER ;
    public final AstValidator.alias_return alias() throws RecognitionException {
        AstValidator.alias_return retval = new AstValidator.alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDENTIFIER26=null;

        CommonTree IDENTIFIER26_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:148:2: ( IDENTIFIER )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:148:4: IDENTIFIER
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            IDENTIFIER26=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias278); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER26_tree = (CommonTree)adaptor.dupNode(IDENTIFIER26);


            adaptor.addChild(root_0, IDENTIFIER26_tree);
            }


            if ( state.backtracking==0 ) {
                   retval.name = (IDENTIFIER26!=null?IDENTIFIER26.getText():null);
                   retval.node = IDENTIFIER26;
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "alias"


    public static class previous_rel_return extends TreeRuleReturnScope {
        public String name;
        public CommonTree node;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "previous_rel"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:155:1: previous_rel returns [String name, CommonTree node] : ARROBA ;
    public final AstValidator.previous_rel_return previous_rel() throws RecognitionException {
        AstValidator.previous_rel_return retval = new AstValidator.previous_rel_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ARROBA27=null;

        CommonTree ARROBA27_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:156:2: ( ARROBA )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:156:4: ARROBA
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            ARROBA27=(CommonTree)match(input,ARROBA,FOLLOW_ARROBA_in_previous_rel296); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ARROBA27_tree = (CommonTree)adaptor.dupNode(ARROBA27);


            adaptor.addChild(root_0, ARROBA27_tree);
            }


            if ( state.backtracking==0 ) {
                   retval.name = getLastRel(ARROBA27);
                   retval.node = ARROBA27;
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "previous_rel"


    public static class op_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "op_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:163:1: op_clause : ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | split_clause | foreach_clause | cube_clause | assert_clause );
    public final AstValidator.op_clause_return op_clause() throws RecognitionException {
        AstValidator.op_clause_return retval = new AstValidator.op_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.define_clause_return define_clause28 =null;

        AstValidator.load_clause_return load_clause29 =null;

        AstValidator.group_clause_return group_clause30 =null;

        AstValidator.store_clause_return store_clause31 =null;

        AstValidator.filter_clause_return filter_clause32 =null;

        AstValidator.distinct_clause_return distinct_clause33 =null;

        AstValidator.limit_clause_return limit_clause34 =null;

        AstValidator.sample_clause_return sample_clause35 =null;

        AstValidator.order_clause_return order_clause36 =null;

        AstValidator.rank_clause_return rank_clause37 =null;

        AstValidator.cross_clause_return cross_clause38 =null;

        AstValidator.join_clause_return join_clause39 =null;

        AstValidator.union_clause_return union_clause40 =null;

        AstValidator.stream_clause_return stream_clause41 =null;

        AstValidator.mr_clause_return mr_clause42 =null;

        AstValidator.split_clause_return split_clause43 =null;

        AstValidator.foreach_clause_return foreach_clause44 =null;

        AstValidator.cube_clause_return cube_clause45 =null;

        AstValidator.assert_clause_return assert_clause46 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:163:11: ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | split_clause | foreach_clause | cube_clause | assert_clause )
            int alt6=19;
            switch ( input.LA(1) ) {
            case DEFINE:
                {
                alt6=1;
                }
                break;
            case LOAD:
                {
                alt6=2;
                }
                break;
            case COGROUP:
            case GROUP:
                {
                alt6=3;
                }
                break;
            case STORE:
                {
                alt6=4;
                }
                break;
            case FILTER:
                {
                alt6=5;
                }
                break;
            case DISTINCT:
                {
                alt6=6;
                }
                break;
            case LIMIT:
                {
                alt6=7;
                }
                break;
            case SAMPLE:
                {
                alt6=8;
                }
                break;
            case ORDER:
                {
                alt6=9;
                }
                break;
            case RANK:
                {
                alt6=10;
                }
                break;
            case CROSS:
                {
                alt6=11;
                }
                break;
            case JOIN:
                {
                alt6=12;
                }
                break;
            case UNION:
                {
                alt6=13;
                }
                break;
            case STREAM:
                {
                alt6=14;
                }
                break;
            case MAPREDUCE:
                {
                alt6=15;
                }
                break;
            case SPLIT:
                {
                alt6=16;
                }
                break;
            case FOREACH:
                {
                alt6=17;
                }
                break;
            case CUBE:
                {
                alt6=18;
                }
                break;
            case ASSERT:
                {
                alt6=19;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }

            switch (alt6) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:163:13: define_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_define_clause_in_op_clause310);
                    define_clause28=define_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, define_clause28.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:164:13: load_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_load_clause_in_op_clause324);
                    load_clause29=load_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, load_clause29.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:165:13: group_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_clause_in_op_clause338);
                    group_clause30=group_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, group_clause30.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:166:13: store_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_store_clause_in_op_clause352);
                    store_clause31=store_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, store_clause31.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:167:13: filter_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_filter_clause_in_op_clause366);
                    filter_clause32=filter_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, filter_clause32.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:168:13: distinct_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_distinct_clause_in_op_clause380);
                    distinct_clause33=distinct_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, distinct_clause33.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:169:13: limit_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_limit_clause_in_op_clause394);
                    limit_clause34=limit_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, limit_clause34.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:170:13: sample_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_sample_clause_in_op_clause408);
                    sample_clause35=sample_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, sample_clause35.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:171:13: order_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_order_clause_in_op_clause422);
                    order_clause36=order_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, order_clause36.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:172:13: rank_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_clause_in_op_clause436);
                    rank_clause37=rank_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rank_clause37.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:173:13: cross_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cross_clause_in_op_clause450);
                    cross_clause38=cross_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cross_clause38.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:174:13: join_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_clause_in_op_clause464);
                    join_clause39=join_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_clause39.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:175:13: union_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_union_clause_in_op_clause478);
                    union_clause40=union_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, union_clause40.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:176:13: stream_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_stream_clause_in_op_clause492);
                    stream_clause41=stream_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, stream_clause41.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:177:13: mr_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_mr_clause_in_op_clause506);
                    mr_clause42=mr_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, mr_clause42.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:178:13: split_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_clause_in_op_clause520);
                    split_clause43=split_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, split_clause43.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:179:13: foreach_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_foreach_clause_in_op_clause534);
                    foreach_clause44=foreach_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, foreach_clause44.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:180:13: cube_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cube_clause_in_op_clause548);
                    cube_clause45=cube_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cube_clause45.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 19 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:181:13: assert_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_assert_clause_in_op_clause562);
                    assert_clause46=assert_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, assert_clause46.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "op_clause"


    public static class define_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "define_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:184:1: define_clause : ^( DEFINE alias ( cmd | func_clause ) ) ;
    public final AstValidator.define_clause_return define_clause() throws RecognitionException {
        AstValidator.define_clause_return retval = new AstValidator.define_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DEFINE47=null;
        AstValidator.alias_return alias48 =null;

        AstValidator.cmd_return cmd49 =null;

        AstValidator.func_clause_return func_clause50 =null;


        CommonTree DEFINE47_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:184:15: ( ^( DEFINE alias ( cmd | func_clause ) ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:184:17: ^( DEFINE alias ( cmd | func_clause ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DEFINE47=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_define_clause573); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DEFINE47_tree = (CommonTree)adaptor.dupNode(DEFINE47);


            root_1 = (CommonTree)adaptor.becomeRoot(DEFINE47_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_define_clause575);
            alias48=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias48.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:184:33: ( cmd | func_clause )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==EXECCOMMAND) ) {
                alt7=1;
            }
            else if ( (LA7_0==FUNC||LA7_0==FUNC_REF) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }
            switch (alt7) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:184:35: cmd
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cmd_in_define_clause579);
                    cmd49=cmd();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cmd49.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:184:41: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_define_clause583);
                    func_clause50=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause50.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "define_clause"


    public static class cmd_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cmd"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:187:1: cmd : ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* ) ;
    public final AstValidator.cmd_return cmd() throws RecognitionException {
        AstValidator.cmd_return retval = new AstValidator.cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree EXECCOMMAND51=null;
        AstValidator.ship_clause_return ship_clause52 =null;

        AstValidator.cache_clause_return cache_clause53 =null;

        AstValidator.input_clause_return input_clause54 =null;

        AstValidator.output_clause_return output_clause55 =null;

        AstValidator.error_clause_return error_clause56 =null;


        CommonTree EXECCOMMAND51_tree=null;


            int ship = 0;
            int cache = 0;
            int in = 0;
            int out = 0;
            int error = 0;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:195:2: ( ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:195:4: ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            EXECCOMMAND51=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_cmd604); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EXECCOMMAND51_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND51);


            root_1 = (CommonTree)adaptor.becomeRoot(EXECCOMMAND51_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:195:19: ( ship_clause | cache_clause | input_clause | output_clause | error_clause )*
                loop8:
                do {
                    int alt8=6;
                    switch ( input.LA(1) ) {
                    case SHIP:
                        {
                        alt8=1;
                        }
                        break;
                    case CACHE:
                        {
                        alt8=2;
                        }
                        break;
                    case INPUT:
                        {
                        alt8=3;
                        }
                        break;
                    case OUTPUT:
                        {
                        alt8=4;
                        }
                        break;
                    case STDERROR:
                        {
                        alt8=5;
                        }
                        break;

                    }

                    switch (alt8) {
                	case 1 :
                	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:195:21: ship_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_ship_clause_in_cmd608);
                	    ship_clause52=ship_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, ship_clause52.getTree());


                	    if ( state.backtracking==0 ) { checkDuplication( ++ship, (ship_clause52!=null?((CommonTree)ship_clause52.start):null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 2 :
                	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:196:21: cache_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_cache_clause_in_cmd632);
                	    cache_clause53=cache_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, cache_clause53.getTree());


                	    if ( state.backtracking==0 ) { checkDuplication( ++cache, (cache_clause53!=null?((CommonTree)cache_clause53.start):null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 3 :
                	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:197:21: input_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_input_clause_in_cmd656);
                	    input_clause54=input_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, input_clause54.getTree());


                	    if ( state.backtracking==0 ) { checkDuplication( ++in, (input_clause54!=null?((CommonTree)input_clause54.start):null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 4 :
                	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:198:21: output_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_output_clause_in_cmd680);
                	    output_clause55=output_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, output_clause55.getTree());


                	    if ( state.backtracking==0 ) { checkDuplication( ++out, (output_clause55!=null?((CommonTree)output_clause55.start):null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 5 :
                	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:199:21: error_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_error_clause_in_cmd704);
                	    error_clause56=error_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, error_clause56.getTree());


                	    if ( state.backtracking==0 ) { checkDuplication( ++error, (error_clause56!=null?((CommonTree)error_clause56.start):null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop8;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cmd"


    public static class ship_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ship_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:204:1: ship_clause : ^( SHIP ( path_list )? ) ;
    public final AstValidator.ship_clause_return ship_clause() throws RecognitionException {
        AstValidator.ship_clause_return retval = new AstValidator.ship_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SHIP57=null;
        AstValidator.path_list_return path_list58 =null;


        CommonTree SHIP57_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:204:13: ( ^( SHIP ( path_list )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:204:15: ^( SHIP ( path_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SHIP57=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_ship_clause743); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHIP57_tree = (CommonTree)adaptor.dupNode(SHIP57);


            root_1 = (CommonTree)adaptor.becomeRoot(SHIP57_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:204:23: ( path_list )?
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==QUOTEDSTRING) ) {
                    alt9=1;
                }
                switch (alt9) {
                    case 1 :
                        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:204:23: path_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_path_list_in_ship_clause745);
                        path_list58=path_list();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, path_list58.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ship_clause"


    public static class path_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "path_list"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:207:1: path_list : ( QUOTEDSTRING )+ ;
    public final AstValidator.path_list_return path_list() throws RecognitionException {
        AstValidator.path_list_return retval = new AstValidator.path_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING59=null;

        CommonTree QUOTEDSTRING59_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:207:11: ( ( QUOTEDSTRING )+ )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:207:13: ( QUOTEDSTRING )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:207:13: ( QUOTEDSTRING )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==QUOTEDSTRING) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:207:13: QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    QUOTEDSTRING59=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_path_list757); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    QUOTEDSTRING59_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING59);


            	    adaptor.addChild(root_0, QUOTEDSTRING59_tree);
            	    }


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "path_list"


    public static class cache_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cache_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:210:1: cache_clause : ^( CACHE path_list ) ;
    public final AstValidator.cache_clause_return cache_clause() throws RecognitionException {
        AstValidator.cache_clause_return retval = new AstValidator.cache_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CACHE60=null;
        AstValidator.path_list_return path_list61 =null;


        CommonTree CACHE60_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:210:14: ( ^( CACHE path_list ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:210:16: ^( CACHE path_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CACHE60=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_cache_clause769); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CACHE60_tree = (CommonTree)adaptor.dupNode(CACHE60);


            root_1 = (CommonTree)adaptor.becomeRoot(CACHE60_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_path_list_in_cache_clause771);
            path_list61=path_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, path_list61.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cache_clause"


    public static class input_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "input_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:213:1: input_clause : ^( INPUT ( stream_cmd )+ ) ;
    public final AstValidator.input_clause_return input_clause() throws RecognitionException {
        AstValidator.input_clause_return retval = new AstValidator.input_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INPUT62=null;
        AstValidator.stream_cmd_return stream_cmd63 =null;


        CommonTree INPUT62_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:213:14: ( ^( INPUT ( stream_cmd )+ ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:213:16: ^( INPUT ( stream_cmd )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            INPUT62=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_input_clause784); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INPUT62_tree = (CommonTree)adaptor.dupNode(INPUT62);


            root_1 = (CommonTree)adaptor.becomeRoot(INPUT62_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:213:25: ( stream_cmd )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==QUOTEDSTRING||(LA11_0 >= STDIN && LA11_0 <= STDOUT)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:213:25: stream_cmd
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_input_clause786);
            	    stream_cmd63=stream_cmd();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd63.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "input_clause"


    public static class stream_cmd_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stream_cmd"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:216:1: stream_cmd : ( ^( STDIN ( func_clause )? ) | ^( STDOUT ( func_clause )? ) | ^( QUOTEDSTRING ( func_clause )? ) );
    public final AstValidator.stream_cmd_return stream_cmd() throws RecognitionException {
        AstValidator.stream_cmd_return retval = new AstValidator.stream_cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDIN64=null;
        CommonTree STDOUT66=null;
        CommonTree QUOTEDSTRING68=null;
        AstValidator.func_clause_return func_clause65 =null;

        AstValidator.func_clause_return func_clause67 =null;

        AstValidator.func_clause_return func_clause69 =null;


        CommonTree STDIN64_tree=null;
        CommonTree STDOUT66_tree=null;
        CommonTree QUOTEDSTRING68_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:216:12: ( ^( STDIN ( func_clause )? ) | ^( STDOUT ( func_clause )? ) | ^( QUOTEDSTRING ( func_clause )? ) )
            int alt15=3;
            switch ( input.LA(1) ) {
            case STDIN:
                {
                alt15=1;
                }
                break;
            case STDOUT:
                {
                alt15=2;
                }
                break;
            case QUOTEDSTRING:
                {
                alt15=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }

            switch (alt15) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:216:14: ^( STDIN ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDIN64=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_stream_cmd800); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN64_tree = (CommonTree)adaptor.dupNode(STDIN64);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDIN64_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:216:23: ( func_clause )?
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==FUNC||LA12_0==FUNC_REF) ) {
                            alt12=1;
                        }
                        switch (alt12) {
                            case 1 :
                                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:216:23: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd802);
                                func_clause65=func_clause();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause65.getTree());


                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        match(input, Token.UP, null); if (state.failed) return retval;
                    }
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:217:14: ^( STDOUT ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDOUT66=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_stream_cmd822); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT66_tree = (CommonTree)adaptor.dupNode(STDOUT66);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDOUT66_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:217:24: ( func_clause )?
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==FUNC||LA13_0==FUNC_REF) ) {
                            alt13=1;
                        }
                        switch (alt13) {
                            case 1 :
                                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:217:24: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd824);
                                func_clause67=func_clause();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause67.getTree());


                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        match(input, Token.UP, null); if (state.failed) return retval;
                    }
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:218:14: ^( QUOTEDSTRING ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING68=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_stream_cmd844); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING68_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING68);


                    root_1 = (CommonTree)adaptor.becomeRoot(QUOTEDSTRING68_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:218:30: ( func_clause )?
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==FUNC||LA14_0==FUNC_REF) ) {
                            alt14=1;
                        }
                        switch (alt14) {
                            case 1 :
                                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:218:30: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd846);
                                func_clause69=func_clause();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause69.getTree());


                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        match(input, Token.UP, null); if (state.failed) return retval;
                    }
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "stream_cmd"


    public static class output_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "output_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:221:1: output_clause : ^( OUTPUT ( stream_cmd )+ ) ;
    public final AstValidator.output_clause_return output_clause() throws RecognitionException {
        AstValidator.output_clause_return retval = new AstValidator.output_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OUTPUT70=null;
        AstValidator.stream_cmd_return stream_cmd71 =null;


        CommonTree OUTPUT70_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:221:15: ( ^( OUTPUT ( stream_cmd )+ ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:221:17: ^( OUTPUT ( stream_cmd )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OUTPUT70=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_output_clause860); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OUTPUT70_tree = (CommonTree)adaptor.dupNode(OUTPUT70);


            root_1 = (CommonTree)adaptor.becomeRoot(OUTPUT70_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:221:27: ( stream_cmd )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==QUOTEDSTRING||(LA16_0 >= STDIN && LA16_0 <= STDOUT)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:221:27: stream_cmd
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_output_clause862);
            	    stream_cmd71=stream_cmd();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd71.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "output_clause"


    public static class error_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "error_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:224:1: error_clause : ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) ;
    public final AstValidator.error_clause_return error_clause() throws RecognitionException {
        AstValidator.error_clause_return retval = new AstValidator.error_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDERROR72=null;
        CommonTree QUOTEDSTRING73=null;
        CommonTree INTEGER74=null;

        CommonTree STDERROR72_tree=null;
        CommonTree QUOTEDSTRING73_tree=null;
        CommonTree INTEGER74_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:224:14: ( ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:224:16: ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STDERROR72=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_error_clause876); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STDERROR72_tree = (CommonTree)adaptor.dupNode(STDERROR72);


            root_1 = (CommonTree)adaptor.becomeRoot(STDERROR72_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:224:29: ( QUOTEDSTRING ( INTEGER )? )?
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==QUOTEDSTRING) ) {
                    alt18=1;
                }
                switch (alt18) {
                    case 1 :
                        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:224:31: QUOTEDSTRING ( INTEGER )?
                        {
                        _last = (CommonTree)input.LT(1);
                        QUOTEDSTRING73=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_error_clause881); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        QUOTEDSTRING73_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING73);


                        adaptor.addChild(root_1, QUOTEDSTRING73_tree);
                        }


                        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:224:44: ( INTEGER )?
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==INTEGER) ) {
                            alt17=1;
                        }
                        switch (alt17) {
                            case 1 :
                                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:224:44: INTEGER
                                {
                                _last = (CommonTree)input.LT(1);
                                INTEGER74=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_error_clause883); if (state.failed) return retval;
                                if ( state.backtracking==0 ) {
                                INTEGER74_tree = (CommonTree)adaptor.dupNode(INTEGER74);


                                adaptor.addChild(root_1, INTEGER74_tree);
                                }


                                if ( state.backtracking==0 ) {
                                }
                                }
                                break;

                        }


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "error_clause"


    public static class load_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "load_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:227:1: load_clause : ^( LOAD filename ( func_clause )? ( as_clause )? ) ;
    public final AstValidator.load_clause_return load_clause() throws RecognitionException {
        AstValidator.load_clause_return retval = new AstValidator.load_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LOAD75=null;
        AstValidator.filename_return filename76 =null;

        AstValidator.func_clause_return func_clause77 =null;

        AstValidator.as_clause_return as_clause78 =null;


        CommonTree LOAD75_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:227:13: ( ^( LOAD filename ( func_clause )? ( as_clause )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:227:15: ^( LOAD filename ( func_clause )? ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LOAD75=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_load_clause900); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LOAD75_tree = (CommonTree)adaptor.dupNode(LOAD75);


            root_1 = (CommonTree)adaptor.becomeRoot(LOAD75_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_load_clause902);
            filename76=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename76.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:227:32: ( func_clause )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==FUNC||LA19_0==FUNC_REF) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:227:32: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_load_clause904);
                    func_clause77=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause77.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:227:45: ( as_clause )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==AS) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:227:45: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_load_clause907);
                    as_clause78=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause78.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "load_clause"


    public static class filename_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "filename"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:230:1: filename : QUOTEDSTRING ;
    public final AstValidator.filename_return filename() throws RecognitionException {
        AstValidator.filename_return retval = new AstValidator.filename_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING79=null;

        CommonTree QUOTEDSTRING79_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:230:10: ( QUOTEDSTRING )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:230:12: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING79=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_filename919); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING79_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING79);


            adaptor.addChild(root_0, QUOTEDSTRING79_tree);
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "filename"


    public static class as_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "as_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:233:1: as_clause : ^( AS field_def_list ) ;
    public final AstValidator.as_clause_return as_clause() throws RecognitionException {
        AstValidator.as_clause_return retval = new AstValidator.as_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AS80=null;
        AstValidator.field_def_list_return field_def_list81 =null;


        CommonTree AS80_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:233:10: ( ^( AS field_def_list ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:233:12: ^( AS field_def_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            AS80=(CommonTree)match(input,AS,FOLLOW_AS_in_as_clause929); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            AS80_tree = (CommonTree)adaptor.dupNode(AS80);


            root_1 = (CommonTree)adaptor.becomeRoot(AS80_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_field_def_list_in_as_clause931);
            field_def_list81=field_def_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, field_def_list81.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "as_clause"


    public static class field_def_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field_def"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:236:1: field_def[Set<String> fieldNames, NumValCarrier nvc] : ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF_WITHOUT_IDENTIFIER type ) );
    public final AstValidator.field_def_return field_def(Set<String> fieldNames, NumValCarrier nvc) throws RecognitionException, DuplicatedSchemaAliasException {
        AstValidator.field_def_return retval = new AstValidator.field_def_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FIELD_DEF82=null;
        CommonTree IDENTIFIER83=null;
        CommonTree FIELD_DEF_WITHOUT_IDENTIFIER85=null;
        AstValidator.type_return type84 =null;

        AstValidator.type_return type86 =null;


        CommonTree FIELD_DEF82_tree=null;
        CommonTree IDENTIFIER83_tree=null;
        CommonTree FIELD_DEF_WITHOUT_IDENTIFIER85_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:237:2: ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF_WITHOUT_IDENTIFIER type ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==FIELD_DEF) ) {
                alt22=1;
            }
            else if ( (LA22_0==FIELD_DEF_WITHOUT_IDENTIFIER) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }
            switch (alt22) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:237:4: ^( FIELD_DEF IDENTIFIER ( type )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF82=(CommonTree)match(input,FIELD_DEF,FOLLOW_FIELD_DEF_in_field_def950); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF82_tree = (CommonTree)adaptor.dupNode(FIELD_DEF82);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF82_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER83=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_field_def952); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER83_tree = (CommonTree)adaptor.dupNode(IDENTIFIER83);


                    adaptor.addChild(root_1, IDENTIFIER83_tree);
                    }


                    if ( state.backtracking==0 ) { validateSchemaAliasName( fieldNames, IDENTIFIER83, (IDENTIFIER83!=null?IDENTIFIER83.getText():null) ); }

                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:237:102: ( type )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==BIGDECIMAL||LA21_0==BIGINTEGER||LA21_0==BOOLEAN||LA21_0==BYTEARRAY||LA21_0==CHARARRAY||LA21_0==DATETIME||LA21_0==DOUBLE||LA21_0==FLOAT||LA21_0==INT||LA21_0==LONG||LA21_0==BAG_TYPE||LA21_0==MAP_TYPE||LA21_0==TUPLE_TYPE) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:237:102: type
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_type_in_field_def956);
                            type84=type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, type84.getTree());


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:238:4: ^( FIELD_DEF_WITHOUT_IDENTIFIER type )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF_WITHOUT_IDENTIFIER85=(CommonTree)match(input,FIELD_DEF_WITHOUT_IDENTIFIER,FOLLOW_FIELD_DEF_WITHOUT_IDENTIFIER_in_field_def966); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF_WITHOUT_IDENTIFIER85_tree = (CommonTree)adaptor.dupNode(FIELD_DEF_WITHOUT_IDENTIFIER85);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF_WITHOUT_IDENTIFIER85_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_field_def968);
                    type86=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type86.getTree());


                    if ( state.backtracking==0 ) { validateSchemaAliasName ( fieldNames, FIELD_DEF_WITHOUT_IDENTIFIER85, nvc.makeNameFromDataType ( (type86!=null?type86.typev:0) ) ); }

                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "field_def"


    protected static class field_def_list_scope {
        Set<String> fieldNames;
        NumValCarrier nvc;
    }
    protected Stack field_def_list_stack = new Stack();


    public static class field_def_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field_def_list"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:241:1: field_def_list : ( field_def[$field_def_list::fieldNames, $field_def_list::nvc] )+ ;
    public final AstValidator.field_def_list_return field_def_list() throws RecognitionException, DuplicatedSchemaAliasException {
        field_def_list_stack.push(new field_def_list_scope());
        AstValidator.field_def_list_return retval = new AstValidator.field_def_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.field_def_return field_def87 =null;




            ((field_def_list_scope)field_def_list_stack.peek()).fieldNames = new HashSet<String>();
            ((field_def_list_scope)field_def_list_stack.peek()).nvc = new NumValCarrier();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:250:2: ( ( field_def[$field_def_list::fieldNames, $field_def_list::nvc] )+ )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:250:4: ( field_def[$field_def_list::fieldNames, $field_def_list::nvc] )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:250:4: ( field_def[$field_def_list::fieldNames, $field_def_list::nvc] )+
            int cnt23=0;
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0 >= FIELD_DEF && LA23_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:250:6: field_def[$field_def_list::fieldNames, $field_def_list::nvc]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_field_def_in_field_def_list996);
            	    field_def87=field_def(((field_def_list_scope)field_def_list_stack.peek()).fieldNames, ((field_def_list_scope)field_def_list_stack.peek()).nvc);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, field_def87.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt23 >= 1 ) break loop23;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(23, input);
                        throw eee;
                }
                cnt23++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            field_def_list_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "field_def_list"


    public static class type_return extends TreeRuleReturnScope {
        public byte typev;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:253:1: type returns [byte typev] : ( simple_type | tuple_type | bag_type | map_type );
    public final AstValidator.type_return type() throws RecognitionException {
        AstValidator.type_return retval = new AstValidator.type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.simple_type_return simple_type88 =null;

        AstValidator.tuple_type_return tuple_type89 =null;

        AstValidator.bag_type_return bag_type90 =null;

        AstValidator.map_type_return map_type91 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:254:3: ( simple_type | tuple_type | bag_type | map_type )
            int alt24=4;
            switch ( input.LA(1) ) {
            case BIGDECIMAL:
            case BIGINTEGER:
            case BOOLEAN:
            case BYTEARRAY:
            case CHARARRAY:
            case DATETIME:
            case DOUBLE:
            case FLOAT:
            case INT:
            case LONG:
                {
                alt24=1;
                }
                break;
            case TUPLE_TYPE:
                {
                alt24=2;
                }
                break;
            case BAG_TYPE:
                {
                alt24=3;
                }
                break;
            case MAP_TYPE:
                {
                alt24=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;

            }

            switch (alt24) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:254:5: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type1015);
                    simple_type88=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type88.getTree());


                    if ( state.backtracking==0 ) { retval.typev = (simple_type88!=null?simple_type88.typev:0); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:255:5: tuple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_in_type1023);
                    tuple_type89=tuple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type89.getTree());


                    if ( state.backtracking==0 ) { retval.typev = DataType.TUPLE; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:256:5: bag_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_in_type1031);
                    bag_type90=bag_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type90.getTree());


                    if ( state.backtracking==0 ) { retval.typev = DataType.BAG; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:257:5: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type1039);
                    map_type91=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type91.getTree());


                    if ( state.backtracking==0 ) { retval.typev = DataType.MAP; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "type"


    public static class simple_type_return extends TreeRuleReturnScope {
        public byte typev;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "simple_type"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:260:1: simple_type returns [byte typev] : ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY );
    public final AstValidator.simple_type_return simple_type() throws RecognitionException {
        AstValidator.simple_type_return retval = new AstValidator.simple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BOOLEAN92=null;
        CommonTree INT93=null;
        CommonTree LONG94=null;
        CommonTree FLOAT95=null;
        CommonTree DOUBLE96=null;
        CommonTree BIGINTEGER97=null;
        CommonTree BIGDECIMAL98=null;
        CommonTree DATETIME99=null;
        CommonTree CHARARRAY100=null;
        CommonTree BYTEARRAY101=null;

        CommonTree BOOLEAN92_tree=null;
        CommonTree INT93_tree=null;
        CommonTree LONG94_tree=null;
        CommonTree FLOAT95_tree=null;
        CommonTree DOUBLE96_tree=null;
        CommonTree BIGINTEGER97_tree=null;
        CommonTree BIGDECIMAL98_tree=null;
        CommonTree DATETIME99_tree=null;
        CommonTree CHARARRAY100_tree=null;
        CommonTree BYTEARRAY101_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:261:3: ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY )
            int alt25=10;
            switch ( input.LA(1) ) {
            case BOOLEAN:
                {
                alt25=1;
                }
                break;
            case INT:
                {
                alt25=2;
                }
                break;
            case LONG:
                {
                alt25=3;
                }
                break;
            case FLOAT:
                {
                alt25=4;
                }
                break;
            case DOUBLE:
                {
                alt25=5;
                }
                break;
            case BIGINTEGER:
                {
                alt25=6;
                }
                break;
            case BIGDECIMAL:
                {
                alt25=7;
                }
                break;
            case DATETIME:
                {
                alt25=8;
                }
                break;
            case CHARARRAY:
                {
                alt25=9;
                }
                break;
            case BYTEARRAY:
                {
                alt25=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;

            }

            switch (alt25) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:261:5: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN92=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_simple_type1056); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN92_tree = (CommonTree)adaptor.dupNode(BOOLEAN92);


                    adaptor.addChild(root_0, BOOLEAN92_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.BOOLEAN; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:262:5: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT93=(CommonTree)match(input,INT,FOLLOW_INT_in_simple_type1064); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT93_tree = (CommonTree)adaptor.dupNode(INT93);


                    adaptor.addChild(root_0, INT93_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.INTEGER; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:263:5: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG94=(CommonTree)match(input,LONG,FOLLOW_LONG_in_simple_type1072); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG94_tree = (CommonTree)adaptor.dupNode(LONG94);


                    adaptor.addChild(root_0, LONG94_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.LONG; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:264:5: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT95=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_simple_type1080); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT95_tree = (CommonTree)adaptor.dupNode(FLOAT95);


                    adaptor.addChild(root_0, FLOAT95_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.FLOAT; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:265:5: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE96=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_simple_type1088); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE96_tree = (CommonTree)adaptor.dupNode(DOUBLE96);


                    adaptor.addChild(root_0, DOUBLE96_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.DOUBLE; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:266:5: BIGINTEGER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGINTEGER97=(CommonTree)match(input,BIGINTEGER,FOLLOW_BIGINTEGER_in_simple_type1096); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGINTEGER97_tree = (CommonTree)adaptor.dupNode(BIGINTEGER97);


                    adaptor.addChild(root_0, BIGINTEGER97_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.BIGINTEGER; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:267:5: BIGDECIMAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGDECIMAL98=(CommonTree)match(input,BIGDECIMAL,FOLLOW_BIGDECIMAL_in_simple_type1104); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGDECIMAL98_tree = (CommonTree)adaptor.dupNode(BIGDECIMAL98);


                    adaptor.addChild(root_0, BIGDECIMAL98_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.BIGDECIMAL; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:268:5: DATETIME
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DATETIME99=(CommonTree)match(input,DATETIME,FOLLOW_DATETIME_in_simple_type1112); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DATETIME99_tree = (CommonTree)adaptor.dupNode(DATETIME99);


                    adaptor.addChild(root_0, DATETIME99_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.DATETIME; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:269:5: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY100=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_simple_type1120); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY100_tree = (CommonTree)adaptor.dupNode(CHARARRAY100);


                    adaptor.addChild(root_0, CHARARRAY100_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.CHARARRAY; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:270:5: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY101=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_simple_type1128); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY101_tree = (CommonTree)adaptor.dupNode(BYTEARRAY101);


                    adaptor.addChild(root_0, BYTEARRAY101_tree);
                    }


                    if ( state.backtracking==0 ) { retval.typev = DataType.BYTEARRAY; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "simple_type"


    public static class tuple_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple_type"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:273:1: tuple_type : ^( TUPLE_TYPE ( field_def_list )? ) ;
    public final AstValidator.tuple_type_return tuple_type() throws RecognitionException {
        AstValidator.tuple_type_return retval = new AstValidator.tuple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE102=null;
        AstValidator.field_def_list_return field_def_list103 =null;


        CommonTree TUPLE_TYPE102_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:273:12: ( ^( TUPLE_TYPE ( field_def_list )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:273:14: ^( TUPLE_TYPE ( field_def_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE102=(CommonTree)match(input,TUPLE_TYPE,FOLLOW_TUPLE_TYPE_in_tuple_type1141); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE102_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE102);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE102_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:273:28: ( field_def_list )?
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0 >= FIELD_DEF && LA26_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                    alt26=1;
                }
                switch (alt26) {
                    case 1 :
                        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:273:28: field_def_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_field_def_list_in_tuple_type1143);
                        field_def_list103=field_def_list();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, field_def_list103.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tuple_type"


    public static class bag_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag_type"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:276:1: bag_type : ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) ;
    public final AstValidator.bag_type_return bag_type() throws RecognitionException {
        AstValidator.bag_type_return retval = new AstValidator.bag_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE104=null;
        CommonTree IDENTIFIER105=null;
        AstValidator.tuple_type_return tuple_type106 =null;


        CommonTree BAG_TYPE104_tree=null;
        CommonTree IDENTIFIER105_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:276:10: ( ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:276:12: ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE104=(CommonTree)match(input,BAG_TYPE,FOLLOW_BAG_TYPE_in_bag_type1157); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE104_tree = (CommonTree)adaptor.dupNode(BAG_TYPE104);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE104_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:276:24: ( IDENTIFIER )?
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==IDENTIFIER) ) {
                    alt27=1;
                }
                switch (alt27) {
                    case 1 :
                        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:276:24: IDENTIFIER
                        {
                        _last = (CommonTree)input.LT(1);
                        IDENTIFIER105=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_bag_type1159); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        IDENTIFIER105_tree = (CommonTree)adaptor.dupNode(IDENTIFIER105);


                        adaptor.addChild(root_1, IDENTIFIER105_tree);
                        }


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:276:36: ( tuple_type )?
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==TUPLE_TYPE) ) {
                    alt28=1;
                }
                switch (alt28) {
                    case 1 :
                        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:276:36: tuple_type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_in_bag_type1162);
                        tuple_type106=tuple_type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type106.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "bag_type"


    public static class map_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map_type"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:279:1: map_type : ^( MAP_TYPE ( type )? ) ;
    public final AstValidator.map_type_return map_type() throws RecognitionException {
        AstValidator.map_type_return retval = new AstValidator.map_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_TYPE107=null;
        AstValidator.type_return type108 =null;


        CommonTree MAP_TYPE107_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:279:10: ( ^( MAP_TYPE ( type )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:279:12: ^( MAP_TYPE ( type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_TYPE107=(CommonTree)match(input,MAP_TYPE,FOLLOW_MAP_TYPE_in_map_type1176); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_TYPE107_tree = (CommonTree)adaptor.dupNode(MAP_TYPE107);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_TYPE107_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:279:24: ( type )?
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==BIGDECIMAL||LA29_0==BIGINTEGER||LA29_0==BOOLEAN||LA29_0==BYTEARRAY||LA29_0==CHARARRAY||LA29_0==DATETIME||LA29_0==DOUBLE||LA29_0==FLOAT||LA29_0==INT||LA29_0==LONG||LA29_0==BAG_TYPE||LA29_0==MAP_TYPE||LA29_0==TUPLE_TYPE) ) {
                    alt29=1;
                }
                switch (alt29) {
                    case 1 :
                        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:279:24: type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_type_in_map_type1178);
                        type108=type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, type108.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "map_type"


    public static class func_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:282:1: func_clause : ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) );
    public final AstValidator.func_clause_return func_clause() throws RecognitionException {
        AstValidator.func_clause_return retval = new AstValidator.func_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_REF109=null;
        CommonTree FUNC111=null;
        AstValidator.func_name_return func_name110 =null;

        AstValidator.func_name_return func_name112 =null;

        AstValidator.func_args_return func_args113 =null;


        CommonTree FUNC_REF109_tree=null;
        CommonTree FUNC111_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:282:13: ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==FUNC_REF) ) {
                alt31=1;
            }
            else if ( (LA31_0==FUNC) ) {
                alt31=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;

            }
            switch (alt31) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:282:15: ^( FUNC_REF func_name )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_REF109=(CommonTree)match(input,FUNC_REF,FOLLOW_FUNC_REF_in_func_clause1192); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_REF109_tree = (CommonTree)adaptor.dupNode(FUNC_REF109);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_REF109_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1194);
                    func_name110=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name110.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:283:15: ^( FUNC func_name ( func_args )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC111=(CommonTree)match(input,FUNC,FOLLOW_FUNC_in_func_clause1214); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC111_tree = (CommonTree)adaptor.dupNode(FUNC111);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC111_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1216);
                    func_name112=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name112.getTree());


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:283:33: ( func_args )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==MULTILINE_QUOTEDSTRING||LA30_0==QUOTEDSTRING) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:283:33: func_args
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_func_args_in_func_clause1218);
                            func_args113=func_args();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, func_args113.getTree());


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_clause"


    public static class func_name_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_name"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:286:1: func_name : eid ( ( PERIOD | DOLLAR ) eid )* ;
    public final AstValidator.func_name_return func_name() throws RecognitionException {
        AstValidator.func_name_return retval = new AstValidator.func_name_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set115=null;
        AstValidator.eid_return eid114 =null;

        AstValidator.eid_return eid116 =null;


        CommonTree set115_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:286:11: ( eid ( ( PERIOD | DOLLAR ) eid )* )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:286:13: eid ( ( PERIOD | DOLLAR ) eid )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_eid_in_func_name1230);
            eid114=eid();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, eid114.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:286:17: ( ( PERIOD | DOLLAR ) eid )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==DOLLAR||LA32_0==PERIOD) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:286:19: ( PERIOD | DOLLAR ) eid
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    set115=(CommonTree)input.LT(1);

            	    if ( input.LA(1)==DOLLAR||input.LA(1)==PERIOD ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) {
            	        set115_tree = (CommonTree)adaptor.dupNode(set115);


            	        adaptor.addChild(root_0, set115_tree);
            	        }

            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_eid_in_func_name1244);
            	    eid116=eid();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, eid116.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_name"


    public static class func_args_string_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_args_string"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:289:1: func_args_string : ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING );
    public final AstValidator.func_args_string_return func_args_string() throws RecognitionException {
        AstValidator.func_args_string_return retval = new AstValidator.func_args_string_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set117=null;

        CommonTree set117_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:289:18: ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set117=(CommonTree)input.LT(1);

            if ( input.LA(1)==MULTILINE_QUOTEDSTRING||input.LA(1)==QUOTEDSTRING ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set117_tree = (CommonTree)adaptor.dupNode(set117);


                adaptor.addChild(root_0, set117_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_args_string"


    public static class func_args_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_args"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:292:1: func_args : ( func_args_string )+ ;
    public final AstValidator.func_args_return func_args() throws RecognitionException {
        AstValidator.func_args_return retval = new AstValidator.func_args_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.func_args_string_return func_args_string118 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:292:11: ( ( func_args_string )+ )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:292:13: ( func_args_string )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:292:13: ( func_args_string )+
            int cnt33=0;
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==MULTILINE_QUOTEDSTRING||LA33_0==QUOTEDSTRING) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:292:13: func_args_string
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_func_args_string_in_func_args1269);
            	    func_args_string118=func_args_string();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, func_args_string118.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt33 >= 1 ) break loop33;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(33, input);
                        throw eee;
                }
                cnt33++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_args"


    public static class cube_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:295:1: cube_clause : ^( CUBE cube_item ) ;
    public final AstValidator.cube_clause_return cube_clause() throws RecognitionException {
        AstValidator.cube_clause_return retval = new AstValidator.cube_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CUBE119=null;
        AstValidator.cube_item_return cube_item120 =null;


        CommonTree CUBE119_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:296:2: ( ^( CUBE cube_item ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:296:4: ^( CUBE cube_item )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CUBE119=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_cube_clause1282); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CUBE119_tree = (CommonTree)adaptor.dupNode(CUBE119);


            root_1 = (CommonTree)adaptor.becomeRoot(CUBE119_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_item_in_cube_clause1284);
            cube_item120=cube_item();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_item120.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_clause"


    public static class cube_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_item"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:299:1: cube_item : rel ( cube_by_clause ) ;
    public final AstValidator.cube_item_return cube_item() throws RecognitionException {
        AstValidator.cube_item_return retval = new AstValidator.cube_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.rel_return rel121 =null;

        AstValidator.cube_by_clause_return cube_by_clause122 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:300:2: ( rel ( cube_by_clause ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:300:4: rel ( cube_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_cube_item1296);
            rel121=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel121.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:300:8: ( cube_by_clause )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:300:10: cube_by_clause
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_by_clause_in_cube_item1300);
            cube_by_clause122=cube_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, cube_by_clause122.getTree());


            if ( state.backtracking==0 ) {
            }
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_item"


    public static class cube_by_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:303:1: cube_by_clause : ^( BY cube_or_rollup ) ;
    public final AstValidator.cube_by_clause_return cube_by_clause() throws RecognitionException {
        AstValidator.cube_by_clause_return retval = new AstValidator.cube_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY123=null;
        AstValidator.cube_or_rollup_return cube_or_rollup124 =null;


        CommonTree BY123_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:304:2: ( ^( BY cube_or_rollup ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:304:4: ^( BY cube_or_rollup )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY123=(CommonTree)match(input,BY,FOLLOW_BY_in_cube_by_clause1314); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY123_tree = (CommonTree)adaptor.dupNode(BY123);


            root_1 = (CommonTree)adaptor.becomeRoot(BY123_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_or_rollup_in_cube_by_clause1316);
            cube_or_rollup124=cube_or_rollup();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_or_rollup124.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_by_clause"


    public static class cube_or_rollup_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_or_rollup"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:307:1: cube_or_rollup : ( cube_rollup_list )+ ;
    public final AstValidator.cube_or_rollup_return cube_or_rollup() throws RecognitionException {
        AstValidator.cube_or_rollup_return retval = new AstValidator.cube_or_rollup_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.cube_rollup_list_return cube_rollup_list125 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:308:2: ( ( cube_rollup_list )+ )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:308:4: ( cube_rollup_list )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:308:4: ( cube_rollup_list )+
            int cnt34=0;
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==CUBE||LA34_0==ROLLUP) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:308:4: cube_rollup_list
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_rollup_list_in_cube_or_rollup1328);
            	    cube_rollup_list125=cube_rollup_list();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, cube_rollup_list125.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt34 >= 1 ) break loop34;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(34, input);
                        throw eee;
                }
                cnt34++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_or_rollup"


    public static class cube_rollup_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_rollup_list"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:311:1: cube_rollup_list : ^( ( CUBE | ROLLUP ) cube_by_expr_list ) ;
    public final AstValidator.cube_rollup_list_return cube_rollup_list() throws RecognitionException {
        AstValidator.cube_rollup_list_return retval = new AstValidator.cube_rollup_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set126=null;
        AstValidator.cube_by_expr_list_return cube_by_expr_list127 =null;


        CommonTree set126_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:312:2: ( ^( ( CUBE | ROLLUP ) cube_by_expr_list ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:312:4: ^( ( CUBE | ROLLUP ) cube_by_expr_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            set126=(CommonTree)input.LT(1);

            if ( input.LA(1)==CUBE||input.LA(1)==ROLLUP ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set126_tree = (CommonTree)adaptor.dupNode(set126);


                root_1 = (CommonTree)adaptor.becomeRoot(set126_tree, root_1);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_by_expr_list_in_cube_rollup_list1351);
            cube_by_expr_list127=cube_by_expr_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_by_expr_list127.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_rollup_list"


    public static class cube_by_expr_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_expr_list"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:315:1: cube_by_expr_list : ( cube_by_expr )+ ;
    public final AstValidator.cube_by_expr_list_return cube_by_expr_list() throws RecognitionException {
        AstValidator.cube_by_expr_list_return retval = new AstValidator.cube_by_expr_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.cube_by_expr_return cube_by_expr128 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:316:2: ( ( cube_by_expr )+ )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:316:4: ( cube_by_expr )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:316:4: ( cube_by_expr )+
            int cnt35=0;
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==BIGDECIMALNUMBER||LA35_0==BIGINTEGERNUMBER||LA35_0==CUBE||LA35_0==DIV||LA35_0==DOLLARVAR||LA35_0==DOUBLENUMBER||LA35_0==FALSE||LA35_0==FLOATNUMBER||LA35_0==GROUP||LA35_0==IDENTIFIER||LA35_0==INTEGER||LA35_0==LONGINTEGER||LA35_0==MINUS||LA35_0==NULL||LA35_0==PERCENT||LA35_0==PLUS||LA35_0==QUOTEDSTRING||LA35_0==STAR||LA35_0==TRUE||(LA35_0 >= BAG_VAL && LA35_0 <= BIN_EXPR)||(LA35_0 >= CASE_COND && LA35_0 <= CASE_EXPR)||(LA35_0 >= CAST_EXPR && LA35_0 <= EXPR_IN_PAREN)||LA35_0==FUNC_EVAL||LA35_0==INVOKER_FUNC_EVAL||(LA35_0 >= MAP_VAL && LA35_0 <= NEG)||LA35_0==TUPLE_VAL) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:316:4: cube_by_expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_by_expr_in_cube_by_expr_list1363);
            	    cube_by_expr128=cube_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, cube_by_expr128.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt35 >= 1 ) break loop35;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(35, input);
                        throw eee;
                }
                cnt35++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_by_expr_list"


    public static class cube_by_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_expr"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:319:1: cube_by_expr : ( col_range | expr | STAR );
    public final AstValidator.cube_by_expr_return cube_by_expr() throws RecognitionException {
        AstValidator.cube_by_expr_return retval = new AstValidator.cube_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR131=null;
        AstValidator.col_range_return col_range129 =null;

        AstValidator.expr_return expr130 =null;


        CommonTree STAR131_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:320:2: ( col_range | expr | STAR )
            int alt36=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt36=1;
                }
                break;
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case CUBE:
            case DIV:
            case DOLLARVAR:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case GROUP:
            case IDENTIFIER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
            case NULL:
            case PERCENT:
            case PLUS:
            case QUOTEDSTRING:
            case TRUE:
            case BAG_VAL:
            case BIN_EXPR:
            case CASE_COND:
            case CASE_EXPR:
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt36=2;
                }
                break;
            case STAR:
                {
                int LA36_3 = input.LA(2);

                if ( (LA36_3==DOWN) ) {
                    alt36=2;
                }
                else if ( (LA36_3==EOF||LA36_3==UP||LA36_3==BIGDECIMALNUMBER||LA36_3==BIGINTEGERNUMBER||LA36_3==CUBE||LA36_3==DIV||LA36_3==DOLLARVAR||LA36_3==DOUBLENUMBER||LA36_3==FALSE||LA36_3==FLOATNUMBER||LA36_3==GROUP||LA36_3==IDENTIFIER||LA36_3==INTEGER||LA36_3==LONGINTEGER||LA36_3==MINUS||LA36_3==NULL||LA36_3==PERCENT||LA36_3==PLUS||LA36_3==QUOTEDSTRING||LA36_3==STAR||LA36_3==TRUE||(LA36_3 >= BAG_VAL && LA36_3 <= BIN_EXPR)||(LA36_3 >= CASE_COND && LA36_3 <= CASE_EXPR)||(LA36_3 >= CAST_EXPR && LA36_3 <= EXPR_IN_PAREN)||LA36_3==FUNC_EVAL||LA36_3==INVOKER_FUNC_EVAL||(LA36_3 >= MAP_VAL && LA36_3 <= NEG)||LA36_3==TUPLE_VAL) ) {
                    alt36=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 36, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;

            }

            switch (alt36) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:320:4: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_cube_by_expr1374);
                    col_range129=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range129.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:320:16: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cube_by_expr1378);
                    expr130=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr130.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:320:23: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR131=(CommonTree)match(input,STAR,FOLLOW_STAR_in_cube_by_expr1382); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR131_tree = (CommonTree)adaptor.dupNode(STAR131);


                    adaptor.addChild(root_0, STAR131_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cube_by_expr"


    protected static class group_clause_scope {
        int arity;
    }
    protected Stack group_clause_stack = new Stack();


    public static class group_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:323:1: group_clause : ^( ( GROUP | COGROUP ) ( group_item )+ ( group_type )? ( partition_clause )? ) ;
    public final AstValidator.group_clause_return group_clause() throws RecognitionException {
        group_clause_stack.push(new group_clause_scope());
        AstValidator.group_clause_return retval = new AstValidator.group_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set132=null;
        AstValidator.group_item_return group_item133 =null;

        AstValidator.group_type_return group_type134 =null;

        AstValidator.partition_clause_return partition_clause135 =null;


        CommonTree set132_tree=null;


            ((group_clause_scope)group_clause_stack.peek()).arity = 0;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:330:2: ( ^( ( GROUP | COGROUP ) ( group_item )+ ( group_type )? ( partition_clause )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:330:4: ^( ( GROUP | COGROUP ) ( group_item )+ ( group_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            set132=(CommonTree)input.LT(1);

            if ( input.LA(1)==COGROUP||input.LA(1)==GROUP ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set132_tree = (CommonTree)adaptor.dupNode(set132);


                root_1 = (CommonTree)adaptor.becomeRoot(set132_tree, root_1);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:330:27: ( group_item )+
            int cnt37=0;
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==ARROBA||LA37_0==ASSERT||LA37_0==COGROUP||(LA37_0 >= CROSS && LA37_0 <= CUBE)||LA37_0==DEFINE||LA37_0==DISTINCT||LA37_0==FILTER||LA37_0==FOREACH||LA37_0==GROUP||LA37_0==IDENTIFIER||LA37_0==JOIN||(LA37_0 >= LIMIT && LA37_0 <= LOAD)||LA37_0==MAPREDUCE||LA37_0==ORDER||LA37_0==RANK||LA37_0==SAMPLE||LA37_0==SPLIT||(LA37_0 >= STORE && LA37_0 <= STREAM)||LA37_0==UNION) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:330:27: group_item
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_group_item_in_group_clause1413);
            	    group_item133=group_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, group_item133.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt37 >= 1 ) break loop37;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(37, input);
                        throw eee;
                }
                cnt37++;
            } while (true);


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:330:39: ( group_type )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==QUOTEDSTRING) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:330:39: group_type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_type_in_group_clause1416);
                    group_type134=group_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, group_type134.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:330:51: ( partition_clause )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==PARTITION) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:330:51: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_group_clause1419);
                    partition_clause135=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause135.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            group_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "group_clause"


    public static class group_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_type"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:333:1: group_type : QUOTEDSTRING ;
    public final AstValidator.group_type_return group_type() throws RecognitionException {
        AstValidator.group_type_return retval = new AstValidator.group_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING136=null;

        CommonTree QUOTEDSTRING136_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:333:12: ( QUOTEDSTRING )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:333:14: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING136=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_group_type1431); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING136_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING136);


            adaptor.addChild(root_0, QUOTEDSTRING136_tree);
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "group_type"


    public static class group_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_item"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:336:1: group_item : rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? ;
    public final AstValidator.group_item_return group_item() throws RecognitionException {
        AstValidator.group_item_return retval = new AstValidator.group_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ALL139=null;
        CommonTree ANY140=null;
        CommonTree set141=null;
        AstValidator.rel_return rel137 =null;

        AstValidator.join_group_by_clause_return join_group_by_clause138 =null;


        CommonTree ALL139_tree=null;
        CommonTree ANY140_tree=null;
        CommonTree set141_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:337:2: ( rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:337:4: rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )?
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_group_item1441);
            rel137=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel137.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:337:8: ( join_group_by_clause | ALL | ANY )
            int alt40=3;
            switch ( input.LA(1) ) {
            case BY:
                {
                alt40=1;
                }
                break;
            case ALL:
                {
                alt40=2;
                }
                break;
            case ANY:
                {
                alt40=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;

            }

            switch (alt40) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:337:10: join_group_by_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_group_by_clause_in_group_item1445);
                    join_group_by_clause138=join_group_by_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_group_by_clause138.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:337:33: ALL
                    {
                    _last = (CommonTree)input.LT(1);
                    ALL139=(CommonTree)match(input,ALL,FOLLOW_ALL_in_group_item1449); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL139_tree = (CommonTree)adaptor.dupNode(ALL139);


                    adaptor.addChild(root_0, ALL139_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:337:39: ANY
                    {
                    _last = (CommonTree)input.LT(1);
                    ANY140=(CommonTree)match(input,ANY,FOLLOW_ANY_in_group_item1453); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ANY140_tree = (CommonTree)adaptor.dupNode(ANY140);


                    adaptor.addChild(root_0, ANY140_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:337:45: ( INNER | OUTER )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==INNER||LA41_0==OUTER) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:
                    {
                    _last = (CommonTree)input.LT(1);
                    set141=(CommonTree)input.LT(1);

                    if ( input.LA(1)==INNER||input.LA(1)==OUTER ) {
                        input.consume();
                        if ( state.backtracking==0 ) {
                        set141_tree = (CommonTree)adaptor.dupNode(set141);


                        adaptor.addChild(root_0, set141_tree);
                        }

                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;

            }


            if ( state.backtracking==0 ) {
                   if( ((group_clause_scope)group_clause_stack.peek()).arity == 0 ) {
                       // For the first input
                       ((group_clause_scope)group_clause_stack.peek()).arity = (join_group_by_clause138!=null?join_group_by_clause138.exprCount:0);
                   } else if( (join_group_by_clause138!=null?join_group_by_clause138.exprCount:0) != ((group_clause_scope)group_clause_stack.peek()).arity ) {
                       throw new ParserValidationException( input, new SourceLocation( (PigParserNode)((CommonTree)retval.start) ),
                           "The arity of the group by columns do not match." );
                   }
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "group_item"


    public static class rel_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:349:1: rel : ( alias | previous_rel | op_clause ( parallel_clause )? );
    public final AstValidator.rel_return rel() throws RecognitionException {
        AstValidator.rel_return retval = new AstValidator.rel_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.alias_return alias142 =null;

        AstValidator.previous_rel_return previous_rel143 =null;

        AstValidator.op_clause_return op_clause144 =null;

        AstValidator.parallel_clause_return parallel_clause145 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:349:5: ( alias | previous_rel | op_clause ( parallel_clause )? )
            int alt43=3;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt43=1;
                }
                break;
            case ARROBA:
                {
                alt43=2;
                }
                break;
            case ASSERT:
            case COGROUP:
            case CROSS:
            case CUBE:
            case DEFINE:
            case DISTINCT:
            case FILTER:
            case FOREACH:
            case GROUP:
            case JOIN:
            case LIMIT:
            case LOAD:
            case MAPREDUCE:
            case ORDER:
            case RANK:
            case SAMPLE:
            case SPLIT:
            case STORE:
            case STREAM:
            case UNION:
                {
                alt43=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;

            }

            switch (alt43) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:349:7: alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_rel1480);
                    alias142=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias142.getTree());


                    if ( state.backtracking==0 ) {  validateAliasRef( aliases, (alias142!=null?alias142.node:null), (alias142!=null?alias142.name:null) ); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:350:7: previous_rel
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_previous_rel_in_rel1490);
                    previous_rel143=previous_rel();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, previous_rel143.getTree());


                    if ( state.backtracking==0 ) { validateAliasRef( aliases, (previous_rel143!=null?previous_rel143.node:null), (previous_rel143!=null?previous_rel143.name:null) ); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:351:7: op_clause ( parallel_clause )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_op_clause_in_rel1500);
                    op_clause144=op_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, op_clause144.getTree());


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:351:17: ( parallel_clause )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==PARALLEL) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:351:17: parallel_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_parallel_clause_in_rel1502);
                            parallel_clause145=parallel_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_0, parallel_clause145.getTree());


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel"


    public static class flatten_generated_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "flatten_generated_item"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:354:1: flatten_generated_item : ( flatten_clause | col_range | expr | STAR ) ( field_def_list )? ;
    public final AstValidator.flatten_generated_item_return flatten_generated_item() throws RecognitionException {
        AstValidator.flatten_generated_item_return retval = new AstValidator.flatten_generated_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR149=null;
        AstValidator.flatten_clause_return flatten_clause146 =null;

        AstValidator.col_range_return col_range147 =null;

        AstValidator.expr_return expr148 =null;

        AstValidator.field_def_list_return field_def_list150 =null;


        CommonTree STAR149_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:354:24: ( ( flatten_clause | col_range | expr | STAR ) ( field_def_list )? )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:354:26: ( flatten_clause | col_range | expr | STAR ) ( field_def_list )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:354:26: ( flatten_clause | col_range | expr | STAR )
            int alt44=4;
            switch ( input.LA(1) ) {
            case FLATTEN:
                {
                alt44=1;
                }
                break;
            case COL_RANGE:
                {
                alt44=2;
                }
                break;
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case CUBE:
            case DIV:
            case DOLLARVAR:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case GROUP:
            case IDENTIFIER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
            case NULL:
            case PERCENT:
            case PLUS:
            case QUOTEDSTRING:
            case TRUE:
            case BAG_VAL:
            case BIN_EXPR:
            case CASE_COND:
            case CASE_EXPR:
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt44=3;
                }
                break;
            case STAR:
                {
                int LA44_4 = input.LA(2);

                if ( (LA44_4==DOWN) ) {
                    alt44=3;
                }
                else if ( (LA44_4==EOF||LA44_4==UP||LA44_4==BIGDECIMALNUMBER||LA44_4==BIGINTEGERNUMBER||LA44_4==CUBE||LA44_4==DIV||LA44_4==DOLLARVAR||LA44_4==DOUBLENUMBER||LA44_4==FALSE||LA44_4==FLATTEN||LA44_4==FLOATNUMBER||LA44_4==GROUP||LA44_4==IDENTIFIER||LA44_4==INTEGER||LA44_4==LONGINTEGER||LA44_4==MINUS||LA44_4==NULL||LA44_4==PERCENT||LA44_4==PLUS||LA44_4==QUOTEDSTRING||LA44_4==STAR||LA44_4==TRUE||(LA44_4 >= BAG_VAL && LA44_4 <= BIN_EXPR)||(LA44_4 >= CASE_COND && LA44_4 <= CASE_EXPR)||(LA44_4 >= CAST_EXPR && LA44_4 <= FIELD_DEF_WITHOUT_IDENTIFIER)||LA44_4==FUNC_EVAL||LA44_4==INVOKER_FUNC_EVAL||(LA44_4 >= MAP_VAL && LA44_4 <= NEG)||LA44_4==TUPLE_VAL) ) {
                    alt44=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 4, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;

            }

            switch (alt44) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:354:28: flatten_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_flatten_clause_in_flatten_generated_item1514);
                    flatten_clause146=flatten_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, flatten_clause146.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:354:45: col_range
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_flatten_generated_item1518);
                    col_range147=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range147.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:354:57: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_flatten_generated_item1522);
                    expr148=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr148.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:354:64: STAR
                    {
                    _last = (CommonTree)input.LT(1);
                    STAR149=(CommonTree)match(input,STAR,FOLLOW_STAR_in_flatten_generated_item1526); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR149_tree = (CommonTree)adaptor.dupNode(STAR149);


                    adaptor.addChild(root_0, STAR149_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:354:71: ( field_def_list )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( ((LA45_0 >= FIELD_DEF && LA45_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:354:71: field_def_list
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_field_def_list_in_flatten_generated_item1530);
                    field_def_list150=field_def_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, field_def_list150.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "flatten_generated_item"


    public static class flatten_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "flatten_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:357:1: flatten_clause : ^( FLATTEN expr ) ;
    public final AstValidator.flatten_clause_return flatten_clause() throws RecognitionException {
        AstValidator.flatten_clause_return retval = new AstValidator.flatten_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FLATTEN151=null;
        AstValidator.expr_return expr152 =null;


        CommonTree FLATTEN151_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:357:16: ( ^( FLATTEN expr ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:357:18: ^( FLATTEN expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FLATTEN151=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_flatten_clause1542); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FLATTEN151_tree = (CommonTree)adaptor.dupNode(FLATTEN151);


            root_1 = (CommonTree)adaptor.becomeRoot(FLATTEN151_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_flatten_clause1544);
            expr152=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr152.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "flatten_clause"


    public static class store_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "store_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:360:1: store_clause : ^( STORE rel filename ( func_clause )? ) ;
    public final AstValidator.store_clause_return store_clause() throws RecognitionException {
        AstValidator.store_clause_return retval = new AstValidator.store_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STORE153=null;
        AstValidator.rel_return rel154 =null;

        AstValidator.filename_return filename155 =null;

        AstValidator.func_clause_return func_clause156 =null;


        CommonTree STORE153_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:360:14: ( ^( STORE rel filename ( func_clause )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:360:16: ^( STORE rel filename ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STORE153=(CommonTree)match(input,STORE,FOLLOW_STORE_in_store_clause1557); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STORE153_tree = (CommonTree)adaptor.dupNode(STORE153);


            root_1 = (CommonTree)adaptor.becomeRoot(STORE153_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_store_clause1559);
            rel154=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel154.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_store_clause1561);
            filename155=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename155.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:360:38: ( func_clause )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==FUNC||LA46_0==FUNC_REF) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:360:38: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_store_clause1563);
                    func_clause156=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause156.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "store_clause"


    public static class assert_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assert_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:363:1: assert_clause : ^( ASSERT rel cond ( comment )? ) ;
    public final AstValidator.assert_clause_return assert_clause() throws RecognitionException {
        AstValidator.assert_clause_return retval = new AstValidator.assert_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ASSERT157=null;
        AstValidator.rel_return rel158 =null;

        AstValidator.cond_return cond159 =null;

        AstValidator.comment_return comment160 =null;


        CommonTree ASSERT157_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:363:15: ( ^( ASSERT rel cond ( comment )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:363:17: ^( ASSERT rel cond ( comment )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ASSERT157=(CommonTree)match(input,ASSERT,FOLLOW_ASSERT_in_assert_clause1577); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ASSERT157_tree = (CommonTree)adaptor.dupNode(ASSERT157);


            root_1 = (CommonTree)adaptor.becomeRoot(ASSERT157_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_assert_clause1579);
            rel158=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel158.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_assert_clause1581);
            cond159=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond159.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:363:36: ( comment )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==QUOTEDSTRING) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:363:36: comment
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_comment_in_assert_clause1583);
                    comment160=comment();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, comment160.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "assert_clause"


    public static class comment_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "comment"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:366:1: comment : QUOTEDSTRING ;
    public final AstValidator.comment_return comment() throws RecognitionException {
        AstValidator.comment_return retval = new AstValidator.comment_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING161=null;

        CommonTree QUOTEDSTRING161_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:366:9: ( QUOTEDSTRING )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:366:11: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING161=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_comment1596); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING161_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING161);


            adaptor.addChild(root_0, QUOTEDSTRING161_tree);
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "comment"


    public static class filter_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "filter_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:369:1: filter_clause : ^( FILTER rel cond ) ;
    public final AstValidator.filter_clause_return filter_clause() throws RecognitionException {
        AstValidator.filter_clause_return retval = new AstValidator.filter_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER162=null;
        AstValidator.rel_return rel163 =null;

        AstValidator.cond_return cond164 =null;


        CommonTree FILTER162_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:369:15: ( ^( FILTER rel cond ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:369:17: ^( FILTER rel cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER162=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_filter_clause1607); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER162_tree = (CommonTree)adaptor.dupNode(FILTER162);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER162_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_filter_clause1609);
            rel163=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel163.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_filter_clause1611);
            cond164=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond164.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "filter_clause"


    public static class cond_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cond"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:372:1: cond : ( ^( OR cond cond ) | ^( AND cond cond ) | ^( NOT cond ) | ^( NULL expr ( NOT )? ) | ^( rel_op expr expr ) | in_eval | func_eval | ^( BOOL_COND expr ) );
    public final AstValidator.cond_return cond() throws RecognitionException {
        AstValidator.cond_return retval = new AstValidator.cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OR165=null;
        CommonTree AND168=null;
        CommonTree NOT171=null;
        CommonTree NULL173=null;
        CommonTree NOT175=null;
        CommonTree BOOL_COND181=null;
        AstValidator.cond_return cond166 =null;

        AstValidator.cond_return cond167 =null;

        AstValidator.cond_return cond169 =null;

        AstValidator.cond_return cond170 =null;

        AstValidator.cond_return cond172 =null;

        AstValidator.expr_return expr174 =null;

        AstValidator.rel_op_return rel_op176 =null;

        AstValidator.expr_return expr177 =null;

        AstValidator.expr_return expr178 =null;

        AstValidator.in_eval_return in_eval179 =null;

        AstValidator.func_eval_return func_eval180 =null;

        AstValidator.expr_return expr182 =null;


        CommonTree OR165_tree=null;
        CommonTree AND168_tree=null;
        CommonTree NOT171_tree=null;
        CommonTree NULL173_tree=null;
        CommonTree NOT175_tree=null;
        CommonTree BOOL_COND181_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:372:6: ( ^( OR cond cond ) | ^( AND cond cond ) | ^( NOT cond ) | ^( NULL expr ( NOT )? ) | ^( rel_op expr expr ) | in_eval | func_eval | ^( BOOL_COND expr ) )
            int alt49=8;
            switch ( input.LA(1) ) {
            case OR:
                {
                alt49=1;
                }
                break;
            case AND:
                {
                alt49=2;
                }
                break;
            case NOT:
                {
                alt49=3;
                }
                break;
            case NULL:
                {
                alt49=4;
                }
                break;
            case NUM_OP_EQ:
            case NUM_OP_GT:
            case NUM_OP_GTE:
            case NUM_OP_LT:
            case NUM_OP_LTE:
            case NUM_OP_NE:
            case STR_OP_EQ:
            case STR_OP_GT:
            case STR_OP_GTE:
            case STR_OP_LT:
            case STR_OP_LTE:
            case STR_OP_MATCHES:
            case STR_OP_NE:
                {
                alt49=5;
                }
                break;
            case IN:
                {
                alt49=6;
                }
                break;
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
                {
                alt49=7;
                }
                break;
            case BOOL_COND:
                {
                alt49=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;

            }

            switch (alt49) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:372:8: ^( OR cond cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    OR165=(CommonTree)match(input,OR,FOLLOW_OR_in_cond1624); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR165_tree = (CommonTree)adaptor.dupNode(OR165);


                    root_1 = (CommonTree)adaptor.becomeRoot(OR165_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1626);
                    cond166=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond166.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1628);
                    cond167=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond167.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:373:8: ^( AND cond cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    AND168=(CommonTree)match(input,AND,FOLLOW_AND_in_cond1641); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND168_tree = (CommonTree)adaptor.dupNode(AND168);


                    root_1 = (CommonTree)adaptor.becomeRoot(AND168_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1643);
                    cond169=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond169.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1645);
                    cond170=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond170.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:374:8: ^( NOT cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NOT171=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond1658); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT171_tree = (CommonTree)adaptor.dupNode(NOT171);


                    root_1 = (CommonTree)adaptor.becomeRoot(NOT171_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1660);
                    cond172=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond172.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:375:8: ^( NULL expr ( NOT )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NULL173=(CommonTree)match(input,NULL,FOLLOW_NULL_in_cond1673); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL173_tree = (CommonTree)adaptor.dupNode(NULL173);


                    root_1 = (CommonTree)adaptor.becomeRoot(NULL173_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1675);
                    expr174=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr174.getTree());


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:375:21: ( NOT )?
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==NOT) ) {
                        alt48=1;
                    }
                    switch (alt48) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:375:21: NOT
                            {
                            _last = (CommonTree)input.LT(1);
                            NOT175=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond1677); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NOT175_tree = (CommonTree)adaptor.dupNode(NOT175);


                            adaptor.addChild(root_1, NOT175_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:376:8: ^( rel_op expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_in_cond1691);
                    rel_op176=rel_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op176.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1693);
                    expr177=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr177.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1695);
                    expr178=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr178.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:377:8: in_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_in_eval_in_cond1706);
                    in_eval179=in_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, in_eval179.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:378:8: func_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_cond1715);
                    func_eval180=func_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval180.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:379:8: ^( BOOL_COND expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    BOOL_COND181=(CommonTree)match(input,BOOL_COND,FOLLOW_BOOL_COND_in_cond1726); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOL_COND181_tree = (CommonTree)adaptor.dupNode(BOOL_COND181);


                    root_1 = (CommonTree)adaptor.becomeRoot(BOOL_COND181_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1728);
                    expr182=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr182.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cond"


    public static class in_eval_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "in_eval"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:382:1: in_eval : ^( IN ( ^( IN_LHS expr ) ^( IN_RHS expr ) )+ ) ;
    public final AstValidator.in_eval_return in_eval() throws RecognitionException {
        AstValidator.in_eval_return retval = new AstValidator.in_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IN183=null;
        CommonTree IN_LHS184=null;
        CommonTree IN_RHS186=null;
        AstValidator.expr_return expr185 =null;

        AstValidator.expr_return expr187 =null;


        CommonTree IN183_tree=null;
        CommonTree IN_LHS184_tree=null;
        CommonTree IN_RHS186_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:382:8: ( ^( IN ( ^( IN_LHS expr ) ^( IN_RHS expr ) )+ ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:382:10: ^( IN ( ^( IN_LHS expr ) ^( IN_RHS expr ) )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            IN183=(CommonTree)match(input,IN,FOLLOW_IN_in_in_eval1740); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IN183_tree = (CommonTree)adaptor.dupNode(IN183);


            root_1 = (CommonTree)adaptor.becomeRoot(IN183_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:382:16: ( ^( IN_LHS expr ) ^( IN_RHS expr ) )+
            int cnt50=0;
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==IN_LHS) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:382:18: ^( IN_LHS expr ) ^( IN_RHS expr )
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_2 = _last;
            	    CommonTree _first_2 = null;
            	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    IN_LHS184=(CommonTree)match(input,IN_LHS,FOLLOW_IN_LHS_in_in_eval1746); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IN_LHS184_tree = (CommonTree)adaptor.dupNode(IN_LHS184);


            	    root_2 = (CommonTree)adaptor.becomeRoot(IN_LHS184_tree, root_2);
            	    }


            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_in_eval1748);
            	    expr185=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr185.getTree());


            	    match(input, Token.UP, null); if (state.failed) return retval;
            	    adaptor.addChild(root_1, root_2);
            	    _last = _save_last_2;
            	    }


            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_2 = _last;
            	    CommonTree _first_2 = null;
            	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    IN_RHS186=(CommonTree)match(input,IN_RHS,FOLLOW_IN_RHS_in_in_eval1754); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IN_RHS186_tree = (CommonTree)adaptor.dupNode(IN_RHS186);


            	    root_2 = (CommonTree)adaptor.becomeRoot(IN_RHS186_tree, root_2);
            	    }


            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_in_eval1756);
            	    expr187=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr187.getTree());


            	    match(input, Token.UP, null); if (state.failed) return retval;
            	    adaptor.addChild(root_1, root_2);
            	    _last = _save_last_2;
            	    }


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt50 >= 1 ) break loop50;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(50, input);
                        throw eee;
                }
                cnt50++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "in_eval"


    public static class func_eval_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_eval"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:385:1: func_eval : ( ^( FUNC_EVAL func_name ( real_arg )* ) | ^( INVOKER_FUNC_EVAL func_name IDENTIFIER ( real_arg )* ) );
    public final AstValidator.func_eval_return func_eval() throws RecognitionException {
        AstValidator.func_eval_return retval = new AstValidator.func_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_EVAL188=null;
        CommonTree INVOKER_FUNC_EVAL191=null;
        CommonTree IDENTIFIER193=null;
        AstValidator.func_name_return func_name189 =null;

        AstValidator.real_arg_return real_arg190 =null;

        AstValidator.func_name_return func_name192 =null;

        AstValidator.real_arg_return real_arg194 =null;


        CommonTree FUNC_EVAL188_tree=null;
        CommonTree INVOKER_FUNC_EVAL191_tree=null;
        CommonTree IDENTIFIER193_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:385:10: ( ^( FUNC_EVAL func_name ( real_arg )* ) | ^( INVOKER_FUNC_EVAL func_name IDENTIFIER ( real_arg )* ) )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==FUNC_EVAL) ) {
                alt53=1;
            }
            else if ( (LA53_0==INVOKER_FUNC_EVAL) ) {
                alt53=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;

            }
            switch (alt53) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:385:12: ^( FUNC_EVAL func_name ( real_arg )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_EVAL188=(CommonTree)match(input,FUNC_EVAL,FOLLOW_FUNC_EVAL_in_func_eval1773); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_EVAL188_tree = (CommonTree)adaptor.dupNode(FUNC_EVAL188);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_EVAL188_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_eval1775);
                    func_name189=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name189.getTree());


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:385:35: ( real_arg )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==BIGDECIMALNUMBER||LA51_0==BIGINTEGERNUMBER||LA51_0==CUBE||LA51_0==DIV||LA51_0==DOLLARVAR||LA51_0==DOUBLENUMBER||LA51_0==FALSE||LA51_0==FLOATNUMBER||LA51_0==GROUP||LA51_0==IDENTIFIER||LA51_0==INTEGER||LA51_0==LONGINTEGER||LA51_0==MINUS||LA51_0==NULL||LA51_0==PERCENT||LA51_0==PLUS||LA51_0==QUOTEDSTRING||LA51_0==STAR||LA51_0==TRUE||(LA51_0 >= BAG_VAL && LA51_0 <= BIN_EXPR)||(LA51_0 >= CASE_COND && LA51_0 <= CASE_EXPR)||(LA51_0 >= CAST_EXPR && LA51_0 <= EXPR_IN_PAREN)||LA51_0==FUNC_EVAL||LA51_0==INVOKER_FUNC_EVAL||(LA51_0 >= MAP_VAL && LA51_0 <= NEG)||LA51_0==TUPLE_VAL) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:385:35: real_arg
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_real_arg_in_func_eval1777);
                    	    real_arg190=real_arg();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, real_arg190.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop51;
                        }
                    } while (true);


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:385:49: ^( INVOKER_FUNC_EVAL func_name IDENTIFIER ( real_arg )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    INVOKER_FUNC_EVAL191=(CommonTree)match(input,INVOKER_FUNC_EVAL,FOLLOW_INVOKER_FUNC_EVAL_in_func_eval1786); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INVOKER_FUNC_EVAL191_tree = (CommonTree)adaptor.dupNode(INVOKER_FUNC_EVAL191);


                    root_1 = (CommonTree)adaptor.becomeRoot(INVOKER_FUNC_EVAL191_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_eval1788);
                    func_name192=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name192.getTree());


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER193=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_func_eval1790); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER193_tree = (CommonTree)adaptor.dupNode(IDENTIFIER193);


                    adaptor.addChild(root_1, IDENTIFIER193_tree);
                    }


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:385:91: ( real_arg )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==BIGDECIMALNUMBER||LA52_0==BIGINTEGERNUMBER||LA52_0==CUBE||LA52_0==DIV||LA52_0==DOLLARVAR||LA52_0==DOUBLENUMBER||LA52_0==FALSE||LA52_0==FLOATNUMBER||LA52_0==GROUP||LA52_0==IDENTIFIER||LA52_0==INTEGER||LA52_0==LONGINTEGER||LA52_0==MINUS||LA52_0==NULL||LA52_0==PERCENT||LA52_0==PLUS||LA52_0==QUOTEDSTRING||LA52_0==STAR||LA52_0==TRUE||(LA52_0 >= BAG_VAL && LA52_0 <= BIN_EXPR)||(LA52_0 >= CASE_COND && LA52_0 <= CASE_EXPR)||(LA52_0 >= CAST_EXPR && LA52_0 <= EXPR_IN_PAREN)||LA52_0==FUNC_EVAL||LA52_0==INVOKER_FUNC_EVAL||(LA52_0 >= MAP_VAL && LA52_0 <= NEG)||LA52_0==TUPLE_VAL) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:385:91: real_arg
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_real_arg_in_func_eval1792);
                    	    real_arg194=real_arg();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, real_arg194.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop52;
                        }
                    } while (true);


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "func_eval"


    public static class real_arg_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "real_arg"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:388:1: real_arg : ( expr | STAR | col_range );
    public final AstValidator.real_arg_return real_arg() throws RecognitionException {
        AstValidator.real_arg_return retval = new AstValidator.real_arg_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR196=null;
        AstValidator.expr_return expr195 =null;

        AstValidator.col_range_return col_range197 =null;


        CommonTree STAR196_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:388:10: ( expr | STAR | col_range )
            int alt54=3;
            switch ( input.LA(1) ) {
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case CUBE:
            case DIV:
            case DOLLARVAR:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case GROUP:
            case IDENTIFIER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
            case NULL:
            case PERCENT:
            case PLUS:
            case QUOTEDSTRING:
            case TRUE:
            case BAG_VAL:
            case BIN_EXPR:
            case CASE_COND:
            case CASE_EXPR:
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt54=1;
                }
                break;
            case STAR:
                {
                int LA54_2 = input.LA(2);

                if ( (LA54_2==DOWN) ) {
                    alt54=1;
                }
                else if ( (LA54_2==EOF||LA54_2==UP||LA54_2==BIGDECIMALNUMBER||LA54_2==BIGINTEGERNUMBER||LA54_2==CUBE||LA54_2==DIV||LA54_2==DOLLARVAR||LA54_2==DOUBLENUMBER||LA54_2==FALSE||LA54_2==FLOATNUMBER||LA54_2==GROUP||LA54_2==IDENTIFIER||LA54_2==INTEGER||LA54_2==LONGINTEGER||LA54_2==MINUS||LA54_2==NULL||LA54_2==PERCENT||LA54_2==PLUS||LA54_2==QUOTEDSTRING||LA54_2==STAR||LA54_2==TRUE||(LA54_2 >= BAG_VAL && LA54_2 <= BIN_EXPR)||(LA54_2 >= CASE_COND && LA54_2 <= CASE_EXPR)||(LA54_2 >= CAST_EXPR && LA54_2 <= EXPR_IN_PAREN)||LA54_2==FUNC_EVAL||LA54_2==INVOKER_FUNC_EVAL||(LA54_2 >= MAP_VAL && LA54_2 <= NEG)||LA54_2==TUPLE_VAL) ) {
                    alt54=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 54, 2, input);

                    throw nvae;

                }
                }
                break;
            case COL_RANGE:
                {
                alt54=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;

            }

            switch (alt54) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:388:12: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_real_arg1804);
                    expr195=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr195.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:388:19: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR196=(CommonTree)match(input,STAR,FOLLOW_STAR_in_real_arg1808); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR196_tree = (CommonTree)adaptor.dupNode(STAR196);


                    adaptor.addChild(root_0, STAR196_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:388:26: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_real_arg1812);
                    col_range197=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range197.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "real_arg"


    public static class expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expr"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:391:1: expr : ( ^( PLUS expr expr ) | ^( MINUS expr expr ) | ^( STAR expr expr ) | ^( DIV expr expr ) | ^( PERCENT expr expr ) | ^( CAST_EXPR type expr ) | const_expr | var_expr | ^( NEG expr ) | ^( CAST_EXPR type_cast expr ) | ^( EXPR_IN_PAREN expr ) );
    public final AstValidator.expr_return expr() throws RecognitionException {
        AstValidator.expr_return retval = new AstValidator.expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PLUS198=null;
        CommonTree MINUS201=null;
        CommonTree STAR204=null;
        CommonTree DIV207=null;
        CommonTree PERCENT210=null;
        CommonTree CAST_EXPR213=null;
        CommonTree NEG218=null;
        CommonTree CAST_EXPR220=null;
        CommonTree EXPR_IN_PAREN223=null;
        AstValidator.expr_return expr199 =null;

        AstValidator.expr_return expr200 =null;

        AstValidator.expr_return expr202 =null;

        AstValidator.expr_return expr203 =null;

        AstValidator.expr_return expr205 =null;

        AstValidator.expr_return expr206 =null;

        AstValidator.expr_return expr208 =null;

        AstValidator.expr_return expr209 =null;

        AstValidator.expr_return expr211 =null;

        AstValidator.expr_return expr212 =null;

        AstValidator.type_return type214 =null;

        AstValidator.expr_return expr215 =null;

        AstValidator.const_expr_return const_expr216 =null;

        AstValidator.var_expr_return var_expr217 =null;

        AstValidator.expr_return expr219 =null;

        AstValidator.type_cast_return type_cast221 =null;

        AstValidator.expr_return expr222 =null;

        AstValidator.expr_return expr224 =null;


        CommonTree PLUS198_tree=null;
        CommonTree MINUS201_tree=null;
        CommonTree STAR204_tree=null;
        CommonTree DIV207_tree=null;
        CommonTree PERCENT210_tree=null;
        CommonTree CAST_EXPR213_tree=null;
        CommonTree NEG218_tree=null;
        CommonTree CAST_EXPR220_tree=null;
        CommonTree EXPR_IN_PAREN223_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:391:6: ( ^( PLUS expr expr ) | ^( MINUS expr expr ) | ^( STAR expr expr ) | ^( DIV expr expr ) | ^( PERCENT expr expr ) | ^( CAST_EXPR type expr ) | const_expr | var_expr | ^( NEG expr ) | ^( CAST_EXPR type_cast expr ) | ^( EXPR_IN_PAREN expr ) )
            int alt55=11;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt55=1;
                }
                break;
            case MINUS:
                {
                int LA55_2 = input.LA(2);

                if ( (synpred108_AstValidator()) ) {
                    alt55=2;
                }
                else if ( (synpred113_AstValidator()) ) {
                    alt55=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 55, 2, input);

                    throw nvae;

                }
                }
                break;
            case STAR:
                {
                alt55=3;
                }
                break;
            case DIV:
                {
                alt55=4;
                }
                break;
            case PERCENT:
                {
                alt55=5;
                }
                break;
            case CAST_EXPR:
                {
                int LA55_6 = input.LA(2);

                if ( (synpred112_AstValidator()) ) {
                    alt55=6;
                }
                else if ( (synpred116_AstValidator()) ) {
                    alt55=10;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 55, 6, input);

                    throw nvae;

                }
                }
                break;
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case NULL:
            case QUOTEDSTRING:
            case TRUE:
            case BAG_VAL:
            case MAP_VAL:
            case TUPLE_VAL:
                {
                alt55=7;
                }
                break;
            case CUBE:
            case DOLLARVAR:
            case GROUP:
            case IDENTIFIER:
            case BIN_EXPR:
            case CASE_COND:
            case CASE_EXPR:
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
                {
                alt55=8;
                }
                break;
            case NEG:
                {
                alt55=9;
                }
                break;
            case EXPR_IN_PAREN:
                {
                alt55=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;

            }

            switch (alt55) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:391:8: ^( PLUS expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PLUS198=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expr1823); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PLUS198_tree = (CommonTree)adaptor.dupNode(PLUS198);


                    root_1 = (CommonTree)adaptor.becomeRoot(PLUS198_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1825);
                    expr199=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr199.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1827);
                    expr200=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr200.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:392:8: ^( MINUS expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    MINUS201=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expr1840); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS201_tree = (CommonTree)adaptor.dupNode(MINUS201);


                    root_1 = (CommonTree)adaptor.becomeRoot(MINUS201_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1842);
                    expr202=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr202.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1844);
                    expr203=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr203.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:393:8: ^( STAR expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STAR204=(CommonTree)match(input,STAR,FOLLOW_STAR_in_expr1857); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR204_tree = (CommonTree)adaptor.dupNode(STAR204);


                    root_1 = (CommonTree)adaptor.becomeRoot(STAR204_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1859);
                    expr205=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr205.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1861);
                    expr206=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr206.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:394:8: ^( DIV expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    DIV207=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expr1874); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DIV207_tree = (CommonTree)adaptor.dupNode(DIV207);


                    root_1 = (CommonTree)adaptor.becomeRoot(DIV207_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1876);
                    expr208=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr208.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1878);
                    expr209=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr209.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:395:8: ^( PERCENT expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PERCENT210=(CommonTree)match(input,PERCENT,FOLLOW_PERCENT_in_expr1891); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PERCENT210_tree = (CommonTree)adaptor.dupNode(PERCENT210);


                    root_1 = (CommonTree)adaptor.becomeRoot(PERCENT210_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1893);
                    expr211=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr211.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1895);
                    expr212=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr212.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:396:8: ^( CAST_EXPR type expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR213=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr1908); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR213_tree = (CommonTree)adaptor.dupNode(CAST_EXPR213);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR213_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_expr1910);
                    type214=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type214.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1912);
                    expr215=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr215.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:397:8: const_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_const_expr_in_expr1923);
                    const_expr216=const_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, const_expr216.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:398:8: var_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_var_expr_in_expr1932);
                    var_expr217=var_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, var_expr217.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:399:8: ^( NEG expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NEG218=(CommonTree)match(input,NEG,FOLLOW_NEG_in_expr1943); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NEG218_tree = (CommonTree)adaptor.dupNode(NEG218);


                    root_1 = (CommonTree)adaptor.becomeRoot(NEG218_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1945);
                    expr219=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr219.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:400:8: ^( CAST_EXPR type_cast expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR220=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr1958); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR220_tree = (CommonTree)adaptor.dupNode(CAST_EXPR220);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR220_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_cast_in_expr1960);
                    type_cast221=type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type_cast221.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1962);
                    expr222=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr222.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:401:8: ^( EXPR_IN_PAREN expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    EXPR_IN_PAREN223=(CommonTree)match(input,EXPR_IN_PAREN,FOLLOW_EXPR_IN_PAREN_in_expr1975); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXPR_IN_PAREN223_tree = (CommonTree)adaptor.dupNode(EXPR_IN_PAREN223);


                    root_1 = (CommonTree)adaptor.becomeRoot(EXPR_IN_PAREN223_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1977);
                    expr224=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr224.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expr"


    public static class type_cast_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type_cast"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:404:1: type_cast : ( simple_type | map_type | tuple_type_cast | bag_type_cast );
    public final AstValidator.type_cast_return type_cast() throws RecognitionException {
        AstValidator.type_cast_return retval = new AstValidator.type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.simple_type_return simple_type225 =null;

        AstValidator.map_type_return map_type226 =null;

        AstValidator.tuple_type_cast_return tuple_type_cast227 =null;

        AstValidator.bag_type_cast_return bag_type_cast228 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:404:11: ( simple_type | map_type | tuple_type_cast | bag_type_cast )
            int alt56=4;
            switch ( input.LA(1) ) {
            case BIGDECIMAL:
            case BIGINTEGER:
            case BOOLEAN:
            case BYTEARRAY:
            case CHARARRAY:
            case DATETIME:
            case DOUBLE:
            case FLOAT:
            case INT:
            case LONG:
                {
                alt56=1;
                }
                break;
            case MAP_TYPE:
                {
                alt56=2;
                }
                break;
            case TUPLE_TYPE_CAST:
                {
                alt56=3;
                }
                break;
            case BAG_TYPE_CAST:
                {
                alt56=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;

            }

            switch (alt56) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:404:13: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type_cast1988);
                    simple_type225=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type225.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:404:27: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type_cast1992);
                    map_type226=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type226.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:404:38: tuple_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_cast_in_type_cast1996);
                    tuple_type_cast227=tuple_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type_cast227.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:404:56: bag_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_cast_in_type_cast2000);
                    bag_type_cast228=bag_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type_cast228.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "type_cast"


    public static class tuple_type_cast_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple_type_cast"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:407:1: tuple_type_cast : ^( TUPLE_TYPE_CAST ( type_cast )* ) ;
    public final AstValidator.tuple_type_cast_return tuple_type_cast() throws RecognitionException {
        AstValidator.tuple_type_cast_return retval = new AstValidator.tuple_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE_CAST229=null;
        AstValidator.type_cast_return type_cast230 =null;


        CommonTree TUPLE_TYPE_CAST229_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:407:17: ( ^( TUPLE_TYPE_CAST ( type_cast )* ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:407:19: ^( TUPLE_TYPE_CAST ( type_cast )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE_CAST229=(CommonTree)match(input,TUPLE_TYPE_CAST,FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast2011); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE_CAST229_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE_CAST229);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE_CAST229_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:407:38: ( type_cast )*
                loop57:
                do {
                    int alt57=2;
                    int LA57_0 = input.LA(1);

                    if ( (LA57_0==BIGDECIMAL||LA57_0==BIGINTEGER||LA57_0==BOOLEAN||LA57_0==BYTEARRAY||LA57_0==CHARARRAY||LA57_0==DATETIME||LA57_0==DOUBLE||LA57_0==FLOAT||LA57_0==INT||LA57_0==LONG||LA57_0==BAG_TYPE_CAST||LA57_0==MAP_TYPE||LA57_0==TUPLE_TYPE_CAST) ) {
                        alt57=1;
                    }


                    switch (alt57) {
                	case 1 :
                	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:407:38: type_cast
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_type_cast_in_tuple_type_cast2013);
                	    type_cast230=type_cast();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, type_cast230.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop57;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tuple_type_cast"


    public static class bag_type_cast_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag_type_cast"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:410:1: bag_type_cast : ^( BAG_TYPE_CAST ( tuple_type_cast )? ) ;
    public final AstValidator.bag_type_cast_return bag_type_cast() throws RecognitionException {
        AstValidator.bag_type_cast_return retval = new AstValidator.bag_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE_CAST231=null;
        AstValidator.tuple_type_cast_return tuple_type_cast232 =null;


        CommonTree BAG_TYPE_CAST231_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:410:15: ( ^( BAG_TYPE_CAST ( tuple_type_cast )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:410:17: ^( BAG_TYPE_CAST ( tuple_type_cast )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE_CAST231=(CommonTree)match(input,BAG_TYPE_CAST,FOLLOW_BAG_TYPE_CAST_in_bag_type_cast2027); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE_CAST231_tree = (CommonTree)adaptor.dupNode(BAG_TYPE_CAST231);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE_CAST231_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:410:34: ( tuple_type_cast )?
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==TUPLE_TYPE_CAST) ) {
                    alt58=1;
                }
                switch (alt58) {
                    case 1 :
                        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:410:34: tuple_type_cast
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_cast_in_bag_type_cast2029);
                        tuple_type_cast232=tuple_type_cast();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type_cast232.getTree());


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "bag_type_cast"


    public static class var_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "var_expr"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:413:1: var_expr : projectable_expr ( dot_proj | pound_proj )* ;
    public final AstValidator.var_expr_return var_expr() throws RecognitionException {
        AstValidator.var_expr_return retval = new AstValidator.var_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.projectable_expr_return projectable_expr233 =null;

        AstValidator.dot_proj_return dot_proj234 =null;

        AstValidator.pound_proj_return pound_proj235 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:413:10: ( projectable_expr ( dot_proj | pound_proj )* )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:413:12: projectable_expr ( dot_proj | pound_proj )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_projectable_expr_in_var_expr2041);
            projectable_expr233=projectable_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, projectable_expr233.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:413:29: ( dot_proj | pound_proj )*
            loop59:
            do {
                int alt59=3;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==PERIOD) ) {
                    alt59=1;
                }
                else if ( (LA59_0==POUND) ) {
                    alt59=2;
                }


                switch (alt59) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:413:31: dot_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_dot_proj_in_var_expr2045);
            	    dot_proj234=dot_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, dot_proj234.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:413:42: pound_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_pound_proj_in_var_expr2049);
            	    pound_proj235=pound_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, pound_proj235.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop59;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "var_expr"


    public static class projectable_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "projectable_expr"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:416:1: projectable_expr : ( func_eval | col_ref | bin_expr | case_expr | case_cond );
    public final AstValidator.projectable_expr_return projectable_expr() throws RecognitionException {
        AstValidator.projectable_expr_return retval = new AstValidator.projectable_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.func_eval_return func_eval236 =null;

        AstValidator.col_ref_return col_ref237 =null;

        AstValidator.bin_expr_return bin_expr238 =null;

        AstValidator.case_expr_return case_expr239 =null;

        AstValidator.case_cond_return case_cond240 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:416:17: ( func_eval | col_ref | bin_expr | case_expr | case_cond )
            int alt60=5;
            switch ( input.LA(1) ) {
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
                {
                alt60=1;
                }
                break;
            case CUBE:
            case DOLLARVAR:
            case GROUP:
            case IDENTIFIER:
                {
                alt60=2;
                }
                break;
            case BIN_EXPR:
                {
                alt60=3;
                }
                break;
            case CASE_EXPR:
                {
                alt60=4;
                }
                break;
            case CASE_COND:
                {
                alt60=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;

            }

            switch (alt60) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:416:19: func_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_projectable_expr2060);
                    func_eval236=func_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval236.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:416:31: col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_projectable_expr2064);
                    col_ref237=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref237.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:416:41: bin_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bin_expr_in_projectable_expr2068);
                    bin_expr238=bin_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bin_expr238.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:416:52: case_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_case_expr_in_projectable_expr2072);
                    case_expr239=case_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, case_expr239.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:416:64: case_cond
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_case_cond_in_projectable_expr2076);
                    case_cond240=case_cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, case_cond240.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "projectable_expr"


    public static class dot_proj_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dot_proj"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:419:1: dot_proj : ^( PERIOD ( col_alias_or_index )+ ) ;
    public final AstValidator.dot_proj_return dot_proj() throws RecognitionException {
        AstValidator.dot_proj_return retval = new AstValidator.dot_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PERIOD241=null;
        AstValidator.col_alias_or_index_return col_alias_or_index242 =null;


        CommonTree PERIOD241_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:419:10: ( ^( PERIOD ( col_alias_or_index )+ ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:419:12: ^( PERIOD ( col_alias_or_index )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PERIOD241=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_dot_proj2087); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PERIOD241_tree = (CommonTree)adaptor.dupNode(PERIOD241);


            root_1 = (CommonTree)adaptor.becomeRoot(PERIOD241_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:419:22: ( col_alias_or_index )+
            int cnt61=0;
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==CUBE||LA61_0==DOLLARVAR||LA61_0==GROUP||LA61_0==IDENTIFIER) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:419:22: col_alias_or_index
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_alias_or_index_in_dot_proj2089);
            	    col_alias_or_index242=col_alias_or_index();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_alias_or_index242.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt61 >= 1 ) break loop61;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(61, input);
                        throw eee;
                }
                cnt61++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "dot_proj"


    public static class col_alias_or_index_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_alias_or_index"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:422:1: col_alias_or_index : ( col_alias | col_index );
    public final AstValidator.col_alias_or_index_return col_alias_or_index() throws RecognitionException {
        AstValidator.col_alias_or_index_return retval = new AstValidator.col_alias_or_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.col_alias_return col_alias243 =null;

        AstValidator.col_index_return col_index244 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:422:20: ( col_alias | col_index )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==CUBE||LA62_0==GROUP||LA62_0==IDENTIFIER) ) {
                alt62=1;
            }
            else if ( (LA62_0==DOLLARVAR) ) {
                alt62=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;

            }
            switch (alt62) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:422:22: col_alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_alias_in_col_alias_or_index2101);
                    col_alias243=col_alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_alias243.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:422:34: col_index
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_index_in_col_alias_or_index2105);
                    col_index244=col_index();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_index244.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_alias_or_index"


    public static class col_alias_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_alias"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:425:1: col_alias : ( GROUP | CUBE | IDENTIFIER );
    public final AstValidator.col_alias_return col_alias() throws RecognitionException {
        AstValidator.col_alias_return retval = new AstValidator.col_alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set245=null;

        CommonTree set245_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:425:11: ( GROUP | CUBE | IDENTIFIER )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set245=(CommonTree)input.LT(1);

            if ( input.LA(1)==CUBE||input.LA(1)==GROUP||input.LA(1)==IDENTIFIER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set245_tree = (CommonTree)adaptor.dupNode(set245);


                adaptor.addChild(root_0, set245_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_alias"


    public static class col_index_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_index"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:428:1: col_index : DOLLARVAR ;
    public final AstValidator.col_index_return col_index() throws RecognitionException {
        AstValidator.col_index_return retval = new AstValidator.col_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR246=null;

        CommonTree DOLLARVAR246_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:428:11: ( DOLLARVAR )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:428:13: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR246=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_col_index2131); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR246_tree = (CommonTree)adaptor.dupNode(DOLLARVAR246);


            adaptor.addChild(root_0, DOLLARVAR246_tree);
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_index"


    public static class col_range_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_range"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:431:1: col_range : ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? ) ;
    public final AstValidator.col_range_return col_range() throws RecognitionException {
        AstValidator.col_range_return retval = new AstValidator.col_range_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree COL_RANGE247=null;
        CommonTree DOUBLE_PERIOD249=null;
        AstValidator.col_ref_return col_ref248 =null;

        AstValidator.col_ref_return col_ref250 =null;


        CommonTree COL_RANGE247_tree=null;
        CommonTree DOUBLE_PERIOD249_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:431:11: ( ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:431:14: ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            COL_RANGE247=(CommonTree)match(input,COL_RANGE,FOLLOW_COL_RANGE_in_col_range2142); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COL_RANGE247_tree = (CommonTree)adaptor.dupNode(COL_RANGE247);


            root_1 = (CommonTree)adaptor.becomeRoot(COL_RANGE247_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:431:26: ( col_ref )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==CUBE||LA63_0==DOLLARVAR||LA63_0==GROUP||LA63_0==IDENTIFIER) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:431:26: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range2144);
                    col_ref248=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, col_ref248.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            DOUBLE_PERIOD249=(CommonTree)match(input,DOUBLE_PERIOD,FOLLOW_DOUBLE_PERIOD_in_col_range2147); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOUBLE_PERIOD249_tree = (CommonTree)adaptor.dupNode(DOUBLE_PERIOD249);


            adaptor.addChild(root_1, DOUBLE_PERIOD249_tree);
            }


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:431:49: ( col_ref )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==CUBE||LA64_0==DOLLARVAR||LA64_0==GROUP||LA64_0==IDENTIFIER) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:431:49: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range2149);
                    col_ref250=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, col_ref250.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_range"


    public static class pound_proj_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pound_proj"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:435:1: pound_proj : ^( POUND ( QUOTEDSTRING | NULL ) ) ;
    public final AstValidator.pound_proj_return pound_proj() throws RecognitionException {
        AstValidator.pound_proj_return retval = new AstValidator.pound_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POUND251=null;
        CommonTree set252=null;

        CommonTree POUND251_tree=null;
        CommonTree set252_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:435:12: ( ^( POUND ( QUOTEDSTRING | NULL ) ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:435:14: ^( POUND ( QUOTEDSTRING | NULL ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            POUND251=(CommonTree)match(input,POUND,FOLLOW_POUND_in_pound_proj2163); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            POUND251_tree = (CommonTree)adaptor.dupNode(POUND251);


            root_1 = (CommonTree)adaptor.becomeRoot(POUND251_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            set252=(CommonTree)input.LT(1);

            if ( input.LA(1)==NULL||input.LA(1)==QUOTEDSTRING ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set252_tree = (CommonTree)adaptor.dupNode(set252);


                adaptor.addChild(root_1, set252_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "pound_proj"


    public static class bin_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bin_expr"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:438:1: bin_expr : ^( BIN_EXPR cond expr expr ) ;
    public final AstValidator.bin_expr_return bin_expr() throws RecognitionException {
        AstValidator.bin_expr_return retval = new AstValidator.bin_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BIN_EXPR253=null;
        AstValidator.cond_return cond254 =null;

        AstValidator.expr_return expr255 =null;

        AstValidator.expr_return expr256 =null;


        CommonTree BIN_EXPR253_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:438:10: ( ^( BIN_EXPR cond expr expr ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:438:12: ^( BIN_EXPR cond expr expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BIN_EXPR253=(CommonTree)match(input,BIN_EXPR,FOLLOW_BIN_EXPR_in_bin_expr2186); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BIN_EXPR253_tree = (CommonTree)adaptor.dupNode(BIN_EXPR253);


            root_1 = (CommonTree)adaptor.becomeRoot(BIN_EXPR253_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_bin_expr2188);
            cond254=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond254.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr2190);
            expr255=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr255.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr2192);
            expr256=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr256.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "bin_expr"


    public static class case_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "case_expr"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:441:1: case_expr : ^( CASE_EXPR ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )+ ) ;
    public final AstValidator.case_expr_return case_expr() throws RecognitionException {
        AstValidator.case_expr_return retval = new AstValidator.case_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CASE_EXPR257=null;
        CommonTree CASE_EXPR_LHS258=null;
        CommonTree CASE_EXPR_RHS260=null;
        AstValidator.expr_return expr259 =null;

        AstValidator.expr_return expr261 =null;


        CommonTree CASE_EXPR257_tree=null;
        CommonTree CASE_EXPR_LHS258_tree=null;
        CommonTree CASE_EXPR_RHS260_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:441:10: ( ^( CASE_EXPR ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )+ ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:441:12: ^( CASE_EXPR ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CASE_EXPR257=(CommonTree)match(input,CASE_EXPR,FOLLOW_CASE_EXPR_in_case_expr2204); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE_EXPR257_tree = (CommonTree)adaptor.dupNode(CASE_EXPR257);


            root_1 = (CommonTree)adaptor.becomeRoot(CASE_EXPR257_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:441:25: ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )+
            int cnt66=0;
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==CASE_EXPR_LHS) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:441:27: ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_2 = _last;
            	    CommonTree _first_2 = null;
            	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    CASE_EXPR_LHS258=(CommonTree)match(input,CASE_EXPR_LHS,FOLLOW_CASE_EXPR_LHS_in_case_expr2210); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    CASE_EXPR_LHS258_tree = (CommonTree)adaptor.dupNode(CASE_EXPR_LHS258);


            	    root_2 = (CommonTree)adaptor.becomeRoot(CASE_EXPR_LHS258_tree, root_2);
            	    }


            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_case_expr2212);
            	    expr259=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr259.getTree());


            	    match(input, Token.UP, null); if (state.failed) return retval;
            	    adaptor.addChild(root_1, root_2);
            	    _last = _save_last_2;
            	    }


            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:441:51: ( ^( CASE_EXPR_RHS expr ) )+
            	    int cnt65=0;
            	    loop65:
            	    do {
            	        int alt65=2;
            	        int LA65_0 = input.LA(1);

            	        if ( (LA65_0==CASE_EXPR_RHS) ) {
            	            alt65=1;
            	        }


            	        switch (alt65) {
            	    	case 1 :
            	    	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:441:53: ^( CASE_EXPR_RHS expr )
            	    	    {
            	    	    _last = (CommonTree)input.LT(1);
            	    	    {
            	    	    CommonTree _save_last_2 = _last;
            	    	    CommonTree _first_2 = null;
            	    	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    	    _last = (CommonTree)input.LT(1);
            	    	    CASE_EXPR_RHS260=(CommonTree)match(input,CASE_EXPR_RHS,FOLLOW_CASE_EXPR_RHS_in_case_expr2220); if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) {
            	    	    CASE_EXPR_RHS260_tree = (CommonTree)adaptor.dupNode(CASE_EXPR_RHS260);


            	    	    root_2 = (CommonTree)adaptor.becomeRoot(CASE_EXPR_RHS260_tree, root_2);
            	    	    }


            	    	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    	    _last = (CommonTree)input.LT(1);
            	    	    pushFollow(FOLLOW_expr_in_case_expr2222);
            	    	    expr261=expr();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) 
            	    	    adaptor.addChild(root_2, expr261.getTree());


            	    	    match(input, Token.UP, null); if (state.failed) return retval;
            	    	    adaptor.addChild(root_1, root_2);
            	    	    _last = _save_last_2;
            	    	    }


            	    	    if ( state.backtracking==0 ) {
            	    	    }
            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt65 >= 1 ) break loop65;
            	    	    if (state.backtracking>0) {state.failed=true; return retval;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(65, input);
            	                throw eee;
            	        }
            	        cnt65++;
            	    } while (true);


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt66 >= 1 ) break loop66;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(66, input);
                        throw eee;
                }
                cnt66++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "case_expr"


    public static class case_cond_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "case_cond"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:444:1: case_cond : ^( CASE_COND ^( WHEN ( cond )+ ) ^( THEN ( expr )+ ) ) ;
    public final AstValidator.case_cond_return case_cond() throws RecognitionException {
        AstValidator.case_cond_return retval = new AstValidator.case_cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CASE_COND262=null;
        CommonTree WHEN263=null;
        CommonTree THEN265=null;
        AstValidator.cond_return cond264 =null;

        AstValidator.expr_return expr266 =null;


        CommonTree CASE_COND262_tree=null;
        CommonTree WHEN263_tree=null;
        CommonTree THEN265_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:444:10: ( ^( CASE_COND ^( WHEN ( cond )+ ) ^( THEN ( expr )+ ) ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:444:12: ^( CASE_COND ^( WHEN ( cond )+ ) ^( THEN ( expr )+ ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CASE_COND262=(CommonTree)match(input,CASE_COND,FOLLOW_CASE_COND_in_case_cond2241); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE_COND262_tree = (CommonTree)adaptor.dupNode(CASE_COND262);


            root_1 = (CommonTree)adaptor.becomeRoot(CASE_COND262_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            WHEN263=(CommonTree)match(input,WHEN,FOLLOW_WHEN_in_case_cond2245); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            WHEN263_tree = (CommonTree)adaptor.dupNode(WHEN263);


            root_2 = (CommonTree)adaptor.becomeRoot(WHEN263_tree, root_2);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:444:33: ( cond )+
            int cnt67=0;
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==AND||LA67_0==IN||(LA67_0 >= NOT && LA67_0 <= NUM_OP_NE)||LA67_0==OR||(LA67_0 >= STR_OP_EQ && LA67_0 <= STR_OP_NE)||LA67_0==BOOL_COND||LA67_0==FUNC_EVAL||LA67_0==INVOKER_FUNC_EVAL) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:444:33: cond
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cond_in_case_cond2247);
            	    cond264=cond();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, cond264.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt67 >= 1 ) break loop67;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(67, input);
                        throw eee;
                }
                cnt67++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_1, root_2);
            _last = _save_last_2;
            }


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            THEN265=(CommonTree)match(input,THEN,FOLLOW_THEN_in_case_cond2254); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            THEN265_tree = (CommonTree)adaptor.dupNode(THEN265);


            root_2 = (CommonTree)adaptor.becomeRoot(THEN265_tree, root_2);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:444:49: ( expr )+
            int cnt68=0;
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==BIGDECIMALNUMBER||LA68_0==BIGINTEGERNUMBER||LA68_0==CUBE||LA68_0==DIV||LA68_0==DOLLARVAR||LA68_0==DOUBLENUMBER||LA68_0==FALSE||LA68_0==FLOATNUMBER||LA68_0==GROUP||LA68_0==IDENTIFIER||LA68_0==INTEGER||LA68_0==LONGINTEGER||LA68_0==MINUS||LA68_0==NULL||LA68_0==PERCENT||LA68_0==PLUS||LA68_0==QUOTEDSTRING||LA68_0==STAR||LA68_0==TRUE||(LA68_0 >= BAG_VAL && LA68_0 <= BIN_EXPR)||(LA68_0 >= CASE_COND && LA68_0 <= CASE_EXPR)||LA68_0==CAST_EXPR||LA68_0==EXPR_IN_PAREN||LA68_0==FUNC_EVAL||LA68_0==INVOKER_FUNC_EVAL||(LA68_0 >= MAP_VAL && LA68_0 <= NEG)||LA68_0==TUPLE_VAL) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:444:49: expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_case_cond2256);
            	    expr266=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr266.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt68 >= 1 ) break loop68;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(68, input);
                        throw eee;
                }
                cnt68++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_1, root_2);
            _last = _save_last_2;
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "case_cond"


    public static class limit_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "limit_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:447:1: limit_clause : ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) ) ;
    public final AstValidator.limit_clause_return limit_clause() throws RecognitionException {
        AstValidator.limit_clause_return retval = new AstValidator.limit_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT267=null;
        CommonTree INTEGER269=null;
        CommonTree LONGINTEGER270=null;
        AstValidator.rel_return rel268 =null;

        AstValidator.expr_return expr271 =null;


        CommonTree LIMIT267_tree=null;
        CommonTree INTEGER269_tree=null;
        CommonTree LONGINTEGER270_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:447:14: ( ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:447:16: ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT267=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_limit_clause2272); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT267_tree = (CommonTree)adaptor.dupNode(LIMIT267);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT267_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_limit_clause2274);
            rel268=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel268.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:447:29: ( INTEGER | LONGINTEGER | expr )
            int alt69=3;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                int LA69_1 = input.LA(2);

                if ( (synpred139_AstValidator()) ) {
                    alt69=1;
                }
                else if ( (true) ) {
                    alt69=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 1, input);

                    throw nvae;

                }
                }
                break;
            case LONGINTEGER:
                {
                int LA69_2 = input.LA(2);

                if ( (synpred140_AstValidator()) ) {
                    alt69=2;
                }
                else if ( (true) ) {
                    alt69=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 2, input);

                    throw nvae;

                }
                }
                break;
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case CUBE:
            case DIV:
            case DOLLARVAR:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case GROUP:
            case IDENTIFIER:
            case MINUS:
            case NULL:
            case PERCENT:
            case PLUS:
            case QUOTEDSTRING:
            case STAR:
            case TRUE:
            case BAG_VAL:
            case BIN_EXPR:
            case CASE_COND:
            case CASE_EXPR:
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt69=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;

            }

            switch (alt69) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:447:31: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER269=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_limit_clause2278); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER269_tree = (CommonTree)adaptor.dupNode(INTEGER269);


                    adaptor.addChild(root_1, INTEGER269_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:447:41: LONGINTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    LONGINTEGER270=(CommonTree)match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_limit_clause2282); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONGINTEGER270_tree = (CommonTree)adaptor.dupNode(LONGINTEGER270);


                    adaptor.addChild(root_1, LONGINTEGER270_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:447:55: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_limit_clause2286);
                    expr271=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr271.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "limit_clause"


    public static class sample_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "sample_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:450:1: sample_clause : ^( SAMPLE rel ( DOUBLENUMBER | expr ) ) ;
    public final AstValidator.sample_clause_return sample_clause() throws RecognitionException {
        AstValidator.sample_clause_return retval = new AstValidator.sample_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SAMPLE272=null;
        CommonTree DOUBLENUMBER274=null;
        AstValidator.rel_return rel273 =null;

        AstValidator.expr_return expr275 =null;


        CommonTree SAMPLE272_tree=null;
        CommonTree DOUBLENUMBER274_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:450:15: ( ^( SAMPLE rel ( DOUBLENUMBER | expr ) ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:450:17: ^( SAMPLE rel ( DOUBLENUMBER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SAMPLE272=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_sample_clause2301); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SAMPLE272_tree = (CommonTree)adaptor.dupNode(SAMPLE272);


            root_1 = (CommonTree)adaptor.becomeRoot(SAMPLE272_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_sample_clause2303);
            rel273=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel273.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:450:31: ( DOUBLENUMBER | expr )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==DOUBLENUMBER) ) {
                int LA70_1 = input.LA(2);

                if ( (synpred141_AstValidator()) ) {
                    alt70=1;
                }
                else if ( (true) ) {
                    alt70=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 70, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA70_0==BIGDECIMALNUMBER||LA70_0==BIGINTEGERNUMBER||LA70_0==CUBE||LA70_0==DIV||LA70_0==DOLLARVAR||LA70_0==FALSE||LA70_0==FLOATNUMBER||LA70_0==GROUP||LA70_0==IDENTIFIER||LA70_0==INTEGER||LA70_0==LONGINTEGER||LA70_0==MINUS||LA70_0==NULL||LA70_0==PERCENT||LA70_0==PLUS||LA70_0==QUOTEDSTRING||LA70_0==STAR||LA70_0==TRUE||(LA70_0 >= BAG_VAL && LA70_0 <= BIN_EXPR)||(LA70_0 >= CASE_COND && LA70_0 <= CASE_EXPR)||LA70_0==CAST_EXPR||LA70_0==EXPR_IN_PAREN||LA70_0==FUNC_EVAL||LA70_0==INVOKER_FUNC_EVAL||(LA70_0 >= MAP_VAL && LA70_0 <= NEG)||LA70_0==TUPLE_VAL) ) {
                alt70=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;

            }
            switch (alt70) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:450:33: DOUBLENUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    DOUBLENUMBER274=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_sample_clause2307); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLENUMBER274_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER274);


                    adaptor.addChild(root_1, DOUBLENUMBER274_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:450:48: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_sample_clause2311);
                    expr275=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr275.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "sample_clause"


    public static class rank_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:453:1: rank_clause : ^( RANK rel ( rank_by_statement )? ) ;
    public final AstValidator.rank_clause_return rank_clause() throws RecognitionException {
        AstValidator.rank_clause_return retval = new AstValidator.rank_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree RANK276=null;
        AstValidator.rel_return rel277 =null;

        AstValidator.rank_by_statement_return rank_by_statement278 =null;


        CommonTree RANK276_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:453:13: ( ^( RANK rel ( rank_by_statement )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:453:15: ^( RANK rel ( rank_by_statement )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            RANK276=(CommonTree)match(input,RANK,FOLLOW_RANK_in_rank_clause2326); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RANK276_tree = (CommonTree)adaptor.dupNode(RANK276);


            root_1 = (CommonTree)adaptor.becomeRoot(RANK276_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_rank_clause2328);
            rel277=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel277.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:453:27: ( rank_by_statement )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==BY) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:453:29: rank_by_statement
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_by_statement_in_rank_clause2332);
                    rank_by_statement278=rank_by_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, rank_by_statement278.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rank_clause"


    public static class rank_by_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_by_statement"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:456:1: rank_by_statement : ^( BY rank_by_clause ( DENSE )? ) ;
    public final AstValidator.rank_by_statement_return rank_by_statement() throws RecognitionException {
        AstValidator.rank_by_statement_return retval = new AstValidator.rank_by_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY279=null;
        CommonTree DENSE281=null;
        AstValidator.rank_by_clause_return rank_by_clause280 =null;


        CommonTree BY279_tree=null;
        CommonTree DENSE281_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:456:19: ( ^( BY rank_by_clause ( DENSE )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:456:21: ^( BY rank_by_clause ( DENSE )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY279=(CommonTree)match(input,BY,FOLLOW_BY_in_rank_by_statement2348); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY279_tree = (CommonTree)adaptor.dupNode(BY279);


            root_1 = (CommonTree)adaptor.becomeRoot(BY279_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rank_by_clause_in_rank_by_statement2350);
            rank_by_clause280=rank_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rank_by_clause280.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:456:42: ( DENSE )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==DENSE) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:456:44: DENSE
                    {
                    _last = (CommonTree)input.LT(1);
                    DENSE281=(CommonTree)match(input,DENSE,FOLLOW_DENSE_in_rank_by_statement2354); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DENSE281_tree = (CommonTree)adaptor.dupNode(DENSE281);


                    adaptor.addChild(root_1, DENSE281_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rank_by_statement"


    public static class rank_by_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_by_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:459:1: rank_by_clause : ( STAR ( ASC | DESC )? | ( rank_col )+ );
    public final AstValidator.rank_by_clause_return rank_by_clause() throws RecognitionException {
        AstValidator.rank_by_clause_return retval = new AstValidator.rank_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR282=null;
        CommonTree set283=null;
        AstValidator.rank_col_return rank_col284 =null;


        CommonTree STAR282_tree=null;
        CommonTree set283_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:459:16: ( STAR ( ASC | DESC )? | ( rank_col )+ )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==STAR) ) {
                alt75=1;
            }
            else if ( (LA75_0==CUBE||LA75_0==DOLLARVAR||LA75_0==GROUP||LA75_0==IDENTIFIER||LA75_0==COL_RANGE) ) {
                alt75=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;

            }
            switch (alt75) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:459:18: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR282=(CommonTree)match(input,STAR,FOLLOW_STAR_in_rank_by_clause2368); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR282_tree = (CommonTree)adaptor.dupNode(STAR282);


                    adaptor.addChild(root_0, STAR282_tree);
                    }


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:459:23: ( ASC | DESC )?
                    int alt73=2;
                    int LA73_0 = input.LA(1);

                    if ( (LA73_0==ASC||LA73_0==DESC) ) {
                        alt73=1;
                    }
                    switch (alt73) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set283=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set283_tree = (CommonTree)adaptor.dupNode(set283);


                                adaptor.addChild(root_0, set283_tree);
                                }

                                state.errorRecovery=false;
                                state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:460:18: ( rank_col )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:460:18: ( rank_col )+
                    int cnt74=0;
                    loop74:
                    do {
                        int alt74=2;
                        int LA74_0 = input.LA(1);

                        if ( (LA74_0==CUBE||LA74_0==DOLLARVAR||LA74_0==GROUP||LA74_0==IDENTIFIER||LA74_0==COL_RANGE) ) {
                            alt74=1;
                        }


                        switch (alt74) {
                    	case 1 :
                    	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:460:18: rank_col
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_rank_col_in_rank_by_clause2398);
                    	    rank_col284=rank_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, rank_col284.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt74 >= 1 ) break loop74;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(74, input);
                                throw eee;
                        }
                        cnt74++;
                    } while (true);


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rank_by_clause"


    public static class rank_col_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_col"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:463:1: rank_col : ( col_range ( ASC | DESC )? | col_ref ( ASC | DESC )? );
    public final AstValidator.rank_col_return rank_col() throws RecognitionException {
        AstValidator.rank_col_return retval = new AstValidator.rank_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set286=null;
        CommonTree set288=null;
        AstValidator.col_range_return col_range285 =null;

        AstValidator.col_ref_return col_ref287 =null;


        CommonTree set286_tree=null;
        CommonTree set288_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:463:10: ( col_range ( ASC | DESC )? | col_ref ( ASC | DESC )? )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==COL_RANGE) ) {
                alt78=1;
            }
            else if ( (LA78_0==CUBE||LA78_0==DOLLARVAR||LA78_0==GROUP||LA78_0==IDENTIFIER) ) {
                alt78=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;

            }
            switch (alt78) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:463:12: col_range ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_rank_col2408);
                    col_range285=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range285.getTree());


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:463:22: ( ASC | DESC )?
                    int alt76=2;
                    int LA76_0 = input.LA(1);

                    if ( (LA76_0==ASC||LA76_0==DESC) ) {
                        alt76=1;
                    }
                    switch (alt76) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set286=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set286_tree = (CommonTree)adaptor.dupNode(set286);


                                adaptor.addChild(root_0, set286_tree);
                                }

                                state.errorRecovery=false;
                                state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:464:12: col_ref ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_rank_col2430);
                    col_ref287=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref287.getTree());


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:464:20: ( ASC | DESC )?
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==ASC||LA77_0==DESC) ) {
                        alt77=1;
                    }
                    switch (alt77) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set288=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set288_tree = (CommonTree)adaptor.dupNode(set288);


                                adaptor.addChild(root_0, set288_tree);
                                }

                                state.errorRecovery=false;
                                state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rank_col"


    public static class order_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:467:1: order_clause : ^( ORDER rel order_by_clause ( func_clause )? ) ;
    public final AstValidator.order_clause_return order_clause() throws RecognitionException {
        AstValidator.order_clause_return retval = new AstValidator.order_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER289=null;
        AstValidator.rel_return rel290 =null;

        AstValidator.order_by_clause_return order_by_clause291 =null;

        AstValidator.func_clause_return func_clause292 =null;


        CommonTree ORDER289_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:467:14: ( ^( ORDER rel order_by_clause ( func_clause )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:467:16: ^( ORDER rel order_by_clause ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER289=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_order_clause2452); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER289_tree = (CommonTree)adaptor.dupNode(ORDER289);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER289_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_order_clause2454);
            rel290=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel290.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_order_clause2456);
            order_by_clause291=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause291.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:467:45: ( func_clause )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==FUNC||LA79_0==FUNC_REF) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:467:45: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_order_clause2458);
                    func_clause292=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause292.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "order_clause"


    public static class order_by_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_by_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:470:1: order_by_clause : ( STAR ( ASC | DESC )? | ( order_col )+ );
    public final AstValidator.order_by_clause_return order_by_clause() throws RecognitionException {
        AstValidator.order_by_clause_return retval = new AstValidator.order_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR293=null;
        CommonTree set294=null;
        AstValidator.order_col_return order_col295 =null;


        CommonTree STAR293_tree=null;
        CommonTree set294_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:470:17: ( STAR ( ASC | DESC )? | ( order_col )+ )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==STAR) ) {
                alt82=1;
            }
            else if ( (LA82_0==CUBE||LA82_0==DOLLARVAR||LA82_0==GROUP||LA82_0==IDENTIFIER||LA82_0==COL_RANGE) ) {
                alt82=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;

            }
            switch (alt82) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:470:19: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR293=(CommonTree)match(input,STAR,FOLLOW_STAR_in_order_by_clause2470); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR293_tree = (CommonTree)adaptor.dupNode(STAR293);


                    adaptor.addChild(root_0, STAR293_tree);
                    }


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:470:24: ( ASC | DESC )?
                    int alt80=2;
                    int LA80_0 = input.LA(1);

                    if ( (LA80_0==ASC||LA80_0==DESC) ) {
                        alt80=1;
                    }
                    switch (alt80) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set294=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set294_tree = (CommonTree)adaptor.dupNode(set294);


                                adaptor.addChild(root_0, set294_tree);
                                }

                                state.errorRecovery=false;
                                state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:471:19: ( order_col )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:471:19: ( order_col )+
                    int cnt81=0;
                    loop81:
                    do {
                        int alt81=2;
                        int LA81_0 = input.LA(1);

                        if ( (LA81_0==CUBE||LA81_0==DOLLARVAR||LA81_0==GROUP||LA81_0==IDENTIFIER||LA81_0==COL_RANGE) ) {
                            alt81=1;
                        }


                        switch (alt81) {
                    	case 1 :
                    	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:471:19: order_col
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_order_col_in_order_by_clause2501);
                    	    order_col295=order_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, order_col295.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt81 >= 1 ) break loop81;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(81, input);
                                throw eee;
                        }
                        cnt81++;
                    } while (true);


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "order_by_clause"


    public static class order_col_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_col"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:474:1: order_col : ( col_range ( ASC | DESC )? | col_ref ( ASC | DESC )? );
    public final AstValidator.order_col_return order_col() throws RecognitionException {
        AstValidator.order_col_return retval = new AstValidator.order_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set297=null;
        CommonTree set299=null;
        AstValidator.col_range_return col_range296 =null;

        AstValidator.col_ref_return col_ref298 =null;


        CommonTree set297_tree=null;
        CommonTree set299_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:474:11: ( col_range ( ASC | DESC )? | col_ref ( ASC | DESC )? )
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==COL_RANGE) ) {
                alt85=1;
            }
            else if ( (LA85_0==CUBE||LA85_0==DOLLARVAR||LA85_0==GROUP||LA85_0==IDENTIFIER) ) {
                alt85=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;

            }
            switch (alt85) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:474:13: col_range ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_order_col2511);
                    col_range296=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range296.getTree());


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:474:23: ( ASC | DESC )?
                    int alt83=2;
                    int LA83_0 = input.LA(1);

                    if ( (LA83_0==ASC||LA83_0==DESC) ) {
                        alt83=1;
                    }
                    switch (alt83) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set297=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set297_tree = (CommonTree)adaptor.dupNode(set297);


                                adaptor.addChild(root_0, set297_tree);
                                }

                                state.errorRecovery=false;
                                state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:475:13: col_ref ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_order_col2534);
                    col_ref298=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref298.getTree());


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:475:21: ( ASC | DESC )?
                    int alt84=2;
                    int LA84_0 = input.LA(1);

                    if ( (LA84_0==ASC||LA84_0==DESC) ) {
                        alt84=1;
                    }
                    switch (alt84) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set299=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set299_tree = (CommonTree)adaptor.dupNode(set299);


                                adaptor.addChild(root_0, set299_tree);
                                }

                                state.errorRecovery=false;
                                state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }


                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "order_col"


    public static class distinct_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "distinct_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:478:1: distinct_clause : ^( DISTINCT rel ( partition_clause )? ) ;
    public final AstValidator.distinct_clause_return distinct_clause() throws RecognitionException {
        AstValidator.distinct_clause_return retval = new AstValidator.distinct_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT300=null;
        AstValidator.rel_return rel301 =null;

        AstValidator.partition_clause_return partition_clause302 =null;


        CommonTree DISTINCT300_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:478:17: ( ^( DISTINCT rel ( partition_clause )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:478:19: ^( DISTINCT rel ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT300=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_distinct_clause2556); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT300_tree = (CommonTree)adaptor.dupNode(DISTINCT300);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT300_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_distinct_clause2558);
            rel301=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel301.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:478:35: ( partition_clause )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==PARTITION) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:478:35: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_distinct_clause2560);
                    partition_clause302=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause302.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "distinct_clause"


    public static class partition_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "partition_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:481:1: partition_clause : ^( PARTITION func_name ) ;
    public final AstValidator.partition_clause_return partition_clause() throws RecognitionException {
        AstValidator.partition_clause_return retval = new AstValidator.partition_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARTITION303=null;
        AstValidator.func_name_return func_name304 =null;


        CommonTree PARTITION303_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:481:18: ( ^( PARTITION func_name ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:481:20: ^( PARTITION func_name )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARTITION303=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_partition_clause2574); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARTITION303_tree = (CommonTree)adaptor.dupNode(PARTITION303);


            root_1 = (CommonTree)adaptor.becomeRoot(PARTITION303_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_func_name_in_partition_clause2576);
            func_name304=func_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, func_name304.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "partition_clause"


    public static class cross_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cross_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:484:1: cross_clause : ^( CROSS rel_list ( partition_clause )? ) ;
    public final AstValidator.cross_clause_return cross_clause() throws RecognitionException {
        AstValidator.cross_clause_return retval = new AstValidator.cross_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS305=null;
        AstValidator.rel_list_return rel_list306 =null;

        AstValidator.partition_clause_return partition_clause307 =null;


        CommonTree CROSS305_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:484:14: ( ^( CROSS rel_list ( partition_clause )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:484:16: ^( CROSS rel_list ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS305=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_cross_clause2589); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS305_tree = (CommonTree)adaptor.dupNode(CROSS305);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS305_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_cross_clause2591);
            rel_list306=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list306.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:484:34: ( partition_clause )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==PARTITION) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:484:34: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_cross_clause2593);
                    partition_clause307=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause307.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "cross_clause"


    public static class rel_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_list"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:487:1: rel_list : ( rel )+ ;
    public final AstValidator.rel_list_return rel_list() throws RecognitionException {
        AstValidator.rel_list_return retval = new AstValidator.rel_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.rel_return rel308 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:487:10: ( ( rel )+ )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:487:12: ( rel )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:487:12: ( rel )+
            int cnt88=0;
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==ARROBA||LA88_0==ASSERT||LA88_0==COGROUP||(LA88_0 >= CROSS && LA88_0 <= CUBE)||LA88_0==DEFINE||LA88_0==DISTINCT||LA88_0==FILTER||LA88_0==FOREACH||LA88_0==GROUP||LA88_0==IDENTIFIER||LA88_0==JOIN||(LA88_0 >= LIMIT && LA88_0 <= LOAD)||LA88_0==MAPREDUCE||LA88_0==ORDER||LA88_0==RANK||LA88_0==SAMPLE||LA88_0==SPLIT||(LA88_0 >= STORE && LA88_0 <= STREAM)||LA88_0==UNION) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:487:12: rel
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_rel_in_rel_list2605);
            	    rel308=rel();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, rel308.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt88 >= 1 ) break loop88;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(88, input);
                        throw eee;
                }
                cnt88++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_list"


    protected static class join_clause_scope {
        int arity;
    }
    protected Stack join_clause_stack = new Stack();


    public static class join_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:490:1: join_clause : ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) ;
    public final AstValidator.join_clause_return join_clause() throws RecognitionException {
        join_clause_stack.push(new join_clause_scope());
        AstValidator.join_clause_return retval = new AstValidator.join_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN309=null;
        AstValidator.join_sub_clause_return join_sub_clause310 =null;

        AstValidator.join_type_return join_type311 =null;

        AstValidator.partition_clause_return partition_clause312 =null;


        CommonTree JOIN309_tree=null;


            ((join_clause_scope)join_clause_stack.peek()).arity = 0;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:497:2: ( ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:497:4: ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN309=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_join_clause2627); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN309_tree = (CommonTree)adaptor.dupNode(JOIN309);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN309_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_sub_clause_in_join_clause2629);
            join_sub_clause310=join_sub_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_sub_clause310.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:497:28: ( join_type )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==QUOTEDSTRING) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:497:28: join_type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_type_in_join_clause2631);
                    join_type311=join_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, join_type311.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:497:39: ( partition_clause )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==PARTITION) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:497:39: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_join_clause2634);
                    partition_clause312=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause312.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            join_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "join_clause"


    public static class join_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_type"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:500:1: join_type : QUOTEDSTRING ;
    public final AstValidator.join_type_return join_type() throws RecognitionException {
        AstValidator.join_type_return retval = new AstValidator.join_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING313=null;

        CommonTree QUOTEDSTRING313_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:500:11: ( QUOTEDSTRING )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:500:13: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING313=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_join_type2646); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING313_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING313);


            adaptor.addChild(root_0, QUOTEDSTRING313_tree);
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_type"


    public static class join_sub_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_sub_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:503:1: join_sub_clause : ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ );
    public final AstValidator.join_sub_clause_return join_sub_clause() throws RecognitionException {
        AstValidator.join_sub_clause_return retval = new AstValidator.join_sub_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set315=null;
        CommonTree OUTER316=null;
        AstValidator.join_item_return join_item314 =null;

        AstValidator.join_item_return join_item317 =null;

        AstValidator.join_item_return join_item318 =null;


        CommonTree set315_tree=null;
        CommonTree OUTER316_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:504:2: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ )
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==JOIN_ITEM) ) {
                int LA93_1 = input.LA(2);

                if ( (synpred171_AstValidator()) ) {
                    alt93=1;
                }
                else if ( (true) ) {
                    alt93=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 93, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;

            }
            switch (alt93) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:504:4: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause2656);
                    join_item314=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item314.getTree());


                    _last = (CommonTree)input.LT(1);
                    set315=(CommonTree)input.LT(1);

                    if ( input.LA(1)==FULL||input.LA(1)==LEFT||input.LA(1)==RIGHT ) {
                        input.consume();
                        if ( state.backtracking==0 ) {
                        set315_tree = (CommonTree)adaptor.dupNode(set315);


                        adaptor.addChild(root_0, set315_tree);
                        }

                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:504:38: ( OUTER )?
                    int alt91=2;
                    int LA91_0 = input.LA(1);

                    if ( (LA91_0==OUTER) ) {
                        alt91=1;
                    }
                    switch (alt91) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:504:38: OUTER
                            {
                            _last = (CommonTree)input.LT(1);
                            OUTER316=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_join_sub_clause2672); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            OUTER316_tree = (CommonTree)adaptor.dupNode(OUTER316);


                            adaptor.addChild(root_0, OUTER316_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause2675);
                    join_item317=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item317.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:505:4: ( join_item )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:505:4: ( join_item )+
                    int cnt92=0;
                    loop92:
                    do {
                        int alt92=2;
                        int LA92_0 = input.LA(1);

                        if ( (LA92_0==JOIN_ITEM) ) {
                            alt92=1;
                        }


                        switch (alt92) {
                    	case 1 :
                    	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:505:4: join_item
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_join_item_in_join_sub_clause2680);
                    	    join_item318=join_item();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, join_item318.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt92 >= 1 ) break loop92;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(92, input);
                                throw eee;
                        }
                        cnt92++;
                    } while (true);


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_sub_clause"


    public static class join_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_item"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:508:1: join_item : ^( JOIN_ITEM rel join_group_by_clause ) ;
    public final AstValidator.join_item_return join_item() throws RecognitionException {
        AstValidator.join_item_return retval = new AstValidator.join_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN_ITEM319=null;
        AstValidator.rel_return rel320 =null;

        AstValidator.join_group_by_clause_return join_group_by_clause321 =null;


        CommonTree JOIN_ITEM319_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:509:2: ( ^( JOIN_ITEM rel join_group_by_clause ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:509:4: ^( JOIN_ITEM rel join_group_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN_ITEM319=(CommonTree)match(input,JOIN_ITEM,FOLLOW_JOIN_ITEM_in_join_item2693); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN_ITEM319_tree = (CommonTree)adaptor.dupNode(JOIN_ITEM319);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN_ITEM319_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_join_item2695);
            rel320=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel320.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_group_by_clause_in_join_item2697);
            join_group_by_clause321=join_group_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_group_by_clause321.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   if( ((join_clause_scope)join_clause_stack.peek()).arity == 0 ) {
                       // For the first input
                       ((join_clause_scope)join_clause_stack.peek()).arity = (join_group_by_clause321!=null?join_group_by_clause321.exprCount:0);
                   } else if( (join_group_by_clause321!=null?join_group_by_clause321.exprCount:0) != ((join_clause_scope)join_clause_stack.peek()).arity ) {
                       throw new ParserValidationException( input, new SourceLocation( (PigParserNode)((CommonTree)retval.start) ),
                           "The arity of the join columns do not match." );
                   }
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_item"


    public static class join_group_by_clause_return extends TreeRuleReturnScope {
        public int exprCount;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_group_by_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:521:1: join_group_by_clause returns [int exprCount] : ^( BY ( join_group_by_expr )+ ) ;
    public final AstValidator.join_group_by_clause_return join_group_by_clause() throws RecognitionException {
        AstValidator.join_group_by_clause_return retval = new AstValidator.join_group_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY322=null;
        AstValidator.join_group_by_expr_return join_group_by_expr323 =null;


        CommonTree BY322_tree=null;


            retval.exprCount = 0;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:525:2: ( ^( BY ( join_group_by_expr )+ ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:525:4: ^( BY ( join_group_by_expr )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY322=(CommonTree)match(input,BY,FOLLOW_BY_in_join_group_by_clause2724); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY322_tree = (CommonTree)adaptor.dupNode(BY322);


            root_1 = (CommonTree)adaptor.becomeRoot(BY322_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:525:10: ( join_group_by_expr )+
            int cnt94=0;
            loop94:
            do {
                int alt94=2;
                int LA94_0 = input.LA(1);

                if ( (LA94_0==BIGDECIMALNUMBER||LA94_0==BIGINTEGERNUMBER||LA94_0==CUBE||LA94_0==DIV||LA94_0==DOLLARVAR||LA94_0==DOUBLENUMBER||LA94_0==FALSE||LA94_0==FLOATNUMBER||LA94_0==GROUP||LA94_0==IDENTIFIER||LA94_0==INTEGER||LA94_0==LONGINTEGER||LA94_0==MINUS||LA94_0==NULL||LA94_0==PERCENT||LA94_0==PLUS||LA94_0==QUOTEDSTRING||LA94_0==STAR||LA94_0==TRUE||(LA94_0 >= BAG_VAL && LA94_0 <= BIN_EXPR)||(LA94_0 >= CASE_COND && LA94_0 <= CASE_EXPR)||(LA94_0 >= CAST_EXPR && LA94_0 <= EXPR_IN_PAREN)||LA94_0==FUNC_EVAL||LA94_0==INVOKER_FUNC_EVAL||(LA94_0 >= MAP_VAL && LA94_0 <= NEG)||LA94_0==TUPLE_VAL) ) {
                    alt94=1;
                }


                switch (alt94) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:525:12: join_group_by_expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_join_group_by_expr_in_join_group_by_clause2728);
            	    join_group_by_expr323=join_group_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, join_group_by_expr323.getTree());


            	    if ( state.backtracking==0 ) { retval.exprCount++; }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt94 >= 1 ) break loop94;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(94, input);
                        throw eee;
                }
                cnt94++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_group_by_clause"


    public static class join_group_by_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_group_by_expr"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:528:1: join_group_by_expr : ( col_range | expr | STAR );
    public final AstValidator.join_group_by_expr_return join_group_by_expr() throws RecognitionException {
        AstValidator.join_group_by_expr_return retval = new AstValidator.join_group_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR326=null;
        AstValidator.col_range_return col_range324 =null;

        AstValidator.expr_return expr325 =null;


        CommonTree STAR326_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:528:20: ( col_range | expr | STAR )
            int alt95=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt95=1;
                }
                break;
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case CUBE:
            case DIV:
            case DOLLARVAR:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case GROUP:
            case IDENTIFIER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
            case NULL:
            case PERCENT:
            case PLUS:
            case QUOTEDSTRING:
            case TRUE:
            case BAG_VAL:
            case BIN_EXPR:
            case CASE_COND:
            case CASE_EXPR:
            case CAST_EXPR:
            case EXPR_IN_PAREN:
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt95=2;
                }
                break;
            case STAR:
                {
                int LA95_3 = input.LA(2);

                if ( (LA95_3==DOWN) ) {
                    alt95=2;
                }
                else if ( (LA95_3==EOF||LA95_3==UP||LA95_3==BIGDECIMALNUMBER||LA95_3==BIGINTEGERNUMBER||LA95_3==CUBE||LA95_3==DIV||LA95_3==DOLLARVAR||LA95_3==DOUBLENUMBER||LA95_3==FALSE||LA95_3==FLOATNUMBER||LA95_3==GROUP||LA95_3==IDENTIFIER||LA95_3==INTEGER||LA95_3==LONGINTEGER||LA95_3==MINUS||LA95_3==NULL||LA95_3==PERCENT||LA95_3==PLUS||LA95_3==QUOTEDSTRING||LA95_3==STAR||LA95_3==TRUE||(LA95_3 >= BAG_VAL && LA95_3 <= BIN_EXPR)||(LA95_3 >= CASE_COND && LA95_3 <= CASE_EXPR)||(LA95_3 >= CAST_EXPR && LA95_3 <= EXPR_IN_PAREN)||LA95_3==FUNC_EVAL||LA95_3==INVOKER_FUNC_EVAL||(LA95_3 >= MAP_VAL && LA95_3 <= NEG)||LA95_3==TUPLE_VAL) ) {
                    alt95=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 95, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;

            }

            switch (alt95) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:528:22: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_join_group_by_expr2744);
                    col_range324=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range324.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:528:35: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_join_group_by_expr2749);
                    expr325=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr325.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:528:42: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR326=(CommonTree)match(input,STAR,FOLLOW_STAR_in_join_group_by_expr2753); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR326_tree = (CommonTree)adaptor.dupNode(STAR326);


                    adaptor.addChild(root_0, STAR326_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "join_group_by_expr"


    public static class union_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "union_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:531:1: union_clause : ^( UNION ( ONSCHEMA )? rel_list ) ;
    public final AstValidator.union_clause_return union_clause() throws RecognitionException {
        AstValidator.union_clause_return retval = new AstValidator.union_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree UNION327=null;
        CommonTree ONSCHEMA328=null;
        AstValidator.rel_list_return rel_list329 =null;


        CommonTree UNION327_tree=null;
        CommonTree ONSCHEMA328_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:531:14: ( ^( UNION ( ONSCHEMA )? rel_list ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:531:16: ^( UNION ( ONSCHEMA )? rel_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            UNION327=(CommonTree)match(input,UNION,FOLLOW_UNION_in_union_clause2764); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            UNION327_tree = (CommonTree)adaptor.dupNode(UNION327);


            root_1 = (CommonTree)adaptor.becomeRoot(UNION327_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:531:25: ( ONSCHEMA )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==ONSCHEMA) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:531:25: ONSCHEMA
                    {
                    _last = (CommonTree)input.LT(1);
                    ONSCHEMA328=(CommonTree)match(input,ONSCHEMA,FOLLOW_ONSCHEMA_in_union_clause2766); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ONSCHEMA328_tree = (CommonTree)adaptor.dupNode(ONSCHEMA328);


                    adaptor.addChild(root_1, ONSCHEMA328_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_union_clause2769);
            rel_list329=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list329.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "union_clause"


    public static class foreach_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "foreach_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:534:1: foreach_clause : ^( FOREACH rel foreach_plan ) ;
    public final AstValidator.foreach_clause_return foreach_clause() throws RecognitionException {
        AstValidator.foreach_clause_return retval = new AstValidator.foreach_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH330=null;
        AstValidator.rel_return rel331 =null;

        AstValidator.foreach_plan_return foreach_plan332 =null;


        CommonTree FOREACH330_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:534:16: ( ^( FOREACH rel foreach_plan ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:534:18: ^( FOREACH rel foreach_plan )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH330=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_foreach_clause2782); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH330_tree = (CommonTree)adaptor.dupNode(FOREACH330);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH330_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_foreach_clause2784);
            rel331=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel331.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_foreach_plan_in_foreach_clause2786);
            foreach_plan332=foreach_plan();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, foreach_plan332.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "foreach_clause"


    public static class foreach_plan_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "foreach_plan"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:537:1: foreach_plan : ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) );
    public final AstValidator.foreach_plan_return foreach_plan() throws RecognitionException {
        AstValidator.foreach_plan_return retval = new AstValidator.foreach_plan_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH_PLAN_SIMPLE333=null;
        CommonTree FOREACH_PLAN_COMPLEX335=null;
        AstValidator.generate_clause_return generate_clause334 =null;

        AstValidator.nested_blk_return nested_blk336 =null;


        CommonTree FOREACH_PLAN_SIMPLE333_tree=null;
        CommonTree FOREACH_PLAN_COMPLEX335_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:537:14: ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) )
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==FOREACH_PLAN_SIMPLE) ) {
                alt97=1;
            }
            else if ( (LA97_0==FOREACH_PLAN_COMPLEX) ) {
                alt97=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 97, 0, input);

                throw nvae;

            }
            switch (alt97) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:537:16: ^( FOREACH_PLAN_SIMPLE generate_clause )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_SIMPLE333=(CommonTree)match(input,FOREACH_PLAN_SIMPLE,FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan2799); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_SIMPLE333_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_SIMPLE333);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_SIMPLE333_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_generate_clause_in_foreach_plan2801);
                    generate_clause334=generate_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, generate_clause334.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:538:16: ^( FOREACH_PLAN_COMPLEX nested_blk )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_COMPLEX335=(CommonTree)match(input,FOREACH_PLAN_COMPLEX,FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan2822); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_COMPLEX335_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_COMPLEX335);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_COMPLEX335_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_blk_in_foreach_plan2824);
                    nested_blk336=nested_blk();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_blk336.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "foreach_plan"


    protected static class nested_blk_scope {
        Set<String> ids;
    }
    protected Stack nested_blk_stack = new Stack();


    public static class nested_blk_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_blk"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:541:1: nested_blk : ( nested_command )* generate_clause ;
    public final AstValidator.nested_blk_return nested_blk() throws RecognitionException {
        nested_blk_stack.push(new nested_blk_scope());
        AstValidator.nested_blk_return retval = new AstValidator.nested_blk_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.nested_command_return nested_command337 =null;

        AstValidator.generate_clause_return generate_clause338 =null;



         ((nested_blk_scope)nested_blk_stack.peek()).ids = new HashSet<String>(); 
        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:544:2: ( ( nested_command )* generate_clause )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:544:4: ( nested_command )* generate_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:544:4: ( nested_command )*
            loop98:
            do {
                int alt98=2;
                int LA98_0 = input.LA(1);

                if ( ((LA98_0 >= NESTED_CMD && LA98_0 <= NESTED_CMD_ASSI)) ) {
                    alt98=1;
                }


                switch (alt98) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:544:4: nested_command
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_command_in_nested_blk2844);
            	    nested_command337=nested_command();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_command337.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop98;
                }
            } while (true);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_blk2847);
            generate_clause338=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, generate_clause338.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            nested_blk_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "nested_blk"


    public static class generate_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "generate_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:547:1: generate_clause : ^( GENERATE ( flatten_generated_item )+ ) ;
    public final AstValidator.generate_clause_return generate_clause() throws RecognitionException {
        AstValidator.generate_clause_return retval = new AstValidator.generate_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GENERATE339=null;
        AstValidator.flatten_generated_item_return flatten_generated_item340 =null;


        CommonTree GENERATE339_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:547:17: ( ^( GENERATE ( flatten_generated_item )+ ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:547:19: ^( GENERATE ( flatten_generated_item )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            GENERATE339=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_generate_clause2858); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            GENERATE339_tree = (CommonTree)adaptor.dupNode(GENERATE339);


            root_1 = (CommonTree)adaptor.becomeRoot(GENERATE339_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:547:31: ( flatten_generated_item )+
            int cnt99=0;
            loop99:
            do {
                int alt99=2;
                int LA99_0 = input.LA(1);

                if ( (LA99_0==BIGDECIMALNUMBER||LA99_0==BIGINTEGERNUMBER||LA99_0==CUBE||LA99_0==DIV||LA99_0==DOLLARVAR||LA99_0==DOUBLENUMBER||LA99_0==FALSE||LA99_0==FLATTEN||LA99_0==FLOATNUMBER||LA99_0==GROUP||LA99_0==IDENTIFIER||LA99_0==INTEGER||LA99_0==LONGINTEGER||LA99_0==MINUS||LA99_0==NULL||LA99_0==PERCENT||LA99_0==PLUS||LA99_0==QUOTEDSTRING||LA99_0==STAR||LA99_0==TRUE||(LA99_0 >= BAG_VAL && LA99_0 <= BIN_EXPR)||(LA99_0 >= CASE_COND && LA99_0 <= CASE_EXPR)||(LA99_0 >= CAST_EXPR && LA99_0 <= EXPR_IN_PAREN)||LA99_0==FUNC_EVAL||LA99_0==INVOKER_FUNC_EVAL||(LA99_0 >= MAP_VAL && LA99_0 <= NEG)||LA99_0==TUPLE_VAL) ) {
                    alt99=1;
                }


                switch (alt99) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:547:31: flatten_generated_item
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_flatten_generated_item_in_generate_clause2860);
            	    flatten_generated_item340=flatten_generated_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, flatten_generated_item340.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt99 >= 1 ) break loop99;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(99, input);
                        throw eee;
                }
                cnt99++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "generate_clause"


    public static class nested_command_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_command"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:550:1: nested_command : ( ^( NESTED_CMD IDENTIFIER nested_op ) | ^( NESTED_CMD_ASSI IDENTIFIER expr ) );
    public final AstValidator.nested_command_return nested_command() throws RecognitionException {
        AstValidator.nested_command_return retval = new AstValidator.nested_command_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_CMD341=null;
        CommonTree IDENTIFIER342=null;
        CommonTree NESTED_CMD_ASSI344=null;
        CommonTree IDENTIFIER345=null;
        AstValidator.nested_op_return nested_op343 =null;

        AstValidator.expr_return expr346 =null;


        CommonTree NESTED_CMD341_tree=null;
        CommonTree IDENTIFIER342_tree=null;
        CommonTree NESTED_CMD_ASSI344_tree=null;
        CommonTree IDENTIFIER345_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:551:2: ( ^( NESTED_CMD IDENTIFIER nested_op ) | ^( NESTED_CMD_ASSI IDENTIFIER expr ) )
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==NESTED_CMD) ) {
                alt100=1;
            }
            else if ( (LA100_0==NESTED_CMD_ASSI) ) {
                alt100=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 100, 0, input);

                throw nvae;

            }
            switch (alt100) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:551:4: ^( NESTED_CMD IDENTIFIER nested_op )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD341=(CommonTree)match(input,NESTED_CMD,FOLLOW_NESTED_CMD_in_nested_command2875); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD341_tree = (CommonTree)adaptor.dupNode(NESTED_CMD341);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD341_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER342=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command2877); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER342_tree = (CommonTree)adaptor.dupNode(IDENTIFIER342);


                    adaptor.addChild(root_1, IDENTIFIER342_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_op_in_nested_command2879);
                    nested_op343=nested_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_op343.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           ((nested_blk_scope)nested_blk_stack.peek()).ids.add( (IDENTIFIER342!=null?IDENTIFIER342.getText():null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:555:4: ^( NESTED_CMD_ASSI IDENTIFIER expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD_ASSI344=(CommonTree)match(input,NESTED_CMD_ASSI,FOLLOW_NESTED_CMD_ASSI_in_nested_command2893); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD_ASSI344_tree = (CommonTree)adaptor.dupNode(NESTED_CMD_ASSI344);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD_ASSI344_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER345=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command2895); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER345_tree = (CommonTree)adaptor.dupNode(IDENTIFIER345);


                    adaptor.addChild(root_1, IDENTIFIER345_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_command2897);
                    expr346=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr346.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           ((nested_blk_scope)nested_blk_stack.peek()).ids.add( (IDENTIFIER345!=null?IDENTIFIER345.getText():null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_command"


    public static class nested_op_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:561:1: nested_op : ( nested_proj | nested_filter | nested_sort | nested_distinct | nested_limit | nested_cross | nested_foreach );
    public final AstValidator.nested_op_return nested_op() throws RecognitionException {
        AstValidator.nested_op_return retval = new AstValidator.nested_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.nested_proj_return nested_proj347 =null;

        AstValidator.nested_filter_return nested_filter348 =null;

        AstValidator.nested_sort_return nested_sort349 =null;

        AstValidator.nested_distinct_return nested_distinct350 =null;

        AstValidator.nested_limit_return nested_limit351 =null;

        AstValidator.nested_cross_return nested_cross352 =null;

        AstValidator.nested_foreach_return nested_foreach353 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:561:11: ( nested_proj | nested_filter | nested_sort | nested_distinct | nested_limit | nested_cross | nested_foreach )
            int alt101=7;
            switch ( input.LA(1) ) {
            case NESTED_PROJ:
                {
                alt101=1;
                }
                break;
            case FILTER:
                {
                alt101=2;
                }
                break;
            case ORDER:
                {
                alt101=3;
                }
                break;
            case DISTINCT:
                {
                alt101=4;
                }
                break;
            case LIMIT:
                {
                alt101=5;
                }
                break;
            case CROSS:
                {
                alt101=6;
                }
                break;
            case FOREACH:
                {
                alt101=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;

            }

            switch (alt101) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:561:13: nested_proj
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op2913);
                    nested_proj347=nested_proj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj347.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:562:13: nested_filter
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_filter_in_nested_op2927);
                    nested_filter348=nested_filter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_filter348.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:563:13: nested_sort
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_sort_in_nested_op2941);
                    nested_sort349=nested_sort();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_sort349.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:564:13: nested_distinct
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_distinct_in_nested_op2955);
                    nested_distinct350=nested_distinct();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_distinct350.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:565:13: nested_limit
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_limit_in_nested_op2969);
                    nested_limit351=nested_limit();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_limit351.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:566:13: nested_cross
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_cross_in_nested_op2983);
                    nested_cross352=nested_cross();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_cross352.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:567:13: nested_foreach
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_foreach_in_nested_op2997);
                    nested_foreach353=nested_foreach();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_foreach353.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_op"


    public static class nested_proj_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_proj"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:570:1: nested_proj : ^( NESTED_PROJ col_ref ( col_ref )+ ) ;
    public final AstValidator.nested_proj_return nested_proj() throws RecognitionException {
        AstValidator.nested_proj_return retval = new AstValidator.nested_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_PROJ354=null;
        AstValidator.col_ref_return col_ref355 =null;

        AstValidator.col_ref_return col_ref356 =null;


        CommonTree NESTED_PROJ354_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:570:13: ( ^( NESTED_PROJ col_ref ( col_ref )+ ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:570:15: ^( NESTED_PROJ col_ref ( col_ref )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            NESTED_PROJ354=(CommonTree)match(input,NESTED_PROJ,FOLLOW_NESTED_PROJ_in_nested_proj3008); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NESTED_PROJ354_tree = (CommonTree)adaptor.dupNode(NESTED_PROJ354);


            root_1 = (CommonTree)adaptor.becomeRoot(NESTED_PROJ354_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_col_ref_in_nested_proj3010);
            col_ref355=col_ref();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, col_ref355.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:570:38: ( col_ref )+
            int cnt102=0;
            loop102:
            do {
                int alt102=2;
                int LA102_0 = input.LA(1);

                if ( (LA102_0==CUBE||LA102_0==DOLLARVAR||LA102_0==GROUP||LA102_0==IDENTIFIER) ) {
                    alt102=1;
                }


                switch (alt102) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:570:38: col_ref
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_ref_in_nested_proj3012);
            	    col_ref356=col_ref();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_ref356.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt102 >= 1 ) break loop102;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(102, input);
                        throw eee;
                }
                cnt102++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_proj"


    public static class nested_filter_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_filter"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:573:1: nested_filter : ^( FILTER nested_op_input cond ) ;
    public final AstValidator.nested_filter_return nested_filter() throws RecognitionException {
        AstValidator.nested_filter_return retval = new AstValidator.nested_filter_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER357=null;
        AstValidator.nested_op_input_return nested_op_input358 =null;

        AstValidator.cond_return cond359 =null;


        CommonTree FILTER357_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:574:2: ( ^( FILTER nested_op_input cond ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:574:4: ^( FILTER nested_op_input cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER357=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_nested_filter3027); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER357_tree = (CommonTree)adaptor.dupNode(FILTER357);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER357_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_filter3029);
            nested_op_input358=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input358.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_nested_filter3031);
            cond359=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond359.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_filter"


    public static class nested_sort_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_sort"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:577:1: nested_sort : ^( ORDER nested_op_input order_by_clause ( func_clause )? ) ;
    public final AstValidator.nested_sort_return nested_sort() throws RecognitionException {
        AstValidator.nested_sort_return retval = new AstValidator.nested_sort_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER360=null;
        AstValidator.nested_op_input_return nested_op_input361 =null;

        AstValidator.order_by_clause_return order_by_clause362 =null;

        AstValidator.func_clause_return func_clause363 =null;


        CommonTree ORDER360_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:577:13: ( ^( ORDER nested_op_input order_by_clause ( func_clause )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:577:15: ^( ORDER nested_op_input order_by_clause ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER360=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_nested_sort3044); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER360_tree = (CommonTree)adaptor.dupNode(ORDER360);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER360_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_sort3046);
            nested_op_input361=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input361.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_nested_sort3049);
            order_by_clause362=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause362.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:577:57: ( func_clause )?
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==FUNC||LA103_0==FUNC_REF) ) {
                alt103=1;
            }
            switch (alt103) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:577:57: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_nested_sort3051);
                    func_clause363=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause363.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_sort"


    public static class nested_distinct_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_distinct"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:580:1: nested_distinct : ^( DISTINCT nested_op_input ) ;
    public final AstValidator.nested_distinct_return nested_distinct() throws RecognitionException {
        AstValidator.nested_distinct_return retval = new AstValidator.nested_distinct_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT364=null;
        AstValidator.nested_op_input_return nested_op_input365 =null;


        CommonTree DISTINCT364_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:580:17: ( ^( DISTINCT nested_op_input ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:580:19: ^( DISTINCT nested_op_input )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT364=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_nested_distinct3065); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT364_tree = (CommonTree)adaptor.dupNode(DISTINCT364);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT364_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_distinct3067);
            nested_op_input365=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input365.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_distinct"


    public static class nested_limit_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_limit"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:583:1: nested_limit : ^( LIMIT nested_op_input ( INTEGER | expr ) ) ;
    public final AstValidator.nested_limit_return nested_limit() throws RecognitionException {
        AstValidator.nested_limit_return retval = new AstValidator.nested_limit_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT366=null;
        CommonTree INTEGER368=null;
        AstValidator.nested_op_input_return nested_op_input367 =null;

        AstValidator.expr_return expr369 =null;


        CommonTree LIMIT366_tree=null;
        CommonTree INTEGER368_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:583:14: ( ^( LIMIT nested_op_input ( INTEGER | expr ) ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:583:16: ^( LIMIT nested_op_input ( INTEGER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT366=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_nested_limit3080); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT366_tree = (CommonTree)adaptor.dupNode(LIMIT366);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT366_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_limit3082);
            nested_op_input367=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input367.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:583:41: ( INTEGER | expr )
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==INTEGER) ) {
                int LA104_1 = input.LA(2);

                if ( (synpred189_AstValidator()) ) {
                    alt104=1;
                }
                else if ( (true) ) {
                    alt104=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 104, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA104_0==BIGDECIMALNUMBER||LA104_0==BIGINTEGERNUMBER||LA104_0==CUBE||LA104_0==DIV||LA104_0==DOLLARVAR||LA104_0==DOUBLENUMBER||LA104_0==FALSE||LA104_0==FLOATNUMBER||LA104_0==GROUP||LA104_0==IDENTIFIER||LA104_0==LONGINTEGER||LA104_0==MINUS||LA104_0==NULL||LA104_0==PERCENT||LA104_0==PLUS||LA104_0==QUOTEDSTRING||LA104_0==STAR||LA104_0==TRUE||(LA104_0 >= BAG_VAL && LA104_0 <= BIN_EXPR)||(LA104_0 >= CASE_COND && LA104_0 <= CASE_EXPR)||LA104_0==CAST_EXPR||LA104_0==EXPR_IN_PAREN||LA104_0==FUNC_EVAL||LA104_0==INVOKER_FUNC_EVAL||(LA104_0 >= MAP_VAL && LA104_0 <= NEG)||LA104_0==TUPLE_VAL) ) {
                alt104=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;

            }
            switch (alt104) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:583:43: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER368=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_nested_limit3086); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER368_tree = (CommonTree)adaptor.dupNode(INTEGER368);


                    adaptor.addChild(root_1, INTEGER368_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:583:53: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_limit3090);
                    expr369=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr369.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_limit"


    public static class nested_cross_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_cross"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:586:1: nested_cross : ^( CROSS nested_op_input_list ) ;
    public final AstValidator.nested_cross_return nested_cross() throws RecognitionException {
        AstValidator.nested_cross_return retval = new AstValidator.nested_cross_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS370=null;
        AstValidator.nested_op_input_list_return nested_op_input_list371 =null;


        CommonTree CROSS370_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:586:14: ( ^( CROSS nested_op_input_list ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:586:16: ^( CROSS nested_op_input_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS370=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_nested_cross3105); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS370_tree = (CommonTree)adaptor.dupNode(CROSS370);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS370_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_list_in_nested_cross3107);
            nested_op_input_list371=nested_op_input_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input_list371.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_cross"


    public static class nested_foreach_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_foreach"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:589:1: nested_foreach : ^( FOREACH nested_op_input generate_clause ) ;
    public final AstValidator.nested_foreach_return nested_foreach() throws RecognitionException {
        AstValidator.nested_foreach_return retval = new AstValidator.nested_foreach_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH372=null;
        AstValidator.nested_op_input_return nested_op_input373 =null;

        AstValidator.generate_clause_return generate_clause374 =null;


        CommonTree FOREACH372_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:589:16: ( ^( FOREACH nested_op_input generate_clause ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:589:18: ^( FOREACH nested_op_input generate_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH372=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_nested_foreach3120); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH372_tree = (CommonTree)adaptor.dupNode(FOREACH372);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH372_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_foreach3122);
            nested_op_input373=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input373.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_foreach3124);
            generate_clause374=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, generate_clause374.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_foreach"


    public static class nested_op_input_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:592:1: nested_op_input : ( col_ref | nested_proj );
    public final AstValidator.nested_op_input_return nested_op_input() throws RecognitionException {
        AstValidator.nested_op_input_return retval = new AstValidator.nested_op_input_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.col_ref_return col_ref375 =null;

        AstValidator.nested_proj_return nested_proj376 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:592:17: ( col_ref | nested_proj )
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==CUBE||LA105_0==DOLLARVAR||LA105_0==GROUP||LA105_0==IDENTIFIER) ) {
                alt105=1;
            }
            else if ( (LA105_0==NESTED_PROJ) ) {
                alt105=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 105, 0, input);

                throw nvae;

            }
            switch (alt105) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:592:19: col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_nested_op_input3135);
                    col_ref375=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref375.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:592:29: nested_proj
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op_input3139);
                    nested_proj376=nested_proj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj376.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_op_input"


    public static class nested_op_input_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input_list"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:595:1: nested_op_input_list : ( nested_op_input )+ ;
    public final AstValidator.nested_op_input_list_return nested_op_input_list() throws RecognitionException {
        AstValidator.nested_op_input_list_return retval = new AstValidator.nested_op_input_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.nested_op_input_return nested_op_input377 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:595:22: ( ( nested_op_input )+ )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:595:24: ( nested_op_input )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:595:24: ( nested_op_input )+
            int cnt106=0;
            loop106:
            do {
                int alt106=2;
                int LA106_0 = input.LA(1);

                if ( (LA106_0==CUBE||LA106_0==DOLLARVAR||LA106_0==GROUP||LA106_0==IDENTIFIER||LA106_0==NESTED_PROJ) ) {
                    alt106=1;
                }


                switch (alt106) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:595:24: nested_op_input
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_op_input_in_nested_op_input_list3148);
            	    nested_op_input377=nested_op_input();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_op_input377.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt106 >= 1 ) break loop106;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(106, input);
                        throw eee;
                }
                cnt106++;
            } while (true);


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "nested_op_input_list"


    public static class stream_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stream_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:598:1: stream_clause : ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) ;
    public final AstValidator.stream_clause_return stream_clause() throws RecognitionException {
        AstValidator.stream_clause_return retval = new AstValidator.stream_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STREAM378=null;
        CommonTree set380=null;
        AstValidator.rel_return rel379 =null;

        AstValidator.as_clause_return as_clause381 =null;


        CommonTree STREAM378_tree=null;
        CommonTree set380_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:598:15: ( ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:598:17: ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STREAM378=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_stream_clause3160); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM378_tree = (CommonTree)adaptor.dupNode(STREAM378);


            root_1 = (CommonTree)adaptor.becomeRoot(STREAM378_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_stream_clause3162);
            rel379=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel379.getTree());


            _last = (CommonTree)input.LT(1);
            set380=(CommonTree)input.LT(1);

            if ( input.LA(1)==EXECCOMMAND||input.LA(1)==IDENTIFIER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set380_tree = (CommonTree)adaptor.dupNode(set380);


                adaptor.addChild(root_1, set380_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:598:60: ( as_clause )?
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==AS) ) {
                alt107=1;
            }
            switch (alt107) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:598:60: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_stream_clause3174);
                    as_clause381=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause381.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "stream_clause"


    public static class mr_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "mr_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:601:1: mr_clause : ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? ) ;
    public final AstValidator.mr_clause_return mr_clause() throws RecognitionException {
        AstValidator.mr_clause_return retval = new AstValidator.mr_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAPREDUCE382=null;
        CommonTree QUOTEDSTRING383=null;
        CommonTree EXECCOMMAND387=null;
        AstValidator.path_list_return path_list384 =null;

        AstValidator.store_clause_return store_clause385 =null;

        AstValidator.load_clause_return load_clause386 =null;


        CommonTree MAPREDUCE382_tree=null;
        CommonTree QUOTEDSTRING383_tree=null;
        CommonTree EXECCOMMAND387_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:601:11: ( ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:601:13: ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAPREDUCE382=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_mr_clause3188); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAPREDUCE382_tree = (CommonTree)adaptor.dupNode(MAPREDUCE382);


            root_1 = (CommonTree)adaptor.becomeRoot(MAPREDUCE382_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING383=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_mr_clause3190); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING383_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING383);


            adaptor.addChild(root_1, QUOTEDSTRING383_tree);
            }


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:601:39: ( path_list )?
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==QUOTEDSTRING) ) {
                alt108=1;
            }
            switch (alt108) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:601:39: path_list
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_path_list_in_mr_clause3192);
                    path_list384=path_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, path_list384.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_store_clause_in_mr_clause3195);
            store_clause385=store_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, store_clause385.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_load_clause_in_mr_clause3197);
            load_clause386=load_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, load_clause386.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:601:75: ( EXECCOMMAND )?
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==EXECCOMMAND) ) {
                alt109=1;
            }
            switch (alt109) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:601:75: EXECCOMMAND
                    {
                    _last = (CommonTree)input.LT(1);
                    EXECCOMMAND387=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_mr_clause3199); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXECCOMMAND387_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND387);


                    adaptor.addChild(root_1, EXECCOMMAND387_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "mr_clause"


    public static class split_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:604:1: split_clause : ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) ;
    public final AstValidator.split_clause_return split_clause() throws RecognitionException {
        AstValidator.split_clause_return retval = new AstValidator.split_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT388=null;
        AstValidator.rel_return rel389 =null;

        AstValidator.split_branch_return split_branch390 =null;

        AstValidator.split_otherwise_return split_otherwise391 =null;


        CommonTree SPLIT388_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:604:14: ( ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:604:16: ^( SPLIT rel ( split_branch )+ ( split_otherwise )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT388=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_split_clause3213); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT388_tree = (CommonTree)adaptor.dupNode(SPLIT388);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT388_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_split_clause3215);
            rel389=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel389.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:604:29: ( split_branch )+
            int cnt110=0;
            loop110:
            do {
                int alt110=2;
                int LA110_0 = input.LA(1);

                if ( (LA110_0==SPLIT_BRANCH) ) {
                    alt110=1;
                }


                switch (alt110) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:604:29: split_branch
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_split_branch_in_split_clause3217);
            	    split_branch390=split_branch();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, split_branch390.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt110 >= 1 ) break loop110;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(110, input);
                        throw eee;
                }
                cnt110++;
            } while (true);


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:604:43: ( split_otherwise )?
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==OTHERWISE) ) {
                alt111=1;
            }
            switch (alt111) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:604:43: split_otherwise
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_otherwise_in_split_clause3220);
                    split_otherwise391=split_otherwise();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, split_otherwise391.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "split_clause"


    public static class split_branch_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_branch"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:607:1: split_branch : ^( SPLIT_BRANCH alias cond ) ;
    public final AstValidator.split_branch_return split_branch() throws RecognitionException {
        AstValidator.split_branch_return retval = new AstValidator.split_branch_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT_BRANCH392=null;
        AstValidator.alias_return alias393 =null;

        AstValidator.cond_return cond394 =null;


        CommonTree SPLIT_BRANCH392_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:608:2: ( ^( SPLIT_BRANCH alias cond ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:608:4: ^( SPLIT_BRANCH alias cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT_BRANCH392=(CommonTree)match(input,SPLIT_BRANCH,FOLLOW_SPLIT_BRANCH_in_split_branch3235); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT_BRANCH392_tree = (CommonTree)adaptor.dupNode(SPLIT_BRANCH392);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT_BRANCH392_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_branch3237);
            alias393=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias393.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_split_branch3239);
            cond394=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond394.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   aliases.add( (alias393!=null?alias393.name:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "split_branch"


    public static class split_otherwise_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_otherwise"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:614:1: split_otherwise : ^( OTHERWISE alias ) ;
    public final AstValidator.split_otherwise_return split_otherwise() throws RecognitionException {
        AstValidator.split_otherwise_return retval = new AstValidator.split_otherwise_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OTHERWISE395=null;
        AstValidator.alias_return alias396 =null;


        CommonTree OTHERWISE395_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:614:17: ( ^( OTHERWISE alias ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:614:19: ^( OTHERWISE alias )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OTHERWISE395=(CommonTree)match(input,OTHERWISE,FOLLOW_OTHERWISE_in_split_otherwise3257); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OTHERWISE395_tree = (CommonTree)adaptor.dupNode(OTHERWISE395);


            root_1 = (CommonTree)adaptor.becomeRoot(OTHERWISE395_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_otherwise3259);
            alias396=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias396.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   aliases.add( (alias396!=null?alias396.name:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "split_otherwise"


    public static class col_ref_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_ref"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:620:1: col_ref : ( alias_col_ref | dollar_col_ref );
    public final AstValidator.col_ref_return col_ref() throws RecognitionException {
        AstValidator.col_ref_return retval = new AstValidator.col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.alias_col_ref_return alias_col_ref397 =null;

        AstValidator.dollar_col_ref_return dollar_col_ref398 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:620:9: ( alias_col_ref | dollar_col_ref )
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==CUBE||LA112_0==GROUP||LA112_0==IDENTIFIER) ) {
                alt112=1;
            }
            else if ( (LA112_0==DOLLARVAR) ) {
                alt112=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 112, 0, input);

                throw nvae;

            }
            switch (alt112) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:620:11: alias_col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_col_ref_in_col_ref3275);
                    alias_col_ref397=alias_col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias_col_ref397.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:620:27: dollar_col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_dollar_col_ref_in_col_ref3279);
                    dollar_col_ref398=dollar_col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, dollar_col_ref398.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "col_ref"


    public static class alias_col_ref_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alias_col_ref"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:623:1: alias_col_ref : ( GROUP | CUBE | IDENTIFIER );
    public final AstValidator.alias_col_ref_return alias_col_ref() throws RecognitionException {
        AstValidator.alias_col_ref_return retval = new AstValidator.alias_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set399=null;

        CommonTree set399_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:623:15: ( GROUP | CUBE | IDENTIFIER )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set399=(CommonTree)input.LT(1);

            if ( input.LA(1)==CUBE||input.LA(1)==GROUP||input.LA(1)==IDENTIFIER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set399_tree = (CommonTree)adaptor.dupNode(set399);


                adaptor.addChild(root_0, set399_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "alias_col_ref"


    public static class dollar_col_ref_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dollar_col_ref"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:626:1: dollar_col_ref : DOLLARVAR ;
    public final AstValidator.dollar_col_ref_return dollar_col_ref() throws RecognitionException {
        AstValidator.dollar_col_ref_return retval = new AstValidator.dollar_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR400=null;

        CommonTree DOLLARVAR400_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:626:16: ( DOLLARVAR )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:626:18: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR400=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_dollar_col_ref3305); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR400_tree = (CommonTree)adaptor.dupNode(DOLLARVAR400);


            adaptor.addChild(root_0, DOLLARVAR400_tree);
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "dollar_col_ref"


    public static class const_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "const_expr"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:629:1: const_expr : literal ;
    public final AstValidator.const_expr_return const_expr() throws RecognitionException {
        AstValidator.const_expr_return retval = new AstValidator.const_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.literal_return literal401 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:629:12: ( literal )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:629:14: literal
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_literal_in_const_expr3314);
            literal401=literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, literal401.getTree());


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "const_expr"


    public static class literal_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "literal"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:632:1: literal : ( scalar | map | bag | tuple );
    public final AstValidator.literal_return literal() throws RecognitionException {
        AstValidator.literal_return retval = new AstValidator.literal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AstValidator.scalar_return scalar402 =null;

        AstValidator.map_return map403 =null;

        AstValidator.bag_return bag404 =null;

        AstValidator.tuple_return tuple405 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:632:9: ( scalar | map | bag | tuple )
            int alt113=4;
            switch ( input.LA(1) ) {
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case DOUBLENUMBER:
            case FALSE:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
            case NULL:
            case QUOTEDSTRING:
            case TRUE:
                {
                alt113=1;
                }
                break;
            case MAP_VAL:
                {
                alt113=2;
                }
                break;
            case BAG_VAL:
                {
                alt113=3;
                }
                break;
            case TUPLE_VAL:
                {
                alt113=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 113, 0, input);

                throw nvae;

            }

            switch (alt113) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:632:11: scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_scalar_in_literal3323);
                    scalar402=scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, scalar402.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:632:20: map
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_in_literal3327);
                    map403=map();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map403.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:632:26: bag
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_in_literal3331);
                    bag404=bag();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag404.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:632:32: tuple
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_in_literal3335);
                    tuple405=tuple();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple405.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "literal"


    public static class scalar_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "scalar"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:635:1: scalar : ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE );
    public final AstValidator.scalar_return scalar() throws RecognitionException {
        AstValidator.scalar_return retval = new AstValidator.scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING407=null;
        CommonTree NULL408=null;
        CommonTree TRUE409=null;
        CommonTree FALSE410=null;
        AstValidator.num_scalar_return num_scalar406 =null;


        CommonTree QUOTEDSTRING407_tree=null;
        CommonTree NULL408_tree=null;
        CommonTree TRUE409_tree=null;
        CommonTree FALSE410_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:635:8: ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE )
            int alt114=5;
            switch ( input.LA(1) ) {
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case DOUBLENUMBER:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
                {
                alt114=1;
                }
                break;
            case QUOTEDSTRING:
                {
                alt114=2;
                }
                break;
            case NULL:
                {
                alt114=3;
                }
                break;
            case TRUE:
                {
                alt114=4;
                }
                break;
            case FALSE:
                {
                alt114=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 114, 0, input);

                throw nvae;

            }

            switch (alt114) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:635:10: num_scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_num_scalar_in_scalar3344);
                    num_scalar406=num_scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, num_scalar406.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:635:23: QUOTEDSTRING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING407=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_scalar3348); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING407_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING407);


                    adaptor.addChild(root_0, QUOTEDSTRING407_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:635:38: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL408=(CommonTree)match(input,NULL,FOLLOW_NULL_in_scalar3352); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL408_tree = (CommonTree)adaptor.dupNode(NULL408);


                    adaptor.addChild(root_0, NULL408_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:635:45: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE409=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_scalar3356); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE409_tree = (CommonTree)adaptor.dupNode(TRUE409);


                    adaptor.addChild(root_0, TRUE409_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:635:52: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE410=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_scalar3360); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE410_tree = (CommonTree)adaptor.dupNode(FALSE410);


                    adaptor.addChild(root_0, FALSE410_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "scalar"


    public static class num_scalar_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "num_scalar"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:638:1: num_scalar : ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER ) ;
    public final AstValidator.num_scalar_return num_scalar() throws RecognitionException {
        AstValidator.num_scalar_return retval = new AstValidator.num_scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MINUS411=null;
        CommonTree set412=null;

        CommonTree MINUS411_tree=null;
        CommonTree set412_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:638:12: ( ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:638:14: ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER )
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:638:14: ( MINUS )?
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( (LA115_0==MINUS) ) {
                alt115=1;
            }
            switch (alt115) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:638:14: MINUS
                    {
                    _last = (CommonTree)input.LT(1);
                    MINUS411=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_num_scalar3369); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS411_tree = (CommonTree)adaptor.dupNode(MINUS411);


                    adaptor.addChild(root_0, MINUS411_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            set412=(CommonTree)input.LT(1);

            if ( input.LA(1)==BIGDECIMALNUMBER||input.LA(1)==BIGINTEGERNUMBER||input.LA(1)==DOUBLENUMBER||input.LA(1)==FLOATNUMBER||input.LA(1)==INTEGER||input.LA(1)==LONGINTEGER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set412_tree = (CommonTree)adaptor.dupNode(set412);


                adaptor.addChild(root_0, set412_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "num_scalar"


    public static class map_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:641:1: map : ^( MAP_VAL ( keyvalue )* ) ;
    public final AstValidator.map_return map() throws RecognitionException {
        AstValidator.map_return retval = new AstValidator.map_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_VAL413=null;
        AstValidator.keyvalue_return keyvalue414 =null;


        CommonTree MAP_VAL413_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:641:5: ( ^( MAP_VAL ( keyvalue )* ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:641:7: ^( MAP_VAL ( keyvalue )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_VAL413=(CommonTree)match(input,MAP_VAL,FOLLOW_MAP_VAL_in_map3407); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_VAL413_tree = (CommonTree)adaptor.dupNode(MAP_VAL413);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_VAL413_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:641:18: ( keyvalue )*
                loop116:
                do {
                    int alt116=2;
                    int LA116_0 = input.LA(1);

                    if ( (LA116_0==KEY_VAL_PAIR) ) {
                        alt116=1;
                    }


                    switch (alt116) {
                	case 1 :
                	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:641:18: keyvalue
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_keyvalue_in_map3409);
                	    keyvalue414=keyvalue();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, keyvalue414.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop116;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "map"


    public static class keyvalue_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "keyvalue"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:644:1: keyvalue : ^( KEY_VAL_PAIR map_key const_expr ) ;
    public final AstValidator.keyvalue_return keyvalue() throws RecognitionException {
        AstValidator.keyvalue_return retval = new AstValidator.keyvalue_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree KEY_VAL_PAIR415=null;
        AstValidator.map_key_return map_key416 =null;

        AstValidator.const_expr_return const_expr417 =null;


        CommonTree KEY_VAL_PAIR415_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:644:10: ( ^( KEY_VAL_PAIR map_key const_expr ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:644:12: ^( KEY_VAL_PAIR map_key const_expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            KEY_VAL_PAIR415=(CommonTree)match(input,KEY_VAL_PAIR,FOLLOW_KEY_VAL_PAIR_in_keyvalue3423); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            KEY_VAL_PAIR415_tree = (CommonTree)adaptor.dupNode(KEY_VAL_PAIR415);


            root_1 = (CommonTree)adaptor.becomeRoot(KEY_VAL_PAIR415_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_map_key_in_keyvalue3425);
            map_key416=map_key();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, map_key416.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_const_expr_in_keyvalue3427);
            const_expr417=const_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, const_expr417.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "keyvalue"


    public static class map_key_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map_key"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:647:1: map_key : QUOTEDSTRING ;
    public final AstValidator.map_key_return map_key() throws RecognitionException {
        AstValidator.map_key_return retval = new AstValidator.map_key_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING418=null;

        CommonTree QUOTEDSTRING418_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:647:9: ( QUOTEDSTRING )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:647:11: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING418=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_map_key3438); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING418_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING418);


            adaptor.addChild(root_0, QUOTEDSTRING418_tree);
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "map_key"


    public static class bag_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:650:1: bag : ^( BAG_VAL ( tuple )* ) ;
    public final AstValidator.bag_return bag() throws RecognitionException {
        AstValidator.bag_return retval = new AstValidator.bag_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_VAL419=null;
        AstValidator.tuple_return tuple420 =null;


        CommonTree BAG_VAL419_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:650:5: ( ^( BAG_VAL ( tuple )* ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:650:7: ^( BAG_VAL ( tuple )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_VAL419=(CommonTree)match(input,BAG_VAL,FOLLOW_BAG_VAL_in_bag3449); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_VAL419_tree = (CommonTree)adaptor.dupNode(BAG_VAL419);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_VAL419_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:650:18: ( tuple )*
                loop117:
                do {
                    int alt117=2;
                    int LA117_0 = input.LA(1);

                    if ( (LA117_0==TUPLE_VAL) ) {
                        alt117=1;
                    }


                    switch (alt117) {
                	case 1 :
                	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:650:18: tuple
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_tuple_in_bag3451);
                	    tuple420=tuple();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, tuple420.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop117;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "bag"


    public static class tuple_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:653:1: tuple : ^( TUPLE_VAL ( literal )* ) ;
    public final AstValidator.tuple_return tuple() throws RecognitionException {
        AstValidator.tuple_return retval = new AstValidator.tuple_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_VAL421=null;
        AstValidator.literal_return literal422 =null;


        CommonTree TUPLE_VAL421_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:653:7: ( ^( TUPLE_VAL ( literal )* ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:653:9: ^( TUPLE_VAL ( literal )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_VAL421=(CommonTree)match(input,TUPLE_VAL,FOLLOW_TUPLE_VAL_in_tuple3465); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_VAL421_tree = (CommonTree)adaptor.dupNode(TUPLE_VAL421);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_VAL421_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:653:22: ( literal )*
                loop118:
                do {
                    int alt118=2;
                    int LA118_0 = input.LA(1);

                    if ( (LA118_0==BIGDECIMALNUMBER||LA118_0==BIGINTEGERNUMBER||LA118_0==DOUBLENUMBER||LA118_0==FALSE||LA118_0==FLOATNUMBER||LA118_0==INTEGER||LA118_0==LONGINTEGER||LA118_0==MINUS||LA118_0==NULL||LA118_0==QUOTEDSTRING||LA118_0==TRUE||LA118_0==BAG_VAL||LA118_0==MAP_VAL||LA118_0==TUPLE_VAL) ) {
                        alt118=1;
                    }


                    switch (alt118) {
                	case 1 :
                	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:653:22: literal
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_literal_in_tuple3467);
                	    literal422=literal();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, literal422.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop118;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tuple"


    public static class eid_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "eid"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:657:1: eid : ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | CUBE | ROLLUP | MATCHES | ORDER | RANK | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE | ASSERT );
    public final AstValidator.eid_return eid() throws RecognitionException {
        AstValidator.eid_return retval = new AstValidator.eid_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IMPORT424=null;
        CommonTree RETURNS425=null;
        CommonTree DEFINE426=null;
        CommonTree LOAD427=null;
        CommonTree FILTER428=null;
        CommonTree FOREACH429=null;
        CommonTree CUBE430=null;
        CommonTree ROLLUP431=null;
        CommonTree MATCHES432=null;
        CommonTree ORDER433=null;
        CommonTree RANK434=null;
        CommonTree DISTINCT435=null;
        CommonTree COGROUP436=null;
        CommonTree JOIN437=null;
        CommonTree CROSS438=null;
        CommonTree UNION439=null;
        CommonTree SPLIT440=null;
        CommonTree INTO441=null;
        CommonTree IF442=null;
        CommonTree ALL443=null;
        CommonTree AS444=null;
        CommonTree BY445=null;
        CommonTree USING446=null;
        CommonTree INNER447=null;
        CommonTree OUTER448=null;
        CommonTree PARALLEL449=null;
        CommonTree PARTITION450=null;
        CommonTree GROUP451=null;
        CommonTree AND452=null;
        CommonTree OR453=null;
        CommonTree NOT454=null;
        CommonTree GENERATE455=null;
        CommonTree FLATTEN456=null;
        CommonTree EVAL457=null;
        CommonTree ASC458=null;
        CommonTree DESC459=null;
        CommonTree BOOLEAN460=null;
        CommonTree INT461=null;
        CommonTree LONG462=null;
        CommonTree FLOAT463=null;
        CommonTree DOUBLE464=null;
        CommonTree BIGINTEGER465=null;
        CommonTree BIGDECIMAL466=null;
        CommonTree DATETIME467=null;
        CommonTree CHARARRAY468=null;
        CommonTree BYTEARRAY469=null;
        CommonTree BAG470=null;
        CommonTree TUPLE471=null;
        CommonTree MAP472=null;
        CommonTree IS473=null;
        CommonTree NULL474=null;
        CommonTree TRUE475=null;
        CommonTree FALSE476=null;
        CommonTree STREAM477=null;
        CommonTree THROUGH478=null;
        CommonTree STORE479=null;
        CommonTree MAPREDUCE480=null;
        CommonTree SHIP481=null;
        CommonTree CACHE482=null;
        CommonTree INPUT483=null;
        CommonTree OUTPUT484=null;
        CommonTree STDERROR485=null;
        CommonTree STDIN486=null;
        CommonTree STDOUT487=null;
        CommonTree LIMIT488=null;
        CommonTree SAMPLE489=null;
        CommonTree LEFT490=null;
        CommonTree RIGHT491=null;
        CommonTree FULL492=null;
        CommonTree IDENTIFIER493=null;
        CommonTree TOBAG494=null;
        CommonTree TOMAP495=null;
        CommonTree TOTUPLE496=null;
        CommonTree ASSERT497=null;
        AstValidator.rel_str_op_return rel_str_op423 =null;


        CommonTree IMPORT424_tree=null;
        CommonTree RETURNS425_tree=null;
        CommonTree DEFINE426_tree=null;
        CommonTree LOAD427_tree=null;
        CommonTree FILTER428_tree=null;
        CommonTree FOREACH429_tree=null;
        CommonTree CUBE430_tree=null;
        CommonTree ROLLUP431_tree=null;
        CommonTree MATCHES432_tree=null;
        CommonTree ORDER433_tree=null;
        CommonTree RANK434_tree=null;
        CommonTree DISTINCT435_tree=null;
        CommonTree COGROUP436_tree=null;
        CommonTree JOIN437_tree=null;
        CommonTree CROSS438_tree=null;
        CommonTree UNION439_tree=null;
        CommonTree SPLIT440_tree=null;
        CommonTree INTO441_tree=null;
        CommonTree IF442_tree=null;
        CommonTree ALL443_tree=null;
        CommonTree AS444_tree=null;
        CommonTree BY445_tree=null;
        CommonTree USING446_tree=null;
        CommonTree INNER447_tree=null;
        CommonTree OUTER448_tree=null;
        CommonTree PARALLEL449_tree=null;
        CommonTree PARTITION450_tree=null;
        CommonTree GROUP451_tree=null;
        CommonTree AND452_tree=null;
        CommonTree OR453_tree=null;
        CommonTree NOT454_tree=null;
        CommonTree GENERATE455_tree=null;
        CommonTree FLATTEN456_tree=null;
        CommonTree EVAL457_tree=null;
        CommonTree ASC458_tree=null;
        CommonTree DESC459_tree=null;
        CommonTree BOOLEAN460_tree=null;
        CommonTree INT461_tree=null;
        CommonTree LONG462_tree=null;
        CommonTree FLOAT463_tree=null;
        CommonTree DOUBLE464_tree=null;
        CommonTree BIGINTEGER465_tree=null;
        CommonTree BIGDECIMAL466_tree=null;
        CommonTree DATETIME467_tree=null;
        CommonTree CHARARRAY468_tree=null;
        CommonTree BYTEARRAY469_tree=null;
        CommonTree BAG470_tree=null;
        CommonTree TUPLE471_tree=null;
        CommonTree MAP472_tree=null;
        CommonTree IS473_tree=null;
        CommonTree NULL474_tree=null;
        CommonTree TRUE475_tree=null;
        CommonTree FALSE476_tree=null;
        CommonTree STREAM477_tree=null;
        CommonTree THROUGH478_tree=null;
        CommonTree STORE479_tree=null;
        CommonTree MAPREDUCE480_tree=null;
        CommonTree SHIP481_tree=null;
        CommonTree CACHE482_tree=null;
        CommonTree INPUT483_tree=null;
        CommonTree OUTPUT484_tree=null;
        CommonTree STDERROR485_tree=null;
        CommonTree STDIN486_tree=null;
        CommonTree STDOUT487_tree=null;
        CommonTree LIMIT488_tree=null;
        CommonTree SAMPLE489_tree=null;
        CommonTree LEFT490_tree=null;
        CommonTree RIGHT491_tree=null;
        CommonTree FULL492_tree=null;
        CommonTree IDENTIFIER493_tree=null;
        CommonTree TOBAG494_tree=null;
        CommonTree TOMAP495_tree=null;
        CommonTree TOTUPLE496_tree=null;
        CommonTree ASSERT497_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:657:5: ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | CUBE | ROLLUP | MATCHES | ORDER | RANK | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE | ASSERT )
            int alt119=75;
            switch ( input.LA(1) ) {
            case STR_OP_EQ:
            case STR_OP_GT:
            case STR_OP_GTE:
            case STR_OP_LT:
            case STR_OP_LTE:
            case STR_OP_MATCHES:
            case STR_OP_NE:
                {
                alt119=1;
                }
                break;
            case IMPORT:
                {
                alt119=2;
                }
                break;
            case RETURNS:
                {
                alt119=3;
                }
                break;
            case DEFINE:
                {
                alt119=4;
                }
                break;
            case LOAD:
                {
                alt119=5;
                }
                break;
            case FILTER:
                {
                alt119=6;
                }
                break;
            case FOREACH:
                {
                alt119=7;
                }
                break;
            case CUBE:
                {
                alt119=8;
                }
                break;
            case ROLLUP:
                {
                alt119=9;
                }
                break;
            case MATCHES:
                {
                alt119=10;
                }
                break;
            case ORDER:
                {
                alt119=11;
                }
                break;
            case RANK:
                {
                alt119=12;
                }
                break;
            case DISTINCT:
                {
                alt119=13;
                }
                break;
            case COGROUP:
                {
                alt119=14;
                }
                break;
            case JOIN:
                {
                alt119=15;
                }
                break;
            case CROSS:
                {
                alt119=16;
                }
                break;
            case UNION:
                {
                alt119=17;
                }
                break;
            case SPLIT:
                {
                alt119=18;
                }
                break;
            case INTO:
                {
                alt119=19;
                }
                break;
            case IF:
                {
                alt119=20;
                }
                break;
            case ALL:
                {
                alt119=21;
                }
                break;
            case AS:
                {
                alt119=22;
                }
                break;
            case BY:
                {
                alt119=23;
                }
                break;
            case USING:
                {
                alt119=24;
                }
                break;
            case INNER:
                {
                alt119=25;
                }
                break;
            case OUTER:
                {
                alt119=26;
                }
                break;
            case PARALLEL:
                {
                alt119=27;
                }
                break;
            case PARTITION:
                {
                alt119=28;
                }
                break;
            case GROUP:
                {
                alt119=29;
                }
                break;
            case AND:
                {
                alt119=30;
                }
                break;
            case OR:
                {
                alt119=31;
                }
                break;
            case NOT:
                {
                alt119=32;
                }
                break;
            case GENERATE:
                {
                alt119=33;
                }
                break;
            case FLATTEN:
                {
                alt119=34;
                }
                break;
            case EVAL:
                {
                alt119=35;
                }
                break;
            case ASC:
                {
                alt119=36;
                }
                break;
            case DESC:
                {
                alt119=37;
                }
                break;
            case BOOLEAN:
                {
                alt119=38;
                }
                break;
            case INT:
                {
                alt119=39;
                }
                break;
            case LONG:
                {
                alt119=40;
                }
                break;
            case FLOAT:
                {
                alt119=41;
                }
                break;
            case DOUBLE:
                {
                alt119=42;
                }
                break;
            case BIGINTEGER:
                {
                alt119=43;
                }
                break;
            case BIGDECIMAL:
                {
                alt119=44;
                }
                break;
            case DATETIME:
                {
                alt119=45;
                }
                break;
            case CHARARRAY:
                {
                alt119=46;
                }
                break;
            case BYTEARRAY:
                {
                alt119=47;
                }
                break;
            case BAG:
                {
                alt119=48;
                }
                break;
            case TUPLE:
                {
                alt119=49;
                }
                break;
            case MAP:
                {
                alt119=50;
                }
                break;
            case IS:
                {
                alt119=51;
                }
                break;
            case NULL:
                {
                alt119=52;
                }
                break;
            case TRUE:
                {
                alt119=53;
                }
                break;
            case FALSE:
                {
                alt119=54;
                }
                break;
            case STREAM:
                {
                alt119=55;
                }
                break;
            case THROUGH:
                {
                alt119=56;
                }
                break;
            case STORE:
                {
                alt119=57;
                }
                break;
            case MAPREDUCE:
                {
                alt119=58;
                }
                break;
            case SHIP:
                {
                alt119=59;
                }
                break;
            case CACHE:
                {
                alt119=60;
                }
                break;
            case INPUT:
                {
                alt119=61;
                }
                break;
            case OUTPUT:
                {
                alt119=62;
                }
                break;
            case STDERROR:
                {
                alt119=63;
                }
                break;
            case STDIN:
                {
                alt119=64;
                }
                break;
            case STDOUT:
                {
                alt119=65;
                }
                break;
            case LIMIT:
                {
                alt119=66;
                }
                break;
            case SAMPLE:
                {
                alt119=67;
                }
                break;
            case LEFT:
                {
                alt119=68;
                }
                break;
            case RIGHT:
                {
                alt119=69;
                }
                break;
            case FULL:
                {
                alt119=70;
                }
                break;
            case IDENTIFIER:
                {
                alt119=71;
                }
                break;
            case TOBAG:
                {
                alt119=72;
                }
                break;
            case TOMAP:
                {
                alt119=73;
                }
                break;
            case TOTUPLE:
                {
                alt119=74;
                }
                break;
            case ASSERT:
                {
                alt119=75;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 119, 0, input);

                throw nvae;

            }

            switch (alt119) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:657:7: rel_str_op
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_str_op_in_eid3480);
                    rel_str_op423=rel_str_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_str_op423.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:658:7: IMPORT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IMPORT424=(CommonTree)match(input,IMPORT,FOLLOW_IMPORT_in_eid3488); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IMPORT424_tree = (CommonTree)adaptor.dupNode(IMPORT424);


                    adaptor.addChild(root_0, IMPORT424_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:659:7: RETURNS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RETURNS425=(CommonTree)match(input,RETURNS,FOLLOW_RETURNS_in_eid3496); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RETURNS425_tree = (CommonTree)adaptor.dupNode(RETURNS425);


                    adaptor.addChild(root_0, RETURNS425_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:660:7: DEFINE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DEFINE426=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_eid3504); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINE426_tree = (CommonTree)adaptor.dupNode(DEFINE426);


                    adaptor.addChild(root_0, DEFINE426_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:661:7: LOAD
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LOAD427=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_eid3512); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LOAD427_tree = (CommonTree)adaptor.dupNode(LOAD427);


                    adaptor.addChild(root_0, LOAD427_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:662:7: FILTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FILTER428=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_eid3520); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FILTER428_tree = (CommonTree)adaptor.dupNode(FILTER428);


                    adaptor.addChild(root_0, FILTER428_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:663:7: FOREACH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FOREACH429=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_eid3528); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH429_tree = (CommonTree)adaptor.dupNode(FOREACH429);


                    adaptor.addChild(root_0, FOREACH429_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:664:7: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE430=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_eid3536); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE430_tree = (CommonTree)adaptor.dupNode(CUBE430);


                    adaptor.addChild(root_0, CUBE430_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:665:7: ROLLUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ROLLUP431=(CommonTree)match(input,ROLLUP,FOLLOW_ROLLUP_in_eid3544); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ROLLUP431_tree = (CommonTree)adaptor.dupNode(ROLLUP431);


                    adaptor.addChild(root_0, ROLLUP431_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:666:7: MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MATCHES432=(CommonTree)match(input,MATCHES,FOLLOW_MATCHES_in_eid3552); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MATCHES432_tree = (CommonTree)adaptor.dupNode(MATCHES432);


                    adaptor.addChild(root_0, MATCHES432_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:667:7: ORDER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ORDER433=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_eid3560); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ORDER433_tree = (CommonTree)adaptor.dupNode(ORDER433);


                    adaptor.addChild(root_0, ORDER433_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:668:7: RANK
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RANK434=(CommonTree)match(input,RANK,FOLLOW_RANK_in_eid3568); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RANK434_tree = (CommonTree)adaptor.dupNode(RANK434);


                    adaptor.addChild(root_0, RANK434_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:669:7: DISTINCT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DISTINCT435=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_eid3576); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DISTINCT435_tree = (CommonTree)adaptor.dupNode(DISTINCT435);


                    adaptor.addChild(root_0, DISTINCT435_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:670:7: COGROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    COGROUP436=(CommonTree)match(input,COGROUP,FOLLOW_COGROUP_in_eid3584); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COGROUP436_tree = (CommonTree)adaptor.dupNode(COGROUP436);


                    adaptor.addChild(root_0, COGROUP436_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:671:7: JOIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    JOIN437=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_eid3592); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    JOIN437_tree = (CommonTree)adaptor.dupNode(JOIN437);


                    adaptor.addChild(root_0, JOIN437_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:672:7: CROSS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CROSS438=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_eid3600); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CROSS438_tree = (CommonTree)adaptor.dupNode(CROSS438);


                    adaptor.addChild(root_0, CROSS438_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:673:7: UNION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    UNION439=(CommonTree)match(input,UNION,FOLLOW_UNION_in_eid3608); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    UNION439_tree = (CommonTree)adaptor.dupNode(UNION439);


                    adaptor.addChild(root_0, UNION439_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:674:7: SPLIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SPLIT440=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_eid3616); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SPLIT440_tree = (CommonTree)adaptor.dupNode(SPLIT440);


                    adaptor.addChild(root_0, SPLIT440_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 19 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:675:7: INTO
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INTO441=(CommonTree)match(input,INTO,FOLLOW_INTO_in_eid3624); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTO441_tree = (CommonTree)adaptor.dupNode(INTO441);


                    adaptor.addChild(root_0, INTO441_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 20 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:676:7: IF
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IF442=(CommonTree)match(input,IF,FOLLOW_IF_in_eid3632); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IF442_tree = (CommonTree)adaptor.dupNode(IF442);


                    adaptor.addChild(root_0, IF442_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 21 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:677:7: ALL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ALL443=(CommonTree)match(input,ALL,FOLLOW_ALL_in_eid3640); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL443_tree = (CommonTree)adaptor.dupNode(ALL443);


                    adaptor.addChild(root_0, ALL443_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 22 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:678:7: AS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AS444=(CommonTree)match(input,AS,FOLLOW_AS_in_eid3648); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AS444_tree = (CommonTree)adaptor.dupNode(AS444);


                    adaptor.addChild(root_0, AS444_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 23 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:679:7: BY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BY445=(CommonTree)match(input,BY,FOLLOW_BY_in_eid3656); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BY445_tree = (CommonTree)adaptor.dupNode(BY445);


                    adaptor.addChild(root_0, BY445_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 24 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:680:7: USING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    USING446=(CommonTree)match(input,USING,FOLLOW_USING_in_eid3664); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    USING446_tree = (CommonTree)adaptor.dupNode(USING446);


                    adaptor.addChild(root_0, USING446_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 25 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:681:7: INNER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INNER447=(CommonTree)match(input,INNER,FOLLOW_INNER_in_eid3672); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INNER447_tree = (CommonTree)adaptor.dupNode(INNER447);


                    adaptor.addChild(root_0, INNER447_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 26 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:682:7: OUTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTER448=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_eid3680); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTER448_tree = (CommonTree)adaptor.dupNode(OUTER448);


                    adaptor.addChild(root_0, OUTER448_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 27 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:683:7: PARALLEL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARALLEL449=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_eid3688); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARALLEL449_tree = (CommonTree)adaptor.dupNode(PARALLEL449);


                    adaptor.addChild(root_0, PARALLEL449_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 28 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:684:7: PARTITION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARTITION450=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_eid3696); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARTITION450_tree = (CommonTree)adaptor.dupNode(PARTITION450);


                    adaptor.addChild(root_0, PARTITION450_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 29 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:685:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP451=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_eid3704); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP451_tree = (CommonTree)adaptor.dupNode(GROUP451);


                    adaptor.addChild(root_0, GROUP451_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 30 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:686:7: AND
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AND452=(CommonTree)match(input,AND,FOLLOW_AND_in_eid3712); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND452_tree = (CommonTree)adaptor.dupNode(AND452);


                    adaptor.addChild(root_0, AND452_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 31 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:687:7: OR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OR453=(CommonTree)match(input,OR,FOLLOW_OR_in_eid3720); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR453_tree = (CommonTree)adaptor.dupNode(OR453);


                    adaptor.addChild(root_0, OR453_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 32 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:688:7: NOT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NOT454=(CommonTree)match(input,NOT,FOLLOW_NOT_in_eid3728); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT454_tree = (CommonTree)adaptor.dupNode(NOT454);


                    adaptor.addChild(root_0, NOT454_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 33 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:689:7: GENERATE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GENERATE455=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_eid3736); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GENERATE455_tree = (CommonTree)adaptor.dupNode(GENERATE455);


                    adaptor.addChild(root_0, GENERATE455_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 34 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:690:7: FLATTEN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLATTEN456=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_eid3744); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLATTEN456_tree = (CommonTree)adaptor.dupNode(FLATTEN456);


                    adaptor.addChild(root_0, FLATTEN456_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 35 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:691:7: EVAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    EVAL457=(CommonTree)match(input,EVAL,FOLLOW_EVAL_in_eid3752); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EVAL457_tree = (CommonTree)adaptor.dupNode(EVAL457);


                    adaptor.addChild(root_0, EVAL457_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 36 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:692:7: ASC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ASC458=(CommonTree)match(input,ASC,FOLLOW_ASC_in_eid3760); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASC458_tree = (CommonTree)adaptor.dupNode(ASC458);


                    adaptor.addChild(root_0, ASC458_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 37 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:693:7: DESC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DESC459=(CommonTree)match(input,DESC,FOLLOW_DESC_in_eid3768); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DESC459_tree = (CommonTree)adaptor.dupNode(DESC459);


                    adaptor.addChild(root_0, DESC459_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 38 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:694:7: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN460=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_eid3776); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN460_tree = (CommonTree)adaptor.dupNode(BOOLEAN460);


                    adaptor.addChild(root_0, BOOLEAN460_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 39 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:695:7: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT461=(CommonTree)match(input,INT,FOLLOW_INT_in_eid3784); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT461_tree = (CommonTree)adaptor.dupNode(INT461);


                    adaptor.addChild(root_0, INT461_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 40 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:696:7: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG462=(CommonTree)match(input,LONG,FOLLOW_LONG_in_eid3792); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG462_tree = (CommonTree)adaptor.dupNode(LONG462);


                    adaptor.addChild(root_0, LONG462_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 41 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:697:7: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT463=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_eid3800); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT463_tree = (CommonTree)adaptor.dupNode(FLOAT463);


                    adaptor.addChild(root_0, FLOAT463_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 42 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:698:7: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE464=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_eid3808); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE464_tree = (CommonTree)adaptor.dupNode(DOUBLE464);


                    adaptor.addChild(root_0, DOUBLE464_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 43 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:699:7: BIGINTEGER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGINTEGER465=(CommonTree)match(input,BIGINTEGER,FOLLOW_BIGINTEGER_in_eid3816); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGINTEGER465_tree = (CommonTree)adaptor.dupNode(BIGINTEGER465);


                    adaptor.addChild(root_0, BIGINTEGER465_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 44 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:700:7: BIGDECIMAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGDECIMAL466=(CommonTree)match(input,BIGDECIMAL,FOLLOW_BIGDECIMAL_in_eid3824); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGDECIMAL466_tree = (CommonTree)adaptor.dupNode(BIGDECIMAL466);


                    adaptor.addChild(root_0, BIGDECIMAL466_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 45 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:701:7: DATETIME
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DATETIME467=(CommonTree)match(input,DATETIME,FOLLOW_DATETIME_in_eid3832); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DATETIME467_tree = (CommonTree)adaptor.dupNode(DATETIME467);


                    adaptor.addChild(root_0, DATETIME467_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 46 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:702:7: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY468=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_eid3840); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY468_tree = (CommonTree)adaptor.dupNode(CHARARRAY468);


                    adaptor.addChild(root_0, CHARARRAY468_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 47 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:703:7: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY469=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_eid3848); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY469_tree = (CommonTree)adaptor.dupNode(BYTEARRAY469);


                    adaptor.addChild(root_0, BYTEARRAY469_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 48 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:704:7: BAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BAG470=(CommonTree)match(input,BAG,FOLLOW_BAG_in_eid3856); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BAG470_tree = (CommonTree)adaptor.dupNode(BAG470);


                    adaptor.addChild(root_0, BAG470_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 49 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:705:7: TUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TUPLE471=(CommonTree)match(input,TUPLE,FOLLOW_TUPLE_in_eid3864); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE471_tree = (CommonTree)adaptor.dupNode(TUPLE471);


                    adaptor.addChild(root_0, TUPLE471_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 50 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:706:7: MAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAP472=(CommonTree)match(input,MAP,FOLLOW_MAP_in_eid3872); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAP472_tree = (CommonTree)adaptor.dupNode(MAP472);


                    adaptor.addChild(root_0, MAP472_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 51 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:707:7: IS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IS473=(CommonTree)match(input,IS,FOLLOW_IS_in_eid3880); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IS473_tree = (CommonTree)adaptor.dupNode(IS473);


                    adaptor.addChild(root_0, IS473_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 52 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:708:7: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL474=(CommonTree)match(input,NULL,FOLLOW_NULL_in_eid3888); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL474_tree = (CommonTree)adaptor.dupNode(NULL474);


                    adaptor.addChild(root_0, NULL474_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 53 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:709:7: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE475=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_eid3896); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE475_tree = (CommonTree)adaptor.dupNode(TRUE475);


                    adaptor.addChild(root_0, TRUE475_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 54 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:710:7: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE476=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_eid3904); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE476_tree = (CommonTree)adaptor.dupNode(FALSE476);


                    adaptor.addChild(root_0, FALSE476_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 55 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:711:7: STREAM
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STREAM477=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_eid3912); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STREAM477_tree = (CommonTree)adaptor.dupNode(STREAM477);


                    adaptor.addChild(root_0, STREAM477_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 56 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:712:7: THROUGH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    THROUGH478=(CommonTree)match(input,THROUGH,FOLLOW_THROUGH_in_eid3920); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    THROUGH478_tree = (CommonTree)adaptor.dupNode(THROUGH478);


                    adaptor.addChild(root_0, THROUGH478_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 57 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:713:7: STORE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STORE479=(CommonTree)match(input,STORE,FOLLOW_STORE_in_eid3928); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STORE479_tree = (CommonTree)adaptor.dupNode(STORE479);


                    adaptor.addChild(root_0, STORE479_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 58 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:714:7: MAPREDUCE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAPREDUCE480=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_eid3936); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAPREDUCE480_tree = (CommonTree)adaptor.dupNode(MAPREDUCE480);


                    adaptor.addChild(root_0, MAPREDUCE480_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 59 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:715:7: SHIP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SHIP481=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_eid3944); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SHIP481_tree = (CommonTree)adaptor.dupNode(SHIP481);


                    adaptor.addChild(root_0, SHIP481_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 60 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:716:7: CACHE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CACHE482=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_eid3952); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CACHE482_tree = (CommonTree)adaptor.dupNode(CACHE482);


                    adaptor.addChild(root_0, CACHE482_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 61 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:717:7: INPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INPUT483=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_eid3960); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INPUT483_tree = (CommonTree)adaptor.dupNode(INPUT483);


                    adaptor.addChild(root_0, INPUT483_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 62 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:718:7: OUTPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTPUT484=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_eid3968); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTPUT484_tree = (CommonTree)adaptor.dupNode(OUTPUT484);


                    adaptor.addChild(root_0, OUTPUT484_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 63 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:719:7: STDERROR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDERROR485=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_eid3976); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDERROR485_tree = (CommonTree)adaptor.dupNode(STDERROR485);


                    adaptor.addChild(root_0, STDERROR485_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 64 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:720:7: STDIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDIN486=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_eid3984); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN486_tree = (CommonTree)adaptor.dupNode(STDIN486);


                    adaptor.addChild(root_0, STDIN486_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 65 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:721:7: STDOUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDOUT487=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_eid3992); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT487_tree = (CommonTree)adaptor.dupNode(STDOUT487);


                    adaptor.addChild(root_0, STDOUT487_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 66 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:722:7: LIMIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LIMIT488=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_eid4000); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LIMIT488_tree = (CommonTree)adaptor.dupNode(LIMIT488);


                    adaptor.addChild(root_0, LIMIT488_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 67 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:723:7: SAMPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SAMPLE489=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_eid4008); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SAMPLE489_tree = (CommonTree)adaptor.dupNode(SAMPLE489);


                    adaptor.addChild(root_0, SAMPLE489_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 68 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:724:7: LEFT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LEFT490=(CommonTree)match(input,LEFT,FOLLOW_LEFT_in_eid4016); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LEFT490_tree = (CommonTree)adaptor.dupNode(LEFT490);


                    adaptor.addChild(root_0, LEFT490_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 69 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:725:7: RIGHT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RIGHT491=(CommonTree)match(input,RIGHT,FOLLOW_RIGHT_in_eid4024); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RIGHT491_tree = (CommonTree)adaptor.dupNode(RIGHT491);


                    adaptor.addChild(root_0, RIGHT491_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 70 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:726:7: FULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FULL492=(CommonTree)match(input,FULL,FOLLOW_FULL_in_eid4032); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FULL492_tree = (CommonTree)adaptor.dupNode(FULL492);


                    adaptor.addChild(root_0, FULL492_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 71 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:727:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER493=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_eid4040); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER493_tree = (CommonTree)adaptor.dupNode(IDENTIFIER493);


                    adaptor.addChild(root_0, IDENTIFIER493_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 72 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:728:7: TOBAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOBAG494=(CommonTree)match(input,TOBAG,FOLLOW_TOBAG_in_eid4048); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOBAG494_tree = (CommonTree)adaptor.dupNode(TOBAG494);


                    adaptor.addChild(root_0, TOBAG494_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 73 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:729:7: TOMAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOMAP495=(CommonTree)match(input,TOMAP,FOLLOW_TOMAP_in_eid4056); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOMAP495_tree = (CommonTree)adaptor.dupNode(TOMAP495);


                    adaptor.addChild(root_0, TOMAP495_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 74 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:730:7: TOTUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOTUPLE496=(CommonTree)match(input,TOTUPLE,FOLLOW_TOTUPLE_in_eid4064); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOTUPLE496_tree = (CommonTree)adaptor.dupNode(TOTUPLE496);


                    adaptor.addChild(root_0, TOTUPLE496_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 75 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:731:7: ASSERT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ASSERT497=(CommonTree)match(input,ASSERT,FOLLOW_ASSERT_in_eid4072); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASSERT497_tree = (CommonTree)adaptor.dupNode(ASSERT497);


                    adaptor.addChild(root_0, ASSERT497_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "eid"


    public static class rel_op_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:735:1: rel_op : ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES );
    public final AstValidator.rel_op_return rel_op() throws RecognitionException {
        AstValidator.rel_op_return retval = new AstValidator.rel_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_MATCHES504=null;
        AstValidator.rel_op_eq_return rel_op_eq498 =null;

        AstValidator.rel_op_ne_return rel_op_ne499 =null;

        AstValidator.rel_op_gt_return rel_op_gt500 =null;

        AstValidator.rel_op_gte_return rel_op_gte501 =null;

        AstValidator.rel_op_lt_return rel_op_lt502 =null;

        AstValidator.rel_op_lte_return rel_op_lte503 =null;


        CommonTree STR_OP_MATCHES504_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:735:8: ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES )
            int alt120=7;
            switch ( input.LA(1) ) {
            case NUM_OP_EQ:
            case STR_OP_EQ:
                {
                alt120=1;
                }
                break;
            case NUM_OP_NE:
            case STR_OP_NE:
                {
                alt120=2;
                }
                break;
            case NUM_OP_GT:
            case STR_OP_GT:
                {
                alt120=3;
                }
                break;
            case NUM_OP_GTE:
            case STR_OP_GTE:
                {
                alt120=4;
                }
                break;
            case NUM_OP_LT:
            case STR_OP_LT:
                {
                alt120=5;
                }
                break;
            case NUM_OP_LTE:
            case STR_OP_LTE:
                {
                alt120=6;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt120=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 120, 0, input);

                throw nvae;

            }

            switch (alt120) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:735:10: rel_op_eq
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_eq_in_rel_op4082);
                    rel_op_eq498=rel_op_eq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_eq498.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:736:10: rel_op_ne
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_ne_in_rel_op4093);
                    rel_op_ne499=rel_op_ne();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_ne499.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:737:10: rel_op_gt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gt_in_rel_op4104);
                    rel_op_gt500=rel_op_gt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gt500.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:738:10: rel_op_gte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gte_in_rel_op4115);
                    rel_op_gte501=rel_op_gte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gte501.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:739:10: rel_op_lt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lt_in_rel_op4126);
                    rel_op_lt502=rel_op_lt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lt502.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:740:10: rel_op_lte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lte_in_rel_op4137);
                    rel_op_lte503=rel_op_lte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lte503.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:741:10: STR_OP_MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES504=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_rel_op4148); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES504_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES504);


                    adaptor.addChild(root_0, STR_OP_MATCHES504_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op"


    public static class rel_op_eq_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_eq"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:744:1: rel_op_eq : ( STR_OP_EQ | NUM_OP_EQ );
    public final AstValidator.rel_op_eq_return rel_op_eq() throws RecognitionException {
        AstValidator.rel_op_eq_return retval = new AstValidator.rel_op_eq_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set505=null;

        CommonTree set505_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:744:11: ( STR_OP_EQ | NUM_OP_EQ )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set505=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_EQ||input.LA(1)==STR_OP_EQ ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set505_tree = (CommonTree)adaptor.dupNode(set505);


                adaptor.addChild(root_0, set505_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_eq"


    public static class rel_op_ne_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_ne"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:747:1: rel_op_ne : ( STR_OP_NE | NUM_OP_NE );
    public final AstValidator.rel_op_ne_return rel_op_ne() throws RecognitionException {
        AstValidator.rel_op_ne_return retval = new AstValidator.rel_op_ne_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set506=null;

        CommonTree set506_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:747:11: ( STR_OP_NE | NUM_OP_NE )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set506=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_NE||input.LA(1)==STR_OP_NE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set506_tree = (CommonTree)adaptor.dupNode(set506);


                adaptor.addChild(root_0, set506_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_ne"


    public static class rel_op_gt_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_gt"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:750:1: rel_op_gt : ( STR_OP_GT | NUM_OP_GT );
    public final AstValidator.rel_op_gt_return rel_op_gt() throws RecognitionException {
        AstValidator.rel_op_gt_return retval = new AstValidator.rel_op_gt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set507=null;

        CommonTree set507_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:750:11: ( STR_OP_GT | NUM_OP_GT )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set507=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GT||input.LA(1)==STR_OP_GT ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set507_tree = (CommonTree)adaptor.dupNode(set507);


                adaptor.addChild(root_0, set507_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_gt"


    public static class rel_op_gte_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_gte"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:753:1: rel_op_gte : ( STR_OP_GTE | NUM_OP_GTE );
    public final AstValidator.rel_op_gte_return rel_op_gte() throws RecognitionException {
        AstValidator.rel_op_gte_return retval = new AstValidator.rel_op_gte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set508=null;

        CommonTree set508_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:753:12: ( STR_OP_GTE | NUM_OP_GTE )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set508=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GTE||input.LA(1)==STR_OP_GTE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set508_tree = (CommonTree)adaptor.dupNode(set508);


                adaptor.addChild(root_0, set508_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_gte"


    public static class rel_op_lt_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_lt"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:756:1: rel_op_lt : ( STR_OP_LT | NUM_OP_LT );
    public final AstValidator.rel_op_lt_return rel_op_lt() throws RecognitionException {
        AstValidator.rel_op_lt_return retval = new AstValidator.rel_op_lt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set509=null;

        CommonTree set509_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:756:11: ( STR_OP_LT | NUM_OP_LT )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set509=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LT||input.LA(1)==STR_OP_LT ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set509_tree = (CommonTree)adaptor.dupNode(set509);


                adaptor.addChild(root_0, set509_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_lt"


    public static class rel_op_lte_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_op_lte"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:759:1: rel_op_lte : ( STR_OP_LTE | NUM_OP_LTE );
    public final AstValidator.rel_op_lte_return rel_op_lte() throws RecognitionException {
        AstValidator.rel_op_lte_return retval = new AstValidator.rel_op_lte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set510=null;

        CommonTree set510_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:759:12: ( STR_OP_LTE | NUM_OP_LTE )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set510=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LTE||input.LA(1)==STR_OP_LTE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set510_tree = (CommonTree)adaptor.dupNode(set510);


                adaptor.addChild(root_0, set510_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_op_lte"


    public static class rel_str_op_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_str_op"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:762:1: rel_str_op : ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES );
    public final AstValidator.rel_str_op_return rel_str_op() throws RecognitionException {
        AstValidator.rel_str_op_return retval = new AstValidator.rel_str_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set511=null;

        CommonTree set511_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:762:12: ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set511=(CommonTree)input.LT(1);

            if ( (input.LA(1) >= STR_OP_EQ && input.LA(1) <= STR_OP_NE) ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set511_tree = (CommonTree)adaptor.dupNode(set511);


                adaptor.addChild(root_0, set511_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==0 ) {
            } 

            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rel_str_op"

    // $ANTLR start synpred108_AstValidator
    public final void synpred108_AstValidator_fragment() throws RecognitionException {
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:392:8: ( ^( MINUS expr expr ) )
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:392:8: ^( MINUS expr expr )
        {
        match(input,MINUS,FOLLOW_MINUS_in_synpred108_AstValidator1840); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred108_AstValidator1842);
        expr();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred108_AstValidator1844);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred108_AstValidator

    // $ANTLR start synpred112_AstValidator
    public final void synpred112_AstValidator_fragment() throws RecognitionException {
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:396:8: ( ^( CAST_EXPR type expr ) )
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:396:8: ^( CAST_EXPR type expr )
        {
        match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_synpred112_AstValidator1908); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_in_synpred112_AstValidator1910);
        type();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred112_AstValidator1912);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred112_AstValidator

    // $ANTLR start synpred113_AstValidator
    public final void synpred113_AstValidator_fragment() throws RecognitionException {
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:397:8: ( const_expr )
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:397:8: const_expr
        {
        pushFollow(FOLLOW_const_expr_in_synpred113_AstValidator1923);
        const_expr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred113_AstValidator

    // $ANTLR start synpred116_AstValidator
    public final void synpred116_AstValidator_fragment() throws RecognitionException {
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:400:8: ( ^( CAST_EXPR type_cast expr ) )
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:400:8: ^( CAST_EXPR type_cast expr )
        {
        match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_synpred116_AstValidator1958); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_cast_in_synpred116_AstValidator1960);
        type_cast();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred116_AstValidator1962);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred116_AstValidator

    // $ANTLR start synpred139_AstValidator
    public final void synpred139_AstValidator_fragment() throws RecognitionException {
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:447:31: ( INTEGER )
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:447:31: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred139_AstValidator2278); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred139_AstValidator

    // $ANTLR start synpred140_AstValidator
    public final void synpred140_AstValidator_fragment() throws RecognitionException {
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:447:41: ( LONGINTEGER )
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:447:41: LONGINTEGER
        {
        match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_synpred140_AstValidator2282); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred140_AstValidator

    // $ANTLR start synpred141_AstValidator
    public final void synpred141_AstValidator_fragment() throws RecognitionException {
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:450:33: ( DOUBLENUMBER )
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:450:33: DOUBLENUMBER
        {
        match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_synpred141_AstValidator2307); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred141_AstValidator

    // $ANTLR start synpred171_AstValidator
    public final void synpred171_AstValidator_fragment() throws RecognitionException {
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:504:4: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item )
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:504:4: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
        {
        pushFollow(FOLLOW_join_item_in_synpred171_AstValidator2656);
        join_item();

        state._fsp--;
        if (state.failed) return ;

        if ( input.LA(1)==FULL||input.LA(1)==LEFT||input.LA(1)==RIGHT ) {
            input.consume();
            state.errorRecovery=false;
            state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }


        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:504:38: ( OUTER )?
        int alt132=2;
        int LA132_0 = input.LA(1);

        if ( (LA132_0==OUTER) ) {
            alt132=1;
        }
        switch (alt132) {
            case 1 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:504:38: OUTER
                {
                match(input,OUTER,FOLLOW_OUTER_in_synpred171_AstValidator2672); if (state.failed) return ;

                }
                break;

        }


        pushFollow(FOLLOW_join_item_in_synpred171_AstValidator2675);
        join_item();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred171_AstValidator

    // $ANTLR start synpred189_AstValidator
    public final void synpred189_AstValidator_fragment() throws RecognitionException {
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:583:43: ( INTEGER )
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AstValidator.g:583:43: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred189_AstValidator3086); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred189_AstValidator

    // Delegated rules

    public final boolean synpred139_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred139_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred140_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred140_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred116_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred116_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred113_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred113_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred108_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred108_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred171_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred171_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred141_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred141_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred112_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred112_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred189_AstValidator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred189_AstValidator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_QUERY_in_query80 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_query82 = new BitSet(new long[]{0x0000000000000408L,0x0020020000000000L,0x0012000000000000L});
    public static final BitSet FOLLOW_general_statement_in_statement94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_statement_in_statement108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_statement_in_statement122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_register_statement_in_statement136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assert_statement_in_statement150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_split_statement159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_clause_in_realias_statement168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REGISTER_in_register_statement179 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_register_statement181 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_USING_in_register_statement184 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_register_statement186 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_AS_in_register_statement188 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_register_statement190 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_assert_clause_in_assert_statement203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STATEMENT_in_general_statement214 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_general_statement218 = new BitSet(new long[]{0x0048400226400400L,0x0C21010010004608L,0x0000000000000080L});
    public static final BitSet FOLLOW_op_clause_in_general_statement225 = new BitSet(new long[]{0x0000000000000008L,0x0000000100000000L});
    public static final BitSet FOLLOW_parallel_clause_in_general_statement227 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REALIAS_in_realias_clause240 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_realias_clause242 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_realias_clause244 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARALLEL_in_parallel_clause261 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_parallel_clause263 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARROBA_in_previous_rel296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_define_clause_in_op_clause310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_load_clause_in_op_clause324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_clause_in_op_clause338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_store_clause_in_op_clause352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filter_clause_in_op_clause366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_distinct_clause_in_op_clause380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_limit_clause_in_op_clause394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sample_clause_in_op_clause408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_order_clause_in_op_clause422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rank_clause_in_op_clause436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cross_clause_in_op_clause450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_clause_in_op_clause464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_union_clause_in_op_clause478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stream_clause_in_op_clause492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mr_clause_in_op_clause506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_op_clause520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreach_clause_in_op_clause534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cube_clause_in_op_clause548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assert_clause_in_op_clause562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_define_clause573 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_define_clause575 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000000L,0x0000000140000000L});
    public static final BitSet FOLLOW_cmd_in_define_clause579 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_func_clause_in_define_clause583 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_cmd604 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ship_clause_in_cmd608 = new BitSet(new long[]{0x2000000000080008L,0x0084000080000000L});
    public static final BitSet FOLLOW_cache_clause_in_cmd632 = new BitSet(new long[]{0x2000000000080008L,0x0084000080000000L});
    public static final BitSet FOLLOW_input_clause_in_cmd656 = new BitSet(new long[]{0x2000000000080008L,0x0084000080000000L});
    public static final BitSet FOLLOW_output_clause_in_cmd680 = new BitSet(new long[]{0x2000000000080008L,0x0084000080000000L});
    public static final BitSet FOLLOW_error_clause_in_cmd704 = new BitSet(new long[]{0x2000000000080008L,0x0084000080000000L});
    public static final BitSet FOLLOW_SHIP_in_ship_clause743 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_ship_clause745 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_path_list757 = new BitSet(new long[]{0x0000000000000002L,0x0000008000000000L});
    public static final BitSet FOLLOW_CACHE_in_cache_clause769 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_cache_clause771 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INPUT_in_input_clause784 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_input_clause786 = new BitSet(new long[]{0x0000000000000008L,0x0300008000000000L});
    public static final BitSet FOLLOW_STDIN_in_stream_cmd800 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd802 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STDOUT_in_stream_cmd822 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd824 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_stream_cmd844 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd846 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OUTPUT_in_output_clause860 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_output_clause862 = new BitSet(new long[]{0x0000000000000008L,0x0300008000000000L});
    public static final BitSet FOLLOW_STDERROR_in_error_clause876 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_error_clause881 = new BitSet(new long[]{0x8000000000000008L});
    public static final BitSet FOLLOW_INTEGER_in_error_clause883 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOAD_in_load_clause900 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_filename_in_load_clause902 = new BitSet(new long[]{0x0000000000000108L,0x0000000000000000L,0x0000000140000000L});
    public static final BitSet FOLLOW_func_clause_in_load_clause904 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_as_clause_in_load_clause907 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_filename919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_as_clause929 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_as_clause931 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_in_field_def950 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_field_def952 = new BitSet(new long[]{0x4001002008255008L,0x0000000000000800L,0x0100020000002000L});
    public static final BitSet FOLLOW_type_in_field_def956 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_WITHOUT_IDENTIFIER_in_field_def966 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_field_def968 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_field_def_in_field_def_list996 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_simple_type_in_type1015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_in_type1023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_in_type1031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type1039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_simple_type1056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_simple_type1064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_simple_type1072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_simple_type1080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_simple_type1088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINTEGER_in_simple_type1096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGDECIMAL_in_simple_type1104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATETIME_in_simple_type1112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_simple_type1120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_simple_type1128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_in_tuple_type1141 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_tuple_type1143 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BAG_TYPE_in_bag_type1157 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_bag_type1159 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_tuple_type_in_bag_type1162 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAP_TYPE_in_map_type1176 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_map_type1178 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_REF_in_func_clause1192 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1194 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_in_func_clause1214 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1216 = new BitSet(new long[]{0x0000000000000008L,0x0000008000020000L});
    public static final BitSet FOLLOW_func_args_in_func_clause1218 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_eid_in_func_name1230 = new BitSet(new long[]{0x0000000800000002L,0x0000000800000000L});
    public static final BitSet FOLLOW_set_in_func_name1234 = new BitSet(new long[]{0x7779D022AE6F5F50L,0xFFA58D03D80C6E1DL,0x18E00000000001F7L});
    public static final BitSet FOLLOW_eid_in_func_name1244 = new BitSet(new long[]{0x0000000800000002L,0x0000000800000000L});
    public static final BitSet FOLLOW_func_args_string_in_func_args1269 = new BitSet(new long[]{0x0000000000000002L,0x0000008000020000L});
    public static final BitSet FOLLOW_CUBE_in_cube_clause1282 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_item_in_cube_clause1284 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_cube_item1296 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_cube_by_clause_in_cube_item1300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_cube_by_clause1314 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_or_rollup_in_cube_by_clause1316 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_rollup_list_in_cube_or_rollup1328 = new BitSet(new long[]{0x0000000004000002L,0x0000800000000000L});
    public static final BitSet FOLLOW_set_in_cube_rollup_list1341 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_by_expr_list_in_cube_rollup_list1351 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_by_expr_in_cube_by_expr_list1363 = new BitSet(new long[]{0x814410540400A002L,0x0040009400089000L,0x04000C0283998020L});
    public static final BitSet FOLLOW_col_range_in_cube_by_expr1374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_cube_by_expr1378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_cube_by_expr1382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_group_clause1403 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_group_item_in_group_clause1413 = new BitSet(new long[]{0x0148400226400488L,0x0C21018210004608L,0x0000000000000080L});
    public static final BitSet FOLLOW_group_type_in_group_clause1416 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_partition_clause_in_group_clause1419 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_group_type1431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_in_group_item1441 = new BitSet(new long[]{0x0000000000020010L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_join_group_by_clause_in_group_item1445 = new BitSet(new long[]{0x1000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_ALL_in_group_item1449 = new BitSet(new long[]{0x1000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_ANY_in_group_item1453 = new BitSet(new long[]{0x1000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_alias_in_rel1480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_previous_rel_in_rel1490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_op_clause_in_rel1500 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_parallel_clause_in_rel1502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_flatten_clause_in_flatten_generated_item1514 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_col_range_in_flatten_generated_item1518 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_expr_in_flatten_generated_item1522 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_STAR_in_flatten_generated_item1526 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_field_def_list_in_flatten_generated_item1530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_flatten_clause1542 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_flatten_clause1544 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STORE_in_store_clause1557 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_store_clause1559 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_filename_in_store_clause1561 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000140000000L});
    public static final BitSet FOLLOW_func_clause_in_store_clause1563 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSERT_in_assert_clause1577 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_assert_clause1579 = new BitSet(new long[]{0x0800000000000040L,0xF00000000BFC0000L,0x0000000280040007L});
    public static final BitSet FOLLOW_cond_in_assert_clause1581 = new BitSet(new long[]{0x0000000000000008L,0x0000008000000000L});
    public static final BitSet FOLLOW_comment_in_assert_clause1583 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_comment1596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILTER_in_filter_clause1607 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_filter_clause1609 = new BitSet(new long[]{0x0800000000000040L,0xF00000000BFC0000L,0x0000000280040007L});
    public static final BitSet FOLLOW_cond_in_filter_clause1611 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_cond1624 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1626 = new BitSet(new long[]{0x0800000000000040L,0xF00000000BFC0000L,0x0000000280040007L});
    public static final BitSet FOLLOW_cond_in_cond1628 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_cond1641 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1643 = new BitSet(new long[]{0x0800000000000040L,0xF00000000BFC0000L,0x0000000280040007L});
    public static final BitSet FOLLOW_cond_in_cond1645 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_cond1658 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1660 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_cond1673 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1675 = new BitSet(new long[]{0x0000000000000008L,0x0000000000040000L});
    public static final BitSet FOLLOW_NOT_in_cond1677 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_in_cond1691 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1693 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_expr_in_cond1695 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_in_eval_in_cond1706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_func_eval_in_cond1715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_COND_in_cond1726 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1728 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_in_in_eval1740 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IN_LHS_in_in_eval1746 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_in_eval1748 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_RHS_in_in_eval1754 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_in_eval1756 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_EVAL_in_func_eval1773 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_eval1775 = new BitSet(new long[]{0x814410540400A008L,0x0040009400089000L,0x04000C0283998020L});
    public static final BitSet FOLLOW_real_arg_in_func_eval1777 = new BitSet(new long[]{0x814410540400A008L,0x0040009400089000L,0x04000C0283998020L});
    public static final BitSet FOLLOW_INVOKER_FUNC_EVAL_in_func_eval1786 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_eval1788 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_func_eval1790 = new BitSet(new long[]{0x814410540400A008L,0x0040009400089000L,0x04000C0283998020L});
    public static final BitSet FOLLOW_real_arg_in_func_eval1792 = new BitSet(new long[]{0x814410540400A008L,0x0040009400089000L,0x04000C0283998020L});
    public static final BitSet FOLLOW_expr_in_real_arg1804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_real_arg1808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_range_in_real_arg1812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_expr1823 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1825 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_expr_in_expr1827 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expr1840 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1842 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_expr_in_expr1844 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_expr1857 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1859 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_expr_in_expr1861 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr1874 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1876 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_expr_in_expr1878 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PERCENT_in_expr1891 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1893 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_expr_in_expr1895 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr1908 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_expr1910 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_expr_in_expr1912 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_expr1923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_expr_in_expr1932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEG_in_expr1943 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1945 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr1958 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_expr1960 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_expr_in_expr1962 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPR_IN_PAREN_in_expr1975 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1977 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_simple_type_in_type_cast1988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type_cast1992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_cast_in_type_cast1996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_cast_in_type_cast2000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast2011 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_tuple_type_cast2013 = new BitSet(new long[]{0x4001002008255008L,0x0000000000000800L,0x0200020000004000L});
    public static final BitSet FOLLOW_BAG_TYPE_CAST_in_bag_type_cast2027 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_type_cast_in_bag_type_cast2029 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_projectable_expr_in_var_expr2041 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
    public static final BitSet FOLLOW_dot_proj_in_var_expr2045 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
    public static final BitSet FOLLOW_pound_proj_in_var_expr2049 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
    public static final BitSet FOLLOW_func_eval_in_projectable_expr2060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_ref_in_projectable_expr2064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bin_expr_in_projectable_expr2068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_expr_in_projectable_expr2072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_cond_in_projectable_expr2076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_dot_proj2087 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_alias_or_index_in_dot_proj2089 = new BitSet(new long[]{0x0140001004000008L});
    public static final BitSet FOLLOW_col_alias_in_col_alias_or_index2101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_index_in_col_alias_or_index2105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_col_index2131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COL_RANGE_in_col_range2142 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_col_range2144 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_DOUBLE_PERIOD_in_col_range2147 = new BitSet(new long[]{0x0140001004000008L});
    public static final BitSet FOLLOW_col_ref_in_col_range2149 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POUND_in_pound_proj2163 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_set_in_pound_proj2165 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BIN_EXPR_in_bin_expr2186 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_bin_expr2188 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_expr_in_bin_expr2190 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_expr_in_bin_expr2192 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_EXPR_in_case_expr2204 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_CASE_EXPR_LHS_in_case_expr2210 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_expr2212 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_EXPR_RHS_in_case_expr2220 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_expr2222 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_COND_in_case_cond2241 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_WHEN_in_case_cond2245 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_case_cond2247 = new BitSet(new long[]{0x0800000000000048L,0xF00000000BFC0000L,0x0000000280040007L});
    public static final BitSet FOLLOW_THEN_in_case_cond2254 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_cond2256 = new BitSet(new long[]{0x814410540400A008L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_LIMIT_in_limit_clause2272 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_limit_clause2274 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_INTEGER_in_limit_clause2278 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LONGINTEGER_in_limit_clause2282 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_limit_clause2286 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SAMPLE_in_sample_clause2301 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_sample_clause2303 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_sample_clause2307 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_sample_clause2311 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RANK_in_rank_clause2326 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_rank_clause2328 = new BitSet(new long[]{0x0000000000020008L});
    public static final BitSet FOLLOW_rank_by_statement_in_rank_clause2332 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_rank_by_statement2348 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rank_by_clause_in_rank_by_statement2350 = new BitSet(new long[]{0x0000000040000008L});
    public static final BitSet FOLLOW_DENSE_in_rank_by_statement2354 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_rank_by_clause2368 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_rank_col_in_rank_by_clause2398 = new BitSet(new long[]{0x0140001004000002L,0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_col_range_in_rank_col2408 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_col_ref_in_rank_col2430 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_ORDER_in_order_clause2452 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_order_clause2454 = new BitSet(new long[]{0x0140001004000000L,0x0040000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_order_by_clause_in_order_clause2456 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000140000000L});
    public static final BitSet FOLLOW_func_clause_in_order_clause2458 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_order_by_clause2470 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_order_col_in_order_by_clause2501 = new BitSet(new long[]{0x0140001004000002L,0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_col_range_in_order_col2511 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_col_ref_in_order_col2534 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_DISTINCT_in_distinct_clause2556 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_distinct_clause2558 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_partition_clause_in_distinct_clause2560 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARTITION_in_partition_clause2574 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_partition_clause2576 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_cross_clause2589 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_list_in_cross_clause2591 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_partition_clause_in_cross_clause2593 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_rel_list2605 = new BitSet(new long[]{0x0148400226400482L,0x0C21010010004608L,0x0000000000000080L});
    public static final BitSet FOLLOW_JOIN_in_join_clause2627 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_sub_clause_in_join_clause2629 = new BitSet(new long[]{0x0000000000000008L,0x0000008200000000L});
    public static final BitSet FOLLOW_join_type_in_join_clause2631 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_partition_clause_in_join_clause2634 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_join_type2646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2656 = new BitSet(new long[]{0x0010000000000000L,0x0000080000000010L});
    public static final BitSet FOLLOW_set_in_join_sub_clause2658 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_OUTER_in_join_sub_clause2672 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2680 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_JOIN_ITEM_in_join_item2693 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_join_item2695 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_join_group_by_clause_in_join_item2697 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_join_group_by_clause2724 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_group_by_expr_in_join_group_by_clause2728 = new BitSet(new long[]{0x814410540400A008L,0x0040009400089000L,0x04000C0283998020L});
    public static final BitSet FOLLOW_col_range_in_join_group_by_expr2744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_join_group_by_expr2749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_join_group_by_expr2753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_union_clause2764 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ONSCHEMA_in_union_clause2766 = new BitSet(new long[]{0x0148400226400480L,0x0C21010010004608L,0x0000000000000080L});
    public static final BitSet FOLLOW_rel_list_in_union_clause2769 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_foreach_clause2782 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_foreach_clause2784 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000030000000L});
    public static final BitSet FOLLOW_foreach_plan_in_foreach_clause2786 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan2799 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_generate_clause_in_foreach_plan2801 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan2822 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_blk_in_foreach_plan2824 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_command_in_nested_blk2844 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000000L,0x0000300000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_blk2847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_generate_clause2858 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_flatten_generated_item_in_generate_clause2860 = new BitSet(new long[]{0x814490540400A008L,0x0040009400089000L,0x04000C0283998020L});
    public static final BitSet FOLLOW_NESTED_CMD_in_nested_command2875 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command2877 = new BitSet(new long[]{0x0008400202000000L,0x0000000010000200L,0x0000400000000000L});
    public static final BitSet FOLLOW_nested_op_in_nested_command2879 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NESTED_CMD_ASSI_in_nested_command2893 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command2895 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_expr_in_nested_command2897 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op2913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_filter_in_nested_op2927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_sort_in_nested_op2941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_distinct_in_nested_op2955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_limit_in_nested_op2969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_cross_in_nested_op2983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_foreach_in_nested_op2997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NESTED_PROJ_in_nested_proj3008 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj3010 = new BitSet(new long[]{0x0140001004000000L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj3012 = new BitSet(new long[]{0x0140001004000008L});
    public static final BitSet FOLLOW_FILTER_in_nested_filter3027 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_filter3029 = new BitSet(new long[]{0x0800000000000040L,0xF00000000BFC0000L,0x0000000280040007L});
    public static final BitSet FOLLOW_cond_in_nested_filter3031 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ORDER_in_nested_sort3044 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_sort3046 = new BitSet(new long[]{0x0140001004000000L,0x0040000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_order_by_clause_in_nested_sort3049 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000140000000L});
    public static final BitSet FOLLOW_func_clause_in_nested_sort3051 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DISTINCT_in_nested_distinct3065 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_distinct3067 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LIMIT_in_nested_limit3080 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_limit3082 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_INTEGER_in_nested_limit3086 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_nested_limit3090 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_nested_cross3105 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_list_in_nested_cross3107 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_nested_foreach3120 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_foreach3122 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_foreach3124 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_col_ref_in_nested_op_input3135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op_input3139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_op_input_list3148 = new BitSet(new long[]{0x0140001004000002L,0x0000000000000000L,0x0000400000000000L});
    public static final BitSet FOLLOW_STREAM_in_stream_clause3160 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_stream_clause3162 = new BitSet(new long[]{0x0100080000000000L});
    public static final BitSet FOLLOW_set_in_stream_clause3164 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_as_clause_in_stream_clause3174 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAPREDUCE_in_mr_clause3188 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_mr_clause3190 = new BitSet(new long[]{0x0000000000000000L,0x0400008000000000L});
    public static final BitSet FOLLOW_path_list_in_mr_clause3192 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_store_clause_in_mr_clause3195 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_load_clause_in_mr_clause3197 = new BitSet(new long[]{0x0000080000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_mr_clause3199 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_in_split_clause3213 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_split_clause3215 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_split_branch_in_split_clause3217 = new BitSet(new long[]{0x0000000000000008L,0x0000000020000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_split_otherwise_in_split_clause3220 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_BRANCH_in_split_branch3235 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_branch3237 = new BitSet(new long[]{0x0800000000000040L,0xF00000000BFC0000L,0x0000000280040007L});
    public static final BitSet FOLLOW_cond_in_split_branch3239 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OTHERWISE_in_split_otherwise3257 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_otherwise3259 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_alias_col_ref_in_col_ref3275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dollar_col_ref_in_col_ref3279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_dollar_col_ref3305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_const_expr3314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scalar_in_literal3323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_in_literal3327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_in_literal3331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_in_literal3335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_num_scalar_in_scalar3344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_scalar3348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_scalar3352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_scalar3356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_scalar3360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_num_scalar3369 = new BitSet(new long[]{0x800400400000A000L,0x0000000000001000L});
    public static final BitSet FOLLOW_set_in_num_scalar3372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_VAL_in_map3407 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_keyvalue_in_map3409 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_KEY_VAL_PAIR_in_keyvalue3423 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_map_key_in_keyvalue3425 = new BitSet(new long[]{0x800410400000A000L,0x0000008000089000L,0x0400040000008020L});
    public static final BitSet FOLLOW_const_expr_in_keyvalue3427 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_map_key3438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_VAL_in_bag3449 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_in_bag3451 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_TUPLE_VAL_in_tuple3465 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_literal_in_tuple3467 = new BitSet(new long[]{0x800410400000A008L,0x0000008000089000L,0x0400040000008020L});
    public static final BitSet FOLLOW_rel_str_op_in_eid3480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_eid3488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURNS_in_eid3496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_eid3504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOAD_in_eid3512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILTER_in_eid3520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOREACH_in_eid3528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_eid3536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROLLUP_in_eid3544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MATCHES_in_eid3552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_eid3560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANK_in_eid3568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTINCT_in_eid3576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COGROUP_in_eid3584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JOIN_in_eid3592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CROSS_in_eid3600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_eid3608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SPLIT_in_eid3616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTO_in_eid3624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_eid3632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALL_in_eid3640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_eid3648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_eid3656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USING_in_eid3664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INNER_in_eid3672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTER_in_eid3680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARALLEL_in_eid3688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARTITION_in_eid3696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_eid3704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_eid3712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_eid3720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_eid3728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_eid3736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_eid3744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EVAL_in_eid3752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASC_in_eid3760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_eid3768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_eid3776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_eid3784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_eid3792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_eid3800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_eid3808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINTEGER_in_eid3816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGDECIMAL_in_eid3824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATETIME_in_eid3832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_eid3840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_eid3848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_in_eid3856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_in_eid3864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_in_eid3872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IS_in_eid3880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_eid3888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_eid3896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_eid3904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STREAM_in_eid3912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROUGH_in_eid3920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STORE_in_eid3928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAPREDUCE_in_eid3936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHIP_in_eid3944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CACHE_in_eid3952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INPUT_in_eid3960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTPUT_in_eid3968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDERROR_in_eid3976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDIN_in_eid3984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDOUT_in_eid3992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LIMIT_in_eid4000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SAMPLE_in_eid4008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_in_eid4016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RIGHT_in_eid4024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FULL_in_eid4032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_eid4040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOBAG_in_eid4048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOMAP_in_eid4056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOTUPLE_in_eid4064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSERT_in_eid4072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_eq_in_rel_op4082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_ne_in_rel_op4093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gt_in_rel_op4104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gte_in_rel_op4115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lt_in_rel_op4126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lte_in_rel_op4137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_rel_op4148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_synpred108_AstValidator1840 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_synpred108_AstValidator1842 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_expr_in_synpred108_AstValidator1844 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_synpred112_AstValidator1908 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_synpred112_AstValidator1910 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_expr_in_synpred112_AstValidator1912 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_synpred113_AstValidator1923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CAST_EXPR_in_synpred116_AstValidator1958 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_synpred116_AstValidator1960 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_expr_in_synpred116_AstValidator1962 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INTEGER_in_synpred139_AstValidator2278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGINTEGER_in_synpred140_AstValidator2282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_synpred141_AstValidator2307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_synpred171_AstValidator2656 = new BitSet(new long[]{0x0010000000000000L,0x0000080000000010L});
    public static final BitSet FOLLOW_set_in_synpred171_AstValidator2658 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_OUTER_in_synpred171_AstValidator2672 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_join_item_in_synpred171_AstValidator2675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_synpred189_AstValidator3086 = new BitSet(new long[]{0x0000000000000002L});

}