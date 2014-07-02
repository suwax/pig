// $ANTLR 3.4 /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g 2014-07-02 16:22:13

package org.apache.pig.parser;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pig.impl.PigContext;
import org.apache.pig.impl.builtin.GFAny;
import org.apache.pig.impl.logicalLayer.FrontendException;
import org.apache.pig.impl.streaming.StreamingCommand;
import org.apache.pig.impl.streaming.StreamingCommand.HandleSpec;
import org.apache.pig.impl.util.MultiMap;
import org.apache.pig.impl.util.NumValCarrier;
import org.apache.pig.impl.plan.PlanValidationException;
import org.apache.pig.newplan.Operator;
import org.apache.pig.newplan.logical.expression.AddExpression;
import org.apache.pig.newplan.logical.expression.AndExpression;
import org.apache.pig.newplan.logical.expression.BinCondExpression;
import org.apache.pig.newplan.logical.expression.CastExpression;
import org.apache.pig.newplan.logical.expression.ConstantExpression;
import org.apache.pig.newplan.logical.expression.DereferenceExpression;
import org.apache.pig.newplan.logical.expression.DivideExpression;
import org.apache.pig.newplan.logical.expression.EqualExpression;
import org.apache.pig.newplan.logical.expression.GreaterThanEqualExpression;
import org.apache.pig.newplan.logical.expression.GreaterThanExpression;
import org.apache.pig.newplan.logical.expression.IsNullExpression;
import org.apache.pig.newplan.logical.expression.LessThanEqualExpression;
import org.apache.pig.newplan.logical.expression.LessThanExpression;
import org.apache.pig.newplan.logical.expression.LogicalExpression;
import org.apache.pig.newplan.logical.expression.LogicalExpressionPlan;
import org.apache.pig.newplan.logical.expression.MapLookupExpression;
import org.apache.pig.newplan.logical.expression.ModExpression;
import org.apache.pig.newplan.logical.expression.MultiplyExpression;
import org.apache.pig.newplan.logical.expression.NegativeExpression;
import org.apache.pig.newplan.logical.expression.NotEqualExpression;
import org.apache.pig.newplan.logical.expression.NotExpression;
import org.apache.pig.newplan.logical.expression.OrExpression;
import org.apache.pig.newplan.logical.expression.ProjectExpression;
import org.apache.pig.newplan.logical.expression.RegexExpression;
import org.apache.pig.newplan.logical.expression.ScalarExpression;
import org.apache.pig.newplan.logical.expression.SubtractExpression;
import org.apache.pig.newplan.logical.expression.UserFuncExpression;
import org.apache.pig.newplan.logical.relational.LOCogroup;
import org.apache.pig.newplan.logical.relational.LOCube;
import org.apache.pig.newplan.logical.relational.LOFilter;
import org.apache.pig.newplan.logical.relational.LOForEach;
import org.apache.pig.newplan.logical.relational.LOGenerate;
import org.apache.pig.newplan.logical.relational.LOLimit;
import org.apache.pig.newplan.logical.relational.LOJoin;
import org.apache.pig.newplan.logical.relational.LOSort;
import org.apache.pig.newplan.logical.relational.LORank;
import org.apache.pig.newplan.logical.relational.LOSplitOutput;
import org.apache.pig.newplan.logical.relational.LogicalPlan;
import org.apache.pig.newplan.logical.relational.LogicalRelationalOperator;
import org.apache.pig.newplan.logical.relational.LogicalSchema;
import org.apache.pig.newplan.logical.relational.LogicalSchema.LogicalFieldSchema;
import org.apache.pig.newplan.logical.relational.LOCogroup.GROUPTYPE;
import org.apache.pig.newplan.logical.relational.LOJoin.JOINTYPE;
import org.apache.pig.FuncSpec;
import org.apache.pig.builtin.PigStreaming;
import org.apache.pig.data.DataBag;
import org.apache.pig.data.DataType;
import org.apache.pig.data.Tuple;
import java.util.Arrays;
import java.util.Collections;
import java.math.BigInteger;
import java.math.BigDecimal;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


/**
 * Grammar file for Pig tree parser (for schema alias validation).
 *
 * NOTE: THIS FILE IS BASED ON QueryParser.g, SO IF YOU CHANGE THAT FILE, YOU WILL
 *       PROBABLY NEED TO MAKE CORRESPONDING CHANGES TO THIS FILE AS WELL.
 */
@SuppressWarnings({"all", "warnings", "unchecked"})
public class LogicalPlanGenerator extends TreeParser {
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

    protected static class GScope_scope {
        LogicalRelationalOperator currentOp;
    }
    protected Stack GScope_stack = new Stack();



    public LogicalPlanGenerator(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public LogicalPlanGenerator(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return LogicalPlanGenerator.tokenNames; }
    public String getGrammarFileName() { return "/home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g"; }


    private static Log log = LogFactory.getLog( LogicalPlanGenerator.class );

    private LogicalPlanBuilder builder = null;

    private boolean inForeachPlan = false;

    private boolean inNestedCommand = false;

    public LogicalPlan getLogicalPlan() {
        return builder.getPlan();
    }

    public Map<String, Operator> getOperators() {
        return builder.getOperators();
    }

    public String getLastRel() {
        return builder.getLastRel();
    }

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

    public LogicalPlanGenerator(TreeNodeStream input, LogicalPlanBuilder builder) {
        this(input, new RecognizerSharedState());
        this.builder = builder;
    }

    public LogicalPlanGenerator(TreeNodeStream input, PigContext pigContext, String scope,
        Map<String, String> fileNameMap) {
        this( input );
        builder = new LogicalPlanBuilder( pigContext, scope, fileNameMap, input );
    }



    public static class query_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "query"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:159:1: query : ^( QUERY ( statement )* ) ;
    public final LogicalPlanGenerator.query_return query() throws RecognitionException {
        LogicalPlanGenerator.query_return retval = new LogicalPlanGenerator.query_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUERY1=null;
        LogicalPlanGenerator.statement_return statement2 =null;


        CommonTree QUERY1_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:159:7: ( ^( QUERY ( statement )* ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:159:9: ^( QUERY ( statement )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            QUERY1=(CommonTree)match(input,QUERY,FOLLOW_QUERY_in_query87); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUERY1_tree = (CommonTree)adaptor.dupNode(QUERY1);


            root_1 = (CommonTree)adaptor.becomeRoot(QUERY1_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:159:18: ( statement )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==ASSERT||LA1_0==REGISTER||LA1_0==SPLIT||LA1_0==REALIAS||LA1_0==STATEMENT) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:159:18: statement
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_statement_in_query89);
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


    protected static class statement_scope {
        String alias;
        Integer parallel;
        String inputAlias;
        int inputIndex;
    }
    protected Stack statement_stack = new Stack();


    public static class statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "statement"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:162:1: statement : ( general_statement | split_statement | realias_statement | assert_statement | register_statement );
    public final LogicalPlanGenerator.statement_return statement() throws RecognitionException {
        statement_stack.push(new statement_scope());
        LogicalPlanGenerator.statement_return retval = new LogicalPlanGenerator.statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.general_statement_return general_statement3 =null;

        LogicalPlanGenerator.split_statement_return split_statement4 =null;

        LogicalPlanGenerator.realias_statement_return realias_statement5 =null;

        LogicalPlanGenerator.assert_statement_return assert_statement6 =null;

        LogicalPlanGenerator.register_statement_return register_statement7 =null;




            ((statement_scope)statement_stack.peek()).inputIndex = 0;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:173:2: ( general_statement | split_statement | realias_statement | assert_statement | register_statement )
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
            case ASSERT:
                {
                alt2=4;
                }
                break;
            case REGISTER:
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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:173:4: general_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_general_statement_in_statement111);
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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:174:4: split_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_statement_in_statement116);
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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:175:4: realias_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_realias_statement_in_statement121);
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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:176:4: assert_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_assert_statement_in_statement126);
                    assert_statement6=assert_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, assert_statement6.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:177:4: register_statement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_register_statement_in_statement131);
                    register_statement7=register_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, register_statement7.getTree());


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
            statement_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "statement"


    public static class split_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_statement"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:180:1: split_statement : split_clause ;
    public final LogicalPlanGenerator.split_statement_return split_statement() throws RecognitionException {
        LogicalPlanGenerator.split_statement_return retval = new LogicalPlanGenerator.split_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.split_clause_return split_clause8 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:180:17: ( split_clause )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:180:19: split_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_split_clause_in_split_statement140);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:183:1: realias_statement : realias_clause ;
    public final LogicalPlanGenerator.realias_statement_return realias_statement() throws RecognitionException {
        LogicalPlanGenerator.realias_statement_return retval = new LogicalPlanGenerator.realias_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.realias_clause_return realias_clause9 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:183:19: ( realias_clause )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:183:21: realias_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_realias_clause_in_realias_statement149);
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


    public static class assert_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assert_statement"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:186:1: assert_statement : assert_clause ;
    public final LogicalPlanGenerator.assert_statement_return assert_statement() throws RecognitionException {
        LogicalPlanGenerator.assert_statement_return retval = new LogicalPlanGenerator.assert_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.assert_clause_return assert_clause10 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:186:18: ( assert_clause )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:186:20: assert_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_assert_clause_in_assert_statement158);
            assert_clause10=assert_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, assert_clause10.getTree());


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


    public static class register_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "register_statement"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:189:1: register_statement : ^( REGISTER QUOTEDSTRING ( USING IDENTIFIER AS IDENTIFIER )? ) ;
    public final LogicalPlanGenerator.register_statement_return register_statement() throws RecognitionException {
        LogicalPlanGenerator.register_statement_return retval = new LogicalPlanGenerator.register_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REGISTER11=null;
        CommonTree QUOTEDSTRING12=null;
        CommonTree USING13=null;
        CommonTree IDENTIFIER14=null;
        CommonTree AS15=null;
        CommonTree IDENTIFIER16=null;

        CommonTree REGISTER11_tree=null;
        CommonTree QUOTEDSTRING12_tree=null;
        CommonTree USING13_tree=null;
        CommonTree IDENTIFIER14_tree=null;
        CommonTree AS15_tree=null;
        CommonTree IDENTIFIER16_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:190:3: ( ^( REGISTER QUOTEDSTRING ( USING IDENTIFIER AS IDENTIFIER )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:190:3: ^( REGISTER QUOTEDSTRING ( USING IDENTIFIER AS IDENTIFIER )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            REGISTER11=(CommonTree)match(input,REGISTER,FOLLOW_REGISTER_in_register_statement169); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REGISTER11_tree = (CommonTree)adaptor.dupNode(REGISTER11);


            root_1 = (CommonTree)adaptor.becomeRoot(REGISTER11_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING12=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_register_statement171); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING12_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING12);


            adaptor.addChild(root_1, QUOTEDSTRING12_tree);
            }


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:190:28: ( USING IDENTIFIER AS IDENTIFIER )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==USING) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:190:29: USING IDENTIFIER AS IDENTIFIER
                    {
                    _last = (CommonTree)input.LT(1);
                    USING13=(CommonTree)match(input,USING,FOLLOW_USING_in_register_statement174); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    USING13_tree = (CommonTree)adaptor.dupNode(USING13);


                    adaptor.addChild(root_1, USING13_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER14=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_register_statement176); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER14_tree = (CommonTree)adaptor.dupNode(IDENTIFIER14);


                    adaptor.addChild(root_1, IDENTIFIER14_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    AS15=(CommonTree)match(input,AS,FOLLOW_AS_in_register_statement178); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AS15_tree = (CommonTree)adaptor.dupNode(AS15);


                    adaptor.addChild(root_1, AS15_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER16=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_register_statement180); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER16_tree = (CommonTree)adaptor.dupNode(IDENTIFIER16);


                    adaptor.addChild(root_1, IDENTIFIER16_tree);
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
                // registers are handled by QueryParserDriver and are not actually part of the logical plan
                // so we just ignore them here
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


    public static class general_statement_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "general_statement"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:197:1: general_statement : ^( STATEMENT ( alias )? oa= op_clause ( parallel_clause )? ) ;
    public final LogicalPlanGenerator.general_statement_return general_statement() throws RecognitionException {
        LogicalPlanGenerator.general_statement_return retval = new LogicalPlanGenerator.general_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STATEMENT17=null;
        LogicalPlanGenerator.op_clause_return oa =null;

        LogicalPlanGenerator.alias_return alias18 =null;

        LogicalPlanGenerator.parallel_clause_return parallel_clause19 =null;


        CommonTree STATEMENT17_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:198:3: ( ^( STATEMENT ( alias )? oa= op_clause ( parallel_clause )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:198:3: ^( STATEMENT ( alias )? oa= op_clause ( parallel_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STATEMENT17=(CommonTree)match(input,STATEMENT,FOLLOW_STATEMENT_in_general_statement199); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STATEMENT17_tree = (CommonTree)adaptor.dupNode(STATEMENT17);


            root_1 = (CommonTree)adaptor.becomeRoot(STATEMENT17_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:198:16: ( alias )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==IDENTIFIER) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:198:18: alias
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_general_statement203);
                    alias18=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, alias18.getTree());


                    if ( state.backtracking==0 ) { ((statement_scope)statement_stack.peek()).alias = (alias18!=null?alias18.name:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_op_clause_in_general_statement214);
            oa=op_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, oa.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:198:79: ( parallel_clause )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==PARALLEL) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:198:79: parallel_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_parallel_clause_in_general_statement216);
                    parallel_clause19=parallel_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, parallel_clause19.getTree());


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
                  Operator op = builder.lookupOperator( (oa!=null?oa.alias:null) );
                  builder.setParallel( (LogicalRelationalOperator)op, ((statement_scope)statement_stack.peek()).parallel );
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:205:1: realias_clause : ^( REALIAS alias IDENTIFIER ) ;
    public final LogicalPlanGenerator.realias_clause_return realias_clause() throws RecognitionException {
        LogicalPlanGenerator.realias_clause_return retval = new LogicalPlanGenerator.realias_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree REALIAS20=null;
        CommonTree IDENTIFIER22=null;
        LogicalPlanGenerator.alias_return alias21 =null;


        CommonTree REALIAS20_tree=null;
        CommonTree IDENTIFIER22_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:206:3: ( ^( REALIAS alias IDENTIFIER ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:206:3: ^( REALIAS alias IDENTIFIER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            REALIAS20=(CommonTree)match(input,REALIAS,FOLLOW_REALIAS_in_realias_clause233); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REALIAS20_tree = (CommonTree)adaptor.dupNode(REALIAS20);


            root_1 = (CommonTree)adaptor.becomeRoot(REALIAS20_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_realias_clause235);
            alias21=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias21.getTree());


            _last = (CommonTree)input.LT(1);
            IDENTIFIER22=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_realias_clause237); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER22_tree = (CommonTree)adaptor.dupNode(IDENTIFIER22);


            adaptor.addChild(root_1, IDENTIFIER22_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
            	    Operator op = builder.lookupOperator( (IDENTIFIER22!=null?IDENTIFIER22.getText():null) );
            	    if (op==null) {
            	        throw new UndefinedAliasException(input,
            	            new SourceLocation( (PigParserNode)IDENTIFIER22 ), (IDENTIFIER22!=null?IDENTIFIER22.getText():null));
            	    }
            	    builder.putOperator( (alias21!=null?alias21.name:null), (LogicalRelationalOperator)op );
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:217:1: parallel_clause : ^( PARALLEL INTEGER ) ;
    public final LogicalPlanGenerator.parallel_clause_return parallel_clause() throws RecognitionException {
        LogicalPlanGenerator.parallel_clause_return retval = new LogicalPlanGenerator.parallel_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARALLEL23=null;
        CommonTree INTEGER24=null;

        CommonTree PARALLEL23_tree=null;
        CommonTree INTEGER24_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:218:2: ( ^( PARALLEL INTEGER ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:218:4: ^( PARALLEL INTEGER )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARALLEL23=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_parallel_clause256); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARALLEL23_tree = (CommonTree)adaptor.dupNode(PARALLEL23);


            root_1 = (CommonTree)adaptor.becomeRoot(PARALLEL23_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            INTEGER24=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_parallel_clause258); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INTEGER24_tree = (CommonTree)adaptor.dupNode(INTEGER24);


            adaptor.addChild(root_1, INTEGER24_tree);
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   ((statement_scope)statement_stack.peek()).parallel = Integer.parseInt( (INTEGER24!=null?INTEGER24.getText():null) );
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
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alias"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:224:1: alias returns [String name] : IDENTIFIER ;
    public final LogicalPlanGenerator.alias_return alias() throws RecognitionException {
        LogicalPlanGenerator.alias_return retval = new LogicalPlanGenerator.alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IDENTIFIER25=null;

        CommonTree IDENTIFIER25_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:224:27: ( IDENTIFIER )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:224:29: IDENTIFIER
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            IDENTIFIER25=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias276); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER25_tree = (CommonTree)adaptor.dupNode(IDENTIFIER25);


            adaptor.addChild(root_0, IDENTIFIER25_tree);
            }


            if ( state.backtracking==0 ) { retval.name = (IDENTIFIER25!=null?IDENTIFIER25.getText():null); }

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
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "op_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:227:1: op_clause returns [String alias] : ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | foreach_clause | cube_clause | assert_clause );
    public final LogicalPlanGenerator.op_clause_return op_clause() throws RecognitionException {
        LogicalPlanGenerator.op_clause_return retval = new LogicalPlanGenerator.op_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.define_clause_return define_clause26 =null;

        LogicalPlanGenerator.load_clause_return load_clause27 =null;

        LogicalPlanGenerator.group_clause_return group_clause28 =null;

        LogicalPlanGenerator.store_clause_return store_clause29 =null;

        LogicalPlanGenerator.filter_clause_return filter_clause30 =null;

        LogicalPlanGenerator.distinct_clause_return distinct_clause31 =null;

        LogicalPlanGenerator.limit_clause_return limit_clause32 =null;

        LogicalPlanGenerator.sample_clause_return sample_clause33 =null;

        LogicalPlanGenerator.order_clause_return order_clause34 =null;

        LogicalPlanGenerator.rank_clause_return rank_clause35 =null;

        LogicalPlanGenerator.cross_clause_return cross_clause36 =null;

        LogicalPlanGenerator.join_clause_return join_clause37 =null;

        LogicalPlanGenerator.union_clause_return union_clause38 =null;

        LogicalPlanGenerator.stream_clause_return stream_clause39 =null;

        LogicalPlanGenerator.mr_clause_return mr_clause40 =null;

        LogicalPlanGenerator.foreach_clause_return foreach_clause41 =null;

        LogicalPlanGenerator.cube_clause_return cube_clause42 =null;

        LogicalPlanGenerator.assert_clause_return assert_clause43 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:227:33: ( define_clause | load_clause | group_clause | store_clause | filter_clause | distinct_clause | limit_clause | sample_clause | order_clause | rank_clause | cross_clause | join_clause | union_clause | stream_clause | mr_clause | foreach_clause | cube_clause | assert_clause )
            int alt6=18;
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
            case FOREACH:
                {
                alt6=16;
                }
                break;
            case CUBE:
                {
                alt6=17;
                }
                break;
            case ASSERT:
                {
                alt6=18;
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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:228:13: define_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_define_clause_in_op_clause302);
                    define_clause26=define_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, define_clause26.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:229:13: load_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_load_clause_in_op_clause316);
                    load_clause27=load_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, load_clause27.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (load_clause27!=null?load_clause27.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:230:13: group_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_group_clause_in_op_clause332);
                    group_clause28=group_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, group_clause28.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (group_clause28!=null?group_clause28.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:231:13: store_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_store_clause_in_op_clause348);
                    store_clause29=store_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, store_clause29.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (store_clause29!=null?store_clause29.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:232:13: filter_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_filter_clause_in_op_clause364);
                    filter_clause30=filter_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, filter_clause30.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (filter_clause30!=null?filter_clause30.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:233:13: distinct_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_distinct_clause_in_op_clause380);
                    distinct_clause31=distinct_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, distinct_clause31.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (distinct_clause31!=null?distinct_clause31.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:234:13: limit_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_limit_clause_in_op_clause396);
                    limit_clause32=limit_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, limit_clause32.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (limit_clause32!=null?limit_clause32.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:235:13: sample_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_sample_clause_in_op_clause412);
                    sample_clause33=sample_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, sample_clause33.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (sample_clause33!=null?sample_clause33.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:236:13: order_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_order_clause_in_op_clause428);
                    order_clause34=order_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, order_clause34.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (order_clause34!=null?order_clause34.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:237:13: rank_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_clause_in_op_clause444);
                    rank_clause35=rank_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rank_clause35.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (rank_clause35!=null?rank_clause35.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:238:13: cross_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cross_clause_in_op_clause460);
                    cross_clause36=cross_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cross_clause36.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (cross_clause36!=null?cross_clause36.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:239:13: join_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_clause_in_op_clause476);
                    join_clause37=join_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_clause37.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (join_clause37!=null?join_clause37.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:240:13: union_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_union_clause_in_op_clause492);
                    union_clause38=union_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, union_clause38.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (union_clause38!=null?union_clause38.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:241:13: stream_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_stream_clause_in_op_clause508);
                    stream_clause39=stream_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, stream_clause39.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (stream_clause39!=null?stream_clause39.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:242:13: mr_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_mr_clause_in_op_clause524);
                    mr_clause40=mr_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, mr_clause40.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (mr_clause40!=null?mr_clause40.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:243:13: foreach_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_foreach_clause_in_op_clause540);
                    foreach_clause41=foreach_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, foreach_clause41.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (foreach_clause41!=null?foreach_clause41.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:244:13: cube_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cube_clause_in_op_clause556);
                    cube_clause42=cube_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cube_clause42.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (cube_clause42!=null?cube_clause42.alias:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:245:13: assert_clause
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_assert_clause_in_op_clause572);
                    assert_clause43=assert_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, assert_clause43.getTree());


                    if ( state.backtracking==0 ) { retval.alias = (assert_clause43!=null?assert_clause43.alias:null); }

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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:248:1: define_clause : ( ^( DEFINE alias cmd[$alias.name] ) | ^( DEFINE alias func_clause[FunctionType.UNKNOWNFUNC] ) );
    public final LogicalPlanGenerator.define_clause_return define_clause() throws RecognitionException {
        LogicalPlanGenerator.define_clause_return retval = new LogicalPlanGenerator.define_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DEFINE44=null;
        CommonTree DEFINE47=null;
        LogicalPlanGenerator.alias_return alias45 =null;

        LogicalPlanGenerator.cmd_return cmd46 =null;

        LogicalPlanGenerator.alias_return alias48 =null;

        LogicalPlanGenerator.func_clause_return func_clause49 =null;


        CommonTree DEFINE44_tree=null;
        CommonTree DEFINE47_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:249:2: ( ^( DEFINE alias cmd[$alias.name] ) | ^( DEFINE alias func_clause[FunctionType.UNKNOWNFUNC] ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==DEFINE) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==DOWN) ) {
                    int LA7_2 = input.LA(3);

                    if ( (LA7_2==IDENTIFIER) ) {
                        int LA7_3 = input.LA(4);

                        if ( (LA7_3==EXECCOMMAND) ) {
                            alt7=1;
                        }
                        else if ( (LA7_3==FUNC||LA7_3==FUNC_REF) ) {
                            alt7=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 7, 3, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }
            switch (alt7) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:249:4: ^( DEFINE alias cmd[$alias.name] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    DEFINE44=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_define_clause586); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINE44_tree = (CommonTree)adaptor.dupNode(DEFINE44);


                    root_1 = (CommonTree)adaptor.becomeRoot(DEFINE44_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_define_clause588);
                    alias45=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, alias45.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cmd_in_define_clause590);
                    cmd46=cmd((alias45!=null?alias45.name:null));

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, cmd46.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           builder.defineCommand( (alias45!=null?alias45.name:null), (cmd46!=null?cmd46.command:null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:253:4: ^( DEFINE alias func_clause[FunctionType.UNKNOWNFUNC] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    DEFINE47=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_define_clause605); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINE47_tree = (CommonTree)adaptor.dupNode(DEFINE47);


                    root_1 = (CommonTree)adaptor.becomeRoot(DEFINE47_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_define_clause607);
                    alias48=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, alias48.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_define_clause609);
                    func_clause49=func_clause(FunctionType.UNKNOWNFUNC);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause49.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           builder.defineFunction( (alias48!=null?alias48.name:null), (func_clause49!=null?func_clause49.funcSpec:null) );
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
    // $ANTLR end "define_clause"


    public static class cmd_return extends TreeRuleReturnScope {
        public StreamingCommand command;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cmd"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:259:1: cmd[String alias] returns [StreamingCommand command] : ^( EXECCOMMAND ( ship_clause[shipPaths] | cache_clause[cachePaths] | input_clause | output_clause | error_clause )* ) ;
    public final LogicalPlanGenerator.cmd_return cmd(String alias) throws RecognitionException {
        LogicalPlanGenerator.cmd_return retval = new LogicalPlanGenerator.cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree EXECCOMMAND50=null;
        LogicalPlanGenerator.ship_clause_return ship_clause51 =null;

        LogicalPlanGenerator.cache_clause_return cache_clause52 =null;

        LogicalPlanGenerator.input_clause_return input_clause53 =null;

        LogicalPlanGenerator.output_clause_return output_clause54 =null;

        LogicalPlanGenerator.error_clause_return error_clause55 =null;


        CommonTree EXECCOMMAND50_tree=null;


            List<String> shipPaths = new ArrayList<String>();
            List<String> cachePaths = new ArrayList<String>();
            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:265:2: ( ^( EXECCOMMAND ( ship_clause[shipPaths] | cache_clause[cachePaths] | input_clause | output_clause | error_clause )* ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:265:4: ^( EXECCOMMAND ( ship_clause[shipPaths] | cache_clause[cachePaths] | input_clause | output_clause | error_clause )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            EXECCOMMAND50=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_cmd638); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EXECCOMMAND50_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND50);


            root_1 = (CommonTree)adaptor.becomeRoot(EXECCOMMAND50_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:265:19: ( ship_clause[shipPaths] | cache_clause[cachePaths] | input_clause | output_clause | error_clause )*
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
                	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:265:21: ship_clause[shipPaths]
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_ship_clause_in_cmd642);
                	    ship_clause51=ship_clause(shipPaths);

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, ship_clause51.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 2 :
                	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:265:46: cache_clause[cachePaths]
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_cache_clause_in_cmd647);
                	    cache_clause52=cache_clause(cachePaths);

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, cache_clause52.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 3 :
                	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:265:73: input_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_input_clause_in_cmd652);
                	    input_clause53=input_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, input_clause53.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 4 :
                	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:265:88: output_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_output_clause_in_cmd656);
                	    output_clause54=output_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, output_clause54.getTree());


                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;
                	case 5 :
                	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:265:104: error_clause
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_error_clause_in_cmd660);
                	    error_clause55=error_clause();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, error_clause55.getTree());


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
                   retval.command = builder.buildCommand( loc, builder.unquote( (EXECCOMMAND50!=null?EXECCOMMAND50.getText():null) ), shipPaths,
                       cachePaths, (input_clause53!=null?input_clause53.inputHandleSpecs:null), (output_clause54!=null?output_clause54.outputHandleSpecs:null),
                       (error_clause55!=null?error_clause55.dir:null), (error_clause55!=null?error_clause55.limit:null) );
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:273:1: ship_clause[List<String> paths] : ^( SHIP ( path_list[$paths] )? ) ;
    public final LogicalPlanGenerator.ship_clause_return ship_clause(List<String> paths) throws RecognitionException {
        LogicalPlanGenerator.ship_clause_return retval = new LogicalPlanGenerator.ship_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SHIP56=null;
        LogicalPlanGenerator.path_list_return path_list57 =null;


        CommonTree SHIP56_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:274:2: ( ^( SHIP ( path_list[$paths] )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:274:4: ^( SHIP ( path_list[$paths] )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SHIP56=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_ship_clause683); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SHIP56_tree = (CommonTree)adaptor.dupNode(SHIP56);


            root_1 = (CommonTree)adaptor.becomeRoot(SHIP56_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:274:12: ( path_list[$paths] )?
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==QUOTEDSTRING) ) {
                    alt9=1;
                }
                switch (alt9) {
                    case 1 :
                        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:274:12: path_list[$paths]
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_path_list_in_ship_clause685);
                        path_list57=path_list(paths);

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, path_list57.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:277:1: path_list[List<String> paths] : ( QUOTEDSTRING )+ ;
    public final LogicalPlanGenerator.path_list_return path_list(List<String> paths) throws RecognitionException {
        LogicalPlanGenerator.path_list_return retval = new LogicalPlanGenerator.path_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING58=null;

        CommonTree QUOTEDSTRING58_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:278:2: ( ( QUOTEDSTRING )+ )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:278:4: ( QUOTEDSTRING )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:278:4: ( QUOTEDSTRING )+
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
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:278:6: QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    QUOTEDSTRING58=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_path_list702); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    QUOTEDSTRING58_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING58);


            	    adaptor.addChild(root_0, QUOTEDSTRING58_tree);
            	    }


            	    if ( state.backtracking==0 ) { paths.add( builder.unquote( (QUOTEDSTRING58!=null?QUOTEDSTRING58.getText():null) ) ); }

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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:281:1: cache_clause[List<String> paths] : ^( CACHE path_list[$paths] ) ;
    public final LogicalPlanGenerator.cache_clause_return cache_clause(List<String> paths) throws RecognitionException {
        LogicalPlanGenerator.cache_clause_return retval = new LogicalPlanGenerator.cache_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CACHE59=null;
        LogicalPlanGenerator.path_list_return path_list60 =null;


        CommonTree CACHE59_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:282:2: ( ^( CACHE path_list[$paths] ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:282:4: ^( CACHE path_list[$paths] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CACHE59=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_cache_clause720); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CACHE59_tree = (CommonTree)adaptor.dupNode(CACHE59);


            root_1 = (CommonTree)adaptor.becomeRoot(CACHE59_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_path_list_in_cache_clause722);
            path_list60=path_list(paths);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, path_list60.getTree());


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
        public List<HandleSpec> inputHandleSpecs;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "input_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:285:1: input_clause returns [List<HandleSpec> inputHandleSpecs] : ^( INPUT ( stream_cmd[true] )+ ) ;
    public final LogicalPlanGenerator.input_clause_return input_clause() throws RecognitionException {
        LogicalPlanGenerator.input_clause_return retval = new LogicalPlanGenerator.input_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree INPUT61=null;
        LogicalPlanGenerator.stream_cmd_return stream_cmd62 =null;


        CommonTree INPUT61_tree=null;


            retval.inputHandleSpecs = new ArrayList<HandleSpec>();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:289:2: ( ^( INPUT ( stream_cmd[true] )+ ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:289:4: ^( INPUT ( stream_cmd[true] )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            INPUT61=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_input_clause745); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INPUT61_tree = (CommonTree)adaptor.dupNode(INPUT61);


            root_1 = (CommonTree)adaptor.becomeRoot(INPUT61_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:289:13: ( stream_cmd[true] )+
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
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:289:15: stream_cmd[true]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_input_clause749);
            	    stream_cmd62=stream_cmd(true);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd62.getTree());


            	    if ( state.backtracking==0 ) { retval.inputHandleSpecs.add( (stream_cmd62!=null?stream_cmd62.handleSpec:null) ); }

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
        public HandleSpec handleSpec;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stream_cmd"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:292:1: stream_cmd[boolean in] returns [HandleSpec handleSpec] : ( ^( STDIN ( func_clause[ft] )? ) | ^( STDOUT ( func_clause[ft] )? ) | ^( QUOTEDSTRING ( func_clause[ft] )? ) );
    public final LogicalPlanGenerator.stream_cmd_return stream_cmd(boolean in) throws RecognitionException {
        LogicalPlanGenerator.stream_cmd_return retval = new LogicalPlanGenerator.stream_cmd_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDIN63=null;
        CommonTree STDOUT65=null;
        CommonTree QUOTEDSTRING67=null;
        LogicalPlanGenerator.func_clause_return func_clause64 =null;

        LogicalPlanGenerator.func_clause_return func_clause66 =null;

        LogicalPlanGenerator.func_clause_return func_clause68 =null;


        CommonTree STDIN63_tree=null;
        CommonTree STDOUT65_tree=null;
        CommonTree QUOTEDSTRING67_tree=null;


            String handleName = null;
            FuncSpec fs = null;
            String deserializer = PigStreaming.class.getName() + "()";
            byte ft = in ? FunctionType.PIGTOSTREAMFUNC : FunctionType.STREAMTOPIGFUNC;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:304:2: ( ^( STDIN ( func_clause[ft] )? ) | ^( STDOUT ( func_clause[ft] )? ) | ^( QUOTEDSTRING ( func_clause[ft] )? ) )
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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:304:4: ^( STDIN ( func_clause[ft] )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDIN63=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_stream_cmd783); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN63_tree = (CommonTree)adaptor.dupNode(STDIN63);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDIN63_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { handleName = "stdin"; }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:305:7: ( func_clause[ft] )?
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==FUNC||LA12_0==FUNC_REF) ) {
                            alt12=1;
                        }
                        switch (alt12) {
                            case 1 :
                                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:305:9: func_clause[ft]
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd795);
                                func_clause64=func_clause(ft);

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause64.getTree());


                                if ( state.backtracking==0 ) { fs = (func_clause64!=null?func_clause64.funcSpec:null); }

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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:306:4: ^( STDOUT ( func_clause[ft] )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STDOUT65=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_stream_cmd810); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT65_tree = (CommonTree)adaptor.dupNode(STDOUT65);


                    root_1 = (CommonTree)adaptor.becomeRoot(STDOUT65_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { handleName = "stdout"; }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:307:7: ( func_clause[ft] )?
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==FUNC||LA13_0==FUNC_REF) ) {
                            alt13=1;
                        }
                        switch (alt13) {
                            case 1 :
                                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:307:9: func_clause[ft]
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd822);
                                func_clause66=func_clause(ft);

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause66.getTree());


                                if ( state.backtracking==0 ) { fs = (func_clause66!=null?func_clause66.funcSpec:null); }

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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:308:4: ^( QUOTEDSTRING ( func_clause[ft] )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING67=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_stream_cmd837); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING67_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING67);


                    root_1 = (CommonTree)adaptor.becomeRoot(QUOTEDSTRING67_tree, root_1);
                    }


                    if ( state.backtracking==0 ) { handleName = builder.unquote( (QUOTEDSTRING67!=null?QUOTEDSTRING67.getText():null) ); }

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return retval;
                        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:309:7: ( func_clause[ft] )?
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==FUNC||LA14_0==FUNC_REF) ) {
                            alt14=1;
                        }
                        switch (alt14) {
                            case 1 :
                                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:309:9: func_clause[ft]
                                {
                                _last = (CommonTree)input.LT(1);
                                pushFollow(FOLLOW_func_clause_in_stream_cmd849);
                                func_clause68=func_clause(ft);

                                state._fsp--;
                                if (state.failed) return retval;
                                if ( state.backtracking==0 ) 
                                adaptor.addChild(root_1, func_clause68.getTree());


                                if ( state.backtracking==0 ) { fs = (func_clause68!=null?func_clause68.funcSpec:null); }

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

            if ( state.backtracking==0 ) {
                if( fs != null )
                    deserializer =  fs.toString();
                retval.handleSpec = new HandleSpec( handleName, deserializer );
            }
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
        public List<HandleSpec> outputHandleSpecs;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "output_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:312:1: output_clause returns [List<HandleSpec> outputHandleSpecs] : ^( OUTPUT ( stream_cmd[false] )+ ) ;
    public final LogicalPlanGenerator.output_clause_return output_clause() throws RecognitionException {
        LogicalPlanGenerator.output_clause_return retval = new LogicalPlanGenerator.output_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OUTPUT69=null;
        LogicalPlanGenerator.stream_cmd_return stream_cmd70 =null;


        CommonTree OUTPUT69_tree=null;


            retval.outputHandleSpecs = new ArrayList<HandleSpec>();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:316:2: ( ^( OUTPUT ( stream_cmd[false] )+ ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:316:4: ^( OUTPUT ( stream_cmd[false] )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OUTPUT69=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_output_clause877); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OUTPUT69_tree = (CommonTree)adaptor.dupNode(OUTPUT69);


            root_1 = (CommonTree)adaptor.becomeRoot(OUTPUT69_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:316:14: ( stream_cmd[false] )+
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
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:316:16: stream_cmd[false]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_stream_cmd_in_output_clause881);
            	    stream_cmd70=stream_cmd(false);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, stream_cmd70.getTree());


            	    if ( state.backtracking==0 ) { retval.outputHandleSpecs.add( (stream_cmd70!=null?stream_cmd70.handleSpec:null) ); }

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
        public String dir;
        public Integer limit;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "error_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:319:1: error_clause returns [String dir, Integer limit] : ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) ;
    public final LogicalPlanGenerator.error_clause_return error_clause() throws RecognitionException {
        LogicalPlanGenerator.error_clause_return retval = new LogicalPlanGenerator.error_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STDERROR71=null;
        CommonTree QUOTEDSTRING72=null;
        CommonTree INTEGER73=null;

        CommonTree STDERROR71_tree=null;
        CommonTree QUOTEDSTRING72_tree=null;
        CommonTree INTEGER73_tree=null;


            retval.limit = StreamingCommand.MAX_TASKS;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:323:2: ( ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:323:4: ^( STDERROR ( QUOTEDSTRING ( INTEGER )? )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STDERROR71=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_error_clause909); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STDERROR71_tree = (CommonTree)adaptor.dupNode(STDERROR71);


            root_1 = (CommonTree)adaptor.becomeRoot(STDERROR71_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:324:7: ( QUOTEDSTRING ( INTEGER )? )?
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==QUOTEDSTRING) ) {
                    alt18=1;
                }
                switch (alt18) {
                    case 1 :
                        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:324:9: QUOTEDSTRING ( INTEGER )?
                        {
                        _last = (CommonTree)input.LT(1);
                        QUOTEDSTRING72=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_error_clause919); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        QUOTEDSTRING72_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING72);


                        adaptor.addChild(root_1, QUOTEDSTRING72_tree);
                        }


                        if ( state.backtracking==0 ) {
                                    retval.dir = builder.unquote( (QUOTEDSTRING72!=null?QUOTEDSTRING72.getText():null) );
                                }

                        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:328:9: ( INTEGER )?
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==INTEGER) ) {
                            alt17=1;
                        }
                        switch (alt17) {
                            case 1 :
                                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:328:11: INTEGER
                                {
                                _last = (CommonTree)input.LT(1);
                                INTEGER73=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_error_clause941); if (state.failed) return retval;
                                if ( state.backtracking==0 ) {
                                INTEGER73_tree = (CommonTree)adaptor.dupNode(INTEGER73);


                                adaptor.addChild(root_1, INTEGER73_tree);
                                }


                                if ( state.backtracking==0 ) {
                                              retval.limit = Integer.parseInt( (INTEGER73!=null?INTEGER73.getText():null) );
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
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "load_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:337:1: load_clause returns [String alias] : ^( LOAD filename ( func_clause[FunctionType.LOADFUNC] )? ( as_clause )? ) ;
    public final LogicalPlanGenerator.load_clause_return load_clause() throws RecognitionException {
        LogicalPlanGenerator.load_clause_return retval = new LogicalPlanGenerator.load_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LOAD74=null;
        LogicalPlanGenerator.filename_return filename75 =null;

        LogicalPlanGenerator.func_clause_return func_clause76 =null;

        LogicalPlanGenerator.as_clause_return as_clause77 =null;


        CommonTree LOAD74_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:338:2: ( ^( LOAD filename ( func_clause[FunctionType.LOADFUNC] )? ( as_clause )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:338:4: ^( LOAD filename ( func_clause[FunctionType.LOADFUNC] )? ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LOAD74=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_load_clause994); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LOAD74_tree = (CommonTree)adaptor.dupNode(LOAD74);


            root_1 = (CommonTree)adaptor.becomeRoot(LOAD74_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_load_clause996);
            filename75=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename75.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:338:21: ( func_clause[FunctionType.LOADFUNC] )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==FUNC||LA19_0==FUNC_REF) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:338:21: func_clause[FunctionType.LOADFUNC]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_load_clause998);
                    func_clause76=func_clause(FunctionType.LOADFUNC);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause76.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:338:57: ( as_clause )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==AS) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:338:57: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_load_clause1002);
                    as_clause77=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause77.getTree());


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
                  SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );
                  retval.alias = builder.buildLoadOp( loc, ((statement_scope)statement_stack.peek()).alias,
                      (filename75!=null?filename75.filename:null), (func_clause76!=null?func_clause76.funcSpec:null), (as_clause77!=null?as_clause77.logicalSchema:null)  );
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
        public String filename;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "filename"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:346:1: filename returns [String filename] : QUOTEDSTRING ;
    public final LogicalPlanGenerator.filename_return filename() throws RecognitionException {
        LogicalPlanGenerator.filename_return retval = new LogicalPlanGenerator.filename_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING78=null;

        CommonTree QUOTEDSTRING78_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:347:2: ( QUOTEDSTRING )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:347:4: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING78=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_filename1022); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING78_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING78);


            adaptor.addChild(root_0, QUOTEDSTRING78_tree);
            }


            if ( state.backtracking==0 ) { retval.filename = builder.unquote( (QUOTEDSTRING78!=null?QUOTEDSTRING78.getText():null) ); }

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
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "as_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:350:1: as_clause returns [LogicalSchema logicalSchema] : ^( AS field_def_list ) ;
    public final LogicalPlanGenerator.as_clause_return as_clause() throws RecognitionException {
        LogicalPlanGenerator.as_clause_return retval = new LogicalPlanGenerator.as_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree AS79=null;
        LogicalPlanGenerator.field_def_list_return field_def_list80 =null;


        CommonTree AS79_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:351:2: ( ^( AS field_def_list ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:351:4: ^( AS field_def_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            AS79=(CommonTree)match(input,AS,FOLLOW_AS_in_as_clause1039); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            AS79_tree = (CommonTree)adaptor.dupNode(AS79);


            root_1 = (CommonTree)adaptor.becomeRoot(AS79_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_field_def_list_in_as_clause1041);
            field_def_list80=field_def_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, field_def_list80.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                    LogicalPlanBuilder.setBytearrayForNULLType((field_def_list80!=null?field_def_list80.schema:null));
                    retval.logicalSchema = (field_def_list80!=null?field_def_list80.schema:null);
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
        public LogicalFieldSchema fieldSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field_def"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:358:1: field_def[NumValCarrier nvc] returns [LogicalFieldSchema fieldSchema] : ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF_WITHOUT_IDENTIFIER ( type ) ) );
    public final LogicalPlanGenerator.field_def_return field_def(NumValCarrier nvc) throws RecognitionException {
        LogicalPlanGenerator.field_def_return retval = new LogicalPlanGenerator.field_def_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FIELD_DEF81=null;
        CommonTree IDENTIFIER82=null;
        CommonTree FIELD_DEF_WITHOUT_IDENTIFIER84=null;
        LogicalPlanGenerator.type_return type83 =null;

        LogicalPlanGenerator.type_return type85 =null;


        CommonTree FIELD_DEF81_tree=null;
        CommonTree IDENTIFIER82_tree=null;
        CommonTree FIELD_DEF_WITHOUT_IDENTIFIER84_tree=null;


            byte datatype = DataType.NULL;
            if (nvc==null) {
                nvc =new NumValCarrier();
            }

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:365:2: ( ^( FIELD_DEF IDENTIFIER ( type )? ) | ^( FIELD_DEF_WITHOUT_IDENTIFIER ( type ) ) )
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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:365:4: ^( FIELD_DEF IDENTIFIER ( type )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF81=(CommonTree)match(input,FIELD_DEF,FOLLOW_FIELD_DEF_in_field_def1069); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF81_tree = (CommonTree)adaptor.dupNode(FIELD_DEF81);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF81_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER82=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_field_def1071); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER82_tree = (CommonTree)adaptor.dupNode(IDENTIFIER82);


                    adaptor.addChild(root_1, IDENTIFIER82_tree);
                    }


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:365:28: ( type )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==BIGDECIMAL||LA21_0==BIGINTEGER||LA21_0==BOOLEAN||LA21_0==BYTEARRAY||LA21_0==CHARARRAY||LA21_0==DATETIME||LA21_0==DOUBLE||LA21_0==FLOAT||LA21_0==INT||LA21_0==LONG||LA21_0==BAG_TYPE||LA21_0==MAP_TYPE||LA21_0==TUPLE_TYPE) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:365:30: type
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_type_in_field_def1075);
                            type83=type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, type83.getTree());


                            if ( state.backtracking==0 ) { datatype = (type83!=null?type83.datatype:null);}

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
                               retval.fieldSchema = new LogicalFieldSchema( (IDENTIFIER82!=null?IDENTIFIER82.getText():null), (type83!=null?type83.logicalSchema:null), datatype );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:369:4: ^( FIELD_DEF_WITHOUT_IDENTIFIER ( type ) )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FIELD_DEF_WITHOUT_IDENTIFIER84=(CommonTree)match(input,FIELD_DEF_WITHOUT_IDENTIFIER,FOLLOW_FIELD_DEF_WITHOUT_IDENTIFIER_in_field_def1094); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FIELD_DEF_WITHOUT_IDENTIFIER84_tree = (CommonTree)adaptor.dupNode(FIELD_DEF_WITHOUT_IDENTIFIER84);


                    root_1 = (CommonTree)adaptor.becomeRoot(FIELD_DEF_WITHOUT_IDENTIFIER84_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:369:36: ( type )
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:369:38: type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_in_field_def1098);
                    type85=type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type85.getTree());


                    if ( state.backtracking==0 ) { datatype = (type85!=null?type85.datatype:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                               retval.fieldSchema = new LogicalFieldSchema ( nvc.makeNameFromDataType(datatype) , (type85!=null?type85.logicalSchema:null), datatype );
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
        public LogicalSchema schema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field_def_list"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:375:1: field_def_list returns [LogicalSchema schema] : ( field_def[nvc] )+ ;
    public final LogicalPlanGenerator.field_def_list_return field_def_list() throws RecognitionException {
        LogicalPlanGenerator.field_def_list_return retval = new LogicalPlanGenerator.field_def_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.field_def_return field_def86 =null;




            retval.schema = new LogicalSchema();
            NumValCarrier nvc = new NumValCarrier();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:380:2: ( ( field_def[nvc] )+ )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:380:4: ( field_def[nvc] )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:380:4: ( field_def[nvc] )+
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
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:380:6: field_def[nvc]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_field_def_in_field_def_list1129);
            	    field_def86=field_def(nvc);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, field_def86.getTree());


            	    if ( state.backtracking==0 ) { retval.schema.addField( (field_def86!=null?field_def86.fieldSchema:null) ); }

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
        }
        return retval;
    }
    // $ANTLR end "field_def_list"


    public static class type_return extends TreeRuleReturnScope {
        public Byte datatype;
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:384:1: type returns [Byte datatype, LogicalSchema logicalSchema] : ( simple_type | tuple_type | bag_type | map_type );
    public final LogicalPlanGenerator.type_return type() throws RecognitionException {
        LogicalPlanGenerator.type_return retval = new LogicalPlanGenerator.type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.simple_type_return simple_type87 =null;

        LogicalPlanGenerator.tuple_type_return tuple_type88 =null;

        LogicalPlanGenerator.bag_type_return bag_type89 =null;

        LogicalPlanGenerator.map_type_return map_type90 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:385:2: ( simple_type | tuple_type | bag_type | map_type )
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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:385:4: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type1149);
                    simple_type87=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type87.getTree());


                    if ( state.backtracking==0 ) {
                            retval.datatype = (simple_type87!=null?simple_type87.datatype:0);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:389:4: tuple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_in_type1159);
                    tuple_type88=tuple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type88.getTree());


                    if ( state.backtracking==0 ) {
                           retval.datatype = DataType.TUPLE;
                           retval.logicalSchema = (tuple_type88!=null?tuple_type88.logicalSchema:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:394:4: bag_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_in_type1169);
                    bag_type89=bag_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type89.getTree());


                    if ( state.backtracking==0 ) {
                           retval.datatype = DataType.BAG;
                           retval.logicalSchema = (bag_type89!=null?bag_type89.logicalSchema:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:399:4: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type1179);
                    map_type90=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type90.getTree());


                    if ( state.backtracking==0 ) {
                           retval.datatype = DataType.MAP;
                           retval.logicalSchema = (map_type90!=null?map_type90.logicalSchema:null);
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
    // $ANTLR end "type"


    public static class simple_type_return extends TreeRuleReturnScope {
        public byte datatype;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "simple_type"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:406:1: simple_type returns [byte datatype] : ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY );
    public final LogicalPlanGenerator.simple_type_return simple_type() throws RecognitionException {
        LogicalPlanGenerator.simple_type_return retval = new LogicalPlanGenerator.simple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BOOLEAN91=null;
        CommonTree INT92=null;
        CommonTree LONG93=null;
        CommonTree FLOAT94=null;
        CommonTree DOUBLE95=null;
        CommonTree BIGINTEGER96=null;
        CommonTree BIGDECIMAL97=null;
        CommonTree DATETIME98=null;
        CommonTree CHARARRAY99=null;
        CommonTree BYTEARRAY100=null;

        CommonTree BOOLEAN91_tree=null;
        CommonTree INT92_tree=null;
        CommonTree LONG93_tree=null;
        CommonTree FLOAT94_tree=null;
        CommonTree DOUBLE95_tree=null;
        CommonTree BIGINTEGER96_tree=null;
        CommonTree BIGDECIMAL97_tree=null;
        CommonTree DATETIME98_tree=null;
        CommonTree CHARARRAY99_tree=null;
        CommonTree BYTEARRAY100_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:407:2: ( BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY )
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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:407:4: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN91=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_simple_type1197); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN91_tree = (CommonTree)adaptor.dupNode(BOOLEAN91);


                    adaptor.addChild(root_0, BOOLEAN91_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.BOOLEAN; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:408:4: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT92=(CommonTree)match(input,INT,FOLLOW_INT_in_simple_type1204); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT92_tree = (CommonTree)adaptor.dupNode(INT92);


                    adaptor.addChild(root_0, INT92_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.INTEGER; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:409:4: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG93=(CommonTree)match(input,LONG,FOLLOW_LONG_in_simple_type1211); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG93_tree = (CommonTree)adaptor.dupNode(LONG93);


                    adaptor.addChild(root_0, LONG93_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.LONG; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:410:4: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT94=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_simple_type1218); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT94_tree = (CommonTree)adaptor.dupNode(FLOAT94);


                    adaptor.addChild(root_0, FLOAT94_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.FLOAT; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:411:4: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE95=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_simple_type1225); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE95_tree = (CommonTree)adaptor.dupNode(DOUBLE95);


                    adaptor.addChild(root_0, DOUBLE95_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.DOUBLE; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:412:4: BIGINTEGER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGINTEGER96=(CommonTree)match(input,BIGINTEGER,FOLLOW_BIGINTEGER_in_simple_type1232); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGINTEGER96_tree = (CommonTree)adaptor.dupNode(BIGINTEGER96);


                    adaptor.addChild(root_0, BIGINTEGER96_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.BIGINTEGER; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:413:4: BIGDECIMAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGDECIMAL97=(CommonTree)match(input,BIGDECIMAL,FOLLOW_BIGDECIMAL_in_simple_type1239); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGDECIMAL97_tree = (CommonTree)adaptor.dupNode(BIGDECIMAL97);


                    adaptor.addChild(root_0, BIGDECIMAL97_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.BIGDECIMAL; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:414:4: DATETIME
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DATETIME98=(CommonTree)match(input,DATETIME,FOLLOW_DATETIME_in_simple_type1246); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DATETIME98_tree = (CommonTree)adaptor.dupNode(DATETIME98);


                    adaptor.addChild(root_0, DATETIME98_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.DATETIME; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:415:4: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY99=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_simple_type1253); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY99_tree = (CommonTree)adaptor.dupNode(CHARARRAY99);


                    adaptor.addChild(root_0, CHARARRAY99_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.CHARARRAY; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:416:4: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY100=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_simple_type1260); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY100_tree = (CommonTree)adaptor.dupNode(BYTEARRAY100);


                    adaptor.addChild(root_0, BYTEARRAY100_tree);
                    }


                    if ( state.backtracking==0 ) { retval.datatype = DataType.BYTEARRAY; }

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
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple_type"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:419:1: tuple_type returns [LogicalSchema logicalSchema] : ^( TUPLE_TYPE ( field_def_list )? ) ;
    public final LogicalPlanGenerator.tuple_type_return tuple_type() throws RecognitionException {
        LogicalPlanGenerator.tuple_type_return retval = new LogicalPlanGenerator.tuple_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE101=null;
        LogicalPlanGenerator.field_def_list_return field_def_list102 =null;


        CommonTree TUPLE_TYPE101_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:420:2: ( ^( TUPLE_TYPE ( field_def_list )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:420:4: ^( TUPLE_TYPE ( field_def_list )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE101=(CommonTree)match(input,TUPLE_TYPE,FOLLOW_TUPLE_TYPE_in_tuple_type1277); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE101_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE101);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE101_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:421:7: ( field_def_list )?
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0 >= FIELD_DEF && LA26_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                    alt26=1;
                }
                switch (alt26) {
                    case 1 :
                        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:421:9: field_def_list
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_field_def_list_in_tuple_type1287);
                        field_def_list102=field_def_list();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, field_def_list102.getTree());


                        if ( state.backtracking==0 ) {
                                    LogicalPlanBuilder.setBytearrayForNULLType((field_def_list102!=null?field_def_list102.schema:null));
                                    retval.logicalSchema = (field_def_list102!=null?field_def_list102.schema:null);
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
    // $ANTLR end "tuple_type"


    public static class bag_type_return extends TreeRuleReturnScope {
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag_type"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:430:1: bag_type returns [LogicalSchema logicalSchema] : ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) ;
    public final LogicalPlanGenerator.bag_type_return bag_type() throws RecognitionException {
        LogicalPlanGenerator.bag_type_return retval = new LogicalPlanGenerator.bag_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE103=null;
        CommonTree IDENTIFIER104=null;
        LogicalPlanGenerator.tuple_type_return tuple_type105 =null;


        CommonTree BAG_TYPE103_tree=null;
        CommonTree IDENTIFIER104_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:431:2: ( ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:431:4: ^( BAG_TYPE ( IDENTIFIER )? ( tuple_type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE103=(CommonTree)match(input,BAG_TYPE,FOLLOW_BAG_TYPE_in_bag_type1327); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE103_tree = (CommonTree)adaptor.dupNode(BAG_TYPE103);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE103_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:431:16: ( IDENTIFIER )?
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==IDENTIFIER) ) {
                    alt27=1;
                }
                switch (alt27) {
                    case 1 :
                        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:431:16: IDENTIFIER
                        {
                        _last = (CommonTree)input.LT(1);
                        IDENTIFIER104=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_bag_type1329); if (state.failed) return retval;
                        if ( state.backtracking==0 ) {
                        IDENTIFIER104_tree = (CommonTree)adaptor.dupNode(IDENTIFIER104);


                        adaptor.addChild(root_1, IDENTIFIER104_tree);
                        }


                        if ( state.backtracking==0 ) {
                        }
                        }
                        break;

                }


                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:431:28: ( tuple_type )?
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==TUPLE_TYPE) ) {
                    alt28=1;
                }
                switch (alt28) {
                    case 1 :
                        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:431:28: tuple_type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_in_bag_type1332);
                        tuple_type105=tuple_type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type105.getTree());


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
                   if ((tuple_type105!=null?tuple_type105.logicalSchema:null)!=null && (tuple_type105!=null?tuple_type105.logicalSchema:null).size()==1 && (tuple_type105!=null?tuple_type105.logicalSchema:null).getField(0).type==DataType.TUPLE) {
                       retval.logicalSchema = (tuple_type105!=null?tuple_type105.logicalSchema:null);
                   }
                   else {
                       LogicalSchema s = new LogicalSchema();
                       s.addField(new LogicalFieldSchema((IDENTIFIER104!=null?IDENTIFIER104.getText():null), (tuple_type105!=null?tuple_type105.logicalSchema:null), DataType.TUPLE));
                       retval.logicalSchema = s;
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
    // $ANTLR end "bag_type"


    public static class map_type_return extends TreeRuleReturnScope {
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map_type"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:444:1: map_type returns [LogicalSchema logicalSchema] : ^( MAP_TYPE ( type )? ) ;
    public final LogicalPlanGenerator.map_type_return map_type() throws RecognitionException {
        LogicalPlanGenerator.map_type_return retval = new LogicalPlanGenerator.map_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_TYPE106=null;
        LogicalPlanGenerator.type_return type107 =null;


        CommonTree MAP_TYPE106_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:445:2: ( ^( MAP_TYPE ( type )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:445:4: ^( MAP_TYPE ( type )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_TYPE106=(CommonTree)match(input,MAP_TYPE,FOLLOW_MAP_TYPE_in_map_type1355); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_TYPE106_tree = (CommonTree)adaptor.dupNode(MAP_TYPE106);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_TYPE106_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:445:16: ( type )?
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==BIGDECIMAL||LA29_0==BIGINTEGER||LA29_0==BOOLEAN||LA29_0==BYTEARRAY||LA29_0==CHARARRAY||LA29_0==DATETIME||LA29_0==DOUBLE||LA29_0==FLOAT||LA29_0==INT||LA29_0==LONG||LA29_0==BAG_TYPE||LA29_0==MAP_TYPE||LA29_0==TUPLE_TYPE) ) {
                    alt29=1;
                }
                switch (alt29) {
                    case 1 :
                        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:445:16: type
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_type_in_map_type1357);
                        type107=type();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, type107.getTree());


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
                   LogicalSchema s = null;
                   if( (type107!=null?type107.datatype:null) != null ) {
                       s = new LogicalSchema();
                       s.addField( new LogicalFieldSchema( null, (type107!=null?type107.logicalSchema:null), (type107!=null?type107.datatype:null) ) );
                   }
                   retval.logicalSchema = s;
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
        public FuncSpec funcSpec;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:456:1: func_clause[byte ft] returns [FuncSpec funcSpec] : ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) );
    public final LogicalPlanGenerator.func_clause_return func_clause(byte ft) throws RecognitionException {
        LogicalPlanGenerator.func_clause_return retval = new LogicalPlanGenerator.func_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FUNC_REF108=null;
        CommonTree FUNC110=null;
        LogicalPlanGenerator.func_name_return func_name109 =null;

        LogicalPlanGenerator.func_name_return func_name111 =null;

        LogicalPlanGenerator.func_args_return func_args112 =null;


        CommonTree FUNC_REF108_tree=null;
        CommonTree FUNC110_tree=null;


            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:460:2: ( ^( FUNC_REF func_name ) | ^( FUNC func_name ( func_args )? ) )
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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:460:4: ^( FUNC_REF func_name )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_REF108=(CommonTree)match(input,FUNC_REF,FOLLOW_FUNC_REF_in_func_clause1386); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_REF108_tree = (CommonTree)adaptor.dupNode(FUNC_REF108);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_REF108_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1388);
                    func_name109=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name109.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.funcSpec = builder.lookupFunction( (func_name109!=null?func_name109.funcName:null) );
                           if( retval.funcSpec == null )
                               retval.funcSpec = builder.buildFuncSpec( loc, (func_name109!=null?func_name109.funcName:null), new ArrayList<String>(), ft );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:466:4: ^( FUNC func_name ( func_args )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC110=(CommonTree)match(input,FUNC,FOLLOW_FUNC_in_func_clause1402); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC110_tree = (CommonTree)adaptor.dupNode(FUNC110);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC110_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_clause1404);
                    func_name111=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name111.getTree());


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:466:22: ( func_args )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==MULTILINE_QUOTEDSTRING||LA30_0==QUOTEDSTRING) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:466:22: func_args
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_func_args_in_func_clause1406);
                            func_args112=func_args();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, func_args112.getTree());


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
                           retval.funcSpec = builder.lookupFunction( (func_name111!=null?func_name111.funcName:null) );
                           if( retval.funcSpec == null ) {
                               List<String> argList = new ArrayList<String>();
                               if( (func_args112!=null?func_args112.args:null) != null )
                                   argList = (func_args112!=null?func_args112.args:null);
                               retval.funcSpec = builder.buildFuncSpec( loc, (func_name111!=null?func_name111.funcName:null), argList, ft );
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
    // $ANTLR end "func_clause"


    public static class func_name_return extends TreeRuleReturnScope {
        public String funcName;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_name"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:478:1: func_name returns [String funcName] : p1= eid ( ( PERIOD | DOLLAR ) p2= eid )* ;
    public final LogicalPlanGenerator.func_name_return func_name() throws RecognitionException {
        LogicalPlanGenerator.func_name_return retval = new LogicalPlanGenerator.func_name_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PERIOD113=null;
        CommonTree DOLLAR114=null;
        LogicalPlanGenerator.eid_return p1 =null;

        LogicalPlanGenerator.eid_return p2 =null;


        CommonTree PERIOD113_tree=null;
        CommonTree DOLLAR114_tree=null;

         StringBuilder buf = new StringBuilder(); 
        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:480:2: (p1= eid ( ( PERIOD | DOLLAR ) p2= eid )* )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:480:4: p1= eid ( ( PERIOD | DOLLAR ) p2= eid )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_eid_in_func_name1436);
            p1=eid();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, p1.getTree());


            if ( state.backtracking==0 ) { buf.append( (p1!=null?p1.id:null) ); }

            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:481:7: ( ( PERIOD | DOLLAR ) p2= eid )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==DOLLAR||LA33_0==PERIOD) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:481:9: ( PERIOD | DOLLAR ) p2= eid
            	    {
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:481:9: ( PERIOD | DOLLAR )
            	    int alt32=2;
            	    int LA32_0 = input.LA(1);

            	    if ( (LA32_0==PERIOD) ) {
            	        alt32=1;
            	    }
            	    else if ( (LA32_0==DOLLAR) ) {
            	        alt32=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 32, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt32) {
            	        case 1 :
            	            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:481:11: PERIOD
            	            {
            	            _last = (CommonTree)input.LT(1);
            	            PERIOD113=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_func_name1450); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            PERIOD113_tree = (CommonTree)adaptor.dupNode(PERIOD113);


            	            adaptor.addChild(root_0, PERIOD113_tree);
            	            }


            	            if ( state.backtracking==0 ) { buf.append( (PERIOD113!=null?PERIOD113.getText():null) ); }

            	            if ( state.backtracking==0 ) {
            	            }
            	            }
            	            break;
            	        case 2 :
            	            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:481:52: DOLLAR
            	            {
            	            _last = (CommonTree)input.LT(1);
            	            DOLLAR114=(CommonTree)match(input,DOLLAR,FOLLOW_DOLLAR_in_func_name1456); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            DOLLAR114_tree = (CommonTree)adaptor.dupNode(DOLLAR114);


            	            adaptor.addChild(root_0, DOLLAR114_tree);
            	            }


            	            if ( state.backtracking==0 ) { buf.append( (DOLLAR114!=null?DOLLAR114.getText():null) ); }

            	            if ( state.backtracking==0 ) {
            	            }
            	            }
            	            break;

            	    }


            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_eid_in_func_name1472);
            	    p2=eid();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, p2.getTree());


            	    if ( state.backtracking==0 ) { buf.append( (p2!=null?p2.id:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            if ( state.backtracking==0 ) {
                   retval.funcName = buf.toString();
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
    // $ANTLR end "func_name"


    public static class func_args_return extends TreeRuleReturnScope {
        public List<String> args;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_args"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:488:1: func_args returns [List<String> args] : ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )+ ;
    public final LogicalPlanGenerator.func_args_return func_args() throws RecognitionException {
        LogicalPlanGenerator.func_args_return retval = new LogicalPlanGenerator.func_args_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING115=null;
        CommonTree MULTILINE_QUOTEDSTRING116=null;

        CommonTree QUOTEDSTRING115_tree=null;
        CommonTree MULTILINE_QUOTEDSTRING116_tree=null;

         retval.args = new ArrayList<String>(); 
        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:490:3: ( ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )+ )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:490:3: ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:490:3: ( QUOTEDSTRING | MULTILINE_QUOTEDSTRING )+
            int cnt34=0;
            loop34:
            do {
                int alt34=3;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==QUOTEDSTRING) ) {
                    alt34=1;
                }
                else if ( (LA34_0==MULTILINE_QUOTEDSTRING) ) {
                    alt34=2;
                }


                switch (alt34) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:490:5: QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    QUOTEDSTRING115=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_func_args1501); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    QUOTEDSTRING115_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING115);


            	    adaptor.addChild(root_0, QUOTEDSTRING115_tree);
            	    }


            	    if ( state.backtracking==0 ) { retval.args.add( builder.unquote( (QUOTEDSTRING115!=null?QUOTEDSTRING115.getText():null) ) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:491:7: MULTILINE_QUOTEDSTRING
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    MULTILINE_QUOTEDSTRING116=(CommonTree)match(input,MULTILINE_QUOTEDSTRING,FOLLOW_MULTILINE_QUOTEDSTRING_in_func_args1511); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    MULTILINE_QUOTEDSTRING116_tree = (CommonTree)adaptor.dupNode(MULTILINE_QUOTEDSTRING116);


            	    adaptor.addChild(root_0, MULTILINE_QUOTEDSTRING116_tree);
            	    }


            	    if ( state.backtracking==0 ) { retval.args.add( builder.unquote( (MULTILINE_QUOTEDSTRING116!=null?MULTILINE_QUOTEDSTRING116.getText():null) ) ); }

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
    // $ANTLR end "func_args"


    protected static class cube_clause_scope {
        LOCube cubeOp;
        MultiMap<Integer, LogicalExpressionPlan> cubePlans;
        List<String> operations;
        int inputIndex;
    }
    protected Stack cube_clause_stack = new Stack();


    public static class cube_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:501:1: cube_clause returns [String alias] : ^( CUBE cube_item ) ;
    public final LogicalPlanGenerator.cube_clause_return cube_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());
        cube_clause_stack.push(new cube_clause_scope());
        LogicalPlanGenerator.cube_clause_return retval = new LogicalPlanGenerator.cube_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CUBE117=null;
        LogicalPlanGenerator.cube_item_return cube_item118 =null;


        CommonTree CUBE117_tree=null;


            ((cube_clause_scope)cube_clause_stack.peek()).cubeOp = builder.createCubeOp();
            ((GScope_scope)GScope_stack.peek()).currentOp = ((cube_clause_scope)cube_clause_stack.peek()).cubeOp;
            ((cube_clause_scope)cube_clause_stack.peek()).cubePlans = new MultiMap<Integer, LogicalExpressionPlan>();
            ((cube_clause_scope)cube_clause_stack.peek()).operations = new ArrayList<String>();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:515:2: ( ^( CUBE cube_item ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:515:4: ^( CUBE cube_item )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CUBE117=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_cube_clause1553); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CUBE117_tree = (CommonTree)adaptor.dupNode(CUBE117);


            root_1 = (CommonTree)adaptor.becomeRoot(CUBE117_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_item_in_cube_clause1555);
            cube_item118=cube_item();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_item118.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );
                   retval.alias = builder.buildCubeOp( loc, ((cube_clause_scope)cube_clause_stack.peek()).cubeOp, ((statement_scope)statement_stack.peek()).alias,
                   ((statement_scope)statement_stack.peek()).inputAlias, ((cube_clause_scope)cube_clause_stack.peek()).operations, ((cube_clause_scope)cube_clause_stack.peek()).cubePlans );
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
            GScope_stack.pop();
            cube_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "cube_clause"


    public static class cube_item_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_item"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:523:1: cube_item : rel ( cube_by_clause ) ;
    public final LogicalPlanGenerator.cube_item_return cube_item() throws RecognitionException {
        LogicalPlanGenerator.cube_item_return retval = new LogicalPlanGenerator.cube_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.rel_return rel119 =null;

        LogicalPlanGenerator.cube_by_clause_return cube_by_clause120 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:524:2: ( rel ( cube_by_clause ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:524:4: rel ( cube_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_cube_item1572);
            rel119=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel119.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:524:8: ( cube_by_clause )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:524:10: cube_by_clause
            {
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_by_clause_in_cube_item1576);
            cube_by_clause120=cube_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, cube_by_clause120.getTree());


            if ( state.backtracking==0 ) {
                   ((cube_clause_scope)cube_clause_stack.peek()).cubePlans = (cube_by_clause120!=null?cube_by_clause120.plans:null);
                   ((cube_clause_scope)cube_clause_stack.peek()).operations = (cube_by_clause120!=null?cube_by_clause120.operations:null);
               }

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
        public List<String> operations;
        public MultiMap<Integer, LogicalExpressionPlan> plans;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:531:1: cube_by_clause returns [List<String> operations, MultiMap<Integer, LogicalExpressionPlan> plans] : ^( BY cube_or_rollup ) ;
    public final LogicalPlanGenerator.cube_by_clause_return cube_by_clause() throws RecognitionException {
        LogicalPlanGenerator.cube_by_clause_return retval = new LogicalPlanGenerator.cube_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY121=null;
        LogicalPlanGenerator.cube_or_rollup_return cube_or_rollup122 =null;


        CommonTree BY121_tree=null;


            retval.operations = new ArrayList<String>();
            retval.plans = new MultiMap<Integer, LogicalExpressionPlan>();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:536:2: ( ^( BY cube_or_rollup ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:536:4: ^( BY cube_or_rollup )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY121=(CommonTree)match(input,BY,FOLLOW_BY_in_cube_by_clause1603); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY121_tree = (CommonTree)adaptor.dupNode(BY121);


            root_1 = (CommonTree)adaptor.becomeRoot(BY121_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_or_rollup_in_cube_by_clause1605);
            cube_or_rollup122=cube_or_rollup();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_or_rollup122.getTree());


            if ( state.backtracking==0 ) { retval.operations = (cube_or_rollup122!=null?cube_or_rollup122.operations:null); retval.plans = (cube_or_rollup122!=null?cube_or_rollup122.plans:null); }

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
        public List<String> operations;
        public MultiMap<Integer, LogicalExpressionPlan> plans;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_or_rollup"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:539:1: cube_or_rollup returns [List<String> operations, MultiMap<Integer, LogicalExpressionPlan> plans] : ( cube_rollup_list )+ ;
    public final LogicalPlanGenerator.cube_or_rollup_return cube_or_rollup() throws RecognitionException {
        LogicalPlanGenerator.cube_or_rollup_return retval = new LogicalPlanGenerator.cube_or_rollup_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.cube_rollup_list_return cube_rollup_list123 =null;




            retval.operations = new ArrayList<String>();
            retval.plans = new MultiMap<Integer, LogicalExpressionPlan>();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:544:2: ( ( cube_rollup_list )+ )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:544:4: ( cube_rollup_list )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:544:4: ( cube_rollup_list )+
            int cnt35=0;
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==CUBE||LA35_0==ROLLUP) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:544:6: cube_rollup_list
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_rollup_list_in_cube_or_rollup1628);
            	    cube_rollup_list123=cube_rollup_list();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, cube_rollup_list123.getTree());


            	    if ( state.backtracking==0 ) {
            	           retval.operations.add((cube_rollup_list123!=null?cube_rollup_list123.operation:null));
            	           retval.plans.put( ((cube_clause_scope)cube_clause_stack.peek()).inputIndex, (cube_rollup_list123!=null?cube_rollup_list123.plans:null));
            	           ((cube_clause_scope)cube_clause_stack.peek()).inputIndex++;
            	       }

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
    // $ANTLR end "cube_or_rollup"


    public static class cube_rollup_list_return extends TreeRuleReturnScope {
        public String operation;
        public List<LogicalExpressionPlan> plans;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_rollup_list"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:552:1: cube_rollup_list returns [String operation, List<LogicalExpressionPlan> plans] : ^( ( CUBE | ROLLUP ) cube_by_expr_list ) ;
    public final LogicalPlanGenerator.cube_rollup_list_return cube_rollup_list() throws RecognitionException {
        LogicalPlanGenerator.cube_rollup_list_return retval = new LogicalPlanGenerator.cube_rollup_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CUBE124=null;
        CommonTree ROLLUP125=null;
        LogicalPlanGenerator.cube_by_expr_list_return cube_by_expr_list126 =null;


        CommonTree CUBE124_tree=null;
        CommonTree ROLLUP125_tree=null;


            retval.plans = new ArrayList<LogicalExpressionPlan>();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:556:2: ( ^( ( CUBE | ROLLUP ) cube_by_expr_list ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:556:4: ^( ( CUBE | ROLLUP ) cube_by_expr_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:556:7: ( CUBE | ROLLUP )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==CUBE) ) {
                alt36=1;
            }
            else if ( (LA36_0==ROLLUP) ) {
                alt36=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;

            }
            switch (alt36) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:556:9: CUBE
                    {
                    _last = (CommonTree)input.LT(1);
                    CUBE124=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_cube_rollup_list1658); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE124_tree = (CommonTree)adaptor.dupNode(CUBE124);


                    adaptor.addChild(root_1, CUBE124_tree);
                    }


                    if ( state.backtracking==0 ) { retval.operation = "CUBE"; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:556:41: ROLLUP
                    {
                    _last = (CommonTree)input.LT(1);
                    ROLLUP125=(CommonTree)match(input,ROLLUP,FOLLOW_ROLLUP_in_cube_rollup_list1664); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ROLLUP125_tree = (CommonTree)adaptor.dupNode(ROLLUP125);


                    adaptor.addChild(root_1, ROLLUP125_tree);
                    }


                    if ( state.backtracking==0 ) { retval.operation = "ROLLUP"; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cube_by_expr_list_in_cube_rollup_list1670);
            cube_by_expr_list126=cube_by_expr_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cube_by_expr_list126.getTree());


            if ( state.backtracking==0 ) { retval.plans = (cube_by_expr_list126!=null?cube_by_expr_list126.plans:null); }

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
        public List<LogicalExpressionPlan> plans;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_expr_list"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:559:1: cube_by_expr_list returns [List<LogicalExpressionPlan> plans] : ( cube_by_expr )+ ;
    public final LogicalPlanGenerator.cube_by_expr_list_return cube_by_expr_list() throws RecognitionException {
        LogicalPlanGenerator.cube_by_expr_list_return retval = new LogicalPlanGenerator.cube_by_expr_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.cube_by_expr_return cube_by_expr127 =null;




            retval.plans = new ArrayList<LogicalExpressionPlan>();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:563:2: ( ( cube_by_expr )+ )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:563:4: ( cube_by_expr )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:563:4: ( cube_by_expr )+
            int cnt37=0;
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==BIGDECIMALNUMBER||LA37_0==BIGINTEGERNUMBER||LA37_0==CUBE||LA37_0==DIV||LA37_0==DOLLARVAR||LA37_0==DOUBLENUMBER||LA37_0==FALSE||LA37_0==FLOATNUMBER||LA37_0==GROUP||LA37_0==IDENTIFIER||LA37_0==INTEGER||LA37_0==LONGINTEGER||LA37_0==MINUS||LA37_0==NULL||LA37_0==PERCENT||LA37_0==PLUS||LA37_0==QUOTEDSTRING||LA37_0==STAR||LA37_0==TRUE||(LA37_0 >= BAG_VAL && LA37_0 <= BIN_EXPR)||(LA37_0 >= CASE_COND && LA37_0 <= CASE_EXPR)||(LA37_0 >= CAST_EXPR && LA37_0 <= EXPR_IN_PAREN)||LA37_0==FUNC_EVAL||LA37_0==INVOKER_FUNC_EVAL||(LA37_0 >= MAP_VAL && LA37_0 <= NEG)||LA37_0==TUPLE_VAL) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:563:6: cube_by_expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cube_by_expr_in_cube_by_expr_list1694);
            	    cube_by_expr127=cube_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, cube_by_expr127.getTree());


            	    if ( state.backtracking==0 ) { retval.plans.add( (cube_by_expr127!=null?cube_by_expr127.plan:null) ); }

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
        public LogicalExpressionPlan plan;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cube_by_expr"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:566:1: cube_by_expr returns [LogicalExpressionPlan plan] : ( col_range[$plan] | expr[$plan] | STAR );
    public final LogicalPlanGenerator.cube_by_expr_return cube_by_expr() throws RecognitionException {
        LogicalPlanGenerator.cube_by_expr_return retval = new LogicalPlanGenerator.cube_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR130=null;
        LogicalPlanGenerator.col_range_return col_range128 =null;

        LogicalPlanGenerator.expr_return expr129 =null;


        CommonTree STAR130_tree=null;


            retval.plan = new LogicalExpressionPlan();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:570:2: ( col_range[$plan] | expr[$plan] | STAR )
            int alt38=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt38=1;
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
                alt38=2;
                }
                break;
            case STAR:
                {
                int LA38_3 = input.LA(2);

                if ( (LA38_3==DOWN) ) {
                    alt38=2;
                }
                else if ( (LA38_3==EOF||LA38_3==UP||LA38_3==BIGDECIMALNUMBER||LA38_3==BIGINTEGERNUMBER||LA38_3==CUBE||LA38_3==DIV||LA38_3==DOLLARVAR||LA38_3==DOUBLENUMBER||LA38_3==FALSE||LA38_3==FLOATNUMBER||LA38_3==GROUP||LA38_3==IDENTIFIER||LA38_3==INTEGER||LA38_3==LONGINTEGER||LA38_3==MINUS||LA38_3==NULL||LA38_3==PERCENT||LA38_3==PLUS||LA38_3==QUOTEDSTRING||LA38_3==STAR||LA38_3==TRUE||(LA38_3 >= BAG_VAL && LA38_3 <= BIN_EXPR)||(LA38_3 >= CASE_COND && LA38_3 <= CASE_EXPR)||(LA38_3 >= CAST_EXPR && LA38_3 <= EXPR_IN_PAREN)||LA38_3==FUNC_EVAL||LA38_3==INVOKER_FUNC_EVAL||(LA38_3 >= MAP_VAL && LA38_3 <= NEG)||LA38_3==TUPLE_VAL) ) {
                    alt38=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 3, input);

                    throw nvae;

                }
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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:570:4: col_range[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_cube_by_expr1717);
                    col_range128=col_range(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range128.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:571:4: expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cube_by_expr1723);
                    expr129=expr(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr129.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:572:4: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR130=(CommonTree)match(input,STAR,FOLLOW_STAR_in_cube_by_expr1729); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR130_tree = (CommonTree)adaptor.dupNode(STAR130);


                    adaptor.addChild(root_0, STAR130_tree);
                    }


                    if ( state.backtracking==0 ) {
                           builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR130 ), retval.plan, ((GScope_scope)GScope_stack.peek()).currentOp, 0, null, -1 );
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
        MultiMap<Integer, LogicalExpressionPlan> groupPlans;
        int inputIndex;
        List<String> inputAliases;
        List<Boolean> innerFlags;
    }
    protected Stack group_clause_stack = new Stack();


    public static class group_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:578:1: group_clause returns [String alias] : ( ^( GROUP ( group_item )+ ( group_type )? ( partition_clause )? ) | ^( COGROUP ( group_item )+ ( group_type )? ( partition_clause )? ) );
    public final LogicalPlanGenerator.group_clause_return group_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());
        group_clause_stack.push(new group_clause_scope());
        LogicalPlanGenerator.group_clause_return retval = new LogicalPlanGenerator.group_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP131=null;
        CommonTree COGROUP135=null;
        LogicalPlanGenerator.group_item_return group_item132 =null;

        LogicalPlanGenerator.group_type_return group_type133 =null;

        LogicalPlanGenerator.partition_clause_return partition_clause134 =null;

        LogicalPlanGenerator.group_item_return group_item136 =null;

        LogicalPlanGenerator.group_type_return group_type137 =null;

        LogicalPlanGenerator.partition_clause_return partition_clause138 =null;


        CommonTree GROUP131_tree=null;
        CommonTree COGROUP135_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createGroupOp();
            ((group_clause_scope)group_clause_stack.peek()).groupPlans = new MultiMap<Integer, LogicalExpressionPlan>();
            ((group_clause_scope)group_clause_stack.peek()).inputAliases = new ArrayList<String>();
            ((group_clause_scope)group_clause_stack.peek()).innerFlags = new ArrayList<Boolean>();
            GROUPTYPE groupType = GROUPTYPE.REGULAR;
            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );
            int oldStatementIndex = ((statement_scope)statement_stack.peek()).inputIndex;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:596:2: ( ^( GROUP ( group_item )+ ( group_type )? ( partition_clause )? ) | ^( COGROUP ( group_item )+ ( group_type )? ( partition_clause )? ) )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==GROUP) ) {
                alt45=1;
            }
            else if ( (LA45_0==COGROUP) ) {
                alt45=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;

            }
            switch (alt45) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:596:4: ^( GROUP ( group_item )+ ( group_type )? ( partition_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    GROUP131=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_group_clause1768); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP131_tree = (CommonTree)adaptor.dupNode(GROUP131);


                    root_1 = (CommonTree)adaptor.becomeRoot(GROUP131_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:596:13: ( group_item )+
                    int cnt39=0;
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==ARROBA||LA39_0==ASSERT||LA39_0==COGROUP||(LA39_0 >= CROSS && LA39_0 <= CUBE)||LA39_0==DEFINE||LA39_0==DISTINCT||LA39_0==FILTER||LA39_0==FOREACH||LA39_0==GROUP||LA39_0==IDENTIFIER||LA39_0==JOIN||(LA39_0 >= LIMIT && LA39_0 <= LOAD)||LA39_0==MAPREDUCE||LA39_0==ORDER||LA39_0==RANK||LA39_0==SAMPLE||(LA39_0 >= STORE && LA39_0 <= STREAM)||LA39_0==UNION) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:596:13: group_item
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_group_item_in_group_clause1770);
                    	    group_item132=group_item();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, group_item132.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt39 >= 1 ) break loop39;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(39, input);
                                throw eee;
                        }
                        cnt39++;
                    } while (true);


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:596:25: ( group_type )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==QUOTEDSTRING) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:596:27: group_type
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_group_type_in_group_clause1775);
                            group_type133=group_type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, group_type133.getTree());


                            if ( state.backtracking==0 ) { groupType = (group_type133!=null?group_type133.type:null); ((LOCogroup)((GScope_scope)GScope_stack.peek()).currentOp).pinOption(LOCogroup.OPTION_GROUPTYPE); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:596:146: ( partition_clause )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==PARTITION) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:596:146: partition_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_partition_clause_in_group_clause1782);
                            partition_clause134=partition_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, partition_clause134.getTree());


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
                           retval.alias = builder.buildGroupOp( loc, (LOCogroup)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias,
                               ((group_clause_scope)group_clause_stack.peek()).inputAliases, ((group_clause_scope)group_clause_stack.peek()).groupPlans, groupType, ((group_clause_scope)group_clause_stack.peek()).innerFlags,
                               (partition_clause134!=null?partition_clause134.partitioner:null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:602:4: ^( COGROUP ( group_item )+ ( group_type )? ( partition_clause )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    COGROUP135=(CommonTree)match(input,COGROUP,FOLLOW_COGROUP_in_group_clause1797); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COGROUP135_tree = (CommonTree)adaptor.dupNode(COGROUP135);


                    root_1 = (CommonTree)adaptor.becomeRoot(COGROUP135_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:602:15: ( group_item )+
                    int cnt42=0;
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==ARROBA||LA42_0==ASSERT||LA42_0==COGROUP||(LA42_0 >= CROSS && LA42_0 <= CUBE)||LA42_0==DEFINE||LA42_0==DISTINCT||LA42_0==FILTER||LA42_0==FOREACH||LA42_0==GROUP||LA42_0==IDENTIFIER||LA42_0==JOIN||(LA42_0 >= LIMIT && LA42_0 <= LOAD)||LA42_0==MAPREDUCE||LA42_0==ORDER||LA42_0==RANK||LA42_0==SAMPLE||(LA42_0 >= STORE && LA42_0 <= STREAM)||LA42_0==UNION) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:602:15: group_item
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_group_item_in_group_clause1799);
                    	    group_item136=group_item();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, group_item136.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt42 >= 1 ) break loop42;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(42, input);
                                throw eee;
                        }
                        cnt42++;
                    } while (true);


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:602:27: ( group_type )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==QUOTEDSTRING) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:602:29: group_type
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_group_type_in_group_clause1804);
                            group_type137=group_type();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, group_type137.getTree());


                            if ( state.backtracking==0 ) { groupType = (group_type137!=null?group_type137.type:null);((LOCogroup)((GScope_scope)GScope_stack.peek()).currentOp).pinOption(LOCogroup.OPTION_GROUPTYPE); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:602:147: ( partition_clause )?
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==PARTITION) ) {
                        alt44=1;
                    }
                    switch (alt44) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:602:147: partition_clause
                            {
                            _last = (CommonTree)input.LT(1);
                            pushFollow(FOLLOW_partition_clause_in_group_clause1811);
                            partition_clause138=partition_clause();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) 
                            adaptor.addChild(root_1, partition_clause138.getTree());


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
                           retval.alias = builder.buildGroupOp( loc, (LOCogroup)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias,
                               ((group_clause_scope)group_clause_stack.peek()).inputAliases, ((group_clause_scope)group_clause_stack.peek()).groupPlans, groupType, ((group_clause_scope)group_clause_stack.peek()).innerFlags,
                               (partition_clause138!=null?partition_clause138.partitioner:null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) { ((statement_scope)statement_stack.peek()).inputIndex = oldStatementIndex; }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();
            group_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "group_clause"


    public static class group_type_return extends TreeRuleReturnScope {
        public GROUPTYPE type;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "group_type"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:610:1: group_type returns [GROUPTYPE type] : QUOTEDSTRING ;
    public final LogicalPlanGenerator.group_type_return group_type() throws RecognitionException {
        LogicalPlanGenerator.group_type_return retval = new LogicalPlanGenerator.group_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING139=null;

        CommonTree QUOTEDSTRING139_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:611:2: ( QUOTEDSTRING )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:611:4: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING139=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_group_type1832); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING139_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING139);


            adaptor.addChild(root_0, QUOTEDSTRING139_tree);
            }


            if ( state.backtracking==0 ) {
                   retval.type =builder.parseGroupType( (QUOTEDSTRING139!=null?QUOTEDSTRING139.getText():null), new SourceLocation( (PigParserNode)QUOTEDSTRING139 ) );
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:617:1: group_item : rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? ;
    public final LogicalPlanGenerator.group_item_return group_item() throws RecognitionException {
        LogicalPlanGenerator.group_item_return retval = new LogicalPlanGenerator.group_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ALL142=null;
        CommonTree ANY143=null;
        CommonTree INNER144=null;
        CommonTree OUTER145=null;
        LogicalPlanGenerator.rel_return rel140 =null;

        LogicalPlanGenerator.join_group_by_clause_return join_group_by_clause141 =null;


        CommonTree ALL142_tree=null;
        CommonTree ANY143_tree=null;
        CommonTree INNER144_tree=null;
        CommonTree OUTER145_tree=null;

         boolean inner = false; 
        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:619:2: ( rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )? )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:619:4: rel ( join_group_by_clause | ALL | ANY ) ( INNER | OUTER )?
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_group_item1852);
            rel140=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, rel140.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:619:8: ( join_group_by_clause | ALL | ANY )
            int alt46=3;
            switch ( input.LA(1) ) {
            case BY:
                {
                alt46=1;
                }
                break;
            case ALL:
                {
                alt46=2;
                }
                break;
            case ANY:
                {
                alt46=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;

            }

            switch (alt46) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:619:10: join_group_by_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_group_by_clause_in_group_item1856);
                    join_group_by_clause141=join_group_by_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_group_by_clause141.getTree());


                    if ( state.backtracking==0 ) {
                                 ((group_clause_scope)group_clause_stack.peek()).groupPlans.put( ((group_clause_scope)group_clause_stack.peek()).inputIndex, (join_group_by_clause141!=null?join_group_by_clause141.plans:null) );
                             }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:623:12: ALL
                    {
                    _last = (CommonTree)input.LT(1);
                    ALL142=(CommonTree)match(input,ALL,FOLLOW_ALL_in_group_item1880); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL142_tree = (CommonTree)adaptor.dupNode(ALL142);


                    adaptor.addChild(root_0, ALL142_tree);
                    }


                    if ( state.backtracking==0 ) {
                                 LogicalExpressionPlan plan = new LogicalExpressionPlan();
                                 ConstantExpression ce = new ConstantExpression( plan, "all");
                                 ce.setLocation( new SourceLocation( (PigParserNode)ALL142 ) );
                                 List<LogicalExpressionPlan> plans = new ArrayList<LogicalExpressionPlan>( 1 );
                                 plans.add( plan );
                                 ((group_clause_scope)group_clause_stack.peek()).groupPlans.put( ((group_clause_scope)group_clause_stack.peek()).inputIndex, plans );
                             }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:632:12: ANY
                    {
                    _last = (CommonTree)input.LT(1);
                    ANY143=(CommonTree)match(input,ANY,FOLLOW_ANY_in_group_item1904); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ANY143_tree = (CommonTree)adaptor.dupNode(ANY143);


                    adaptor.addChild(root_0, ANY143_tree);
                    }


                    if ( state.backtracking==0 ) {
                                 LogicalExpressionPlan plan = new LogicalExpressionPlan();
                                 UserFuncExpression udf = new UserFuncExpression( plan, new FuncSpec( GFAny.class.getName() ) );
                                 udf.setLocation( new SourceLocation( (PigParserNode)ANY143 ) );
                                 List<LogicalExpressionPlan> plans = new ArrayList<LogicalExpressionPlan>( 1 );
                                 plans.add( plan );
                                 ((group_clause_scope)group_clause_stack.peek()).groupPlans.put( ((group_clause_scope)group_clause_stack.peek()).inputIndex, plans );
                             }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:641:11: ( INNER | OUTER )?
            int alt47=3;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==INNER) ) {
                alt47=1;
            }
            else if ( (LA47_0==OUTER) ) {
                alt47=2;
            }
            switch (alt47) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:641:13: INNER
                    {
                    _last = (CommonTree)input.LT(1);
                    INNER144=(CommonTree)match(input,INNER,FOLLOW_INNER_in_group_item1929); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INNER144_tree = (CommonTree)adaptor.dupNode(INNER144);


                    adaptor.addChild(root_0, INNER144_tree);
                    }


                    if ( state.backtracking==0 ) { inner =  true; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:641:40: OUTER
                    {
                    _last = (CommonTree)input.LT(1);
                    OUTER145=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_group_item1935); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTER145_tree = (CommonTree)adaptor.dupNode(OUTER145);


                    adaptor.addChild(root_0, OUTER145_tree);
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) {
                   ((group_clause_scope)group_clause_stack.peek()).inputAliases.add( ((statement_scope)statement_stack.peek()).inputAlias );
                   ((group_clause_scope)group_clause_stack.peek()).innerFlags.add( inner );
                   ((group_clause_scope)group_clause_stack.peek()).inputIndex++;
                   ((statement_scope)statement_stack.peek()).inputIndex++;
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:650:1: rel : ( alias | previous_rel | inline_op );
    public final LogicalPlanGenerator.rel_return rel() throws RecognitionException {
        LogicalPlanGenerator.rel_return retval = new LogicalPlanGenerator.rel_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.alias_return alias146 =null;

        LogicalPlanGenerator.previous_rel_return previous_rel147 =null;

        LogicalPlanGenerator.inline_op_return inline_op148 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:651:2: ( alias | previous_rel | inline_op )
            int alt48=3;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt48=1;
                }
                break;
            case ARROBA:
                {
                alt48=2;
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
            case STORE:
            case STREAM:
            case UNION:
                {
                alt48=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;

            }

            switch (alt48) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:651:4: alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_in_rel1953);
                    alias146=alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias146.getTree());


                    if ( state.backtracking==0 ) {
                           ((statement_scope)statement_stack.peek()).inputAlias = (alias146!=null?alias146.name:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:655:4: previous_rel
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_previous_rel_in_rel1963);
                    previous_rel147=previous_rel();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, previous_rel147.getTree());


                    if ( state.backtracking==0 ) {
                           ((statement_scope)statement_stack.peek()).inputAlias = (previous_rel147!=null?previous_rel147.name:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:659:4: inline_op
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_inline_op_in_rel1973);
                    inline_op148=inline_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, inline_op148.getTree());


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


    public static class previous_rel_return extends TreeRuleReturnScope {
        public String name;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "previous_rel"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:662:1: previous_rel returns [String name] : ARROBA ;
    public final LogicalPlanGenerator.previous_rel_return previous_rel() throws RecognitionException {
        LogicalPlanGenerator.previous_rel_return retval = new LogicalPlanGenerator.previous_rel_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ARROBA149=null;

        CommonTree ARROBA149_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:662:35: ( ARROBA )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:662:37: ARROBA
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            ARROBA149=(CommonTree)match(input,ARROBA,FOLLOW_ARROBA_in_previous_rel1985); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ARROBA149_tree = (CommonTree)adaptor.dupNode(ARROBA149);


            adaptor.addChild(root_0, ARROBA149_tree);
            }


            if ( state.backtracking==0 ) { retval.name = builder.getLastRel(new SourceLocation((PigParserNode)ARROBA149)); }

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


    public static class inline_op_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "inline_op"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:665:1: inline_op : op_clause ( parallel_clause )? ;
    public final LogicalPlanGenerator.inline_op_return inline_op() throws RecognitionException {
        LogicalPlanGenerator.inline_op_return retval = new LogicalPlanGenerator.inline_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.op_clause_return op_clause150 =null;

        LogicalPlanGenerator.parallel_clause_return parallel_clause151 =null;




            String al = ((statement_scope)statement_stack.peek()).alias;
            ((statement_scope)statement_stack.peek()).alias = null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:673:2: ( op_clause ( parallel_clause )? )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:673:4: op_clause ( parallel_clause )?
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_op_clause_in_inline_op2007);
            op_clause150=op_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, op_clause150.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:673:14: ( parallel_clause )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==PARALLEL) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:673:14: parallel_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_parallel_clause_in_inline_op2009);
                    parallel_clause151=parallel_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, parallel_clause151.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) {
                   Operator op = builder.lookupOperator( (op_clause150!=null?op_clause150.alias:null) );
                   builder.setParallel( (LogicalRelationalOperator)op, ((statement_scope)statement_stack.peek()).parallel );
                   ((statement_scope)statement_stack.peek()).inputAlias = (op_clause150!=null?op_clause150.alias:null);
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) {
                ((statement_scope)statement_stack.peek()).alias = al;
            }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "inline_op"


    public static class flatten_generated_item_return extends TreeRuleReturnScope {
        public LogicalExpressionPlan plan;
        public boolean flattenFlag;
        public LogicalSchema schema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "flatten_generated_item"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:681:1: flatten_generated_item returns [LogicalExpressionPlan plan, boolean flattenFlag, LogicalSchema schema] : ( flatten_clause[$plan] | col_range[$plan] | expr[$plan] | STAR ) ( field_def_list )? ;
    public final LogicalPlanGenerator.flatten_generated_item_return flatten_generated_item() throws RecognitionException {
        LogicalPlanGenerator.flatten_generated_item_return retval = new LogicalPlanGenerator.flatten_generated_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR155=null;
        LogicalPlanGenerator.flatten_clause_return flatten_clause152 =null;

        LogicalPlanGenerator.col_range_return col_range153 =null;

        LogicalPlanGenerator.expr_return expr154 =null;

        LogicalPlanGenerator.field_def_list_return field_def_list156 =null;


        CommonTree STAR155_tree=null;


            retval.plan = new LogicalExpressionPlan();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:685:2: ( ( flatten_clause[$plan] | col_range[$plan] | expr[$plan] | STAR ) ( field_def_list )? )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:685:4: ( flatten_clause[$plan] | col_range[$plan] | expr[$plan] | STAR ) ( field_def_list )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:685:4: ( flatten_clause[$plan] | col_range[$plan] | expr[$plan] | STAR )
            int alt50=4;
            switch ( input.LA(1) ) {
            case FLATTEN:
                {
                alt50=1;
                }
                break;
            case COL_RANGE:
                {
                alt50=2;
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
                alt50=3;
                }
                break;
            case STAR:
                {
                int LA50_4 = input.LA(2);

                if ( (LA50_4==DOWN) ) {
                    alt50=3;
                }
                else if ( (LA50_4==EOF||LA50_4==UP||LA50_4==BIGDECIMALNUMBER||LA50_4==BIGINTEGERNUMBER||LA50_4==CUBE||LA50_4==DIV||LA50_4==DOLLARVAR||LA50_4==DOUBLENUMBER||LA50_4==FALSE||LA50_4==FLATTEN||LA50_4==FLOATNUMBER||LA50_4==GROUP||LA50_4==IDENTIFIER||LA50_4==INTEGER||LA50_4==LONGINTEGER||LA50_4==MINUS||LA50_4==NULL||LA50_4==PERCENT||LA50_4==PLUS||LA50_4==QUOTEDSTRING||LA50_4==STAR||LA50_4==TRUE||(LA50_4 >= BAG_VAL && LA50_4 <= BIN_EXPR)||(LA50_4 >= CASE_COND && LA50_4 <= CASE_EXPR)||(LA50_4 >= CAST_EXPR && LA50_4 <= FIELD_DEF_WITHOUT_IDENTIFIER)||LA50_4==FUNC_EVAL||LA50_4==INVOKER_FUNC_EVAL||(LA50_4 >= MAP_VAL && LA50_4 <= NEG)||LA50_4==TUPLE_VAL) ) {
                    alt50=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 50, 4, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;

            }

            switch (alt50) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:685:6: flatten_clause[$plan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_flatten_clause_in_flatten_generated_item2035);
                    flatten_clause152=flatten_clause(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, flatten_clause152.getTree());


                    if ( state.backtracking==0 ) { retval.flattenFlag = true; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:686:6: col_range[$plan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_flatten_generated_item2045);
                    col_range153=col_range(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range153.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:687:6: expr[$plan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_flatten_generated_item2053);
                    expr154=expr(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr154.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:688:6: STAR
                    {
                    _last = (CommonTree)input.LT(1);
                    STAR155=(CommonTree)match(input,STAR,FOLLOW_STAR_in_flatten_generated_item2061); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR155_tree = (CommonTree)adaptor.dupNode(STAR155);


                    adaptor.addChild(root_0, STAR155_tree);
                    }


                    if ( state.backtracking==0 ) {
                             builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR155 ), retval.plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                                 ((statement_scope)statement_stack.peek()).inputIndex, null, -1 );
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:694:4: ( field_def_list )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( ((LA51_0 >= FIELD_DEF && LA51_0 <= FIELD_DEF_WITHOUT_IDENTIFIER)) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:694:6: field_def_list
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_field_def_list_in_flatten_generated_item2080);
                    field_def_list156=field_def_list();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, field_def_list156.getTree());


                    if ( state.backtracking==0 ) { retval.schema = (field_def_list156!=null?field_def_list156.schema:null); }

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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:697:1: flatten_clause[LogicalExpressionPlan plan] : ^( FLATTEN expr[$plan] ) ;
    public final LogicalPlanGenerator.flatten_clause_return flatten_clause(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.flatten_clause_return retval = new LogicalPlanGenerator.flatten_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FLATTEN157=null;
        LogicalPlanGenerator.expr_return expr158 =null;


        CommonTree FLATTEN157_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:698:2: ( ^( FLATTEN expr[$plan] ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:698:4: ^( FLATTEN expr[$plan] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FLATTEN157=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_flatten_clause2098); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FLATTEN157_tree = (CommonTree)adaptor.dupNode(FLATTEN157);


            root_1 = (CommonTree)adaptor.becomeRoot(FLATTEN157_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_flatten_clause2100);
            expr158=expr(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, expr158.getTree());


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
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "store_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:701:1: store_clause returns [String alias] : ^( STORE rel filename ( func_clause[FunctionType.STOREFUNC] )? ) ;
    public final LogicalPlanGenerator.store_clause_return store_clause() throws RecognitionException {
        LogicalPlanGenerator.store_clause_return retval = new LogicalPlanGenerator.store_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STORE159=null;
        LogicalPlanGenerator.rel_return rel160 =null;

        LogicalPlanGenerator.filename_return filename161 =null;

        LogicalPlanGenerator.func_clause_return func_clause162 =null;


        CommonTree STORE159_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:702:2: ( ^( STORE rel filename ( func_clause[FunctionType.STOREFUNC] )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:702:4: ^( STORE rel filename ( func_clause[FunctionType.STOREFUNC] )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STORE159=(CommonTree)match(input,STORE,FOLLOW_STORE_in_store_clause2118); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STORE159_tree = (CommonTree)adaptor.dupNode(STORE159);


            root_1 = (CommonTree)adaptor.becomeRoot(STORE159_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_store_clause2120);
            rel160=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel160.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_filename_in_store_clause2122);
            filename161=filename();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, filename161.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:702:26: ( func_clause[FunctionType.STOREFUNC] )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==FUNC||LA52_0==FUNC_REF) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:702:26: func_clause[FunctionType.STOREFUNC]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_store_clause2124);
                    func_clause162=func_clause(FunctionType.STOREFUNC);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause162.getTree());


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
                   SourceLocation loc = new SourceLocation( (PigParserNode)STORE159 );
                   retval.alias = builder.buildStoreOp( loc, ((statement_scope)statement_stack.peek()).alias,
                      ((statement_scope)statement_stack.peek()).inputAlias, (filename161!=null?filename161.filename:null), (func_clause162!=null?func_clause162.funcSpec:null) );
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
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assert_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:710:1: assert_clause returns [String alias] : ^( ASSERT rel cond[exprPlan] ( comment )? ) ;
    public final LogicalPlanGenerator.assert_clause_return assert_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.assert_clause_return retval = new LogicalPlanGenerator.assert_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ASSERT163=null;
        LogicalPlanGenerator.rel_return rel164 =null;

        LogicalPlanGenerator.cond_return cond165 =null;

        LogicalPlanGenerator.comment_return comment166 =null;


        CommonTree ASSERT163_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createFilterOp();
            LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:716:2: ( ^( ASSERT rel cond[exprPlan] ( comment )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:716:4: ^( ASSERT rel cond[exprPlan] ( comment )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ASSERT163=(CommonTree)match(input,ASSERT,FOLLOW_ASSERT_in_assert_clause2158); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ASSERT163_tree = (CommonTree)adaptor.dupNode(ASSERT163);


            root_1 = (CommonTree)adaptor.becomeRoot(ASSERT163_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_assert_clause2160);
            rel164=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel164.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_assert_clause2162);
            cond165=cond(exprPlan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond165.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:716:33: ( comment )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==QUOTEDSTRING) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:716:33: comment
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_comment_in_assert_clause2165);
                    comment166=comment();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, comment166.getTree());


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
                   SourceLocation loc = new SourceLocation( (PigParserNode)ASSERT163 );
                   retval.alias = builder.buildAssertOp(loc, (LOFilter)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias,
                      ((statement_scope)statement_stack.peek()).inputAlias, (cond165!=null?cond165.expr:null), (comment166!=null?comment166.comment:null), exprPlan);
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
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "assert_clause"


    public static class comment_return extends TreeRuleReturnScope {
        public String comment;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "comment"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:724:1: comment returns [String comment] : QUOTEDSTRING ;
    public final LogicalPlanGenerator.comment_return comment() throws RecognitionException {
        LogicalPlanGenerator.comment_return retval = new LogicalPlanGenerator.comment_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING167=null;

        CommonTree QUOTEDSTRING167_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:725:2: ( QUOTEDSTRING )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:725:4: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING167=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_comment2186); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING167_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING167);


            adaptor.addChild(root_0, QUOTEDSTRING167_tree);
            }


            if ( state.backtracking==0 ) { retval.comment = builder.unquote( (QUOTEDSTRING167!=null?QUOTEDSTRING167.getText():null) ); }

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
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "filter_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:728:1: filter_clause returns [String alias] : ^( FILTER rel cond[exprPlan] ) ;
    public final LogicalPlanGenerator.filter_clause_return filter_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.filter_clause_return retval = new LogicalPlanGenerator.filter_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER168=null;
        LogicalPlanGenerator.rel_return rel169 =null;

        LogicalPlanGenerator.cond_return cond170 =null;


        CommonTree FILTER168_tree=null;


            LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createFilterOp();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:734:2: ( ^( FILTER rel cond[exprPlan] ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:734:4: ^( FILTER rel cond[exprPlan] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER168=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_filter_clause2213); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER168_tree = (CommonTree)adaptor.dupNode(FILTER168);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER168_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_filter_clause2215);
            rel169=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel169.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_filter_clause2217);
            cond170=cond(exprPlan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond170.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.alias = builder.buildFilterOp( new SourceLocation( (PigParserNode)FILTER168 ),
                       (LOFilter)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias,
                       ((statement_scope)statement_stack.peek()).inputAlias, exprPlan );
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
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "filter_clause"


    public static class cond_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cond"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:742:1: cond[LogicalExpressionPlan exprPlan] returns [LogicalExpression expr] : ( ^( OR left= cond[exprPlan] right= cond[exprPlan] ) | ^( AND left= cond[exprPlan] right= cond[exprPlan] ) | ^( NOT c= cond[exprPlan] ) | ^( NULL expr[$exprPlan] ( NOT )? ) | ^( rel_op_eq e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_ne e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_lt e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_lte e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_gt e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_gte e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( STR_OP_MATCHES e1= expr[$exprPlan] e2= expr[$exprPlan] ) | in_eval[$exprPlan] | func_eval[$exprPlan] | ^( BOOL_COND e1= expr[$exprPlan] ) );
    public final LogicalPlanGenerator.cond_return cond(LogicalExpressionPlan exprPlan) throws RecognitionException {
        LogicalPlanGenerator.cond_return retval = new LogicalPlanGenerator.cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OR171=null;
        CommonTree AND172=null;
        CommonTree NOT173=null;
        CommonTree NULL174=null;
        CommonTree NOT176=null;
        CommonTree STR_OP_MATCHES183=null;
        CommonTree BOOL_COND186=null;
        LogicalPlanGenerator.cond_return left =null;

        LogicalPlanGenerator.cond_return right =null;

        LogicalPlanGenerator.cond_return c =null;

        LogicalPlanGenerator.expr_return e1 =null;

        LogicalPlanGenerator.expr_return e2 =null;

        LogicalPlanGenerator.expr_return expr175 =null;

        LogicalPlanGenerator.rel_op_eq_return rel_op_eq177 =null;

        LogicalPlanGenerator.rel_op_ne_return rel_op_ne178 =null;

        LogicalPlanGenerator.rel_op_lt_return rel_op_lt179 =null;

        LogicalPlanGenerator.rel_op_lte_return rel_op_lte180 =null;

        LogicalPlanGenerator.rel_op_gt_return rel_op_gt181 =null;

        LogicalPlanGenerator.rel_op_gte_return rel_op_gte182 =null;

        LogicalPlanGenerator.in_eval_return in_eval184 =null;

        LogicalPlanGenerator.func_eval_return func_eval185 =null;


        CommonTree OR171_tree=null;
        CommonTree AND172_tree=null;
        CommonTree NOT173_tree=null;
        CommonTree NULL174_tree=null;
        CommonTree NOT176_tree=null;
        CommonTree STR_OP_MATCHES183_tree=null;
        CommonTree BOOL_COND186_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:743:2: ( ^( OR left= cond[exprPlan] right= cond[exprPlan] ) | ^( AND left= cond[exprPlan] right= cond[exprPlan] ) | ^( NOT c= cond[exprPlan] ) | ^( NULL expr[$exprPlan] ( NOT )? ) | ^( rel_op_eq e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_ne e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_lt e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_lte e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_gt e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( rel_op_gte e1= expr[$exprPlan] e2= expr[$exprPlan] ) | ^( STR_OP_MATCHES e1= expr[$exprPlan] e2= expr[$exprPlan] ) | in_eval[$exprPlan] | func_eval[$exprPlan] | ^( BOOL_COND e1= expr[$exprPlan] ) )
            int alt55=14;
            switch ( input.LA(1) ) {
            case OR:
                {
                alt55=1;
                }
                break;
            case AND:
                {
                alt55=2;
                }
                break;
            case NOT:
                {
                alt55=3;
                }
                break;
            case NULL:
                {
                alt55=4;
                }
                break;
            case NUM_OP_EQ:
            case STR_OP_EQ:
                {
                alt55=5;
                }
                break;
            case NUM_OP_NE:
            case STR_OP_NE:
                {
                alt55=6;
                }
                break;
            case NUM_OP_LT:
            case STR_OP_LT:
                {
                alt55=7;
                }
                break;
            case NUM_OP_LTE:
            case STR_OP_LTE:
                {
                alt55=8;
                }
                break;
            case NUM_OP_GT:
            case STR_OP_GT:
                {
                alt55=9;
                }
                break;
            case NUM_OP_GTE:
            case STR_OP_GTE:
                {
                alt55=10;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt55=11;
                }
                break;
            case IN:
                {
                alt55=12;
                }
                break;
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
                {
                alt55=13;
                }
                break;
            case BOOL_COND:
                {
                alt55=14;
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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:743:4: ^( OR left= cond[exprPlan] right= cond[exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    OR171=(CommonTree)match(input,OR,FOLLOW_OR_in_cond2241); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR171_tree = (CommonTree)adaptor.dupNode(OR171);


                    root_1 = (CommonTree)adaptor.becomeRoot(OR171_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2247);
                    left=cond(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2254);
                    right=cond(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new OrExpression( exprPlan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)OR171 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:748:4: ^( AND left= cond[exprPlan] right= cond[exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    AND172=(CommonTree)match(input,AND,FOLLOW_AND_in_cond2269); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND172_tree = (CommonTree)adaptor.dupNode(AND172);


                    root_1 = (CommonTree)adaptor.becomeRoot(AND172_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2275);
                    left=cond(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2282);
                    right=cond(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new AndExpression( exprPlan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)AND172 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:753:4: ^( NOT c= cond[exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NOT173=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond2297); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT173_tree = (CommonTree)adaptor.dupNode(NOT173);


                    root_1 = (CommonTree)adaptor.becomeRoot(NOT173_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_cond_in_cond2303);
                    c=cond(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, c.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new NotExpression( exprPlan, (c!=null?c.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)NOT173 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:758:4: ^( NULL expr[$exprPlan] ( NOT )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NULL174=(CommonTree)match(input,NULL,FOLLOW_NULL_in_cond2318); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL174_tree = (CommonTree)adaptor.dupNode(NULL174);


                    root_1 = (CommonTree)adaptor.becomeRoot(NULL174_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2320);
                    expr175=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr175.getTree());


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:758:28: ( NOT )?
                    int alt54=2;
                    int LA54_0 = input.LA(1);

                    if ( (LA54_0==NOT) ) {
                        alt54=1;
                    }
                    switch (alt54) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:758:28: NOT
                            {
                            _last = (CommonTree)input.LT(1);
                            NOT176=(CommonTree)match(input,NOT,FOLLOW_NOT_in_cond2323); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            NOT176_tree = (CommonTree)adaptor.dupNode(NOT176);


                            adaptor.addChild(root_1, NOT176_tree);
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
                           retval.expr = new IsNullExpression( exprPlan, (expr175!=null?expr175.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)NULL174 ) );
                           if( NOT176 != null ) {
                               retval.expr = new NotExpression( exprPlan, retval.expr );
                               retval.expr.setLocation( new SourceLocation( (PigParserNode)NOT176 ) );
                           }
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:767:4: ^( rel_op_eq e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_eq_in_cond2338);
                    rel_op_eq177=rel_op_eq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_eq177.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2344);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2351);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new EqualExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_eq177!=null?((CommonTree)rel_op_eq177.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:772:4: ^( rel_op_ne e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_ne_in_cond2366);
                    rel_op_ne178=rel_op_ne();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_ne178.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2372);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2379);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new NotEqualExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_ne178!=null?((CommonTree)rel_op_ne178.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:777:4: ^( rel_op_lt e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lt_in_cond2394);
                    rel_op_lt179=rel_op_lt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_lt179.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2400);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2407);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new LessThanExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_lt179!=null?((CommonTree)rel_op_lt179.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:782:4: ^( rel_op_lte e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lte_in_cond2422);
                    rel_op_lte180=rel_op_lte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_lte180.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2428);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2435);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new LessThanEqualExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_lte180!=null?((CommonTree)rel_op_lte180.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:787:4: ^( rel_op_gt e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gt_in_cond2450);
                    rel_op_gt181=rel_op_gt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_gt181.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2456);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2463);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new GreaterThanExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_gt181!=null?((CommonTree)rel_op_gt181.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:792:4: ^( rel_op_gte e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gte_in_cond2478);
                    rel_op_gte182=rel_op_gte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_1 = (CommonTree)adaptor.becomeRoot(rel_op_gte182.getTree(), root_1);


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2484);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2491);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new GreaterThanEqualExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(rel_op_gte182!=null?((CommonTree)rel_op_gte182.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:797:4: ^( STR_OP_MATCHES e1= expr[$exprPlan] e2= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES183=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_cond2506); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES183_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES183);


                    root_1 = (CommonTree)adaptor.becomeRoot(STR_OP_MATCHES183_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2512);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2519);
                    e2=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e2.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new RegexExpression( exprPlan, (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)STR_OP_MATCHES183 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:802:4: in_eval[$exprPlan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_in_eval_in_cond2532);
                    in_eval184=in_eval(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, in_eval184.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (in_eval184!=null?in_eval184.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:806:4: func_eval[$exprPlan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_cond2543);
                    func_eval185=func_eval(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval185.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (func_eval185!=null?func_eval185.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:810:4: ^( BOOL_COND e1= expr[$exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    BOOL_COND186=(CommonTree)match(input,BOOL_COND,FOLLOW_BOOL_COND_in_cond2556); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOL_COND186_tree = (CommonTree)adaptor.dupNode(BOOL_COND186);


                    root_1 = (CommonTree)adaptor.becomeRoot(BOOL_COND186_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_cond2562);
                    e1=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e1.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = (e1!=null?e1.expr:null);
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)BOOL_COND186 ) );
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
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "in_eval"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:817:1: in_eval[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ^( IN ( ^( IN_LHS lhs= expr[$plan] ) ^( IN_RHS rhs= expr[$plan] ) )+ ) ;
    public final LogicalPlanGenerator.in_eval_return in_eval(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.in_eval_return retval = new LogicalPlanGenerator.in_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IN187=null;
        CommonTree IN_LHS188=null;
        CommonTree IN_RHS189=null;
        LogicalPlanGenerator.expr_return lhs =null;

        LogicalPlanGenerator.expr_return rhs =null;


        CommonTree IN187_tree=null;
        CommonTree IN_LHS188_tree=null;
        CommonTree IN_RHS189_tree=null;


            List<LogicalExpression> lhsExprs = new ArrayList<LogicalExpression>();
            List<LogicalExpression> rhsExprs = new ArrayList<LogicalExpression>();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:822:2: ( ^( IN ( ^( IN_LHS lhs= expr[$plan] ) ^( IN_RHS rhs= expr[$plan] ) )+ ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:822:4: ^( IN ( ^( IN_LHS lhs= expr[$plan] ) ^( IN_RHS rhs= expr[$plan] ) )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            IN187=(CommonTree)match(input,IN,FOLLOW_IN_in_in_eval2591); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IN187_tree = (CommonTree)adaptor.dupNode(IN187);


            root_1 = (CommonTree)adaptor.becomeRoot(IN187_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:822:10: ( ^( IN_LHS lhs= expr[$plan] ) ^( IN_RHS rhs= expr[$plan] ) )+
            int cnt56=0;
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==IN_LHS) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:822:12: ^( IN_LHS lhs= expr[$plan] ) ^( IN_RHS rhs= expr[$plan] )
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_2 = _last;
            	    CommonTree _first_2 = null;
            	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    IN_LHS188=(CommonTree)match(input,IN_LHS,FOLLOW_IN_LHS_in_in_eval2597); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IN_LHS188_tree = (CommonTree)adaptor.dupNode(IN_LHS188);


            	    root_2 = (CommonTree)adaptor.becomeRoot(IN_LHS188_tree, root_2);
            	    }


            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_in_eval2603);
            	    lhs=expr(plan);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, lhs.getTree());


            	    match(input, Token.UP, null); if (state.failed) return retval;
            	    adaptor.addChild(root_1, root_2);
            	    _last = _save_last_2;
            	    }


            	    if ( state.backtracking==0 ) { lhsExprs.add((lhs!=null?lhs.expr:null)); }

            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_2 = _last;
            	    CommonTree _first_2 = null;
            	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    IN_RHS189=(CommonTree)match(input,IN_RHS,FOLLOW_IN_RHS_in_in_eval2623); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IN_RHS189_tree = (CommonTree)adaptor.dupNode(IN_RHS189);


            	    root_2 = (CommonTree)adaptor.becomeRoot(IN_RHS189_tree, root_2);
            	    }


            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_in_eval2629);
            	    rhs=expr(plan);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, rhs.getTree());


            	    match(input, Token.UP, null); if (state.failed) return retval;
            	    adaptor.addChild(root_1, root_2);
            	    _last = _save_last_2;
            	    }


            	    if ( state.backtracking==0 ) { rhsExprs.add((rhs!=null?rhs.expr:null)); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt56 >= 1 ) break loop56;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(56, input);
                        throw eee;
                }
                cnt56++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                    // Convert IN tree to nested or expressions. Please also see
                    // QueryParser.g for how IN tree is constructed from IN expression.
                    EqualExpression firstBoolExpr = new EqualExpression(plan, lhsExprs.get(0), rhsExprs.get(0));
                    if (lhsExprs.size() == 1) {
                        retval.expr = firstBoolExpr;
                    } else {
                        OrExpression currOrExpr = null;
                        OrExpression prevOrExpr = null;
                        for (int i = 1; i < lhsExprs.size(); i++) {
                            EqualExpression boolExpr = new EqualExpression(plan, lhsExprs.get(i), rhsExprs.get(i));
                            currOrExpr = new OrExpression( plan, prevOrExpr == null ? firstBoolExpr : prevOrExpr, boolExpr );
                            prevOrExpr = currOrExpr;
                        }
                        retval.expr = currOrExpr;
                    }
                    retval.expr.setLocation( new SourceLocation( (PigParserNode)((CommonTree)retval.start) ) );
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
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "func_eval"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:844:1: func_eval[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ( ^( FUNC_EVAL func_name ( real_arg[$plan] )* ) | ^( INVOKER_FUNC_EVAL package_name= IDENTIFIER function_name= IDENTIFIER is_static= IDENTIFIER ( real_arg[$plan] )* ) );
    public final LogicalPlanGenerator.func_eval_return func_eval(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.func_eval_return retval = new LogicalPlanGenerator.func_eval_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree package_name=null;
        CommonTree function_name=null;
        CommonTree is_static=null;
        CommonTree FUNC_EVAL190=null;
        CommonTree INVOKER_FUNC_EVAL193=null;
        LogicalPlanGenerator.func_name_return func_name191 =null;

        LogicalPlanGenerator.real_arg_return real_arg192 =null;

        LogicalPlanGenerator.real_arg_return real_arg194 =null;


        CommonTree package_name_tree=null;
        CommonTree function_name_tree=null;
        CommonTree is_static_tree=null;
        CommonTree FUNC_EVAL190_tree=null;
        CommonTree INVOKER_FUNC_EVAL193_tree=null;


            List<LogicalExpression> args = new ArrayList<LogicalExpression>();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:848:2: ( ^( FUNC_EVAL func_name ( real_arg[$plan] )* ) | ^( INVOKER_FUNC_EVAL package_name= IDENTIFIER function_name= IDENTIFIER is_static= IDENTIFIER ( real_arg[$plan] )* ) )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==FUNC_EVAL) ) {
                alt59=1;
            }
            else if ( (LA59_0==INVOKER_FUNC_EVAL) ) {
                alt59=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;

            }
            switch (alt59) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:848:4: ^( FUNC_EVAL func_name ( real_arg[$plan] )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FUNC_EVAL190=(CommonTree)match(input,FUNC_EVAL,FOLLOW_FUNC_EVAL_in_func_eval2666); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FUNC_EVAL190_tree = (CommonTree)adaptor.dupNode(FUNC_EVAL190);


                    root_1 = (CommonTree)adaptor.becomeRoot(FUNC_EVAL190_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_name_in_func_eval2668);
                    func_name191=func_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_name191.getTree());


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:848:27: ( real_arg[$plan] )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==BIGDECIMALNUMBER||LA57_0==BIGINTEGERNUMBER||LA57_0==CUBE||LA57_0==DIV||LA57_0==DOLLARVAR||LA57_0==DOUBLENUMBER||LA57_0==FALSE||LA57_0==FLOATNUMBER||LA57_0==GROUP||LA57_0==IDENTIFIER||LA57_0==INTEGER||LA57_0==LONGINTEGER||LA57_0==MINUS||LA57_0==NULL||LA57_0==PERCENT||LA57_0==PLUS||LA57_0==QUOTEDSTRING||LA57_0==STAR||LA57_0==TRUE||(LA57_0 >= BAG_VAL && LA57_0 <= BIN_EXPR)||(LA57_0 >= CASE_COND && LA57_0 <= CASE_EXPR)||(LA57_0 >= CAST_EXPR && LA57_0 <= EXPR_IN_PAREN)||LA57_0==FUNC_EVAL||LA57_0==INVOKER_FUNC_EVAL||(LA57_0 >= MAP_VAL && LA57_0 <= NEG)||LA57_0==TUPLE_VAL) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:848:29: real_arg[$plan]
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_real_arg_in_func_eval2672);
                    	    real_arg192=real_arg(plan);

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, real_arg192.getTree());


                    	    if ( state.backtracking==0 ) { args.add( (real_arg192!=null?real_arg192.expr:null) ); }

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop57;
                        }
                    } while (true);


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           SourceLocation loc = new SourceLocation( (PigParserNode)(func_name191!=null?((CommonTree)func_name191.start):null) );
                           retval.expr = builder.buildUDF( loc, plan, (func_name191!=null?func_name191.funcName:null), args );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:853:4: ^( INVOKER_FUNC_EVAL package_name= IDENTIFIER function_name= IDENTIFIER is_static= IDENTIFIER ( real_arg[$plan] )* )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    INVOKER_FUNC_EVAL193=(CommonTree)match(input,INVOKER_FUNC_EVAL,FOLLOW_INVOKER_FUNC_EVAL_in_func_eval2692); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INVOKER_FUNC_EVAL193_tree = (CommonTree)adaptor.dupNode(INVOKER_FUNC_EVAL193);


                    root_1 = (CommonTree)adaptor.becomeRoot(INVOKER_FUNC_EVAL193_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    package_name=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_func_eval2696); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    package_name_tree = (CommonTree)adaptor.dupNode(package_name);


                    adaptor.addChild(root_1, package_name_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    function_name=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_func_eval2700); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    function_name_tree = (CommonTree)adaptor.dupNode(function_name);


                    adaptor.addChild(root_1, function_name_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    is_static=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_func_eval2704); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    is_static_tree = (CommonTree)adaptor.dupNode(is_static);


                    adaptor.addChild(root_1, is_static_tree);
                    }


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:853:95: ( real_arg[$plan] )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==BIGDECIMALNUMBER||LA58_0==BIGINTEGERNUMBER||LA58_0==CUBE||LA58_0==DIV||LA58_0==DOLLARVAR||LA58_0==DOUBLENUMBER||LA58_0==FALSE||LA58_0==FLOATNUMBER||LA58_0==GROUP||LA58_0==IDENTIFIER||LA58_0==INTEGER||LA58_0==LONGINTEGER||LA58_0==MINUS||LA58_0==NULL||LA58_0==PERCENT||LA58_0==PLUS||LA58_0==QUOTEDSTRING||LA58_0==STAR||LA58_0==TRUE||(LA58_0 >= BAG_VAL && LA58_0 <= BIN_EXPR)||(LA58_0 >= CASE_COND && LA58_0 <= CASE_EXPR)||(LA58_0 >= CAST_EXPR && LA58_0 <= EXPR_IN_PAREN)||LA58_0==FUNC_EVAL||LA58_0==INVOKER_FUNC_EVAL||(LA58_0 >= MAP_VAL && LA58_0 <= NEG)||LA58_0==TUPLE_VAL) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:853:97: real_arg[$plan]
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_real_arg_in_func_eval2708);
                    	    real_arg194=real_arg(plan);

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_1, real_arg194.getTree());


                    	    if ( state.backtracking==0 ) { args.add( (real_arg194!=null?real_arg194.expr:null) ); }

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    break loop58;
                        }
                    } while (true);


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           SourceLocation loc = new SourceLocation( (PigParserNode)function_name );
                           retval.expr = builder.buildInvokerUDF( loc, plan, (package_name!=null?package_name.getText():null), (function_name!=null?function_name.getText():null), Boolean.parseBoolean((is_static!=null?is_static.getText():null)), args );
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
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "real_arg"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:860:1: real_arg[LogicalExpressionPlan plan] returns [LogicalExpression expr] : (e= expr[$plan] | STAR |cr= col_range[$plan] );
    public final LogicalPlanGenerator.real_arg_return real_arg(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.real_arg_return retval = new LogicalPlanGenerator.real_arg_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR195=null;
        LogicalPlanGenerator.expr_return e =null;

        LogicalPlanGenerator.col_range_return cr =null;


        CommonTree STAR195_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:861:2: (e= expr[$plan] | STAR |cr= col_range[$plan] )
            int alt60=3;
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
                alt60=1;
                }
                break;
            case STAR:
                {
                int LA60_2 = input.LA(2);

                if ( (LA60_2==DOWN) ) {
                    alt60=1;
                }
                else if ( (LA60_2==EOF||LA60_2==UP||LA60_2==BIGDECIMALNUMBER||LA60_2==BIGINTEGERNUMBER||LA60_2==CUBE||LA60_2==DIV||LA60_2==DOLLARVAR||LA60_2==DOUBLENUMBER||LA60_2==FALSE||LA60_2==FLOATNUMBER||LA60_2==GROUP||LA60_2==IDENTIFIER||LA60_2==INTEGER||LA60_2==LONGINTEGER||LA60_2==MINUS||LA60_2==NULL||LA60_2==PERCENT||LA60_2==PLUS||LA60_2==QUOTEDSTRING||LA60_2==STAR||LA60_2==TRUE||(LA60_2 >= BAG_VAL && LA60_2 <= BIN_EXPR)||(LA60_2 >= CASE_COND && LA60_2 <= CASE_EXPR)||(LA60_2 >= CAST_EXPR && LA60_2 <= EXPR_IN_PAREN)||LA60_2==FUNC_EVAL||LA60_2==INVOKER_FUNC_EVAL||(LA60_2 >= MAP_VAL && LA60_2 <= NEG)||LA60_2==TUPLE_VAL) ) {
                    alt60=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 60, 2, input);

                    throw nvae;

                }
                }
                break;
            case COL_RANGE:
                {
                alt60=3;
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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:861:4: e= expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_real_arg2740);
                    e=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, e.getTree());


                    if ( state.backtracking==0 ) { retval.expr = (e!=null?e.expr:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:862:4: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR195=(CommonTree)match(input,STAR,FOLLOW_STAR_in_real_arg2748); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR195_tree = (CommonTree)adaptor.dupNode(STAR195);


                    adaptor.addChild(root_0, STAR195_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR195 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                               ((statement_scope)statement_stack.peek()).inputIndex, null, -1 );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:867:4: cr= col_range[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_real_arg2762);
                    cr=col_range(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, cr.getTree());


                    if ( state.backtracking==0 ) { retval.expr = (cr!=null?cr.expr:null);}

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
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expr"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:870:1: expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ( ^( PLUS left= expr[$plan] right= expr[$plan] ) | ^( MINUS left= expr[$plan] right= expr[$plan] ) | ^( STAR left= expr[$plan] right= expr[$plan] ) | ^( DIV left= expr[$plan] right= expr[$plan] ) | ^( PERCENT left= expr[$plan] right= expr[$plan] ) | const_expr[$plan] | var_expr[$plan] | ^( NEG e= expr[$plan] ) | ^( CAST_EXPR type_cast e= expr[$plan] ) | ^( EXPR_IN_PAREN e= expr[$plan] ) );
    public final LogicalPlanGenerator.expr_return expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.expr_return retval = new LogicalPlanGenerator.expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PLUS196=null;
        CommonTree MINUS197=null;
        CommonTree STAR198=null;
        CommonTree DIV199=null;
        CommonTree PERCENT200=null;
        CommonTree NEG203=null;
        CommonTree CAST_EXPR204=null;
        CommonTree EXPR_IN_PAREN206=null;
        LogicalPlanGenerator.expr_return left =null;

        LogicalPlanGenerator.expr_return right =null;

        LogicalPlanGenerator.expr_return e =null;

        LogicalPlanGenerator.const_expr_return const_expr201 =null;

        LogicalPlanGenerator.var_expr_return var_expr202 =null;

        LogicalPlanGenerator.type_cast_return type_cast205 =null;


        CommonTree PLUS196_tree=null;
        CommonTree MINUS197_tree=null;
        CommonTree STAR198_tree=null;
        CommonTree DIV199_tree=null;
        CommonTree PERCENT200_tree=null;
        CommonTree NEG203_tree=null;
        CommonTree CAST_EXPR204_tree=null;
        CommonTree EXPR_IN_PAREN206_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:871:2: ( ^( PLUS left= expr[$plan] right= expr[$plan] ) | ^( MINUS left= expr[$plan] right= expr[$plan] ) | ^( STAR left= expr[$plan] right= expr[$plan] ) | ^( DIV left= expr[$plan] right= expr[$plan] ) | ^( PERCENT left= expr[$plan] right= expr[$plan] ) | const_expr[$plan] | var_expr[$plan] | ^( NEG e= expr[$plan] ) | ^( CAST_EXPR type_cast e= expr[$plan] ) | ^( EXPR_IN_PAREN e= expr[$plan] ) )
            int alt61=10;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt61=1;
                }
                break;
            case MINUS:
                {
                int LA61_2 = input.LA(2);

                if ( (LA61_2==DOWN) ) {
                    alt61=2;
                }
                else if ( (LA61_2==BIGDECIMALNUMBER||LA61_2==BIGINTEGERNUMBER||LA61_2==DOUBLENUMBER||LA61_2==FLOATNUMBER||LA61_2==INTEGER||LA61_2==LONGINTEGER) ) {
                    alt61=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 61, 2, input);

                    throw nvae;

                }
                }
                break;
            case STAR:
                {
                alt61=3;
                }
                break;
            case DIV:
                {
                alt61=4;
                }
                break;
            case PERCENT:
                {
                alt61=5;
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
                alt61=6;
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
                alt61=7;
                }
                break;
            case NEG:
                {
                alt61=8;
                }
                break;
            case CAST_EXPR:
                {
                alt61=9;
                }
                break;
            case EXPR_IN_PAREN:
                {
                alt61=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;

            }

            switch (alt61) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:871:4: ^( PLUS left= expr[$plan] right= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PLUS196=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expr2781); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PLUS196_tree = (CommonTree)adaptor.dupNode(PLUS196);


                    root_1 = (CommonTree)adaptor.becomeRoot(PLUS196_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2787);
                    left=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2794);
                    right=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new AddExpression( plan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)PLUS196 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:876:4: ^( MINUS left= expr[$plan] right= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    MINUS197=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expr2809); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS197_tree = (CommonTree)adaptor.dupNode(MINUS197);


                    root_1 = (CommonTree)adaptor.becomeRoot(MINUS197_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2815);
                    left=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2822);
                    right=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new SubtractExpression( plan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)MINUS197 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:881:4: ^( STAR left= expr[$plan] right= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    STAR198=(CommonTree)match(input,STAR,FOLLOW_STAR_in_expr2837); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR198_tree = (CommonTree)adaptor.dupNode(STAR198);


                    root_1 = (CommonTree)adaptor.becomeRoot(STAR198_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2843);
                    left=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2850);
                    right=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new MultiplyExpression( plan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)STAR198 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:886:4: ^( DIV left= expr[$plan] right= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    DIV199=(CommonTree)match(input,DIV,FOLLOW_DIV_in_expr2865); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DIV199_tree = (CommonTree)adaptor.dupNode(DIV199);


                    root_1 = (CommonTree)adaptor.becomeRoot(DIV199_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2871);
                    left=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2878);
                    right=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new DivideExpression( plan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)DIV199 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:891:4: ^( PERCENT left= expr[$plan] right= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    PERCENT200=(CommonTree)match(input,PERCENT,FOLLOW_PERCENT_in_expr2893); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PERCENT200_tree = (CommonTree)adaptor.dupNode(PERCENT200);


                    root_1 = (CommonTree)adaptor.becomeRoot(PERCENT200_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2899);
                    left=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, left.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2906);
                    right=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, right.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new ModExpression( plan, (left!=null?left.expr:null), (right!=null?right.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)PERCENT200 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:896:4: const_expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_const_expr_in_expr2919);
                    const_expr201=const_expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, const_expr201.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (const_expr201!=null?const_expr201.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:900:4: var_expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_var_expr_in_expr2930);
                    var_expr202=var_expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, var_expr202.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (var_expr202!=null?var_expr202.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:904:4: ^( NEG e= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NEG203=(CommonTree)match(input,NEG,FOLLOW_NEG_in_expr2943); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NEG203_tree = (CommonTree)adaptor.dupNode(NEG203);


                    root_1 = (CommonTree)adaptor.becomeRoot(NEG203_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2949);
                    e=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new NegativeExpression( plan, (e!=null?e.expr:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(e!=null?((CommonTree)e.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:909:4: ^( CAST_EXPR type_cast e= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    CAST_EXPR204=(CommonTree)match(input,CAST_EXPR,FOLLOW_CAST_EXPR_in_expr2964); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CAST_EXPR204_tree = (CommonTree)adaptor.dupNode(CAST_EXPR204);


                    root_1 = (CommonTree)adaptor.becomeRoot(CAST_EXPR204_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_type_cast_in_expr2966);
                    type_cast205=type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, type_cast205.getTree());


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2972);
                    e=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = new CastExpression( plan, (e!=null?e.expr:null), (type_cast205!=null?type_cast205.fieldSchema:null) );
                           retval.expr.setLocation( new SourceLocation( (PigParserNode)(type_cast205!=null?((CommonTree)type_cast205.start):null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:914:4: ^( EXPR_IN_PAREN e= expr[$plan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    EXPR_IN_PAREN206=(CommonTree)match(input,EXPR_IN_PAREN,FOLLOW_EXPR_IN_PAREN_in_expr2988); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXPR_IN_PAREN206_tree = (CommonTree)adaptor.dupNode(EXPR_IN_PAREN206);


                    root_1 = (CommonTree)adaptor.becomeRoot(EXPR_IN_PAREN206_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_expr2994);
                    e=expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, e.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = (e!=null?e.expr:null);
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
        public LogicalFieldSchema fieldSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type_cast"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:920:1: type_cast returns [LogicalFieldSchema fieldSchema] : ( simple_type | map_type | tuple_type_cast | bag_type_cast );
    public final LogicalPlanGenerator.type_cast_return type_cast() throws RecognitionException {
        LogicalPlanGenerator.type_cast_return retval = new LogicalPlanGenerator.type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.simple_type_return simple_type207 =null;

        LogicalPlanGenerator.map_type_return map_type208 =null;

        LogicalPlanGenerator.tuple_type_cast_return tuple_type_cast209 =null;

        LogicalPlanGenerator.bag_type_cast_return bag_type_cast210 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:921:2: ( simple_type | map_type | tuple_type_cast | bag_type_cast )
            int alt62=4;
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
                alt62=1;
                }
                break;
            case MAP_TYPE:
                {
                alt62=2;
                }
                break;
            case TUPLE_TYPE_CAST:
                {
                alt62=3;
                }
                break;
            case BAG_TYPE_CAST:
                {
                alt62=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;

            }

            switch (alt62) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:921:4: simple_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_simple_type_in_type_cast3016);
                    simple_type207=simple_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, simple_type207.getTree());


                    if ( state.backtracking==0 ) {
                            retval.fieldSchema = new LogicalFieldSchema( null, null, (simple_type207!=null?simple_type207.datatype:0) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:925:4: map_type
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_type_in_type_cast3026);
                    map_type208=map_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map_type208.getTree());


                    if ( state.backtracking==0 ) {
                           retval.fieldSchema = new LogicalFieldSchema( null, (map_type208!=null?map_type208.logicalSchema:null), DataType.MAP );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:929:4: tuple_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_type_cast_in_type_cast3036);
                    tuple_type_cast209=tuple_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple_type_cast209.getTree());


                    if ( state.backtracking==0 ) {
                           retval.fieldSchema = new LogicalFieldSchema( null, (tuple_type_cast209!=null?tuple_type_cast209.logicalSchema:null), DataType.TUPLE );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:933:4: bag_type_cast
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_type_cast_in_type_cast3046);
                    bag_type_cast210=bag_type_cast();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag_type_cast210.getTree());


                    if ( state.backtracking==0 ) {
                           retval.fieldSchema = new LogicalFieldSchema( null, (bag_type_cast210!=null?bag_type_cast210.logicalSchema:null), DataType.BAG );
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
    // $ANTLR end "type_cast"


    public static class tuple_type_cast_return extends TreeRuleReturnScope {
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple_type_cast"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:939:1: tuple_type_cast returns [LogicalSchema logicalSchema] : ^( TUPLE_TYPE_CAST ( type_cast )* ) ;
    public final LogicalPlanGenerator.tuple_type_cast_return tuple_type_cast() throws RecognitionException {
        LogicalPlanGenerator.tuple_type_cast_return retval = new LogicalPlanGenerator.tuple_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_TYPE_CAST211=null;
        LogicalPlanGenerator.type_cast_return type_cast212 =null;


        CommonTree TUPLE_TYPE_CAST211_tree=null;


            retval.logicalSchema = new LogicalSchema();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:943:2: ( ^( TUPLE_TYPE_CAST ( type_cast )* ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:943:4: ^( TUPLE_TYPE_CAST ( type_cast )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_TYPE_CAST211=(CommonTree)match(input,TUPLE_TYPE_CAST,FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast3071); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_TYPE_CAST211_tree = (CommonTree)adaptor.dupNode(TUPLE_TYPE_CAST211);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_TYPE_CAST211_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:943:23: ( type_cast )*
                loop63:
                do {
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==BIGDECIMAL||LA63_0==BIGINTEGER||LA63_0==BOOLEAN||LA63_0==BYTEARRAY||LA63_0==CHARARRAY||LA63_0==DATETIME||LA63_0==DOUBLE||LA63_0==FLOAT||LA63_0==INT||LA63_0==LONG||LA63_0==BAG_TYPE_CAST||LA63_0==MAP_TYPE||LA63_0==TUPLE_TYPE_CAST) ) {
                        alt63=1;
                    }


                    switch (alt63) {
                	case 1 :
                	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:943:25: type_cast
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_type_cast_in_tuple_type_cast3075);
                	    type_cast212=type_cast();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, type_cast212.getTree());


                	    if ( state.backtracking==0 ) { retval.logicalSchema.addField( (type_cast212!=null?type_cast212.fieldSchema:null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop63;
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
        public LogicalSchema logicalSchema;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag_type_cast"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:946:1: bag_type_cast returns [LogicalSchema logicalSchema] : ^( BAG_TYPE_CAST ( tuple_type_cast )? ) ;
    public final LogicalPlanGenerator.bag_type_cast_return bag_type_cast() throws RecognitionException {
        LogicalPlanGenerator.bag_type_cast_return retval = new LogicalPlanGenerator.bag_type_cast_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_TYPE_CAST213=null;
        LogicalPlanGenerator.tuple_type_cast_return tuple_type_cast214 =null;


        CommonTree BAG_TYPE_CAST213_tree=null;


            retval.logicalSchema = new LogicalSchema();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:950:2: ( ^( BAG_TYPE_CAST ( tuple_type_cast )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:950:4: ^( BAG_TYPE_CAST ( tuple_type_cast )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_TYPE_CAST213=(CommonTree)match(input,BAG_TYPE_CAST,FOLLOW_BAG_TYPE_CAST_in_bag_type_cast3102); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_TYPE_CAST213_tree = (CommonTree)adaptor.dupNode(BAG_TYPE_CAST213);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_TYPE_CAST213_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:950:21: ( tuple_type_cast )?
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==TUPLE_TYPE_CAST) ) {
                    alt64=1;
                }
                switch (alt64) {
                    case 1 :
                        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:950:21: tuple_type_cast
                        {
                        _last = (CommonTree)input.LT(1);
                        pushFollow(FOLLOW_tuple_type_cast_in_bag_type_cast3104);
                        tuple_type_cast214=tuple_type_cast();

                        state._fsp--;
                        if (state.failed) return retval;
                        if ( state.backtracking==0 ) 
                        adaptor.addChild(root_1, tuple_type_cast214.getTree());


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
                   retval.logicalSchema.addField( new LogicalFieldSchema( null, (tuple_type_cast214!=null?tuple_type_cast214.logicalSchema:null), DataType.TUPLE ) );
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
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "var_expr"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:956:1: var_expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : projectable_expr[$plan] ( dot_proj | pound_proj )* ;
    public final LogicalPlanGenerator.var_expr_return var_expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.var_expr_return retval = new LogicalPlanGenerator.var_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.projectable_expr_return projectable_expr215 =null;

        LogicalPlanGenerator.dot_proj_return dot_proj216 =null;

        LogicalPlanGenerator.pound_proj_return pound_proj217 =null;




            List<Object> columns = null;
            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:961:2: ( projectable_expr[$plan] ( dot_proj | pound_proj )* )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:961:4: projectable_expr[$plan] ( dot_proj | pound_proj )*
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_projectable_expr_in_var_expr3131);
            projectable_expr215=projectable_expr(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, projectable_expr215.getTree());


            if ( state.backtracking==0 ) { retval.expr = (projectable_expr215!=null?projectable_expr215.expr:null); }

            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:962:4: ( dot_proj | pound_proj )*
            loop65:
            do {
                int alt65=3;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==PERIOD) ) {
                    alt65=1;
                }
                else if ( (LA65_0==POUND) ) {
                    alt65=2;
                }


                switch (alt65) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:962:6: dot_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_dot_proj_in_var_expr3141);
            	    dot_proj216=dot_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, dot_proj216.getTree());


            	    if ( state.backtracking==0 ) {
            	             columns = (dot_proj216!=null?dot_proj216.cols:null);
            	             boolean processScalar = false;
            	             if( retval.expr instanceof ScalarExpression ) {
            	                 List<Operator> succs = plan.getSuccessors( retval.expr );
            	                 if( succs == null || succs.size() == 0 ) {
            	                     // We haven't process this scalar projection yet. Set the flag so as to process it next.
            	                     // This will handle a projection such as A.u.x, where we need to build ScalarExpression
            	                     // for A.u, while for x, we need to treat it as a normal dereference (on the output of
            	                     // the ScalarExpression.
            	                     processScalar = true;
            	                 }
            	             }

            	             if( processScalar ) {
            	                 // This is a scalar projection.
            	                 ScalarExpression scalarExpr = (ScalarExpression)retval.expr;

            	                 if( (dot_proj216!=null?dot_proj216.cols:null).size() > 1 ) {
            	                     throw new InvalidScalarProjectionException( input, loc, scalarExpr );
            	                 }

            	                 Object val = (dot_proj216!=null?dot_proj216.cols:null).get( 0 );
            	                 int pos = -1;
            	                 LogicalRelationalOperator relOp = (LogicalRelationalOperator)scalarExpr.getImplicitReferencedOperator();
            	                 LogicalSchema schema = null;
            	                 try {
            	                     schema = relOp.getSchema();
            	                 } catch(FrontendException e) {
            	                     throw new PlanGenerationFailureException( input, loc, e );
            	                 }
            	                 if( val instanceof Integer ) {
            	                     pos = (Integer)val;
            	                     if( schema != null && pos >= schema.size() ) {
            	                         throw new InvalidScalarProjectionException( input, loc, scalarExpr );
            	                     }
            	                 } else {
            	                     String colAlias = (String)val;
            	                     pos = schema.getFieldPosition( colAlias );
            	                     if( schema == null || pos == -1 ) {
            	                         throw new InvalidScalarProjectionException( input, loc, scalarExpr );
            	                     }
            	                 }

            	                 ConstantExpression constExpr = new ConstantExpression( plan, pos);
            	                 plan.connect( retval.expr, constExpr );
            	                 constExpr = new ConstantExpression( plan, "filename"); // place holder for file name.
            	                 plan.connect( retval.expr, constExpr );
            	             } else {
            	                 DereferenceExpression e = new DereferenceExpression( plan );
            	                 e.setRawColumns( (dot_proj216!=null?dot_proj216.cols:null) );
            	                 e.setLocation( new SourceLocation( (PigParserNode)(dot_proj216!=null?((CommonTree)dot_proj216.start):null) ) );
            	                 plan.connect( e, retval.expr );
            	                 retval.expr = e;
            	             }
            	         }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;
            	case 2 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1019:6: pound_proj
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_pound_proj_in_var_expr3155);
            	    pound_proj217=pound_proj();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, pound_proj217.getTree());


            	    if ( state.backtracking==0 ) {
            	             MapLookupExpression e = new MapLookupExpression( plan, (pound_proj217!=null?pound_proj217.key:null) );
            	             e.setLocation( new SourceLocation( (PigParserNode)(pound_proj217!=null?((CommonTree)pound_proj217.start):null) ) );
            	             plan.connect( e, retval.expr );
            	             retval.expr = e;
            	         }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);


            if ( state.backtracking==0 ) {
                  if( ( retval.expr instanceof ScalarExpression ) && columns == null ) {
                      throw new InvalidScalarProjectionException( input, loc, (ScalarExpression)retval.expr, " : A column needs to be projected from a relation for it to be used as a scalar" );
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
    // $ANTLR end "var_expr"


    public static class projectable_expr_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "projectable_expr"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1034:1: projectable_expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ( func_eval[$plan] | col_ref[$plan] | bin_expr[$plan] | case_expr[$plan] | case_cond[$plan] );
    public final LogicalPlanGenerator.projectable_expr_return projectable_expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.projectable_expr_return retval = new LogicalPlanGenerator.projectable_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.func_eval_return func_eval218 =null;

        LogicalPlanGenerator.col_ref_return col_ref219 =null;

        LogicalPlanGenerator.bin_expr_return bin_expr220 =null;

        LogicalPlanGenerator.case_expr_return case_expr221 =null;

        LogicalPlanGenerator.case_cond_return case_cond222 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1035:2: ( func_eval[$plan] | col_ref[$plan] | bin_expr[$plan] | case_expr[$plan] | case_cond[$plan] )
            int alt66=5;
            switch ( input.LA(1) ) {
            case FUNC_EVAL:
            case INVOKER_FUNC_EVAL:
                {
                alt66=1;
                }
                break;
            case CUBE:
            case DOLLARVAR:
            case GROUP:
            case IDENTIFIER:
                {
                alt66=2;
                }
                break;
            case BIN_EXPR:
                {
                alt66=3;
                }
                break;
            case CASE_EXPR:
                {
                alt66=4;
                }
                break;
            case CASE_COND:
                {
                alt66=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;

            }

            switch (alt66) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1035:4: func_eval[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_eval_in_projectable_expr3185);
                    func_eval218=func_eval(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, func_eval218.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (func_eval218!=null?func_eval218.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1039:4: col_ref[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_projectable_expr3196);
                    col_ref219=col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref219.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (col_ref219!=null?col_ref219.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1043:4: bin_expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bin_expr_in_projectable_expr3207);
                    bin_expr220=bin_expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bin_expr220.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (bin_expr220!=null?bin_expr220.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1047:4: case_expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_case_expr_in_projectable_expr3218);
                    case_expr221=case_expr(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, case_expr221.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (case_expr221!=null?case_expr221.expr:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1051:4: case_cond[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_case_cond_in_projectable_expr3229);
                    case_cond222=case_cond(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, case_cond222.getTree());


                    if ( state.backtracking==0 ) {
                           retval.expr = (case_cond222!=null?case_cond222.expr:null);
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
    // $ANTLR end "projectable_expr"


    public static class dot_proj_return extends TreeRuleReturnScope {
        public List<Object> cols;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dot_proj"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1057:1: dot_proj returns [List<Object> cols] : ^( PERIOD ( col_alias_or_index )+ ) ;
    public final LogicalPlanGenerator.dot_proj_return dot_proj() throws RecognitionException {
        LogicalPlanGenerator.dot_proj_return retval = new LogicalPlanGenerator.dot_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PERIOD223=null;
        LogicalPlanGenerator.col_alias_or_index_return col_alias_or_index224 =null;


        CommonTree PERIOD223_tree=null;


            retval.cols = new ArrayList<Object>();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1061:2: ( ^( PERIOD ( col_alias_or_index )+ ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1061:4: ^( PERIOD ( col_alias_or_index )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PERIOD223=(CommonTree)match(input,PERIOD,FOLLOW_PERIOD_in_dot_proj3255); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PERIOD223_tree = (CommonTree)adaptor.dupNode(PERIOD223);


            root_1 = (CommonTree)adaptor.becomeRoot(PERIOD223_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1061:14: ( col_alias_or_index )+
            int cnt67=0;
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==CUBE||LA67_0==DOLLARVAR||LA67_0==GROUP||LA67_0==IDENTIFIER) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1061:16: col_alias_or_index
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_alias_or_index_in_dot_proj3259);
            	    col_alias_or_index224=col_alias_or_index();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, col_alias_or_index224.getTree());


            	    if ( state.backtracking==0 ) { retval.cols.add( (col_alias_or_index224!=null?col_alias_or_index224.col:null) ); }

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
        public Object col;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_alias_or_index"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1064:1: col_alias_or_index returns [Object col] : ( col_alias | col_index );
    public final LogicalPlanGenerator.col_alias_or_index_return col_alias_or_index() throws RecognitionException {
        LogicalPlanGenerator.col_alias_or_index_return retval = new LogicalPlanGenerator.col_alias_or_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.col_alias_return col_alias225 =null;

        LogicalPlanGenerator.col_index_return col_index226 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1065:2: ( col_alias | col_index )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==CUBE||LA68_0==GROUP||LA68_0==IDENTIFIER) ) {
                alt68=1;
            }
            else if ( (LA68_0==DOLLARVAR) ) {
                alt68=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;

            }
            switch (alt68) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1065:4: col_alias
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_alias_in_col_alias_or_index3279);
                    col_alias225=col_alias();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_alias225.getTree());


                    if ( state.backtracking==0 ) { retval.col = (col_alias225!=null?col_alias225.col:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1065:43: col_index
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_index_in_col_alias_or_index3285);
                    col_index226=col_index();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_index226.getTree());


                    if ( state.backtracking==0 ) { retval.col = (col_index226!=null?col_index226.col:null); }

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
        public Object col;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_alias"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1068:1: col_alias returns [Object col] : ( GROUP | CUBE | IDENTIFIER );
    public final LogicalPlanGenerator.col_alias_return col_alias() throws RecognitionException {
        LogicalPlanGenerator.col_alias_return retval = new LogicalPlanGenerator.col_alias_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP227=null;
        CommonTree CUBE228=null;
        CommonTree IDENTIFIER229=null;

        CommonTree GROUP227_tree=null;
        CommonTree CUBE228_tree=null;
        CommonTree IDENTIFIER229_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1069:2: ( GROUP | CUBE | IDENTIFIER )
            int alt69=3;
            switch ( input.LA(1) ) {
            case GROUP:
                {
                alt69=1;
                }
                break;
            case CUBE:
                {
                alt69=2;
                }
                break;
            case IDENTIFIER:
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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1069:4: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP227=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_col_alias3300); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP227_tree = (CommonTree)adaptor.dupNode(GROUP227);


                    adaptor.addChild(root_0, GROUP227_tree);
                    }


                    if ( state.backtracking==0 ) { retval.col = (GROUP227!=null?GROUP227.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1070:4: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE228=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_col_alias3307); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE228_tree = (CommonTree)adaptor.dupNode(CUBE228);


                    adaptor.addChild(root_0, CUBE228_tree);
                    }


                    if ( state.backtracking==0 ) { retval.col = (CUBE228!=null?CUBE228.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1071:4: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER229=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_col_alias3314); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER229_tree = (CommonTree)adaptor.dupNode(IDENTIFIER229);


                    adaptor.addChild(root_0, IDENTIFIER229_tree);
                    }


                    if ( state.backtracking==0 ) { retval.col = (IDENTIFIER229!=null?IDENTIFIER229.getText():null); }

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
    // $ANTLR end "col_alias"


    public static class col_index_return extends TreeRuleReturnScope {
        public Integer col;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_index"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1074:1: col_index returns [Integer col] : DOLLARVAR ;
    public final LogicalPlanGenerator.col_index_return col_index() throws RecognitionException {
        LogicalPlanGenerator.col_index_return retval = new LogicalPlanGenerator.col_index_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR230=null;

        CommonTree DOLLARVAR230_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1075:2: ( DOLLARVAR )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1075:4: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR230=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_col_index3329); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR230_tree = (CommonTree)adaptor.dupNode(DOLLARVAR230);


            adaptor.addChild(root_0, DOLLARVAR230_tree);
            }


            if ( state.backtracking==0 ) { retval.col = builder.undollar( (DOLLARVAR230!=null?DOLLARVAR230.getText():null) ); }

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
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_range"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1079:1: col_range[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ^( COL_RANGE (startExpr= col_ref[$plan] )? DOUBLE_PERIOD (endExpr= col_ref[$plan] )? ) ;
    public final LogicalPlanGenerator.col_range_return col_range(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.col_range_return retval = new LogicalPlanGenerator.col_range_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree COL_RANGE231=null;
        CommonTree DOUBLE_PERIOD232=null;
        LogicalPlanGenerator.col_ref_return startExpr =null;

        LogicalPlanGenerator.col_ref_return endExpr =null;


        CommonTree COL_RANGE231_tree=null;
        CommonTree DOUBLE_PERIOD232_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1080:2: ( ^( COL_RANGE (startExpr= col_ref[$plan] )? DOUBLE_PERIOD (endExpr= col_ref[$plan] )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1080:5: ^( COL_RANGE (startExpr= col_ref[$plan] )? DOUBLE_PERIOD (endExpr= col_ref[$plan] )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            COL_RANGE231=(CommonTree)match(input,COL_RANGE,FOLLOW_COL_RANGE_in_col_range3348); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COL_RANGE231_tree = (CommonTree)adaptor.dupNode(COL_RANGE231);


            root_1 = (CommonTree)adaptor.becomeRoot(COL_RANGE231_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1080:17: (startExpr= col_ref[$plan] )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==CUBE||LA70_0==DOLLARVAR||LA70_0==GROUP||LA70_0==IDENTIFIER) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1080:18: startExpr= col_ref[$plan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range3355);
                    startExpr=col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, startExpr.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            DOUBLE_PERIOD232=(CommonTree)match(input,DOUBLE_PERIOD,FOLLOW_DOUBLE_PERIOD_in_col_range3360); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOUBLE_PERIOD232_tree = (CommonTree)adaptor.dupNode(DOUBLE_PERIOD232);


            adaptor.addChild(root_1, DOUBLE_PERIOD232_tree);
            }


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1080:61: (endExpr= col_ref[$plan] )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==CUBE||LA71_0==DOLLARVAR||LA71_0==GROUP||LA71_0==IDENTIFIER) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1080:62: endExpr= col_ref[$plan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_col_range3367);
                    endExpr=col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, endExpr.getTree());


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
                    SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );
                    retval.expr = builder.buildRangeProjectExpr(
                                loc, plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                                ((statement_scope)statement_stack.peek()).inputIndex,
                                (startExpr!=null?startExpr.expr:null),
                                (endExpr!=null?endExpr.expr:null)
                            );
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
        public String key;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pound_proj"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1092:1: pound_proj returns [String key] : ^( POUND ( QUOTEDSTRING | NULL ) ) ;
    public final LogicalPlanGenerator.pound_proj_return pound_proj() throws RecognitionException {
        LogicalPlanGenerator.pound_proj_return retval = new LogicalPlanGenerator.pound_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree POUND233=null;
        CommonTree QUOTEDSTRING234=null;
        CommonTree NULL235=null;

        CommonTree POUND233_tree=null;
        CommonTree QUOTEDSTRING234_tree=null;
        CommonTree NULL235_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1093:2: ( ^( POUND ( QUOTEDSTRING | NULL ) ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1093:4: ^( POUND ( QUOTEDSTRING | NULL ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            POUND233=(CommonTree)match(input,POUND,FOLLOW_POUND_in_pound_proj3393); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            POUND233_tree = (CommonTree)adaptor.dupNode(POUND233);


            root_1 = (CommonTree)adaptor.becomeRoot(POUND233_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1093:13: ( QUOTEDSTRING | NULL )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==QUOTEDSTRING) ) {
                alt72=1;
            }
            else if ( (LA72_0==NULL) ) {
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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1093:15: QUOTEDSTRING
                    {
                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING234=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_pound_proj3397); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING234_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING234);


                    adaptor.addChild(root_1, QUOTEDSTRING234_tree);
                    }


                    if ( state.backtracking==0 ) { retval.key = builder.unquote( (QUOTEDSTRING234!=null?QUOTEDSTRING234.getText():null) ); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1093:80: NULL
                    {
                    _last = (CommonTree)input.LT(1);
                    NULL235=(CommonTree)match(input,NULL,FOLLOW_NULL_in_pound_proj3403); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL235_tree = (CommonTree)adaptor.dupNode(NULL235);


                    adaptor.addChild(root_1, NULL235_tree);
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
    // $ANTLR end "pound_proj"


    public static class bin_expr_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bin_expr"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1096:1: bin_expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ^( BIN_EXPR cond[$plan] e1= expr[$plan] e2= expr[$plan] ) ;
    public final LogicalPlanGenerator.bin_expr_return bin_expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.bin_expr_return retval = new LogicalPlanGenerator.bin_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BIN_EXPR236=null;
        LogicalPlanGenerator.expr_return e1 =null;

        LogicalPlanGenerator.expr_return e2 =null;

        LogicalPlanGenerator.cond_return cond237 =null;


        CommonTree BIN_EXPR236_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1097:2: ( ^( BIN_EXPR cond[$plan] e1= expr[$plan] e2= expr[$plan] ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1097:4: ^( BIN_EXPR cond[$plan] e1= expr[$plan] e2= expr[$plan] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BIN_EXPR236=(CommonTree)match(input,BIN_EXPR,FOLLOW_BIN_EXPR_in_bin_expr3423); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BIN_EXPR236_tree = (CommonTree)adaptor.dupNode(BIN_EXPR236);


            root_1 = (CommonTree)adaptor.becomeRoot(BIN_EXPR236_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_bin_expr3425);
            cond237=cond(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond237.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr3432);
            e1=expr(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, e1.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_expr_in_bin_expr3439);
            e2=expr(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, e2.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.expr = new BinCondExpression( plan, (cond237!=null?cond237.expr:null), (e1!=null?e1.expr:null), (e2!=null?e2.expr:null) );
                   retval.expr.setLocation( new SourceLocation( (PigParserNode)((CommonTree)retval.start) ) );
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
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "case_expr"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1104:1: case_expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ^( CASE_EXPR ( ( ^( CASE_EXPR_LHS lhs= expr[$plan] ) ) ( ^( CASE_EXPR_RHS rhs= expr[$plan] ) )+ )+ ) ;
    public final LogicalPlanGenerator.case_expr_return case_expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.case_expr_return retval = new LogicalPlanGenerator.case_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CASE_EXPR238=null;
        CommonTree CASE_EXPR_LHS239=null;
        CommonTree CASE_EXPR_RHS240=null;
        LogicalPlanGenerator.expr_return lhs =null;

        LogicalPlanGenerator.expr_return rhs =null;


        CommonTree CASE_EXPR238_tree=null;
        CommonTree CASE_EXPR_LHS239_tree=null;
        CommonTree CASE_EXPR_RHS240_tree=null;


            List<LogicalExpression> lhsExprs = new ArrayList<LogicalExpression>();
            List<LogicalExpression> rhsExprs = new ArrayList<LogicalExpression>();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1109:2: ( ^( CASE_EXPR ( ( ^( CASE_EXPR_LHS lhs= expr[$plan] ) ) ( ^( CASE_EXPR_RHS rhs= expr[$plan] ) )+ )+ ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1109:4: ^( CASE_EXPR ( ( ^( CASE_EXPR_LHS lhs= expr[$plan] ) ) ( ^( CASE_EXPR_RHS rhs= expr[$plan] ) )+ )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CASE_EXPR238=(CommonTree)match(input,CASE_EXPR,FOLLOW_CASE_EXPR_in_case_expr3468); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE_EXPR238_tree = (CommonTree)adaptor.dupNode(CASE_EXPR238);


            root_1 = (CommonTree)adaptor.becomeRoot(CASE_EXPR238_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1109:17: ( ( ^( CASE_EXPR_LHS lhs= expr[$plan] ) ) ( ^( CASE_EXPR_RHS rhs= expr[$plan] ) )+ )+
            int cnt74=0;
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==CASE_EXPR_LHS) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1109:19: ( ^( CASE_EXPR_LHS lhs= expr[$plan] ) ) ( ^( CASE_EXPR_RHS rhs= expr[$plan] ) )+
            	    {
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1109:19: ( ^( CASE_EXPR_LHS lhs= expr[$plan] ) )
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1109:21: ^( CASE_EXPR_LHS lhs= expr[$plan] )
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    {
            	    CommonTree _save_last_2 = _last;
            	    CommonTree _first_2 = null;
            	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    _last = (CommonTree)input.LT(1);
            	    CASE_EXPR_LHS239=(CommonTree)match(input,CASE_EXPR_LHS,FOLLOW_CASE_EXPR_LHS_in_case_expr3476); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    CASE_EXPR_LHS239_tree = (CommonTree)adaptor.dupNode(CASE_EXPR_LHS239);


            	    root_2 = (CommonTree)adaptor.becomeRoot(CASE_EXPR_LHS239_tree, root_2);
            	    }


            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_case_expr3482);
            	    lhs=expr(plan);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, lhs.getTree());


            	    if ( state.backtracking==0 ) { lhsExprs.add((lhs!=null?lhs.expr:null)); }

            	    match(input, Token.UP, null); if (state.failed) return retval;
            	    adaptor.addChild(root_1, root_2);
            	    _last = _save_last_2;
            	    }


            	    if ( state.backtracking==0 ) {
            	    }
            	    }


            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1110:19: ( ^( CASE_EXPR_RHS rhs= expr[$plan] ) )+
            	    int cnt73=0;
            	    loop73:
            	    do {
            	        int alt73=2;
            	        int LA73_0 = input.LA(1);

            	        if ( (LA73_0==CASE_EXPR_RHS) ) {
            	            alt73=1;
            	        }


            	        switch (alt73) {
            	    	case 1 :
            	    	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1110:21: ^( CASE_EXPR_RHS rhs= expr[$plan] )
            	    	    {
            	    	    _last = (CommonTree)input.LT(1);
            	    	    {
            	    	    CommonTree _save_last_2 = _last;
            	    	    CommonTree _first_2 = null;
            	    	    CommonTree root_2 = (CommonTree)adaptor.nil();
            	    	    _last = (CommonTree)input.LT(1);
            	    	    CASE_EXPR_RHS240=(CommonTree)match(input,CASE_EXPR_RHS,FOLLOW_CASE_EXPR_RHS_in_case_expr3513); if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) {
            	    	    CASE_EXPR_RHS240_tree = (CommonTree)adaptor.dupNode(CASE_EXPR_RHS240);


            	    	    root_2 = (CommonTree)adaptor.becomeRoot(CASE_EXPR_RHS240_tree, root_2);
            	    	    }


            	    	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    	    _last = (CommonTree)input.LT(1);
            	    	    pushFollow(FOLLOW_expr_in_case_expr3519);
            	    	    rhs=expr(plan);

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) 
            	    	    adaptor.addChild(root_2, rhs.getTree());


            	    	    if ( state.backtracking==0 ) { rhsExprs.add((rhs!=null?rhs.expr:null)); }

            	    	    match(input, Token.UP, null); if (state.failed) return retval;
            	    	    adaptor.addChild(root_1, root_2);
            	    	    _last = _save_last_2;
            	    	    }


            	    	    if ( state.backtracking==0 ) {
            	    	    }
            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt73 >= 1 ) break loop73;
            	    	    if (state.backtracking>0) {state.failed=true; return retval;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(73, input);
            	                throw eee;
            	        }
            	        cnt73++;
            	    } while (true);


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


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                    // Convert CASE tree to nested bincond expressions. Please also see
                    // QueryParser.g for how CASE tree is constructed from case statement.
                    boolean hasElse = rhsExprs.size() % 2 == 1;
                    LogicalExpression elseExpr = hasElse ? rhsExprs.get(rhsExprs.size()-1)
                                                         : new ConstantExpression(plan, null);

                    int numWhenBranches = rhsExprs.size() / 2;
                    BinCondExpression prevBinCondExpr = null;
                    BinCondExpression currBinCondExpr = null;
                    for (int i = 0; i < numWhenBranches; i++) {
                        currBinCondExpr = new BinCondExpression( plan,
                            new EqualExpression( plan, lhsExprs.get(i), rhsExprs.get(2*i) ), rhsExprs.get(2*i+1),
                            prevBinCondExpr == null ? elseExpr : prevBinCondExpr);
                        prevBinCondExpr = currBinCondExpr;
                    }
                    retval.expr = currBinCondExpr;
                    retval.expr.setLocation( new SourceLocation( (PigParserNode)((CommonTree)retval.start) ) );
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
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "case_cond"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1132:1: case_cond[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ^( CASE_COND ^( WHEN ( cond[$plan] )+ ) ^( THEN ( expr[$plan] )+ ) ) ;
    public final LogicalPlanGenerator.case_cond_return case_cond(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.case_cond_return retval = new LogicalPlanGenerator.case_cond_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CASE_COND241=null;
        CommonTree WHEN242=null;
        CommonTree THEN244=null;
        LogicalPlanGenerator.cond_return cond243 =null;

        LogicalPlanGenerator.expr_return expr245 =null;


        CommonTree CASE_COND241_tree=null;
        CommonTree WHEN242_tree=null;
        CommonTree THEN244_tree=null;


            List<LogicalExpression> conds = new ArrayList<LogicalExpression>();
            List<LogicalExpression> exprs = new ArrayList<LogicalExpression>();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1137:2: ( ^( CASE_COND ^( WHEN ( cond[$plan] )+ ) ^( THEN ( expr[$plan] )+ ) ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1137:4: ^( CASE_COND ^( WHEN ( cond[$plan] )+ ) ^( THEN ( expr[$plan] )+ ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CASE_COND241=(CommonTree)match(input,CASE_COND,FOLLOW_CASE_COND_in_case_cond3559); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CASE_COND241_tree = (CommonTree)adaptor.dupNode(CASE_COND241);


            root_1 = (CommonTree)adaptor.becomeRoot(CASE_COND241_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_2 = _last;
            CommonTree _first_2 = null;
            CommonTree root_2 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            WHEN242=(CommonTree)match(input,WHEN,FOLLOW_WHEN_in_case_cond3563); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            WHEN242_tree = (CommonTree)adaptor.dupNode(WHEN242);


            root_2 = (CommonTree)adaptor.becomeRoot(WHEN242_tree, root_2);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1137:25: ( cond[$plan] )+
            int cnt75=0;
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==AND||LA75_0==IN||(LA75_0 >= NOT && LA75_0 <= NUM_OP_NE)||LA75_0==OR||(LA75_0 >= STR_OP_EQ && LA75_0 <= STR_OP_NE)||LA75_0==BOOL_COND||LA75_0==FUNC_EVAL||LA75_0==INVOKER_FUNC_EVAL) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1137:27: cond[$plan]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_cond_in_case_cond3567);
            	    cond243=cond(plan);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, cond243.getTree());


            	    if ( state.backtracking==0 ) { conds.add((cond243!=null?cond243.expr:null)); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt75 >= 1 ) break loop75;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(75, input);
                        throw eee;
                }
                cnt75++;
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
            THEN244=(CommonTree)match(input,THEN,FOLLOW_THEN_in_case_cond3595); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            THEN244_tree = (CommonTree)adaptor.dupNode(THEN244);


            root_2 = (CommonTree)adaptor.becomeRoot(THEN244_tree, root_2);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1138:25: ( expr[$plan] )+
            int cnt76=0;
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==BIGDECIMALNUMBER||LA76_0==BIGINTEGERNUMBER||LA76_0==CUBE||LA76_0==DIV||LA76_0==DOLLARVAR||LA76_0==DOUBLENUMBER||LA76_0==FALSE||LA76_0==FLOATNUMBER||LA76_0==GROUP||LA76_0==IDENTIFIER||LA76_0==INTEGER||LA76_0==LONGINTEGER||LA76_0==MINUS||LA76_0==NULL||LA76_0==PERCENT||LA76_0==PLUS||LA76_0==QUOTEDSTRING||LA76_0==STAR||LA76_0==TRUE||(LA76_0 >= BAG_VAL && LA76_0 <= BIN_EXPR)||(LA76_0 >= CASE_COND && LA76_0 <= CASE_EXPR)||LA76_0==CAST_EXPR||LA76_0==EXPR_IN_PAREN||LA76_0==FUNC_EVAL||LA76_0==INVOKER_FUNC_EVAL||(LA76_0 >= MAP_VAL && LA76_0 <= NEG)||LA76_0==TUPLE_VAL) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1138:27: expr[$plan]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_expr_in_case_cond3599);
            	    expr245=expr(plan);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_2, expr245.getTree());


            	    if ( state.backtracking==0 ) { exprs.add((expr245!=null?expr245.expr:null)); }

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


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_1, root_2);
            _last = _save_last_2;
            }


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                    // Convert CASE tree to nested bincond expressions. Please also see
                    // QueryParser.g for how CASE tree is constructed from case statement.
                    boolean hasElse = exprs.size() != conds.size();
                    LogicalExpression elseExpr = hasElse ? exprs.remove(exprs.size()-1)
                                                         : new ConstantExpression(plan, null);
                    Collections.reverse(exprs);
                    Collections.reverse(conds);
                    int numWhenBranches = conds.size();
                    BinCondExpression prevBinCondExpr = null;
                    BinCondExpression currBinCondExpr = null;
                    for (int i = 0; i < numWhenBranches; i++) {
                        currBinCondExpr = new BinCondExpression( plan,
                            conds.get(i), exprs.get(i),
                            prevBinCondExpr == null ? elseExpr : prevBinCondExpr);
                        prevBinCondExpr = currBinCondExpr;
                    }
                    retval.expr = currBinCondExpr;
                    retval.expr.setLocation( new SourceLocation( (PigParserNode)((CommonTree)retval.start) ) );
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
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "limit_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1161:1: limit_clause returns [String alias] : ^( LIMIT rel ( INTEGER | LONGINTEGER | expr[exprPlan] ) ) ;
    public final LogicalPlanGenerator.limit_clause_return limit_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.limit_clause_return retval = new LogicalPlanGenerator.limit_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT246=null;
        CommonTree INTEGER248=null;
        CommonTree LONGINTEGER249=null;
        LogicalPlanGenerator.rel_return rel247 =null;

        LogicalPlanGenerator.expr_return expr250 =null;


        CommonTree LIMIT246_tree=null;
        CommonTree INTEGER248_tree=null;
        CommonTree LONGINTEGER249_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createLimitOp();
            LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1167:2: ( ^( LIMIT rel ( INTEGER | LONGINTEGER | expr[exprPlan] ) ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1167:5: ^( LIMIT rel ( INTEGER | LONGINTEGER | expr[exprPlan] ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT246=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_limit_clause3641); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT246_tree = (CommonTree)adaptor.dupNode(LIMIT246);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT246_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_limit_clause3643);
            rel247=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel247.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1167:18: ( INTEGER | LONGINTEGER | expr[exprPlan] )
            int alt77=3;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                int LA77_1 = input.LA(2);

                if ( (synpred146_LogicalPlanGenerator()) ) {
                    alt77=1;
                }
                else if ( (true) ) {
                    alt77=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 77, 1, input);

                    throw nvae;

                }
                }
                break;
            case LONGINTEGER:
                {
                int LA77_2 = input.LA(2);

                if ( (synpred147_LogicalPlanGenerator()) ) {
                    alt77=2;
                }
                else if ( (true) ) {
                    alt77=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 77, 2, input);

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
                alt77=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;

            }

            switch (alt77) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1167:20: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER248=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_limit_clause3647); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER248_tree = (CommonTree)adaptor.dupNode(INTEGER248);


                    adaptor.addChild(root_1, INTEGER248_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildLimitOp( new SourceLocation( (PigParserNode)LIMIT246 ),
                             ((statement_scope)statement_stack.peek()).alias, ((statement_scope)statement_stack.peek()).inputAlias, Long.valueOf( (INTEGER248!=null?INTEGER248.getText():null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1172:4: LONGINTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    LONGINTEGER249=(CommonTree)match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_limit_clause3657); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONGINTEGER249_tree = (CommonTree)adaptor.dupNode(LONGINTEGER249);


                    adaptor.addChild(root_1, LONGINTEGER249_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildLimitOp( new SourceLocation( (PigParserNode)LIMIT246 ),
                             ((statement_scope)statement_stack.peek()).alias, ((statement_scope)statement_stack.peek()).inputAlias, builder.parseLong( (LONGINTEGER249!=null?LONGINTEGER249.getText():null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1177:4: expr[exprPlan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_limit_clause3667);
                    expr250=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr250.getTree());


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildLimitOp( new SourceLocation( (PigParserNode)LIMIT246 ),
                               (LOLimit)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias, ((statement_scope)statement_stack.peek()).inputAlias, exprPlan);
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
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "limit_clause"


    public static class sample_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "sample_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1185:1: sample_clause returns [String alias] : ^( SAMPLE rel ( DOUBLENUMBER | expr[exprPlan] ) ) ;
    public final LogicalPlanGenerator.sample_clause_return sample_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.sample_clause_return retval = new LogicalPlanGenerator.sample_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SAMPLE251=null;
        CommonTree DOUBLENUMBER253=null;
        LogicalPlanGenerator.rel_return rel252 =null;

        LogicalPlanGenerator.expr_return expr254 =null;


        CommonTree SAMPLE251_tree=null;
        CommonTree DOUBLENUMBER253_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createSampleOp();
            LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1191:2: ( ^( SAMPLE rel ( DOUBLENUMBER | expr[exprPlan] ) ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1191:4: ^( SAMPLE rel ( DOUBLENUMBER | expr[exprPlan] ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SAMPLE251=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_sample_clause3703); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SAMPLE251_tree = (CommonTree)adaptor.dupNode(SAMPLE251);


            root_1 = (CommonTree)adaptor.becomeRoot(SAMPLE251_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_sample_clause3705);
            rel252=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel252.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1191:18: ( DOUBLENUMBER | expr[exprPlan] )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==DOUBLENUMBER) ) {
                int LA78_1 = input.LA(2);

                if ( (synpred148_LogicalPlanGenerator()) ) {
                    alt78=1;
                }
                else if ( (true) ) {
                    alt78=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 78, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA78_0==BIGDECIMALNUMBER||LA78_0==BIGINTEGERNUMBER||LA78_0==CUBE||LA78_0==DIV||LA78_0==DOLLARVAR||LA78_0==FALSE||LA78_0==FLOATNUMBER||LA78_0==GROUP||LA78_0==IDENTIFIER||LA78_0==INTEGER||LA78_0==LONGINTEGER||LA78_0==MINUS||LA78_0==NULL||LA78_0==PERCENT||LA78_0==PLUS||LA78_0==QUOTEDSTRING||LA78_0==STAR||LA78_0==TRUE||(LA78_0 >= BAG_VAL && LA78_0 <= BIN_EXPR)||(LA78_0 >= CASE_COND && LA78_0 <= CASE_EXPR)||LA78_0==CAST_EXPR||LA78_0==EXPR_IN_PAREN||LA78_0==FUNC_EVAL||LA78_0==INVOKER_FUNC_EVAL||(LA78_0 >= MAP_VAL && LA78_0 <= NEG)||LA78_0==TUPLE_VAL) ) {
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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1191:20: DOUBLENUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    DOUBLENUMBER253=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_sample_clause3709); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLENUMBER253_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER253);


                    adaptor.addChild(root_1, DOUBLENUMBER253_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildSampleOp( new SourceLocation( (PigParserNode)SAMPLE251 ), ((statement_scope)statement_stack.peek()).alias,
                               ((statement_scope)statement_stack.peek()).inputAlias, Double.valueOf( (DOUBLENUMBER253!=null?DOUBLENUMBER253.getText():null) ),
                               new SourceLocation( (PigParserNode)DOUBLENUMBER253 ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1197:4: expr[exprPlan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_sample_clause3719);
                    expr254=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr254.getTree());


                    if ( state.backtracking==0 ) {
                           retval.alias = builder.buildSampleOp( new SourceLocation( (PigParserNode)SAMPLE251 ),
                               (LOFilter)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias, ((statement_scope)statement_stack.peek()).inputAlias, exprPlan, (expr254!=null?expr254.expr:null));
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
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "sample_clause"


    protected static class rank_clause_scope {
        LORank rankOp;
    }
    protected Stack rank_clause_stack = new Stack();


    public static class rank_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1205:1: rank_clause returns [String alias] : ^( RANK rel ( rank_by_statement )? ) ;
    public final LogicalPlanGenerator.rank_clause_return rank_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());
        rank_clause_stack.push(new rank_clause_scope());
        LogicalPlanGenerator.rank_clause_return retval = new LogicalPlanGenerator.rank_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree RANK255=null;
        LogicalPlanGenerator.rel_return rel256 =null;

        LogicalPlanGenerator.rank_by_statement_return rank_by_statement257 =null;


        CommonTree RANK255_tree=null;


        	((GScope_scope)GScope_stack.peek()).currentOp = builder.createRankOp();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1215:2: ( ^( RANK rel ( rank_by_statement )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1215:4: ^( RANK rel ( rank_by_statement )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            RANK255=(CommonTree)match(input,RANK,FOLLOW_RANK_in_rank_clause3765); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RANK255_tree = (CommonTree)adaptor.dupNode(RANK255);


            root_1 = (CommonTree)adaptor.becomeRoot(RANK255_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_rank_clause3767);
            rel256=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel256.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1215:16: ( rank_by_statement )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==BY) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1215:16: rank_by_statement
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rank_by_statement_in_rank_clause3769);
                    rank_by_statement257=rank_by_statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, rank_by_statement257.getTree());


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
            	SourceLocation loc = new SourceLocation( (PigParserNode) ((CommonTree)retval.start) );

            	List<LogicalExpressionPlan> tempPlans = (rank_by_statement257!=null?rank_by_statement257.plans:null);
            	List<Boolean> tempAscFlags = (rank_by_statement257!=null?rank_by_statement257.ascFlags:null);

            	if(tempPlans == null && tempAscFlags == null) {
            		tempPlans = new ArrayList<LogicalExpressionPlan>();
            		tempAscFlags = new ArrayList<Boolean>();

            		((LORank)((GScope_scope)GScope_stack.peek()).currentOp).setIsRowNumber( true );
            	}

            	((LORank)((GScope_scope)GScope_stack.peek()).currentOp).setIsDenseRank( (rank_by_statement257!=null?rank_by_statement257.isDenseRank:null) != null?(rank_by_statement257!=null?rank_by_statement257.isDenseRank:null):false );

            	retval.alias = builder.buildRankOp( loc, (LORank)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias, ((statement_scope)statement_stack.peek()).inputAlias, tempPlans, tempAscFlags );
             }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) {
            }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();
            rank_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "rank_clause"


    public static class rank_by_statement_return extends TreeRuleReturnScope {
        public List<LogicalExpressionPlan> plans;
        public List<Boolean> ascFlags;
        public Boolean isDenseRank;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_by_statement"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1235:1: rank_by_statement returns [List<LogicalExpressionPlan> plans, List<Boolean> ascFlags, Boolean isDenseRank] : ^( BY rank_by_clause ( DENSE )? ) ;
    public final LogicalPlanGenerator.rank_by_statement_return rank_by_statement() throws RecognitionException {
        LogicalPlanGenerator.rank_by_statement_return retval = new LogicalPlanGenerator.rank_by_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY258=null;
        CommonTree DENSE260=null;
        LogicalPlanGenerator.rank_by_clause_return rank_by_clause259 =null;


        CommonTree BY258_tree=null;
        CommonTree DENSE260_tree=null;


            retval.plans = new ArrayList<LogicalExpressionPlan>();
            retval.ascFlags = new ArrayList<Boolean>();
            retval.isDenseRank = false;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1241:2: ( ^( BY rank_by_clause ( DENSE )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1241:4: ^( BY rank_by_clause ( DENSE )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY258=(CommonTree)match(input,BY,FOLLOW_BY_in_rank_by_statement3795); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY258_tree = (CommonTree)adaptor.dupNode(BY258);


            root_1 = (CommonTree)adaptor.becomeRoot(BY258_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rank_by_clause_in_rank_by_statement3797);
            rank_by_clause259=rank_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rank_by_clause259.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1241:25: ( DENSE )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==DENSE) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1241:27: DENSE
                    {
                    _last = (CommonTree)input.LT(1);
                    DENSE260=(CommonTree)match(input,DENSE,FOLLOW_DENSE_in_rank_by_statement3801); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DENSE260_tree = (CommonTree)adaptor.dupNode(DENSE260);


                    adaptor.addChild(root_1, DENSE260_tree);
                    }


                    if ( state.backtracking==0 ) { retval.isDenseRank =  true; }

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
            	retval.plans = (rank_by_clause259!=null?rank_by_clause259.plans:null);
            	retval.ascFlags = (rank_by_clause259!=null?rank_by_clause259.ascFlags:null);
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
        public List<LogicalExpressionPlan> plans;
        public List<Boolean> ascFlags;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_by_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1248:1: rank_by_clause returns [List<LogicalExpressionPlan> plans, List<Boolean> ascFlags] : ( STAR ( ASC | DESC )? | ( rank_col )+ );
    public final LogicalPlanGenerator.rank_by_clause_return rank_by_clause() throws RecognitionException {
        LogicalPlanGenerator.rank_by_clause_return retval = new LogicalPlanGenerator.rank_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR261=null;
        CommonTree ASC262=null;
        CommonTree DESC263=null;
        LogicalPlanGenerator.rank_col_return rank_col264 =null;


        CommonTree STAR261_tree=null;
        CommonTree ASC262_tree=null;
        CommonTree DESC263_tree=null;


            retval.plans = new ArrayList<LogicalExpressionPlan>();
            retval.ascFlags = new ArrayList<Boolean>();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1253:2: ( STAR ( ASC | DESC )? | ( rank_col )+ )
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==STAR) ) {
                alt83=1;
            }
            else if ( (LA83_0==CUBE||LA83_0==DOLLARVAR||LA83_0==GROUP||LA83_0==IDENTIFIER||LA83_0==COL_RANGE) ) {
                alt83=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;

            }
            switch (alt83) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1253:4: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR261=(CommonTree)match(input,STAR,FOLLOW_STAR_in_rank_by_clause3830); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR261_tree = (CommonTree)adaptor.dupNode(STAR261);


                    adaptor.addChild(root_0, STAR261_tree);
                    }


                    if ( state.backtracking==0 ) {
                    		LogicalExpressionPlan plan = new LogicalExpressionPlan();
                    		builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR261 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).inputIndex, null, -1 );
                    		retval.plans.add( plan );
                       }

                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1258:4: ( ASC | DESC )?
                    int alt81=3;
                    int LA81_0 = input.LA(1);

                    if ( (LA81_0==ASC) ) {
                        alt81=1;
                    }
                    else if ( (LA81_0==DESC) ) {
                        alt81=2;
                    }
                    switch (alt81) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1258:6: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC262=(CommonTree)match(input,ASC,FOLLOW_ASC_in_rank_by_clause3839); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC262_tree = (CommonTree)adaptor.dupNode(ASC262);


                            adaptor.addChild(root_0, ASC262_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlags.add( true ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1258:39: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC263=(CommonTree)match(input,DESC,FOLLOW_DESC_in_rank_by_clause3845); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC263_tree = (CommonTree)adaptor.dupNode(DESC263);


                            adaptor.addChild(root_0, DESC263_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlags.add( false ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1259:4: ( rank_col )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1259:4: ( rank_col )+
                    int cnt82=0;
                    loop82:
                    do {
                        int alt82=2;
                        int LA82_0 = input.LA(1);

                        if ( (LA82_0==CUBE||LA82_0==DOLLARVAR||LA82_0==GROUP||LA82_0==IDENTIFIER||LA82_0==COL_RANGE) ) {
                            alt82=1;
                        }


                        switch (alt82) {
                    	case 1 :
                    	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1259:6: rank_col
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_rank_col_in_rank_by_clause3857);
                    	    rank_col264=rank_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, rank_col264.getTree());


                    	    if ( state.backtracking==0 ) {
                    	           retval.plans.add( (rank_col264!=null?rank_col264.plan:null) );
                    	           retval.ascFlags.add( (rank_col264!=null?rank_col264.ascFlag:null) );
                    	       }

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
        public LogicalExpressionPlan plan;
        public Boolean ascFlag;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rank_col"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1266:1: rank_col returns [LogicalExpressionPlan plan, Boolean ascFlag] : ( col_range[$plan] ( ASC | DESC )? | col_ref[$plan] ( ASC | DESC )? );
    public final LogicalPlanGenerator.rank_col_return rank_col() throws RecognitionException {
        LogicalPlanGenerator.rank_col_return retval = new LogicalPlanGenerator.rank_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ASC266=null;
        CommonTree DESC267=null;
        CommonTree ASC269=null;
        CommonTree DESC270=null;
        LogicalPlanGenerator.col_range_return col_range265 =null;

        LogicalPlanGenerator.col_ref_return col_ref268 =null;


        CommonTree ASC266_tree=null;
        CommonTree DESC267_tree=null;
        CommonTree ASC269_tree=null;
        CommonTree DESC270_tree=null;


            retval.plan = new LogicalExpressionPlan();
            retval.ascFlag = true;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1271:2: ( col_range[$plan] ( ASC | DESC )? | col_ref[$plan] ( ASC | DESC )? )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==COL_RANGE) ) {
                alt86=1;
            }
            else if ( (LA86_0==CUBE||LA86_0==DOLLARVAR||LA86_0==GROUP||LA86_0==IDENTIFIER) ) {
                alt86=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;

            }
            switch (alt86) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1271:4: col_range[$plan] ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_rank_col3883);
                    col_range265=col_range(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range265.getTree());


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1271:21: ( ASC | DESC )?
                    int alt84=3;
                    int LA84_0 = input.LA(1);

                    if ( (LA84_0==ASC) ) {
                        alt84=1;
                    }
                    else if ( (LA84_0==DESC) ) {
                        alt84=2;
                    }
                    switch (alt84) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1271:22: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC266=(CommonTree)match(input,ASC,FOLLOW_ASC_in_rank_col3887); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC266_tree = (CommonTree)adaptor.dupNode(ASC266);


                            adaptor.addChild(root_0, ASC266_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1271:28: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC267=(CommonTree)match(input,DESC,FOLLOW_DESC_in_rank_col3891); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC267_tree = (CommonTree)adaptor.dupNode(DESC267);


                            adaptor.addChild(root_0, DESC267_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlag = false; }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1272:4: col_ref[$plan] ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_rank_col3901);
                    col_ref268=col_ref(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref268.getTree());


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1272:19: ( ASC | DESC )?
                    int alt85=3;
                    int LA85_0 = input.LA(1);

                    if ( (LA85_0==ASC) ) {
                        alt85=1;
                    }
                    else if ( (LA85_0==DESC) ) {
                        alt85=2;
                    }
                    switch (alt85) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1272:21: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC269=(CommonTree)match(input,ASC,FOLLOW_ASC_in_rank_col3906); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC269_tree = (CommonTree)adaptor.dupNode(ASC269);


                            adaptor.addChild(root_0, ASC269_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1272:27: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC270=(CommonTree)match(input,DESC,FOLLOW_DESC_in_rank_col3910); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC270_tree = (CommonTree)adaptor.dupNode(DESC270);


                            adaptor.addChild(root_0, DESC270_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlag = false; }

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
    // $ANTLR end "rank_col"


    public static class order_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1275:1: order_clause returns [String alias] : ^( ORDER rel order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? ) ;
    public final LogicalPlanGenerator.order_clause_return order_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.order_clause_return retval = new LogicalPlanGenerator.order_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER271=null;
        LogicalPlanGenerator.rel_return rel272 =null;

        LogicalPlanGenerator.order_by_clause_return order_by_clause273 =null;

        LogicalPlanGenerator.func_clause_return func_clause274 =null;


        CommonTree ORDER271_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createSortOp();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1280:2: ( ^( ORDER rel order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1280:4: ^( ORDER rel order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER271=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_order_clause3940); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER271_tree = (CommonTree)adaptor.dupNode(ORDER271);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER271_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_order_clause3942);
            rel272=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel272.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_order_clause3944);
            order_by_clause273=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause273.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1280:33: ( func_clause[FunctionType.COMPARISONFUNC] )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==FUNC||LA87_0==FUNC_REF) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1280:33: func_clause[FunctionType.COMPARISONFUNC]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_order_clause3946);
                    func_clause274=func_clause(FunctionType.COMPARISONFUNC);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause274.getTree());


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
                   SourceLocation loc = new SourceLocation( (PigParserNode)ORDER271 );
                   retval.alias = builder.buildSortOp( loc, (LOSort)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias,
                       ((statement_scope)statement_stack.peek()).inputAlias, (order_by_clause273!=null?order_by_clause273.plans:null),
                       (order_by_clause273!=null?order_by_clause273.ascFlags:null), (func_clause274!=null?func_clause274.funcSpec:null) );
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
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "order_clause"


    public static class order_by_clause_return extends TreeRuleReturnScope {
        public List<LogicalExpressionPlan> plans;
        public List<Boolean> ascFlags;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_by_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1289:1: order_by_clause returns [List<LogicalExpressionPlan> plans, List<Boolean> ascFlags] : ( STAR ( ASC | DESC )? | ( order_col )+ );
    public final LogicalPlanGenerator.order_by_clause_return order_by_clause() throws RecognitionException {
        LogicalPlanGenerator.order_by_clause_return retval = new LogicalPlanGenerator.order_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR275=null;
        CommonTree ASC276=null;
        CommonTree DESC277=null;
        LogicalPlanGenerator.order_col_return order_col278 =null;


        CommonTree STAR275_tree=null;
        CommonTree ASC276_tree=null;
        CommonTree DESC277_tree=null;


            retval.plans = new ArrayList<LogicalExpressionPlan>();
            retval.ascFlags = new ArrayList<Boolean>();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1294:2: ( STAR ( ASC | DESC )? | ( order_col )+ )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==STAR) ) {
                alt90=1;
            }
            else if ( (LA90_0==CUBE||LA90_0==DOLLARVAR||LA90_0==GROUP||LA90_0==IDENTIFIER||LA90_0==COL_RANGE) ) {
                alt90=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;

            }
            switch (alt90) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1294:4: STAR ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR275=(CommonTree)match(input,STAR,FOLLOW_STAR_in_order_by_clause3973); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR275_tree = (CommonTree)adaptor.dupNode(STAR275);


                    adaptor.addChild(root_0, STAR275_tree);
                    }


                    if ( state.backtracking==0 ) {
                           LogicalExpressionPlan plan = new LogicalExpressionPlan();
                           builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR275 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                               ((statement_scope)statement_stack.peek()).inputIndex, null, -1 );
                           retval.plans.add( plan );
                       }

                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1300:4: ( ASC | DESC )?
                    int alt88=3;
                    int LA88_0 = input.LA(1);

                    if ( (LA88_0==ASC) ) {
                        alt88=1;
                    }
                    else if ( (LA88_0==DESC) ) {
                        alt88=2;
                    }
                    switch (alt88) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1300:6: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC276=(CommonTree)match(input,ASC,FOLLOW_ASC_in_order_by_clause3982); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC276_tree = (CommonTree)adaptor.dupNode(ASC276);


                            adaptor.addChild(root_0, ASC276_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlags.add( true ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1300:39: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC277=(CommonTree)match(input,DESC,FOLLOW_DESC_in_order_by_clause3988); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC277_tree = (CommonTree)adaptor.dupNode(DESC277);


                            adaptor.addChild(root_0, DESC277_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlags.add( false ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1301:4: ( order_col )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1301:4: ( order_col )+
                    int cnt89=0;
                    loop89:
                    do {
                        int alt89=2;
                        int LA89_0 = input.LA(1);

                        if ( (LA89_0==CUBE||LA89_0==DOLLARVAR||LA89_0==GROUP||LA89_0==IDENTIFIER||LA89_0==COL_RANGE) ) {
                            alt89=1;
                        }


                        switch (alt89) {
                    	case 1 :
                    	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1301:6: order_col
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_order_col_in_order_by_clause4000);
                    	    order_col278=order_col();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, order_col278.getTree());


                    	    if ( state.backtracking==0 ) {
                    	           retval.plans.add( (order_col278!=null?order_col278.plan:null) );
                    	           retval.ascFlags.add( (order_col278!=null?order_col278.ascFlag:null) );
                    	       }

                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt89 >= 1 ) break loop89;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(89, input);
                                throw eee;
                        }
                        cnt89++;
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
        public LogicalExpressionPlan plan;
        public Boolean ascFlag;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "order_col"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1308:1: order_col returns [LogicalExpressionPlan plan, Boolean ascFlag] : ( col_range[$plan] ( ASC | DESC )? | col_ref[$plan] ( ASC | DESC )? );
    public final LogicalPlanGenerator.order_col_return order_col() throws RecognitionException {
        LogicalPlanGenerator.order_col_return retval = new LogicalPlanGenerator.order_col_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ASC280=null;
        CommonTree DESC281=null;
        CommonTree ASC283=null;
        CommonTree DESC284=null;
        LogicalPlanGenerator.col_range_return col_range279 =null;

        LogicalPlanGenerator.col_ref_return col_ref282 =null;


        CommonTree ASC280_tree=null;
        CommonTree DESC281_tree=null;
        CommonTree ASC283_tree=null;
        CommonTree DESC284_tree=null;


            retval.plan = new LogicalExpressionPlan();
            retval.ascFlag = true;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1313:2: ( col_range[$plan] ( ASC | DESC )? | col_ref[$plan] ( ASC | DESC )? )
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==COL_RANGE) ) {
                alt93=1;
            }
            else if ( (LA93_0==CUBE||LA93_0==DOLLARVAR||LA93_0==GROUP||LA93_0==IDENTIFIER) ) {
                alt93=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;

            }
            switch (alt93) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1313:4: col_range[$plan] ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_order_col4026);
                    col_range279=col_range(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range279.getTree());


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1313:21: ( ASC | DESC )?
                    int alt91=3;
                    int LA91_0 = input.LA(1);

                    if ( (LA91_0==ASC) ) {
                        alt91=1;
                    }
                    else if ( (LA91_0==DESC) ) {
                        alt91=2;
                    }
                    switch (alt91) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1313:22: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC280=(CommonTree)match(input,ASC,FOLLOW_ASC_in_order_col4030); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC280_tree = (CommonTree)adaptor.dupNode(ASC280);


                            adaptor.addChild(root_0, ASC280_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1313:28: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC281=(CommonTree)match(input,DESC,FOLLOW_DESC_in_order_col4034); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC281_tree = (CommonTree)adaptor.dupNode(DESC281);


                            adaptor.addChild(root_0, DESC281_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlag = false; }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1314:4: col_ref[$plan] ( ASC | DESC )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_order_col4044);
                    col_ref282=col_ref(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref282.getTree());


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1314:19: ( ASC | DESC )?
                    int alt92=3;
                    int LA92_0 = input.LA(1);

                    if ( (LA92_0==ASC) ) {
                        alt92=1;
                    }
                    else if ( (LA92_0==DESC) ) {
                        alt92=2;
                    }
                    switch (alt92) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1314:21: ASC
                            {
                            _last = (CommonTree)input.LT(1);
                            ASC283=(CommonTree)match(input,ASC,FOLLOW_ASC_in_order_col4049); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASC283_tree = (CommonTree)adaptor.dupNode(ASC283);


                            adaptor.addChild(root_0, ASC283_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1314:27: DESC
                            {
                            _last = (CommonTree)input.LT(1);
                            DESC284=(CommonTree)match(input,DESC,FOLLOW_DESC_in_order_col4053); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DESC284_tree = (CommonTree)adaptor.dupNode(DESC284);


                            adaptor.addChild(root_0, DESC284_tree);
                            }


                            if ( state.backtracking==0 ) { retval.ascFlag = false; }

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
    // $ANTLR end "order_col"


    public static class distinct_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "distinct_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1317:1: distinct_clause returns [String alias] : ^( DISTINCT rel ( partition_clause )? ) ;
    public final LogicalPlanGenerator.distinct_clause_return distinct_clause() throws RecognitionException {
        LogicalPlanGenerator.distinct_clause_return retval = new LogicalPlanGenerator.distinct_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT285=null;
        LogicalPlanGenerator.rel_return rel286 =null;

        LogicalPlanGenerator.partition_clause_return partition_clause287 =null;


        CommonTree DISTINCT285_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1318:2: ( ^( DISTINCT rel ( partition_clause )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1318:4: ^( DISTINCT rel ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT285=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_distinct_clause4073); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT285_tree = (CommonTree)adaptor.dupNode(DISTINCT285);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT285_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_distinct_clause4075);
            rel286=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel286.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1318:20: ( partition_clause )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==PARTITION) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1318:20: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_distinct_clause4077);
                    partition_clause287=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause287.getTree());


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
                   retval.alias = builder.buildDistinctOp( new SourceLocation( (PigParserNode)DISTINCT285 ), ((statement_scope)statement_stack.peek()).alias,
                      ((statement_scope)statement_stack.peek()).inputAlias, (partition_clause287!=null?partition_clause287.partitioner:null) );
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
        public String partitioner;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "partition_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1325:1: partition_clause returns [String partitioner] : ^( PARTITION func_name ) ;
    public final LogicalPlanGenerator.partition_clause_return partition_clause() throws RecognitionException {
        LogicalPlanGenerator.partition_clause_return retval = new LogicalPlanGenerator.partition_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree PARTITION288=null;
        LogicalPlanGenerator.func_name_return func_name289 =null;


        CommonTree PARTITION288_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1326:2: ( ^( PARTITION func_name ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1326:4: ^( PARTITION func_name )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            PARTITION288=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_partition_clause4100); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PARTITION288_tree = (CommonTree)adaptor.dupNode(PARTITION288);


            root_1 = (CommonTree)adaptor.becomeRoot(PARTITION288_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_func_name_in_partition_clause4102);
            func_name289=func_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, func_name289.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.partitioner = (func_name289!=null?func_name289.funcName:null);
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
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "cross_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1332:1: cross_clause returns [String alias] : ^( CROSS rel_list ( partition_clause )? ) ;
    public final LogicalPlanGenerator.cross_clause_return cross_clause() throws RecognitionException {
        LogicalPlanGenerator.cross_clause_return retval = new LogicalPlanGenerator.cross_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS290=null;
        LogicalPlanGenerator.rel_list_return rel_list291 =null;

        LogicalPlanGenerator.partition_clause_return partition_clause292 =null;


        CommonTree CROSS290_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1333:2: ( ^( CROSS rel_list ( partition_clause )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1333:4: ^( CROSS rel_list ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS290=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_cross_clause4124); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS290_tree = (CommonTree)adaptor.dupNode(CROSS290);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS290_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_cross_clause4126);
            rel_list291=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list291.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1333:22: ( partition_clause )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==PARTITION) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1333:22: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_cross_clause4128);
                    partition_clause292=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause292.getTree());


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
                   retval.alias = builder.buildCrossOp( new SourceLocation( (PigParserNode)CROSS290 ), ((statement_scope)statement_stack.peek()).alias,
                      (rel_list291!=null?rel_list291.aliasList:null), (partition_clause292!=null?partition_clause292.partitioner:null) );
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
        public List<String> aliasList;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_list"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1340:1: rel_list returns [List<String> aliasList] : ( rel )+ ;
    public final LogicalPlanGenerator.rel_list_return rel_list() throws RecognitionException {
        LogicalPlanGenerator.rel_list_return retval = new LogicalPlanGenerator.rel_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.rel_return rel293 =null;



         retval.aliasList = new ArrayList<String>(); 
        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1342:2: ( ( rel )+ )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1342:4: ( rel )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1342:4: ( rel )+
            int cnt96=0;
            loop96:
            do {
                int alt96=2;
                int LA96_0 = input.LA(1);

                if ( (LA96_0==ARROBA||LA96_0==ASSERT||LA96_0==COGROUP||(LA96_0 >= CROSS && LA96_0 <= CUBE)||LA96_0==DEFINE||LA96_0==DISTINCT||LA96_0==FILTER||LA96_0==FOREACH||LA96_0==GROUP||LA96_0==IDENTIFIER||LA96_0==JOIN||(LA96_0 >= LIMIT && LA96_0 <= LOAD)||LA96_0==MAPREDUCE||LA96_0==ORDER||LA96_0==RANK||LA96_0==SAMPLE||(LA96_0 >= STORE && LA96_0 <= STREAM)||LA96_0==UNION) ) {
                    alt96=1;
                }


                switch (alt96) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1342:6: rel
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_rel_in_rel_list4156);
            	    rel293=rel();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, rel293.getTree());


            	    if ( state.backtracking==0 ) { retval.aliasList.add( ((statement_scope)statement_stack.peek()).inputAlias ); }

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
        MultiMap<Integer, LogicalExpressionPlan> joinPlans;
        int inputIndex;
        List<String> inputAliases;
        List<Boolean> innerFlags;
    }
    protected Stack join_clause_stack = new Stack();


    public static class join_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1345:1: join_clause returns [String alias] : ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) ;
    public final LogicalPlanGenerator.join_clause_return join_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());
        join_clause_stack.push(new join_clause_scope());
        LogicalPlanGenerator.join_clause_return retval = new LogicalPlanGenerator.join_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN294=null;
        LogicalPlanGenerator.join_sub_clause_return join_sub_clause295 =null;

        LogicalPlanGenerator.join_type_return join_type296 =null;

        LogicalPlanGenerator.partition_clause_return partition_clause297 =null;


        CommonTree JOIN294_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createJoinOp();
            ((join_clause_scope)join_clause_stack.peek()).joinPlans = new MultiMap<Integer, LogicalExpressionPlan>();
            ((join_clause_scope)join_clause_stack.peek()).inputAliases = new ArrayList<String>();
            ((join_clause_scope)join_clause_stack.peek()).innerFlags = new ArrayList<Boolean>();
            int oldStatementIndex = ((statement_scope)statement_stack.peek()).inputIndex;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1363:2: ( ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1363:4: ^( JOIN join_sub_clause ( join_type )? ( partition_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN294=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_join_clause4195); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN294_tree = (CommonTree)adaptor.dupNode(JOIN294);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN294_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_sub_clause_in_join_clause4197);
            join_sub_clause295=join_sub_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_sub_clause295.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1363:28: ( join_type )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==QUOTEDSTRING) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1363:28: join_type
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_type_in_join_clause4199);
                    join_type296=join_type();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, join_type296.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1363:39: ( partition_clause )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==PARTITION) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1363:39: partition_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_partition_clause_in_join_clause4202);
                    partition_clause297=partition_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, partition_clause297.getTree());


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
                   SourceLocation loc = new SourceLocation( (PigParserNode)JOIN294 );
                   retval.alias = builder.buildJoinOp( loc, (LOJoin)((GScope_scope)GScope_stack.peek()).currentOp, ((statement_scope)statement_stack.peek()).alias,
                      ((join_clause_scope)join_clause_stack.peek()).inputAliases, ((join_clause_scope)join_clause_stack.peek()).joinPlans,
                      (join_type296!=null?join_type296.type:null), ((join_clause_scope)join_clause_stack.peek()).innerFlags, (partition_clause297!=null?partition_clause297.partitioner:null) );
               }

            if ( state.backtracking==0 ) {
            }
            }

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) {
               ((statement_scope)statement_stack.peek()).inputIndex =oldStatementIndex;
            }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            GScope_stack.pop();
            join_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "join_clause"


    public static class join_type_return extends TreeRuleReturnScope {
        public JOINTYPE type;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_type"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1372:1: join_type returns [JOINTYPE type] : QUOTEDSTRING ;
    public final LogicalPlanGenerator.join_type_return join_type() throws RecognitionException {
        LogicalPlanGenerator.join_type_return retval = new LogicalPlanGenerator.join_type_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING298=null;

        CommonTree QUOTEDSTRING298_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1373:2: ( QUOTEDSTRING )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1373:4: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING298=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_join_type4223); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING298_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING298);


            adaptor.addChild(root_0, QUOTEDSTRING298_tree);
            }


            if ( state.backtracking==0 ) {
                   retval.type = builder.parseJoinType( (QUOTEDSTRING298!=null?QUOTEDSTRING298.getText():null), new SourceLocation( (PigParserNode)QUOTEDSTRING298 ) );
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1379:1: join_sub_clause : ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ );
    public final LogicalPlanGenerator.join_sub_clause_return join_sub_clause() throws RecognitionException {
        LogicalPlanGenerator.join_sub_clause_return retval = new LogicalPlanGenerator.join_sub_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LEFT300=null;
        CommonTree RIGHT301=null;
        CommonTree FULL302=null;
        CommonTree OUTER303=null;
        LogicalPlanGenerator.join_item_return join_item299 =null;

        LogicalPlanGenerator.join_item_return join_item304 =null;

        LogicalPlanGenerator.join_item_return join_item305 =null;


        CommonTree LEFT300_tree=null;
        CommonTree RIGHT301_tree=null;
        CommonTree FULL302_tree=null;
        CommonTree OUTER303_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1380:2: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item | ( join_item )+ )
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==JOIN_ITEM) ) {
                int LA102_1 = input.LA(2);

                if ( (synpred178_LogicalPlanGenerator()) ) {
                    alt102=1;
                }
                else if ( (true) ) {
                    alt102=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 102, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;

            }
            switch (alt102) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1380:4: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause4238);
                    join_item299=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item299.getTree());


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1380:14: ( LEFT | RIGHT | FULL )
                    int alt99=3;
                    switch ( input.LA(1) ) {
                    case LEFT:
                        {
                        alt99=1;
                        }
                        break;
                    case RIGHT:
                        {
                        alt99=2;
                        }
                        break;
                    case FULL:
                        {
                        alt99=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 99, 0, input);

                        throw nvae;

                    }

                    switch (alt99) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1380:16: LEFT
                            {
                            _last = (CommonTree)input.LT(1);
                            LEFT300=(CommonTree)match(input,LEFT,FOLLOW_LEFT_in_join_sub_clause4242); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            LEFT300_tree = (CommonTree)adaptor.dupNode(LEFT300);


                            adaptor.addChild(root_0, LEFT300_tree);
                            }


                            if ( state.backtracking==0 ) { ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( true );
                                                  ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( false ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 2 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1382:16: RIGHT
                            {
                            _last = (CommonTree)input.LT(1);
                            RIGHT301=(CommonTree)match(input,RIGHT,FOLLOW_RIGHT_in_join_sub_clause4261); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            RIGHT301_tree = (CommonTree)adaptor.dupNode(RIGHT301);


                            adaptor.addChild(root_0, RIGHT301_tree);
                            }


                            if ( state.backtracking==0 ) { ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( false );
                                                   ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( true ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;
                        case 3 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1384:16: FULL
                            {
                            _last = (CommonTree)input.LT(1);
                            FULL302=(CommonTree)match(input,FULL,FOLLOW_FULL_in_join_sub_clause4280); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            FULL302_tree = (CommonTree)adaptor.dupNode(FULL302);


                            adaptor.addChild(root_0, FULL302_tree);
                            }


                            if ( state.backtracking==0 ) { ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( false );
                                                  ((join_clause_scope)join_clause_stack.peek()).innerFlags.add( false ); }

                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1385:66: ( OUTER )?
                    int alt100=2;
                    int LA100_0 = input.LA(1);

                    if ( (LA100_0==OUTER) ) {
                        alt100=1;
                    }
                    switch (alt100) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1385:66: OUTER
                            {
                            _last = (CommonTree)input.LT(1);
                            OUTER303=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_join_sub_clause4286); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            OUTER303_tree = (CommonTree)adaptor.dupNode(OUTER303);


                            adaptor.addChild(root_0, OUTER303_tree);
                            }


                            if ( state.backtracking==0 ) {
                            }
                            }
                            break;

                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_join_item_in_join_sub_clause4289);
                    join_item304=join_item();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, join_item304.getTree());


                    if ( state.backtracking==0 ) {
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1388:4: ( join_item )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1388:4: ( join_item )+
                    int cnt101=0;
                    loop101:
                    do {
                        int alt101=2;
                        int LA101_0 = input.LA(1);

                        if ( (LA101_0==JOIN_ITEM) ) {
                            alt101=1;
                        }


                        switch (alt101) {
                    	case 1 :
                    	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1388:4: join_item
                    	    {
                    	    _last = (CommonTree)input.LT(1);
                    	    pushFollow(FOLLOW_join_item_in_join_sub_clause4299);
                    	    join_item305=join_item();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) 
                    	    adaptor.addChild(root_0, join_item305.getTree());


                    	    if ( state.backtracking==0 ) {
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt101 >= 1 ) break loop101;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(101, input);
                                throw eee;
                        }
                        cnt101++;
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1391:1: join_item : ^( JOIN_ITEM rel join_group_by_clause ) ;
    public final LogicalPlanGenerator.join_item_return join_item() throws RecognitionException {
        LogicalPlanGenerator.join_item_return retval = new LogicalPlanGenerator.join_item_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree JOIN_ITEM306=null;
        LogicalPlanGenerator.rel_return rel307 =null;

        LogicalPlanGenerator.join_group_by_clause_return join_group_by_clause308 =null;


        CommonTree JOIN_ITEM306_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1392:2: ( ^( JOIN_ITEM rel join_group_by_clause ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1392:4: ^( JOIN_ITEM rel join_group_by_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            JOIN_ITEM306=(CommonTree)match(input,JOIN_ITEM,FOLLOW_JOIN_ITEM_in_join_item4312); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            JOIN_ITEM306_tree = (CommonTree)adaptor.dupNode(JOIN_ITEM306);


            root_1 = (CommonTree)adaptor.becomeRoot(JOIN_ITEM306_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_join_item4314);
            rel307=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel307.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_join_group_by_clause_in_join_item4316);
            join_group_by_clause308=join_group_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, join_group_by_clause308.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   ((join_clause_scope)join_clause_stack.peek()).inputAliases.add( ((statement_scope)statement_stack.peek()).inputAlias );
                   ((join_clause_scope)join_clause_stack.peek()).joinPlans.put( ((join_clause_scope)join_clause_stack.peek()).inputIndex, (join_group_by_clause308!=null?join_group_by_clause308.plans:null) );
                   ((join_clause_scope)join_clause_stack.peek()).inputIndex++;
                   ((statement_scope)statement_stack.peek()).inputIndex++;
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
        public List<LogicalExpressionPlan> plans;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_group_by_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1401:1: join_group_by_clause returns [List<LogicalExpressionPlan> plans] : ^( BY ( join_group_by_expr )+ ) ;
    public final LogicalPlanGenerator.join_group_by_clause_return join_group_by_clause() throws RecognitionException {
        LogicalPlanGenerator.join_group_by_clause_return retval = new LogicalPlanGenerator.join_group_by_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BY309=null;
        LogicalPlanGenerator.join_group_by_expr_return join_group_by_expr310 =null;


        CommonTree BY309_tree=null;


            retval.plans = new ArrayList<LogicalExpressionPlan>();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1405:2: ( ^( BY ( join_group_by_expr )+ ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1405:4: ^( BY ( join_group_by_expr )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BY309=(CommonTree)match(input,BY,FOLLOW_BY_in_join_group_by_clause4343); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BY309_tree = (CommonTree)adaptor.dupNode(BY309);


            root_1 = (CommonTree)adaptor.becomeRoot(BY309_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1405:10: ( join_group_by_expr )+
            int cnt103=0;
            loop103:
            do {
                int alt103=2;
                int LA103_0 = input.LA(1);

                if ( (LA103_0==BIGDECIMALNUMBER||LA103_0==BIGINTEGERNUMBER||LA103_0==CUBE||LA103_0==DIV||LA103_0==DOLLARVAR||LA103_0==DOUBLENUMBER||LA103_0==FALSE||LA103_0==FLOATNUMBER||LA103_0==GROUP||LA103_0==IDENTIFIER||LA103_0==INTEGER||LA103_0==LONGINTEGER||LA103_0==MINUS||LA103_0==NULL||LA103_0==PERCENT||LA103_0==PLUS||LA103_0==QUOTEDSTRING||LA103_0==STAR||LA103_0==TRUE||(LA103_0 >= BAG_VAL && LA103_0 <= BIN_EXPR)||(LA103_0 >= CASE_COND && LA103_0 <= CASE_EXPR)||(LA103_0 >= CAST_EXPR && LA103_0 <= EXPR_IN_PAREN)||LA103_0==FUNC_EVAL||LA103_0==INVOKER_FUNC_EVAL||(LA103_0 >= MAP_VAL && LA103_0 <= NEG)||LA103_0==TUPLE_VAL) ) {
                    alt103=1;
                }


                switch (alt103) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1405:12: join_group_by_expr
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_join_group_by_expr_in_join_group_by_clause4347);
            	    join_group_by_expr310=join_group_by_expr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, join_group_by_expr310.getTree());


            	    if ( state.backtracking==0 ) { retval.plans.add( (join_group_by_expr310!=null?join_group_by_expr310.plan:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt103 >= 1 ) break loop103;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(103, input);
                        throw eee;
                }
                cnt103++;
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
        public LogicalExpressionPlan plan;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "join_group_by_expr"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1408:1: join_group_by_expr returns [LogicalExpressionPlan plan] : ( col_range[$plan] | expr[$plan] | STAR );
    public final LogicalPlanGenerator.join_group_by_expr_return join_group_by_expr() throws RecognitionException {
        LogicalPlanGenerator.join_group_by_expr_return retval = new LogicalPlanGenerator.join_group_by_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STAR313=null;
        LogicalPlanGenerator.col_range_return col_range311 =null;

        LogicalPlanGenerator.expr_return expr312 =null;


        CommonTree STAR313_tree=null;


            retval.plan = new LogicalExpressionPlan();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1412:2: ( col_range[$plan] | expr[$plan] | STAR )
            int alt104=3;
            switch ( input.LA(1) ) {
            case COL_RANGE:
                {
                alt104=1;
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
                alt104=2;
                }
                break;
            case STAR:
                {
                int LA104_3 = input.LA(2);

                if ( (LA104_3==DOWN) ) {
                    alt104=2;
                }
                else if ( (LA104_3==EOF||LA104_3==UP||LA104_3==BIGDECIMALNUMBER||LA104_3==BIGINTEGERNUMBER||LA104_3==CUBE||LA104_3==DIV||LA104_3==DOLLARVAR||LA104_3==DOUBLENUMBER||LA104_3==FALSE||LA104_3==FLOATNUMBER||LA104_3==GROUP||LA104_3==IDENTIFIER||LA104_3==INTEGER||LA104_3==LONGINTEGER||LA104_3==MINUS||LA104_3==NULL||LA104_3==PERCENT||LA104_3==PLUS||LA104_3==QUOTEDSTRING||LA104_3==STAR||LA104_3==TRUE||(LA104_3 >= BAG_VAL && LA104_3 <= BIN_EXPR)||(LA104_3 >= CASE_COND && LA104_3 <= CASE_EXPR)||(LA104_3 >= CAST_EXPR && LA104_3 <= EXPR_IN_PAREN)||LA104_3==FUNC_EVAL||LA104_3==INVOKER_FUNC_EVAL||(LA104_3 >= MAP_VAL && LA104_3 <= NEG)||LA104_3==TUPLE_VAL) ) {
                    alt104=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 104, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;

            }

            switch (alt104) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1412:4: col_range[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_range_in_join_group_by_expr4372);
                    col_range311=col_range(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_range311.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1413:4: expr[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_join_group_by_expr4378);
                    expr312=expr(retval.plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, expr312.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1414:4: STAR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STAR313=(CommonTree)match(input,STAR,FOLLOW_STAR_in_join_group_by_expr4384); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR313_tree = (CommonTree)adaptor.dupNode(STAR313);


                    adaptor.addChild(root_0, STAR313_tree);
                    }


                    if ( state.backtracking==0 ) {
                           builder.buildProjectExpr( new SourceLocation( (PigParserNode)STAR313 ), retval.plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                               ((statement_scope)statement_stack.peek()).inputIndex, null, -1 );
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
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "union_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1421:1: union_clause returns [String alias] : ^( UNION ( ONSCHEMA )? rel_list ) ;
    public final LogicalPlanGenerator.union_clause_return union_clause() throws RecognitionException {
        LogicalPlanGenerator.union_clause_return retval = new LogicalPlanGenerator.union_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree UNION314=null;
        CommonTree ONSCHEMA315=null;
        LogicalPlanGenerator.rel_list_return rel_list316 =null;


        CommonTree UNION314_tree=null;
        CommonTree ONSCHEMA315_tree=null;


            boolean onSchema = false;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1425:2: ( ^( UNION ( ONSCHEMA )? rel_list ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1425:4: ^( UNION ( ONSCHEMA )? rel_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            UNION314=(CommonTree)match(input,UNION,FOLLOW_UNION_in_union_clause4409); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            UNION314_tree = (CommonTree)adaptor.dupNode(UNION314);


            root_1 = (CommonTree)adaptor.becomeRoot(UNION314_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1425:13: ( ONSCHEMA )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==ONSCHEMA) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1425:15: ONSCHEMA
                    {
                    _last = (CommonTree)input.LT(1);
                    ONSCHEMA315=(CommonTree)match(input,ONSCHEMA,FOLLOW_ONSCHEMA_in_union_clause4413); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ONSCHEMA315_tree = (CommonTree)adaptor.dupNode(ONSCHEMA315);


                    adaptor.addChild(root_1, ONSCHEMA315_tree);
                    }


                    if ( state.backtracking==0 ) { onSchema = true; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_list_in_union_clause4420);
            rel_list316=rel_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel_list316.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                  retval.alias = builder.buildUnionOp( new SourceLocation( (PigParserNode)UNION314 ), ((statement_scope)statement_stack.peek()).alias,
                      (rel_list316!=null?rel_list316.aliasList:null), onSchema );
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


    protected static class foreach_clause_scope {
        LOForEach foreachOp;
    }
    protected Stack foreach_clause_stack = new Stack();


    public static class foreach_clause_return extends TreeRuleReturnScope {
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "foreach_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1432:1: foreach_clause returns [String alias] : ^( FOREACH rel foreach_plan ) ;
    public final LogicalPlanGenerator.foreach_clause_return foreach_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());
        foreach_clause_stack.push(new foreach_clause_scope());
        LogicalPlanGenerator.foreach_clause_return retval = new LogicalPlanGenerator.foreach_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH317=null;
        LogicalPlanGenerator.rel_return rel318 =null;

        LogicalPlanGenerator.foreach_plan_return foreach_plan319 =null;


        CommonTree FOREACH317_tree=null;


             ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp = builder.createForeachOp();
             ((GScope_scope)GScope_stack.peek()).currentOp = ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1441:2: ( ^( FOREACH rel foreach_plan ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1441:4: ^( FOREACH rel foreach_plan )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH317=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_foreach_clause4456); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH317_tree = (CommonTree)adaptor.dupNode(FOREACH317);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH317_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_foreach_clause4458);
            rel318=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel318.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_foreach_plan_in_foreach_clause4460);
            foreach_plan319=foreach_plan();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, foreach_plan319.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)FOREACH317 );
                   retval.alias = builder.buildForeachOp( loc, ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp, ((statement_scope)statement_stack.peek()).alias,
                      ((statement_scope)statement_stack.peek()).inputAlias, (foreach_plan319!=null?foreach_plan319.plan:null) );
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
            GScope_stack.pop();
            foreach_clause_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "foreach_clause"


    protected static class foreach_plan_scope {
        LogicalPlan innerPlan;
        Map<String, LogicalExpressionPlan> exprPlans;
        Map<String, Operator> operators;
    }
    protected Stack foreach_plan_stack = new Stack();


    public static class foreach_plan_return extends TreeRuleReturnScope {
        public LogicalPlan plan;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "foreach_plan"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1449:1: foreach_plan returns [LogicalPlan plan] : ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) );
    public final LogicalPlanGenerator.foreach_plan_return foreach_plan() throws RecognitionException {
        foreach_plan_stack.push(new foreach_plan_scope());
        LogicalPlanGenerator.foreach_plan_return retval = new LogicalPlanGenerator.foreach_plan_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH_PLAN_SIMPLE320=null;
        CommonTree FOREACH_PLAN_COMPLEX322=null;
        LogicalPlanGenerator.generate_clause_return generate_clause321 =null;

        LogicalPlanGenerator.nested_blk_return nested_blk323 =null;


        CommonTree FOREACH_PLAN_SIMPLE320_tree=null;
        CommonTree FOREACH_PLAN_COMPLEX322_tree=null;


            inForeachPlan = true;
            ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan = new LogicalPlan();
            ((foreach_plan_scope)foreach_plan_stack.peek()).exprPlans = new HashMap<String, LogicalExpressionPlan>();
            ((foreach_plan_scope)foreach_plan_stack.peek()).operators = new HashMap<String, Operator>();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1465:2: ( ^( FOREACH_PLAN_SIMPLE generate_clause ) | ^( FOREACH_PLAN_COMPLEX nested_blk ) )
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==FOREACH_PLAN_SIMPLE) ) {
                alt106=1;
            }
            else if ( (LA106_0==FOREACH_PLAN_COMPLEX) ) {
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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1465:4: ^( FOREACH_PLAN_SIMPLE generate_clause )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_SIMPLE320=(CommonTree)match(input,FOREACH_PLAN_SIMPLE,FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan4496); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_SIMPLE320_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_SIMPLE320);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_SIMPLE320_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_generate_clause_in_foreach_plan4498);
                    generate_clause321=generate_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, generate_clause321.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1466:4: ^( FOREACH_PLAN_COMPLEX nested_blk )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    FOREACH_PLAN_COMPLEX322=(CommonTree)match(input,FOREACH_PLAN_COMPLEX,FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan4507); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH_PLAN_COMPLEX322_tree = (CommonTree)adaptor.dupNode(FOREACH_PLAN_COMPLEX322);


                    root_1 = (CommonTree)adaptor.becomeRoot(FOREACH_PLAN_COMPLEX322_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_blk_in_foreach_plan4509);
                    nested_blk323=nested_blk();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_blk323.getTree());


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

            if ( state.backtracking==0 ) {
                retval.plan = ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan;
                inForeachPlan = false;
            }
        }

        catch(RecognitionException re) {
            throw re;
        }

        finally {
        	// do for sure before leaving
            foreach_plan_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "foreach_plan"


    public static class nested_blk_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_blk"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1469:1: nested_blk : ( nested_command )* generate_clause ;
    public final LogicalPlanGenerator.nested_blk_return nested_blk() throws RecognitionException {
        LogicalPlanGenerator.nested_blk_return retval = new LogicalPlanGenerator.nested_blk_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.nested_command_return nested_command324 =null;

        LogicalPlanGenerator.generate_clause_return generate_clause325 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1469:12: ( ( nested_command )* generate_clause )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1469:14: ( nested_command )* generate_clause
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1469:14: ( nested_command )*
            loop107:
            do {
                int alt107=2;
                int LA107_0 = input.LA(1);

                if ( ((LA107_0 >= NESTED_CMD && LA107_0 <= NESTED_CMD_ASSI)) ) {
                    alt107=1;
                }


                switch (alt107) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1469:14: nested_command
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_command_in_nested_blk4520);
            	    nested_command324=nested_command();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_command324.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    break loop107;
                }
            } while (true);


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_blk4523);
            generate_clause325=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, generate_clause325.getTree());


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


    public static class nested_command_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_command"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1472:1: nested_command : ( ^( NESTED_CMD IDENTIFIER nested_op[$IDENTIFIER.text] ) | ^( NESTED_CMD_ASSI IDENTIFIER expr[exprPlan] ) );
    public final LogicalPlanGenerator.nested_command_return nested_command() throws RecognitionException {
        LogicalPlanGenerator.nested_command_return retval = new LogicalPlanGenerator.nested_command_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_CMD326=null;
        CommonTree IDENTIFIER327=null;
        CommonTree NESTED_CMD_ASSI329=null;
        CommonTree IDENTIFIER330=null;
        LogicalPlanGenerator.nested_op_return nested_op328 =null;

        LogicalPlanGenerator.expr_return expr331 =null;


        CommonTree NESTED_CMD326_tree=null;
        CommonTree IDENTIFIER327_tree=null;
        CommonTree NESTED_CMD_ASSI329_tree=null;
        CommonTree IDENTIFIER330_tree=null;


            LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();
            inNestedCommand = true;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1480:2: ( ^( NESTED_CMD IDENTIFIER nested_op[$IDENTIFIER.text] ) | ^( NESTED_CMD_ASSI IDENTIFIER expr[exprPlan] ) )
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==NESTED_CMD) ) {
                alt108=1;
            }
            else if ( (LA108_0==NESTED_CMD_ASSI) ) {
                alt108=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 108, 0, input);

                throw nvae;

            }
            switch (alt108) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1480:4: ^( NESTED_CMD IDENTIFIER nested_op[$IDENTIFIER.text] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD326=(CommonTree)match(input,NESTED_CMD,FOLLOW_NESTED_CMD_in_nested_command4545); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD326_tree = (CommonTree)adaptor.dupNode(NESTED_CMD326);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD326_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER327=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command4547); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER327_tree = (CommonTree)adaptor.dupNode(IDENTIFIER327);


                    adaptor.addChild(root_1, IDENTIFIER327_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_op_in_nested_command4549);
                    nested_op328=nested_op((IDENTIFIER327!=null?IDENTIFIER327.getText():null));

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, nested_op328.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                           ((foreach_plan_scope)foreach_plan_stack.peek()).operators.put( (IDENTIFIER327!=null?IDENTIFIER327.getText():null), (nested_op328!=null?nested_op328.op:null) );
                           ((foreach_plan_scope)foreach_plan_stack.peek()).exprPlans.remove( (IDENTIFIER327!=null?IDENTIFIER327.getText():null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1486:4: ^( NESTED_CMD_ASSI IDENTIFIER expr[exprPlan] )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    {
                    CommonTree _save_last_1 = _last;
                    CommonTree _first_1 = null;
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    _last = (CommonTree)input.LT(1);
                    NESTED_CMD_ASSI329=(CommonTree)match(input,NESTED_CMD_ASSI,FOLLOW_NESTED_CMD_ASSI_in_nested_command4567); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NESTED_CMD_ASSI329_tree = (CommonTree)adaptor.dupNode(NESTED_CMD_ASSI329);


                    root_1 = (CommonTree)adaptor.becomeRoot(NESTED_CMD_ASSI329_tree, root_1);
                    }


                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER330=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_nested_command4569); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER330_tree = (CommonTree)adaptor.dupNode(IDENTIFIER330);


                    adaptor.addChild(root_1, IDENTIFIER330_tree);
                    }


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_command4571);
                    expr331=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr331.getTree());


                    match(input, Token.UP, null); if (state.failed) return retval;
                    adaptor.addChild(root_0, root_1);
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==0 ) {
                            ((foreach_plan_scope)foreach_plan_stack.peek()).exprPlans.put( (IDENTIFIER330!=null?IDENTIFIER330.getText():null), exprPlan );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }
            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            }

            if ( state.backtracking==0 ) {
            	inNestedCommand = false;
            }
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
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1492:1: nested_op[String alias] returns [Operator op] : ( nested_proj[$alias] | nested_filter[$alias] | nested_sort[$alias] | nested_distinct[$alias] | nested_limit[$alias] | nested_cross[$alias] | nested_foreach[$alias] );
    public final LogicalPlanGenerator.nested_op_return nested_op(String alias) throws RecognitionException {
        LogicalPlanGenerator.nested_op_return retval = new LogicalPlanGenerator.nested_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.nested_proj_return nested_proj332 =null;

        LogicalPlanGenerator.nested_filter_return nested_filter333 =null;

        LogicalPlanGenerator.nested_sort_return nested_sort334 =null;

        LogicalPlanGenerator.nested_distinct_return nested_distinct335 =null;

        LogicalPlanGenerator.nested_limit_return nested_limit336 =null;

        LogicalPlanGenerator.nested_cross_return nested_cross337 =null;

        LogicalPlanGenerator.nested_foreach_return nested_foreach338 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1493:2: ( nested_proj[$alias] | nested_filter[$alias] | nested_sort[$alias] | nested_distinct[$alias] | nested_limit[$alias] | nested_cross[$alias] | nested_foreach[$alias] )
            int alt109=7;
            switch ( input.LA(1) ) {
            case NESTED_PROJ:
                {
                alt109=1;
                }
                break;
            case FILTER:
                {
                alt109=2;
                }
                break;
            case ORDER:
                {
                alt109=3;
                }
                break;
            case DISTINCT:
                {
                alt109=4;
                }
                break;
            case LIMIT:
                {
                alt109=5;
                }
                break;
            case CROSS:
                {
                alt109=6;
                }
                break;
            case FOREACH:
                {
                alt109=7;
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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1493:4: nested_proj[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op4593);
                    nested_proj332=nested_proj(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj332.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_proj332!=null?nested_proj332.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1494:4: nested_filter[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_filter_in_nested_op4601);
                    nested_filter333=nested_filter(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_filter333.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_filter333!=null?nested_filter333.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1495:4: nested_sort[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_sort_in_nested_op4609);
                    nested_sort334=nested_sort(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_sort334.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_sort334!=null?nested_sort334.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1496:4: nested_distinct[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_distinct_in_nested_op4618);
                    nested_distinct335=nested_distinct(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_distinct335.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_distinct335!=null?nested_distinct335.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1497:4: nested_limit[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_limit_in_nested_op4626);
                    nested_limit336=nested_limit(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_limit336.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_limit336!=null?nested_limit336.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1498:4: nested_cross[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_cross_in_nested_op4634);
                    nested_cross337=nested_cross(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_cross337.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_cross337!=null?nested_cross337.op:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1499:4: nested_foreach[$alias]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_foreach_in_nested_op4642);
                    nested_foreach338=nested_foreach(alias);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_foreach338.getTree());


                    if ( state.backtracking==0 ) { retval.op = (nested_foreach338!=null?nested_foreach338.op:null); }

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
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_proj"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1502:1: nested_proj[String alias] returns [Operator op] : ^( NESTED_PROJ cr0= col_ref[plan] (cr= col_ref[new LogicalExpressionPlan()] )+ ) ;
    public final LogicalPlanGenerator.nested_proj_return nested_proj(String alias) throws RecognitionException {
        LogicalPlanGenerator.nested_proj_return retval = new LogicalPlanGenerator.nested_proj_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree NESTED_PROJ339=null;
        LogicalPlanGenerator.col_ref_return cr0 =null;

        LogicalPlanGenerator.col_ref_return cr =null;


        CommonTree NESTED_PROJ339_tree=null;


            LogicalExpressionPlan plan = new LogicalExpressionPlan();
            List<LogicalExpressionPlan> plans = new ArrayList<LogicalExpressionPlan>();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1507:2: ( ^( NESTED_PROJ cr0= col_ref[plan] (cr= col_ref[new LogicalExpressionPlan()] )+ ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1507:4: ^( NESTED_PROJ cr0= col_ref[plan] (cr= col_ref[new LogicalExpressionPlan()] )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            NESTED_PROJ339=(CommonTree)match(input,NESTED_PROJ,FOLLOW_NESTED_PROJ_in_nested_proj4666); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NESTED_PROJ339_tree = (CommonTree)adaptor.dupNode(NESTED_PROJ339);


            root_1 = (CommonTree)adaptor.becomeRoot(NESTED_PROJ339_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_col_ref_in_nested_proj4678);
            cr0=col_ref(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cr0.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1509:7: (cr= col_ref[new LogicalExpressionPlan()] )+
            int cnt110=0;
            loop110:
            do {
                int alt110=2;
                int LA110_0 = input.LA(1);

                if ( (LA110_0==CUBE||LA110_0==DOLLARVAR||LA110_0==GROUP||LA110_0==IDENTIFIER) ) {
                    alt110=1;
                }


                switch (alt110) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1509:9: cr= col_ref[new LogicalExpressionPlan()]
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_col_ref_in_nested_proj4693);
            	    cr=col_ref(new LogicalExpressionPlan());

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, cr.getTree());


            	    if ( state.backtracking==0 ) {
            	                plans.add( (LogicalExpressionPlan)( (cr!=null?cr.expr:null).getPlan() ) );
            	            }

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


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)(cr0!=null?((CommonTree)cr0.start):null) );
                   retval.op = builder.buildNestedProjectOp( loc, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp,
                       ((foreach_plan_scope)foreach_plan_stack.peek()).operators, alias, (ProjectExpression)(cr0!=null?cr0.expr:null), plans );
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
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_filter"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1521:1: nested_filter[String alias] returns [Operator op] : ^( FILTER nested_op_input cond[plan] ) ;
    public final LogicalPlanGenerator.nested_filter_return nested_filter(String alias) throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.nested_filter_return retval = new LogicalPlanGenerator.nested_filter_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FILTER340=null;
        LogicalPlanGenerator.nested_op_input_return nested_op_input341 =null;

        LogicalPlanGenerator.cond_return cond342 =null;


        CommonTree FILTER340_tree=null;


            LogicalExpressionPlan plan = new LogicalExpressionPlan();
            Operator inputOp = null;
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createNestedFilterOp( ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan );

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1528:2: ( ^( FILTER nested_op_input cond[plan] ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1528:4: ^( FILTER nested_op_input cond[plan] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FILTER340=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_nested_filter4746); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FILTER340_tree = (CommonTree)adaptor.dupNode(FILTER340);


            root_1 = (CommonTree)adaptor.becomeRoot(FILTER340_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_filter4748);
            nested_op_input341=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input341.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_nested_filter4750);
            cond342=cond(plan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond342.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)FILTER340 );
                   retval.op = builder.buildNestedFilterOp( loc, (LOFilter)((GScope_scope)GScope_stack.peek()).currentOp, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias,
                       (nested_op_input341!=null?nested_op_input341.op:null), plan );
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
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "nested_filter"


    public static class nested_sort_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_sort"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1536:1: nested_sort[String alias] returns [Operator op] : ^( ORDER nested_op_input order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? ) ;
    public final LogicalPlanGenerator.nested_sort_return nested_sort(String alias) throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.nested_sort_return retval = new LogicalPlanGenerator.nested_sort_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree ORDER343=null;
        LogicalPlanGenerator.nested_op_input_return nested_op_input344 =null;

        LogicalPlanGenerator.order_by_clause_return order_by_clause345 =null;

        LogicalPlanGenerator.func_clause_return func_clause346 =null;


        CommonTree ORDER343_tree=null;


            Operator inputOp = null;
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createNestedSortOp( ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan );

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1542:2: ( ^( ORDER nested_op_input order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1542:4: ^( ORDER nested_op_input order_by_clause ( func_clause[FunctionType.COMPARISONFUNC] )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            ORDER343=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_nested_sort4784); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORDER343_tree = (CommonTree)adaptor.dupNode(ORDER343);


            root_1 = (CommonTree)adaptor.becomeRoot(ORDER343_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_sort4786);
            nested_op_input344=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input344.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_order_by_clause_in_nested_sort4788);
            order_by_clause345=order_by_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, order_by_clause345.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1542:45: ( func_clause[FunctionType.COMPARISONFUNC] )?
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==FUNC||LA111_0==FUNC_REF) ) {
                alt111=1;
            }
            switch (alt111) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1542:45: func_clause[FunctionType.COMPARISONFUNC]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_func_clause_in_nested_sort4790);
                    func_clause346=func_clause(FunctionType.COMPARISONFUNC);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, func_clause346.getTree());


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
                   SourceLocation loc = new SourceLocation( (PigParserNode)ORDER343 );
                   retval.op = builder.buildNestedSortOp( loc, (LOSort)((GScope_scope)GScope_stack.peek()).currentOp, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias,
                       (nested_op_input344!=null?nested_op_input344.op:null),
                       (order_by_clause345!=null?order_by_clause345.plans:null), (order_by_clause345!=null?order_by_clause345.ascFlags:null), (func_clause346!=null?func_clause346.funcSpec:null) );
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
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "nested_sort"


    public static class nested_distinct_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_distinct"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1551:1: nested_distinct[String alias] returns [Operator op] : ^( DISTINCT nested_op_input ) ;
    public final LogicalPlanGenerator.nested_distinct_return nested_distinct(String alias) throws RecognitionException {
        LogicalPlanGenerator.nested_distinct_return retval = new LogicalPlanGenerator.nested_distinct_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DISTINCT347=null;
        LogicalPlanGenerator.nested_op_input_return nested_op_input348 =null;


        CommonTree DISTINCT347_tree=null;


            Operator inputOp = null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1555:2: ( ^( DISTINCT nested_op_input ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1555:4: ^( DISTINCT nested_op_input )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            DISTINCT347=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_nested_distinct4820); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DISTINCT347_tree = (CommonTree)adaptor.dupNode(DISTINCT347);


            root_1 = (CommonTree)adaptor.becomeRoot(DISTINCT347_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_distinct4822);
            nested_op_input348=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input348.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)DISTINCT347 );
                   retval.op = builder.buildNestedDistinctOp( loc, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias, (nested_op_input348!=null?nested_op_input348.op:null) );
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
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_limit"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1562:1: nested_limit[String alias] returns [Operator op] : ^( LIMIT nested_op_input ( INTEGER | expr[exprPlan] ) ) ;
    public final LogicalPlanGenerator.nested_limit_return nested_limit(String alias) throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.nested_limit_return retval = new LogicalPlanGenerator.nested_limit_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree LIMIT349=null;
        CommonTree INTEGER351=null;
        LogicalPlanGenerator.nested_op_input_return nested_op_input350 =null;

        LogicalPlanGenerator.expr_return expr352 =null;


        CommonTree LIMIT349_tree=null;
        CommonTree INTEGER351_tree=null;


            Operator inputOp = null;
            LogicalExpressionPlan exprPlan = new LogicalExpressionPlan();
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createNestedLimitOp( ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan );

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1569:2: ( ^( LIMIT nested_op_input ( INTEGER | expr[exprPlan] ) ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1569:4: ^( LIMIT nested_op_input ( INTEGER | expr[exprPlan] ) )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            LIMIT349=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_nested_limit4855); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LIMIT349_tree = (CommonTree)adaptor.dupNode(LIMIT349);


            root_1 = (CommonTree)adaptor.becomeRoot(LIMIT349_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_limit4857);
            nested_op_input350=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input350.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1569:29: ( INTEGER | expr[exprPlan] )
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==INTEGER) ) {
                int LA112_1 = input.LA(2);

                if ( (synpred195_LogicalPlanGenerator()) ) {
                    alt112=1;
                }
                else if ( (true) ) {
                    alt112=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 112, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA112_0==BIGDECIMALNUMBER||LA112_0==BIGINTEGERNUMBER||LA112_0==CUBE||LA112_0==DIV||LA112_0==DOLLARVAR||LA112_0==DOUBLENUMBER||LA112_0==FALSE||LA112_0==FLOATNUMBER||LA112_0==GROUP||LA112_0==IDENTIFIER||LA112_0==LONGINTEGER||LA112_0==MINUS||LA112_0==NULL||LA112_0==PERCENT||LA112_0==PLUS||LA112_0==QUOTEDSTRING||LA112_0==STAR||LA112_0==TRUE||(LA112_0 >= BAG_VAL && LA112_0 <= BIN_EXPR)||(LA112_0 >= CASE_COND && LA112_0 <= CASE_EXPR)||LA112_0==CAST_EXPR||LA112_0==EXPR_IN_PAREN||LA112_0==FUNC_EVAL||LA112_0==INVOKER_FUNC_EVAL||(LA112_0 >= MAP_VAL && LA112_0 <= NEG)||LA112_0==TUPLE_VAL) ) {
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
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1569:31: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER351=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_nested_limit4861); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER351_tree = (CommonTree)adaptor.dupNode(INTEGER351);


                    adaptor.addChild(root_1, INTEGER351_tree);
                    }


                    if ( state.backtracking==0 ) {
                           SourceLocation loc = new SourceLocation( (PigParserNode)LIMIT349 );
                           retval.op = builder.buildNestedLimitOp( loc, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias, (nested_op_input350!=null?nested_op_input350.op:null),
                               Integer.valueOf( (INTEGER351!=null?INTEGER351.getText():null) ) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1575:4: expr[exprPlan]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_expr_in_nested_limit4871);
                    expr352=expr(exprPlan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, expr352.getTree());


                    if ( state.backtracking==0 ) {
                           SourceLocation loc = new SourceLocation( (PigParserNode)LIMIT349 );
                           retval.op = builder.buildNestedLimitOp( loc, (LOLimit)((GScope_scope)GScope_stack.peek()).currentOp, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias,
                               (nested_op_input350!=null?nested_op_input350.op:null), exprPlan);
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
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "nested_limit"


    public static class nested_cross_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_cross"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1584:1: nested_cross[String alias] returns [Operator op] : ^( CROSS nested_op_input_list ) ;
    public final LogicalPlanGenerator.nested_cross_return nested_cross(String alias) throws RecognitionException {
        LogicalPlanGenerator.nested_cross_return retval = new LogicalPlanGenerator.nested_cross_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree CROSS353=null;
        LogicalPlanGenerator.nested_op_input_list_return nested_op_input_list354 =null;


        CommonTree CROSS353_tree=null;


            Operator inputOp = null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1588:2: ( ^( CROSS nested_op_input_list ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1588:4: ^( CROSS nested_op_input_list )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            CROSS353=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_nested_cross4904); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CROSS353_tree = (CommonTree)adaptor.dupNode(CROSS353);


            root_1 = (CommonTree)adaptor.becomeRoot(CROSS353_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_list_in_nested_cross4906);
            nested_op_input_list354=nested_op_input_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input_list354.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)CROSS353 );
                   retval.op = builder.buildNestedCrossOp( loc, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan, alias, (nested_op_input_list354!=null?nested_op_input_list354.opList:null) );
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


    protected static class nested_foreach_scope {
        LogicalPlan innerPlan;
        LOForEach foreachOp;
    }
    protected Stack nested_foreach_stack = new Stack();


    public static class nested_foreach_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_foreach"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1595:1: nested_foreach[String alias] returns [Operator op] : ^( FOREACH nested_op_input generate_clause ) ;
    public final LogicalPlanGenerator.nested_foreach_return nested_foreach(String alias) throws RecognitionException {
        nested_foreach_stack.push(new nested_foreach_scope());
        LogicalPlanGenerator.nested_foreach_return retval = new LogicalPlanGenerator.nested_foreach_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree FOREACH355=null;
        LogicalPlanGenerator.nested_op_input_return nested_op_input356 =null;

        LogicalPlanGenerator.generate_clause_return generate_clause357 =null;


        CommonTree FOREACH355_tree=null;


        	Operator inputOp = null;
        	((nested_foreach_scope)nested_foreach_stack.peek()).innerPlan = new LogicalPlan();
        	((nested_foreach_scope)nested_foreach_stack.peek()).foreachOp = builder.createNestedForeachOp( ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan );

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1605:2: ( ^( FOREACH nested_op_input generate_clause ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1605:4: ^( FOREACH nested_op_input generate_clause )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            FOREACH355=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_nested_foreach4938); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOREACH355_tree = (CommonTree)adaptor.dupNode(FOREACH355);


            root_1 = (CommonTree)adaptor.becomeRoot(FOREACH355_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_nested_op_input_in_nested_foreach4940);
            nested_op_input356=nested_op_input();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, nested_op_input356.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_generate_clause_in_nested_foreach4942);
            generate_clause357=generate_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, generate_clause357.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
               		SourceLocation loc = new SourceLocation( (PigParserNode)FOREACH355 );
               		retval.op = builder.buildNestedForeachOp( loc, (LOForEach)((nested_foreach_scope)nested_foreach_stack.peek()).foreachOp, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan,
               							alias, (nested_op_input356!=null?nested_op_input356.op:null), ((nested_foreach_scope)nested_foreach_stack.peek()).innerPlan);
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
            nested_foreach_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "nested_foreach"


    public static class generate_clause_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "generate_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1613:1: generate_clause : ^( GENERATE ( flatten_generated_item )+ ) ;
    public final LogicalPlanGenerator.generate_clause_return generate_clause() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.generate_clause_return retval = new LogicalPlanGenerator.generate_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GENERATE358=null;
        LogicalPlanGenerator.flatten_generated_item_return flatten_generated_item359 =null;


        CommonTree GENERATE358_tree=null;


        	((GScope_scope)GScope_stack.peek()).currentOp = builder.createGenerateOp(inNestedCommand ? ((nested_foreach_scope)nested_foreach_stack.peek()).innerPlan : ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan );
            List<LogicalExpressionPlan> plans = new ArrayList<LogicalExpressionPlan>();
            List<Boolean> flattenFlags = new ArrayList<Boolean>();
            List<LogicalSchema> schemas = new ArrayList<LogicalSchema>();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1621:2: ( ^( GENERATE ( flatten_generated_item )+ ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1621:4: ^( GENERATE ( flatten_generated_item )+ )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            GENERATE358=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_generate_clause4971); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            GENERATE358_tree = (CommonTree)adaptor.dupNode(GENERATE358);


            root_1 = (CommonTree)adaptor.becomeRoot(GENERATE358_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1621:16: ( flatten_generated_item )+
            int cnt113=0;
            loop113:
            do {
                int alt113=2;
                int LA113_0 = input.LA(1);

                if ( (LA113_0==BIGDECIMALNUMBER||LA113_0==BIGINTEGERNUMBER||LA113_0==CUBE||LA113_0==DIV||LA113_0==DOLLARVAR||LA113_0==DOUBLENUMBER||LA113_0==FALSE||LA113_0==FLATTEN||LA113_0==FLOATNUMBER||LA113_0==GROUP||LA113_0==IDENTIFIER||LA113_0==INTEGER||LA113_0==LONGINTEGER||LA113_0==MINUS||LA113_0==NULL||LA113_0==PERCENT||LA113_0==PLUS||LA113_0==QUOTEDSTRING||LA113_0==STAR||LA113_0==TRUE||(LA113_0 >= BAG_VAL && LA113_0 <= BIN_EXPR)||(LA113_0 >= CASE_COND && LA113_0 <= CASE_EXPR)||(LA113_0 >= CAST_EXPR && LA113_0 <= EXPR_IN_PAREN)||LA113_0==FUNC_EVAL||LA113_0==INVOKER_FUNC_EVAL||(LA113_0 >= MAP_VAL && LA113_0 <= NEG)||LA113_0==TUPLE_VAL) ) {
                    alt113=1;
                }


                switch (alt113) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1621:18: flatten_generated_item
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_flatten_generated_item_in_generate_clause4975);
            	    flatten_generated_item359=flatten_generated_item();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, flatten_generated_item359.getTree());


            	    if ( state.backtracking==0 ) {
            	                         plans.add( (flatten_generated_item359!=null?flatten_generated_item359.plan:null) );
            	                         flattenFlags.add( (flatten_generated_item359!=null?flatten_generated_item359.flattenFlag:false) );
            	                         schemas.add( (flatten_generated_item359!=null?flatten_generated_item359.schema:null) );
            	                     }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt113 >= 1 ) break loop113;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(113, input);
                        throw eee;
                }
                cnt113++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   builder.buildGenerateOp( new SourceLocation( (PigParserNode)GENERATE358 ),
                   	   inNestedCommand ? ((nested_foreach_scope)nested_foreach_stack.peek()).foreachOp : ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp,
                       (LOGenerate)((GScope_scope)GScope_stack.peek()).currentOp, plans, flattenFlags, schemas );
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
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "generate_clause"


    public static class nested_op_input_return extends TreeRuleReturnScope {
        public Operator op;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1636:1: nested_op_input returns [Operator op] : ( col_ref[plan] | nested_proj[null] );
    public final LogicalPlanGenerator.nested_op_input_return nested_op_input() throws RecognitionException {
        LogicalPlanGenerator.nested_op_input_return retval = new LogicalPlanGenerator.nested_op_input_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.col_ref_return col_ref360 =null;

        LogicalPlanGenerator.nested_proj_return nested_proj361 =null;




            LogicalExpressionPlan plan = new LogicalExpressionPlan();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1640:2: ( col_ref[plan] | nested_proj[null] )
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==CUBE||LA114_0==DOLLARVAR||LA114_0==GROUP||LA114_0==IDENTIFIER) ) {
                alt114=1;
            }
            else if ( (LA114_0==NESTED_PROJ) ) {
                alt114=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 114, 0, input);

                throw nvae;

            }
            switch (alt114) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1640:4: col_ref[plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_col_ref_in_nested_op_input5041);
                    col_ref360=col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, col_ref360.getTree());


                    if ( state.backtracking==0 ) {
                           SourceLocation loc = new SourceLocation( (PigParserNode)(col_ref360!=null?((CommonTree)col_ref360.start):null) );
                           retval.op = builder.buildNestedOperatorInput( loc, ((foreach_plan_scope)foreach_plan_stack.peek()).innerPlan,
                               ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp, ((foreach_plan_scope)foreach_plan_stack.peek()).operators, (col_ref360!=null?col_ref360.expr:null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1646:4: nested_proj[null]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_nested_proj_in_nested_op_input5052);
                    nested_proj361=nested_proj(null);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, nested_proj361.getTree());


                    if ( state.backtracking==0 ) {
                           retval.op = (nested_proj361!=null?nested_proj361.op:null);
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
    // $ANTLR end "nested_op_input"


    public static class nested_op_input_list_return extends TreeRuleReturnScope {
        public List<Operator> opList;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "nested_op_input_list"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1652:1: nested_op_input_list returns [List<Operator> opList] : ( nested_op_input )+ ;
    public final LogicalPlanGenerator.nested_op_input_list_return nested_op_input_list() throws RecognitionException {
        LogicalPlanGenerator.nested_op_input_list_return retval = new LogicalPlanGenerator.nested_op_input_list_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.nested_op_input_return nested_op_input362 =null;



         retval.opList = new ArrayList<Operator>(); 
        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1654:2: ( ( nested_op_input )+ )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1654:4: ( nested_op_input )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1654:4: ( nested_op_input )+
            int cnt115=0;
            loop115:
            do {
                int alt115=2;
                int LA115_0 = input.LA(1);

                if ( (LA115_0==CUBE||LA115_0==DOLLARVAR||LA115_0==GROUP||LA115_0==IDENTIFIER||LA115_0==NESTED_PROJ) ) {
                    alt115=1;
                }


                switch (alt115) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1654:6: nested_op_input
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_nested_op_input_in_nested_op_input_list5078);
            	    nested_op_input362=nested_op_input();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_0, nested_op_input362.getTree());


            	    if ( state.backtracking==0 ) { retval.opList.add( (nested_op_input362!=null?nested_op_input362.op:null) ); }

            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt115 >= 1 ) break loop115;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(115, input);
                        throw eee;
                }
                cnt115++;
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
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stream_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1657:1: stream_clause returns [String alias] : ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) ;
    public final LogicalPlanGenerator.stream_clause_return stream_clause() throws RecognitionException {
        LogicalPlanGenerator.stream_clause_return retval = new LogicalPlanGenerator.stream_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STREAM363=null;
        CommonTree EXECCOMMAND365=null;
        CommonTree IDENTIFIER366=null;
        LogicalPlanGenerator.rel_return rel364 =null;

        LogicalPlanGenerator.as_clause_return as_clause367 =null;


        CommonTree STREAM363_tree=null;
        CommonTree EXECCOMMAND365_tree=null;
        CommonTree IDENTIFIER366_tree=null;


            StreamingCommand cmd = null;
            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1662:2: ( ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1662:4: ^( STREAM rel ( EXECCOMMAND | IDENTIFIER ) ( as_clause )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            STREAM363=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_stream_clause5103); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            STREAM363_tree = (CommonTree)adaptor.dupNode(STREAM363);


            root_1 = (CommonTree)adaptor.becomeRoot(STREAM363_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_stream_clause5105);
            rel364=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel364.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1662:18: ( EXECCOMMAND | IDENTIFIER )
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( (LA116_0==EXECCOMMAND) ) {
                alt116=1;
            }
            else if ( (LA116_0==IDENTIFIER) ) {
                alt116=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 116, 0, input);

                throw nvae;

            }
            switch (alt116) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1662:20: EXECCOMMAND
                    {
                    _last = (CommonTree)input.LT(1);
                    EXECCOMMAND365=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_stream_clause5109); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXECCOMMAND365_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND365);


                    adaptor.addChild(root_1, EXECCOMMAND365_tree);
                    }


                    if ( state.backtracking==0 ) { cmd = builder.buildCommand( loc, builder.unquote( (EXECCOMMAND365!=null?EXECCOMMAND365.getText():null) ) ); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1663:20: IDENTIFIER
                    {
                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER366=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_stream_clause5132); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER366_tree = (CommonTree)adaptor.dupNode(IDENTIFIER366);


                    adaptor.addChild(root_1, IDENTIFIER366_tree);
                    }


                    if ( state.backtracking==0 ) {
                                           cmd = builder.lookupCommand( (IDENTIFIER366!=null?IDENTIFIER366.getText():null) );
                                           if( cmd == null ) {
                                               String msg = "Undefined command-alias [" + (IDENTIFIER366!=null?IDENTIFIER366.getText():null) + "]";
                                               throw new ParserValidationException( input,
                                                   new SourceLocation( (PigParserNode)IDENTIFIER366 ), msg );
                                           }
                                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1672:20: ( as_clause )?
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==AS) ) {
                alt117=1;
            }
            switch (alt117) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1672:20: as_clause
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_as_clause_in_stream_clause5174);
                    as_clause367=as_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, as_clause367.getTree());


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
                   retval.alias = builder.buildStreamOp( loc, ((statement_scope)statement_stack.peek()).alias,
                      ((statement_scope)statement_stack.peek()).inputAlias, cmd, (as_clause367!=null?as_clause367.logicalSchema:null), input );
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
        public String alias;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "mr_clause"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1679:1: mr_clause returns [String alias] : ^( MAPREDUCE QUOTEDSTRING ( path_list[paths] )? store_clause load_clause ( EXECCOMMAND )? ) ;
    public final LogicalPlanGenerator.mr_clause_return mr_clause() throws RecognitionException {
        LogicalPlanGenerator.mr_clause_return retval = new LogicalPlanGenerator.mr_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAPREDUCE368=null;
        CommonTree QUOTEDSTRING369=null;
        CommonTree EXECCOMMAND373=null;
        LogicalPlanGenerator.path_list_return path_list370 =null;

        LogicalPlanGenerator.store_clause_return store_clause371 =null;

        LogicalPlanGenerator.load_clause_return load_clause372 =null;


        CommonTree MAPREDUCE368_tree=null;
        CommonTree QUOTEDSTRING369_tree=null;
        CommonTree EXECCOMMAND373_tree=null;


            List<String> paths = new ArrayList<String>();
            String alias = ((statement_scope)statement_stack.peek()).alias;
            SourceLocation loc = new SourceLocation( (PigParserNode)((CommonTree)retval.start) );

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1685:2: ( ^( MAPREDUCE QUOTEDSTRING ( path_list[paths] )? store_clause load_clause ( EXECCOMMAND )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1685:4: ^( MAPREDUCE QUOTEDSTRING ( path_list[paths] )? store_clause load_clause ( EXECCOMMAND )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAPREDUCE368=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_mr_clause5202); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAPREDUCE368_tree = (CommonTree)adaptor.dupNode(MAPREDUCE368);


            root_1 = (CommonTree)adaptor.becomeRoot(MAPREDUCE368_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING369=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_mr_clause5204); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING369_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING369);


            adaptor.addChild(root_1, QUOTEDSTRING369_tree);
            }


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1685:30: ( path_list[paths] )?
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==QUOTEDSTRING) ) {
                alt118=1;
            }
            switch (alt118) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1685:30: path_list[paths]
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_path_list_in_mr_clause5206);
                    path_list370=path_list(paths);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, path_list370.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            if ( state.backtracking==0 ) { ((statement_scope)statement_stack.peek()).alias = null; }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_store_clause_in_mr_clause5217);
            store_clause371=store_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, store_clause371.getTree());


            if ( state.backtracking==0 ) { ((statement_scope)statement_stack.peek()).alias = alias; }

            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_load_clause_in_mr_clause5226);
            load_clause372=load_clause();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, load_clause372.getTree());


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1688:6: ( EXECCOMMAND )?
            int alt119=2;
            int LA119_0 = input.LA(1);

            if ( (LA119_0==EXECCOMMAND) ) {
                alt119=1;
            }
            switch (alt119) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1688:6: EXECCOMMAND
                    {
                    _last = (CommonTree)input.LT(1);
                    EXECCOMMAND373=(CommonTree)match(input,EXECCOMMAND,FOLLOW_EXECCOMMAND_in_mr_clause5233); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EXECCOMMAND373_tree = (CommonTree)adaptor.dupNode(EXECCOMMAND373);


                    adaptor.addChild(root_1, EXECCOMMAND373_tree);
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
                   retval.alias = builder.buildNativeOp( loc,
                       builder.unquote( (QUOTEDSTRING369!=null?QUOTEDSTRING369.getText():null) ), builder.unquote( (EXECCOMMAND373!=null?EXECCOMMAND373.getText():null) ),
                       paths, (store_clause371!=null?store_clause371.alias:null), (load_clause372!=null?load_clause372.alias:null), input );
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1696:1: split_clause : ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) ;
    public final LogicalPlanGenerator.split_clause_return split_clause() throws RecognitionException {
        LogicalPlanGenerator.split_clause_return retval = new LogicalPlanGenerator.split_clause_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT374=null;
        LogicalPlanGenerator.rel_return rel375 =null;

        LogicalPlanGenerator.split_branch_return split_branch376 =null;

        LogicalPlanGenerator.split_otherwise_return split_otherwise377 =null;


        CommonTree SPLIT374_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1697:2: ( ^( SPLIT rel ( split_branch )+ ( split_otherwise )? ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1697:4: ^( SPLIT rel ( split_branch )+ ( split_otherwise )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT374=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_split_clause5253); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT374_tree = (CommonTree)adaptor.dupNode(SPLIT374);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT374_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_rel_in_split_clause5261);
            rel375=rel();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, rel375.getTree());


            if ( state.backtracking==0 ) {
                      SourceLocation loc = new SourceLocation( (PigParserNode)SPLIT374 );
                      ((statement_scope)statement_stack.peek()).inputAlias = builder.buildSplitOp( loc, ((statement_scope)statement_stack.peek()).inputAlias );
                  }

            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1703:7: ( split_branch )+
            int cnt120=0;
            loop120:
            do {
                int alt120=2;
                int LA120_0 = input.LA(1);

                if ( (LA120_0==SPLIT_BRANCH) ) {
                    alt120=1;
                }


                switch (alt120) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1703:7: split_branch
            	    {
            	    _last = (CommonTree)input.LT(1);
            	    pushFollow(FOLLOW_split_branch_in_split_clause5277);
            	    split_branch376=split_branch();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) 
            	    adaptor.addChild(root_1, split_branch376.getTree());


            	    if ( state.backtracking==0 ) {
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt120 >= 1 ) break loop120;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(120, input);
                        throw eee;
                }
                cnt120++;
            } while (true);


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1703:21: ( split_otherwise )?
            int alt121=2;
            int LA121_0 = input.LA(1);

            if ( (LA121_0==OTHERWISE) ) {
                alt121=1;
            }
            switch (alt121) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1703:21: split_otherwise
                    {
                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_split_otherwise_in_split_clause5280);
                    split_otherwise377=split_otherwise();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_1, split_otherwise377.getTree());


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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1707:1: split_branch : ^( SPLIT_BRANCH alias cond[splitPlan] ) ;
    public final LogicalPlanGenerator.split_branch_return split_branch() throws RecognitionException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.split_branch_return retval = new LogicalPlanGenerator.split_branch_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree SPLIT_BRANCH378=null;
        LogicalPlanGenerator.alias_return alias379 =null;

        LogicalPlanGenerator.cond_return cond380 =null;


        CommonTree SPLIT_BRANCH378_tree=null;


            LogicalExpressionPlan splitPlan = new LogicalExpressionPlan();
            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createSplitOutputOp();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1713:2: ( ^( SPLIT_BRANCH alias cond[splitPlan] ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1713:4: ^( SPLIT_BRANCH alias cond[splitPlan] )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            SPLIT_BRANCH378=(CommonTree)match(input,SPLIT_BRANCH,FOLLOW_SPLIT_BRANCH_in_split_branch5309); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SPLIT_BRANCH378_tree = (CommonTree)adaptor.dupNode(SPLIT_BRANCH378);


            root_1 = (CommonTree)adaptor.becomeRoot(SPLIT_BRANCH378_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_branch5311);
            alias379=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias379.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_cond_in_split_branch5313);
            cond380=cond(splitPlan);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, cond380.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)(alias379!=null?((CommonTree)alias379.start):null) );
                   builder.buildSplitOutputOp( loc, (LOSplitOutput)((GScope_scope)GScope_stack.peek()).currentOp, (alias379!=null?alias379.name:null),
                       ((statement_scope)statement_stack.peek()).inputAlias, splitPlan );
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
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "split_branch"


    public static class split_otherwise_return extends TreeRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "split_otherwise"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1721:1: split_otherwise : ^( OTHERWISE alias ) ;
    public final LogicalPlanGenerator.split_otherwise_return split_otherwise() throws RecognitionException, PlanGenerationFailureException {
        GScope_stack.push(new GScope_scope());

        LogicalPlanGenerator.split_otherwise_return retval = new LogicalPlanGenerator.split_otherwise_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree OTHERWISE381=null;
        LogicalPlanGenerator.alias_return alias382 =null;


        CommonTree OTHERWISE381_tree=null;


            ((GScope_scope)GScope_stack.peek()).currentOp = builder.createSplitOutputOp();

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1726:2: ( ^( OTHERWISE alias ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1726:4: ^( OTHERWISE alias )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            OTHERWISE381=(CommonTree)match(input,OTHERWISE,FOLLOW_OTHERWISE_in_split_otherwise5347); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OTHERWISE381_tree = (CommonTree)adaptor.dupNode(OTHERWISE381);


            root_1 = (CommonTree)adaptor.becomeRoot(OTHERWISE381_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_alias_in_split_otherwise5349);
            alias382=alias();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, alias382.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   SourceLocation loc = new SourceLocation( (PigParserNode)(alias382!=null?((CommonTree)alias382.start):null) );
                   builder.buildSplitOtherwiseOp( loc, (LOSplitOutput)((GScope_scope)GScope_stack.peek()).currentOp, (alias382!=null?alias382.name:null),
                       ((statement_scope)statement_stack.peek()).inputAlias);
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
            GScope_stack.pop();

        }
        return retval;
    }
    // $ANTLR end "split_otherwise"


    public static class col_ref_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "col_ref"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1734:1: col_ref[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ( alias_col_ref[$plan] | dollar_col_ref[$plan] );
    public final LogicalPlanGenerator.col_ref_return col_ref(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.col_ref_return retval = new LogicalPlanGenerator.col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.alias_col_ref_return alias_col_ref383 =null;

        LogicalPlanGenerator.dollar_col_ref_return dollar_col_ref384 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1735:2: ( alias_col_ref[$plan] | dollar_col_ref[$plan] )
            int alt122=2;
            int LA122_0 = input.LA(1);

            if ( (LA122_0==CUBE||LA122_0==GROUP||LA122_0==IDENTIFIER) ) {
                alt122=1;
            }
            else if ( (LA122_0==DOLLARVAR) ) {
                alt122=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 122, 0, input);

                throw nvae;

            }
            switch (alt122) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1735:4: alias_col_ref[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_alias_col_ref_in_col_ref5369);
                    alias_col_ref383=alias_col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, alias_col_ref383.getTree());


                    if ( state.backtracking==0 ) { retval.expr = (alias_col_ref383!=null?alias_col_ref383.expr:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1736:4: dollar_col_ref[$plan]
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_dollar_col_ref_in_col_ref5377);
                    dollar_col_ref384=dollar_col_ref(plan);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, dollar_col_ref384.getTree());


                    if ( state.backtracking==0 ) { retval.expr = (dollar_col_ref384!=null?dollar_col_ref384.expr:null); }

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
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alias_col_ref"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1739:1: alias_col_ref[LogicalExpressionPlan plan] returns [LogicalExpression expr] : ( GROUP | CUBE | IDENTIFIER );
    public final LogicalPlanGenerator.alias_col_ref_return alias_col_ref(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.alias_col_ref_return retval = new LogicalPlanGenerator.alias_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree GROUP385=null;
        CommonTree CUBE386=null;
        CommonTree IDENTIFIER387=null;

        CommonTree GROUP385_tree=null;
        CommonTree CUBE386_tree=null;
        CommonTree IDENTIFIER387_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1740:2: ( GROUP | CUBE | IDENTIFIER )
            int alt123=3;
            switch ( input.LA(1) ) {
            case GROUP:
                {
                alt123=1;
                }
                break;
            case CUBE:
                {
                alt123=2;
                }
                break;
            case IDENTIFIER:
                {
                alt123=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 123, 0, input);

                throw nvae;

            }

            switch (alt123) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1740:4: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP385=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_alias_col_ref5394); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP385_tree = (CommonTree)adaptor.dupNode(GROUP385);


                    adaptor.addChild(root_0, GROUP385_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = builder.buildProjectExpr( new SourceLocation( (PigParserNode)GROUP385 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                               ((statement_scope)statement_stack.peek()).inputIndex, (GROUP385!=null?GROUP385.getText():null), 0 );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1745:4: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE386=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_alias_col_ref5404); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE386_tree = (CommonTree)adaptor.dupNode(CUBE386);


                    adaptor.addChild(root_0, CUBE386_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.expr = builder.buildProjectExpr( new SourceLocation( (PigParserNode)CUBE386 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                               ((statement_scope)statement_stack.peek()).inputIndex, (CUBE386!=null?CUBE386.getText():null), 0 );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1750:4: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER387=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_alias_col_ref5414); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER387_tree = (CommonTree)adaptor.dupNode(IDENTIFIER387);


                    adaptor.addChild(root_0, IDENTIFIER387_tree);
                    }


                    if ( state.backtracking==0 ) {
                           SourceLocation loc = new SourceLocation( (PigParserNode)IDENTIFIER387 );
                           String alias = (IDENTIFIER387!=null?IDENTIFIER387.getText():null);
                           Operator inOp = builder.lookupOperator( ((statement_scope)statement_stack.peek()).inputAlias );
                           if(null == inOp)
                           {
                               throw new UndefinedAliasException (input,loc,((statement_scope)statement_stack.peek()).inputAlias);
                           }
                           LogicalSchema schema;
                           try {
                               schema = ((LogicalRelationalOperator)inOp).getSchema();
                           } catch (FrontendException e) {
                               throw new PlanGenerationFailureException( input, loc, e );
                           }

                           Operator op = builder.lookupOperator( alias );
                           if( op != null && ( schema == null || schema.getFieldPosition( alias ) == -1 ) ) {
                               retval.expr = new ScalarExpression( plan, op,
                                   inForeachPlan ? ((foreach_clause_scope)foreach_clause_stack.peek()).foreachOp : ((GScope_scope)GScope_stack.peek()).currentOp );
                               retval.expr.setLocation( loc );
                           } else {
                               if( inForeachPlan ) {
                                   retval.expr = builder.buildProjectExpr( loc, plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                                        ((foreach_plan_scope)foreach_plan_stack.peek()).operators, ((foreach_plan_scope)foreach_plan_stack.peek()).exprPlans, alias, 0 );
                               } else {
                                   retval.expr = builder.buildProjectExpr( loc, plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                                       ((statement_scope)statement_stack.peek()).inputIndex, alias, 0 );
                               }
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
    // $ANTLR end "alias_col_ref"


    public static class dollar_col_ref_return extends TreeRuleReturnScope {
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "dollar_col_ref"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1783:1: dollar_col_ref[LogicalExpressionPlan plan] returns [LogicalExpression expr] : DOLLARVAR ;
    public final LogicalPlanGenerator.dollar_col_ref_return dollar_col_ref(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.dollar_col_ref_return retval = new LogicalPlanGenerator.dollar_col_ref_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree DOLLARVAR388=null;

        CommonTree DOLLARVAR388_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1784:2: ( DOLLARVAR )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1784:4: DOLLARVAR
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            DOLLARVAR388=(CommonTree)match(input,DOLLARVAR,FOLLOW_DOLLARVAR_in_dollar_col_ref5433); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOLLARVAR388_tree = (CommonTree)adaptor.dupNode(DOLLARVAR388);


            adaptor.addChild(root_0, DOLLARVAR388_tree);
            }


            if ( state.backtracking==0 ) {
                   int col = builder.undollar( (DOLLARVAR388!=null?DOLLARVAR388.getText():null) );
                   retval.expr = builder.buildProjectExpr( new SourceLocation( (PigParserNode)DOLLARVAR388 ), plan, ((GScope_scope)GScope_stack.peek()).currentOp,
                       ((statement_scope)statement_stack.peek()).inputIndex, null, col );
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
        public LogicalExpression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "const_expr"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1792:1: const_expr[LogicalExpressionPlan plan] returns [LogicalExpression expr] : literal ;
    public final LogicalPlanGenerator.const_expr_return const_expr(LogicalExpressionPlan plan) throws RecognitionException {
        LogicalPlanGenerator.const_expr_return retval = new LogicalPlanGenerator.const_expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.literal_return literal389 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1793:2: ( literal )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1793:4: literal
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_literal_in_const_expr5452);
            literal389=literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_0, literal389.getTree());


            if ( state.backtracking==0 ) {
                   retval.expr = new ConstantExpression( plan, (literal389!=null?literal389.value:null));
                   retval.expr.setLocation( new SourceLocation( (PigParserNode)((CommonTree)retval.start) ) );
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
    // $ANTLR end "const_expr"


    public static class literal_return extends TreeRuleReturnScope {
        public Object value;
        public byte type;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "literal"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1800:1: literal returns [Object value, byte type] : ( scalar | map | bag | tuple );
    public final LogicalPlanGenerator.literal_return literal() throws RecognitionException {
        LogicalPlanGenerator.literal_return retval = new LogicalPlanGenerator.literal_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        LogicalPlanGenerator.scalar_return scalar390 =null;

        LogicalPlanGenerator.map_return map391 =null;

        LogicalPlanGenerator.bag_return bag392 =null;

        LogicalPlanGenerator.tuple_return tuple393 =null;



        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1801:2: ( scalar | map | bag | tuple )
            int alt124=4;
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
                alt124=1;
                }
                break;
            case MAP_VAL:
                {
                alt124=2;
                }
                break;
            case BAG_VAL:
                {
                alt124=3;
                }
                break;
            case TUPLE_VAL:
                {
                alt124=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 124, 0, input);

                throw nvae;

            }

            switch (alt124) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1801:4: scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_scalar_in_literal5470);
                    scalar390=scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, scalar390.getTree());


                    if ( state.backtracking==0 ) {
                           retval.value = (scalar390!=null?scalar390.value:null);
                           retval.type = (scalar390!=null?scalar390.type:0);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1806:4: map
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_map_in_literal5480);
                    map391=map();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, map391.getTree());


                    if ( state.backtracking==0 ) {
                           retval.value = (map391!=null?map391.value:null);
                           retval.type = DataType.MAP;
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1811:4: bag
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_bag_in_literal5490);
                    bag392=bag();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, bag392.getTree());


                    if ( state.backtracking==0 ) {
                           retval.value = (bag392!=null?bag392.value:null);
                           retval.type = DataType.BAG;
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1816:4: tuple
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_tuple_in_literal5500);
                    tuple393=tuple();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, tuple393.getTree());


                    if ( state.backtracking==0 ) {
                           retval.value = (tuple393!=null?tuple393.value:null);
                           retval.type = DataType.TUPLE;
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
    // $ANTLR end "literal"


    public static class scalar_return extends TreeRuleReturnScope {
        public Object value;
        public byte type;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "scalar"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1823:1: scalar returns [Object value, byte type] : ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE );
    public final LogicalPlanGenerator.scalar_return scalar() throws RecognitionException {
        LogicalPlanGenerator.scalar_return retval = new LogicalPlanGenerator.scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING395=null;
        CommonTree NULL396=null;
        CommonTree TRUE397=null;
        CommonTree FALSE398=null;
        LogicalPlanGenerator.num_scalar_return num_scalar394 =null;


        CommonTree QUOTEDSTRING395_tree=null;
        CommonTree NULL396_tree=null;
        CommonTree TRUE397_tree=null;
        CommonTree FALSE398_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1824:2: ( num_scalar | QUOTEDSTRING | NULL | TRUE | FALSE )
            int alt125=5;
            switch ( input.LA(1) ) {
            case BIGDECIMALNUMBER:
            case BIGINTEGERNUMBER:
            case DOUBLENUMBER:
            case FLOATNUMBER:
            case INTEGER:
            case LONGINTEGER:
            case MINUS:
                {
                alt125=1;
                }
                break;
            case QUOTEDSTRING:
                {
                alt125=2;
                }
                break;
            case NULL:
                {
                alt125=3;
                }
                break;
            case TRUE:
                {
                alt125=4;
                }
                break;
            case FALSE:
                {
                alt125=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 125, 0, input);

                throw nvae;

            }

            switch (alt125) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1824:4: num_scalar
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_num_scalar_in_scalar5518);
                    num_scalar394=num_scalar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, num_scalar394.getTree());


                    if ( state.backtracking==0 ) {
                           retval.type = (num_scalar394!=null?num_scalar394.type:0);
                           retval.value = (num_scalar394!=null?num_scalar394.value:null);
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1829:4: QUOTEDSTRING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    QUOTEDSTRING395=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_scalar5528); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUOTEDSTRING395_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING395);


                    adaptor.addChild(root_0, QUOTEDSTRING395_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.type = DataType.CHARARRAY;
                           retval.value = builder.unquote( (QUOTEDSTRING395!=null?QUOTEDSTRING395.getText():null) );
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1834:4: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL396=(CommonTree)match(input,NULL,FOLLOW_NULL_in_scalar5538); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL396_tree = (CommonTree)adaptor.dupNode(NULL396);


                    adaptor.addChild(root_0, NULL396_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.type = DataType.NULL;
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1838:4: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE397=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_scalar5548); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE397_tree = (CommonTree)adaptor.dupNode(TRUE397);


                    adaptor.addChild(root_0, TRUE397_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.type = DataType.BOOLEAN;
                           retval.value = Boolean.TRUE;
                       }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1843:4: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE398=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_scalar5558); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE398_tree = (CommonTree)adaptor.dupNode(FALSE398);


                    adaptor.addChild(root_0, FALSE398_tree);
                    }


                    if ( state.backtracking==0 ) {
                           retval.type = DataType.BOOLEAN;
                           retval.value = Boolean.FALSE;
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
        public Object value;
        public byte type;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "num_scalar"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1850:1: num_scalar returns [Object value, byte type] : ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER ) ;
    public final LogicalPlanGenerator.num_scalar_return num_scalar() throws RecognitionException {
        LogicalPlanGenerator.num_scalar_return retval = new LogicalPlanGenerator.num_scalar_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MINUS399=null;
        CommonTree INTEGER400=null;
        CommonTree LONGINTEGER401=null;
        CommonTree FLOATNUMBER402=null;
        CommonTree DOUBLENUMBER403=null;
        CommonTree BIGINTEGERNUMBER404=null;
        CommonTree BIGDECIMALNUMBER405=null;

        CommonTree MINUS399_tree=null;
        CommonTree INTEGER400_tree=null;
        CommonTree LONGINTEGER401_tree=null;
        CommonTree FLOATNUMBER402_tree=null;
        CommonTree DOUBLENUMBER403_tree=null;
        CommonTree BIGINTEGERNUMBER404_tree=null;
        CommonTree BIGDECIMALNUMBER405_tree=null;


            int sign = 1;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1854:2: ( ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1854:4: ( MINUS )? ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER )
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1854:4: ( MINUS )?
            int alt126=2;
            int LA126_0 = input.LA(1);

            if ( (LA126_0==MINUS) ) {
                alt126=1;
            }
            switch (alt126) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1854:6: MINUS
                    {
                    _last = (CommonTree)input.LT(1);
                    MINUS399=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_num_scalar5583); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS399_tree = (CommonTree)adaptor.dupNode(MINUS399);


                    adaptor.addChild(root_0, MINUS399_tree);
                    }


                    if ( state.backtracking==0 ) { sign = -1; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;

            }


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1855:4: ( INTEGER | LONGINTEGER | FLOATNUMBER | DOUBLENUMBER | BIGINTEGERNUMBER | BIGDECIMALNUMBER )
            int alt127=6;
            switch ( input.LA(1) ) {
            case INTEGER:
                {
                alt127=1;
                }
                break;
            case LONGINTEGER:
                {
                alt127=2;
                }
                break;
            case FLOATNUMBER:
                {
                alt127=3;
                }
                break;
            case DOUBLENUMBER:
                {
                alt127=4;
                }
                break;
            case BIGINTEGERNUMBER:
                {
                alt127=5;
                }
                break;
            case BIGDECIMALNUMBER:
                {
                alt127=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 127, 0, input);

                throw nvae;

            }

            switch (alt127) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1855:6: INTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    INTEGER400=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_num_scalar5596); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER400_tree = (CommonTree)adaptor.dupNode(INTEGER400);


                    adaptor.addChild(root_0, INTEGER400_tree);
                    }


                    if ( state.backtracking==0 ) {
                             retval.type = DataType.INTEGER;
                             retval.value = sign * Integer.valueOf( (INTEGER400!=null?INTEGER400.getText():null) );
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1860:6: LONGINTEGER
                    {
                    _last = (CommonTree)input.LT(1);
                    LONGINTEGER401=(CommonTree)match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_num_scalar5610); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONGINTEGER401_tree = (CommonTree)adaptor.dupNode(LONGINTEGER401);


                    adaptor.addChild(root_0, LONGINTEGER401_tree);
                    }


                    if ( state.backtracking==0 ) {
                             retval.type = DataType.LONG;
                             retval.value = sign * builder.parseLong( (LONGINTEGER401!=null?LONGINTEGER401.getText():null) );
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1865:6: FLOATNUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    FLOATNUMBER402=(CommonTree)match(input,FLOATNUMBER,FOLLOW_FLOATNUMBER_in_num_scalar5624); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOATNUMBER402_tree = (CommonTree)adaptor.dupNode(FLOATNUMBER402);


                    adaptor.addChild(root_0, FLOATNUMBER402_tree);
                    }


                    if ( state.backtracking==0 ) {
                             retval.type = DataType.FLOAT;
                             retval.value = sign * Float.valueOf( (FLOATNUMBER402!=null?FLOATNUMBER402.getText():null) );
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1870:6: DOUBLENUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    DOUBLENUMBER403=(CommonTree)match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_num_scalar5638); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLENUMBER403_tree = (CommonTree)adaptor.dupNode(DOUBLENUMBER403);


                    adaptor.addChild(root_0, DOUBLENUMBER403_tree);
                    }


                    if ( state.backtracking==0 ) {
                             retval.type = DataType.DOUBLE;
                             retval.value = sign * Double.valueOf( (DOUBLENUMBER403!=null?DOUBLENUMBER403.getText():null) );
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1875:6: BIGINTEGERNUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    BIGINTEGERNUMBER404=(CommonTree)match(input,BIGINTEGERNUMBER,FOLLOW_BIGINTEGERNUMBER_in_num_scalar5652); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGINTEGERNUMBER404_tree = (CommonTree)adaptor.dupNode(BIGINTEGERNUMBER404);


                    adaptor.addChild(root_0, BIGINTEGERNUMBER404_tree);
                    }


                    if ( state.backtracking==0 ) {
                             retval.type = DataType.BIGINTEGER;
                             retval.value = builder.parseBigInteger( (BIGINTEGERNUMBER404!=null?BIGINTEGERNUMBER404.getText():null) );
                             if ( sign == -1 ) {
                                 retval.value = ((BigInteger)retval.value).negate();
                             }
                         }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1883:6: BIGDECIMALNUMBER
                    {
                    _last = (CommonTree)input.LT(1);
                    BIGDECIMALNUMBER405=(CommonTree)match(input,BIGDECIMALNUMBER,FOLLOW_BIGDECIMALNUMBER_in_num_scalar5666); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGDECIMALNUMBER405_tree = (CommonTree)adaptor.dupNode(BIGDECIMALNUMBER405);


                    adaptor.addChild(root_0, BIGDECIMALNUMBER405_tree);
                    }


                    if ( state.backtracking==0 ) {
                             retval.type = DataType.BIGDECIMAL;
                             retval.value = builder.parseBigDecimal( (BIGDECIMALNUMBER405!=null?BIGDECIMALNUMBER405.getText():null) );
                             if ( sign == -1 ) {
                                 retval.value = ((BigDecimal)retval.value).negate();
                             }
                         }

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
    // $ANTLR end "num_scalar"


    public static class map_return extends TreeRuleReturnScope {
        public Object value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1894:1: map returns [Object value] : ^( MAP_VAL ( keyvalue )* ) ;
    public final LogicalPlanGenerator.map_return map() throws RecognitionException {
        LogicalPlanGenerator.map_return retval = new LogicalPlanGenerator.map_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree MAP_VAL406=null;
        LogicalPlanGenerator.keyvalue_return keyvalue407 =null;


        CommonTree MAP_VAL406_tree=null;

         Map<String, Object> kvs = new HashMap<String, Object>(); 
        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1896:2: ( ^( MAP_VAL ( keyvalue )* ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1896:4: ^( MAP_VAL ( keyvalue )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            MAP_VAL406=(CommonTree)match(input,MAP_VAL,FOLLOW_MAP_VAL_in_map5698); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            MAP_VAL406_tree = (CommonTree)adaptor.dupNode(MAP_VAL406);


            root_1 = (CommonTree)adaptor.becomeRoot(MAP_VAL406_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1896:15: ( keyvalue )*
                loop128:
                do {
                    int alt128=2;
                    int LA128_0 = input.LA(1);

                    if ( (LA128_0==KEY_VAL_PAIR) ) {
                        alt128=1;
                    }


                    switch (alt128) {
                	case 1 :
                	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1896:17: keyvalue
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_keyvalue_in_map5702);
                	    keyvalue407=keyvalue();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, keyvalue407.getTree());


                	    if ( state.backtracking==0 ) { kvs.put( (keyvalue407!=null?keyvalue407.key:null), (keyvalue407!=null?keyvalue407.value:null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop128;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.value = kvs;
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
        public String key;
        public Object value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "keyvalue"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1902:1: keyvalue returns [String key, Object value] : ^( KEY_VAL_PAIR map_key literal ) ;
    public final LogicalPlanGenerator.keyvalue_return keyvalue() throws RecognitionException {
        LogicalPlanGenerator.keyvalue_return retval = new LogicalPlanGenerator.keyvalue_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree KEY_VAL_PAIR408=null;
        LogicalPlanGenerator.map_key_return map_key409 =null;

        LogicalPlanGenerator.literal_return literal410 =null;


        CommonTree KEY_VAL_PAIR408_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1903:2: ( ^( KEY_VAL_PAIR map_key literal ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1903:4: ^( KEY_VAL_PAIR map_key literal )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            KEY_VAL_PAIR408=(CommonTree)match(input,KEY_VAL_PAIR,FOLLOW_KEY_VAL_PAIR_in_keyvalue5729); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            KEY_VAL_PAIR408_tree = (CommonTree)adaptor.dupNode(KEY_VAL_PAIR408);


            root_1 = (CommonTree)adaptor.becomeRoot(KEY_VAL_PAIR408_tree, root_1);
            }


            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_map_key_in_keyvalue5731);
            map_key409=map_key();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, map_key409.getTree());


            _last = (CommonTree)input.LT(1);
            pushFollow(FOLLOW_literal_in_keyvalue5733);
            literal410=literal();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) 
            adaptor.addChild(root_1, literal410.getTree());


            match(input, Token.UP, null); if (state.failed) return retval;
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.key = (map_key409!=null?map_key409.value:null);
                   retval.value = (literal410!=null?literal410.value:null);
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
        public String value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "map_key"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1910:1: map_key returns [String value] : QUOTEDSTRING ;
    public final LogicalPlanGenerator.map_key_return map_key() throws RecognitionException {
        LogicalPlanGenerator.map_key_return retval = new LogicalPlanGenerator.map_key_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree QUOTEDSTRING411=null;

        CommonTree QUOTEDSTRING411_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1911:2: ( QUOTEDSTRING )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1911:4: QUOTEDSTRING
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            QUOTEDSTRING411=(CommonTree)match(input,QUOTEDSTRING,FOLLOW_QUOTEDSTRING_in_map_key5753); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUOTEDSTRING411_tree = (CommonTree)adaptor.dupNode(QUOTEDSTRING411);


            adaptor.addChild(root_0, QUOTEDSTRING411_tree);
            }


            if ( state.backtracking==0 ) { retval.value = builder.unquote( (QUOTEDSTRING411!=null?QUOTEDSTRING411.getText():null) ); }

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
        public Object value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bag"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1914:1: bag returns [Object value] : ^( BAG_VAL ( tuple )* ) ;
    public final LogicalPlanGenerator.bag_return bag() throws RecognitionException {
        LogicalPlanGenerator.bag_return retval = new LogicalPlanGenerator.bag_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree BAG_VAL412=null;
        LogicalPlanGenerator.tuple_return tuple413 =null;


        CommonTree BAG_VAL412_tree=null;

         DataBag dataBag = builder.createDataBag(); 
        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1916:2: ( ^( BAG_VAL ( tuple )* ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1916:4: ^( BAG_VAL ( tuple )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            BAG_VAL412=(CommonTree)match(input,BAG_VAL,FOLLOW_BAG_VAL_in_bag5775); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            BAG_VAL412_tree = (CommonTree)adaptor.dupNode(BAG_VAL412);


            root_1 = (CommonTree)adaptor.becomeRoot(BAG_VAL412_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1916:15: ( tuple )*
                loop129:
                do {
                    int alt129=2;
                    int LA129_0 = input.LA(1);

                    if ( (LA129_0==TUPLE_VAL) ) {
                        alt129=1;
                    }


                    switch (alt129) {
                	case 1 :
                	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1916:17: tuple
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_tuple_in_bag5779);
                	    tuple413=tuple();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, tuple413.getTree());


                	    if ( state.backtracking==0 ) { dataBag.add( (tuple413!=null?tuple413.value:null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop129;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.value = dataBag;
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
        public Tuple value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tuple"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1922:1: tuple returns [Tuple value] : ^( TUPLE_VAL ( literal )* ) ;
    public final LogicalPlanGenerator.tuple_return tuple() throws RecognitionException {
        LogicalPlanGenerator.tuple_return retval = new LogicalPlanGenerator.tuple_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree TUPLE_VAL414=null;
        LogicalPlanGenerator.literal_return literal415 =null;


        CommonTree TUPLE_VAL414_tree=null;

         List<Object> objList = new ArrayList<Object>(); 
        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1924:2: ( ^( TUPLE_VAL ( literal )* ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1924:4: ^( TUPLE_VAL ( literal )* )
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            {
            CommonTree _save_last_1 = _last;
            CommonTree _first_1 = null;
            CommonTree root_1 = (CommonTree)adaptor.nil();
            _last = (CommonTree)input.LT(1);
            TUPLE_VAL414=(CommonTree)match(input,TUPLE_VAL,FOLLOW_TUPLE_VAL_in_tuple5811); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TUPLE_VAL414_tree = (CommonTree)adaptor.dupNode(TUPLE_VAL414);


            root_1 = (CommonTree)adaptor.becomeRoot(TUPLE_VAL414_tree, root_1);
            }


            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1924:17: ( literal )*
                loop130:
                do {
                    int alt130=2;
                    int LA130_0 = input.LA(1);

                    if ( (LA130_0==BIGDECIMALNUMBER||LA130_0==BIGINTEGERNUMBER||LA130_0==DOUBLENUMBER||LA130_0==FALSE||LA130_0==FLOATNUMBER||LA130_0==INTEGER||LA130_0==LONGINTEGER||LA130_0==MINUS||LA130_0==NULL||LA130_0==QUOTEDSTRING||LA130_0==TRUE||LA130_0==BAG_VAL||LA130_0==MAP_VAL||LA130_0==TUPLE_VAL) ) {
                        alt130=1;
                    }


                    switch (alt130) {
                	case 1 :
                	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1924:19: literal
                	    {
                	    _last = (CommonTree)input.LT(1);
                	    pushFollow(FOLLOW_literal_in_tuple5815);
                	    literal415=literal();

                	    state._fsp--;
                	    if (state.failed) return retval;
                	    if ( state.backtracking==0 ) 
                	    adaptor.addChild(root_1, literal415.getTree());


                	    if ( state.backtracking==0 ) { objList.add( (literal415!=null?literal415.value:null) ); }

                	    if ( state.backtracking==0 ) {
                	    }
                	    }
                	    break;

                	default :
                	    break loop130;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }
            adaptor.addChild(root_0, root_1);
            _last = _save_last_1;
            }


            if ( state.backtracking==0 ) {
                   retval.value = builder.buildTuple( objList );
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
        public String id;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "eid"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1931:1: eid returns [String id] : ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | MATCHES | ORDER | DISTINCT | COGROUP | CUBE | ROLLUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE | ASSERT );
    public final LogicalPlanGenerator.eid_return eid() throws RecognitionException {
        LogicalPlanGenerator.eid_return retval = new LogicalPlanGenerator.eid_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree IMPORT417=null;
        CommonTree RETURNS418=null;
        CommonTree DEFINE419=null;
        CommonTree LOAD420=null;
        CommonTree FILTER421=null;
        CommonTree FOREACH422=null;
        CommonTree MATCHES423=null;
        CommonTree ORDER424=null;
        CommonTree DISTINCT425=null;
        CommonTree COGROUP426=null;
        CommonTree CUBE427=null;
        CommonTree ROLLUP428=null;
        CommonTree JOIN429=null;
        CommonTree CROSS430=null;
        CommonTree UNION431=null;
        CommonTree SPLIT432=null;
        CommonTree INTO433=null;
        CommonTree IF434=null;
        CommonTree ALL435=null;
        CommonTree AS436=null;
        CommonTree BY437=null;
        CommonTree USING438=null;
        CommonTree INNER439=null;
        CommonTree OUTER440=null;
        CommonTree PARALLEL441=null;
        CommonTree PARTITION442=null;
        CommonTree GROUP443=null;
        CommonTree AND444=null;
        CommonTree OR445=null;
        CommonTree NOT446=null;
        CommonTree GENERATE447=null;
        CommonTree FLATTEN448=null;
        CommonTree EVAL449=null;
        CommonTree ASC450=null;
        CommonTree DESC451=null;
        CommonTree BOOLEAN452=null;
        CommonTree INT453=null;
        CommonTree LONG454=null;
        CommonTree FLOAT455=null;
        CommonTree DOUBLE456=null;
        CommonTree BIGINTEGER457=null;
        CommonTree BIGDECIMAL458=null;
        CommonTree DATETIME459=null;
        CommonTree CHARARRAY460=null;
        CommonTree BYTEARRAY461=null;
        CommonTree BAG462=null;
        CommonTree TUPLE463=null;
        CommonTree MAP464=null;
        CommonTree IS465=null;
        CommonTree NULL466=null;
        CommonTree TRUE467=null;
        CommonTree FALSE468=null;
        CommonTree STREAM469=null;
        CommonTree THROUGH470=null;
        CommonTree STORE471=null;
        CommonTree MAPREDUCE472=null;
        CommonTree SHIP473=null;
        CommonTree CACHE474=null;
        CommonTree INPUT475=null;
        CommonTree OUTPUT476=null;
        CommonTree STDERROR477=null;
        CommonTree STDIN478=null;
        CommonTree STDOUT479=null;
        CommonTree LIMIT480=null;
        CommonTree SAMPLE481=null;
        CommonTree LEFT482=null;
        CommonTree RIGHT483=null;
        CommonTree FULL484=null;
        CommonTree IDENTIFIER485=null;
        CommonTree TOBAG486=null;
        CommonTree TOMAP487=null;
        CommonTree TOTUPLE488=null;
        CommonTree ASSERT489=null;
        LogicalPlanGenerator.rel_str_op_return rel_str_op416 =null;


        CommonTree IMPORT417_tree=null;
        CommonTree RETURNS418_tree=null;
        CommonTree DEFINE419_tree=null;
        CommonTree LOAD420_tree=null;
        CommonTree FILTER421_tree=null;
        CommonTree FOREACH422_tree=null;
        CommonTree MATCHES423_tree=null;
        CommonTree ORDER424_tree=null;
        CommonTree DISTINCT425_tree=null;
        CommonTree COGROUP426_tree=null;
        CommonTree CUBE427_tree=null;
        CommonTree ROLLUP428_tree=null;
        CommonTree JOIN429_tree=null;
        CommonTree CROSS430_tree=null;
        CommonTree UNION431_tree=null;
        CommonTree SPLIT432_tree=null;
        CommonTree INTO433_tree=null;
        CommonTree IF434_tree=null;
        CommonTree ALL435_tree=null;
        CommonTree AS436_tree=null;
        CommonTree BY437_tree=null;
        CommonTree USING438_tree=null;
        CommonTree INNER439_tree=null;
        CommonTree OUTER440_tree=null;
        CommonTree PARALLEL441_tree=null;
        CommonTree PARTITION442_tree=null;
        CommonTree GROUP443_tree=null;
        CommonTree AND444_tree=null;
        CommonTree OR445_tree=null;
        CommonTree NOT446_tree=null;
        CommonTree GENERATE447_tree=null;
        CommonTree FLATTEN448_tree=null;
        CommonTree EVAL449_tree=null;
        CommonTree ASC450_tree=null;
        CommonTree DESC451_tree=null;
        CommonTree BOOLEAN452_tree=null;
        CommonTree INT453_tree=null;
        CommonTree LONG454_tree=null;
        CommonTree FLOAT455_tree=null;
        CommonTree DOUBLE456_tree=null;
        CommonTree BIGINTEGER457_tree=null;
        CommonTree BIGDECIMAL458_tree=null;
        CommonTree DATETIME459_tree=null;
        CommonTree CHARARRAY460_tree=null;
        CommonTree BYTEARRAY461_tree=null;
        CommonTree BAG462_tree=null;
        CommonTree TUPLE463_tree=null;
        CommonTree MAP464_tree=null;
        CommonTree IS465_tree=null;
        CommonTree NULL466_tree=null;
        CommonTree TRUE467_tree=null;
        CommonTree FALSE468_tree=null;
        CommonTree STREAM469_tree=null;
        CommonTree THROUGH470_tree=null;
        CommonTree STORE471_tree=null;
        CommonTree MAPREDUCE472_tree=null;
        CommonTree SHIP473_tree=null;
        CommonTree CACHE474_tree=null;
        CommonTree INPUT475_tree=null;
        CommonTree OUTPUT476_tree=null;
        CommonTree STDERROR477_tree=null;
        CommonTree STDIN478_tree=null;
        CommonTree STDOUT479_tree=null;
        CommonTree LIMIT480_tree=null;
        CommonTree SAMPLE481_tree=null;
        CommonTree LEFT482_tree=null;
        CommonTree RIGHT483_tree=null;
        CommonTree FULL484_tree=null;
        CommonTree IDENTIFIER485_tree=null;
        CommonTree TOBAG486_tree=null;
        CommonTree TOMAP487_tree=null;
        CommonTree TOTUPLE488_tree=null;
        CommonTree ASSERT489_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1931:24: ( rel_str_op | IMPORT | RETURNS | DEFINE | LOAD | FILTER | FOREACH | MATCHES | ORDER | DISTINCT | COGROUP | CUBE | ROLLUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | ALL | AS | BY | USING | INNER | OUTER | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | EVAL | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | DOUBLE | BIGINTEGER | BIGDECIMAL | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | NULL | TRUE | FALSE | STREAM | THROUGH | STORE | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | IDENTIFIER | TOBAG | TOMAP | TOTUPLE | ASSERT )
            int alt131=74;
            switch ( input.LA(1) ) {
            case STR_OP_EQ:
            case STR_OP_GT:
            case STR_OP_GTE:
            case STR_OP_LT:
            case STR_OP_LTE:
            case STR_OP_MATCHES:
            case STR_OP_NE:
                {
                alt131=1;
                }
                break;
            case IMPORT:
                {
                alt131=2;
                }
                break;
            case RETURNS:
                {
                alt131=3;
                }
                break;
            case DEFINE:
                {
                alt131=4;
                }
                break;
            case LOAD:
                {
                alt131=5;
                }
                break;
            case FILTER:
                {
                alt131=6;
                }
                break;
            case FOREACH:
                {
                alt131=7;
                }
                break;
            case MATCHES:
                {
                alt131=8;
                }
                break;
            case ORDER:
                {
                alt131=9;
                }
                break;
            case DISTINCT:
                {
                alt131=10;
                }
                break;
            case COGROUP:
                {
                alt131=11;
                }
                break;
            case CUBE:
                {
                alt131=12;
                }
                break;
            case ROLLUP:
                {
                alt131=13;
                }
                break;
            case JOIN:
                {
                alt131=14;
                }
                break;
            case CROSS:
                {
                alt131=15;
                }
                break;
            case UNION:
                {
                alt131=16;
                }
                break;
            case SPLIT:
                {
                alt131=17;
                }
                break;
            case INTO:
                {
                alt131=18;
                }
                break;
            case IF:
                {
                alt131=19;
                }
                break;
            case ALL:
                {
                alt131=20;
                }
                break;
            case AS:
                {
                alt131=21;
                }
                break;
            case BY:
                {
                alt131=22;
                }
                break;
            case USING:
                {
                alt131=23;
                }
                break;
            case INNER:
                {
                alt131=24;
                }
                break;
            case OUTER:
                {
                alt131=25;
                }
                break;
            case PARALLEL:
                {
                alt131=26;
                }
                break;
            case PARTITION:
                {
                alt131=27;
                }
                break;
            case GROUP:
                {
                alt131=28;
                }
                break;
            case AND:
                {
                alt131=29;
                }
                break;
            case OR:
                {
                alt131=30;
                }
                break;
            case NOT:
                {
                alt131=31;
                }
                break;
            case GENERATE:
                {
                alt131=32;
                }
                break;
            case FLATTEN:
                {
                alt131=33;
                }
                break;
            case EVAL:
                {
                alt131=34;
                }
                break;
            case ASC:
                {
                alt131=35;
                }
                break;
            case DESC:
                {
                alt131=36;
                }
                break;
            case BOOLEAN:
                {
                alt131=37;
                }
                break;
            case INT:
                {
                alt131=38;
                }
                break;
            case LONG:
                {
                alt131=39;
                }
                break;
            case FLOAT:
                {
                alt131=40;
                }
                break;
            case DOUBLE:
                {
                alt131=41;
                }
                break;
            case BIGINTEGER:
                {
                alt131=42;
                }
                break;
            case BIGDECIMAL:
                {
                alt131=43;
                }
                break;
            case DATETIME:
                {
                alt131=44;
                }
                break;
            case CHARARRAY:
                {
                alt131=45;
                }
                break;
            case BYTEARRAY:
                {
                alt131=46;
                }
                break;
            case BAG:
                {
                alt131=47;
                }
                break;
            case TUPLE:
                {
                alt131=48;
                }
                break;
            case MAP:
                {
                alt131=49;
                }
                break;
            case IS:
                {
                alt131=50;
                }
                break;
            case NULL:
                {
                alt131=51;
                }
                break;
            case TRUE:
                {
                alt131=52;
                }
                break;
            case FALSE:
                {
                alt131=53;
                }
                break;
            case STREAM:
                {
                alt131=54;
                }
                break;
            case THROUGH:
                {
                alt131=55;
                }
                break;
            case STORE:
                {
                alt131=56;
                }
                break;
            case MAPREDUCE:
                {
                alt131=57;
                }
                break;
            case SHIP:
                {
                alt131=58;
                }
                break;
            case CACHE:
                {
                alt131=59;
                }
                break;
            case INPUT:
                {
                alt131=60;
                }
                break;
            case OUTPUT:
                {
                alt131=61;
                }
                break;
            case STDERROR:
                {
                alt131=62;
                }
                break;
            case STDIN:
                {
                alt131=63;
                }
                break;
            case STDOUT:
                {
                alt131=64;
                }
                break;
            case LIMIT:
                {
                alt131=65;
                }
                break;
            case SAMPLE:
                {
                alt131=66;
                }
                break;
            case LEFT:
                {
                alt131=67;
                }
                break;
            case RIGHT:
                {
                alt131=68;
                }
                break;
            case FULL:
                {
                alt131=69;
                }
                break;
            case IDENTIFIER:
                {
                alt131=70;
                }
                break;
            case TOBAG:
                {
                alt131=71;
                }
                break;
            case TOMAP:
                {
                alt131=72;
                }
                break;
            case TOTUPLE:
                {
                alt131=73;
                }
                break;
            case ASSERT:
                {
                alt131=74;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 131, 0, input);

                throw nvae;

            }

            switch (alt131) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1931:26: rel_str_op
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_str_op_in_eid5840);
                    rel_str_op416=rel_str_op();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_str_op416.getTree());


                    if ( state.backtracking==0 ) { retval.id = (rel_str_op416!=null?rel_str_op416.id:null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1932:7: IMPORT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IMPORT417=(CommonTree)match(input,IMPORT,FOLLOW_IMPORT_in_eid5850); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IMPORT417_tree = (CommonTree)adaptor.dupNode(IMPORT417);


                    adaptor.addChild(root_0, IMPORT417_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (IMPORT417!=null?IMPORT417.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1933:7: RETURNS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RETURNS418=(CommonTree)match(input,RETURNS,FOLLOW_RETURNS_in_eid5860); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RETURNS418_tree = (CommonTree)adaptor.dupNode(RETURNS418);


                    adaptor.addChild(root_0, RETURNS418_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (RETURNS418!=null?RETURNS418.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1934:7: DEFINE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DEFINE419=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_eid5870); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFINE419_tree = (CommonTree)adaptor.dupNode(DEFINE419);


                    adaptor.addChild(root_0, DEFINE419_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (DEFINE419!=null?DEFINE419.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1935:7: LOAD
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LOAD420=(CommonTree)match(input,LOAD,FOLLOW_LOAD_in_eid5880); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LOAD420_tree = (CommonTree)adaptor.dupNode(LOAD420);


                    adaptor.addChild(root_0, LOAD420_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (LOAD420!=null?LOAD420.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1936:7: FILTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FILTER421=(CommonTree)match(input,FILTER,FOLLOW_FILTER_in_eid5890); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FILTER421_tree = (CommonTree)adaptor.dupNode(FILTER421);


                    adaptor.addChild(root_0, FILTER421_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FILTER421!=null?FILTER421.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1937:7: FOREACH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FOREACH422=(CommonTree)match(input,FOREACH,FOLLOW_FOREACH_in_eid5900); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FOREACH422_tree = (CommonTree)adaptor.dupNode(FOREACH422);


                    adaptor.addChild(root_0, FOREACH422_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FOREACH422!=null?FOREACH422.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 8 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1938:7: MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MATCHES423=(CommonTree)match(input,MATCHES,FOLLOW_MATCHES_in_eid5910); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MATCHES423_tree = (CommonTree)adaptor.dupNode(MATCHES423);


                    adaptor.addChild(root_0, MATCHES423_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (MATCHES423!=null?MATCHES423.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 9 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1939:7: ORDER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ORDER424=(CommonTree)match(input,ORDER,FOLLOW_ORDER_in_eid5920); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ORDER424_tree = (CommonTree)adaptor.dupNode(ORDER424);


                    adaptor.addChild(root_0, ORDER424_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (ORDER424!=null?ORDER424.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 10 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1940:7: DISTINCT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DISTINCT425=(CommonTree)match(input,DISTINCT,FOLLOW_DISTINCT_in_eid5930); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DISTINCT425_tree = (CommonTree)adaptor.dupNode(DISTINCT425);


                    adaptor.addChild(root_0, DISTINCT425_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (DISTINCT425!=null?DISTINCT425.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 11 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1941:7: COGROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    COGROUP426=(CommonTree)match(input,COGROUP,FOLLOW_COGROUP_in_eid5940); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COGROUP426_tree = (CommonTree)adaptor.dupNode(COGROUP426);


                    adaptor.addChild(root_0, COGROUP426_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (COGROUP426!=null?COGROUP426.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 12 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1942:7: CUBE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CUBE427=(CommonTree)match(input,CUBE,FOLLOW_CUBE_in_eid5950); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CUBE427_tree = (CommonTree)adaptor.dupNode(CUBE427);


                    adaptor.addChild(root_0, CUBE427_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (CUBE427!=null?CUBE427.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 13 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1943:7: ROLLUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ROLLUP428=(CommonTree)match(input,ROLLUP,FOLLOW_ROLLUP_in_eid5960); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ROLLUP428_tree = (CommonTree)adaptor.dupNode(ROLLUP428);


                    adaptor.addChild(root_0, ROLLUP428_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (ROLLUP428!=null?ROLLUP428.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 14 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1944:7: JOIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    JOIN429=(CommonTree)match(input,JOIN,FOLLOW_JOIN_in_eid5970); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    JOIN429_tree = (CommonTree)adaptor.dupNode(JOIN429);


                    adaptor.addChild(root_0, JOIN429_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (JOIN429!=null?JOIN429.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 15 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1945:7: CROSS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CROSS430=(CommonTree)match(input,CROSS,FOLLOW_CROSS_in_eid5980); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CROSS430_tree = (CommonTree)adaptor.dupNode(CROSS430);


                    adaptor.addChild(root_0, CROSS430_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (CROSS430!=null?CROSS430.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 16 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1946:7: UNION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    UNION431=(CommonTree)match(input,UNION,FOLLOW_UNION_in_eid5990); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    UNION431_tree = (CommonTree)adaptor.dupNode(UNION431);


                    adaptor.addChild(root_0, UNION431_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (UNION431!=null?UNION431.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 17 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1947:7: SPLIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SPLIT432=(CommonTree)match(input,SPLIT,FOLLOW_SPLIT_in_eid6000); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SPLIT432_tree = (CommonTree)adaptor.dupNode(SPLIT432);


                    adaptor.addChild(root_0, SPLIT432_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (SPLIT432!=null?SPLIT432.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 18 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1948:7: INTO
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INTO433=(CommonTree)match(input,INTO,FOLLOW_INTO_in_eid6010); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTO433_tree = (CommonTree)adaptor.dupNode(INTO433);


                    adaptor.addChild(root_0, INTO433_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (INTO433!=null?INTO433.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 19 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1949:7: IF
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IF434=(CommonTree)match(input,IF,FOLLOW_IF_in_eid6020); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IF434_tree = (CommonTree)adaptor.dupNode(IF434);


                    adaptor.addChild(root_0, IF434_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (IF434!=null?IF434.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 20 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1950:7: ALL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ALL435=(CommonTree)match(input,ALL,FOLLOW_ALL_in_eid6030); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALL435_tree = (CommonTree)adaptor.dupNode(ALL435);


                    adaptor.addChild(root_0, ALL435_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (ALL435!=null?ALL435.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 21 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1951:7: AS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AS436=(CommonTree)match(input,AS,FOLLOW_AS_in_eid6040); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AS436_tree = (CommonTree)adaptor.dupNode(AS436);


                    adaptor.addChild(root_0, AS436_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (AS436!=null?AS436.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 22 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1952:7: BY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BY437=(CommonTree)match(input,BY,FOLLOW_BY_in_eid6050); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BY437_tree = (CommonTree)adaptor.dupNode(BY437);


                    adaptor.addChild(root_0, BY437_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (BY437!=null?BY437.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 23 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1953:7: USING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    USING438=(CommonTree)match(input,USING,FOLLOW_USING_in_eid6060); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    USING438_tree = (CommonTree)adaptor.dupNode(USING438);


                    adaptor.addChild(root_0, USING438_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (USING438!=null?USING438.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 24 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1954:7: INNER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INNER439=(CommonTree)match(input,INNER,FOLLOW_INNER_in_eid6070); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INNER439_tree = (CommonTree)adaptor.dupNode(INNER439);


                    adaptor.addChild(root_0, INNER439_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (INNER439!=null?INNER439.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 25 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1955:7: OUTER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTER440=(CommonTree)match(input,OUTER,FOLLOW_OUTER_in_eid6080); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTER440_tree = (CommonTree)adaptor.dupNode(OUTER440);


                    adaptor.addChild(root_0, OUTER440_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (OUTER440!=null?OUTER440.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 26 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1956:7: PARALLEL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARALLEL441=(CommonTree)match(input,PARALLEL,FOLLOW_PARALLEL_in_eid6090); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARALLEL441_tree = (CommonTree)adaptor.dupNode(PARALLEL441);


                    adaptor.addChild(root_0, PARALLEL441_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (PARALLEL441!=null?PARALLEL441.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 27 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1957:7: PARTITION
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    PARTITION442=(CommonTree)match(input,PARTITION,FOLLOW_PARTITION_in_eid6100); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PARTITION442_tree = (CommonTree)adaptor.dupNode(PARTITION442);


                    adaptor.addChild(root_0, PARTITION442_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (PARTITION442!=null?PARTITION442.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 28 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1958:7: GROUP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GROUP443=(CommonTree)match(input,GROUP,FOLLOW_GROUP_in_eid6110); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GROUP443_tree = (CommonTree)adaptor.dupNode(GROUP443);


                    adaptor.addChild(root_0, GROUP443_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (GROUP443!=null?GROUP443.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 29 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1959:7: AND
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    AND444=(CommonTree)match(input,AND,FOLLOW_AND_in_eid6120); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AND444_tree = (CommonTree)adaptor.dupNode(AND444);


                    adaptor.addChild(root_0, AND444_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (AND444!=null?AND444.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 30 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1960:7: OR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OR445=(CommonTree)match(input,OR,FOLLOW_OR_in_eid6130); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OR445_tree = (CommonTree)adaptor.dupNode(OR445);


                    adaptor.addChild(root_0, OR445_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (OR445!=null?OR445.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 31 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1961:7: NOT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NOT446=(CommonTree)match(input,NOT,FOLLOW_NOT_in_eid6140); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT446_tree = (CommonTree)adaptor.dupNode(NOT446);


                    adaptor.addChild(root_0, NOT446_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (NOT446!=null?NOT446.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 32 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1962:7: GENERATE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    GENERATE447=(CommonTree)match(input,GENERATE,FOLLOW_GENERATE_in_eid6150); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GENERATE447_tree = (CommonTree)adaptor.dupNode(GENERATE447);


                    adaptor.addChild(root_0, GENERATE447_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (GENERATE447!=null?GENERATE447.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 33 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1963:7: FLATTEN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLATTEN448=(CommonTree)match(input,FLATTEN,FOLLOW_FLATTEN_in_eid6160); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLATTEN448_tree = (CommonTree)adaptor.dupNode(FLATTEN448);


                    adaptor.addChild(root_0, FLATTEN448_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FLATTEN448!=null?FLATTEN448.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 34 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1964:7: EVAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    EVAL449=(CommonTree)match(input,EVAL,FOLLOW_EVAL_in_eid6170); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EVAL449_tree = (CommonTree)adaptor.dupNode(EVAL449);


                    adaptor.addChild(root_0, EVAL449_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (EVAL449!=null?EVAL449.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 35 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1965:7: ASC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ASC450=(CommonTree)match(input,ASC,FOLLOW_ASC_in_eid6180); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASC450_tree = (CommonTree)adaptor.dupNode(ASC450);


                    adaptor.addChild(root_0, ASC450_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (ASC450!=null?ASC450.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 36 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1966:7: DESC
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DESC451=(CommonTree)match(input,DESC,FOLLOW_DESC_in_eid6190); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DESC451_tree = (CommonTree)adaptor.dupNode(DESC451);


                    adaptor.addChild(root_0, DESC451_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (DESC451!=null?DESC451.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 37 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1967:7: BOOLEAN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BOOLEAN452=(CommonTree)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_eid6200); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BOOLEAN452_tree = (CommonTree)adaptor.dupNode(BOOLEAN452);


                    adaptor.addChild(root_0, BOOLEAN452_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (BOOLEAN452!=null?BOOLEAN452.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 38 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1968:7: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INT453=(CommonTree)match(input,INT,FOLLOW_INT_in_eid6210); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT453_tree = (CommonTree)adaptor.dupNode(INT453);


                    adaptor.addChild(root_0, INT453_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (INT453!=null?INT453.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 39 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1969:7: LONG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LONG454=(CommonTree)match(input,LONG,FOLLOW_LONG_in_eid6220); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LONG454_tree = (CommonTree)adaptor.dupNode(LONG454);


                    adaptor.addChild(root_0, LONG454_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (LONG454!=null?LONG454.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 40 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1970:7: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FLOAT455=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_eid6230); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FLOAT455_tree = (CommonTree)adaptor.dupNode(FLOAT455);


                    adaptor.addChild(root_0, FLOAT455_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FLOAT455!=null?FLOAT455.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 41 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1971:7: DOUBLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DOUBLE456=(CommonTree)match(input,DOUBLE,FOLLOW_DOUBLE_in_eid6240); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLE456_tree = (CommonTree)adaptor.dupNode(DOUBLE456);


                    adaptor.addChild(root_0, DOUBLE456_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (DOUBLE456!=null?DOUBLE456.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 42 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1972:7: BIGINTEGER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGINTEGER457=(CommonTree)match(input,BIGINTEGER,FOLLOW_BIGINTEGER_in_eid6250); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGINTEGER457_tree = (CommonTree)adaptor.dupNode(BIGINTEGER457);


                    adaptor.addChild(root_0, BIGINTEGER457_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (BIGINTEGER457!=null?BIGINTEGER457.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 43 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1973:7: BIGDECIMAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BIGDECIMAL458=(CommonTree)match(input,BIGDECIMAL,FOLLOW_BIGDECIMAL_in_eid6260); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BIGDECIMAL458_tree = (CommonTree)adaptor.dupNode(BIGDECIMAL458);


                    adaptor.addChild(root_0, BIGDECIMAL458_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (BIGDECIMAL458!=null?BIGDECIMAL458.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 44 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1974:7: DATETIME
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    DATETIME459=(CommonTree)match(input,DATETIME,FOLLOW_DATETIME_in_eid6270); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DATETIME459_tree = (CommonTree)adaptor.dupNode(DATETIME459);


                    adaptor.addChild(root_0, DATETIME459_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (DATETIME459!=null?DATETIME459.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 45 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1975:7: CHARARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CHARARRAY460=(CommonTree)match(input,CHARARRAY,FOLLOW_CHARARRAY_in_eid6280); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CHARARRAY460_tree = (CommonTree)adaptor.dupNode(CHARARRAY460);


                    adaptor.addChild(root_0, CHARARRAY460_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (CHARARRAY460!=null?CHARARRAY460.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 46 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1976:7: BYTEARRAY
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BYTEARRAY461=(CommonTree)match(input,BYTEARRAY,FOLLOW_BYTEARRAY_in_eid6290); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BYTEARRAY461_tree = (CommonTree)adaptor.dupNode(BYTEARRAY461);


                    adaptor.addChild(root_0, BYTEARRAY461_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (BYTEARRAY461!=null?BYTEARRAY461.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 47 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1977:7: BAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    BAG462=(CommonTree)match(input,BAG,FOLLOW_BAG_in_eid6300); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    BAG462_tree = (CommonTree)adaptor.dupNode(BAG462);


                    adaptor.addChild(root_0, BAG462_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (BAG462!=null?BAG462.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 48 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1978:7: TUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TUPLE463=(CommonTree)match(input,TUPLE,FOLLOW_TUPLE_in_eid6310); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TUPLE463_tree = (CommonTree)adaptor.dupNode(TUPLE463);


                    adaptor.addChild(root_0, TUPLE463_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (TUPLE463!=null?TUPLE463.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 49 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1979:7: MAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAP464=(CommonTree)match(input,MAP,FOLLOW_MAP_in_eid6320); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAP464_tree = (CommonTree)adaptor.dupNode(MAP464);


                    adaptor.addChild(root_0, MAP464_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (MAP464!=null?MAP464.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 50 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1980:7: IS
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IS465=(CommonTree)match(input,IS,FOLLOW_IS_in_eid6330); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IS465_tree = (CommonTree)adaptor.dupNode(IS465);


                    adaptor.addChild(root_0, IS465_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (IS465!=null?IS465.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 51 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1981:7: NULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    NULL466=(CommonTree)match(input,NULL,FOLLOW_NULL_in_eid6340); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NULL466_tree = (CommonTree)adaptor.dupNode(NULL466);


                    adaptor.addChild(root_0, NULL466_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (NULL466!=null?NULL466.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 52 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1982:7: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TRUE467=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_eid6350); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE467_tree = (CommonTree)adaptor.dupNode(TRUE467);


                    adaptor.addChild(root_0, TRUE467_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (TRUE467!=null?TRUE467.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 53 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1983:7: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FALSE468=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_eid6360); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE468_tree = (CommonTree)adaptor.dupNode(FALSE468);


                    adaptor.addChild(root_0, FALSE468_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FALSE468!=null?FALSE468.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 54 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1984:7: STREAM
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STREAM469=(CommonTree)match(input,STREAM,FOLLOW_STREAM_in_eid6370); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STREAM469_tree = (CommonTree)adaptor.dupNode(STREAM469);


                    adaptor.addChild(root_0, STREAM469_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STREAM469!=null?STREAM469.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 55 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1985:7: THROUGH
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    THROUGH470=(CommonTree)match(input,THROUGH,FOLLOW_THROUGH_in_eid6380); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    THROUGH470_tree = (CommonTree)adaptor.dupNode(THROUGH470);


                    adaptor.addChild(root_0, THROUGH470_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (THROUGH470!=null?THROUGH470.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 56 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1986:7: STORE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STORE471=(CommonTree)match(input,STORE,FOLLOW_STORE_in_eid6390); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STORE471_tree = (CommonTree)adaptor.dupNode(STORE471);


                    adaptor.addChild(root_0, STORE471_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STORE471!=null?STORE471.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 57 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1987:7: MAPREDUCE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    MAPREDUCE472=(CommonTree)match(input,MAPREDUCE,FOLLOW_MAPREDUCE_in_eid6400); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MAPREDUCE472_tree = (CommonTree)adaptor.dupNode(MAPREDUCE472);


                    adaptor.addChild(root_0, MAPREDUCE472_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (MAPREDUCE472!=null?MAPREDUCE472.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 58 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1988:7: SHIP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SHIP473=(CommonTree)match(input,SHIP,FOLLOW_SHIP_in_eid6410); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SHIP473_tree = (CommonTree)adaptor.dupNode(SHIP473);


                    adaptor.addChild(root_0, SHIP473_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (SHIP473!=null?SHIP473.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 59 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1989:7: CACHE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    CACHE474=(CommonTree)match(input,CACHE,FOLLOW_CACHE_in_eid6420); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CACHE474_tree = (CommonTree)adaptor.dupNode(CACHE474);


                    adaptor.addChild(root_0, CACHE474_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (CACHE474!=null?CACHE474.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 60 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1990:7: INPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    INPUT475=(CommonTree)match(input,INPUT,FOLLOW_INPUT_in_eid6430); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INPUT475_tree = (CommonTree)adaptor.dupNode(INPUT475);


                    adaptor.addChild(root_0, INPUT475_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (INPUT475!=null?INPUT475.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 61 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1991:7: OUTPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    OUTPUT476=(CommonTree)match(input,OUTPUT,FOLLOW_OUTPUT_in_eid6440); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTPUT476_tree = (CommonTree)adaptor.dupNode(OUTPUT476);


                    adaptor.addChild(root_0, OUTPUT476_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (OUTPUT476!=null?OUTPUT476.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 62 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1992:7: STDERROR
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDERROR477=(CommonTree)match(input,STDERROR,FOLLOW_STDERROR_in_eid6450); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDERROR477_tree = (CommonTree)adaptor.dupNode(STDERROR477);


                    adaptor.addChild(root_0, STDERROR477_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STDERROR477!=null?STDERROR477.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 63 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1993:7: STDIN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDIN478=(CommonTree)match(input,STDIN,FOLLOW_STDIN_in_eid6460); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDIN478_tree = (CommonTree)adaptor.dupNode(STDIN478);


                    adaptor.addChild(root_0, STDIN478_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STDIN478!=null?STDIN478.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 64 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1994:7: STDOUT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STDOUT479=(CommonTree)match(input,STDOUT,FOLLOW_STDOUT_in_eid6470); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STDOUT479_tree = (CommonTree)adaptor.dupNode(STDOUT479);


                    adaptor.addChild(root_0, STDOUT479_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STDOUT479!=null?STDOUT479.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 65 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1995:7: LIMIT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LIMIT480=(CommonTree)match(input,LIMIT,FOLLOW_LIMIT_in_eid6480); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LIMIT480_tree = (CommonTree)adaptor.dupNode(LIMIT480);


                    adaptor.addChild(root_0, LIMIT480_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (LIMIT480!=null?LIMIT480.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 66 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1996:7: SAMPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    SAMPLE481=(CommonTree)match(input,SAMPLE,FOLLOW_SAMPLE_in_eid6490); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SAMPLE481_tree = (CommonTree)adaptor.dupNode(SAMPLE481);


                    adaptor.addChild(root_0, SAMPLE481_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (SAMPLE481!=null?SAMPLE481.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 67 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1997:7: LEFT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    LEFT482=(CommonTree)match(input,LEFT,FOLLOW_LEFT_in_eid6500); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LEFT482_tree = (CommonTree)adaptor.dupNode(LEFT482);


                    adaptor.addChild(root_0, LEFT482_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (LEFT482!=null?LEFT482.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 68 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1998:7: RIGHT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    RIGHT483=(CommonTree)match(input,RIGHT,FOLLOW_RIGHT_in_eid6510); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RIGHT483_tree = (CommonTree)adaptor.dupNode(RIGHT483);


                    adaptor.addChild(root_0, RIGHT483_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (RIGHT483!=null?RIGHT483.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 69 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1999:7: FULL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    FULL484=(CommonTree)match(input,FULL,FOLLOW_FULL_in_eid6520); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FULL484_tree = (CommonTree)adaptor.dupNode(FULL484);


                    adaptor.addChild(root_0, FULL484_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (FULL484!=null?FULL484.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 70 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2000:7: IDENTIFIER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    IDENTIFIER485=(CommonTree)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_eid6530); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER485_tree = (CommonTree)adaptor.dupNode(IDENTIFIER485);


                    adaptor.addChild(root_0, IDENTIFIER485_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (IDENTIFIER485!=null?IDENTIFIER485.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 71 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2001:7: TOBAG
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOBAG486=(CommonTree)match(input,TOBAG,FOLLOW_TOBAG_in_eid6540); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOBAG486_tree = (CommonTree)adaptor.dupNode(TOBAG486);


                    adaptor.addChild(root_0, TOBAG486_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = "TOBAG"; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 72 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2002:7: TOMAP
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOMAP487=(CommonTree)match(input,TOMAP,FOLLOW_TOMAP_in_eid6550); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOMAP487_tree = (CommonTree)adaptor.dupNode(TOMAP487);


                    adaptor.addChild(root_0, TOMAP487_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = "TOMAP"; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 73 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2003:7: TOTUPLE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    TOTUPLE488=(CommonTree)match(input,TOTUPLE,FOLLOW_TOTUPLE_in_eid6560); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TOTUPLE488_tree = (CommonTree)adaptor.dupNode(TOTUPLE488);


                    adaptor.addChild(root_0, TOTUPLE488_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = "TOTUPLE"; }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 74 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2004:7: ASSERT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    ASSERT489=(CommonTree)match(input,ASSERT,FOLLOW_ASSERT_in_eid6570); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASSERT489_tree = (CommonTree)adaptor.dupNode(ASSERT489);


                    adaptor.addChild(root_0, ASSERT489_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = "ASSERT"; }

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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2008:1: rel_op : ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES );
    public final LogicalPlanGenerator.rel_op_return rel_op() throws RecognitionException {
        LogicalPlanGenerator.rel_op_return retval = new LogicalPlanGenerator.rel_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_MATCHES496=null;
        LogicalPlanGenerator.rel_op_eq_return rel_op_eq490 =null;

        LogicalPlanGenerator.rel_op_ne_return rel_op_ne491 =null;

        LogicalPlanGenerator.rel_op_gt_return rel_op_gt492 =null;

        LogicalPlanGenerator.rel_op_gte_return rel_op_gte493 =null;

        LogicalPlanGenerator.rel_op_lt_return rel_op_lt494 =null;

        LogicalPlanGenerator.rel_op_lte_return rel_op_lte495 =null;


        CommonTree STR_OP_MATCHES496_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2008:8: ( rel_op_eq | rel_op_ne | rel_op_gt | rel_op_gte | rel_op_lt | rel_op_lte | STR_OP_MATCHES )
            int alt132=7;
            switch ( input.LA(1) ) {
            case NUM_OP_EQ:
            case STR_OP_EQ:
                {
                alt132=1;
                }
                break;
            case NUM_OP_NE:
            case STR_OP_NE:
                {
                alt132=2;
                }
                break;
            case NUM_OP_GT:
            case STR_OP_GT:
                {
                alt132=3;
                }
                break;
            case NUM_OP_GTE:
            case STR_OP_GTE:
                {
                alt132=4;
                }
                break;
            case NUM_OP_LT:
            case STR_OP_LT:
                {
                alt132=5;
                }
                break;
            case NUM_OP_LTE:
            case STR_OP_LTE:
                {
                alt132=6;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt132=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 132, 0, input);

                throw nvae;

            }

            switch (alt132) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2008:10: rel_op_eq
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_eq_in_rel_op6583);
                    rel_op_eq490=rel_op_eq();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_eq490.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2009:10: rel_op_ne
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_ne_in_rel_op6594);
                    rel_op_ne491=rel_op_ne();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_ne491.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2010:10: rel_op_gt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gt_in_rel_op6605);
                    rel_op_gt492=rel_op_gt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gt492.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2011:10: rel_op_gte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_gte_in_rel_op6616);
                    rel_op_gte493=rel_op_gte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_gte493.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2012:10: rel_op_lt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lt_in_rel_op6627);
                    rel_op_lt494=rel_op_lt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lt494.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2013:10: rel_op_lte
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    pushFollow(FOLLOW_rel_op_lte_in_rel_op6638);
                    rel_op_lte495=rel_op_lte();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) 
                    adaptor.addChild(root_0, rel_op_lte495.getTree());


                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2014:10: STR_OP_MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES496=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_rel_op6649); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES496_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES496);


                    adaptor.addChild(root_0, STR_OP_MATCHES496_tree);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2017:1: rel_op_eq : ( STR_OP_EQ | NUM_OP_EQ );
    public final LogicalPlanGenerator.rel_op_eq_return rel_op_eq() throws RecognitionException {
        LogicalPlanGenerator.rel_op_eq_return retval = new LogicalPlanGenerator.rel_op_eq_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set497=null;

        CommonTree set497_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2017:11: ( STR_OP_EQ | NUM_OP_EQ )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set497=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_EQ||input.LA(1)==STR_OP_EQ ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set497_tree = (CommonTree)adaptor.dupNode(set497);


                adaptor.addChild(root_0, set497_tree);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2020:1: rel_op_ne : ( STR_OP_NE | NUM_OP_NE );
    public final LogicalPlanGenerator.rel_op_ne_return rel_op_ne() throws RecognitionException {
        LogicalPlanGenerator.rel_op_ne_return retval = new LogicalPlanGenerator.rel_op_ne_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set498=null;

        CommonTree set498_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2020:11: ( STR_OP_NE | NUM_OP_NE )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set498=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_NE||input.LA(1)==STR_OP_NE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set498_tree = (CommonTree)adaptor.dupNode(set498);


                adaptor.addChild(root_0, set498_tree);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2023:1: rel_op_gt : ( STR_OP_GT | NUM_OP_GT );
    public final LogicalPlanGenerator.rel_op_gt_return rel_op_gt() throws RecognitionException {
        LogicalPlanGenerator.rel_op_gt_return retval = new LogicalPlanGenerator.rel_op_gt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set499=null;

        CommonTree set499_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2023:11: ( STR_OP_GT | NUM_OP_GT )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set499=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GT||input.LA(1)==STR_OP_GT ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set499_tree = (CommonTree)adaptor.dupNode(set499);


                adaptor.addChild(root_0, set499_tree);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2026:1: rel_op_gte : ( STR_OP_GTE | NUM_OP_GTE );
    public final LogicalPlanGenerator.rel_op_gte_return rel_op_gte() throws RecognitionException {
        LogicalPlanGenerator.rel_op_gte_return retval = new LogicalPlanGenerator.rel_op_gte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set500=null;

        CommonTree set500_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2026:12: ( STR_OP_GTE | NUM_OP_GTE )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set500=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_GTE||input.LA(1)==STR_OP_GTE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set500_tree = (CommonTree)adaptor.dupNode(set500);


                adaptor.addChild(root_0, set500_tree);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2029:1: rel_op_lt : ( STR_OP_LT | NUM_OP_LT );
    public final LogicalPlanGenerator.rel_op_lt_return rel_op_lt() throws RecognitionException {
        LogicalPlanGenerator.rel_op_lt_return retval = new LogicalPlanGenerator.rel_op_lt_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set501=null;

        CommonTree set501_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2029:11: ( STR_OP_LT | NUM_OP_LT )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set501=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LT||input.LA(1)==STR_OP_LT ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set501_tree = (CommonTree)adaptor.dupNode(set501);


                adaptor.addChild(root_0, set501_tree);
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
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2032:1: rel_op_lte : ( STR_OP_LTE | NUM_OP_LTE );
    public final LogicalPlanGenerator.rel_op_lte_return rel_op_lte() throws RecognitionException {
        LogicalPlanGenerator.rel_op_lte_return retval = new LogicalPlanGenerator.rel_op_lte_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree set502=null;

        CommonTree set502_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2032:12: ( STR_OP_LTE | NUM_OP_LTE )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            _last = (CommonTree)input.LT(1);
            set502=(CommonTree)input.LT(1);

            if ( input.LA(1)==NUM_OP_LTE||input.LA(1)==STR_OP_LTE ) {
                input.consume();
                if ( state.backtracking==0 ) {
                set502_tree = (CommonTree)adaptor.dupNode(set502);


                adaptor.addChild(root_0, set502_tree);
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
        public String id;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rel_str_op"
    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2035:1: rel_str_op returns [String id] : ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES );
    public final LogicalPlanGenerator.rel_str_op_return rel_str_op() throws RecognitionException {
        LogicalPlanGenerator.rel_str_op_return retval = new LogicalPlanGenerator.rel_str_op_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CommonTree _first_0 = null;
        CommonTree _last = null;

        CommonTree STR_OP_EQ503=null;
        CommonTree STR_OP_NE504=null;
        CommonTree STR_OP_GT505=null;
        CommonTree STR_OP_LT506=null;
        CommonTree STR_OP_GTE507=null;
        CommonTree STR_OP_LTE508=null;
        CommonTree STR_OP_MATCHES509=null;

        CommonTree STR_OP_EQ503_tree=null;
        CommonTree STR_OP_NE504_tree=null;
        CommonTree STR_OP_GT505_tree=null;
        CommonTree STR_OP_LT506_tree=null;
        CommonTree STR_OP_GTE507_tree=null;
        CommonTree STR_OP_LTE508_tree=null;
        CommonTree STR_OP_MATCHES509_tree=null;

        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2036:2: ( STR_OP_EQ | STR_OP_NE | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_MATCHES )
            int alt133=7;
            switch ( input.LA(1) ) {
            case STR_OP_EQ:
                {
                alt133=1;
                }
                break;
            case STR_OP_NE:
                {
                alt133=2;
                }
                break;
            case STR_OP_GT:
                {
                alt133=3;
                }
                break;
            case STR_OP_LT:
                {
                alt133=4;
                }
                break;
            case STR_OP_GTE:
                {
                alt133=5;
                }
                break;
            case STR_OP_LTE:
                {
                alt133=6;
                }
                break;
            case STR_OP_MATCHES:
                {
                alt133=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 133, 0, input);

                throw nvae;

            }

            switch (alt133) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2036:4: STR_OP_EQ
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_EQ503=(CommonTree)match(input,STR_OP_EQ,FOLLOW_STR_OP_EQ_in_rel_str_op6740); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_EQ503_tree = (CommonTree)adaptor.dupNode(STR_OP_EQ503);


                    adaptor.addChild(root_0, STR_OP_EQ503_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_EQ503!=null?STR_OP_EQ503.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2037:4: STR_OP_NE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_NE504=(CommonTree)match(input,STR_OP_NE,FOLLOW_STR_OP_NE_in_rel_str_op6747); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_NE504_tree = (CommonTree)adaptor.dupNode(STR_OP_NE504);


                    adaptor.addChild(root_0, STR_OP_NE504_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_NE504!=null?STR_OP_NE504.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 3 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2038:4: STR_OP_GT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_GT505=(CommonTree)match(input,STR_OP_GT,FOLLOW_STR_OP_GT_in_rel_str_op6754); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_GT505_tree = (CommonTree)adaptor.dupNode(STR_OP_GT505);


                    adaptor.addChild(root_0, STR_OP_GT505_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_GT505!=null?STR_OP_GT505.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 4 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2039:4: STR_OP_LT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_LT506=(CommonTree)match(input,STR_OP_LT,FOLLOW_STR_OP_LT_in_rel_str_op6761); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_LT506_tree = (CommonTree)adaptor.dupNode(STR_OP_LT506);


                    adaptor.addChild(root_0, STR_OP_LT506_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_LT506!=null?STR_OP_LT506.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 5 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2040:4: STR_OP_GTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_GTE507=(CommonTree)match(input,STR_OP_GTE,FOLLOW_STR_OP_GTE_in_rel_str_op6768); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_GTE507_tree = (CommonTree)adaptor.dupNode(STR_OP_GTE507);


                    adaptor.addChild(root_0, STR_OP_GTE507_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_GTE507!=null?STR_OP_GTE507.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 6 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2041:4: STR_OP_LTE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_LTE508=(CommonTree)match(input,STR_OP_LTE,FOLLOW_STR_OP_LTE_in_rel_str_op6775); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_LTE508_tree = (CommonTree)adaptor.dupNode(STR_OP_LTE508);


                    adaptor.addChild(root_0, STR_OP_LTE508_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_LTE508!=null?STR_OP_LTE508.getText():null); }

                    if ( state.backtracking==0 ) {
                    }
                    }
                    break;
                case 7 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:2042:4: STR_OP_MATCHES
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    _last = (CommonTree)input.LT(1);
                    STR_OP_MATCHES509=(CommonTree)match(input,STR_OP_MATCHES,FOLLOW_STR_OP_MATCHES_in_rel_str_op6782); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STR_OP_MATCHES509_tree = (CommonTree)adaptor.dupNode(STR_OP_MATCHES509);


                    adaptor.addChild(root_0, STR_OP_MATCHES509_tree);
                    }


                    if ( state.backtracking==0 ) { retval.id = (STR_OP_MATCHES509!=null?STR_OP_MATCHES509.getText():null); }

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
    // $ANTLR end "rel_str_op"

    // $ANTLR start synpred146_LogicalPlanGenerator
    public final void synpred146_LogicalPlanGenerator_fragment() throws RecognitionException {
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1167:20: ( INTEGER )
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1167:20: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred146_LogicalPlanGenerator3647); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred146_LogicalPlanGenerator

    // $ANTLR start synpred147_LogicalPlanGenerator
    public final void synpred147_LogicalPlanGenerator_fragment() throws RecognitionException {
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1172:4: ( LONGINTEGER )
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1172:4: LONGINTEGER
        {
        match(input,LONGINTEGER,FOLLOW_LONGINTEGER_in_synpred147_LogicalPlanGenerator3657); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred147_LogicalPlanGenerator

    // $ANTLR start synpred148_LogicalPlanGenerator
    public final void synpred148_LogicalPlanGenerator_fragment() throws RecognitionException {
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1191:20: ( DOUBLENUMBER )
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1191:20: DOUBLENUMBER
        {
        match(input,DOUBLENUMBER,FOLLOW_DOUBLENUMBER_in_synpred148_LogicalPlanGenerator3709); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred148_LogicalPlanGenerator

    // $ANTLR start synpred178_LogicalPlanGenerator
    public final void synpred178_LogicalPlanGenerator_fragment() throws RecognitionException {
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1380:4: ( join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item )
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1380:4: join_item ( LEFT | RIGHT | FULL ) ( OUTER )? join_item
        {
        pushFollow(FOLLOW_join_item_in_synpred178_LogicalPlanGenerator4238);
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


        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1385:66: ( OUTER )?
        int alt148=2;
        int LA148_0 = input.LA(1);

        if ( (LA148_0==OUTER) ) {
            alt148=1;
        }
        switch (alt148) {
            case 1 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1385:66: OUTER
                {
                match(input,OUTER,FOLLOW_OUTER_in_synpred178_LogicalPlanGenerator4286); if (state.failed) return ;

                }
                break;

        }


        pushFollow(FOLLOW_join_item_in_synpred178_LogicalPlanGenerator4289);
        join_item();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred178_LogicalPlanGenerator

    // $ANTLR start synpred195_LogicalPlanGenerator
    public final void synpred195_LogicalPlanGenerator_fragment() throws RecognitionException {
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1569:31: ( INTEGER )
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/LogicalPlanGenerator.g:1569:31: INTEGER
        {
        match(input,INTEGER,FOLLOW_INTEGER_in_synpred195_LogicalPlanGenerator4861); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred195_LogicalPlanGenerator

    // Delegated rules

    public final boolean synpred147_LogicalPlanGenerator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred147_LogicalPlanGenerator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred146_LogicalPlanGenerator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred146_LogicalPlanGenerator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred178_LogicalPlanGenerator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred178_LogicalPlanGenerator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred195_LogicalPlanGenerator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred195_LogicalPlanGenerator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred148_LogicalPlanGenerator() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred148_LogicalPlanGenerator_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_QUERY_in_query87 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_statement_in_query89 = new BitSet(new long[]{0x0000000000000408L,0x0020020000000000L,0x0012000000000000L});
    public static final BitSet FOLLOW_general_statement_in_statement111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_statement_in_statement116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_statement_in_statement121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assert_statement_in_statement126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_register_statement_in_statement131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_split_clause_in_split_statement140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_realias_clause_in_realias_statement149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assert_clause_in_assert_statement158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REGISTER_in_register_statement169 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_register_statement171 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_USING_in_register_statement174 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_register_statement176 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_AS_in_register_statement178 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_register_statement180 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STATEMENT_in_general_statement199 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_general_statement203 = new BitSet(new long[]{0x0048400226400400L,0x0C01010010004608L,0x0000000000000080L});
    public static final BitSet FOLLOW_op_clause_in_general_statement214 = new BitSet(new long[]{0x0000000000000008L,0x0000000100000000L});
    public static final BitSet FOLLOW_parallel_clause_in_general_statement216 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REALIAS_in_realias_clause233 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_realias_clause235 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_realias_clause237 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARALLEL_in_parallel_clause256 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEGER_in_parallel_clause258 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_define_clause_in_op_clause302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_load_clause_in_op_clause316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_group_clause_in_op_clause332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_store_clause_in_op_clause348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filter_clause_in_op_clause364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_distinct_clause_in_op_clause380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_limit_clause_in_op_clause396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sample_clause_in_op_clause412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_order_clause_in_op_clause428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rank_clause_in_op_clause444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cross_clause_in_op_clause460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_clause_in_op_clause476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_union_clause_in_op_clause492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stream_clause_in_op_clause508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mr_clause_in_op_clause524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_foreach_clause_in_op_clause540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cube_clause_in_op_clause556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assert_clause_in_op_clause572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_define_clause586 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_define_clause588 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_cmd_in_define_clause590 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DEFINE_in_define_clause605 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_define_clause607 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000140000000L});
    public static final BitSet FOLLOW_func_clause_in_define_clause609 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_cmd638 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ship_clause_in_cmd642 = new BitSet(new long[]{0x2000000000080008L,0x0084000080000000L});
    public static final BitSet FOLLOW_cache_clause_in_cmd647 = new BitSet(new long[]{0x2000000000080008L,0x0084000080000000L});
    public static final BitSet FOLLOW_input_clause_in_cmd652 = new BitSet(new long[]{0x2000000000080008L,0x0084000080000000L});
    public static final BitSet FOLLOW_output_clause_in_cmd656 = new BitSet(new long[]{0x2000000000080008L,0x0084000080000000L});
    public static final BitSet FOLLOW_error_clause_in_cmd660 = new BitSet(new long[]{0x2000000000080008L,0x0084000080000000L});
    public static final BitSet FOLLOW_SHIP_in_ship_clause683 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_ship_clause685 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_path_list702 = new BitSet(new long[]{0x0000000000000002L,0x0000008000000000L});
    public static final BitSet FOLLOW_CACHE_in_cache_clause720 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_path_list_in_cache_clause722 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_INPUT_in_input_clause745 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_input_clause749 = new BitSet(new long[]{0x0000000000000008L,0x0300008000000000L});
    public static final BitSet FOLLOW_STDIN_in_stream_cmd783 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd795 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STDOUT_in_stream_cmd810 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd822 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_stream_cmd837 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_clause_in_stream_cmd849 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OUTPUT_in_output_clause877 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stream_cmd_in_output_clause881 = new BitSet(new long[]{0x0000000000000008L,0x0300008000000000L});
    public static final BitSet FOLLOW_STDERROR_in_error_clause909 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_error_clause919 = new BitSet(new long[]{0x8000000000000008L});
    public static final BitSet FOLLOW_INTEGER_in_error_clause941 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOAD_in_load_clause994 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_filename_in_load_clause996 = new BitSet(new long[]{0x0000000000000108L,0x0000000000000000L,0x0000000140000000L});
    public static final BitSet FOLLOW_func_clause_in_load_clause998 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_as_clause_in_load_clause1002 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_filename1022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_as_clause1039 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_as_clause1041 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_in_field_def1069 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_field_def1071 = new BitSet(new long[]{0x4001002008255008L,0x0000000000000800L,0x0100020000002000L});
    public static final BitSet FOLLOW_type_in_field_def1075 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELD_DEF_WITHOUT_IDENTIFIER_in_field_def1094 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_field_def1098 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_field_def_in_field_def_list1129 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_simple_type_in_type1149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_in_type1159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_in_type1169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type1179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_simple_type1197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_simple_type1204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_simple_type1211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_simple_type1218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_simple_type1225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINTEGER_in_simple_type1232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGDECIMAL_in_simple_type1239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATETIME_in_simple_type1246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_simple_type1253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_simple_type1260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_in_tuple_type1277 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_def_list_in_tuple_type1287 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BAG_TYPE_in_bag_type1327 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_bag_type1329 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0100000000000000L});
    public static final BitSet FOLLOW_tuple_type_in_bag_type1332 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAP_TYPE_in_map_type1355 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_in_map_type1357 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_REF_in_func_clause1386 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1388 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_in_func_clause1402 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_clause1404 = new BitSet(new long[]{0x0000000000000008L,0x0000008000020000L});
    public static final BitSet FOLLOW_func_args_in_func_clause1406 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_eid_in_func_name1436 = new BitSet(new long[]{0x0000000800000002L,0x0000000800000000L});
    public static final BitSet FOLLOW_PERIOD_in_func_name1450 = new BitSet(new long[]{0x7779D022AE6F5F50L,0xFFA58C03D80C6E1DL,0x18E00000000001F7L});
    public static final BitSet FOLLOW_DOLLAR_in_func_name1456 = new BitSet(new long[]{0x7779D022AE6F5F50L,0xFFA58C03D80C6E1DL,0x18E00000000001F7L});
    public static final BitSet FOLLOW_eid_in_func_name1472 = new BitSet(new long[]{0x0000000800000002L,0x0000000800000000L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_func_args1501 = new BitSet(new long[]{0x0000000000000002L,0x0000008000020000L});
    public static final BitSet FOLLOW_MULTILINE_QUOTEDSTRING_in_func_args1511 = new BitSet(new long[]{0x0000000000000002L,0x0000008000020000L});
    public static final BitSet FOLLOW_CUBE_in_cube_clause1553 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_item_in_cube_clause1555 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_cube_item1572 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_cube_by_clause_in_cube_item1576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_cube_by_clause1603 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_or_rollup_in_cube_by_clause1605 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_rollup_list_in_cube_or_rollup1628 = new BitSet(new long[]{0x0000000004000002L,0x0000800000000000L});
    public static final BitSet FOLLOW_CUBE_in_cube_rollup_list1658 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ROLLUP_in_cube_rollup_list1664 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cube_by_expr_list_in_cube_rollup_list1670 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_cube_by_expr_in_cube_by_expr_list1694 = new BitSet(new long[]{0x814410540400A002L,0x0040009400089000L,0x04000C0283998020L});
    public static final BitSet FOLLOW_col_range_in_cube_by_expr1717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_cube_by_expr1723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_cube_by_expr1729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_group_clause1768 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_group_item_in_group_clause1770 = new BitSet(new long[]{0x0148400226400488L,0x0C01018210004608L,0x0000000000000080L});
    public static final BitSet FOLLOW_group_type_in_group_clause1775 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_partition_clause_in_group_clause1782 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_COGROUP_in_group_clause1797 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_group_item_in_group_clause1799 = new BitSet(new long[]{0x0148400226400488L,0x0C01018210004608L,0x0000000000000080L});
    public static final BitSet FOLLOW_group_type_in_group_clause1804 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_partition_clause_in_group_clause1811 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_group_type1832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_in_group_item1852 = new BitSet(new long[]{0x0000000000020010L,0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_join_group_by_clause_in_group_item1856 = new BitSet(new long[]{0x1000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_ALL_in_group_item1880 = new BitSet(new long[]{0x1000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_ANY_in_group_item1904 = new BitSet(new long[]{0x1000000000000002L,0x0000000040000000L});
    public static final BitSet FOLLOW_INNER_in_group_item1929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTER_in_group_item1935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alias_in_rel1953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_previous_rel_in_rel1963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inline_op_in_rel1973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARROBA_in_previous_rel1985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_op_clause_in_inline_op2007 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_parallel_clause_in_inline_op2009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_flatten_clause_in_flatten_generated_item2035 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_col_range_in_flatten_generated_item2045 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_expr_in_flatten_generated_item2053 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_STAR_in_flatten_generated_item2061 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x000000000C000000L});
    public static final BitSet FOLLOW_field_def_list_in_flatten_generated_item2080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_flatten_clause2098 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_flatten_clause2100 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STORE_in_store_clause2118 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_store_clause2120 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_filename_in_store_clause2122 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000140000000L});
    public static final BitSet FOLLOW_func_clause_in_store_clause2124 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSERT_in_assert_clause2158 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_assert_clause2160 = new BitSet(new long[]{0x0800000000000040L,0xF00000000BFC0000L,0x0000000280040007L});
    public static final BitSet FOLLOW_cond_in_assert_clause2162 = new BitSet(new long[]{0x0000000000000008L,0x0000008000000000L});
    public static final BitSet FOLLOW_comment_in_assert_clause2165 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_comment2186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILTER_in_filter_clause2213 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_filter_clause2215 = new BitSet(new long[]{0x0800000000000040L,0xF00000000BFC0000L,0x0000000280040007L});
    public static final BitSet FOLLOW_cond_in_filter_clause2217 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OR_in_cond2241 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond2247 = new BitSet(new long[]{0x0800000000000040L,0xF00000000BFC0000L,0x0000000280040007L});
    public static final BitSet FOLLOW_cond_in_cond2254 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_AND_in_cond2269 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond2275 = new BitSet(new long[]{0x0800000000000040L,0xF00000000BFC0000L,0x0000000280040007L});
    public static final BitSet FOLLOW_cond_in_cond2282 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_cond2297 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_cond2303 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_cond2318 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2320 = new BitSet(new long[]{0x0000000000000008L,0x0000000000040000L});
    public static final BitSet FOLLOW_NOT_in_cond2323 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_eq_in_cond2338 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2344 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_expr_in_cond2351 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_ne_in_cond2366 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2372 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_expr_in_cond2379 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_lt_in_cond2394 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2400 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_expr_in_cond2407 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_lte_in_cond2422 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2428 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_expr_in_cond2435 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_gt_in_cond2450 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2456 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_expr_in_cond2463 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_op_gte_in_cond2478 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2484 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_expr_in_cond2491 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_cond2506 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2512 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_expr_in_cond2519 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_in_eval_in_cond2532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_func_eval_in_cond2543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_COND_in_cond2556 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_cond2562 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_in_in_eval2591 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IN_LHS_in_in_eval2597 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_in_eval2603 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IN_RHS_in_in_eval2623 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_in_eval2629 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FUNC_EVAL_in_func_eval2666 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_func_eval2668 = new BitSet(new long[]{0x814410540400A008L,0x0040009400089000L,0x04000C0283998020L});
    public static final BitSet FOLLOW_real_arg_in_func_eval2672 = new BitSet(new long[]{0x814410540400A008L,0x0040009400089000L,0x04000C0283998020L});
    public static final BitSet FOLLOW_INVOKER_FUNC_EVAL_in_func_eval2692 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_func_eval2696 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_func_eval2700 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_func_eval2704 = new BitSet(new long[]{0x814410540400A008L,0x0040009400089000L,0x04000C0283998020L});
    public static final BitSet FOLLOW_real_arg_in_func_eval2708 = new BitSet(new long[]{0x814410540400A008L,0x0040009400089000L,0x04000C0283998020L});
    public static final BitSet FOLLOW_expr_in_real_arg2740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_real_arg2748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_range_in_real_arg2762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_expr2781 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2787 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_expr_in_expr2794 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MINUS_in_expr2809 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2815 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_expr_in_expr2822 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_expr2837 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2843 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_expr_in_expr2850 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DIV_in_expr2865 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2871 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_expr_in_expr2878 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PERCENT_in_expr2893 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2899 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_expr_in_expr2906 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_const_expr_in_expr2919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_expr_in_expr2930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEG_in_expr2943 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2949 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CAST_EXPR_in_expr2964 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_expr2966 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_expr_in_expr2972 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_EXPR_IN_PAREN_in_expr2988 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr2994 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_simple_type_in_type_cast3016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_type_in_type_cast3026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_type_cast_in_type_cast3036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_type_cast_in_type_cast3046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_TYPE_CAST_in_tuple_type_cast3071 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_type_cast_in_tuple_type_cast3075 = new BitSet(new long[]{0x4001002008255008L,0x0000000000000800L,0x0200020000004000L});
    public static final BitSet FOLLOW_BAG_TYPE_CAST_in_bag_type_cast3102 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_type_cast_in_bag_type_cast3104 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_projectable_expr_in_var_expr3131 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
    public static final BitSet FOLLOW_dot_proj_in_var_expr3141 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
    public static final BitSet FOLLOW_pound_proj_in_var_expr3155 = new BitSet(new long[]{0x0000000000000002L,0x0000002800000000L});
    public static final BitSet FOLLOW_func_eval_in_projectable_expr3185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_ref_in_projectable_expr3196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bin_expr_in_projectable_expr3207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_expr_in_projectable_expr3218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_case_cond_in_projectable_expr3229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_dot_proj3255 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_alias_or_index_in_dot_proj3259 = new BitSet(new long[]{0x0140001004000008L});
    public static final BitSet FOLLOW_col_alias_in_col_alias_or_index3279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_index_in_col_alias_or_index3285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_col_alias3300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_col_alias3307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_col_alias3314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_col_index3329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COL_RANGE_in_col_range3348 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_col_range3355 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_DOUBLE_PERIOD_in_col_range3360 = new BitSet(new long[]{0x0140001004000008L});
    public static final BitSet FOLLOW_col_ref_in_col_range3367 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POUND_in_pound_proj3393 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_pound_proj3397 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NULL_in_pound_proj3403 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BIN_EXPR_in_bin_expr3423 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_bin_expr3425 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_expr_in_bin_expr3432 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_expr_in_bin_expr3439 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_EXPR_in_case_expr3468 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_CASE_EXPR_LHS_in_case_expr3476 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_expr3482 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_EXPR_RHS_in_case_expr3513 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_expr3519 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CASE_COND_in_case_cond3559 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_WHEN_in_case_cond3563 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_cond_in_case_cond3567 = new BitSet(new long[]{0x0800000000000048L,0xF00000000BFC0000L,0x0000000280040007L});
    public static final BitSet FOLLOW_THEN_in_case_cond3595 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_case_cond3599 = new BitSet(new long[]{0x814410540400A008L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_LIMIT_in_limit_clause3641 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_limit_clause3643 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_INTEGER_in_limit_clause3647 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LONGINTEGER_in_limit_clause3657 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_limit_clause3667 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SAMPLE_in_sample_clause3703 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_sample_clause3705 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_sample_clause3709 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_sample_clause3719 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RANK_in_rank_clause3765 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_rank_clause3767 = new BitSet(new long[]{0x0000000000020008L});
    public static final BitSet FOLLOW_rank_by_statement_in_rank_clause3769 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_rank_by_statement3795 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rank_by_clause_in_rank_by_statement3797 = new BitSet(new long[]{0x0000000040000008L});
    public static final BitSet FOLLOW_DENSE_in_rank_by_statement3801 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_rank_by_clause3830 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_ASC_in_rank_by_clause3839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_rank_by_clause3845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rank_col_in_rank_by_clause3857 = new BitSet(new long[]{0x0140001004000002L,0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_col_range_in_rank_col3883 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_ASC_in_rank_col3887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_rank_col3891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_ref_in_rank_col3901 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_ASC_in_rank_col3906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_rank_col3910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_order_clause3940 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_order_clause3942 = new BitSet(new long[]{0x0140001004000000L,0x0040000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_order_by_clause_in_order_clause3944 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000140000000L});
    public static final BitSet FOLLOW_func_clause_in_order_clause3946 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STAR_in_order_by_clause3973 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_ASC_in_order_by_clause3982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_order_by_clause3988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_order_col_in_order_by_clause4000 = new BitSet(new long[]{0x0140001004000002L,0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_col_range_in_order_col4026 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_ASC_in_order_col4030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_order_col4034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_col_ref_in_order_col4044 = new BitSet(new long[]{0x0000000080000202L});
    public static final BitSet FOLLOW_ASC_in_order_col4049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_order_col4053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTINCT_in_distinct_clause4073 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_distinct_clause4075 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_partition_clause_in_distinct_clause4077 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PARTITION_in_partition_clause4100 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_func_name_in_partition_clause4102 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_cross_clause4124 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_list_in_cross_clause4126 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_partition_clause_in_cross_clause4128 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_rel_in_rel_list4156 = new BitSet(new long[]{0x0148400226400482L,0x0C01010010004608L,0x0000000000000080L});
    public static final BitSet FOLLOW_JOIN_in_join_clause4195 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_sub_clause_in_join_clause4197 = new BitSet(new long[]{0x0000000000000008L,0x0000008200000000L});
    public static final BitSet FOLLOW_join_type_in_join_clause4199 = new BitSet(new long[]{0x0000000000000008L,0x0000000200000000L});
    public static final BitSet FOLLOW_partition_clause_in_join_clause4202 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_join_type4223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause4238 = new BitSet(new long[]{0x0010000000000000L,0x0000080000000010L});
    public static final BitSet FOLLOW_LEFT_in_join_sub_clause4242 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_RIGHT_in_join_sub_clause4261 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_FULL_in_join_sub_clause4280 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_OUTER_in_join_sub_clause4286 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause4289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_join_sub_clause4299 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_JOIN_ITEM_in_join_item4312 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_join_item4314 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_join_group_by_clause_in_join_item4316 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BY_in_join_group_by_clause4343 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_join_group_by_expr_in_join_group_by_clause4347 = new BitSet(new long[]{0x814410540400A008L,0x0040009400089000L,0x04000C0283998020L});
    public static final BitSet FOLLOW_col_range_in_join_group_by_expr4372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_join_group_by_expr4378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_join_group_by_expr4384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_union_clause4409 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ONSCHEMA_in_union_clause4413 = new BitSet(new long[]{0x0148400226400480L,0x0C01010010004608L,0x0000000000000080L});
    public static final BitSet FOLLOW_rel_list_in_union_clause4420 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_foreach_clause4456 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_foreach_clause4458 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000030000000L});
    public static final BitSet FOLLOW_foreach_plan_in_foreach_clause4460 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_SIMPLE_in_foreach_plan4496 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_generate_clause_in_foreach_plan4498 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_PLAN_COMPLEX_in_foreach_plan4507 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_blk_in_foreach_plan4509 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_command_in_nested_blk4520 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000000L,0x0000300000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_blk4523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NESTED_CMD_in_nested_command4545 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command4547 = new BitSet(new long[]{0x0008400202000000L,0x0000000010000200L,0x0000400000000000L});
    public static final BitSet FOLLOW_nested_op_in_nested_command4549 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NESTED_CMD_ASSI_in_nested_command4567 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENTIFIER_in_nested_command4569 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_expr_in_nested_command4571 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op4593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_filter_in_nested_op4601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_sort_in_nested_op4609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_distinct_in_nested_op4618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_limit_in_nested_op4626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_cross_in_nested_op4634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_foreach_in_nested_op4642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NESTED_PROJ_in_nested_proj4666 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj4678 = new BitSet(new long[]{0x0140001004000000L});
    public static final BitSet FOLLOW_col_ref_in_nested_proj4693 = new BitSet(new long[]{0x0140001004000008L});
    public static final BitSet FOLLOW_FILTER_in_nested_filter4746 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_filter4748 = new BitSet(new long[]{0x0800000000000040L,0xF00000000BFC0000L,0x0000000280040007L});
    public static final BitSet FOLLOW_cond_in_nested_filter4750 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ORDER_in_nested_sort4784 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_sort4786 = new BitSet(new long[]{0x0140001004000000L,0x0040000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_order_by_clause_in_nested_sort4788 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000140000000L});
    public static final BitSet FOLLOW_func_clause_in_nested_sort4790 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DISTINCT_in_nested_distinct4820 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_distinct4822 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LIMIT_in_nested_limit4855 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_limit4857 = new BitSet(new long[]{0x814410540400A000L,0x0040009400089000L,0x04000C0282998020L});
    public static final BitSet FOLLOW_INTEGER_in_nested_limit4861 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_nested_limit4871 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CROSS_in_nested_cross4904 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_list_in_nested_cross4906 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FOREACH_in_nested_foreach4938 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_foreach4940 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_generate_clause_in_nested_foreach4942 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_GENERATE_in_generate_clause4971 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_flatten_generated_item_in_generate_clause4975 = new BitSet(new long[]{0x814490540400A008L,0x0040009400089000L,0x04000C0283998020L});
    public static final BitSet FOLLOW_col_ref_in_nested_op_input5041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_proj_in_nested_op_input5052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nested_op_input_in_nested_op_input_list5078 = new BitSet(new long[]{0x0140001004000002L,0x0000000000000000L,0x0000400000000000L});
    public static final BitSet FOLLOW_STREAM_in_stream_clause5103 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_stream_clause5105 = new BitSet(new long[]{0x0100080000000000L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_stream_clause5109 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_IDENTIFIER_in_stream_clause5132 = new BitSet(new long[]{0x0000000000000108L});
    public static final BitSet FOLLOW_as_clause_in_stream_clause5174 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MAPREDUCE_in_mr_clause5202 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_mr_clause5204 = new BitSet(new long[]{0x0000000000000000L,0x0400008000000000L});
    public static final BitSet FOLLOW_path_list_in_mr_clause5206 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_store_clause_in_mr_clause5217 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_load_clause_in_mr_clause5226 = new BitSet(new long[]{0x0000080000000008L});
    public static final BitSet FOLLOW_EXECCOMMAND_in_mr_clause5233 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_in_split_clause5253 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rel_in_split_clause5261 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_split_branch_in_split_clause5277 = new BitSet(new long[]{0x0000000000000008L,0x0000000020000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_split_otherwise_in_split_clause5280 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SPLIT_BRANCH_in_split_branch5309 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_branch5311 = new BitSet(new long[]{0x0800000000000040L,0xF00000000BFC0000L,0x0000000280040007L});
    public static final BitSet FOLLOW_cond_in_split_branch5313 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OTHERWISE_in_split_otherwise5347 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alias_in_split_otherwise5349 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_alias_col_ref_in_col_ref5369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dollar_col_ref_in_col_ref5377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_alias_col_ref5394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_alias_col_ref5404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_alias_col_ref5414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLARVAR_in_dollar_col_ref5433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_const_expr5452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scalar_in_literal5470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_in_literal5480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bag_in_literal5490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tuple_in_literal5500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_num_scalar_in_scalar5518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_scalar5528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_scalar5538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_scalar5548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_scalar5558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_num_scalar5583 = new BitSet(new long[]{0x800400400000A000L,0x0000000000001000L});
    public static final BitSet FOLLOW_INTEGER_in_num_scalar5596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGINTEGER_in_num_scalar5610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOATNUMBER_in_num_scalar5624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_num_scalar5638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINTEGERNUMBER_in_num_scalar5652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGDECIMALNUMBER_in_num_scalar5666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_VAL_in_map5698 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_keyvalue_in_map5702 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_KEY_VAL_PAIR_in_keyvalue5729 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_map_key_in_keyvalue5731 = new BitSet(new long[]{0x800410400000A000L,0x0000008000089000L,0x0400040000008020L});
    public static final BitSet FOLLOW_literal_in_keyvalue5733 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_QUOTEDSTRING_in_map_key5753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_VAL_in_bag5775 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tuple_in_bag5779 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_TUPLE_VAL_in_tuple5811 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_literal_in_tuple5815 = new BitSet(new long[]{0x800410400000A008L,0x0000008000089000L,0x0400040000008020L});
    public static final BitSet FOLLOW_rel_str_op_in_eid5840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_eid5850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURNS_in_eid5860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_eid5870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOAD_in_eid5880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILTER_in_eid5890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOREACH_in_eid5900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MATCHES_in_eid5910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORDER_in_eid5920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DISTINCT_in_eid5930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COGROUP_in_eid5940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CUBE_in_eid5950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ROLLUP_in_eid5960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JOIN_in_eid5970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CROSS_in_eid5980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNION_in_eid5990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SPLIT_in_eid6000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTO_in_eid6010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_eid6020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALL_in_eid6030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AS_in_eid6040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BY_in_eid6050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USING_in_eid6060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INNER_in_eid6070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTER_in_eid6080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARALLEL_in_eid6090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARTITION_in_eid6100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GROUP_in_eid6110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_eid6120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_eid6130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_eid6140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATE_in_eid6150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLATTEN_in_eid6160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EVAL_in_eid6170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASC_in_eid6180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESC_in_eid6190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_eid6200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_eid6210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONG_in_eid6220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_eid6230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLE_in_eid6240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGINTEGER_in_eid6250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BIGDECIMAL_in_eid6260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATETIME_in_eid6270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHARARRAY_in_eid6280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTEARRAY_in_eid6290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_in_eid6300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TUPLE_in_eid6310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAP_in_eid6320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IS_in_eid6330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NULL_in_eid6340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_eid6350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_eid6360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STREAM_in_eid6370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROUGH_in_eid6380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STORE_in_eid6390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAPREDUCE_in_eid6400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHIP_in_eid6410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CACHE_in_eid6420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INPUT_in_eid6430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTPUT_in_eid6440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDERROR_in_eid6450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDIN_in_eid6460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STDOUT_in_eid6470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LIMIT_in_eid6480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SAMPLE_in_eid6490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_in_eid6500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RIGHT_in_eid6510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FULL_in_eid6520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_eid6530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOBAG_in_eid6540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOMAP_in_eid6550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOTUPLE_in_eid6560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSERT_in_eid6570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_eq_in_rel_op6583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_ne_in_rel_op6594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gt_in_rel_op6605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_gte_in_rel_op6616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lt_in_rel_op6627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rel_op_lte_in_rel_op6638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_rel_op6649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_EQ_in_rel_str_op6740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_NE_in_rel_str_op6747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_GT_in_rel_str_op6754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_LT_in_rel_str_op6761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_GTE_in_rel_str_op6768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_LTE_in_rel_str_op6775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STR_OP_MATCHES_in_rel_str_op6782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_synpred146_LogicalPlanGenerator3647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGINTEGER_in_synpred147_LogicalPlanGenerator3657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLENUMBER_in_synpred148_LogicalPlanGenerator3709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_join_item_in_synpred178_LogicalPlanGenerator4238 = new BitSet(new long[]{0x0010000000000000L,0x0000080000000010L});
    public static final BitSet FOLLOW_set_in_synpred178_LogicalPlanGenerator4240 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_OUTER_in_synpred178_LogicalPlanGenerator4286 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000001000000000L});
    public static final BitSet FOLLOW_join_item_in_synpred178_LogicalPlanGenerator4289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_synpred195_LogicalPlanGenerator4861 = new BitSet(new long[]{0x0000000000000002L});

}