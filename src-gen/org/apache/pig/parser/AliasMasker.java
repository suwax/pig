// $ANTLR 3.4 /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g 2014-07-02 16:22:15

package org.apache.pig.parser;

import java.util.HashSet;
import java.util.Set;


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
public class AliasMasker extends TreeParser {
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


    public AliasMasker(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public AliasMasker(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return AliasMasker.tokenNames; }
    public String getGrammarFileName() { return "/home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g"; }



    @Override
    public String getErrorMessage(RecognitionException e, String[] tokenNames) {
    	if (e instanceof ParserValidationException) {
    		return e.toString();
    	}
    	return super.getErrorMessage(e, tokenNames);
    }

    public void setParams(Set ps, String macro, long idx) {
        params = ps;
        macroName = macro;
        index = idx;
    }

    private String getMask(String alias) {
        return params.contains( alias )
            ? alias
            : "macro_" + macroName + "_" + alias + "_" + index;
    }

    private Set<String> params = new HashSet<String>();

    private Set<String> aliasSeen = new HashSet<String>();

    private String macroName = "";

    private long index = 0;

    private boolean inAsOrGenClause = false;



    public static class query_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "query"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:82:1: query : ^( QUERY ( statement )* ) ;
    public final AliasMasker.query_return query() throws RecognitionException {
        AliasMasker.query_return retval = new AliasMasker.query_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUERY1=null;
        AliasMasker.statement_return statement2 =null;


        CommonTree QUERY1_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:82:7: ( ^( QUERY ( statement )* ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:82:9: ^( QUERY ( statement )* )
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
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:82:18: ( statement )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==ASSERT||LA1_0==SPLIT||LA1_0==REALIAS||LA1_0==STATEMENT) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:82:18: statement
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:85:1: statement : ( general_statement | split_statement | realias_statement | assert_statement );
    public final AliasMasker.statement_return statement() throws RecognitionException {
        AliasMasker.statement_return retval = new AliasMasker.statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.general_statement_return general_statement3 =null;

        AliasMasker.split_statement_return split_statement4 =null;

        AliasMasker.realias_statement_return realias_statement5 =null;

        AliasMasker.assert_statement_return assert_statement6 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:85:11: ( general_statement | split_statement | realias_statement | assert_statement )
            int alt2=4;
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
            case ASSERT:
                {
                alt2=4;
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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:85:13: general_statement
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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:86:13: split_statement
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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:87:13: realias_statement
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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:88:13: assert_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_assert_statement_in_statement136);
                    assert_statement6=assert_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, assert_statement6.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:91:1: split_statement : split_clause ;
    public final AliasMasker.split_statement_return split_statement() throws RecognitionException {
        AliasMasker.split_statement_return retval = new AliasMasker.split_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.split_clause_return split_clause7 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:91:17: ( split_clause )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:91:19: split_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_split_clause_in_split_statement145);
            split_clause7=split_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, split_clause7.getTree());


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


    public static class assert_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assert_statement"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:94:1: assert_statement : assert_clause ;
    public final AliasMasker.assert_statement_return assert_statement() throws RecognitionException {
        AliasMasker.assert_statement_return retval = new AliasMasker.assert_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.assert_clause_return assert_clause8 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:94:17: ( assert_clause )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:94:19: assert_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_assert_clause_in_assert_statement153);
            assert_clause8=assert_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, assert_clause8.getTree());


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


    public static class realias_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "realias_statement"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:97:1: realias_statement : realias_clause ;
    public final AliasMasker.realias_statement_return realias_statement() throws RecognitionException {
        AliasMasker.realias_statement_return retval = new AliasMasker.realias_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.realias_clause_return realias_clause9 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:97:19: ( realias_clause )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:97:21: realias_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_realias_clause_in_realias_statement162);
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


    public static class general_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "general_statement"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:101:1: general_statement : ^( STATEMENT ( alias )? op_clause ( parallel_clause )? ) ;
    public final AliasMasker.general_statement_return general_statement() throws RecognitionException {
        AliasMasker.general_statement_return retval = new AliasMasker.general_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STATEMENT10=null;
        AliasMasker.alias_return alias11 =null;

        AliasMasker.op_clause_return op_clause12 =null;

        AliasMasker.parallel_clause_return parallel_clause13 =null;


        CommonTree STATEMENT10_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:102:5: ( ^( STATEMENT ( alias )? op_clause ( parallel_clause )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:102:7: ^( STATEMENT ( alias )? op_clause ( parallel_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STATEMENT10=(CommonTree)match(input,STATEMENT,FOLLOW_STATEMENT_in_general_statement178); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STATEMENT10_tree = (CommonTree)adaptor.dupNode(STATEMENT10);


            root_1 = (CommonTree)adaptor.becomeRoot(STATEMENT10_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:102:20: ( alias )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==IDENTIFIER) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:102:22: alias
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_general_statement182);
                    alias11=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, alias11.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_op_clause_in_general_statement195);
            op_clause12=op_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, op_clause12.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:103:19: ( parallel_clause )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==PARALLEL) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:103:19: parallel_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_parallel_clause_in_general_statement197);
                    parallel_clause13=parallel_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, parallel_clause13.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:106:1: realias_clause : ^( REALIAS alias IDENTIFIER ) ;
    public final AliasMasker.realias_clause_return realias_clause() throws RecognitionException {
        AliasMasker.realias_clause_return retval = new AliasMasker.realias_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REALIAS14=null;
        CommonTree IDENTIFIER16=null;
        AliasMasker.alias_return alias15 =null;


        CommonTree REALIAS14_tree=null;
        CommonTree IDENTIFIER16_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:106:16: ( ^( REALIAS alias IDENTIFIER ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:106:18: ^( REALIAS alias IDENTIFIER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            REALIAS14=(CommonTree)match(input,REALIAS,FOLLOW_REALIAS_in_realias_clause210); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REALIAS14_tree = (CommonTree)adaptor.dupNode(REALIAS14);


            root_1 = (CommonTree)adaptor.becomeRoot(REALIAS14_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_realias_clause212);
            alias15=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias15.getTree());


            _last = (CommonTree)input.LT(1);
            IDENTIFIER16=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_realias_clause214); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER16_tree = (CommonTree)adaptor.dupNode(IDENTIFIER16);


            adaptor.addChild(root_1, IDENTIFIER16_tree);
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
    // $ANTLR end "realias_clause"


    public static class parallel_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parallel_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:109:1: parallel_clause : ^( PARALLEL INTEGER ) ;
    public final AliasMasker.parallel_clause_return parallel_clause() throws RecognitionException {
        AliasMasker.parallel_clause_return retval = new AliasMasker.parallel_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARALLEL17=null;
        CommonTree INTEGER18=null;

        CommonTree PARALLEL17_tree=null;
        CommonTree INTEGER18_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:110:5: ( ^( PARALLEL INTEGER ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:110:7: ^( PARALLEL INTEGER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARALLEL17=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_parallel_clause230); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARALLEL17_tree = (CommonTree)adaptor.dupNode(PARALLEL17);


            root_1 = (CommonTree)adaptor.becomeRoot(PARALLEL17_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            INTEGER18=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_parallel_clause232); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER18_tree = (CommonTree)adaptor.dupNode(INTEGER18);


            adaptor.addChild(root_1, INTEGER18_tree);
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alias"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:113:1: alias : IDENTIFIER ;
    public final AliasMasker.alias_return alias() throws RecognitionException {
        AliasMasker.alias_return retval = new AliasMasker.alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDENTIFIER19=null;

        CommonTree IDENTIFIER19_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:114:5: ( IDENTIFIER )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:114:7: IDENTIFIER
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            IDENTIFIER19=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias247); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER19_tree = (CommonTree)adaptor.dupNode(IDENTIFIER19);


            adaptor.addChild(root_0, IDENTIFIER19_tree);
            }


            if ( state.backtracking==0 ) {
                        aliasSeen.add((IDENTIFIER19!=null?IDENTIFIER19.getText():null));
                        IDENTIFIER19.getToken().setText(getMask((IDENTIFIER19!=null?IDENTIFIER19.getText():null)));
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


    public static class op_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "op_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:121:1: op_clause : ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | split_clause | foreach_clause | cube_clause | assert_clause );
    public final AliasMasker.op_clause_return op_clause() throws RecognitionException {
        AliasMasker.op_clause_return retval = new AliasMasker.op_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.define_clause_return define_clause20 =null;

        AliasMasker.load_clause_return load_clause21 =null;

        AliasMasker.group_clause_return group_clause22 =null;

        AliasMasker.store_clause_return store_clause23 =null;

        AliasMasker.filter_clause_return filter_clause24 =null;

        AliasMasker.distinct_clause_return distinct_clause25 =null;

        AliasMasker.limit_clause_return limit_clause26 =null;

        AliasMasker.sample_clause_return sample_clause27 =null;

        AliasMasker.order_clause_return order_clause28 =null;

        AliasMasker.rank_clause_return rank_clause29 =null;

        AliasMasker.cross_clause_return cross_clause30 =null;

        AliasMasker.join_clause_return join_clause31 =null;

        AliasMasker.union_clause_return union_clause32 =null;

        AliasMasker.stream_clause_return stream_clause33 =null;

        AliasMasker.mr_clause_return mr_clause34 =null;

        AliasMasker.split_clause_return split_clause35 =null;

        AliasMasker.foreach_clause_return foreach_clause36 =null;

        AliasMasker.cube_clause_return cube_clause37 =null;

        AliasMasker.assert_clause_return assert_clause38 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:121:11: ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | split_clause | foreach_clause | cube_clause | assert_clause )
            int alt5=19;
            switch ( input.LA(1) ) {
            case DEFINE:
                {
                alt5=1;
                }
                break;
            case LOAD:
                {
                alt5=2;
                }
                break;
            case COGROUP:
            case GROUP:
                {
                alt5=3;
                }
                break;
            case STORE:
                {
                alt5=4;
                }
                break;
            case FILTER:
                {
                alt5=5;
                }
                break;
            case DISTINCT:
                {
                alt5=6;
                }
                break;
            case LIMIT:
                {
                alt5=7;
                }
                break;
            case SAMPLE:
                {
                alt5=8;
                }
                break;
            case ORDER:
                {
                alt5=9;
                }
                break;
            case RANK:
                {
                alt5=10;
                }
                break;
            case CROSS:
                {
                alt5=11;
                }
                break;
            case JOIN:
                {
                alt5=12;
                }
                break;
            case UNION:
                {
                alt5=13;
                }
                break;
            case STREAM:
                {
                alt5=14;
                }
                break;
            case MAPREDUCE:
                {
                alt5=15;
                }
                break;
            case SPLIT:
                {
                alt5=16;
                }
                break;
            case FOREACH:
                {
                alt5=17;
                }
                break;
            case CUBE:
                {
                alt5=18;
                }
                break;
            case ASSERT:
                {
                alt5=19;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }

            switch (alt5) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:121:13: define_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_define_clause_in_op_clause266);
                    define_clause20=define_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, define_clause20.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:122:13: load_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_load_clause_in_op_clause280);
                    load_clause21=load_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, load_clause21.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:123:13: group_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_clause_in_op_clause294);
                    group_clause22=group_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, group_clause22.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:124:13: store_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_store_clause_in_op_clause308);
                    store_clause23=store_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, store_clause23.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:125:13: filter_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_filter_clause_in_op_clause322);
                    filter_clause24=filter_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, filter_clause24.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:126:13: distinct_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_distinct_clause_in_op_clause336);
                    distinct_clause25=distinct_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, distinct_clause25.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:127:13: limit_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_limit_clause_in_op_clause350);
                    limit_clause26=limit_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, limit_clause26.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:128:13: sample_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_sample_clause_in_op_clause364);
                    sample_clause27=sample_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, sample_clause27.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:129:13: order_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_order_clause_in_op_clause378);
                    order_clause28=order_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, order_clause28.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:130:13: rank_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_clause_in_op_clause392);
                    rank_clause29=rank_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rank_clause29.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:131:13: cross_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cross_clause_in_op_clause406);
                    cross_clause30=cross_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cross_clause30.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:132:13: join_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_clause_in_op_clause420);
                    join_clause31=join_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_clause31.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:133:13: union_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_union_clause_in_op_clause434);
                    union_clause32=union_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, union_clause32.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:134:13: stream_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_stream_clause_in_op_clause448);
                    stream_clause33=stream_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, stream_clause33.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:135:13: mr_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_mr_clause_in_op_clause462);
                    mr_clause34=mr_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, mr_clause34.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:136:13: split_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_clause_in_op_clause476);
                    split_clause35=split_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, split_clause35.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:137:13: foreach_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_foreach_clause_in_op_clause490);
                    foreach_clause36=foreach_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, foreach_clause36.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:138:13: cube_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cube_clause_in_op_clause504);
                    cube_clause37=cube_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cube_clause37.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 19 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:139:13: assert_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_assert_clause_in_op_clause518);
                    assert_clause38=assert_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, assert_clause38.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:142:1: define_clause : ^( DEFINE IDENTIFIER ( cmd | func_clause ) ) ;
    public final AliasMasker.define_clause_return define_clause() throws RecognitionException {
        AliasMasker.define_clause_return retval = new AliasMasker.define_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DEFINE39=null;
        CommonTree IDENTIFIER40=null;
        AliasMasker.cmd_return cmd41 =null;

        AliasMasker.func_clause_return func_clause42 =null;


        CommonTree DEFINE39_tree=null;
        CommonTree IDENTIFIER40_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:143:5: ( ^( DEFINE IDENTIFIER ( cmd | func_clause ) ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:143:7: ^( DEFINE IDENTIFIER ( cmd | func_clause ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DEFINE39=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_define_clause533); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DEFINE39_tree = (CommonTree)adaptor.dupNode(DEFINE39);


            root_1 = (CommonTree)adaptor.becomeRoot(DEFINE39_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            IDENTIFIER40=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_define_clause535); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER40_tree = (CommonTree)adaptor.dupNode(IDENTIFIER40);


            adaptor.addChild(root_1, IDENTIFIER40_tree);
            }


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:143:29: ( cmd | func_clause )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==EXECCOMMAND) ) {
                alt6=1;
            }
            else if ( (LA6_0==FUNC||LA6_0==FUNC_REF) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:143:31: cmd
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cmd_in_define_clause540);
                    cmd41=cmd();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cmd41.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:143:37: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_define_clause544);
                    func_clause42=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause42.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:146:1: cmd : ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* ) ;
    public final AliasMasker.cmd_return cmd() throws RecognitionException {
        AliasMasker.cmd_return retval = new AliasMasker.cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree EXECCOMMAND43=null;
        AliasMasker.ship_clause_return ship_clause44 =null;

        AliasMasker.cache_clause_return cache_clause45 =null;

        AliasMasker.input_clause_return input_clause46 =null;

        AliasMasker.output_clause_return output_clause47 =null;

        AliasMasker.error_clause_return error_clause48 =null;


        CommonTree EXECCOMMAND43_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:147:5: ( ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:147:7: ^( EXECCOMMAND ( ship_clause | cache_clause | input_clause | output_clause | error_clause )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            EXECCOMMAND43=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_cmd563); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EXECCOMMAND43_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND43);


            root_1 = (CommonTree)adaptor.becomeRoot(EXECCOMMAND43_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:148:9: ( ship_clause | cache_clause | input_clause | output_clause | error_clause )*
                loop7:
                do {
                    int alt7=6;
                    switch ( input.LA(1) ) {
                    case SHIP:
                        {
                        alt7=1;
                        }
                        break;
                    case CACHE:
                        {
                        alt7=2;
                        }
                        break;
                    case INPUT:
                        {
                        alt7=3;
                        }
                        break;
                    case OUTPUT:
                        {
                        alt7=4;
                        }
                        break;
                    case STDERROR:
                        {
                        alt7=5;
                        }
                        break;

                    }

                    switch (alt7) {
                	case 1 :
                	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:148:11: ship_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_ship_clause_in_cmd575);
                	    ship_clause44=ship_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, ship_clause44.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 2 :
                	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:148:25: cache_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_cache_clause_in_cmd579);
                	    cache_clause45=cache_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, cache_clause45.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 3 :
                	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:148:40: input_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_input_clause_in_cmd583);
                	    input_clause46=input_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, input_clause46.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 4 :
                	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:148:55: output_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_output_clause_in_cmd587);
                	    output_clause47=output_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, output_clause47.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 5 :
                	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:148:71: error_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_error_clause_in_cmd591);
                	    error_clause48=error_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, error_clause48.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop7;
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:151:1: ship_clause : ^( SHIP ( path_list )? ) ;
    public final AliasMasker.ship_clause_return ship_clause() throws RecognitionException {
        AliasMasker.ship_clause_return retval = new AliasMasker.ship_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SHIP49=null;
        AliasMasker.path_list_return path_list50 =null;


        CommonTree SHIP49_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:152:5: ( ^( SHIP ( path_list )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:152:7: ^( SHIP ( path_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SHIP49=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_ship_clause611); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHIP49_tree = (CommonTree)adaptor.dupNode(SHIP49);


            root_1 = (CommonTree)adaptor.becomeRoot(SHIP49_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:152:15: ( path_list )?
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==QUOTEDSTRING) ) {
                    alt8=1;
                }
                switch (alt8) {
                    case 1 :
                        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:152:15: path_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_path_list_in_ship_clause613);
                        path_list50=path_list();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, path_list50.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:155:1: path_list : ( QUOTEDSTRING )+ ;
    public final AliasMasker.path_list_return path_list() throws RecognitionException {
        AliasMasker.path_list_return retval = new AliasMasker.path_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING51=null;

        CommonTree QUOTEDSTRING51_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:156:5: ( ( QUOTEDSTRING )+ )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:156:7: ( QUOTEDSTRING )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:156:7: ( QUOTEDSTRING )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==QUOTEDSTRING) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:156:7: QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    QUOTEDSTRING51=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_path_list629); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    QUOTEDSTRING51_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING51);


            	    adaptor.addChild(root_0, QUOTEDSTRING51_tree);
            	    }


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:159:1: cache_clause : ^( CACHE path_list ) ;
    public final AliasMasker.cache_clause_return cache_clause() throws RecognitionException {
        AliasMasker.cache_clause_return retval = new AliasMasker.cache_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CACHE52=null;
        AliasMasker.path_list_return path_list53 =null;


        CommonTree CACHE52_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:160:5: ( ^( CACHE path_list ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:160:7: ^( CACHE path_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CACHE52=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_cache_clause645); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CACHE52_tree = (CommonTree)adaptor.dupNode(CACHE52);


            root_1 = (CommonTree)adaptor.becomeRoot(CACHE52_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_path_list_in_cache_clause647);
            path_list53=path_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, path_list53.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:163:1: input_clause : ^( INPUT ( stream_cmd )+ ) ;
    public final AliasMasker.input_clause_return input_clause() throws RecognitionException {
        AliasMasker.input_clause_return retval = new AliasMasker.input_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INPUT54=null;
        AliasMasker.stream_cmd_return stream_cmd55 =null;


        CommonTree INPUT54_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:164:5: ( ^( INPUT ( stream_cmd )+ ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:164:7: ^( INPUT ( stream_cmd )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            INPUT54=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_input_clause664); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INPUT54_tree = (CommonTree)adaptor.dupNode(INPUT54);


            root_1 = (CommonTree)adaptor.becomeRoot(INPUT54_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:164:16: ( stream_cmd )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==QUOTEDSTRING||(LA10_0 >= STDIN && LA10_0 <= STDOUT)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:164:16: stream_cmd
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_input_clause666);
            	    stream_cmd55=stream_cmd();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd55.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:167:1: stream_cmd : ( ^( STDIN ( func_clause )? ) | ^( STDOUT ( func_clause )? ) | ^( QUOTEDSTRING ( func_clause )? ) );
    public final AliasMasker.stream_cmd_return stream_cmd() throws RecognitionException {
        AliasMasker.stream_cmd_return retval = new AliasMasker.stream_cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDIN56=null;
        CommonTree STDOUT58=null;
        CommonTree QUOTEDSTRING60=null;
        AliasMasker.func_clause_return func_clause57 =null;

        AliasMasker.func_clause_return func_clause59 =null;

        AliasMasker.func_clause_return func_clause61 =null;


        CommonTree STDIN56_tree=null;
        CommonTree STDOUT58_tree=null;
        CommonTree QUOTEDSTRING60_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:168:5: ( ^( STDIN ( func_clause )? ) | ^( STDOUT ( func_clause )? ) | ^( QUOTEDSTRING ( func_clause )? ) )
            int alt14=3;
            switch ( input.LA(1) ) {
            case STDIN:
                {
                alt14=1;
                }
                break;
            case STDOUT:
                {
                alt14=2;
                }
                break;
            case QUOTEDSTRING:
                {
                alt14=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }

            switch (alt14) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:168:7: ^( STDIN ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDIN56=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_stream_cmd684); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN56_tree = (CommonTree)adaptor.dupNode(STDIN56);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDIN56_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:168:16: ( func_clause )?
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==FUNC||LA11_0==FUNC_REF) ) {
                            alt11=1;
                        }
                        switch (alt11) {
                            case 1 :
                                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:168:16: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd686);
                                func_clause57=func_clause();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause57.getTree());


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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:169:7: ^( STDOUT ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDOUT58=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_stream_cmd699); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT58_tree = (CommonTree)adaptor.dupNode(STDOUT58);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDOUT58_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:169:17: ( func_clause )?
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==FUNC||LA12_0==FUNC_REF) ) {
                            alt12=1;
                        }
                        switch (alt12) {
                            case 1 :
                                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:169:17: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd701);
                                func_clause59=func_clause();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause59.getTree());


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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:170:7: ^( QUOTEDSTRING ( func_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING60=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_stream_cmd714); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING60_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING60);


                    root_1 = (CommonTree)adaptor.becomeRoot(QUOTEDSTRING60_tree, root_1);
                    }


                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:170:23: ( func_clause )?
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==FUNC||LA13_0==FUNC_REF) ) {
                            alt13=1;
                        }
                        switch (alt13) {
                            case 1 :
                                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:170:23: func_clause
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd716);
                                func_clause61=func_clause();

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause61.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:173:1: output_clause : ^( OUTPUT ( stream_cmd )+ ) ;
    public final AliasMasker.output_clause_return output_clause() throws RecognitionException {
        AliasMasker.output_clause_return retval = new AliasMasker.output_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OUTPUT62=null;
        AliasMasker.stream_cmd_return stream_cmd63 =null;


        CommonTree OUTPUT62_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:174:5: ( ^( OUTPUT ( stream_cmd )+ ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:174:7: ^( OUTPUT ( stream_cmd )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OUTPUT62=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_output_clause734); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OUTPUT62_tree = (CommonTree)adaptor.dupNode(OUTPUT62);


            root_1 = (CommonTree)adaptor.becomeRoot(OUTPUT62_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:174:17: ( stream_cmd )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==QUOTEDSTRING||(LA15_0 >= STDIN && LA15_0 <= STDOUT)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:174:17: stream_cmd
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_output_clause736);
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
            	    if ( cnt15 >= 1 ) break loop15;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:177:1: error_clause : ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) ;
    public final AliasMasker.error_clause_return error_clause() throws RecognitionException {
        AliasMasker.error_clause_return retval = new AliasMasker.error_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDERROR64=null;
        CommonTree QUOTEDSTRING65=null;
        CommonTree INTEGER66=null;

        CommonTree STDERROR64_tree=null;
        CommonTree QUOTEDSTRING65_tree=null;
        CommonTree INTEGER66_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:178:5: ( ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:178:7: ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STDERROR64=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_error_clause754); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STDERROR64_tree = (CommonTree)adaptor.dupNode(STDERROR64);


            root_1 = (CommonTree)adaptor.becomeRoot(STDERROR64_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:178:19: ( QUOTEDSTRING ( INTEGER )? )?
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==QUOTEDSTRING) ) {
                    alt17=1;
                }
                switch (alt17) {
                    case 1 :
                        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:178:21: QUOTEDSTRING ( INTEGER )?
                        {
                        _last = (CommonTree)input.LT(1);
                        QUOTEDSTRING65=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_error_clause758); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        QUOTEDSTRING65_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING65);


                        adaptor.addChild(root_1, QUOTEDSTRING65_tree);
                        }


                        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:178:34: ( INTEGER )?
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==INTEGER) ) {
                            alt16=1;
                        }
                        switch (alt16) {
                            case 1 :
                                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:178:34: INTEGER
                                {
                                _last = (CommonTree)input.LT(1);
                                INTEGER66=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_error_clause760); if (state.failed) return retval;
                                if ( state.backtracking==0 ) {
                                INTEGER66_tree = (CommonTree)adaptor.dupNode(INTEGER66);


                                adaptor.addChild(root_1, INTEGER66_tree);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:181:1: load_clause : ^( LOAD filename ( func_clause )? ( as_clause )? ) ;
    public final AliasMasker.load_clause_return load_clause() throws RecognitionException {
        AliasMasker.load_clause_return retval = new AliasMasker.load_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LOAD67=null;
        AliasMasker.filename_return filename68 =null;

        AliasMasker.func_clause_return func_clause69 =null;

        AliasMasker.as_clause_return as_clause70 =null;


        CommonTree LOAD67_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:182:5: ( ^( LOAD filename ( func_clause )? ( as_clause )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:182:7: ^( LOAD filename ( func_clause )? ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LOAD67=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_load_clause781); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LOAD67_tree = (CommonTree)adaptor.dupNode(LOAD67);


            root_1 = (CommonTree)adaptor.becomeRoot(LOAD67_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_load_clause783);
            filename68=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename68.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:182:24: ( func_clause )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==FUNC||LA18_0==FUNC_REF) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:182:24: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_load_clause785);
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


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:182:37: ( as_clause )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==AS) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:182:37: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_load_clause788);
                    as_clause70=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause70.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:185:1: filename : QUOTEDSTRING ;
    public final AliasMasker.filename_return filename() throws RecognitionException {
        AliasMasker.filename_return retval = new AliasMasker.filename_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING71=null;

        CommonTree QUOTEDSTRING71_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:186:5: ( QUOTEDSTRING )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:186:7: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING71=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_filename804); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING71_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING71);


            adaptor.addChild(root_0, QUOTEDSTRING71_tree);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:189:1: as_clause : ^( AS field_def_list ) ;
    public final AliasMasker.as_clause_return as_clause() throws RecognitionException {
        AliasMasker.as_clause_return retval = new AliasMasker.as_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AS72=null;
        AliasMasker.field_def_list_return field_def_list73 =null;


        CommonTree AS72_tree=null;


        	inAsOrGenClause = true;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:196:5: ( ^( AS field_def_list ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:196:7: ^( AS field_def_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            AS72=(CommonTree)match(input,AS,FOLLOW_AS_in_as_clause829); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            AS72_tree = (CommonTree)adaptor.dupNode(AS72);


            root_1 = (CommonTree)adaptor.becomeRoot(AS72_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_field_def_list_in_as_clause831);
            field_def_list73=field_def_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, field_def_list73.getTree());


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

            if ( state.backtracking==0 ) {
            	inAsOrGenClause = false;
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:199:1: field_def : ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF_WITHOUT_IDENTIFIER type ) );
    public final AliasMasker.field_def_return field_def() throws RecognitionException {
        AliasMasker.field_def_return retval = new AliasMasker.field_def_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FIELD_DEF74=null;
        CommonTree IDENTIFIER75=null;
        CommonTree FIELD_DEF_WITHOUT_IDENTIFIER77=null;
        AliasMasker.type_return type76 =null;

        AliasMasker.type_return type78 =null;


        CommonTree FIELD_DEF74_tree=null;
        CommonTree IDENTIFIER75_tree=null;
        CommonTree FIELD_DEF_WITHOUT_IDENTIFIER77_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:200:5: ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF_WITHOUT_IDENTIFIER type ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==FIELD_DEF) ) {
                alt21=1;
            }
            else if ( (LA21_0==FIELD_DEF_WITHOUT_IDENTIFIER) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;

            }
            switch (alt21) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:200:7: ^( FIELD_DEF IDENTIFIER ( type )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF74=(CommonTree)match(input,FIELD_DEF,FOLLOW_FIELD_DEF_in_field_def848); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF74_tree = (CommonTree)adaptor.dupNode(FIELD_DEF74);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF74_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER75=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_field_def850); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER75_tree = (CommonTree)adaptor.dupNode(IDENTIFIER75);


                    adaptor.addChild(root_1, IDENTIFIER75_tree);
                    }


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:200:31: ( type )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==BIGDECIMAL||LA20_0==BIGINTEGER||LA20_0==BOOLEAN||LA20_0==BYTEARRAY||LA20_0==CHARARRAY||LA20_0==DATETIME||LA20_0==DOUBLE||LA20_0==FLOAT||LA20_0==INT||LA20_0==LONG||LA20_0==BAG_TYPE||LA20_0==MAP_TYPE||LA20_0==TUPLE_TYPE) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:200:31: type
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_type_in_field_def852);
                            type76=type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, type76.getTree());


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
                    	if (inAsOrGenClause) {
                    		if (aliasSeen.contains((IDENTIFIER75!=null?IDENTIFIER75.getText():null))) {
                    			throw new ParserValidationException(input, new SourceLocation((PigParserNode)((CommonTree)retval.start)),
                    				"Macro doesn't support user defined schema that contains name that conflicts with alias name: " + (IDENTIFIER75!=null?IDENTIFIER75.getText():null));
                    		}
                    	}
                    }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:208:7: ^( FIELD_DEF_WITHOUT_IDENTIFIER type )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF_WITHOUT_IDENTIFIER77=(CommonTree)match(input,FIELD_DEF_WITHOUT_IDENTIFIER,FOLLOW_FIELD_DEF_WITHOUT_IDENTIFIER_in_field_def867); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF_WITHOUT_IDENTIFIER77_tree = (CommonTree)adaptor.dupNode(FIELD_DEF_WITHOUT_IDENTIFIER77);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF_WITHOUT_IDENTIFIER77_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_field_def869);
                    type78=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type78.getTree());


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


    public static class field_def_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field_def_list"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:211:1: field_def_list : ( field_def )+ ;
    public final AliasMasker.field_def_list_return field_def_list() throws RecognitionException {
        AliasMasker.field_def_list_return retval = new AliasMasker.field_def_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.field_def_return field_def79 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:212:5: ( ( field_def )+ )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:212:7: ( field_def )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:212:7: ( field_def )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0 >= FIELD_DEF && LA22_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:212:7: field_def
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_field_def_in_field_def_list884);
            	    field_def79=field_def();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, field_def79.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
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
    // $ANTLR end "field_def_list"


    public static class type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:215:1: type : ( simple_type | tuple_type | bag_type | map_type );
    public final AliasMasker.type_return type() throws RecognitionException {
        AliasMasker.type_return retval = new AliasMasker.type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.simple_type_return simple_type80 =null;

        AliasMasker.tuple_type_return tuple_type81 =null;

        AliasMasker.bag_type_return bag_type82 =null;

        AliasMasker.map_type_return map_type83 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:215:6: ( simple_type | tuple_type | bag_type | map_type )
            int alt23=4;
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
                alt23=1;
                }
                break;
            case TUPLE_TYPE:
                {
                alt23=2;
                }
                break;
            case BAG_TYPE:
                {
                alt23=3;
                }
                break;
            case MAP_TYPE:
                {
                alt23=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;

            }

            switch (alt23) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:215:8: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type894);
                    simple_type80=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type80.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:215:22: tuple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_in_type898);
                    tuple_type81=tuple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type81.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:215:35: bag_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_in_type902);
                    bag_type82=bag_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type82.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:215:46: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type906);
                    map_type83=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type83.getTree());


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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "simple_type"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:218:1: simple_type : ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | DATETIME | BIGINTEGER | BIGDECIMAL | CHARARRAY | BYTEARRAY );
    public final AliasMasker.simple_type_return simple_type() throws RecognitionException {
        AliasMasker.simple_type_return retval = new AliasMasker.simple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set84=null;

        CommonTree set84_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:219:5: ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | DATETIME | BIGINTEGER | BIGDECIMAL | CHARARRAY | BYTEARRAY )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set84=(CommonTree)input.LT(1);

            if ( input.LA(1)==BIGDECIMAL||input.LA(1)==BIGINTEGER||input.LA(1)==BOOLEAN||input.LA(1)==BYTEARRAY||input.LA(1)==CHARARRAY||input.LA(1)==DATETIME||input.LA(1)==DOUBLE||input.LA(1)==FLOAT||input.LA(1)==INT||input.LA(1)==LONG ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set84_tree = (CommonTree)adaptor.dupNode(set84);


                adaptor.addChild(root_0, set84_tree);
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
    // $ANTLR end "simple_type"


    public static class tuple_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple_type"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:222:1: tuple_type : ^( TUPLE_TYPE ( field_def_list )? ) ;
    public final AliasMasker.tuple_type_return tuple_type() throws RecognitionException {
        AliasMasker.tuple_type_return retval = new AliasMasker.tuple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE85=null;
        AliasMasker.field_def_list_return field_def_list86 =null;


        CommonTree TUPLE_TYPE85_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:223:5: ( ^( TUPLE_TYPE ( field_def_list )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:223:7: ^( TUPLE_TYPE ( field_def_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE85=(CommonTree)match(input,TUPLE_TYPE,FOLLOW_TUPLE_TYPE_in_tuple_type970); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE85_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE85);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE85_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:223:21: ( field_def_list )?
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0 >= FIELD_DEF && LA24_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                    alt24=1;
                }
                switch (alt24) {
                    case 1 :
                        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:223:21: field_def_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_field_def_list_in_tuple_type972);
                        field_def_list86=field_def_list();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, field_def_list86.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:226:1: bag_type : ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) ;
    public final AliasMasker.bag_type_return bag_type() throws RecognitionException {
        AliasMasker.bag_type_return retval = new AliasMasker.bag_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE87=null;
        CommonTree IDENTIFIER88=null;
        AliasMasker.tuple_type_return tuple_type89 =null;


        CommonTree BAG_TYPE87_tree=null;
        CommonTree IDENTIFIER88_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:227:5: ( ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:227:7: ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE87=(CommonTree)match(input,BAG_TYPE,FOLLOW_BAG_TYPE_in_bag_type990); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE87_tree = (CommonTree)adaptor.dupNode(BAG_TYPE87);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE87_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:227:19: ( IDENTIFIER )?
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==IDENTIFIER) ) {
                    alt25=1;
                }
                switch (alt25) {
                    case 1 :
                        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:227:19: IDENTIFIER
                        {
                        _last = (CommonTree)input.LT(1);
                        IDENTIFIER88=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_bag_type992); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        IDENTIFIER88_tree = (CommonTree)adaptor.dupNode(IDENTIFIER88);


                        adaptor.addChild(root_1, IDENTIFIER88_tree);
                        }


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:227:31: ( tuple_type )?
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==TUPLE_TYPE) ) {
                    alt26=1;
                }
                switch (alt26) {
                    case 1 :
                        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:227:31: tuple_type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_in_bag_type995);
                        tuple_type89=tuple_type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type89.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:230:1: map_type : ^( MAP_TYPE ( type )? ) ;
    public final AliasMasker.map_type_return map_type() throws RecognitionException {
        AliasMasker.map_type_return retval = new AliasMasker.map_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_TYPE90=null;
        AliasMasker.type_return type91 =null;


        CommonTree MAP_TYPE90_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:230:10: ( ^( MAP_TYPE ( type )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:230:12: ^( MAP_TYPE ( type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_TYPE90=(CommonTree)match(input,MAP_TYPE,FOLLOW_MAP_TYPE_in_map_type1009); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_TYPE90_tree = (CommonTree)adaptor.dupNode(MAP_TYPE90);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_TYPE90_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:230:24: ( type )?
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==BIGDECIMAL||LA27_0==BIGINTEGER||LA27_0==BOOLEAN||LA27_0==BYTEARRAY||LA27_0==CHARARRAY||LA27_0==DATETIME||LA27_0==DOUBLE||LA27_0==FLOAT||LA27_0==INT||LA27_0==LONG||LA27_0==BAG_TYPE||LA27_0==MAP_TYPE||LA27_0==TUPLE_TYPE) ) {
                    alt27=1;
                }
                switch (alt27) {
                    case 1 :
                        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:230:24: type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_type_in_map_type1011);
                        type91=type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, type91.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:233:1: func_clause : ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) );
    public final AliasMasker.func_clause_return func_clause() throws RecognitionException {
        AliasMasker.func_clause_return retval = new AliasMasker.func_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_REF92=null;
        CommonTree FUNC94=null;
        AliasMasker.func_name_return func_name93 =null;

        AliasMasker.func_name_return func_name95 =null;

        AliasMasker.func_args_return func_args96 =null;


        CommonTree FUNC_REF92_tree=null;
        CommonTree FUNC94_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:234:5: ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==FUNC_REF) ) {
                alt29=1;
            }
            else if ( (LA29_0==FUNC) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;

            }
            switch (alt29) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:234:7: ^( FUNC_REF func_name )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_REF92=(CommonTree)match(input,FUNC_REF,FOLLOW_FUNC_REF_in_func_clause1029); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_REF92_tree = (CommonTree)adaptor.dupNode(FUNC_REF92);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_REF92_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1031);
                    func_name93=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name93.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:235:7: ^( FUNC func_name ( func_args )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC94=(CommonTree)match(input,FUNC,FOLLOW_FUNC_in_func_clause1043); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC94_tree = (CommonTree)adaptor.dupNode(FUNC94);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC94_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1045);
                    func_name95=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name95.getTree());


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:235:25: ( func_args )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==QUOTEDSTRING) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:235:25: func_args
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_func_args_in_func_clause1047);
                            func_args96=func_args();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, func_args96.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:238:1: func_name : eid ( ( PERIOD | DOLLAR ) eid )* ;
    public final AliasMasker.func_name_return func_name() throws RecognitionException {
        AliasMasker.func_name_return retval = new AliasMasker.func_name_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set98=null;
        AliasMasker.eid_return eid97 =null;

        AliasMasker.eid_return eid99 =null;


        CommonTree set98_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:239:5: ( eid ( ( PERIOD | DOLLAR ) eid )* )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:239:7: eid ( ( PERIOD | DOLLAR ) eid )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_eid_in_func_name1063);
            eid97=eid();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, eid97.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:239:11: ( ( PERIOD | DOLLAR ) eid )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==DOLLAR||LA30_0==PERIOD) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:239:13: ( PERIOD | DOLLAR ) eid
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    set98=(CommonTree)input.LT(1);

            	    if ( input.LA(1)==DOLLAR||input.LA(1)==PERIOD ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) {
            	        set98_tree = (CommonTree)adaptor.dupNode(set98);


            	        adaptor.addChild(root_0, set98_tree);
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
            	    pushFollow(FOLLOW_eid_in_func_name1077);
            	    eid99=eid();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, eid99.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop30;
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


    public static class func_args_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_args"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:242:1: func_args : ( QUOTEDSTRING )+ ;
    public final AliasMasker.func_args_return func_args() throws RecognitionException {
        AliasMasker.func_args_return retval = new AliasMasker.func_args_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING100=null;

        CommonTree QUOTEDSTRING100_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:243:5: ( ( QUOTEDSTRING )+ )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:243:7: ( QUOTEDSTRING )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:243:7: ( QUOTEDSTRING )+
            int cnt31=0;
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==QUOTEDSTRING) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:243:7: QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    QUOTEDSTRING100=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_func_args1093); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    QUOTEDSTRING100_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING100);


            	    adaptor.addChild(root_0, QUOTEDSTRING100_tree);
            	    }


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt31 >= 1 ) break loop31;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(31, input);
                        throw eee;
                }
                cnt31++;
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:246:1: cube_clause : ^( CUBE cube_item ) ;
    public final AliasMasker.cube_clause_return cube_clause() throws RecognitionException {
        AliasMasker.cube_clause_return retval = new AliasMasker.cube_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CUBE101=null;
        AliasMasker.cube_item_return cube_item102 =null;


        CommonTree CUBE101_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:247:5: ( ^( CUBE cube_item ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:247:7: ^( CUBE cube_item )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CUBE101=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_cube_clause1109); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CUBE101_tree = (CommonTree)adaptor.dupNode(CUBE101);


            root_1 = (CommonTree)adaptor.becomeRoot(CUBE101_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_item_in_cube_clause1111);
            cube_item102=cube_item();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_item102.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:250:1: cube_item : rel ( cube_by_clause ) ;
    public final AliasMasker.cube_item_return cube_item() throws RecognitionException {
        AliasMasker.cube_item_return retval = new AliasMasker.cube_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.rel_return rel103 =null;

        AliasMasker.cube_by_clause_return cube_by_clause104 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:251:5: ( rel ( cube_by_clause ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:251:7: rel ( cube_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_cube_item1126);
            rel103=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel103.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:251:11: ( cube_by_clause )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:251:13: cube_by_clause
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_by_clause_in_cube_item1130);
            cube_by_clause104=cube_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, cube_by_clause104.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:254:1: cube_by_clause : ^( BY cube_or_rollup ) ;
    public final AliasMasker.cube_by_clause_return cube_by_clause() throws RecognitionException {
        AliasMasker.cube_by_clause_return retval = new AliasMasker.cube_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY105=null;
        AliasMasker.cube_or_rollup_return cube_or_rollup106 =null;


        CommonTree BY105_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:255:5: ( ^( BY cube_or_rollup ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:255:7: ^( BY cube_or_rollup )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY105=(CommonTree)match(input,BY,FOLLOW_BY_in_cube_by_clause1147); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY105_tree = (CommonTree)adaptor.dupNode(BY105);


            root_1 = (CommonTree)adaptor.becomeRoot(BY105_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_or_rollup_in_cube_by_clause1149);
            cube_or_rollup106=cube_or_rollup();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_or_rollup106.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:258:1: cube_or_rollup : ( cube_rollup_list )+ ;
    public final AliasMasker.cube_or_rollup_return cube_or_rollup() throws RecognitionException {
        AliasMasker.cube_or_rollup_return retval = new AliasMasker.cube_or_rollup_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.cube_rollup_list_return cube_rollup_list107 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:259:5: ( ( cube_rollup_list )+ )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:259:7: ( cube_rollup_list )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:259:7: ( cube_rollup_list )+
            int cnt32=0;
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==CUBE||LA32_0==ROLLUP) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:259:7: cube_rollup_list
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_rollup_list_in_cube_or_rollup1164);
            	    cube_rollup_list107=cube_rollup_list();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, cube_rollup_list107.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt32 >= 1 ) break loop32;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:262:1: cube_rollup_list : ^( ( CUBE | ROLLUP ) cube_by_expr_list ) ;
    public final AliasMasker.cube_rollup_list_return cube_rollup_list() throws RecognitionException {
        AliasMasker.cube_rollup_list_return retval = new AliasMasker.cube_rollup_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set108=null;
        AliasMasker.cube_by_expr_list_return cube_by_expr_list109 =null;


        CommonTree set108_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:263:5: ( ^( ( CUBE | ROLLUP ) cube_by_expr_list ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:263:7: ^( ( CUBE | ROLLUP ) cube_by_expr_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            set108=(CommonTree)input.LT(1);

            if ( input.LA(1)==CUBE||input.LA(1)==ROLLUP ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set108_tree = (CommonTree)adaptor.dupNode(set108);


                root_1 = (CommonTree)adaptor.becomeRoot(set108_tree, root_1);
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
            pushFollow(FOLLOW_cube_by_expr_list_in_cube_rollup_list1190);
            cube_by_expr_list109=cube_by_expr_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_by_expr_list109.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:266:1: cube_by_expr_list : ( cube_by_expr )+ ;
    public final AliasMasker.cube_by_expr_list_return cube_by_expr_list() throws RecognitionException {
        AliasMasker.cube_by_expr_list_return retval = new AliasMasker.cube_by_expr_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.cube_by_expr_return cube_by_expr110 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:267:5: ( ( cube_by_expr )+ )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:267:7: ( cube_by_expr )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:267:7: ( cube_by_expr )+
            int cnt33=0;
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==BIGDECIMALNUMBER||LA33_0==BIGINTEGERNUMBER||LA33_0==CUBE||LA33_0==DIV||LA33_0==DOLLARVAR||LA33_0==DOUBLENUMBER||LA33_0==FALSE||LA33_0==FLOATNUMBER||LA33_0==GROUP||LA33_0==IDENTIFIER||LA33_0==INTEGER||LA33_0==LONGINTEGER||LA33_0==MINUS||LA33_0==NULL||LA33_0==PERCENT||LA33_0==PLUS||LA33_0==QUOTEDSTRING||LA33_0==STAR||LA33_0==TRUE||(LA33_0 >= BAG_VAL && LA33_0 <= BIN_EXPR)||(LA33_0 >= CASE_COND && LA33_0 <= CASE_EXPR)||(LA33_0 >= CAST_EXPR && LA33_0 <= EXPR_IN_PAREN)||LA33_0==FUNC_EVAL||(LA33_0 >= MAP_VAL && LA33_0 <= NEG)||LA33_0==TUPLE_VAL) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:267:7: cube_by_expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_by_expr_in_cube_by_expr_list1205);
            	    cube_by_expr110=cube_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, cube_by_expr110.getTree());


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
    // $ANTLR end "cube_by_expr_list"


    public static class cube_by_expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_expr"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:270:1: cube_by_expr : ( col_range | expr | STAR );
    public final AliasMasker.cube_by_expr_return cube_by_expr() throws RecognitionException {
        AliasMasker.cube_by_expr_return retval = new AliasMasker.cube_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR113=null;
        AliasMasker.col_range_return col_range111 =null;

        AliasMasker.expr_return expr112 =null;


        CommonTree STAR113_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:271:5: ( col_range | expr | STAR )
            int alt34=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt34=1;
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
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt34=2;
                }
                break;
            case STAR:
                {
                int LA34_3 = input.LA(2);

                if ( (LA34_3==DOWN) ) {
                    alt34=2;
                }
                else if ( (LA34_3==EOF||LA34_3==UP||LA34_3==BIGDECIMALNUMBER||LA34_3==BIGINTEGERNUMBER||LA34_3==CUBE||LA34_3==DIV||LA34_3==DOLLARVAR||LA34_3==DOUBLENUMBER||LA34_3==FALSE||LA34_3==FLOATNUMBER||LA34_3==GROUP||LA34_3==IDENTIFIER||LA34_3==INTEGER||LA34_3==LONGINTEGER||LA34_3==MINUS||LA34_3==NULL||LA34_3==PERCENT||LA34_3==PLUS||LA34_3==QUOTEDSTRING||LA34_3==STAR||LA34_3==TRUE||(LA34_3 >= BAG_VAL && LA34_3 <= BIN_EXPR)||(LA34_3 >= CASE_COND && LA34_3 <= CASE_EXPR)||(LA34_3 >= CAST_EXPR && LA34_3 <= EXPR_IN_PAREN)||LA34_3==FUNC_EVAL||(LA34_3 >= MAP_VAL && LA34_3 <= NEG)||LA34_3==TUPLE_VAL) ) {
                    alt34=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 34, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;

            }

            switch (alt34) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:271:7: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_cube_by_expr1219);
                    col_range111=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range111.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:271:19: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cube_by_expr1223);
                    expr112=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr112.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:271:26: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR113=(CommonTree)match(input,STAR,FOLLOW_STAR_in_cube_by_expr1227); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR113_tree = (CommonTree)adaptor.dupNode(STAR113);


                    adaptor.addChild(root_0, STAR113_tree);
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


    public static class group_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:274:1: group_clause : ^( ( GROUP | COGROUP ) ( group_item )+ ( group_type )? ( partition_clause )? ) ;
    public final AliasMasker.group_clause_return group_clause() throws RecognitionException {
        AliasMasker.group_clause_return retval = new AliasMasker.group_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set114=null;
        AliasMasker.group_item_return group_item115 =null;

        AliasMasker.group_type_return group_type116 =null;

        AliasMasker.partition_clause_return partition_clause117 =null;


        CommonTree set114_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:275:5: ( ^( ( GROUP | COGROUP ) ( group_item )+ ( group_type )? ( partition_clause )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:275:7: ^( ( GROUP | COGROUP ) ( group_item )+ ( group_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            set114=(CommonTree)input.LT(1);

            if ( input.LA(1)==COGROUP||input.LA(1)==GROUP ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set114_tree = (CommonTree)adaptor.dupNode(set114);


                root_1 = (CommonTree)adaptor.becomeRoot(set114_tree, root_1);
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
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:275:30: ( group_item )+
            int cnt35=0;
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==ASSERT||LA35_0==COGROUP||(LA35_0 >= CROSS && LA35_0 <= CUBE)||LA35_0==DEFINE||LA35_0==DISTINCT||LA35_0==FILTER||LA35_0==FOREACH||LA35_0==GROUP||LA35_0==IDENTIFIER||LA35_0==JOIN||(LA35_0 >= LIMIT && LA35_0 <= LOAD)||LA35_0==MAPREDUCE||LA35_0==ORDER||LA35_0==RANK||LA35_0==SAMPLE||LA35_0==SPLIT||(LA35_0 >= STORE && LA35_0 <= STREAM)||LA35_0==UNION) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:275:30: group_item
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_group_item_in_group_clause1252);
            	    group_item115=group_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, group_item115.getTree());


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


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:275:42: ( group_type )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==QUOTEDSTRING) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:275:42: group_type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_type_in_group_clause1255);
                    group_type116=group_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, group_type116.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:275:54: ( partition_clause )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==PARTITION) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:275:54: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_group_clause1258);
                    partition_clause117=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause117.getTree());


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
    // $ANTLR end "group_clause"


    public static class group_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_type"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:278:1: group_type : QUOTEDSTRING ;
    public final AliasMasker.group_type_return group_type() throws RecognitionException {
        AliasMasker.group_type_return retval = new AliasMasker.group_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING118=null;

        CommonTree QUOTEDSTRING118_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:278:12: ( QUOTEDSTRING )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:278:14: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING118=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_group_type1270); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING118_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING118);


            adaptor.addChild(root_0, QUOTEDSTRING118_tree);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:281:1: group_item : rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? ;
    public final AliasMasker.group_item_return group_item() throws RecognitionException {
        AliasMasker.group_item_return retval = new AliasMasker.group_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ALL121=null;
        CommonTree ANY122=null;
        CommonTree set123=null;
        AliasMasker.rel_return rel119 =null;

        AliasMasker.join_group_by_clause_return join_group_by_clause120 =null;


        CommonTree ALL121_tree=null;
        CommonTree ANY122_tree=null;
        CommonTree set123_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:282:5: ( rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:282:7: rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )?
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_group_item1283);
            rel119=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel119.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:282:11: ( join_group_by_clause | ALL | ANY )
            int alt38=3;
            switch ( input.LA(1) ) {
            case BY:
                {
                alt38=1;
                }
                break;
            case ALL:
                {
                alt38=2;
                }
                break;
            case ANY:
                {
                alt38=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;

            }

            switch (alt38) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:282:13: join_group_by_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_group_by_clause_in_group_item1287);
                    join_group_by_clause120=join_group_by_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_group_by_clause120.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:282:36: ALL
                    {
                    _last = (CommonTree)input.LT(1);
                    ALL121=(CommonTree)match(input,ALL,FOLLOW_ALL_in_group_item1291); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL121_tree = (CommonTree)adaptor.dupNode(ALL121);


                    adaptor.addChild(root_0, ALL121_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:282:42: ANY
                    {
                    _last = (CommonTree)input.LT(1);
                    ANY122=(CommonTree)match(input,ANY,FOLLOW_ANY_in_group_item1295); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ANY122_tree = (CommonTree)adaptor.dupNode(ANY122);


                    adaptor.addChild(root_0, ANY122_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:282:48: ( INNER | OUTER )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==INNER||LA39_0==OUTER) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:
                    {
                    _last = (CommonTree)input.LT(1);
                    set123=(CommonTree)input.LT(1);

                    if ( input.LA(1)==INNER||input.LA(1)==OUTER ) {
                        input.consume();
                        if ( state.backtracking==0 ) {
                        set123_tree = (CommonTree)adaptor.dupNode(set123);


                        adaptor.addChild(root_0, set123_tree);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:285:1: rel : ( alias | ( op_clause ( parallel_clause )? ) );
    public final AliasMasker.rel_return rel() throws RecognitionException {
        AliasMasker.rel_return retval = new AliasMasker.rel_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.alias_return alias124 =null;

        AliasMasker.op_clause_return op_clause125 =null;

        AliasMasker.parallel_clause_return parallel_clause126 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:286:5: ( alias | ( op_clause ( parallel_clause )? ) )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==IDENTIFIER) ) {
                alt41=1;
            }
            else if ( (LA41_0==ASSERT||LA41_0==COGROUP||(LA41_0 >= CROSS && LA41_0 <= CUBE)||LA41_0==DEFINE||LA41_0==DISTINCT||LA41_0==FILTER||LA41_0==FOREACH||LA41_0==GROUP||LA41_0==JOIN||(LA41_0 >= LIMIT && LA41_0 <= LOAD)||LA41_0==MAPREDUCE||LA41_0==ORDER||LA41_0==RANK||LA41_0==SAMPLE||LA41_0==SPLIT||(LA41_0 >= STORE && LA41_0 <= STREAM)||LA41_0==UNION) ) {
                alt41=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;

            }
            switch (alt41) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:286:7: alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_rel1321);
                    alias124=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias124.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:286:15: ( op_clause ( parallel_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:286:15: ( op_clause ( parallel_clause )? )
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:286:17: op_clause ( parallel_clause )?
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_op_clause_in_rel1327);
                    op_clause125=op_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, op_clause125.getTree());


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:286:27: ( parallel_clause )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==PARALLEL) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:286:27: parallel_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_parallel_clause_in_rel1329);
                            parallel_clause126=parallel_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_0, parallel_clause126.getTree());


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:289:1: flatten_generated_item : ( flatten_clause | col_range | expr | STAR ) ( field_def_list )? ;
    public final AliasMasker.flatten_generated_item_return flatten_generated_item() throws RecognitionException {
        AliasMasker.flatten_generated_item_return retval = new AliasMasker.flatten_generated_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR130=null;
        AliasMasker.flatten_clause_return flatten_clause127 =null;

        AliasMasker.col_range_return col_range128 =null;

        AliasMasker.expr_return expr129 =null;

        AliasMasker.field_def_list_return field_def_list131 =null;


        CommonTree STAR130_tree=null;


        	inAsOrGenClause = true;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:296:5: ( ( flatten_clause | col_range | expr | STAR ) ( field_def_list )? )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:296:7: ( flatten_clause | col_range | expr | STAR ) ( field_def_list )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:296:7: ( flatten_clause | col_range | expr | STAR )
            int alt42=4;
            switch ( input.LA(1) ) {
            case FLATTEN:
                {
                alt42=1;
                }
                break;
            case COL_RANGE:
                {
                alt42=2;
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
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt42=3;
                }
                break;
            case STAR:
                {
                int LA42_4 = input.LA(2);

                if ( (LA42_4==DOWN) ) {
                    alt42=3;
                }
                else if ( (LA42_4==EOF||LA42_4==UP||LA42_4==BIGDECIMALNUMBER||LA42_4==BIGINTEGERNUMBER||LA42_4==CUBE||LA42_4==DIV||LA42_4==DOLLARVAR||LA42_4==DOUBLENUMBER||LA42_4==FALSE||LA42_4==FLATTEN||LA42_4==FLOATNUMBER||LA42_4==GROUP||LA42_4==IDENTIFIER||LA42_4==INTEGER||LA42_4==LONGINTEGER||LA42_4==MINUS||LA42_4==NULL||LA42_4==PERCENT||LA42_4==PLUS||LA42_4==QUOTEDSTRING||LA42_4==STAR||LA42_4==TRUE||(LA42_4 >= BAG_VAL && LA42_4 <= BIN_EXPR)||(LA42_4 >= CASE_COND && LA42_4 <= CASE_EXPR)||(LA42_4 >= CAST_EXPR && LA42_4 <= FIELD_DEF_WITHOUT_IDENTIFIER)||LA42_4==FUNC_EVAL||(LA42_4 >= MAP_VAL && LA42_4 <= NEG)||LA42_4==TUPLE_VAL) ) {
                    alt42=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 42, 4, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;

            }

            switch (alt42) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:296:9: flatten_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_flatten_clause_in_flatten_generated_item1357);
                    flatten_clause127=flatten_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, flatten_clause127.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:296:26: col_range
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_flatten_generated_item1361);
                    col_range128=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range128.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:296:38: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_flatten_generated_item1365);
                    expr129=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr129.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:296:45: STAR
                    {
                    _last = (CommonTree)input.LT(1);
                    STAR130=(CommonTree)match(input,STAR,FOLLOW_STAR_in_flatten_generated_item1369); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR130_tree = (CommonTree)adaptor.dupNode(STAR130);


                    adaptor.addChild(root_0, STAR130_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:296:52: ( field_def_list )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0 >= FIELD_DEF && LA43_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:296:52: field_def_list
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_field_def_list_in_flatten_generated_item1373);
                    field_def_list131=field_def_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, field_def_list131.getTree());


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

            if ( state.backtracking==0 ) {
            	inAsOrGenClause = false;
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:299:1: flatten_clause : ^( FLATTEN expr ) ;
    public final AliasMasker.flatten_clause_return flatten_clause() throws RecognitionException {
        AliasMasker.flatten_clause_return retval = new AliasMasker.flatten_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FLATTEN132=null;
        AliasMasker.expr_return expr133 =null;


        CommonTree FLATTEN132_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:300:5: ( ^( FLATTEN expr ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:300:7: ^( FLATTEN expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FLATTEN132=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_flatten_clause1389); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FLATTEN132_tree = (CommonTree)adaptor.dupNode(FLATTEN132);


            root_1 = (CommonTree)adaptor.becomeRoot(FLATTEN132_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_flatten_clause1391);
            expr133=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr133.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:303:1: store_clause : ^( STORE alias filename ( func_clause )? ) ;
    public final AliasMasker.store_clause_return store_clause() throws RecognitionException {
        AliasMasker.store_clause_return retval = new AliasMasker.store_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STORE134=null;
        AliasMasker.alias_return alias135 =null;

        AliasMasker.filename_return filename136 =null;

        AliasMasker.func_clause_return func_clause137 =null;


        CommonTree STORE134_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:304:5: ( ^( STORE alias filename ( func_clause )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:304:7: ^( STORE alias filename ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STORE134=(CommonTree)match(input,STORE,FOLLOW_STORE_in_store_clause1408); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STORE134_tree = (CommonTree)adaptor.dupNode(STORE134);


            root_1 = (CommonTree)adaptor.becomeRoot(STORE134_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_store_clause1410);
            alias135=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias135.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_store_clause1412);
            filename136=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename136.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:304:31: ( func_clause )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==FUNC||LA44_0==FUNC_REF) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:304:31: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_store_clause1414);
                    func_clause137=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause137.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:307:1: assert_clause : ^( ASSERT alias cond ( comment )? ) ;
    public final AliasMasker.assert_clause_return assert_clause() throws RecognitionException {
        AliasMasker.assert_clause_return retval = new AliasMasker.assert_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ASSERT138=null;
        AliasMasker.alias_return alias139 =null;

        AliasMasker.cond_return cond140 =null;

        AliasMasker.comment_return comment141 =null;


        CommonTree ASSERT138_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:308:5: ( ^( ASSERT alias cond ( comment )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:308:7: ^( ASSERT alias cond ( comment )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ASSERT138=(CommonTree)match(input,ASSERT,FOLLOW_ASSERT_in_assert_clause1432); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ASSERT138_tree = (CommonTree)adaptor.dupNode(ASSERT138);


            root_1 = (CommonTree)adaptor.becomeRoot(ASSERT138_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_assert_clause1434);
            alias139=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias139.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_assert_clause1436);
            cond140=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond140.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:308:28: ( comment )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==QUOTEDSTRING) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:308:28: comment
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_comment_in_assert_clause1438);
                    comment141=comment();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, comment141.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:311:1: comment : QUOTEDSTRING ;
    public final AliasMasker.comment_return comment() throws RecognitionException {
        AliasMasker.comment_return retval = new AliasMasker.comment_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING142=null;

        CommonTree QUOTEDSTRING142_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:311:9: ( QUOTEDSTRING )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:311:11: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING142=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_comment1450); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING142_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING142);


            adaptor.addChild(root_0, QUOTEDSTRING142_tree);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:314:1: filter_clause : ^( FILTER rel cond ) ;
    public final AliasMasker.filter_clause_return filter_clause() throws RecognitionException {
        AliasMasker.filter_clause_return retval = new AliasMasker.filter_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER143=null;
        AliasMasker.rel_return rel144 =null;

        AliasMasker.cond_return cond145 =null;


        CommonTree FILTER143_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:315:5: ( ^( FILTER rel cond ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:315:7: ^( FILTER rel cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER143=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_filter_clause1465); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER143_tree = (CommonTree)adaptor.dupNode(FILTER143);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER143_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_filter_clause1467);
            rel144=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel144.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_filter_clause1469);
            cond145=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond145.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:318:1: cond : ( ^( OR cond cond ) | ^( AND cond cond ) | ^( NOT cond ) | ^( NULL expr ( NOT )? ) | ^( rel_op expr expr ) | in_eval | func_eval | ^( BOOL_COND expr ) );
    public final AliasMasker.cond_return cond() throws RecognitionException {
        AliasMasker.cond_return retval = new AliasMasker.cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OR146=null;
        CommonTree AND149=null;
        CommonTree NOT152=null;
        CommonTree NULL154=null;
        CommonTree NOT156=null;
        CommonTree BOOL_COND162=null;
        AliasMasker.cond_return cond147 =null;

        AliasMasker.cond_return cond148 =null;

        AliasMasker.cond_return cond150 =null;

        AliasMasker.cond_return cond151 =null;

        AliasMasker.cond_return cond153 =null;

        AliasMasker.expr_return expr155 =null;

        AliasMasker.rel_op_return rel_op157 =null;

        AliasMasker.expr_return expr158 =null;

        AliasMasker.expr_return expr159 =null;

        AliasMasker.in_eval_return in_eval160 =null;

        AliasMasker.func_eval_return func_eval161 =null;

        AliasMasker.expr_return expr163 =null;


        CommonTree OR146_tree=null;
        CommonTree AND149_tree=null;
        CommonTree NOT152_tree=null;
        CommonTree NULL154_tree=null;
        CommonTree NOT156_tree=null;
        CommonTree BOOL_COND162_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:319:5: ( ^( OR cond cond ) | ^( AND cond cond ) | ^( NOT cond ) | ^( NULL expr ( NOT )? ) | ^( rel_op expr expr ) | in_eval | func_eval | ^( BOOL_COND expr ) )
            int alt47=8;
            switch ( input.LA(1) ) {
            case OR:
                {
                alt47=1;
                }
                break;
            case AND:
                {
                alt47=2;
                }
                break;
            case NOT:
                {
                alt47=3;
                }
                break;
            case NULL:
                {
                alt47=4;
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
                alt47=5;
                }
                break;
            case IN:
                {
                alt47=6;
                }
                break;
            case FUNC_EVAL:
                {
                alt47=7;
                }
                break;
            case BOOL_COND:
                {
                alt47=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;

            }

            switch (alt47) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:319:7: ^( OR cond cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    OR146=(CommonTree)match(input,OR,FOLLOW_OR_in_cond1486); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR146_tree = (CommonTree)adaptor.dupNode(OR146);


                    root_1 = (CommonTree)adaptor.becomeRoot(OR146_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1488);
                    cond147=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond147.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1490);
                    cond148=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond148.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:320:7: ^( AND cond cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    AND149=(CommonTree)match(input,AND,FOLLOW_AND_in_cond1502); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND149_tree = (CommonTree)adaptor.dupNode(AND149);


                    root_1 = (CommonTree)adaptor.becomeRoot(AND149_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1504);
                    cond150=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond150.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1506);
                    cond151=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond151.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:321:7: ^( NOT cond )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NOT152=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond1518); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT152_tree = (CommonTree)adaptor.dupNode(NOT152);


                    root_1 = (CommonTree)adaptor.becomeRoot(NOT152_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond1520);
                    cond153=cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cond153.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:322:7: ^( NULL expr ( NOT )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NULL154=(CommonTree)match(input,NULL,FOLLOW_NULL_in_cond1532); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL154_tree = (CommonTree)adaptor.dupNode(NULL154);


                    root_1 = (CommonTree)adaptor.becomeRoot(NULL154_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1534);
                    expr155=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr155.getTree());


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:322:20: ( NOT )?
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==NOT) ) {
                        alt46=1;
                    }
                    switch (alt46) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:322:20: NOT
                            {
                            _last = (CommonTree)input.LT(1);
                            NOT156=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond1536); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NOT156_tree = (CommonTree)adaptor.dupNode(NOT156);


                            adaptor.addChild(root_1, NOT156_tree);
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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:323:7: ^( rel_op expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_in_cond1549);
                    rel_op157=rel_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op157.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1551);
                    expr158=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr158.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1553);
                    expr159=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr159.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:324:7: in_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_in_eval_in_cond1563);
                    in_eval160=in_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, in_eval160.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:325:7: func_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_cond1571);
                    func_eval161=func_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval161.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:326:7: ^( BOOL_COND expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    BOOL_COND162=(CommonTree)match(input,BOOL_COND,FOLLOW_BOOL_COND_in_cond1581); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOL_COND162_tree = (CommonTree)adaptor.dupNode(BOOL_COND162);


                    root_1 = (CommonTree)adaptor.becomeRoot(BOOL_COND162_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond1583);
                    expr163=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr163.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:329:1: in_eval : ^( IN ( ^( IN_LHS expr ) ^( IN_RHS expr ) )+ ) ;
    public final AliasMasker.in_eval_return in_eval() throws RecognitionException {
        AliasMasker.in_eval_return retval = new AliasMasker.in_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IN164=null;
        CommonTree IN_LHS165=null;
        CommonTree IN_RHS167=null;
        AliasMasker.expr_return expr166 =null;

        AliasMasker.expr_return expr168 =null;


        CommonTree IN164_tree=null;
        CommonTree IN_LHS165_tree=null;
        CommonTree IN_RHS167_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:330:5: ( ^( IN ( ^( IN_LHS expr ) ^( IN_RHS expr ) )+ ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:330:7: ^( IN ( ^( IN_LHS expr ) ^( IN_RHS expr ) )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            IN164=(CommonTree)match(input,IN,FOLLOW_IN_in_in_eval1600); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IN164_tree = (CommonTree)adaptor.dupNode(IN164);


            root_1 = (CommonTree)adaptor.becomeRoot(IN164_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:330:13: ( ^( IN_LHS expr ) ^( IN_RHS expr ) )+
            int cnt48=0;
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==IN_LHS) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:330:15: ^( IN_LHS expr ) ^( IN_RHS expr )
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_2 = _last;
            	    CommonTree _first_2 = null;
            	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    IN_LHS165=(CommonTree)match(input,IN_LHS,FOLLOW_IN_LHS_in_in_eval1606); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IN_LHS165_tree = (CommonTree)adaptor.dupNode(IN_LHS165);


            	    root_2 = (CommonTree)adaptor.becomeRoot(IN_LHS165_tree, root_2);
            	    }


            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_in_eval1608);
            	    expr166=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr166.getTree());


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
            	    IN_RHS167=(CommonTree)match(input,IN_RHS,FOLLOW_IN_RHS_in_in_eval1614); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IN_RHS167_tree = (CommonTree)adaptor.dupNode(IN_RHS167);


            	    root_2 = (CommonTree)adaptor.becomeRoot(IN_RHS167_tree, root_2);
            	    }


            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_in_eval1616);
            	    expr168=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr168.getTree());


            	    match(input, Token.UP, null); if (state.failed) return retval;
            	    adaptor.addChild(root_1, root_2);
            	    _last = _save_last_2;
            	    }


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt48 >= 1 ) break loop48;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(48, input);
                        throw eee;
                }
                cnt48++;
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:333:1: func_eval : ^( FUNC_EVAL func_name ( real_arg )* ) ;
    public final AliasMasker.func_eval_return func_eval() throws RecognitionException {
        AliasMasker.func_eval_return retval = new AliasMasker.func_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_EVAL169=null;
        AliasMasker.func_name_return func_name170 =null;

        AliasMasker.real_arg_return real_arg171 =null;


        CommonTree FUNC_EVAL169_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:334:5: ( ^( FUNC_EVAL func_name ( real_arg )* ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:334:7: ^( FUNC_EVAL func_name ( real_arg )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FUNC_EVAL169=(CommonTree)match(input,FUNC_EVAL,FOLLOW_FUNC_EVAL_in_func_eval1638); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FUNC_EVAL169_tree = (CommonTree)adaptor.dupNode(FUNC_EVAL169);


            root_1 = (CommonTree)adaptor.becomeRoot(FUNC_EVAL169_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_func_name_in_func_eval1640);
            func_name170=func_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, func_name170.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:334:30: ( real_arg )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==BIGDECIMALNUMBER||LA49_0==BIGINTEGERNUMBER||LA49_0==CUBE||LA49_0==DIV||LA49_0==DOLLARVAR||LA49_0==DOUBLENUMBER||LA49_0==FALSE||LA49_0==FLOATNUMBER||LA49_0==GROUP||LA49_0==IDENTIFIER||LA49_0==INTEGER||LA49_0==LONGINTEGER||LA49_0==MINUS||LA49_0==NULL||LA49_0==PERCENT||LA49_0==PLUS||LA49_0==QUOTEDSTRING||LA49_0==STAR||LA49_0==TRUE||(LA49_0 >= BAG_VAL && LA49_0 <= BIN_EXPR)||(LA49_0 >= CASE_COND && LA49_0 <= CASE_EXPR)||LA49_0==CAST_EXPR||LA49_0==EXPR_IN_PAREN||LA49_0==FUNC_EVAL||(LA49_0 >= MAP_VAL && LA49_0 <= NEG)||LA49_0==TUPLE_VAL) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:334:30: real_arg
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_real_arg_in_func_eval1642);
            	    real_arg171=real_arg();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, real_arg171.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop49;
                }
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
    // $ANTLR end "func_eval"


    public static class real_arg_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "real_arg"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:337:1: real_arg : ( expr | STAR );
    public final AliasMasker.real_arg_return real_arg() throws RecognitionException {
        AliasMasker.real_arg_return retval = new AliasMasker.real_arg_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR173=null;
        AliasMasker.expr_return expr172 =null;


        CommonTree STAR173_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:338:5: ( expr | STAR )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==BIGDECIMALNUMBER||LA50_0==BIGINTEGERNUMBER||LA50_0==CUBE||LA50_0==DIV||LA50_0==DOLLARVAR||LA50_0==DOUBLENUMBER||LA50_0==FALSE||LA50_0==FLOATNUMBER||LA50_0==GROUP||LA50_0==IDENTIFIER||LA50_0==INTEGER||LA50_0==LONGINTEGER||LA50_0==MINUS||LA50_0==NULL||LA50_0==PERCENT||LA50_0==PLUS||LA50_0==QUOTEDSTRING||LA50_0==TRUE||(LA50_0 >= BAG_VAL && LA50_0 <= BIN_EXPR)||(LA50_0 >= CASE_COND && LA50_0 <= CASE_EXPR)||LA50_0==CAST_EXPR||LA50_0==EXPR_IN_PAREN||LA50_0==FUNC_EVAL||(LA50_0 >= MAP_VAL && LA50_0 <= NEG)||LA50_0==TUPLE_VAL) ) {
                alt50=1;
            }
            else if ( (LA50_0==STAR) ) {
                int LA50_2 = input.LA(2);

                if ( (LA50_2==DOWN) ) {
                    alt50=1;
                }
                else if ( (LA50_2==EOF||LA50_2==UP||LA50_2==BIGDECIMALNUMBER||LA50_2==BIGINTEGERNUMBER||LA50_2==CUBE||LA50_2==DIV||LA50_2==DOLLARVAR||LA50_2==DOUBLENUMBER||LA50_2==FALSE||LA50_2==FLOATNUMBER||LA50_2==GROUP||LA50_2==IDENTIFIER||LA50_2==INTEGER||LA50_2==LONGINTEGER||LA50_2==MINUS||LA50_2==NULL||LA50_2==PERCENT||LA50_2==PLUS||LA50_2==QUOTEDSTRING||LA50_2==STAR||LA50_2==TRUE||(LA50_2 >= BAG_VAL && LA50_2 <= BIN_EXPR)||(LA50_2 >= CASE_COND && LA50_2 <= CASE_EXPR)||LA50_2==CAST_EXPR||LA50_2==EXPR_IN_PAREN||LA50_2==FUNC_EVAL||(LA50_2 >= MAP_VAL && LA50_2 <= NEG)||LA50_2==TUPLE_VAL) ) {
                    alt50=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 50, 2, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;

            }
            switch (alt50) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:338:7: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_real_arg1658);
                    expr172=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr172.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:338:14: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR173=(CommonTree)match(input,STAR,FOLLOW_STAR_in_real_arg1662); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR173_tree = (CommonTree)adaptor.dupNode(STAR173);


                    adaptor.addChild(root_0, STAR173_tree);
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
    // $ANTLR end "real_arg"


    public static class expr_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expr"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:341:1: expr : ( ^( PLUS expr expr ) | ^( MINUS expr expr ) | ^( STAR expr expr ) | ^( DIV expr expr ) | ^( PERCENT expr expr ) | ^( CAST_EXPR type expr ) | const_expr | var_expr | ^( NEG expr ) | ^( CAST_EXPR type_cast expr ) | ^( EXPR_IN_PAREN expr ) );
    public final AliasMasker.expr_return expr() throws RecognitionException {
        AliasMasker.expr_return retval = new AliasMasker.expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PLUS174=null;
        CommonTree MINUS177=null;
        CommonTree STAR180=null;
        CommonTree DIV183=null;
        CommonTree PERCENT186=null;
        CommonTree CAST_EXPR189=null;
        CommonTree NEG194=null;
        CommonTree CAST_EXPR196=null;
        CommonTree EXPR_IN_PAREN199=null;
        AliasMasker.expr_return expr175 =null;

        AliasMasker.expr_return expr176 =null;

        AliasMasker.expr_return expr178 =null;

        AliasMasker.expr_return expr179 =null;

        AliasMasker.expr_return expr181 =null;

        AliasMasker.expr_return expr182 =null;

        AliasMasker.expr_return expr184 =null;

        AliasMasker.expr_return expr185 =null;

        AliasMasker.expr_return expr187 =null;

        AliasMasker.expr_return expr188 =null;

        AliasMasker.type_return type190 =null;

        AliasMasker.expr_return expr191 =null;

        AliasMasker.const_expr_return const_expr192 =null;

        AliasMasker.var_expr_return var_expr193 =null;

        AliasMasker.expr_return expr195 =null;

        AliasMasker.type_cast_return type_cast197 =null;

        AliasMasker.expr_return expr198 =null;

        AliasMasker.expr_return expr200 =null;


        CommonTree PLUS174_tree=null;
        CommonTree MINUS177_tree=null;
        CommonTree STAR180_tree=null;
        CommonTree DIV183_tree=null;
        CommonTree PERCENT186_tree=null;
        CommonTree CAST_EXPR189_tree=null;
        CommonTree NEG194_tree=null;
        CommonTree CAST_EXPR196_tree=null;
        CommonTree EXPR_IN_PAREN199_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:342:5: ( ^( PLUS expr expr ) | ^( MINUS expr expr ) | ^( STAR expr expr ) | ^( DIV expr expr ) | ^( PERCENT expr expr ) | ^( CAST_EXPR type expr ) | const_expr | var_expr | ^( NEG expr ) | ^( CAST_EXPR type_cast expr ) | ^( EXPR_IN_PAREN expr ) )
            int alt51=11;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt51=1;
                }
                break;
            case MINUS:
                {
                int LA51_2 = input.LA(2);

                if ( (synpred101_AliasMasker()) ) {
                    alt51=2;
                }
                else if ( (synpred106_AliasMasker()) ) {
                    alt51=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 51, 2, input);

                    throw nvae;

                }
                }
                break;
            case STAR:
                {
                alt51=3;
                }
                break;
            case DIV:
                {
                alt51=4;
                }
                break;
            case PERCENT:
                {
                alt51=5;
                }
                break;
            case CAST_EXPR:
                {
                int LA51_6 = input.LA(2);

                if ( (synpred105_AliasMasker()) ) {
                    alt51=6;
                }
                else if ( (synpred109_AliasMasker()) ) {
                    alt51=10;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 51, 6, input);

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
                alt51=7;
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
                {
                alt51=8;
                }
                break;
            case NEG:
                {
                alt51=9;
                }
                break;
            case EXPR_IN_PAREN:
                {
                alt51=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;

            }

            switch (alt51) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:342:7: ^( PLUS expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PLUS174=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expr1677); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PLUS174_tree = (CommonTree)adaptor.dupNode(PLUS174);


                    root_1 = (CommonTree)adaptor.becomeRoot(PLUS174_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1679);
                    expr175=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr175.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1681);
                    expr176=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr176.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:343:7: ^( MINUS expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    MINUS177=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expr1693); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS177_tree = (CommonTree)adaptor.dupNode(MINUS177);


                    root_1 = (CommonTree)adaptor.becomeRoot(MINUS177_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1695);
                    expr178=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr178.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1697);
                    expr179=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr179.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:344:7: ^( STAR expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STAR180=(CommonTree)match(input,STAR,FOLLOW_STAR_in_expr1709); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR180_tree = (CommonTree)adaptor.dupNode(STAR180);


                    root_1 = (CommonTree)adaptor.becomeRoot(STAR180_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1711);
                    expr181=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr181.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1713);
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
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:345:7: ^( DIV expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    DIV183=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expr1725); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DIV183_tree = (CommonTree)adaptor.dupNode(DIV183);


                    root_1 = (CommonTree)adaptor.becomeRoot(DIV183_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1727);
                    expr184=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr184.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1729);
                    expr185=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr185.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:346:7: ^( PERCENT expr expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PERCENT186=(CommonTree)match(input,PERCENT,FOLLOW_PERCENT_in_expr1741); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PERCENT186_tree = (CommonTree)adaptor.dupNode(PERCENT186);


                    root_1 = (CommonTree)adaptor.becomeRoot(PERCENT186_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1743);
                    expr187=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr187.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1745);
                    expr188=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr188.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:347:7: ^( CAST_EXPR type expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR189=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr1757); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR189_tree = (CommonTree)adaptor.dupNode(CAST_EXPR189);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR189_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_expr1759);
                    type190=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type190.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1761);
                    expr191=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr191.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:348:7: const_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_const_expr_in_expr1771);
                    const_expr192=const_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, const_expr192.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:349:7: var_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_var_expr_in_expr1779);
                    var_expr193=var_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, var_expr193.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:350:7: ^( NEG expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NEG194=(CommonTree)match(input,NEG,FOLLOW_NEG_in_expr1789); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NEG194_tree = (CommonTree)adaptor.dupNode(NEG194);


                    root_1 = (CommonTree)adaptor.becomeRoot(NEG194_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1791);
                    expr195=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr195.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:351:7: ^( CAST_EXPR type_cast expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR196=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr1803); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR196_tree = (CommonTree)adaptor.dupNode(CAST_EXPR196);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR196_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_cast_in_expr1805);
                    type_cast197=type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type_cast197.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1807);
                    expr198=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr198.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:352:7: ^( EXPR_IN_PAREN expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    EXPR_IN_PAREN199=(CommonTree)match(input,EXPR_IN_PAREN,FOLLOW_EXPR_IN_PAREN_in_expr1819); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXPR_IN_PAREN199_tree = (CommonTree)adaptor.dupNode(EXPR_IN_PAREN199);


                    root_1 = (CommonTree)adaptor.becomeRoot(EXPR_IN_PAREN199_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr1821);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:355:1: type_cast : ( simple_type | map_type | tuple_type_cast | bag_type_cast );
    public final AliasMasker.type_cast_return type_cast() throws RecognitionException {
        AliasMasker.type_cast_return retval = new AliasMasker.type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.simple_type_return simple_type201 =null;

        AliasMasker.map_type_return map_type202 =null;

        AliasMasker.tuple_type_cast_return tuple_type_cast203 =null;

        AliasMasker.bag_type_cast_return bag_type_cast204 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:356:5: ( simple_type | map_type | tuple_type_cast | bag_type_cast )
            int alt52=4;
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
                alt52=1;
                }
                break;
            case MAP_TYPE:
                {
                alt52=2;
                }
                break;
            case TUPLE_TYPE_CAST:
                {
                alt52=3;
                }
                break;
            case BAG_TYPE_CAST:
                {
                alt52=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;

            }

            switch (alt52) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:356:7: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type_cast1836);
                    simple_type201=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type201.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:356:21: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type_cast1840);
                    map_type202=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type202.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:356:32: tuple_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_cast_in_type_cast1844);
                    tuple_type_cast203=tuple_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type_cast203.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:356:50: bag_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_cast_in_type_cast1848);
                    bag_type_cast204=bag_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type_cast204.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:359:1: tuple_type_cast : ^( TUPLE_TYPE_CAST ( type_cast )* ) ;
    public final AliasMasker.tuple_type_cast_return tuple_type_cast() throws RecognitionException {
        AliasMasker.tuple_type_cast_return retval = new AliasMasker.tuple_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE_CAST205=null;
        AliasMasker.type_cast_return type_cast206 =null;


        CommonTree TUPLE_TYPE_CAST205_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:360:5: ( ^( TUPLE_TYPE_CAST ( type_cast )* ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:360:7: ^( TUPLE_TYPE_CAST ( type_cast )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE_CAST205=(CommonTree)match(input,TUPLE_TYPE_CAST,FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast1863); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE_CAST205_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE_CAST205);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE_CAST205_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:360:26: ( type_cast )*
                loop53:
                do {
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==BIGDECIMAL||LA53_0==BIGINTEGER||LA53_0==BOOLEAN||LA53_0==BYTEARRAY||LA53_0==CHARARRAY||LA53_0==DATETIME||LA53_0==DOUBLE||LA53_0==FLOAT||LA53_0==INT||LA53_0==LONG||LA53_0==BAG_TYPE_CAST||LA53_0==MAP_TYPE||LA53_0==TUPLE_TYPE_CAST) ) {
                        alt53=1;
                    }


                    switch (alt53) {
                	case 1 :
                	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:360:26: type_cast
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_type_cast_in_tuple_type_cast1865);
                	    type_cast206=type_cast();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, type_cast206.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop53;
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:363:1: bag_type_cast : ^( BAG_TYPE_CAST ( tuple_type_cast )? ) ;
    public final AliasMasker.bag_type_cast_return bag_type_cast() throws RecognitionException {
        AliasMasker.bag_type_cast_return retval = new AliasMasker.bag_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE_CAST207=null;
        AliasMasker.tuple_type_cast_return tuple_type_cast208 =null;


        CommonTree BAG_TYPE_CAST207_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:364:5: ( ^( BAG_TYPE_CAST ( tuple_type_cast )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:364:7: ^( BAG_TYPE_CAST ( tuple_type_cast )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE_CAST207=(CommonTree)match(input,BAG_TYPE_CAST,FOLLOW_BAG_TYPE_CAST_in_bag_type_cast1883); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE_CAST207_tree = (CommonTree)adaptor.dupNode(BAG_TYPE_CAST207);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE_CAST207_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:364:24: ( tuple_type_cast )?
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==TUPLE_TYPE_CAST) ) {
                    alt54=1;
                }
                switch (alt54) {
                    case 1 :
                        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:364:24: tuple_type_cast
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_cast_in_bag_type_cast1885);
                        tuple_type_cast208=tuple_type_cast();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type_cast208.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:367:1: var_expr : projectable_expr ( dot_proj | pound_proj )* ;
    public final AliasMasker.var_expr_return var_expr() throws RecognitionException {
        AliasMasker.var_expr_return retval = new AliasMasker.var_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.projectable_expr_return projectable_expr209 =null;

        AliasMasker.dot_proj_return dot_proj210 =null;

        AliasMasker.pound_proj_return pound_proj211 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:368:5: ( projectable_expr ( dot_proj | pound_proj )* )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:368:7: projectable_expr ( dot_proj | pound_proj )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_projectable_expr_in_var_expr1901);
            projectable_expr209=projectable_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, projectable_expr209.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:368:24: ( dot_proj | pound_proj )*
            loop55:
            do {
                int alt55=3;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==PERIOD) ) {
                    alt55=1;
                }
                else if ( (LA55_0==POUND) ) {
                    alt55=2;
                }


                switch (alt55) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:368:26: dot_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_dot_proj_in_var_expr1905);
            	    dot_proj210=dot_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, dot_proj210.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:368:37: pound_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_pound_proj_in_var_expr1909);
            	    pound_proj211=pound_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, pound_proj211.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop55;
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:371:1: projectable_expr : ( func_eval | col_ref | bin_expr | case_expr | case_cond );
    public final AliasMasker.projectable_expr_return projectable_expr() throws RecognitionException {
        AliasMasker.projectable_expr_return retval = new AliasMasker.projectable_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.func_eval_return func_eval212 =null;

        AliasMasker.col_ref_return col_ref213 =null;

        AliasMasker.bin_expr_return bin_expr214 =null;

        AliasMasker.case_expr_return case_expr215 =null;

        AliasMasker.case_cond_return case_cond216 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:372:5: ( func_eval | col_ref | bin_expr | case_expr | case_cond )
            int alt56=5;
            switch ( input.LA(1) ) {
            case FUNC_EVAL:
                {
                alt56=1;
                }
                break;
            case CUBE:
            case DOLLARVAR:
            case GROUP:
            case IDENTIFIER:
                {
                alt56=2;
                }
                break;
            case BIN_EXPR:
                {
                alt56=3;
                }
                break;
            case CASE_EXPR:
                {
                alt56=4;
                }
                break;
            case CASE_COND:
                {
                alt56=5;
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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:372:7: func_eval
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_projectable_expr1925);
                    func_eval212=func_eval();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval212.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:372:19: col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_projectable_expr1929);
                    col_ref213=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref213.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:372:29: bin_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bin_expr_in_projectable_expr1933);
                    bin_expr214=bin_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bin_expr214.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:372:40: case_expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_case_expr_in_projectable_expr1937);
                    case_expr215=case_expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, case_expr215.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:372:52: case_cond
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_case_cond_in_projectable_expr1941);
                    case_cond216=case_cond();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, case_cond216.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:375:1: dot_proj : ^( PERIOD ( col_alias_or_index )+ ) ;
    public final AliasMasker.dot_proj_return dot_proj() throws RecognitionException {
        AliasMasker.dot_proj_return retval = new AliasMasker.dot_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PERIOD217=null;
        AliasMasker.col_alias_or_index_return col_alias_or_index218 =null;


        CommonTree PERIOD217_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:376:5: ( ^( PERIOD ( col_alias_or_index )+ ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:376:7: ^( PERIOD ( col_alias_or_index )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PERIOD217=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_dot_proj1956); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PERIOD217_tree = (CommonTree)adaptor.dupNode(PERIOD217);


            root_1 = (CommonTree)adaptor.becomeRoot(PERIOD217_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:376:17: ( col_alias_or_index )+
            int cnt57=0;
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==CUBE||LA57_0==DOLLARVAR||LA57_0==GROUP||LA57_0==IDENTIFIER) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:376:17: col_alias_or_index
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_alias_or_index_in_dot_proj1958);
            	    col_alias_or_index218=col_alias_or_index();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_alias_or_index218.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt57 >= 1 ) break loop57;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(57, input);
                        throw eee;
                }
                cnt57++;
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:379:1: col_alias_or_index : ( col_alias | col_index );
    public final AliasMasker.col_alias_or_index_return col_alias_or_index() throws RecognitionException {
        AliasMasker.col_alias_or_index_return retval = new AliasMasker.col_alias_or_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.col_alias_return col_alias219 =null;

        AliasMasker.col_index_return col_index220 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:379:20: ( col_alias | col_index )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==CUBE||LA58_0==GROUP||LA58_0==IDENTIFIER) ) {
                alt58=1;
            }
            else if ( (LA58_0==DOLLARVAR) ) {
                alt58=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;

            }
            switch (alt58) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:379:22: col_alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_alias_in_col_alias_or_index1970);
                    col_alias219=col_alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_alias219.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:379:34: col_index
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_index_in_col_alias_or_index1974);
                    col_index220=col_index();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_index220.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:382:1: col_alias : ( GROUP | CUBE | IDENTIFIER );
    public final AliasMasker.col_alias_return col_alias() throws RecognitionException {
        AliasMasker.col_alias_return retval = new AliasMasker.col_alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set221=null;

        CommonTree set221_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:383:5: ( GROUP | CUBE | IDENTIFIER )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set221=(CommonTree)input.LT(1);

            if ( input.LA(1)==CUBE||input.LA(1)==GROUP||input.LA(1)==IDENTIFIER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set221_tree = (CommonTree)adaptor.dupNode(set221);


                adaptor.addChild(root_0, set221_tree);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:388:1: col_index : DOLLARVAR ;
    public final AliasMasker.col_index_return col_index() throws RecognitionException {
        AliasMasker.col_index_return retval = new AliasMasker.col_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR222=null;

        CommonTree DOLLARVAR222_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:389:5: ( DOLLARVAR )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:389:7: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR222=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_col_index2016); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR222_tree = (CommonTree)adaptor.dupNode(DOLLARVAR222);


            adaptor.addChild(root_0, DOLLARVAR222_tree);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:392:1: col_range : ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? ) ;
    public final AliasMasker.col_range_return col_range() throws RecognitionException {
        AliasMasker.col_range_return retval = new AliasMasker.col_range_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree COL_RANGE223=null;
        CommonTree DOUBLE_PERIOD225=null;
        AliasMasker.col_ref_return col_ref224 =null;

        AliasMasker.col_ref_return col_ref226 =null;


        CommonTree COL_RANGE223_tree=null;
        CommonTree DOUBLE_PERIOD225_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:392:11: ( ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:392:14: ^( COL_RANGE ( col_ref )? DOUBLE_PERIOD ( col_ref )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            COL_RANGE223=(CommonTree)match(input,COL_RANGE,FOLLOW_COL_RANGE_in_col_range2027); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COL_RANGE223_tree = (CommonTree)adaptor.dupNode(COL_RANGE223);


            root_1 = (CommonTree)adaptor.becomeRoot(COL_RANGE223_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:392:26: ( col_ref )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==CUBE||LA59_0==DOLLARVAR||LA59_0==GROUP||LA59_0==IDENTIFIER) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:392:26: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range2029);
                    col_ref224=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, col_ref224.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            DOUBLE_PERIOD225=(CommonTree)match(input,DOUBLE_PERIOD,FOLLOW_DOUBLE_PERIOD_in_col_range2032); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOUBLE_PERIOD225_tree = (CommonTree)adaptor.dupNode(DOUBLE_PERIOD225);


            adaptor.addChild(root_1, DOUBLE_PERIOD225_tree);
            }


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:392:49: ( col_ref )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==CUBE||LA60_0==DOLLARVAR||LA60_0==GROUP||LA60_0==IDENTIFIER) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:392:49: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range2034);
                    col_ref226=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, col_ref226.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:395:1: pound_proj : ^( POUND ( QUOTEDSTRING | NULL ) ) ;
    public final AliasMasker.pound_proj_return pound_proj() throws RecognitionException {
        AliasMasker.pound_proj_return retval = new AliasMasker.pound_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POUND227=null;
        CommonTree set228=null;

        CommonTree POUND227_tree=null;
        CommonTree set228_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:396:5: ( ^( POUND ( QUOTEDSTRING | NULL ) ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:396:7: ^( POUND ( QUOTEDSTRING | NULL ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            POUND227=(CommonTree)match(input,POUND,FOLLOW_POUND_in_pound_proj2051); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            POUND227_tree = (CommonTree)adaptor.dupNode(POUND227);


            root_1 = (CommonTree)adaptor.becomeRoot(POUND227_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            set228=(CommonTree)input.LT(1);

            if ( input.LA(1)==NULL||input.LA(1)==QUOTEDSTRING ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set228_tree = (CommonTree)adaptor.dupNode(set228);


                adaptor.addChild(root_1, set228_tree);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:399:1: bin_expr : ^( BIN_EXPR cond expr expr ) ;
    public final AliasMasker.bin_expr_return bin_expr() throws RecognitionException {
        AliasMasker.bin_expr_return retval = new AliasMasker.bin_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BIN_EXPR229=null;
        AliasMasker.cond_return cond230 =null;

        AliasMasker.expr_return expr231 =null;

        AliasMasker.expr_return expr232 =null;


        CommonTree BIN_EXPR229_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:400:5: ( ^( BIN_EXPR cond expr expr ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:400:7: ^( BIN_EXPR cond expr expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BIN_EXPR229=(CommonTree)match(input,BIN_EXPR,FOLLOW_BIN_EXPR_in_bin_expr2078); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BIN_EXPR229_tree = (CommonTree)adaptor.dupNode(BIN_EXPR229);


            root_1 = (CommonTree)adaptor.becomeRoot(BIN_EXPR229_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_bin_expr2080);
            cond230=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond230.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr2082);
            expr231=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr231.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr2084);
            expr232=expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr232.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:403:1: case_expr : ^( CASE_EXPR ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )+ ) ;
    public final AliasMasker.case_expr_return case_expr() throws RecognitionException {
        AliasMasker.case_expr_return retval = new AliasMasker.case_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CASE_EXPR233=null;
        CommonTree CASE_EXPR_LHS234=null;
        CommonTree CASE_EXPR_RHS236=null;
        AliasMasker.expr_return expr235 =null;

        AliasMasker.expr_return expr237 =null;


        CommonTree CASE_EXPR233_tree=null;
        CommonTree CASE_EXPR_LHS234_tree=null;
        CommonTree CASE_EXPR_RHS236_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:404:5: ( ^( CASE_EXPR ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )+ ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:404:7: ^( CASE_EXPR ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CASE_EXPR233=(CommonTree)match(input,CASE_EXPR,FOLLOW_CASE_EXPR_in_case_expr2101); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE_EXPR233_tree = (CommonTree)adaptor.dupNode(CASE_EXPR233);


            root_1 = (CommonTree)adaptor.becomeRoot(CASE_EXPR233_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:404:20: ( ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+ )+
            int cnt62=0;
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==CASE_EXPR_LHS) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:404:22: ^( CASE_EXPR_LHS expr ) ( ^( CASE_EXPR_RHS expr ) )+
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_2 = _last;
            	    CommonTree _first_2 = null;
            	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    CASE_EXPR_LHS234=(CommonTree)match(input,CASE_EXPR_LHS,FOLLOW_CASE_EXPR_LHS_in_case_expr2107); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    CASE_EXPR_LHS234_tree = (CommonTree)adaptor.dupNode(CASE_EXPR_LHS234);


            	    root_2 = (CommonTree)adaptor.becomeRoot(CASE_EXPR_LHS234_tree, root_2);
            	    }


            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_case_expr2109);
            	    expr235=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr235.getTree());


            	    match(input, Token.UP, null); if (state.failed) return retval;
            	    adaptor.addChild(root_1, root_2);
            	    _last = _save_last_2;
            	    }


            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:404:46: ( ^( CASE_EXPR_RHS expr ) )+
            	    int cnt61=0;
            	    loop61:
            	    do {
            	        int alt61=2;
            	        int LA61_0 = input.LA(1);

            	        if ( (LA61_0==CASE_EXPR_RHS) ) {
            	            alt61=1;
            	        }


            	        switch (alt61) {
            	    	case 1 :
            	    	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:404:48: ^( CASE_EXPR_RHS expr )
            	    	    {
            	    	    _last = (CommonTree)input.LT(1);
            	    	    {
            	    	    CommonTree _save_last_2 = _last;
            	    	    CommonTree _first_2 = null;
            	    	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    	    _last = (CommonTree)input.LT(1);
            	    	    CASE_EXPR_RHS236=(CommonTree)match(input,CASE_EXPR_RHS,FOLLOW_CASE_EXPR_RHS_in_case_expr2117); if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) {
            	    	    CASE_EXPR_RHS236_tree = (CommonTree)adaptor.dupNode(CASE_EXPR_RHS236);


            	    	    root_2 = (CommonTree)adaptor.becomeRoot(CASE_EXPR_RHS236_tree, root_2);
            	    	    }


            	    	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    	    _last = (CommonTree)input.LT(1);
            	    	    pushFollow(FOLLOW_expr_in_case_expr2119);
            	    	    expr237=expr();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) 
            	    	    adaptor.addChild(root_2, expr237.getTree());


            	    	    match(input, Token.UP, null); if (state.failed) return retval;
            	    	    adaptor.addChild(root_1, root_2);
            	    	    _last = _save_last_2;
            	    	    }


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


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt62 >= 1 ) break loop62;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(62, input);
                        throw eee;
                }
                cnt62++;
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:407:1: case_cond : ^( CASE_COND ^( WHEN ( cond )+ ) ^( THEN ( expr )+ ) ) ;
    public final AliasMasker.case_cond_return case_cond() throws RecognitionException {
        AliasMasker.case_cond_return retval = new AliasMasker.case_cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CASE_COND238=null;
        CommonTree WHEN239=null;
        CommonTree THEN241=null;
        AliasMasker.cond_return cond240 =null;

        AliasMasker.expr_return expr242 =null;


        CommonTree CASE_COND238_tree=null;
        CommonTree WHEN239_tree=null;
        CommonTree THEN241_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:408:5: ( ^( CASE_COND ^( WHEN ( cond )+ ) ^( THEN ( expr )+ ) ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:408:7: ^( CASE_COND ^( WHEN ( cond )+ ) ^( THEN ( expr )+ ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CASE_COND238=(CommonTree)match(input,CASE_COND,FOLLOW_CASE_COND_in_case_cond2143); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE_COND238_tree = (CommonTree)adaptor.dupNode(CASE_COND238);


            root_1 = (CommonTree)adaptor.becomeRoot(CASE_COND238_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            WHEN239=(CommonTree)match(input,WHEN,FOLLOW_WHEN_in_case_cond2147); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            WHEN239_tree = (CommonTree)adaptor.dupNode(WHEN239);


            root_2 = (CommonTree)adaptor.becomeRoot(WHEN239_tree, root_2);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:408:28: ( cond )+
            int cnt63=0;
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==AND||LA63_0==IN||(LA63_0 >= NOT && LA63_0 <= NUM_OP_NE)||LA63_0==OR||(LA63_0 >= STR_OP_EQ && LA63_0 <= STR_OP_NE)||LA63_0==BOOL_COND||LA63_0==FUNC_EVAL) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:408:28: cond
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cond_in_case_cond2149);
            	    cond240=cond();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, cond240.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt63 >= 1 ) break loop63;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(63, input);
                        throw eee;
                }
                cnt63++;
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
            THEN241=(CommonTree)match(input,THEN,FOLLOW_THEN_in_case_cond2156); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            THEN241_tree = (CommonTree)adaptor.dupNode(THEN241);


            root_2 = (CommonTree)adaptor.becomeRoot(THEN241_tree, root_2);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:408:44: ( expr )+
            int cnt64=0;
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==BIGDECIMALNUMBER||LA64_0==BIGINTEGERNUMBER||LA64_0==CUBE||LA64_0==DIV||LA64_0==DOLLARVAR||LA64_0==DOUBLENUMBER||LA64_0==FALSE||LA64_0==FLOATNUMBER||LA64_0==GROUP||LA64_0==IDENTIFIER||LA64_0==INTEGER||LA64_0==LONGINTEGER||LA64_0==MINUS||LA64_0==NULL||LA64_0==PERCENT||LA64_0==PLUS||LA64_0==QUOTEDSTRING||LA64_0==STAR||LA64_0==TRUE||(LA64_0 >= BAG_VAL && LA64_0 <= BIN_EXPR)||(LA64_0 >= CASE_COND && LA64_0 <= CASE_EXPR)||LA64_0==CAST_EXPR||LA64_0==EXPR_IN_PAREN||LA64_0==FUNC_EVAL||(LA64_0 >= MAP_VAL && LA64_0 <= NEG)||LA64_0==TUPLE_VAL) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:408:44: expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_case_cond2158);
            	    expr242=expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr242.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt64 >= 1 ) break loop64;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(64, input);
                        throw eee;
                }
                cnt64++;
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:411:1: limit_clause : ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) ) ;
    public final AliasMasker.limit_clause_return limit_clause() throws RecognitionException {
        AliasMasker.limit_clause_return retval = new AliasMasker.limit_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT243=null;
        CommonTree INTEGER245=null;
        CommonTree LONGINTEGER246=null;
        AliasMasker.rel_return rel244 =null;

        AliasMasker.expr_return expr247 =null;


        CommonTree LIMIT243_tree=null;
        CommonTree INTEGER245_tree=null;
        CommonTree LONGINTEGER246_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:412:5: ( ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:412:7: ^( LIMIT rel ( INTEGER | LONGINTEGER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT243=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_limit_clause2178); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT243_tree = (CommonTree)adaptor.dupNode(LIMIT243);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT243_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_limit_clause2180);
            rel244=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel244.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:412:20: ( INTEGER | LONGINTEGER | expr )
            int alt65=3;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                int LA65_1 = input.LA(2);

                if ( (synpred132_AliasMasker()) ) {
                    alt65=1;
                }
                else if ( (true) ) {
                    alt65=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 65, 1, input);

                    throw nvae;

                }
                }
                break;
            case LONGINTEGER:
                {
                int LA65_2 = input.LA(2);

                if ( (synpred133_AliasMasker()) ) {
                    alt65=2;
                }
                else if ( (true) ) {
                    alt65=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 65, 2, input);

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
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt65=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;

            }

            switch (alt65) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:412:22: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER245=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_limit_clause2184); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER245_tree = (CommonTree)adaptor.dupNode(INTEGER245);


                    adaptor.addChild(root_1, INTEGER245_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:412:32: LONGINTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    LONGINTEGER246=(CommonTree)match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_limit_clause2188); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONGINTEGER246_tree = (CommonTree)adaptor.dupNode(LONGINTEGER246);


                    adaptor.addChild(root_1, LONGINTEGER246_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:412:46: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_limit_clause2192);
                    expr247=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr247.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:415:1: sample_clause : ^( SAMPLE rel ( DOUBLENUMBER | expr ) ) ;
    public final AliasMasker.sample_clause_return sample_clause() throws RecognitionException {
        AliasMasker.sample_clause_return retval = new AliasMasker.sample_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SAMPLE248=null;
        CommonTree DOUBLENUMBER250=null;
        AliasMasker.rel_return rel249 =null;

        AliasMasker.expr_return expr251 =null;


        CommonTree SAMPLE248_tree=null;
        CommonTree DOUBLENUMBER250_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:416:5: ( ^( SAMPLE rel ( DOUBLENUMBER | expr ) ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:416:8: ^( SAMPLE rel ( DOUBLENUMBER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SAMPLE248=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_sample_clause2212); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SAMPLE248_tree = (CommonTree)adaptor.dupNode(SAMPLE248);


            root_1 = (CommonTree)adaptor.becomeRoot(SAMPLE248_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_sample_clause2214);
            rel249=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel249.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:416:22: ( DOUBLENUMBER | expr )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==DOUBLENUMBER) ) {
                int LA66_1 = input.LA(2);

                if ( (synpred134_AliasMasker()) ) {
                    alt66=1;
                }
                else if ( (true) ) {
                    alt66=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 66, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA66_0==BIGDECIMALNUMBER||LA66_0==BIGINTEGERNUMBER||LA66_0==CUBE||LA66_0==DIV||LA66_0==DOLLARVAR||LA66_0==FALSE||LA66_0==FLOATNUMBER||LA66_0==GROUP||LA66_0==IDENTIFIER||LA66_0==INTEGER||LA66_0==LONGINTEGER||LA66_0==MINUS||LA66_0==NULL||LA66_0==PERCENT||LA66_0==PLUS||LA66_0==QUOTEDSTRING||LA66_0==STAR||LA66_0==TRUE||(LA66_0 >= BAG_VAL && LA66_0 <= BIN_EXPR)||(LA66_0 >= CASE_COND && LA66_0 <= CASE_EXPR)||LA66_0==CAST_EXPR||LA66_0==EXPR_IN_PAREN||LA66_0==FUNC_EVAL||(LA66_0 >= MAP_VAL && LA66_0 <= NEG)||LA66_0==TUPLE_VAL) ) {
                alt66=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;

            }
            switch (alt66) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:416:24: DOUBLENUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    DOUBLENUMBER250=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_sample_clause2218); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLENUMBER250_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER250);


                    adaptor.addChild(root_1, DOUBLENUMBER250_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:416:39: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_sample_clause2222);
                    expr251=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr251.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:419:1: rank_clause : ^( RANK rel ( rank_by_statement )? ) ;
    public final AliasMasker.rank_clause_return rank_clause() throws RecognitionException {
        AliasMasker.rank_clause_return retval = new AliasMasker.rank_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree RANK252=null;
        AliasMasker.rel_return rel253 =null;

        AliasMasker.rank_by_statement_return rank_by_statement254 =null;


        CommonTree RANK252_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:420:2: ( ^( RANK rel ( rank_by_statement )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:420:4: ^( RANK rel ( rank_by_statement )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            RANK252=(CommonTree)match(input,RANK,FOLLOW_RANK_in_rank_clause2238); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RANK252_tree = (CommonTree)adaptor.dupNode(RANK252);


            root_1 = (CommonTree)adaptor.becomeRoot(RANK252_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_rank_clause2240);
            rel253=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel253.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:420:16: ( rank_by_statement )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==BY) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:420:18: rank_by_statement
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_by_statement_in_rank_clause2244);
                    rank_by_statement254=rank_by_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, rank_by_statement254.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:423:1: rank_by_statement : ^( BY rank_by_clause ( DENSE )? ) ;
    public final AliasMasker.rank_by_statement_return rank_by_statement() throws RecognitionException {
        AliasMasker.rank_by_statement_return retval = new AliasMasker.rank_by_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY255=null;
        CommonTree DENSE257=null;
        AliasMasker.rank_by_clause_return rank_by_clause256 =null;


        CommonTree BY255_tree=null;
        CommonTree DENSE257_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:424:2: ( ^( BY rank_by_clause ( DENSE )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:424:4: ^( BY rank_by_clause ( DENSE )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY255=(CommonTree)match(input,BY,FOLLOW_BY_in_rank_by_statement2261); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY255_tree = (CommonTree)adaptor.dupNode(BY255);


            root_1 = (CommonTree)adaptor.becomeRoot(BY255_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rank_by_clause_in_rank_by_statement2263);
            rank_by_clause256=rank_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rank_by_clause256.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:424:25: ( DENSE )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==DENSE) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:424:27: DENSE
                    {
                    _last = (CommonTree)input.LT(1);
                    DENSE257=(CommonTree)match(input,DENSE,FOLLOW_DENSE_in_rank_by_statement2267); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DENSE257_tree = (CommonTree)adaptor.dupNode(DENSE257);


                    adaptor.addChild(root_1, DENSE257_tree);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:427:1: rank_by_clause : ( STAR ( ASC | DESC )? | ( rank_col )+ );
    public final AliasMasker.rank_by_clause_return rank_by_clause() throws RecognitionException {
        AliasMasker.rank_by_clause_return retval = new AliasMasker.rank_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR258=null;
        CommonTree set259=null;
        AliasMasker.rank_col_return rank_col260 =null;


        CommonTree STAR258_tree=null;
        CommonTree set259_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:428:2: ( STAR ( ASC | DESC )? | ( rank_col )+ )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==STAR) ) {
                alt71=1;
            }
            else if ( (LA71_0==CUBE||LA71_0==DOLLARVAR||LA71_0==GROUP||LA71_0==IDENTIFIER||LA71_0==COL_RANGE) ) {
                alt71=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;

            }
            switch (alt71) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:428:4: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR258=(CommonTree)match(input,STAR,FOLLOW_STAR_in_rank_by_clause2282); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR258_tree = (CommonTree)adaptor.dupNode(STAR258);


                    adaptor.addChild(root_0, STAR258_tree);
                    }


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:428:9: ( ASC | DESC )?
                    int alt69=2;
                    int LA69_0 = input.LA(1);

                    if ( (LA69_0==ASC||LA69_0==DESC) ) {
                        alt69=1;
                    }
                    switch (alt69) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set259=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set259_tree = (CommonTree)adaptor.dupNode(set259);


                                adaptor.addChild(root_0, set259_tree);
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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:429:7: ( rank_col )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:429:7: ( rank_col )+
                    int cnt70=0;
                    loop70:
                    do {
                        int alt70=2;
                        int LA70_0 = input.LA(1);

                        if ( (LA70_0==CUBE||LA70_0==DOLLARVAR||LA70_0==GROUP||LA70_0==IDENTIFIER||LA70_0==COL_RANGE) ) {
                            alt70=1;
                        }


                        switch (alt70) {
                    	case 1 :
                    	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:429:7: rank_col
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_rank_col_in_rank_by_clause2301);
                    	    rank_col260=rank_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, rank_col260.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt70 >= 1 ) break loop70;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(70, input);
                                throw eee;
                        }
                        cnt70++;
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:432:1: rank_col : ( col_range | col_ref ) ( ASC | DESC )? ;
    public final AliasMasker.rank_col_return rank_col() throws RecognitionException {
        AliasMasker.rank_col_return retval = new AliasMasker.rank_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set263=null;
        AliasMasker.col_range_return col_range261 =null;

        AliasMasker.col_ref_return col_ref262 =null;


        CommonTree set263_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:433:2: ( ( col_range | col_ref ) ( ASC | DESC )? )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:433:4: ( col_range | col_ref ) ( ASC | DESC )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:433:4: ( col_range | col_ref )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==COL_RANGE) ) {
                alt72=1;
            }
            else if ( (LA72_0==CUBE||LA72_0==DOLLARVAR||LA72_0==GROUP||LA72_0==IDENTIFIER) ) {
                alt72=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;

            }
            switch (alt72) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:433:6: col_range
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_rank_col2314);
                    col_range261=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range261.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:433:18: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_rank_col2318);
                    col_ref262=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref262.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:433:28: ( ASC | DESC )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==ASC||LA73_0==DESC) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:
                    {
                    _last = (CommonTree)input.LT(1);
                    set263=(CommonTree)input.LT(1);

                    if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                        input.consume();
                        if ( state.backtracking==0 ) {
                        set263_tree = (CommonTree)adaptor.dupNode(set263);


                        adaptor.addChild(root_0, set263_tree);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:436:1: order_clause : ^( ORDER rel order_by_clause ( func_clause )? ) ;
    public final AliasMasker.order_clause_return order_clause() throws RecognitionException {
        AliasMasker.order_clause_return retval = new AliasMasker.order_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER264=null;
        AliasMasker.rel_return rel265 =null;

        AliasMasker.order_by_clause_return order_by_clause266 =null;

        AliasMasker.func_clause_return func_clause267 =null;


        CommonTree ORDER264_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:437:5: ( ^( ORDER rel order_by_clause ( func_clause )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:437:7: ^( ORDER rel order_by_clause ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER264=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_order_clause2346); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER264_tree = (CommonTree)adaptor.dupNode(ORDER264);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER264_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_order_clause2348);
            rel265=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel265.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_order_clause2350);
            order_by_clause266=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause266.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:437:36: ( func_clause )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==FUNC||LA74_0==FUNC_REF) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:437:36: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_order_clause2352);
                    func_clause267=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause267.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:440:1: order_by_clause : ( STAR ( ASC | DESC )? | ( order_col )+ );
    public final AliasMasker.order_by_clause_return order_by_clause() throws RecognitionException {
        AliasMasker.order_by_clause_return retval = new AliasMasker.order_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR268=null;
        CommonTree set269=null;
        AliasMasker.order_col_return order_col270 =null;


        CommonTree STAR268_tree=null;
        CommonTree set269_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:441:5: ( STAR ( ASC | DESC )? | ( order_col )+ )
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==STAR) ) {
                alt77=1;
            }
            else if ( (LA77_0==CUBE||LA77_0==DOLLARVAR||LA77_0==GROUP||LA77_0==IDENTIFIER||LA77_0==COL_RANGE) ) {
                alt77=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;

            }
            switch (alt77) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:441:7: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR268=(CommonTree)match(input,STAR,FOLLOW_STAR_in_order_by_clause2368); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR268_tree = (CommonTree)adaptor.dupNode(STAR268);


                    adaptor.addChild(root_0, STAR268_tree);
                    }


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:441:12: ( ASC | DESC )?
                    int alt75=2;
                    int LA75_0 = input.LA(1);

                    if ( (LA75_0==ASC||LA75_0==DESC) ) {
                        alt75=1;
                    }
                    switch (alt75) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:
                            {
                            _last = (CommonTree)input.LT(1);
                            set269=(CommonTree)input.LT(1);

                            if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                                input.consume();
                                if ( state.backtracking==0 ) {
                                set269_tree = (CommonTree)adaptor.dupNode(set269);


                                adaptor.addChild(root_0, set269_tree);
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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:442:7: ( order_col )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:442:7: ( order_col )+
                    int cnt76=0;
                    loop76:
                    do {
                        int alt76=2;
                        int LA76_0 = input.LA(1);

                        if ( (LA76_0==CUBE||LA76_0==DOLLARVAR||LA76_0==GROUP||LA76_0==IDENTIFIER||LA76_0==COL_RANGE) ) {
                            alt76=1;
                        }


                        switch (alt76) {
                    	case 1 :
                    	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:442:7: order_col
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_order_col_in_order_by_clause2387);
                    	    order_col270=order_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, order_col270.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt76 >= 1 ) break loop76;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(76, input);
                                throw eee;
                        }
                        cnt76++;
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:445:1: order_col : ( col_range | col_ref ) ( ASC | DESC )? ;
    public final AliasMasker.order_col_return order_col() throws RecognitionException {
        AliasMasker.order_col_return retval = new AliasMasker.order_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set273=null;
        AliasMasker.col_range_return col_range271 =null;

        AliasMasker.col_ref_return col_ref272 =null;


        CommonTree set273_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:446:5: ( ( col_range | col_ref ) ( ASC | DESC )? )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:446:7: ( col_range | col_ref ) ( ASC | DESC )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:446:7: ( col_range | col_ref )
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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:446:8: col_range
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_order_col2402);
                    col_range271=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range271.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:446:20: col_ref
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_order_col2406);
                    col_ref272=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref272.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:446:29: ( ASC | DESC )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==ASC||LA79_0==DESC) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:
                    {
                    _last = (CommonTree)input.LT(1);
                    set273=(CommonTree)input.LT(1);

                    if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
                        input.consume();
                        if ( state.backtracking==0 ) {
                        set273_tree = (CommonTree)adaptor.dupNode(set273);


                        adaptor.addChild(root_0, set273_tree);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:449:1: distinct_clause : ^( DISTINCT rel ( partition_clause )? ) ;
    public final AliasMasker.distinct_clause_return distinct_clause() throws RecognitionException {
        AliasMasker.distinct_clause_return retval = new AliasMasker.distinct_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT274=null;
        AliasMasker.rel_return rel275 =null;

        AliasMasker.partition_clause_return partition_clause276 =null;


        CommonTree DISTINCT274_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:450:5: ( ^( DISTINCT rel ( partition_clause )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:450:7: ^( DISTINCT rel ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT274=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_distinct_clause2433); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT274_tree = (CommonTree)adaptor.dupNode(DISTINCT274);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT274_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_distinct_clause2435);
            rel275=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel275.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:450:23: ( partition_clause )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==PARTITION) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:450:23: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_distinct_clause2437);
                    partition_clause276=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause276.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:453:1: partition_clause : ^( PARTITION func_name ) ;
    public final AliasMasker.partition_clause_return partition_clause() throws RecognitionException {
        AliasMasker.partition_clause_return retval = new AliasMasker.partition_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARTITION277=null;
        AliasMasker.func_name_return func_name278 =null;


        CommonTree PARTITION277_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:454:5: ( ^( PARTITION func_name ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:454:7: ^( PARTITION func_name )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARTITION277=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_partition_clause2455); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARTITION277_tree = (CommonTree)adaptor.dupNode(PARTITION277);


            root_1 = (CommonTree)adaptor.becomeRoot(PARTITION277_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_func_name_in_partition_clause2457);
            func_name278=func_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, func_name278.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:457:1: cross_clause : ^( CROSS rel_list ( partition_clause )? ) ;
    public final AliasMasker.cross_clause_return cross_clause() throws RecognitionException {
        AliasMasker.cross_clause_return retval = new AliasMasker.cross_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS279=null;
        AliasMasker.rel_list_return rel_list280 =null;

        AliasMasker.partition_clause_return partition_clause281 =null;


        CommonTree CROSS279_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:458:5: ( ^( CROSS rel_list ( partition_clause )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:458:7: ^( CROSS rel_list ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS279=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_cross_clause2474); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS279_tree = (CommonTree)adaptor.dupNode(CROSS279);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS279_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_cross_clause2476);
            rel_list280=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list280.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:458:25: ( partition_clause )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==PARTITION) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:458:25: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_cross_clause2478);
                    partition_clause281=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause281.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:461:1: rel_list : ( rel )+ ;
    public final AliasMasker.rel_list_return rel_list() throws RecognitionException {
        AliasMasker.rel_list_return retval = new AliasMasker.rel_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.rel_return rel282 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:462:5: ( ( rel )+ )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:462:7: ( rel )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:462:7: ( rel )+
            int cnt82=0;
            loop82:
            do {
                int alt82=2;
                int LA82_0 = input.LA(1);

                if ( (LA82_0==ASSERT||LA82_0==COGROUP||(LA82_0 >= CROSS && LA82_0 <= CUBE)||LA82_0==DEFINE||LA82_0==DISTINCT||LA82_0==FILTER||LA82_0==FOREACH||LA82_0==GROUP||LA82_0==IDENTIFIER||LA82_0==JOIN||(LA82_0 >= LIMIT && LA82_0 <= LOAD)||LA82_0==MAPREDUCE||LA82_0==ORDER||LA82_0==RANK||LA82_0==SAMPLE||LA82_0==SPLIT||(LA82_0 >= STORE && LA82_0 <= STREAM)||LA82_0==UNION) ) {
                    alt82=1;
                }


                switch (alt82) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:462:7: rel
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_rel_in_rel_list2494);
            	    rel282=rel();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, rel282.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt82 >= 1 ) break loop82;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(82, input);
                        throw eee;
                }
                cnt82++;
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


    public static class join_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:465:1: join_clause : ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) ;
    public final AliasMasker.join_clause_return join_clause() throws RecognitionException {
        AliasMasker.join_clause_return retval = new AliasMasker.join_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN283=null;
        AliasMasker.join_sub_clause_return join_sub_clause284 =null;

        AliasMasker.join_type_return join_type285 =null;

        AliasMasker.partition_clause_return partition_clause286 =null;


        CommonTree JOIN283_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:466:5: ( ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:466:7: ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN283=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_join_clause2510); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN283_tree = (CommonTree)adaptor.dupNode(JOIN283);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN283_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_sub_clause_in_join_clause2512);
            join_sub_clause284=join_sub_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_sub_clause284.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:466:31: ( join_type )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==QUOTEDSTRING) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:466:31: join_type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_type_in_join_clause2514);
                    join_type285=join_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, join_type285.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:466:42: ( partition_clause )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==PARTITION) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:466:42: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_join_clause2517);
                    partition_clause286=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause286.getTree());


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
    // $ANTLR end "join_clause"


    public static class join_type_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_type"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:469:1: join_type : QUOTEDSTRING ;
    public final AliasMasker.join_type_return join_type() throws RecognitionException {
        AliasMasker.join_type_return retval = new AliasMasker.join_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING287=null;

        CommonTree QUOTEDSTRING287_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:469:11: ( QUOTEDSTRING )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:469:13: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING287=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_join_type2529); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING287_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING287);


            adaptor.addChild(root_0, QUOTEDSTRING287_tree);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:472:1: join_sub_clause : ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ );
    public final AliasMasker.join_sub_clause_return join_sub_clause() throws RecognitionException {
        AliasMasker.join_sub_clause_return retval = new AliasMasker.join_sub_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set289=null;
        CommonTree OUTER290=null;
        AliasMasker.join_item_return join_item288 =null;

        AliasMasker.join_item_return join_item291 =null;

        AliasMasker.join_item_return join_item292 =null;


        CommonTree set289_tree=null;
        CommonTree OUTER290_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:473:5: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==JOIN_ITEM) ) {
                int LA87_1 = input.LA(2);

                if ( (synpred160_AliasMasker()) ) {
                    alt87=1;
                }
                else if ( (true) ) {
                    alt87=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 87, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;

            }
            switch (alt87) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:473:7: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause2542);
                    join_item288=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item288.getTree());


                    _last = (CommonTree)input.LT(1);
                    set289=(CommonTree)input.LT(1);

                    if ( input.LA(1)==FULL||input.LA(1)==LEFT||input.LA(1)==RIGHT ) {
                        input.consume();
                        if ( state.backtracking==0 ) {
                        set289_tree = (CommonTree)adaptor.dupNode(set289);


                        adaptor.addChild(root_0, set289_tree);
                        }

                        state.errorRecovery=false;
                        state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:476:16: ( OUTER )?
                    int alt85=2;
                    int LA85_0 = input.LA(1);

                    if ( (LA85_0==OUTER) ) {
                        alt85=1;
                    }
                    switch (alt85) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:476:16: OUTER
                            {
                            _last = (CommonTree)input.LT(1);
                            OUTER290=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_join_sub_clause2597); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            OUTER290_tree = (CommonTree)adaptor.dupNode(OUTER290);


                            adaptor.addChild(root_0, OUTER290_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause2600);
                    join_item291=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item291.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:477:7: ( join_item )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:477:7: ( join_item )+
                    int cnt86=0;
                    loop86:
                    do {
                        int alt86=2;
                        int LA86_0 = input.LA(1);

                        if ( (LA86_0==JOIN_ITEM) ) {
                            alt86=1;
                        }


                        switch (alt86) {
                    	case 1 :
                    	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:477:7: join_item
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_join_item_in_join_sub_clause2608);
                    	    join_item292=join_item();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, join_item292.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt86 >= 1 ) break loop86;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(86, input);
                                throw eee;
                        }
                        cnt86++;
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:480:1: join_item : ^( JOIN_ITEM rel join_group_by_clause ) ;
    public final AliasMasker.join_item_return join_item() throws RecognitionException {
        AliasMasker.join_item_return retval = new AliasMasker.join_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN_ITEM293=null;
        AliasMasker.rel_return rel294 =null;

        AliasMasker.join_group_by_clause_return join_group_by_clause295 =null;


        CommonTree JOIN_ITEM293_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:481:2: ( ^( JOIN_ITEM rel join_group_by_clause ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:481:4: ^( JOIN_ITEM rel join_group_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN_ITEM293=(CommonTree)match(input,JOIN_ITEM,FOLLOW_JOIN_ITEM_in_join_item2621); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN_ITEM293_tree = (CommonTree)adaptor.dupNode(JOIN_ITEM293);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN_ITEM293_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_join_item2623);
            rel294=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel294.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_group_by_clause_in_join_item2625);
            join_group_by_clause295=join_group_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_group_by_clause295.getTree());


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
    // $ANTLR end "join_item"


    public static class join_group_by_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_group_by_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:484:1: join_group_by_clause : ^( BY ( join_group_by_expr )+ ) ;
    public final AliasMasker.join_group_by_clause_return join_group_by_clause() throws RecognitionException {
        AliasMasker.join_group_by_clause_return retval = new AliasMasker.join_group_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY296=null;
        AliasMasker.join_group_by_expr_return join_group_by_expr297 =null;


        CommonTree BY296_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:485:5: ( ^( BY ( join_group_by_expr )+ ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:485:7: ^( BY ( join_group_by_expr )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY296=(CommonTree)match(input,BY,FOLLOW_BY_in_join_group_by_clause2642); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY296_tree = (CommonTree)adaptor.dupNode(BY296);


            root_1 = (CommonTree)adaptor.becomeRoot(BY296_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:485:13: ( join_group_by_expr )+
            int cnt88=0;
            loop88:
            do {
                int alt88=2;
                int LA88_0 = input.LA(1);

                if ( (LA88_0==BIGDECIMALNUMBER||LA88_0==BIGINTEGERNUMBER||LA88_0==CUBE||LA88_0==DIV||LA88_0==DOLLARVAR||LA88_0==DOUBLENUMBER||LA88_0==FALSE||LA88_0==FLOATNUMBER||LA88_0==GROUP||LA88_0==IDENTIFIER||LA88_0==INTEGER||LA88_0==LONGINTEGER||LA88_0==MINUS||LA88_0==NULL||LA88_0==PERCENT||LA88_0==PLUS||LA88_0==QUOTEDSTRING||LA88_0==STAR||LA88_0==TRUE||(LA88_0 >= BAG_VAL && LA88_0 <= BIN_EXPR)||(LA88_0 >= CASE_COND && LA88_0 <= CASE_EXPR)||(LA88_0 >= CAST_EXPR && LA88_0 <= EXPR_IN_PAREN)||LA88_0==FUNC_EVAL||(LA88_0 >= MAP_VAL && LA88_0 <= NEG)||LA88_0==TUPLE_VAL) ) {
                    alt88=1;
                }


                switch (alt88) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:485:13: join_group_by_expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_join_group_by_expr_in_join_group_by_clause2644);
            	    join_group_by_expr297=join_group_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, join_group_by_expr297.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:488:1: join_group_by_expr : ( col_range | expr | STAR );
    public final AliasMasker.join_group_by_expr_return join_group_by_expr() throws RecognitionException {
        AliasMasker.join_group_by_expr_return retval = new AliasMasker.join_group_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR300=null;
        AliasMasker.col_range_return col_range298 =null;

        AliasMasker.expr_return expr299 =null;


        CommonTree STAR300_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:489:5: ( col_range | expr | STAR )
            int alt89=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt89=1;
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
            case MAP_VAL:
            case NEG:
            case TUPLE_VAL:
                {
                alt89=2;
                }
                break;
            case STAR:
                {
                int LA89_3 = input.LA(2);

                if ( (LA89_3==DOWN) ) {
                    alt89=2;
                }
                else if ( (LA89_3==EOF||LA89_3==UP||LA89_3==BIGDECIMALNUMBER||LA89_3==BIGINTEGERNUMBER||LA89_3==CUBE||LA89_3==DIV||LA89_3==DOLLARVAR||LA89_3==DOUBLENUMBER||LA89_3==FALSE||LA89_3==FLOATNUMBER||LA89_3==GROUP||LA89_3==IDENTIFIER||LA89_3==INTEGER||LA89_3==LONGINTEGER||LA89_3==MINUS||LA89_3==NULL||LA89_3==PERCENT||LA89_3==PLUS||LA89_3==QUOTEDSTRING||LA89_3==STAR||LA89_3==TRUE||(LA89_3 >= BAG_VAL && LA89_3 <= BIN_EXPR)||(LA89_3 >= CASE_COND && LA89_3 <= CASE_EXPR)||(LA89_3 >= CAST_EXPR && LA89_3 <= EXPR_IN_PAREN)||LA89_3==FUNC_EVAL||(LA89_3 >= MAP_VAL && LA89_3 <= NEG)||LA89_3==TUPLE_VAL) ) {
                    alt89=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 89, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;

            }

            switch (alt89) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:489:7: col_range
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_join_group_by_expr2660);
                    col_range298=col_range();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range298.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:489:19: expr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_join_group_by_expr2664);
                    expr299=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr299.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:489:26: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR300=(CommonTree)match(input,STAR,FOLLOW_STAR_in_join_group_by_expr2668); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR300_tree = (CommonTree)adaptor.dupNode(STAR300);


                    adaptor.addChild(root_0, STAR300_tree);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:492:1: union_clause : ^( UNION ( ONSCHEMA )? rel_list ) ;
    public final AliasMasker.union_clause_return union_clause() throws RecognitionException {
        AliasMasker.union_clause_return retval = new AliasMasker.union_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree UNION301=null;
        CommonTree ONSCHEMA302=null;
        AliasMasker.rel_list_return rel_list303 =null;


        CommonTree UNION301_tree=null;
        CommonTree ONSCHEMA302_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:493:5: ( ^( UNION ( ONSCHEMA )? rel_list ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:493:7: ^( UNION ( ONSCHEMA )? rel_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            UNION301=(CommonTree)match(input,UNION,FOLLOW_UNION_in_union_clause2683); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            UNION301_tree = (CommonTree)adaptor.dupNode(UNION301);


            root_1 = (CommonTree)adaptor.becomeRoot(UNION301_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:493:16: ( ONSCHEMA )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==ONSCHEMA) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:493:16: ONSCHEMA
                    {
                    _last = (CommonTree)input.LT(1);
                    ONSCHEMA302=(CommonTree)match(input,ONSCHEMA,FOLLOW_ONSCHEMA_in_union_clause2685); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ONSCHEMA302_tree = (CommonTree)adaptor.dupNode(ONSCHEMA302);


                    adaptor.addChild(root_1, ONSCHEMA302_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_union_clause2688);
            rel_list303=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list303.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:496:1: foreach_clause : ^( FOREACH rel foreach_plan ) ;
    public final AliasMasker.foreach_clause_return foreach_clause() throws RecognitionException {
        AliasMasker.foreach_clause_return retval = new AliasMasker.foreach_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH304=null;
        AliasMasker.rel_return rel305 =null;

        AliasMasker.foreach_plan_return foreach_plan306 =null;


        CommonTree FOREACH304_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:497:5: ( ^( FOREACH rel foreach_plan ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:497:7: ^( FOREACH rel foreach_plan )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH304=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_foreach_clause2705); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH304_tree = (CommonTree)adaptor.dupNode(FOREACH304);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH304_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_foreach_clause2707);
            rel305=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel305.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_foreach_plan_in_foreach_clause2709);
            foreach_plan306=foreach_plan();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, foreach_plan306.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:500:1: foreach_plan : ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) );
    public final AliasMasker.foreach_plan_return foreach_plan() throws RecognitionException {
        AliasMasker.foreach_plan_return retval = new AliasMasker.foreach_plan_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH_PLAN_SIMPLE307=null;
        CommonTree FOREACH_PLAN_COMPLEX309=null;
        AliasMasker.generate_clause_return generate_clause308 =null;

        AliasMasker.nested_blk_return nested_blk310 =null;


        CommonTree FOREACH_PLAN_SIMPLE307_tree=null;
        CommonTree FOREACH_PLAN_COMPLEX309_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:501:5: ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) )
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==FOREACH_PLAN_SIMPLE) ) {
                alt91=1;
            }
            else if ( (LA91_0==FOREACH_PLAN_COMPLEX) ) {
                alt91=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;

            }
            switch (alt91) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:501:7: ^( FOREACH_PLAN_SIMPLE generate_clause )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_SIMPLE307=(CommonTree)match(input,FOREACH_PLAN_SIMPLE,FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan2726); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_SIMPLE307_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_SIMPLE307);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_SIMPLE307_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_generate_clause_in_foreach_plan2728);
                    generate_clause308=generate_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, generate_clause308.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:502:7: ^( FOREACH_PLAN_COMPLEX nested_blk )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_COMPLEX309=(CommonTree)match(input,FOREACH_PLAN_COMPLEX,FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan2740); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_COMPLEX309_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_COMPLEX309);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_COMPLEX309_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_blk_in_foreach_plan2742);
                    nested_blk310=nested_blk();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_blk310.getTree());


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


    public static class nested_blk_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_blk"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:505:1: nested_blk : ( nested_command )* generate_clause ;
    public final AliasMasker.nested_blk_return nested_blk() throws RecognitionException {
        AliasMasker.nested_blk_return retval = new AliasMasker.nested_blk_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.nested_command_return nested_command311 =null;

        AliasMasker.generate_clause_return generate_clause312 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:506:5: ( ( nested_command )* generate_clause )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:506:7: ( nested_command )* generate_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:506:7: ( nested_command )*
            loop92:
            do {
                int alt92=2;
                int LA92_0 = input.LA(1);

                if ( ((LA92_0 >= NESTED_CMD && LA92_0 <= NESTED_CMD_ASSI)) ) {
                    alt92=1;
                }


                switch (alt92) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:506:7: nested_command
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_command_in_nested_blk2757);
            	    nested_command311=nested_command();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_command311.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop92;
                }
            } while (true);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_blk2760);
            generate_clause312=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, generate_clause312.getTree());


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
    // $ANTLR end "nested_blk"


    public static class generate_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "generate_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:509:1: generate_clause : ^( GENERATE ( flatten_generated_item )+ ) ;
    public final AliasMasker.generate_clause_return generate_clause() throws RecognitionException {
        AliasMasker.generate_clause_return retval = new AliasMasker.generate_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GENERATE313=null;
        AliasMasker.flatten_generated_item_return flatten_generated_item314 =null;


        CommonTree GENERATE313_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:510:5: ( ^( GENERATE ( flatten_generated_item )+ ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:510:7: ^( GENERATE ( flatten_generated_item )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            GENERATE313=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_generate_clause2775); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            GENERATE313_tree = (CommonTree)adaptor.dupNode(GENERATE313);


            root_1 = (CommonTree)adaptor.becomeRoot(GENERATE313_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:510:19: ( flatten_generated_item )+
            int cnt93=0;
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( (LA93_0==BIGDECIMALNUMBER||LA93_0==BIGINTEGERNUMBER||LA93_0==CUBE||LA93_0==DIV||LA93_0==DOLLARVAR||LA93_0==DOUBLENUMBER||LA93_0==FALSE||LA93_0==FLATTEN||LA93_0==FLOATNUMBER||LA93_0==GROUP||LA93_0==IDENTIFIER||LA93_0==INTEGER||LA93_0==LONGINTEGER||LA93_0==MINUS||LA93_0==NULL||LA93_0==PERCENT||LA93_0==PLUS||LA93_0==QUOTEDSTRING||LA93_0==STAR||LA93_0==TRUE||(LA93_0 >= BAG_VAL && LA93_0 <= BIN_EXPR)||(LA93_0 >= CASE_COND && LA93_0 <= CASE_EXPR)||(LA93_0 >= CAST_EXPR && LA93_0 <= EXPR_IN_PAREN)||LA93_0==FUNC_EVAL||(LA93_0 >= MAP_VAL && LA93_0 <= NEG)||LA93_0==TUPLE_VAL) ) {
                    alt93=1;
                }


                switch (alt93) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:510:19: flatten_generated_item
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_flatten_generated_item_in_generate_clause2777);
            	    flatten_generated_item314=flatten_generated_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, flatten_generated_item314.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt93 >= 1 ) break loop93;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(93, input);
                        throw eee;
                }
                cnt93++;
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:513:1: nested_command : ( ^( NESTED_CMD IDENTIFIER nested_op ) | ^( NESTED_CMD_ASSI IDENTIFIER expr ) );
    public final AliasMasker.nested_command_return nested_command() throws RecognitionException {
        AliasMasker.nested_command_return retval = new AliasMasker.nested_command_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_CMD315=null;
        CommonTree IDENTIFIER316=null;
        CommonTree NESTED_CMD_ASSI318=null;
        CommonTree IDENTIFIER319=null;
        AliasMasker.nested_op_return nested_op317 =null;

        AliasMasker.expr_return expr320 =null;


        CommonTree NESTED_CMD315_tree=null;
        CommonTree IDENTIFIER316_tree=null;
        CommonTree NESTED_CMD_ASSI318_tree=null;
        CommonTree IDENTIFIER319_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:514:5: ( ^( NESTED_CMD IDENTIFIER nested_op ) | ^( NESTED_CMD_ASSI IDENTIFIER expr ) )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==NESTED_CMD) ) {
                alt94=1;
            }
            else if ( (LA94_0==NESTED_CMD_ASSI) ) {
                alt94=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;

            }
            switch (alt94) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:514:7: ^( NESTED_CMD IDENTIFIER nested_op )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD315=(CommonTree)match(input,NESTED_CMD,FOLLOW_NESTED_CMD_in_nested_command2795); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD315_tree = (CommonTree)adaptor.dupNode(NESTED_CMD315);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD315_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER316=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command2797); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER316_tree = (CommonTree)adaptor.dupNode(IDENTIFIER316);


                    adaptor.addChild(root_1, IDENTIFIER316_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_op_in_nested_command2799);
                    nested_op317=nested_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_op317.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:515:7: ^( NESTED_CMD_ASSI IDENTIFIER expr )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD_ASSI318=(CommonTree)match(input,NESTED_CMD_ASSI,FOLLOW_NESTED_CMD_ASSI_in_nested_command2811); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD_ASSI318_tree = (CommonTree)adaptor.dupNode(NESTED_CMD_ASSI318);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD_ASSI318_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER319=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command2813); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER319_tree = (CommonTree)adaptor.dupNode(IDENTIFIER319);


                    adaptor.addChild(root_1, IDENTIFIER319_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_command2815);
                    expr320=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr320.getTree());


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
    // $ANTLR end "nested_command"


    public static class nested_op_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:518:1: nested_op : ( nested_proj | nested_filter | nested_sort | nested_distinct | nested_limit | nested_cross | nested_foreach );
    public final AliasMasker.nested_op_return nested_op() throws RecognitionException {
        AliasMasker.nested_op_return retval = new AliasMasker.nested_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.nested_proj_return nested_proj321 =null;

        AliasMasker.nested_filter_return nested_filter322 =null;

        AliasMasker.nested_sort_return nested_sort323 =null;

        AliasMasker.nested_distinct_return nested_distinct324 =null;

        AliasMasker.nested_limit_return nested_limit325 =null;

        AliasMasker.nested_cross_return nested_cross326 =null;

        AliasMasker.nested_foreach_return nested_foreach327 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:518:11: ( nested_proj | nested_filter | nested_sort | nested_distinct | nested_limit | nested_cross | nested_foreach )
            int alt95=7;
            switch ( input.LA(1) ) {
            case NESTED_PROJ:
                {
                alt95=1;
                }
                break;
            case FILTER:
                {
                alt95=2;
                }
                break;
            case ORDER:
                {
                alt95=3;
                }
                break;
            case DISTINCT:
                {
                alt95=4;
                }
                break;
            case LIMIT:
                {
                alt95=5;
                }
                break;
            case CROSS:
                {
                alt95=6;
                }
                break;
            case FOREACH:
                {
                alt95=7;
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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:518:13: nested_proj
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op2826);
                    nested_proj321=nested_proj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj321.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:519:13: nested_filter
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_filter_in_nested_op2840);
                    nested_filter322=nested_filter();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_filter322.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:520:13: nested_sort
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_sort_in_nested_op2854);
                    nested_sort323=nested_sort();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_sort323.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:521:13: nested_distinct
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_distinct_in_nested_op2868);
                    nested_distinct324=nested_distinct();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_distinct324.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:522:13: nested_limit
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_limit_in_nested_op2882);
                    nested_limit325=nested_limit();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_limit325.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:523:13: nested_cross
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_cross_in_nested_op2896);
                    nested_cross326=nested_cross();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_cross326.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:524:13: nested_foreach
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_foreach_in_nested_op2910);
                    nested_foreach327=nested_foreach();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_foreach327.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:527:1: nested_proj : ^( NESTED_PROJ col_ref ( col_ref )+ ) ;
    public final AliasMasker.nested_proj_return nested_proj() throws RecognitionException {
        AliasMasker.nested_proj_return retval = new AliasMasker.nested_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_PROJ328=null;
        AliasMasker.col_ref_return col_ref329 =null;

        AliasMasker.col_ref_return col_ref330 =null;


        CommonTree NESTED_PROJ328_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:528:5: ( ^( NESTED_PROJ col_ref ( col_ref )+ ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:528:7: ^( NESTED_PROJ col_ref ( col_ref )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            NESTED_PROJ328=(CommonTree)match(input,NESTED_PROJ,FOLLOW_NESTED_PROJ_in_nested_proj2925); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NESTED_PROJ328_tree = (CommonTree)adaptor.dupNode(NESTED_PROJ328);


            root_1 = (CommonTree)adaptor.becomeRoot(NESTED_PROJ328_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_col_ref_in_nested_proj2927);
            col_ref329=col_ref();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, col_ref329.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:528:30: ( col_ref )+
            int cnt96=0;
            loop96:
            do {
                int alt96=2;
                int LA96_0 = input.LA(1);

                if ( (LA96_0==CUBE||LA96_0==DOLLARVAR||LA96_0==GROUP||LA96_0==IDENTIFIER) ) {
                    alt96=1;
                }


                switch (alt96) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:528:30: col_ref
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_ref_in_nested_proj2929);
            	    col_ref330=col_ref();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_ref330.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt96 >= 1 ) break loop96;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(96, input);
                        throw eee;
                }
                cnt96++;
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:531:1: nested_filter : ^( FILTER nested_op_input cond ) ;
    public final AliasMasker.nested_filter_return nested_filter() throws RecognitionException {
        AliasMasker.nested_filter_return retval = new AliasMasker.nested_filter_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER331=null;
        AliasMasker.nested_op_input_return nested_op_input332 =null;

        AliasMasker.cond_return cond333 =null;


        CommonTree FILTER331_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:532:5: ( ^( FILTER nested_op_input cond ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:532:7: ^( FILTER nested_op_input cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER331=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_nested_filter2947); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER331_tree = (CommonTree)adaptor.dupNode(FILTER331);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER331_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_filter2949);
            nested_op_input332=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input332.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_nested_filter2951);
            cond333=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond333.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:535:1: nested_sort : ^( ORDER nested_op_input order_by_clause ( func_clause )? ) ;
    public final AliasMasker.nested_sort_return nested_sort() throws RecognitionException {
        AliasMasker.nested_sort_return retval = new AliasMasker.nested_sort_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER334=null;
        AliasMasker.nested_op_input_return nested_op_input335 =null;

        AliasMasker.order_by_clause_return order_by_clause336 =null;

        AliasMasker.func_clause_return func_clause337 =null;


        CommonTree ORDER334_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:536:5: ( ^( ORDER nested_op_input order_by_clause ( func_clause )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:536:7: ^( ORDER nested_op_input order_by_clause ( func_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER334=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_nested_sort2968); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER334_tree = (CommonTree)adaptor.dupNode(ORDER334);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER334_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_sort2970);
            nested_op_input335=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input335.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_nested_sort2972);
            order_by_clause336=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause336.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:536:48: ( func_clause )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==FUNC||LA97_0==FUNC_REF) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:536:48: func_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_nested_sort2974);
                    func_clause337=func_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause337.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:539:1: nested_distinct : ^( DISTINCT nested_op_input ) ;
    public final AliasMasker.nested_distinct_return nested_distinct() throws RecognitionException {
        AliasMasker.nested_distinct_return retval = new AliasMasker.nested_distinct_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT338=null;
        AliasMasker.nested_op_input_return nested_op_input339 =null;


        CommonTree DISTINCT338_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:540:5: ( ^( DISTINCT nested_op_input ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:540:7: ^( DISTINCT nested_op_input )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT338=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_nested_distinct2992); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT338_tree = (CommonTree)adaptor.dupNode(DISTINCT338);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT338_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_distinct2994);
            nested_op_input339=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input339.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:543:1: nested_limit : ^( LIMIT nested_op_input ( INTEGER | expr ) ) ;
    public final AliasMasker.nested_limit_return nested_limit() throws RecognitionException {
        AliasMasker.nested_limit_return retval = new AliasMasker.nested_limit_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT340=null;
        CommonTree INTEGER342=null;
        AliasMasker.nested_op_input_return nested_op_input341 =null;

        AliasMasker.expr_return expr343 =null;


        CommonTree LIMIT340_tree=null;
        CommonTree INTEGER342_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:544:5: ( ^( LIMIT nested_op_input ( INTEGER | expr ) ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:544:7: ^( LIMIT nested_op_input ( INTEGER | expr ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT340=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_nested_limit3011); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT340_tree = (CommonTree)adaptor.dupNode(LIMIT340);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT340_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_limit3013);
            nested_op_input341=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input341.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:544:32: ( INTEGER | expr )
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==INTEGER) ) {
                int LA98_1 = input.LA(2);

                if ( (synpred178_AliasMasker()) ) {
                    alt98=1;
                }
                else if ( (true) ) {
                    alt98=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 98, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA98_0==BIGDECIMALNUMBER||LA98_0==BIGINTEGERNUMBER||LA98_0==CUBE||LA98_0==DIV||LA98_0==DOLLARVAR||LA98_0==DOUBLENUMBER||LA98_0==FALSE||LA98_0==FLOATNUMBER||LA98_0==GROUP||LA98_0==IDENTIFIER||LA98_0==LONGINTEGER||LA98_0==MINUS||LA98_0==NULL||LA98_0==PERCENT||LA98_0==PLUS||LA98_0==QUOTEDSTRING||LA98_0==STAR||LA98_0==TRUE||(LA98_0 >= BAG_VAL && LA98_0 <= BIN_EXPR)||(LA98_0 >= CASE_COND && LA98_0 <= CASE_EXPR)||LA98_0==CAST_EXPR||LA98_0==EXPR_IN_PAREN||LA98_0==FUNC_EVAL||(LA98_0 >= MAP_VAL && LA98_0 <= NEG)||LA98_0==TUPLE_VAL) ) {
                alt98=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 98, 0, input);

                throw nvae;

            }
            switch (alt98) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:544:34: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER342=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_nested_limit3017); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER342_tree = (CommonTree)adaptor.dupNode(INTEGER342);


                    adaptor.addChild(root_1, INTEGER342_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:544:44: expr
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_limit3021);
                    expr343=expr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr343.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:547:1: nested_cross : ^( CROSS nested_op_input_list ) ;
    public final AliasMasker.nested_cross_return nested_cross() throws RecognitionException {
        AliasMasker.nested_cross_return retval = new AliasMasker.nested_cross_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS344=null;
        AliasMasker.nested_op_input_list_return nested_op_input_list345 =null;


        CommonTree CROSS344_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:547:14: ( ^( CROSS nested_op_input_list ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:547:16: ^( CROSS nested_op_input_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS344=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_nested_cross3036); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS344_tree = (CommonTree)adaptor.dupNode(CROSS344);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS344_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_list_in_nested_cross3038);
            nested_op_input_list345=nested_op_input_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input_list345.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:550:1: nested_foreach : ^( FOREACH nested_op_input generate_clause ) ;
    public final AliasMasker.nested_foreach_return nested_foreach() throws RecognitionException {
        AliasMasker.nested_foreach_return retval = new AliasMasker.nested_foreach_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH346=null;
        AliasMasker.nested_op_input_return nested_op_input347 =null;

        AliasMasker.generate_clause_return generate_clause348 =null;


        CommonTree FOREACH346_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:550:16: ( ^( FOREACH nested_op_input generate_clause ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:550:18: ^( FOREACH nested_op_input generate_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH346=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_nested_foreach3051); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH346_tree = (CommonTree)adaptor.dupNode(FOREACH346);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH346_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_foreach3053);
            nested_op_input347=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input347.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_foreach3055);
            generate_clause348=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, generate_clause348.getTree());


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


    public static class nested_op_input_list_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input_list"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:553:1: nested_op_input_list : ( nested_op_input )+ ;
    public final AliasMasker.nested_op_input_list_return nested_op_input_list() throws RecognitionException {
        AliasMasker.nested_op_input_list_return retval = new AliasMasker.nested_op_input_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.nested_op_input_return nested_op_input349 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:553:22: ( ( nested_op_input )+ )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:553:24: ( nested_op_input )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:553:24: ( nested_op_input )+
            int cnt99=0;
            loop99:
            do {
                int alt99=2;
                int LA99_0 = input.LA(1);

                if ( (LA99_0==CUBE||LA99_0==DOLLARVAR||LA99_0==GROUP||LA99_0==IDENTIFIER||LA99_0==NESTED_PROJ) ) {
                    alt99=1;
                }


                switch (alt99) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:553:24: nested_op_input
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_op_input_in_nested_op_input_list3066);
            	    nested_op_input349=nested_op_input();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_op_input349.getTree());


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


    public static class nested_op_input_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:556:1: nested_op_input : ( col_ref | nested_proj );
    public final AliasMasker.nested_op_input_return nested_op_input() throws RecognitionException {
        AliasMasker.nested_op_input_return retval = new AliasMasker.nested_op_input_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.col_ref_return col_ref350 =null;

        AliasMasker.nested_proj_return nested_proj351 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:556:17: ( col_ref | nested_proj )
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==CUBE||LA100_0==DOLLARVAR||LA100_0==GROUP||LA100_0==IDENTIFIER) ) {
                alt100=1;
            }
            else if ( (LA100_0==NESTED_PROJ) ) {
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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:556:19: col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_nested_op_input3076);
                    col_ref350=col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref350.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:556:29: nested_proj
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op_input3080);
                    nested_proj351=nested_proj();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj351.getTree());


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


    public static class stream_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stream_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:559:1: stream_clause : ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) ;
    public final AliasMasker.stream_clause_return stream_clause() throws RecognitionException {
        AliasMasker.stream_clause_return retval = new AliasMasker.stream_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STREAM352=null;
        CommonTree set354=null;
        AliasMasker.rel_return rel353 =null;

        AliasMasker.as_clause_return as_clause355 =null;


        CommonTree STREAM352_tree=null;
        CommonTree set354_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:560:5: ( ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:560:7: ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STREAM352=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_stream_clause3095); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM352_tree = (CommonTree)adaptor.dupNode(STREAM352);


            root_1 = (CommonTree)adaptor.becomeRoot(STREAM352_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_stream_clause3097);
            rel353=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel353.getTree());


            _last = (CommonTree)input.LT(1);
            set354=(CommonTree)input.LT(1);

            if ( input.LA(1)==EXECCOMMAND||input.LA(1)==IDENTIFIER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set354_tree = (CommonTree)adaptor.dupNode(set354);


                adaptor.addChild(root_1, set354_tree);
                }

                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:560:50: ( as_clause )?
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==AS) ) {
                alt101=1;
            }
            switch (alt101) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:560:50: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_stream_clause3109);
                    as_clause355=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause355.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:563:1: mr_clause : ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? ) ;
    public final AliasMasker.mr_clause_return mr_clause() throws RecognitionException {
        AliasMasker.mr_clause_return retval = new AliasMasker.mr_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAPREDUCE356=null;
        CommonTree QUOTEDSTRING357=null;
        CommonTree EXECCOMMAND361=null;
        AliasMasker.path_list_return path_list358 =null;

        AliasMasker.store_clause_return store_clause359 =null;

        AliasMasker.load_clause_return load_clause360 =null;


        CommonTree MAPREDUCE356_tree=null;
        CommonTree QUOTEDSTRING357_tree=null;
        CommonTree EXECCOMMAND361_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:564:5: ( ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:564:7: ^( MAPREDUCE QUOTEDSTRING ( path_list )? store_clause load_clause ( EXECCOMMAND )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAPREDUCE356=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_mr_clause3127); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAPREDUCE356_tree = (CommonTree)adaptor.dupNode(MAPREDUCE356);


            root_1 = (CommonTree)adaptor.becomeRoot(MAPREDUCE356_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING357=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_mr_clause3129); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING357_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING357);


            adaptor.addChild(root_1, QUOTEDSTRING357_tree);
            }


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:564:33: ( path_list )?
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==QUOTEDSTRING) ) {
                alt102=1;
            }
            switch (alt102) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:564:33: path_list
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_path_list_in_mr_clause3131);
                    path_list358=path_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, path_list358.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_store_clause_in_mr_clause3134);
            store_clause359=store_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, store_clause359.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_load_clause_in_mr_clause3136);
            load_clause360=load_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, load_clause360.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:564:69: ( EXECCOMMAND )?
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==EXECCOMMAND) ) {
                alt103=1;
            }
            switch (alt103) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:564:69: EXECCOMMAND
                    {
                    _last = (CommonTree)input.LT(1);
                    EXECCOMMAND361=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_mr_clause3138); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXECCOMMAND361_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND361);


                    adaptor.addChild(root_1, EXECCOMMAND361_tree);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:567:1: split_clause : ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) ;
    public final AliasMasker.split_clause_return split_clause() throws RecognitionException {
        AliasMasker.split_clause_return retval = new AliasMasker.split_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT362=null;
        AliasMasker.rel_return rel363 =null;

        AliasMasker.split_branch_return split_branch364 =null;

        AliasMasker.split_otherwise_return split_otherwise365 =null;


        CommonTree SPLIT362_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:568:5: ( ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:568:7: ^( SPLIT rel ( split_branch )+ ( split_otherwise )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT362=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_split_clause3156); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT362_tree = (CommonTree)adaptor.dupNode(SPLIT362);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT362_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_split_clause3158);
            rel363=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel363.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:568:20: ( split_branch )+
            int cnt104=0;
            loop104:
            do {
                int alt104=2;
                int LA104_0 = input.LA(1);

                if ( (LA104_0==SPLIT_BRANCH) ) {
                    alt104=1;
                }


                switch (alt104) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:568:20: split_branch
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_split_branch_in_split_clause3160);
            	    split_branch364=split_branch();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, split_branch364.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt104 >= 1 ) break loop104;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(104, input);
                        throw eee;
                }
                cnt104++;
            } while (true);


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:568:34: ( split_otherwise )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==OTHERWISE) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:568:34: split_otherwise
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_otherwise_in_split_clause3163);
                    split_otherwise365=split_otherwise();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, split_otherwise365.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:571:1: split_branch : ^( SPLIT_BRANCH alias cond ) ;
    public final AliasMasker.split_branch_return split_branch() throws RecognitionException {
        AliasMasker.split_branch_return retval = new AliasMasker.split_branch_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT_BRANCH366=null;
        AliasMasker.alias_return alias367 =null;

        AliasMasker.cond_return cond368 =null;


        CommonTree SPLIT_BRANCH366_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:572:5: ( ^( SPLIT_BRANCH alias cond ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:572:7: ^( SPLIT_BRANCH alias cond )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT_BRANCH366=(CommonTree)match(input,SPLIT_BRANCH,FOLLOW_SPLIT_BRANCH_in_split_branch3181); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT_BRANCH366_tree = (CommonTree)adaptor.dupNode(SPLIT_BRANCH366);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT_BRANCH366_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_branch3183);
            alias367=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias367.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_split_branch3185);
            cond368=cond();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond368.getTree());


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
    // $ANTLR end "split_branch"


    public static class split_otherwise_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_otherwise"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:575:1: split_otherwise : ^( OTHERWISE alias ) ;
    public final AliasMasker.split_otherwise_return split_otherwise() throws RecognitionException {
        AliasMasker.split_otherwise_return retval = new AliasMasker.split_otherwise_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OTHERWISE369=null;
        AliasMasker.alias_return alias370 =null;


        CommonTree OTHERWISE369_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:576:5: ( ^( OTHERWISE alias ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:576:7: ^( OTHERWISE alias )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OTHERWISE369=(CommonTree)match(input,OTHERWISE,FOLLOW_OTHERWISE_in_split_otherwise3202); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OTHERWISE369_tree = (CommonTree)adaptor.dupNode(OTHERWISE369);


            root_1 = (CommonTree)adaptor.becomeRoot(OTHERWISE369_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_otherwise3204);
            alias370=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias370.getTree());


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
    // $ANTLR end "split_otherwise"


    public static class col_ref_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_ref"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:579:1: col_ref : ( alias_col_ref | dollar_col_ref );
    public final AliasMasker.col_ref_return col_ref() throws RecognitionException {
        AliasMasker.col_ref_return retval = new AliasMasker.col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.alias_col_ref_return alias_col_ref371 =null;

        AliasMasker.dollar_col_ref_return dollar_col_ref372 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:579:9: ( alias_col_ref | dollar_col_ref )
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==CUBE||LA106_0==GROUP||LA106_0==IDENTIFIER) ) {
                alt106=1;
            }
            else if ( (LA106_0==DOLLARVAR) ) {
                alt106=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 106, 0, input);

                throw nvae;

            }
            switch (alt106) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:579:11: alias_col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_col_ref_in_col_ref3215);
                    alias_col_ref371=alias_col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias_col_ref371.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:579:27: dollar_col_ref
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_dollar_col_ref_in_col_ref3219);
                    dollar_col_ref372=dollar_col_ref();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, dollar_col_ref372.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:582:1: alias_col_ref : ( GROUP | CUBE | IDENTIFIER );
    public final AliasMasker.alias_col_ref_return alias_col_ref() throws RecognitionException {
        AliasMasker.alias_col_ref_return retval = new AliasMasker.alias_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP373=null;
        CommonTree CUBE374=null;
        CommonTree IDENTIFIER375=null;

        CommonTree GROUP373_tree=null;
        CommonTree CUBE374_tree=null;
        CommonTree IDENTIFIER375_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:583:5: ( GROUP | CUBE | IDENTIFIER )
            int alt107=3;
            switch ( input.LA(1) ) {
            case GROUP:
                {
                alt107=1;
                }
                break;
            case CUBE:
                {
                alt107=2;
                }
                break;
            case IDENTIFIER:
                {
                alt107=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 107, 0, input);

                throw nvae;

            }

            switch (alt107) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:583:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP373=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_alias_col_ref3232); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP373_tree = (CommonTree)adaptor.dupNode(GROUP373);


                    adaptor.addChild(root_0, GROUP373_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:584:7: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE374=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_alias_col_ref3240); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE374_tree = (CommonTree)adaptor.dupNode(CUBE374);


                    adaptor.addChild(root_0, CUBE374_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:585:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER375=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias_col_ref3248); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER375_tree = (CommonTree)adaptor.dupNode(IDENTIFIER375);


                    adaptor.addChild(root_0, IDENTIFIER375_tree);
                    }


                    if ( state.backtracking==0 ) {
                              String alias = (IDENTIFIER375!=null?IDENTIFIER375.getText():null);
                              String[] names = alias.split( "::" );
                              StringBuilder sb = new StringBuilder();
                              for( int i = 0; i < names.length; i++ ) {
                                  String name = names[i];
                                  sb.append( aliasSeen.contains( name ) ? getMask( name ) : name );
                                  if( i < names.length - 1 )
                                      sb.append( "::" );
                              }
                              IDENTIFIER375.token.setText( sb.toString() );
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
    // $ANTLR end "alias_col_ref"


    public static class dollar_col_ref_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dollar_col_ref"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:600:1: dollar_col_ref : DOLLARVAR ;
    public final AliasMasker.dollar_col_ref_return dollar_col_ref() throws RecognitionException {
        AliasMasker.dollar_col_ref_return retval = new AliasMasker.dollar_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR376=null;

        CommonTree DOLLARVAR376_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:601:5: ( DOLLARVAR )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:601:7: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR376=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_dollar_col_ref3269); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR376_tree = (CommonTree)adaptor.dupNode(DOLLARVAR376);


            adaptor.addChild(root_0, DOLLARVAR376_tree);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:604:1: const_expr : literal ;
    public final AliasMasker.const_expr_return const_expr() throws RecognitionException {
        AliasMasker.const_expr_return retval = new AliasMasker.const_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.literal_return literal377 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:604:12: ( literal )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:604:14: literal
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_literal_in_const_expr3278);
            literal377=literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, literal377.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:607:1: literal : ( scalar | map | bag | tuple );
    public final AliasMasker.literal_return literal() throws RecognitionException {
        AliasMasker.literal_return retval = new AliasMasker.literal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        AliasMasker.scalar_return scalar378 =null;

        AliasMasker.map_return map379 =null;

        AliasMasker.bag_return bag380 =null;

        AliasMasker.tuple_return tuple381 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:607:9: ( scalar | map | bag | tuple )
            int alt108=4;
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
                alt108=1;
                }
                break;
            case MAP_VAL:
                {
                alt108=2;
                }
                break;
            case BAG_VAL:
                {
                alt108=3;
                }
                break;
            case TUPLE_VAL:
                {
                alt108=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 108, 0, input);

                throw nvae;

            }

            switch (alt108) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:607:11: scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_scalar_in_literal3287);
                    scalar378=scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, scalar378.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:607:20: map
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_in_literal3291);
                    map379=map();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map379.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:607:26: bag
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_in_literal3295);
                    bag380=bag();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag380.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:607:32: tuple
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_in_literal3299);
                    tuple381=tuple();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple381.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:610:1: scalar : ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE );
    public final AliasMasker.scalar_return scalar() throws RecognitionException {
        AliasMasker.scalar_return retval = new AliasMasker.scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING383=null;
        CommonTree NULL384=null;
        CommonTree TRUE385=null;
        CommonTree FALSE386=null;
        AliasMasker.num_scalar_return num_scalar382 =null;


        CommonTree QUOTEDSTRING383_tree=null;
        CommonTree NULL384_tree=null;
        CommonTree TRUE385_tree=null;
        CommonTree FALSE386_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:610:8: ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE )
            int alt109=5;
            switch ( input.LA(1) ) {
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case DOUBLENUMBER:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
                {
                alt109=1;
                }
                break;
            case QUOTEDSTRING:
                {
                alt109=2;
                }
                break;
            case NULL:
                {
                alt109=3;
                }
                break;
            case TRUE:
                {
                alt109=4;
                }
                break;
            case FALSE:
                {
                alt109=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 109, 0, input);

                throw nvae;

            }

            switch (alt109) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:610:10: num_scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_num_scalar_in_scalar3308);
                    num_scalar382=num_scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, num_scalar382.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:610:23: QUOTEDSTRING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING383=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_scalar3312); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING383_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING383);


                    adaptor.addChild(root_0, QUOTEDSTRING383_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:610:38: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL384=(CommonTree)match(input,NULL,FOLLOW_NULL_in_scalar3316); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL384_tree = (CommonTree)adaptor.dupNode(NULL384);


                    adaptor.addChild(root_0, NULL384_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:610:45: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE385=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_scalar3320); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE385_tree = (CommonTree)adaptor.dupNode(TRUE385);


                    adaptor.addChild(root_0, TRUE385_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:610:52: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE386=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_scalar3324); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE386_tree = (CommonTree)adaptor.dupNode(FALSE386);


                    adaptor.addChild(root_0, FALSE386_tree);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:613:1: num_scalar : ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER ) ;
    public final AliasMasker.num_scalar_return num_scalar() throws RecognitionException {
        AliasMasker.num_scalar_return retval = new AliasMasker.num_scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MINUS387=null;
        CommonTree set388=null;

        CommonTree MINUS387_tree=null;
        CommonTree set388_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:613:12: ( ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:613:14: ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER )
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:613:14: ( MINUS )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==MINUS) ) {
                alt110=1;
            }
            switch (alt110) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:613:14: MINUS
                    {
                    _last = (CommonTree)input.LT(1);
                    MINUS387=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_num_scalar3333); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS387_tree = (CommonTree)adaptor.dupNode(MINUS387);


                    adaptor.addChild(root_0, MINUS387_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            set388=(CommonTree)input.LT(1);

            if ( input.LA(1)==BIGDECIMALNUMBER||input.LA(1)==BIGINTEGERNUMBER||input.LA(1)==DOUBLENUMBER||input.LA(1)==FLOATNUMBER||input.LA(1)==INTEGER||input.LA(1)==LONGINTEGER ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set388_tree = (CommonTree)adaptor.dupNode(set388);


                adaptor.addChild(root_0, set388_tree);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:616:1: map : ^( MAP_VAL ( keyvalue )* ) ;
    public final AliasMasker.map_return map() throws RecognitionException {
        AliasMasker.map_return retval = new AliasMasker.map_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_VAL389=null;
        AliasMasker.keyvalue_return keyvalue390 =null;


        CommonTree MAP_VAL389_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:617:5: ( ^( MAP_VAL ( keyvalue )* ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:617:7: ^( MAP_VAL ( keyvalue )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_VAL389=(CommonTree)match(input,MAP_VAL,FOLLOW_MAP_VAL_in_map3375); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_VAL389_tree = (CommonTree)adaptor.dupNode(MAP_VAL389);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_VAL389_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:617:18: ( keyvalue )*
                loop111:
                do {
                    int alt111=2;
                    int LA111_0 = input.LA(1);

                    if ( (LA111_0==KEY_VAL_PAIR) ) {
                        alt111=1;
                    }


                    switch (alt111) {
                	case 1 :
                	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:617:18: keyvalue
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_keyvalue_in_map3377);
                	    keyvalue390=keyvalue();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, keyvalue390.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop111;
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:620:1: keyvalue : ^( KEY_VAL_PAIR map_key const_expr ) ;
    public final AliasMasker.keyvalue_return keyvalue() throws RecognitionException {
        AliasMasker.keyvalue_return retval = new AliasMasker.keyvalue_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree KEY_VAL_PAIR391=null;
        AliasMasker.map_key_return map_key392 =null;

        AliasMasker.const_expr_return const_expr393 =null;


        CommonTree KEY_VAL_PAIR391_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:621:5: ( ^( KEY_VAL_PAIR map_key const_expr ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:621:7: ^( KEY_VAL_PAIR map_key const_expr )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            KEY_VAL_PAIR391=(CommonTree)match(input,KEY_VAL_PAIR,FOLLOW_KEY_VAL_PAIR_in_keyvalue3395); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            KEY_VAL_PAIR391_tree = (CommonTree)adaptor.dupNode(KEY_VAL_PAIR391);


            root_1 = (CommonTree)adaptor.becomeRoot(KEY_VAL_PAIR391_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_map_key_in_keyvalue3397);
            map_key392=map_key();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, map_key392.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_const_expr_in_keyvalue3399);
            const_expr393=const_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, const_expr393.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:624:1: map_key : QUOTEDSTRING ;
    public final AliasMasker.map_key_return map_key() throws RecognitionException {
        AliasMasker.map_key_return retval = new AliasMasker.map_key_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING394=null;

        CommonTree QUOTEDSTRING394_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:624:9: ( QUOTEDSTRING )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:624:11: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING394=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_map_key3410); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING394_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING394);


            adaptor.addChild(root_0, QUOTEDSTRING394_tree);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:627:1: bag : ^( BAG_VAL ( tuple )* ) ;
    public final AliasMasker.bag_return bag() throws RecognitionException {
        AliasMasker.bag_return retval = new AliasMasker.bag_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_VAL395=null;
        AliasMasker.tuple_return tuple396 =null;


        CommonTree BAG_VAL395_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:628:5: ( ^( BAG_VAL ( tuple )* ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:628:7: ^( BAG_VAL ( tuple )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_VAL395=(CommonTree)match(input,BAG_VAL,FOLLOW_BAG_VAL_in_bag3425); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_VAL395_tree = (CommonTree)adaptor.dupNode(BAG_VAL395);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_VAL395_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:628:18: ( tuple )*
                loop112:
                do {
                    int alt112=2;
                    int LA112_0 = input.LA(1);

                    if ( (LA112_0==TUPLE_VAL) ) {
                        alt112=1;
                    }


                    switch (alt112) {
                	case 1 :
                	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:628:18: tuple
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_tuple_in_bag3427);
                	    tuple396=tuple();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, tuple396.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop112;
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:631:1: tuple : ^( TUPLE_VAL ( literal )* ) ;
    public final AliasMasker.tuple_return tuple() throws RecognitionException {
        AliasMasker.tuple_return retval = new AliasMasker.tuple_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_VAL397=null;
        AliasMasker.literal_return literal398 =null;


        CommonTree TUPLE_VAL397_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:632:5: ( ^( TUPLE_VAL ( literal )* ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:632:7: ^( TUPLE_VAL ( literal )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_VAL397=(CommonTree)match(input,TUPLE_VAL,FOLLOW_TUPLE_VAL_in_tuple3445); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_VAL397_tree = (CommonTree)adaptor.dupNode(TUPLE_VAL397);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_VAL397_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:632:20: ( literal )*
                loop113:
                do {
                    int alt113=2;
                    int LA113_0 = input.LA(1);

                    if ( (LA113_0==BIGDECIMALNUMBER||LA113_0==BIGINTEGERNUMBER||LA113_0==DOUBLENUMBER||LA113_0==FALSE||LA113_0==FLOATNUMBER||LA113_0==INTEGER||LA113_0==LONGINTEGER||LA113_0==MINUS||LA113_0==NULL||LA113_0==QUOTEDSTRING||LA113_0==TRUE||LA113_0==BAG_VAL||LA113_0==MAP_VAL||LA113_0==TUPLE_VAL) ) {
                        alt113=1;
                    }


                    switch (alt113) {
                	case 1 :
                	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:632:20: literal
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_literal_in_tuple3447);
                	    literal398=literal();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, literal398.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop113;
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:636:1: eid : ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | CUBE | ROLLUP | MATCHES | ORDER | RANK | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | DATETIME | CHARARRAY | BIGINTEGER | BIGDECIMAL | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE | ASSERT );
    public final AliasMasker.eid_return eid() throws RecognitionException {
        AliasMasker.eid_return retval = new AliasMasker.eid_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IMPORT400=null;
        CommonTree RETURNS401=null;
        CommonTree DEFINE402=null;
        CommonTree LOAD403=null;
        CommonTree FILTER404=null;
        CommonTree FOREACH405=null;
        CommonTree CUBE406=null;
        CommonTree ROLLUP407=null;
        CommonTree MATCHES408=null;
        CommonTree ORDER409=null;
        CommonTree RANK410=null;
        CommonTree DISTINCT411=null;
        CommonTree COGROUP412=null;
        CommonTree JOIN413=null;
        CommonTree CROSS414=null;
        CommonTree UNION415=null;
        CommonTree SPLIT416=null;
        CommonTree INTO417=null;
        CommonTree IF418=null;
        CommonTree ALL419=null;
        CommonTree AS420=null;
        CommonTree BY421=null;
        CommonTree USING422=null;
        CommonTree INNER423=null;
        CommonTree OUTER424=null;
        CommonTree PARALLEL425=null;
        CommonTree PARTITION426=null;
        CommonTree GROUP427=null;
        CommonTree AND428=null;
        CommonTree OR429=null;
        CommonTree NOT430=null;
        CommonTree GENERATE431=null;
        CommonTree FLATTEN432=null;
        CommonTree EVAL433=null;
        CommonTree ASC434=null;
        CommonTree DESC435=null;
        CommonTree BOOLEAN436=null;
        CommonTree INT437=null;
        CommonTree LONG438=null;
        CommonTree FLOAT439=null;
        CommonTree DOUBLE440=null;
        CommonTree DATETIME441=null;
        CommonTree CHARARRAY442=null;
        CommonTree BIGINTEGER443=null;
        CommonTree BIGDECIMAL444=null;
        CommonTree BYTEARRAY445=null;
        CommonTree BAG446=null;
        CommonTree TUPLE447=null;
        CommonTree MAP448=null;
        CommonTree IS449=null;
        CommonTree NULL450=null;
        CommonTree TRUE451=null;
        CommonTree FALSE452=null;
        CommonTree STREAM453=null;
        CommonTree THROUGH454=null;
        CommonTree STORE455=null;
        CommonTree MAPREDUCE456=null;
        CommonTree SHIP457=null;
        CommonTree CACHE458=null;
        CommonTree INPUT459=null;
        CommonTree OUTPUT460=null;
        CommonTree STDERROR461=null;
        CommonTree STDIN462=null;
        CommonTree STDOUT463=null;
        CommonTree LIMIT464=null;
        CommonTree SAMPLE465=null;
        CommonTree LEFT466=null;
        CommonTree RIGHT467=null;
        CommonTree FULL468=null;
        CommonTree IDENTIFIER469=null;
        CommonTree TOBAG470=null;
        CommonTree TOMAP471=null;
        CommonTree TOTUPLE472=null;
        CommonTree ASSERT473=null;
        AliasMasker.rel_str_op_return rel_str_op399 =null;


        CommonTree IMPORT400_tree=null;
        CommonTree RETURNS401_tree=null;
        CommonTree DEFINE402_tree=null;
        CommonTree LOAD403_tree=null;
        CommonTree FILTER404_tree=null;
        CommonTree FOREACH405_tree=null;
        CommonTree CUBE406_tree=null;
        CommonTree ROLLUP407_tree=null;
        CommonTree MATCHES408_tree=null;
        CommonTree ORDER409_tree=null;
        CommonTree RANK410_tree=null;
        CommonTree DISTINCT411_tree=null;
        CommonTree COGROUP412_tree=null;
        CommonTree JOIN413_tree=null;
        CommonTree CROSS414_tree=null;
        CommonTree UNION415_tree=null;
        CommonTree SPLIT416_tree=null;
        CommonTree INTO417_tree=null;
        CommonTree IF418_tree=null;
        CommonTree ALL419_tree=null;
        CommonTree AS420_tree=null;
        CommonTree BY421_tree=null;
        CommonTree USING422_tree=null;
        CommonTree INNER423_tree=null;
        CommonTree OUTER424_tree=null;
        CommonTree PARALLEL425_tree=null;
        CommonTree PARTITION426_tree=null;
        CommonTree GROUP427_tree=null;
        CommonTree AND428_tree=null;
        CommonTree OR429_tree=null;
        CommonTree NOT430_tree=null;
        CommonTree GENERATE431_tree=null;
        CommonTree FLATTEN432_tree=null;
        CommonTree EVAL433_tree=null;
        CommonTree ASC434_tree=null;
        CommonTree DESC435_tree=null;
        CommonTree BOOLEAN436_tree=null;
        CommonTree INT437_tree=null;
        CommonTree LONG438_tree=null;
        CommonTree FLOAT439_tree=null;
        CommonTree DOUBLE440_tree=null;
        CommonTree DATETIME441_tree=null;
        CommonTree CHARARRAY442_tree=null;
        CommonTree BIGINTEGER443_tree=null;
        CommonTree BIGDECIMAL444_tree=null;
        CommonTree BYTEARRAY445_tree=null;
        CommonTree BAG446_tree=null;
        CommonTree TUPLE447_tree=null;
        CommonTree MAP448_tree=null;
        CommonTree IS449_tree=null;
        CommonTree NULL450_tree=null;
        CommonTree TRUE451_tree=null;
        CommonTree FALSE452_tree=null;
        CommonTree STREAM453_tree=null;
        CommonTree THROUGH454_tree=null;
        CommonTree STORE455_tree=null;
        CommonTree MAPREDUCE456_tree=null;
        CommonTree SHIP457_tree=null;
        CommonTree CACHE458_tree=null;
        CommonTree INPUT459_tree=null;
        CommonTree OUTPUT460_tree=null;
        CommonTree STDERROR461_tree=null;
        CommonTree STDIN462_tree=null;
        CommonTree STDOUT463_tree=null;
        CommonTree LIMIT464_tree=null;
        CommonTree SAMPLE465_tree=null;
        CommonTree LEFT466_tree=null;
        CommonTree RIGHT467_tree=null;
        CommonTree FULL468_tree=null;
        CommonTree IDENTIFIER469_tree=null;
        CommonTree TOBAG470_tree=null;
        CommonTree TOMAP471_tree=null;
        CommonTree TOTUPLE472_tree=null;
        CommonTree ASSERT473_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:636:5: ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | CUBE | ROLLUP | MATCHES | ORDER | RANK | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | DATETIME | CHARARRAY | BIGINTEGER | BIGDECIMAL | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE | ASSERT )
            int alt114=75;
            switch ( input.LA(1) ) {
            case STR_OP_EQ:
            case STR_OP_GT:
            case STR_OP_GTE:
            case STR_OP_LT:
            case STR_OP_LTE:
            case STR_OP_MATCHES:
            case STR_OP_NE:
                {
                alt114=1;
                }
                break;
            case IMPORT:
                {
                alt114=2;
                }
                break;
            case RETURNS:
                {
                alt114=3;
                }
                break;
            case DEFINE:
                {
                alt114=4;
                }
                break;
            case LOAD:
                {
                alt114=5;
                }
                break;
            case FILTER:
                {
                alt114=6;
                }
                break;
            case FOREACH:
                {
                alt114=7;
                }
                break;
            case CUBE:
                {
                alt114=8;
                }
                break;
            case ROLLUP:
                {
                alt114=9;
                }
                break;
            case MATCHES:
                {
                alt114=10;
                }
                break;
            case ORDER:
                {
                alt114=11;
                }
                break;
            case RANK:
                {
                alt114=12;
                }
                break;
            case DISTINCT:
                {
                alt114=13;
                }
                break;
            case COGROUP:
                {
                alt114=14;
                }
                break;
            case JOIN:
                {
                alt114=15;
                }
                break;
            case CROSS:
                {
                alt114=16;
                }
                break;
            case UNION:
                {
                alt114=17;
                }
                break;
            case SPLIT:
                {
                alt114=18;
                }
                break;
            case INTO:
                {
                alt114=19;
                }
                break;
            case IF:
                {
                alt114=20;
                }
                break;
            case ALL:
                {
                alt114=21;
                }
                break;
            case AS:
                {
                alt114=22;
                }
                break;
            case BY:
                {
                alt114=23;
                }
                break;
            case USING:
                {
                alt114=24;
                }
                break;
            case INNER:
                {
                alt114=25;
                }
                break;
            case OUTER:
                {
                alt114=26;
                }
                break;
            case PARALLEL:
                {
                alt114=27;
                }
                break;
            case PARTITION:
                {
                alt114=28;
                }
                break;
            case GROUP:
                {
                alt114=29;
                }
                break;
            case AND:
                {
                alt114=30;
                }
                break;
            case OR:
                {
                alt114=31;
                }
                break;
            case NOT:
                {
                alt114=32;
                }
                break;
            case GENERATE:
                {
                alt114=33;
                }
                break;
            case FLATTEN:
                {
                alt114=34;
                }
                break;
            case EVAL:
                {
                alt114=35;
                }
                break;
            case ASC:
                {
                alt114=36;
                }
                break;
            case DESC:
                {
                alt114=37;
                }
                break;
            case BOOLEAN:
                {
                alt114=38;
                }
                break;
            case INT:
                {
                alt114=39;
                }
                break;
            case LONG:
                {
                alt114=40;
                }
                break;
            case FLOAT:
                {
                alt114=41;
                }
                break;
            case DOUBLE:
                {
                alt114=42;
                }
                break;
            case DATETIME:
                {
                alt114=43;
                }
                break;
            case CHARARRAY:
                {
                alt114=44;
                }
                break;
            case BIGINTEGER:
                {
                alt114=45;
                }
                break;
            case BIGDECIMAL:
                {
                alt114=46;
                }
                break;
            case BYTEARRAY:
                {
                alt114=47;
                }
                break;
            case BAG:
                {
                alt114=48;
                }
                break;
            case TUPLE:
                {
                alt114=49;
                }
                break;
            case MAP:
                {
                alt114=50;
                }
                break;
            case IS:
                {
                alt114=51;
                }
                break;
            case NULL:
                {
                alt114=52;
                }
                break;
            case TRUE:
                {
                alt114=53;
                }
                break;
            case FALSE:
                {
                alt114=54;
                }
                break;
            case STREAM:
                {
                alt114=55;
                }
                break;
            case THROUGH:
                {
                alt114=56;
                }
                break;
            case STORE:
                {
                alt114=57;
                }
                break;
            case MAPREDUCE:
                {
                alt114=58;
                }
                break;
            case SHIP:
                {
                alt114=59;
                }
                break;
            case CACHE:
                {
                alt114=60;
                }
                break;
            case INPUT:
                {
                alt114=61;
                }
                break;
            case OUTPUT:
                {
                alt114=62;
                }
                break;
            case STDERROR:
                {
                alt114=63;
                }
                break;
            case STDIN:
                {
                alt114=64;
                }
                break;
            case STDOUT:
                {
                alt114=65;
                }
                break;
            case LIMIT:
                {
                alt114=66;
                }
                break;
            case SAMPLE:
                {
                alt114=67;
                }
                break;
            case LEFT:
                {
                alt114=68;
                }
                break;
            case RIGHT:
                {
                alt114=69;
                }
                break;
            case FULL:
                {
                alt114=70;
                }
                break;
            case IDENTIFIER:
                {
                alt114=71;
                }
                break;
            case TOBAG:
                {
                alt114=72;
                }
                break;
            case TOMAP:
                {
                alt114=73;
                }
                break;
            case TOTUPLE:
                {
                alt114=74;
                }
                break;
            case ASSERT:
                {
                alt114=75;
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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:636:7: rel_str_op
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_str_op_in_eid3460);
                    rel_str_op399=rel_str_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_str_op399.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:637:7: IMPORT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IMPORT400=(CommonTree)match(input,IMPORT,FOLLOW_IMPORT_in_eid3468); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IMPORT400_tree = (CommonTree)adaptor.dupNode(IMPORT400);


                    adaptor.addChild(root_0, IMPORT400_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:638:7: RETURNS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RETURNS401=(CommonTree)match(input,RETURNS,FOLLOW_RETURNS_in_eid3476); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RETURNS401_tree = (CommonTree)adaptor.dupNode(RETURNS401);


                    adaptor.addChild(root_0, RETURNS401_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:639:7: DEFINE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DEFINE402=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_eid3484); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINE402_tree = (CommonTree)adaptor.dupNode(DEFINE402);


                    adaptor.addChild(root_0, DEFINE402_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:640:7: LOAD
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LOAD403=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_eid3492); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LOAD403_tree = (CommonTree)adaptor.dupNode(LOAD403);


                    adaptor.addChild(root_0, LOAD403_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:641:7: FILTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FILTER404=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_eid3500); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FILTER404_tree = (CommonTree)adaptor.dupNode(FILTER404);


                    adaptor.addChild(root_0, FILTER404_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:642:7: FOREACH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FOREACH405=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_eid3508); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH405_tree = (CommonTree)adaptor.dupNode(FOREACH405);


                    adaptor.addChild(root_0, FOREACH405_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:643:7: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE406=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_eid3516); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE406_tree = (CommonTree)adaptor.dupNode(CUBE406);


                    adaptor.addChild(root_0, CUBE406_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:644:7: ROLLUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ROLLUP407=(CommonTree)match(input,ROLLUP,FOLLOW_ROLLUP_in_eid3524); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ROLLUP407_tree = (CommonTree)adaptor.dupNode(ROLLUP407);


                    adaptor.addChild(root_0, ROLLUP407_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:645:7: MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MATCHES408=(CommonTree)match(input,MATCHES,FOLLOW_MATCHES_in_eid3532); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MATCHES408_tree = (CommonTree)adaptor.dupNode(MATCHES408);


                    adaptor.addChild(root_0, MATCHES408_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:646:7: ORDER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ORDER409=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_eid3540); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ORDER409_tree = (CommonTree)adaptor.dupNode(ORDER409);


                    adaptor.addChild(root_0, ORDER409_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:647:7: RANK
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RANK410=(CommonTree)match(input,RANK,FOLLOW_RANK_in_eid3548); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RANK410_tree = (CommonTree)adaptor.dupNode(RANK410);


                    adaptor.addChild(root_0, RANK410_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:648:7: DISTINCT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DISTINCT411=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_eid3556); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DISTINCT411_tree = (CommonTree)adaptor.dupNode(DISTINCT411);


                    adaptor.addChild(root_0, DISTINCT411_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:649:7: COGROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    COGROUP412=(CommonTree)match(input,COGROUP,FOLLOW_COGROUP_in_eid3564); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COGROUP412_tree = (CommonTree)adaptor.dupNode(COGROUP412);


                    adaptor.addChild(root_0, COGROUP412_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:650:7: JOIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    JOIN413=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_eid3572); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    JOIN413_tree = (CommonTree)adaptor.dupNode(JOIN413);


                    adaptor.addChild(root_0, JOIN413_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:651:7: CROSS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CROSS414=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_eid3580); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CROSS414_tree = (CommonTree)adaptor.dupNode(CROSS414);


                    adaptor.addChild(root_0, CROSS414_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:652:7: UNION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    UNION415=(CommonTree)match(input,UNION,FOLLOW_UNION_in_eid3588); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    UNION415_tree = (CommonTree)adaptor.dupNode(UNION415);


                    adaptor.addChild(root_0, UNION415_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:653:7: SPLIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SPLIT416=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_eid3596); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SPLIT416_tree = (CommonTree)adaptor.dupNode(SPLIT416);


                    adaptor.addChild(root_0, SPLIT416_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 19 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:654:7: INTO
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INTO417=(CommonTree)match(input,INTO,FOLLOW_INTO_in_eid3604); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTO417_tree = (CommonTree)adaptor.dupNode(INTO417);


                    adaptor.addChild(root_0, INTO417_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 20 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:655:7: IF
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IF418=(CommonTree)match(input,IF,FOLLOW_IF_in_eid3612); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IF418_tree = (CommonTree)adaptor.dupNode(IF418);


                    adaptor.addChild(root_0, IF418_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 21 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:656:7: ALL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ALL419=(CommonTree)match(input,ALL,FOLLOW_ALL_in_eid3620); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL419_tree = (CommonTree)adaptor.dupNode(ALL419);


                    adaptor.addChild(root_0, ALL419_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 22 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:657:7: AS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AS420=(CommonTree)match(input,AS,FOLLOW_AS_in_eid3628); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AS420_tree = (CommonTree)adaptor.dupNode(AS420);


                    adaptor.addChild(root_0, AS420_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 23 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:658:7: BY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BY421=(CommonTree)match(input,BY,FOLLOW_BY_in_eid3636); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BY421_tree = (CommonTree)adaptor.dupNode(BY421);


                    adaptor.addChild(root_0, BY421_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 24 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:659:7: USING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    USING422=(CommonTree)match(input,USING,FOLLOW_USING_in_eid3644); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    USING422_tree = (CommonTree)adaptor.dupNode(USING422);


                    adaptor.addChild(root_0, USING422_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 25 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:660:7: INNER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INNER423=(CommonTree)match(input,INNER,FOLLOW_INNER_in_eid3652); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INNER423_tree = (CommonTree)adaptor.dupNode(INNER423);


                    adaptor.addChild(root_0, INNER423_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 26 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:661:7: OUTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTER424=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_eid3660); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTER424_tree = (CommonTree)adaptor.dupNode(OUTER424);


                    adaptor.addChild(root_0, OUTER424_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 27 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:662:7: PARALLEL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARALLEL425=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_eid3668); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARALLEL425_tree = (CommonTree)adaptor.dupNode(PARALLEL425);


                    adaptor.addChild(root_0, PARALLEL425_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 28 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:663:7: PARTITION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARTITION426=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_eid3676); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARTITION426_tree = (CommonTree)adaptor.dupNode(PARTITION426);


                    adaptor.addChild(root_0, PARTITION426_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 29 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:664:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP427=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_eid3684); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP427_tree = (CommonTree)adaptor.dupNode(GROUP427);


                    adaptor.addChild(root_0, GROUP427_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 30 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:665:7: AND
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AND428=(CommonTree)match(input,AND,FOLLOW_AND_in_eid3692); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND428_tree = (CommonTree)adaptor.dupNode(AND428);


                    adaptor.addChild(root_0, AND428_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 31 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:666:7: OR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OR429=(CommonTree)match(input,OR,FOLLOW_OR_in_eid3700); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR429_tree = (CommonTree)adaptor.dupNode(OR429);


                    adaptor.addChild(root_0, OR429_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 32 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:667:7: NOT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NOT430=(CommonTree)match(input,NOT,FOLLOW_NOT_in_eid3708); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT430_tree = (CommonTree)adaptor.dupNode(NOT430);


                    adaptor.addChild(root_0, NOT430_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 33 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:668:7: GENERATE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GENERATE431=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_eid3716); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GENERATE431_tree = (CommonTree)adaptor.dupNode(GENERATE431);


                    adaptor.addChild(root_0, GENERATE431_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 34 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:669:7: FLATTEN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLATTEN432=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_eid3724); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLATTEN432_tree = (CommonTree)adaptor.dupNode(FLATTEN432);


                    adaptor.addChild(root_0, FLATTEN432_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 35 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:670:7: EVAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    EVAL433=(CommonTree)match(input,EVAL,FOLLOW_EVAL_in_eid3732); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EVAL433_tree = (CommonTree)adaptor.dupNode(EVAL433);


                    adaptor.addChild(root_0, EVAL433_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 36 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:671:7: ASC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ASC434=(CommonTree)match(input,ASC,FOLLOW_ASC_in_eid3740); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASC434_tree = (CommonTree)adaptor.dupNode(ASC434);


                    adaptor.addChild(root_0, ASC434_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 37 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:672:7: DESC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DESC435=(CommonTree)match(input,DESC,FOLLOW_DESC_in_eid3748); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DESC435_tree = (CommonTree)adaptor.dupNode(DESC435);


                    adaptor.addChild(root_0, DESC435_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 38 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:673:7: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN436=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_eid3756); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN436_tree = (CommonTree)adaptor.dupNode(BOOLEAN436);


                    adaptor.addChild(root_0, BOOLEAN436_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 39 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:674:7: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT437=(CommonTree)match(input,INT,FOLLOW_INT_in_eid3764); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT437_tree = (CommonTree)adaptor.dupNode(INT437);


                    adaptor.addChild(root_0, INT437_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 40 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:675:7: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG438=(CommonTree)match(input,LONG,FOLLOW_LONG_in_eid3772); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG438_tree = (CommonTree)adaptor.dupNode(LONG438);


                    adaptor.addChild(root_0, LONG438_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 41 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:676:7: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT439=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_eid3780); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT439_tree = (CommonTree)adaptor.dupNode(FLOAT439);


                    adaptor.addChild(root_0, FLOAT439_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 42 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:677:7: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE440=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_eid3788); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE440_tree = (CommonTree)adaptor.dupNode(DOUBLE440);


                    adaptor.addChild(root_0, DOUBLE440_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 43 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:678:7: DATETIME
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DATETIME441=(CommonTree)match(input,DATETIME,FOLLOW_DATETIME_in_eid3796); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DATETIME441_tree = (CommonTree)adaptor.dupNode(DATETIME441);


                    adaptor.addChild(root_0, DATETIME441_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 44 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:679:7: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY442=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_eid3804); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY442_tree = (CommonTree)adaptor.dupNode(CHARARRAY442);


                    adaptor.addChild(root_0, CHARARRAY442_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 45 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:680:7: BIGINTEGER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGINTEGER443=(CommonTree)match(input,BIGINTEGER,FOLLOW_BIGINTEGER_in_eid3812); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGINTEGER443_tree = (CommonTree)adaptor.dupNode(BIGINTEGER443);


                    adaptor.addChild(root_0, BIGINTEGER443_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 46 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:681:7: BIGDECIMAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGDECIMAL444=(CommonTree)match(input,BIGDECIMAL,FOLLOW_BIGDECIMAL_in_eid3820); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGDECIMAL444_tree = (CommonTree)adaptor.dupNode(BIGDECIMAL444);


                    adaptor.addChild(root_0, BIGDECIMAL444_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 47 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:682:7: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY445=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_eid3828); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY445_tree = (CommonTree)adaptor.dupNode(BYTEARRAY445);


                    adaptor.addChild(root_0, BYTEARRAY445_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 48 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:683:7: BAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BAG446=(CommonTree)match(input,BAG,FOLLOW_BAG_in_eid3836); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BAG446_tree = (CommonTree)adaptor.dupNode(BAG446);


                    adaptor.addChild(root_0, BAG446_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 49 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:684:7: TUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TUPLE447=(CommonTree)match(input,TUPLE,FOLLOW_TUPLE_in_eid3844); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE447_tree = (CommonTree)adaptor.dupNode(TUPLE447);


                    adaptor.addChild(root_0, TUPLE447_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 50 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:685:7: MAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAP448=(CommonTree)match(input,MAP,FOLLOW_MAP_in_eid3852); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAP448_tree = (CommonTree)adaptor.dupNode(MAP448);


                    adaptor.addChild(root_0, MAP448_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 51 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:686:7: IS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IS449=(CommonTree)match(input,IS,FOLLOW_IS_in_eid3860); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IS449_tree = (CommonTree)adaptor.dupNode(IS449);


                    adaptor.addChild(root_0, IS449_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 52 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:687:7: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL450=(CommonTree)match(input,NULL,FOLLOW_NULL_in_eid3868); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL450_tree = (CommonTree)adaptor.dupNode(NULL450);


                    adaptor.addChild(root_0, NULL450_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 53 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:688:7: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE451=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_eid3876); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE451_tree = (CommonTree)adaptor.dupNode(TRUE451);


                    adaptor.addChild(root_0, TRUE451_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 54 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:689:7: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE452=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_eid3884); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE452_tree = (CommonTree)adaptor.dupNode(FALSE452);


                    adaptor.addChild(root_0, FALSE452_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 55 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:690:7: STREAM
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STREAM453=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_eid3892); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STREAM453_tree = (CommonTree)adaptor.dupNode(STREAM453);


                    adaptor.addChild(root_0, STREAM453_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 56 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:691:7: THROUGH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    THROUGH454=(CommonTree)match(input,THROUGH,FOLLOW_THROUGH_in_eid3900); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    THROUGH454_tree = (CommonTree)adaptor.dupNode(THROUGH454);


                    adaptor.addChild(root_0, THROUGH454_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 57 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:692:7: STORE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STORE455=(CommonTree)match(input,STORE,FOLLOW_STORE_in_eid3908); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STORE455_tree = (CommonTree)adaptor.dupNode(STORE455);


                    adaptor.addChild(root_0, STORE455_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 58 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:693:7: MAPREDUCE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAPREDUCE456=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_eid3916); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAPREDUCE456_tree = (CommonTree)adaptor.dupNode(MAPREDUCE456);


                    adaptor.addChild(root_0, MAPREDUCE456_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 59 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:694:7: SHIP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SHIP457=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_eid3924); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SHIP457_tree = (CommonTree)adaptor.dupNode(SHIP457);


                    adaptor.addChild(root_0, SHIP457_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 60 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:695:7: CACHE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CACHE458=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_eid3932); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CACHE458_tree = (CommonTree)adaptor.dupNode(CACHE458);


                    adaptor.addChild(root_0, CACHE458_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 61 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:696:7: INPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INPUT459=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_eid3940); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INPUT459_tree = (CommonTree)adaptor.dupNode(INPUT459);


                    adaptor.addChild(root_0, INPUT459_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 62 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:697:7: OUTPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTPUT460=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_eid3948); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTPUT460_tree = (CommonTree)adaptor.dupNode(OUTPUT460);


                    adaptor.addChild(root_0, OUTPUT460_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 63 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:698:7: STDERROR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDERROR461=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_eid3956); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDERROR461_tree = (CommonTree)adaptor.dupNode(STDERROR461);


                    adaptor.addChild(root_0, STDERROR461_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 64 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:699:7: STDIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDIN462=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_eid3964); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN462_tree = (CommonTree)adaptor.dupNode(STDIN462);


                    adaptor.addChild(root_0, STDIN462_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 65 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:700:7: STDOUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDOUT463=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_eid3972); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT463_tree = (CommonTree)adaptor.dupNode(STDOUT463);


                    adaptor.addChild(root_0, STDOUT463_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 66 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:701:7: LIMIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LIMIT464=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_eid3980); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LIMIT464_tree = (CommonTree)adaptor.dupNode(LIMIT464);


                    adaptor.addChild(root_0, LIMIT464_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 67 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:702:7: SAMPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SAMPLE465=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_eid3988); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SAMPLE465_tree = (CommonTree)adaptor.dupNode(SAMPLE465);


                    adaptor.addChild(root_0, SAMPLE465_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 68 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:703:7: LEFT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LEFT466=(CommonTree)match(input,LEFT,FOLLOW_LEFT_in_eid3996); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LEFT466_tree = (CommonTree)adaptor.dupNode(LEFT466);


                    adaptor.addChild(root_0, LEFT466_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 69 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:704:7: RIGHT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RIGHT467=(CommonTree)match(input,RIGHT,FOLLOW_RIGHT_in_eid4004); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RIGHT467_tree = (CommonTree)adaptor.dupNode(RIGHT467);


                    adaptor.addChild(root_0, RIGHT467_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 70 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:705:7: FULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FULL468=(CommonTree)match(input,FULL,FOLLOW_FULL_in_eid4012); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FULL468_tree = (CommonTree)adaptor.dupNode(FULL468);


                    adaptor.addChild(root_0, FULL468_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 71 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:706:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER469=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_eid4020); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER469_tree = (CommonTree)adaptor.dupNode(IDENTIFIER469);


                    adaptor.addChild(root_0, IDENTIFIER469_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 72 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:707:7: TOBAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOBAG470=(CommonTree)match(input,TOBAG,FOLLOW_TOBAG_in_eid4028); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOBAG470_tree = (CommonTree)adaptor.dupNode(TOBAG470);


                    adaptor.addChild(root_0, TOBAG470_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 73 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:708:7: TOMAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOMAP471=(CommonTree)match(input,TOMAP,FOLLOW_TOMAP_in_eid4036); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOMAP471_tree = (CommonTree)adaptor.dupNode(TOMAP471);


                    adaptor.addChild(root_0, TOMAP471_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 74 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:709:7: TOTUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOTUPLE472=(CommonTree)match(input,TOTUPLE,FOLLOW_TOTUPLE_in_eid4044); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOTUPLE472_tree = (CommonTree)adaptor.dupNode(TOTUPLE472);


                    adaptor.addChild(root_0, TOTUPLE472_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 75 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:710:7: ASSERT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ASSERT473=(CommonTree)match(input,ASSERT,FOLLOW_ASSERT_in_eid4052); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASSERT473_tree = (CommonTree)adaptor.dupNode(ASSERT473);


                    adaptor.addChild(root_0, ASSERT473_tree);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:714:1: rel_op : ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES );
    public final AliasMasker.rel_op_return rel_op() throws RecognitionException {
        AliasMasker.rel_op_return retval = new AliasMasker.rel_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_MATCHES480=null;
        AliasMasker.rel_op_eq_return rel_op_eq474 =null;

        AliasMasker.rel_op_ne_return rel_op_ne475 =null;

        AliasMasker.rel_op_gt_return rel_op_gt476 =null;

        AliasMasker.rel_op_gte_return rel_op_gte477 =null;

        AliasMasker.rel_op_lt_return rel_op_lt478 =null;

        AliasMasker.rel_op_lte_return rel_op_lte479 =null;


        CommonTree STR_OP_MATCHES480_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:715:5: ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES )
            int alt115=7;
            switch ( input.LA(1) ) {
            case NUM_OP_EQ:
            case STR_OP_EQ:
                {
                alt115=1;
                }
                break;
            case NUM_OP_NE:
            case STR_OP_NE:
                {
                alt115=2;
                }
                break;
            case NUM_OP_GT:
            case STR_OP_GT:
                {
                alt115=3;
                }
                break;
            case NUM_OP_GTE:
            case STR_OP_GTE:
                {
                alt115=4;
                }
                break;
            case NUM_OP_LT:
            case STR_OP_LT:
                {
                alt115=5;
                }
                break;
            case NUM_OP_LTE:
            case STR_OP_LTE:
                {
                alt115=6;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt115=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 115, 0, input);

                throw nvae;

            }

            switch (alt115) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:715:7: rel_op_eq
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_eq_in_rel_op4066);
                    rel_op_eq474=rel_op_eq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_eq474.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:716:7: rel_op_ne
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_ne_in_rel_op4074);
                    rel_op_ne475=rel_op_ne();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_ne475.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:717:7: rel_op_gt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gt_in_rel_op4082);
                    rel_op_gt476=rel_op_gt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gt476.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:718:7: rel_op_gte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gte_in_rel_op4090);
                    rel_op_gte477=rel_op_gte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gte477.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:719:7: rel_op_lt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lt_in_rel_op4098);
                    rel_op_lt478=rel_op_lt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lt478.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:720:7: rel_op_lte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lte_in_rel_op4106);
                    rel_op_lte479=rel_op_lte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lte479.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:721:7: STR_OP_MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES480=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_rel_op4114); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES480_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES480);


                    adaptor.addChild(root_0, STR_OP_MATCHES480_tree);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:724:1: rel_op_eq : ( STR_OP_EQ | NUM_OP_EQ );
    public final AliasMasker.rel_op_eq_return rel_op_eq() throws RecognitionException {
        AliasMasker.rel_op_eq_return retval = new AliasMasker.rel_op_eq_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set481=null;

        CommonTree set481_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:725:5: ( STR_OP_EQ | NUM_OP_EQ )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set481=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_EQ||input.LA(1)==STR_OP_EQ ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set481_tree = (CommonTree)adaptor.dupNode(set481);


                adaptor.addChild(root_0, set481_tree);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:729:1: rel_op_ne : ( STR_OP_NE | NUM_OP_NE );
    public final AliasMasker.rel_op_ne_return rel_op_ne() throws RecognitionException {
        AliasMasker.rel_op_ne_return retval = new AliasMasker.rel_op_ne_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set482=null;

        CommonTree set482_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:730:5: ( STR_OP_NE | NUM_OP_NE )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set482=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_NE||input.LA(1)==STR_OP_NE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set482_tree = (CommonTree)adaptor.dupNode(set482);


                adaptor.addChild(root_0, set482_tree);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:734:1: rel_op_gt : ( STR_OP_GT | NUM_OP_GT );
    public final AliasMasker.rel_op_gt_return rel_op_gt() throws RecognitionException {
        AliasMasker.rel_op_gt_return retval = new AliasMasker.rel_op_gt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set483=null;

        CommonTree set483_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:735:5: ( STR_OP_GT | NUM_OP_GT )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set483=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GT||input.LA(1)==STR_OP_GT ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set483_tree = (CommonTree)adaptor.dupNode(set483);


                adaptor.addChild(root_0, set483_tree);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:739:1: rel_op_gte : ( STR_OP_GTE | NUM_OP_GTE );
    public final AliasMasker.rel_op_gte_return rel_op_gte() throws RecognitionException {
        AliasMasker.rel_op_gte_return retval = new AliasMasker.rel_op_gte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set484=null;

        CommonTree set484_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:740:5: ( STR_OP_GTE | NUM_OP_GTE )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set484=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GTE||input.LA(1)==STR_OP_GTE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set484_tree = (CommonTree)adaptor.dupNode(set484);


                adaptor.addChild(root_0, set484_tree);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:744:1: rel_op_lt : ( STR_OP_LT | NUM_OP_LT );
    public final AliasMasker.rel_op_lt_return rel_op_lt() throws RecognitionException {
        AliasMasker.rel_op_lt_return retval = new AliasMasker.rel_op_lt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set485=null;

        CommonTree set485_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:745:5: ( STR_OP_LT | NUM_OP_LT )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set485=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LT||input.LA(1)==STR_OP_LT ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set485_tree = (CommonTree)adaptor.dupNode(set485);


                adaptor.addChild(root_0, set485_tree);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:749:1: rel_op_lte : ( STR_OP_LTE | NUM_OP_LTE );
    public final AliasMasker.rel_op_lte_return rel_op_lte() throws RecognitionException {
        AliasMasker.rel_op_lte_return retval = new AliasMasker.rel_op_lte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set486=null;

        CommonTree set486_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:750:5: ( STR_OP_LTE | NUM_OP_LTE )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set486=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LTE||input.LA(1)==STR_OP_LTE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set486_tree = (CommonTree)adaptor.dupNode(set486);


                adaptor.addChild(root_0, set486_tree);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:754:1: rel_str_op : ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES );
    public final AliasMasker.rel_str_op_return rel_str_op() throws RecognitionException {
        AliasMasker.rel_str_op_return retval = new AliasMasker.rel_str_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set487=null;

        CommonTree set487_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:755:5: ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set487=(CommonTree)input.LT(1);

            if ( (input.LA(1) >= STR_OP_EQ && input.LA(1) <= STR_OP_NE) ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set487_tree = (CommonTree)adaptor.dupNode(set487);


                adaptor.addChild(root_0, set487_tree);
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

    // $ANTLR start synpred101_AliasMasker
    public final void synpred101_AliasMasker_fragment() throws RecognitionException {
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:343:7: ( ^( MINUS expr expr ) )
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:343:7: ^( MINUS expr expr )
        {
        match(input,MINUS,FOLLOW_MINUS_in_synpred101_AliasMasker1693); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_expr_in_synpred101_AliasMasker1695);
        expr();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred101_AliasMasker1697);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred101_AliasMasker

    // $ANTLR start synpred105_AliasMasker
    public final void synpred105_AliasMasker_fragment() throws RecognitionException {
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:347:7: ( ^( CAST_EXPR type expr ) )
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:347:7: ^( CAST_EXPR type expr )
        {
        match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_synpred105_AliasMasker1757); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_in_synpred105_AliasMasker1759);
        type();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred105_AliasMasker1761);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred105_AliasMasker

    // $ANTLR start synpred106_AliasMasker
    public final void synpred106_AliasMasker_fragment() throws RecognitionException {
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:348:7: ( const_expr )
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:348:7: const_expr
        {
        pushFollow(FOLLOW_const_expr_in_synpred106_AliasMasker1771);
        const_expr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred106_AliasMasker

    // $ANTLR start synpred109_AliasMasker
    public final void synpred109_AliasMasker_fragment() throws RecognitionException {
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:351:7: ( ^( CAST_EXPR type_cast expr ) )
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:351:7: ^( CAST_EXPR type_cast expr )
        {
        match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_synpred109_AliasMasker1803); if (state.failed) return ;

        match(input, Token.DOWN, null); if (state.failed) return ;
        pushFollow(FOLLOW_type_cast_in_synpred109_AliasMasker1805);
        type_cast();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_expr_in_synpred109_AliasMasker1807);
        expr();

        state._fsp--;
        if (state.failed) return ;

        match(input, Token.UP, null); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred109_AliasMasker

    // $ANTLR start synpred132_AliasMasker
    public final void synpred132_AliasMasker_fragment() throws RecognitionException {
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:412:22: ( INTEGER )
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:412:22: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred132_AliasMasker2184); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred132_AliasMasker

    // $ANTLR start synpred133_AliasMasker
    public final void synpred133_AliasMasker_fragment() throws RecognitionException {
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:412:32: ( LONGINTEGER )
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:412:32: LONGINTEGER
        {
        match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_synpred133_AliasMasker2188); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred133_AliasMasker

    // $ANTLR start synpred134_AliasMasker
    public final void synpred134_AliasMasker_fragment() throws RecognitionException {
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:416:24: ( DOUBLENUMBER )
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:416:24: DOUBLENUMBER
        {
        match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_synpred134_AliasMasker2218); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred134_AliasMasker

    // $ANTLR start synpred160_AliasMasker
    public final void synpred160_AliasMasker_fragment() throws RecognitionException {
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:473:7: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item )
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:473:7: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
        {
        pushFollow(FOLLOW_join_item_in_synpred160_AliasMasker2542);
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


        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:476:16: ( OUTER )?
        int alt124=2;
        int LA124_0 = input.LA(1);

        if ( (LA124_0==OUTER) ) {
            alt124=1;
        }
        switch (alt124) {
            case 1 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:476:16: OUTER
                {
                match(input,OUTER,FOLLOW_OUTER_in_synpred160_AliasMasker2597); if (state.failed) return ;

                }
                break;

        }


        pushFollow(FOLLOW_join_item_in_synpred160_AliasMasker2600);
        join_item();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred160_AliasMasker

    // $ANTLR start synpred178_AliasMasker
    public final void synpred178_AliasMasker_fragment() throws RecognitionException {
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:544:34: ( INTEGER )
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/AliasMasker.g:544:34: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred178_AliasMasker3017); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred178_AliasMasker

    // Delegated rules

    public final boolean synpred106_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred106_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred101_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred101_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred109_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred109_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred178_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred178_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred160_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred160_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred134_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred134_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred133_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred133_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred105_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred105_AliasMasker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred132_AliasMasker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred132_AliasMasker_fragment(); // can never throw exception
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
    public static final BitSet FOLLOW_statement_in_query82 = new BitSet(new long[]{0x0000000000000408L,0x0020000000000000L,0x0012000000000000L});
    public static final BitSet FOLLOW_general_statement_in_statement94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_statement_in_statement108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_statement_in_statement122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assert_statement_in_statement136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_split_statement145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assert_clause_in_assert_statement153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_clause_in_realias_statement162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STATEMENT_in_general_statement178 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_general_statement182 = new BitSet(new long[]{0x0048400226400400L,0x0C21010010004608L,0x0000000000000080L});
    public static final BitSet FOLLOW_op_clause_in_general_statement195 = new BitSet(new long[]{0x0000000000000008L,0x0000000100000000L});
    public static final BitSet FOLLOW_parallel_clause_in_general_statement197 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REALIAS_in_realias_clause210 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_realias_clause212 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_realias_clause214 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARALLEL_in_parallel_clause230 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_parallel_clause232 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_define_clause_in_op_clause266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_load_clause_in_op_clause280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_clause_in_op_clause294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_store_clause_in_op_clause308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filter_clause_in_op_clause322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_distinct_clause_in_op_clause336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_limit_clause_in_op_clause350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sample_clause_in_op_clause364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_order_clause_in_op_clause378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rank_clause_in_op_clause392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cross_clause_in_op_clause406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_clause_in_op_clause420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_union_clause_in_op_clause434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stream_clause_in_op_clause448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mr_clause_in_op_clause462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_op_clause476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreach_clause_in_op_clause490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cube_clause_in_op_clause504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assert_clause_in_op_clause518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_define_clause533 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_define_clause535 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000000L,0x0000000140000000L});
    public static final BitSet FOLLOW_cmd_in_define_clause540 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_func_clause_in_define_clause544 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_cmd563 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ship_clause_in_cmd575 = new BitSet(new long[]{0x2000000000080008L,0x0084000080000000L});
    public static final BitSet FOLLOW_cache_clause_in_cmd579 = new BitSet(new long[]{0x2000000000080008L,0x0084000080000000L});
    public static final BitSet FOLLOW_input_clause_in_cmd583 = new BitSet(new long[]{0x2000000000080008L,0x0084000080000000L});
    public static final BitSet FOLLOW_output_clause_in_cmd587 = new BitSet(new long[]{0x2000000000080008L,0x0084000080000000L});
    public static final BitSet FOLLOW_error_clause_in_cmd591 = new BitSet(new long[]{0x2000000000080008L,0x0084000080000000L});
    public static final BitSet FOLLOW_SHIP_in_ship_clause611 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_ship_clause613 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_path_list629 = new BitSet(new long[]{0x0000000000000002L,0x0000008000000000L});
    public static final BitSet FOLLOW_CACHE_in_cache_clause645 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_cache_clause647 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INPUT_in_input_clause664 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_input_clause666 = new BitSet(new long[]{0x0000000000000008L,0x0300008000000000L});
    public static final BitSet FOLLOW_STDIN_in_stream_cmd684 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd686 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STDOUT_in_stream_cmd699 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd701 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_stream_cmd714 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd716 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OUTPUT_in_output_clause734 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_output_clause736 = new BitSet(new long[]{0x0000000000000008L,0x0300008000000000L});
    public static final BitSet FOLLOW_STDERROR_in_error_clause754 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_error_clause758 = new BitSet(new long[]{0x8000000000000008L});
    public static final BitSet FOLLOW_INTEGER_in_error_clause760 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOAD_in_load_clause781 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_filename_in_load_clause783 = new BitSet(new long[]{0x0000000000000108L,0x0000000000000000L,0x0000000140000000L});
    public static final BitSet FOLLOW_func_clause_in_load_clause785 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_as_clause_in_load_clause788 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_filename804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_as_clause829 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_as_clause831 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_in_field_def848 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_field_def850 = new BitSet(new long[]{0x4001002008255008L,0x0000000000000800L,0x0100020000002000L});
    public static final BitSet FOLLOW_type_in_field_def852 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_WITHOUT_IDENTIFIER_in_field_def867 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_field_def869 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_field_def_in_field_def_list884 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_simple_type_in_type894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_in_type898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_in_type902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_in_tuple_type970 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_tuple_type972 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BAG_TYPE_in_bag_type990 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_bag_type992 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_tuple_type_in_bag_type995 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAP_TYPE_in_map_type1009 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_map_type1011 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_REF_in_func_clause1029 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1031 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_in_func_clause1043 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1045 = new BitSet(new long[]{0x0000000000000008L,0x0000008000000000L});
    public static final BitSet FOLLOW_func_args_in_func_clause1047 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_eid_in_func_name1063 = new BitSet(new long[]{0x0000000800000002L,0x0000000800000000L});
    public static final BitSet FOLLOW_set_in_func_name1067 = new BitSet(new long[]{0x7779D022AE6F5F50L,0xFFA58D03D80C6E1DL,0x18E00000000001F7L});
    public static final BitSet FOLLOW_eid_in_func_name1077 = new BitSet(new long[]{0x0000000800000002L,0x0000000800000000L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_func_args1093 = new BitSet(new long[]{0x0000000000000002L,0x0000008000000000L});
    public static final BitSet FOLLOW_CUBE_in_cube_clause1109 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_item_in_cube_clause1111 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_cube_item1126 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_cube_by_clause_in_cube_item1130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_cube_by_clause1147 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_or_rollup_in_cube_by_clause1149 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_rollup_list_in_cube_or_rollup1164 = new BitSet(new long[]{0x0000000004000002L,0x0000800000000000L});
    public static final BitSet FOLLOW_set_in_cube_rollup_list1180 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_by_expr_list_in_cube_rollup_list1190 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_by_expr_in_cube_by_expr_list1205 = new BitSet(new long[]{0x814410540400A002L,0x0040009400089000L,0x04000C0083998020L});
    public static final BitSet FOLLOW_col_range_in_cube_by_expr1219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_cube_by_expr1223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_cube_by_expr1227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_group_clause1242 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_group_item_in_group_clause1252 = new BitSet(new long[]{0x0148400226400408L,0x0C21018210004608L,0x0000000000000080L});
    public static final BitSet FOLLOW_group_type_in_group_clause1255 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_partition_clause_in_group_clause1258 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_group_type1270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_in_group_item1283 = new BitSet(new long[]{0x0000000000020010L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_join_group_by_clause_in_group_item1287 = new BitSet(new long[]{0x1000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_ALL_in_group_item1291 = new BitSet(new long[]{0x1000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_ANY_in_group_item1295 = new BitSet(new long[]{0x1000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_alias_in_rel1321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_op_clause_in_rel1327 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_parallel_clause_in_rel1329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_flatten_clause_in_flatten_generated_item1357 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_col_range_in_flatten_generated_item1361 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_expr_in_flatten_generated_item1365 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_STAR_in_flatten_generated_item1369 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_field_def_list_in_flatten_generated_item1373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_flatten_clause1389 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_flatten_clause1391 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STORE_in_store_clause1408 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_store_clause1410 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_filename_in_store_clause1412 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000140000000L});
    public static final BitSet FOLLOW_func_clause_in_store_clause1414 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSERT_in_assert_clause1432 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_assert_clause1434 = new BitSet(new long[]{0x0800000000000040L,0xF00000000BFC0000L,0x0000000080040007L});
    public static final BitSet FOLLOW_cond_in_assert_clause1436 = new BitSet(new long[]{0x0000000000000008L,0x0000008000000000L});
    public static final BitSet FOLLOW_comment_in_assert_clause1438 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_comment1450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILTER_in_filter_clause1465 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_filter_clause1467 = new BitSet(new long[]{0x0800000000000040L,0xF00000000BFC0000L,0x0000000080040007L});
    public static final BitSet FOLLOW_cond_in_filter_clause1469 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_cond1486 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1488 = new BitSet(new long[]{0x0800000000000040L,0xF00000000BFC0000L,0x0000000080040007L});
    public static final BitSet FOLLOW_cond_in_cond1490 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_cond1502 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1504 = new BitSet(new long[]{0x0800000000000040L,0xF00000000BFC0000L,0x0000000080040007L});
    public static final BitSet FOLLOW_cond_in_cond1506 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_cond1518 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond1520 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_cond1532 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1534 = new BitSet(new long[]{0x0000000000000008L,0x0000000000040000L});
    public static final BitSet FOLLOW_NOT_in_cond1536 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_in_cond1549 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1551 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0082998020L});
    public static final BitSet FOLLOW_expr_in_cond1553 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_in_eval_in_cond1563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_func_eval_in_cond1571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_COND_in_cond1581 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond1583 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_in_in_eval1600 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IN_LHS_in_in_eval1606 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_in_eval1608 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_RHS_in_in_eval1614 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_in_eval1616 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_EVAL_in_func_eval1638 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_eval1640 = new BitSet(new long[]{0x814410540400A008L,0x0040009400089000L,0x04000C0082998020L});
    public static final BitSet FOLLOW_real_arg_in_func_eval1642 = new BitSet(new long[]{0x814410540400A008L,0x0040009400089000L,0x04000C0082998020L});
    public static final BitSet FOLLOW_expr_in_real_arg1658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_real_arg1662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_expr1677 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1679 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0082998020L});
    public static final BitSet FOLLOW_expr_in_expr1681 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expr1693 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1695 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0082998020L});
    public static final BitSet FOLLOW_expr_in_expr1697 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_expr1709 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1711 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0082998020L});
    public static final BitSet FOLLOW_expr_in_expr1713 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr1725 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1727 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0082998020L});
    public static final BitSet FOLLOW_expr_in_expr1729 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PERCENT_in_expr1741 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1743 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0082998020L});
    public static final BitSet FOLLOW_expr_in_expr1745 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr1757 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_expr1759 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0082998020L});
    public static final BitSet FOLLOW_expr_in_expr1761 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_expr1771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_expr_in_expr1779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEG_in_expr1789 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1791 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr1803 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_expr1805 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0082998020L});
    public static final BitSet FOLLOW_expr_in_expr1807 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPR_IN_PAREN_in_expr1819 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr1821 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_simple_type_in_type_cast1836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type_cast1840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_cast_in_type_cast1844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_cast_in_type_cast1848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast1863 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_tuple_type_cast1865 = new BitSet(new long[]{0x4001002008255008L,0x0000000000000800L,0x0200020000004000L});
    public static final BitSet FOLLOW_BAG_TYPE_CAST_in_bag_type_cast1883 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_type_cast_in_bag_type_cast1885 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_projectable_expr_in_var_expr1901 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
    public static final BitSet FOLLOW_dot_proj_in_var_expr1905 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
    public static final BitSet FOLLOW_pound_proj_in_var_expr1909 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
    public static final BitSet FOLLOW_func_eval_in_projectable_expr1925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_ref_in_projectable_expr1929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bin_expr_in_projectable_expr1933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_expr_in_projectable_expr1937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_cond_in_projectable_expr1941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_dot_proj1956 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_alias_or_index_in_dot_proj1958 = new BitSet(new long[]{0x0140001004000008L});
    public static final BitSet FOLLOW_col_alias_in_col_alias_or_index1970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_index_in_col_alias_or_index1974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_col_index2016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COL_RANGE_in_col_range2027 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_col_range2029 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_DOUBLE_PERIOD_in_col_range2032 = new BitSet(new long[]{0x0140001004000008L});
    public static final BitSet FOLLOW_col_ref_in_col_range2034 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POUND_in_pound_proj2051 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_set_in_pound_proj2053 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BIN_EXPR_in_bin_expr2078 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_bin_expr2080 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0082998020L});
    public static final BitSet FOLLOW_expr_in_bin_expr2082 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0082998020L});
    public static final BitSet FOLLOW_expr_in_bin_expr2084 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_EXPR_in_case_expr2101 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_CASE_EXPR_LHS_in_case_expr2107 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_expr2109 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_EXPR_RHS_in_case_expr2117 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_expr2119 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_COND_in_case_cond2143 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_WHEN_in_case_cond2147 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_case_cond2149 = new BitSet(new long[]{0x0800000000000048L,0xF00000000BFC0000L,0x0000000080040007L});
    public static final BitSet FOLLOW_THEN_in_case_cond2156 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_cond2158 = new BitSet(new long[]{0x814410540400A008L,0x0040009400089000L,0x04000C0082998020L});
    public static final BitSet FOLLOW_LIMIT_in_limit_clause2178 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_limit_clause2180 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0082998020L});
    public static final BitSet FOLLOW_INTEGER_in_limit_clause2184 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LONGINTEGER_in_limit_clause2188 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_limit_clause2192 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SAMPLE_in_sample_clause2212 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_sample_clause2214 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0082998020L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_sample_clause2218 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_sample_clause2222 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RANK_in_rank_clause2238 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_rank_clause2240 = new BitSet(new long[]{0x0000000000020008L});
    public static final BitSet FOLLOW_rank_by_statement_in_rank_clause2244 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_rank_by_statement2261 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rank_by_clause_in_rank_by_statement2263 = new BitSet(new long[]{0x0000000040000008L});
    public static final BitSet FOLLOW_DENSE_in_rank_by_statement2267 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_rank_by_clause2282 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_rank_col_in_rank_by_clause2301 = new BitSet(new long[]{0x0140001004000002L,0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_col_range_in_rank_col2314 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_col_ref_in_rank_col2318 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_ORDER_in_order_clause2346 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_order_clause2348 = new BitSet(new long[]{0x0140001004000000L,0x0040000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_order_by_clause_in_order_clause2350 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000140000000L});
    public static final BitSet FOLLOW_func_clause_in_order_clause2352 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_order_by_clause2368 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_order_col_in_order_by_clause2387 = new BitSet(new long[]{0x0140001004000002L,0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_col_range_in_order_col2402 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_col_ref_in_order_col2406 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_DISTINCT_in_distinct_clause2433 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_distinct_clause2435 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_partition_clause_in_distinct_clause2437 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARTITION_in_partition_clause2455 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_partition_clause2457 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_cross_clause2474 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_list_in_cross_clause2476 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_partition_clause_in_cross_clause2478 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_rel_list2494 = new BitSet(new long[]{0x0148400226400402L,0x0C21010010004608L,0x0000000000000080L});
    public static final BitSet FOLLOW_JOIN_in_join_clause2510 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_sub_clause_in_join_clause2512 = new BitSet(new long[]{0x0000000000000008L,0x0000008200000000L});
    public static final BitSet FOLLOW_join_type_in_join_clause2514 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_partition_clause_in_join_clause2517 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_join_type2529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2542 = new BitSet(new long[]{0x0010000000000000L,0x0000080000000010L});
    public static final BitSet FOLLOW_set_in_join_sub_clause2544 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_OUTER_in_join_sub_clause2597 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause2608 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_JOIN_ITEM_in_join_item2621 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_join_item2623 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_join_group_by_clause_in_join_item2625 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_join_group_by_clause2642 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_group_by_expr_in_join_group_by_clause2644 = new BitSet(new long[]{0x814410540400A008L,0x0040009400089000L,0x04000C0083998020L});
    public static final BitSet FOLLOW_col_range_in_join_group_by_expr2660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_join_group_by_expr2664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_join_group_by_expr2668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_union_clause2683 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ONSCHEMA_in_union_clause2685 = new BitSet(new long[]{0x0148400226400400L,0x0C21010010004608L,0x0000000000000080L});
    public static final BitSet FOLLOW_rel_list_in_union_clause2688 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_foreach_clause2705 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_foreach_clause2707 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000030000000L});
    public static final BitSet FOLLOW_foreach_plan_in_foreach_clause2709 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan2726 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_generate_clause_in_foreach_plan2728 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan2740 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_blk_in_foreach_plan2742 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_command_in_nested_blk2757 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000000L,0x0000300000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_blk2760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_generate_clause2775 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_flatten_generated_item_in_generate_clause2777 = new BitSet(new long[]{0x814490540400A008L,0x0040009400089000L,0x04000C0083998020L});
    public static final BitSet FOLLOW_NESTED_CMD_in_nested_command2795 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command2797 = new BitSet(new long[]{0x0008400202000000L,0x0000000010000200L,0x0000400000000000L});
    public static final BitSet FOLLOW_nested_op_in_nested_command2799 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NESTED_CMD_ASSI_in_nested_command2811 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command2813 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0082998020L});
    public static final BitSet FOLLOW_expr_in_nested_command2815 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op2826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_filter_in_nested_op2840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_sort_in_nested_op2854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_distinct_in_nested_op2868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_limit_in_nested_op2882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_cross_in_nested_op2896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_foreach_in_nested_op2910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NESTED_PROJ_in_nested_proj2925 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj2927 = new BitSet(new long[]{0x0140001004000000L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj2929 = new BitSet(new long[]{0x0140001004000008L});
    public static final BitSet FOLLOW_FILTER_in_nested_filter2947 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_filter2949 = new BitSet(new long[]{0x0800000000000040L,0xF00000000BFC0000L,0x0000000080040007L});
    public static final BitSet FOLLOW_cond_in_nested_filter2951 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ORDER_in_nested_sort2968 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_sort2970 = new BitSet(new long[]{0x0140001004000000L,0x0040000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_order_by_clause_in_nested_sort2972 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000140000000L});
    public static final BitSet FOLLOW_func_clause_in_nested_sort2974 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DISTINCT_in_nested_distinct2992 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_distinct2994 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LIMIT_in_nested_limit3011 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_limit3013 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0082998020L});
    public static final BitSet FOLLOW_INTEGER_in_nested_limit3017 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_nested_limit3021 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_nested_cross3036 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_list_in_nested_cross3038 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_nested_foreach3051 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_foreach3053 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_foreach3055 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_op_input_list3066 = new BitSet(new long[]{0x0140001004000002L,0x0000000000000000L,0x0000400000000000L});
    public static final BitSet FOLLOW_col_ref_in_nested_op_input3076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op_input3080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STREAM_in_stream_clause3095 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_stream_clause3097 = new BitSet(new long[]{0x0100080000000000L});
    public static final BitSet FOLLOW_set_in_stream_clause3099 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_as_clause_in_stream_clause3109 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAPREDUCE_in_mr_clause3127 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_mr_clause3129 = new BitSet(new long[]{0x0000000000000000L,0x0400008000000000L});
    public static final BitSet FOLLOW_path_list_in_mr_clause3131 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_store_clause_in_mr_clause3134 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_load_clause_in_mr_clause3136 = new BitSet(new long[]{0x0000080000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_mr_clause3138 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_in_split_clause3156 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_split_clause3158 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_split_branch_in_split_clause3160 = new BitSet(new long[]{0x0000000000000008L,0x0000000020000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_split_otherwise_in_split_clause3163 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_BRANCH_in_split_branch3181 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_branch3183 = new BitSet(new long[]{0x0800000000000040L,0xF00000000BFC0000L,0x0000000080040007L});
    public static final BitSet FOLLOW_cond_in_split_branch3185 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OTHERWISE_in_split_otherwise3202 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_otherwise3204 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_alias_col_ref_in_col_ref3215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dollar_col_ref_in_col_ref3219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_alias_col_ref3232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_alias_col_ref3240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias_col_ref3248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_dollar_col_ref3269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_const_expr3278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scalar_in_literal3287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_in_literal3291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_in_literal3295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_in_literal3299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_num_scalar_in_scalar3308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_scalar3312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_scalar3316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_scalar3320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_scalar3324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_num_scalar3333 = new BitSet(new long[]{0x800400400000A000L,0x0000000000001000L});
    public static final BitSet FOLLOW_set_in_num_scalar3336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_VAL_in_map3375 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_keyvalue_in_map3377 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_KEY_VAL_PAIR_in_keyvalue3395 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_map_key_in_keyvalue3397 = new BitSet(new long[]{0x800410400000A000L,0x0000008000089000L,0x0400040000008020L});
    public static final BitSet FOLLOW_const_expr_in_keyvalue3399 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_map_key3410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_VAL_in_bag3425 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_in_bag3427 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_TUPLE_VAL_in_tuple3445 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_literal_in_tuple3447 = new BitSet(new long[]{0x800410400000A008L,0x0000008000089000L,0x0400040000008020L});
    public static final BitSet FOLLOW_rel_str_op_in_eid3460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_eid3468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURNS_in_eid3476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_eid3484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOAD_in_eid3492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILTER_in_eid3500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOREACH_in_eid3508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_eid3516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROLLUP_in_eid3524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MATCHES_in_eid3532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_eid3540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANK_in_eid3548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTINCT_in_eid3556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COGROUP_in_eid3564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JOIN_in_eid3572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CROSS_in_eid3580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_eid3588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SPLIT_in_eid3596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTO_in_eid3604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_eid3612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALL_in_eid3620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_eid3628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_eid3636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USING_in_eid3644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INNER_in_eid3652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTER_in_eid3660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARALLEL_in_eid3668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARTITION_in_eid3676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_eid3684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_eid3692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_eid3700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_eid3708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_eid3716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_eid3724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EVAL_in_eid3732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASC_in_eid3740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_eid3748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_eid3756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_eid3764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_eid3772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_eid3780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_eid3788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATETIME_in_eid3796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_eid3804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINTEGER_in_eid3812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGDECIMAL_in_eid3820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_eid3828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_in_eid3836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_in_eid3844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_in_eid3852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IS_in_eid3860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_eid3868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_eid3876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_eid3884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STREAM_in_eid3892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROUGH_in_eid3900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STORE_in_eid3908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAPREDUCE_in_eid3916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHIP_in_eid3924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CACHE_in_eid3932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INPUT_in_eid3940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTPUT_in_eid3948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDERROR_in_eid3956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDIN_in_eid3964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDOUT_in_eid3972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LIMIT_in_eid3980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SAMPLE_in_eid3988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_in_eid3996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RIGHT_in_eid4004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FULL_in_eid4012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_eid4020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOBAG_in_eid4028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOMAP_in_eid4036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOTUPLE_in_eid4044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSERT_in_eid4052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_eq_in_rel_op4066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_ne_in_rel_op4074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gt_in_rel_op4082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gte_in_rel_op4090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lt_in_rel_op4098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lte_in_rel_op4106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_rel_op4114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_synpred101_AliasMasker1693 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_synpred101_AliasMasker1695 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0082998020L});
    public static final BitSet FOLLOW_expr_in_synpred101_AliasMasker1697 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_synpred105_AliasMasker1757 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_synpred105_AliasMasker1759 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0082998020L});
    public static final BitSet FOLLOW_expr_in_synpred105_AliasMasker1761 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_synpred106_AliasMasker1771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CAST_EXPR_in_synpred109_AliasMasker1803 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_synpred109_AliasMasker1805 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0082998020L});
    public static final BitSet FOLLOW_expr_in_synpred109_AliasMasker1807 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INTEGER_in_synpred132_AliasMasker2184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGINTEGER_in_synpred133_AliasMasker2188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_synpred134_AliasMasker2218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_synpred160_AliasMasker2542 = new BitSet(new long[]{0x0010000000000000L,0x0000080000000010L});
    public static final BitSet FOLLOW_set_in_synpred160_AliasMasker2544 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_OUTER_in_synpred160_AliasMasker2597 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_join_item_in_synpred160_AliasMasker2600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_synpred178_AliasMasker3017 = new BitSet(new long[]{0x0000000000000002L});

}