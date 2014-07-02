// $ANTLR 3.4 /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g 2014-07-02 16:21:35

package org.apache.pig.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Lexer file for Pig Parser
 */
@SuppressWarnings({"all", "warnings", "unchecked"})
public class QueryLexer extends Lexer {
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


    @Override
    public void reportError(RecognitionException e) {
        super.reportError( e );

        // The method of this signature doesn't permit checked exception. Here we have to
        // throw a unchecked execption in order to stop at the first error.
        // For more information, visit http://www.antlr.org/wiki/pages/viewpage.action?pageId=5341217.
        StringBuilder sb = new StringBuilder();
        sb.append( getErrorHeader( e ) ).append( " " );
        sb.append( getErrorMessage( e, getTokenNames() ) );
        throw new RuntimeException( sb.toString() );
    }

    @Override
    public String getErrorMessage(RecognitionException e, String[] tokenNames ) {
        if( e instanceof NoViableAltException ) {
            return "Unexpected character " + getCharErrorDisplay( e.c );
        } else {
            return super.getErrorMessage( e, tokenNames );
        }
    }

    @Override
    public String getErrorHeader(RecognitionException ex) {
    	return QueryParserUtils.generateErrorHeader( ex, this.getSourceName() );
    }



    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public QueryLexer() {} 
    public QueryLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public QueryLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g"; }

    // $ANTLR start "VOID"
    public final void mVOID() throws RecognitionException {
        try {
            int _type = VOID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:60:9: ( 'VOID' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:60:11: 'VOID'
            {
            match("VOID"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "VOID"

    // $ANTLR start "NULL"
    public final void mNULL() throws RecognitionException {
        try {
            int _type = NULL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:63:9: ( 'NULL' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:63:11: 'NULL'
            {
            match("NULL"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NULL"

    // $ANTLR start "IMPORT"
    public final void mIMPORT() throws RecognitionException {
        try {
            int _type = IMPORT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:66:9: ( 'IMPORT' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:66:11: 'IMPORT'
            {
            match("IMPORT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IMPORT"

    // $ANTLR start "REGISTER"
    public final void mREGISTER() throws RecognitionException {
        try {
            int _type = REGISTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:69:10: ( 'REGISTER' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:69:12: 'REGISTER'
            {
            match("REGISTER"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "REGISTER"

    // $ANTLR start "RETURNS"
    public final void mRETURNS() throws RecognitionException {
        try {
            int _type = RETURNS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:72:9: ( 'RETURNS' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:72:11: 'RETURNS'
            {
            match("RETURNS"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RETURNS"

    // $ANTLR start "DEFINE"
    public final void mDEFINE() throws RecognitionException {
        try {
            int _type = DEFINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:75:8: ( 'DEFINE' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:75:10: 'DEFINE'
            {
            match("DEFINE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DEFINE"

    // $ANTLR start "LOAD"
    public final void mLOAD() throws RecognitionException {
        try {
            int _type = LOAD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:78:8: ( 'LOAD' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:78:10: 'LOAD'
            {
            match("LOAD"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LOAD"

    // $ANTLR start "FILTER"
    public final void mFILTER() throws RecognitionException {
        try {
            int _type = FILTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:81:8: ( 'FILTER' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:81:10: 'FILTER'
            {
            match("FILTER"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FILTER"

    // $ANTLR start "FOREACH"
    public final void mFOREACH() throws RecognitionException {
        try {
            int _type = FOREACH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:84:9: ( 'FOREACH' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:84:11: 'FOREACH'
            {
            match("FOREACH"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FOREACH"

    // $ANTLR start "ORDER"
    public final void mORDER() throws RecognitionException {
        try {
            int _type = ORDER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:87:9: ( 'ORDER' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:87:12: 'ORDER'
            {
            match("ORDER"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ORDER"

    // $ANTLR start "RANK"
    public final void mRANK() throws RecognitionException {
        try {
            int _type = RANK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:90:8: ( 'RANK' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:90:11: 'RANK'
            {
            match("RANK"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RANK"

    // $ANTLR start "DENSE"
    public final void mDENSE() throws RecognitionException {
        try {
            int _type = DENSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:93:9: ( 'DENSE' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:93:12: 'DENSE'
            {
            match("DENSE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DENSE"

    // $ANTLR start "CUBE"
    public final void mCUBE() throws RecognitionException {
        try {
            int _type = CUBE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:96:9: ( 'CUBE' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:96:11: 'CUBE'
            {
            match("CUBE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CUBE"

    // $ANTLR start "ROLLUP"
    public final void mROLLUP() throws RecognitionException {
        try {
            int _type = ROLLUP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:99:8: ( 'ROLLUP' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:99:10: 'ROLLUP'
            {
            match("ROLLUP"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ROLLUP"

    // $ANTLR start "INVOKE"
    public final void mINVOKE() throws RecognitionException {
        try {
            int _type = INVOKE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:102:9: ( 'INVOKE' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:102:11: 'INVOKE'
            {
            match("INVOKE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INVOKE"

    // $ANTLR start "DISTINCT"
    public final void mDISTINCT() throws RecognitionException {
        try {
            int _type = DISTINCT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:105:10: ( 'DISTINCT' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:105:12: 'DISTINCT'
            {
            match("DISTINCT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DISTINCT"

    // $ANTLR start "COGROUP"
    public final void mCOGROUP() throws RecognitionException {
        try {
            int _type = COGROUP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:108:9: ( 'COGROUP' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:108:11: 'COGROUP'
            {
            match("COGROUP"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COGROUP"

    // $ANTLR start "JOIN"
    public final void mJOIN() throws RecognitionException {
        try {
            int _type = JOIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:111:6: ( 'JOIN' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:111:8: 'JOIN'
            {
            match("JOIN"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "JOIN"

    // $ANTLR start "CROSS"
    public final void mCROSS() throws RecognitionException {
        try {
            int _type = CROSS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:114:7: ( 'CROSS' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:114:9: 'CROSS'
            {
            match("CROSS"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CROSS"

    // $ANTLR start "UNION"
    public final void mUNION() throws RecognitionException {
        try {
            int _type = UNION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:117:7: ( 'UNION' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:117:9: 'UNION'
            {
            match("UNION"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNION"

    // $ANTLR start "SPLIT"
    public final void mSPLIT() throws RecognitionException {
        try {
            int _type = SPLIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:120:7: ( 'SPLIT' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:120:9: 'SPLIT'
            {
            match("SPLIT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SPLIT"

    // $ANTLR start "INTO"
    public final void mINTO() throws RecognitionException {
        try {
            int _type = INTO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:123:6: ( 'INTO' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:123:8: 'INTO'
            {
            match("INTO"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INTO"

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:126:4: ( 'IF' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:126:6: 'IF'
            {
            match("IF"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IF"

    // $ANTLR start "OTHERWISE"
    public final void mOTHERWISE() throws RecognitionException {
        try {
            int _type = OTHERWISE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:129:11: ( 'OTHERWISE' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:129:13: 'OTHERWISE'
            {
            match("OTHERWISE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OTHERWISE"

    // $ANTLR start "ALL"
    public final void mALL() throws RecognitionException {
        try {
            int _type = ALL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:132:5: ( 'ALL' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:132:7: 'ALL'
            {
            match("ALL"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ALL"

    // $ANTLR start "AS"
    public final void mAS() throws RecognitionException {
        try {
            int _type = AS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:135:4: ( 'AS' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:135:6: 'AS'
            {
            match("AS"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AS"

    // $ANTLR start "BY"
    public final void mBY() throws RecognitionException {
        try {
            int _type = BY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:138:4: ( 'BY' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:138:6: 'BY'
            {
            match("BY"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BY"

    // $ANTLR start "USING"
    public final void mUSING() throws RecognitionException {
        try {
            int _type = USING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:141:7: ( 'USING' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:141:9: 'USING'
            {
            match("USING"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "USING"

    // $ANTLR start "INNER"
    public final void mINNER() throws RecognitionException {
        try {
            int _type = INNER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:144:7: ( 'INNER' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:144:9: 'INNER'
            {
            match("INNER"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INNER"

    // $ANTLR start "OUTER"
    public final void mOUTER() throws RecognitionException {
        try {
            int _type = OUTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:147:7: ( 'OUTER' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:147:9: 'OUTER'
            {
            match("OUTER"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OUTER"

    // $ANTLR start "ONSCHEMA"
    public final void mONSCHEMA() throws RecognitionException {
        try {
            int _type = ONSCHEMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:150:10: ( 'ONSCHEMA' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:150:12: 'ONSCHEMA'
            {
            match("ONSCHEMA"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ONSCHEMA"

    // $ANTLR start "PARALLEL"
    public final void mPARALLEL() throws RecognitionException {
        try {
            int _type = PARALLEL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:153:10: ( 'PARALLEL' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:153:12: 'PARALLEL'
            {
            match("PARALLEL"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PARALLEL"

    // $ANTLR start "PARTITION"
    public final void mPARTITION() throws RecognitionException {
        try {
            int _type = PARTITION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:156:11: ( 'PARTITION' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:156:13: 'PARTITION'
            {
            match("PARTITION"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PARTITION"

    // $ANTLR start "GROUP"
    public final void mGROUP() throws RecognitionException {
        try {
            int _type = GROUP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:159:7: ( 'GROUP' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:159:9: 'GROUP'
            {
            match("GROUP"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GROUP"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:162:5: ( 'AND' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:162:7: 'AND'
            {
            match("AND"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:165:4: ( 'OR' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:165:6: 'OR'
            {
            match("OR"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:168:5: ( 'NOT' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:168:7: 'NOT'
            {
            match("NOT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "GENERATE"
    public final void mGENERATE() throws RecognitionException {
        try {
            int _type = GENERATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:171:10: ( 'GENERATE' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:171:12: 'GENERATE'
            {
            match("GENERATE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GENERATE"

    // $ANTLR start "FLATTEN"
    public final void mFLATTEN() throws RecognitionException {
        try {
            int _type = FLATTEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:174:9: ( 'FLATTEN' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:174:11: 'FLATTEN'
            {
            match("FLATTEN"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLATTEN"

    // $ANTLR start "ASC"
    public final void mASC() throws RecognitionException {
        try {
            int _type = ASC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:177:5: ( 'ASC' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:177:7: 'ASC'
            {
            match("ASC"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ASC"

    // $ANTLR start "DESC"
    public final void mDESC() throws RecognitionException {
        try {
            int _type = DESC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:180:6: ( 'DESC' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:180:8: 'DESC'
            {
            match("DESC"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DESC"

    // $ANTLR start "BOOLEAN"
    public final void mBOOLEAN() throws RecognitionException {
        try {
            int _type = BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:183:9: ( 'BOOLEAN' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:183:11: 'BOOLEAN'
            {
            match("BOOLEAN"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BOOLEAN"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:186:5: ( 'INT' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:186:7: 'INT'
            {
            match("INT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "LONG"
    public final void mLONG() throws RecognitionException {
        try {
            int _type = LONG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:189:6: ( 'LONG' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:189:8: 'LONG'
            {
            match("LONG"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LONG"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:192:7: ( 'FLOAT' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:192:9: 'FLOAT'
            {
            match("FLOAT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "BIGDECIMAL"
    public final void mBIGDECIMAL() throws RecognitionException {
        try {
            int _type = BIGDECIMAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:195:12: ( 'BIGDECIMAL' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:195:14: 'BIGDECIMAL'
            {
            match("BIGDECIMAL"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BIGDECIMAL"

    // $ANTLR start "BIGINTEGER"
    public final void mBIGINTEGER() throws RecognitionException {
        try {
            int _type = BIGINTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:198:12: ( 'BIGINTEGER' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:198:14: 'BIGINTEGER'
            {
            match("BIGINTEGER"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BIGINTEGER"

    // $ANTLR start "DOUBLE"
    public final void mDOUBLE() throws RecognitionException {
        try {
            int _type = DOUBLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:201:8: ( 'DOUBLE' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:201:10: 'DOUBLE'
            {
            match("DOUBLE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOUBLE"

    // $ANTLR start "DATETIME"
    public final void mDATETIME() throws RecognitionException {
        try {
            int _type = DATETIME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:204:10: ( 'DATETIME' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:204:12: 'DATETIME'
            {
            match("DATETIME"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DATETIME"

    // $ANTLR start "CHARARRAY"
    public final void mCHARARRAY() throws RecognitionException {
        try {
            int _type = CHARARRAY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:207:11: ( 'CHARARRAY' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:207:13: 'CHARARRAY'
            {
            match("CHARARRAY"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CHARARRAY"

    // $ANTLR start "BYTEARRAY"
    public final void mBYTEARRAY() throws RecognitionException {
        try {
            int _type = BYTEARRAY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:210:11: ( 'BYTEARRAY' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:210:13: 'BYTEARRAY'
            {
            match("BYTEARRAY"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BYTEARRAY"

    // $ANTLR start "BAG"
    public final void mBAG() throws RecognitionException {
        try {
            int _type = BAG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:213:5: ( 'BAG' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:213:7: 'BAG'
            {
            match("BAG"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BAG"

    // $ANTLR start "TUPLE"
    public final void mTUPLE() throws RecognitionException {
        try {
            int _type = TUPLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:216:7: ( 'TUPLE' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:216:9: 'TUPLE'
            {
            match("TUPLE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TUPLE"

    // $ANTLR start "MAP"
    public final void mMAP() throws RecognitionException {
        try {
            int _type = MAP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:219:5: ( 'MAP' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:219:7: 'MAP'
            {
            match("MAP"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MAP"

    // $ANTLR start "IS"
    public final void mIS() throws RecognitionException {
        try {
            int _type = IS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:222:4: ( 'IS' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:222:6: 'IS'
            {
            match("IS"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IS"

    // $ANTLR start "STREAM"
    public final void mSTREAM() throws RecognitionException {
        try {
            int _type = STREAM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:225:8: ( 'STREAM' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:225:10: 'STREAM'
            {
            match("STREAM"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STREAM"

    // $ANTLR start "THROUGH"
    public final void mTHROUGH() throws RecognitionException {
        try {
            int _type = THROUGH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:228:9: ( 'THROUGH' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:228:11: 'THROUGH'
            {
            match("THROUGH"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "THROUGH"

    // $ANTLR start "STORE"
    public final void mSTORE() throws RecognitionException {
        try {
            int _type = STORE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:231:7: ( 'STORE' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:231:9: 'STORE'
            {
            match("STORE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STORE"

    // $ANTLR start "ASSERT"
    public final void mASSERT() throws RecognitionException {
        try {
            int _type = ASSERT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:234:8: ( 'ASSERT' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:234:10: 'ASSERT'
            {
            match("ASSERT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ASSERT"

    // $ANTLR start "MAPREDUCE"
    public final void mMAPREDUCE() throws RecognitionException {
        try {
            int _type = MAPREDUCE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:237:11: ( 'MAPREDUCE' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:237:13: 'MAPREDUCE'
            {
            match("MAPREDUCE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MAPREDUCE"

    // $ANTLR start "SHIP"
    public final void mSHIP() throws RecognitionException {
        try {
            int _type = SHIP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:240:6: ( 'SHIP' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:240:8: 'SHIP'
            {
            match("SHIP"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SHIP"

    // $ANTLR start "CACHE"
    public final void mCACHE() throws RecognitionException {
        try {
            int _type = CACHE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:243:7: ( 'CACHE' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:243:9: 'CACHE'
            {
            match("CACHE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CACHE"

    // $ANTLR start "INPUT"
    public final void mINPUT() throws RecognitionException {
        try {
            int _type = INPUT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:246:7: ( 'INPUT' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:246:9: 'INPUT'
            {
            match("INPUT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INPUT"

    // $ANTLR start "OUTPUT"
    public final void mOUTPUT() throws RecognitionException {
        try {
            int _type = OUTPUT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:249:8: ( 'OUTPUT' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:249:10: 'OUTPUT'
            {
            match("OUTPUT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OUTPUT"

    // $ANTLR start "STDERROR"
    public final void mSTDERROR() throws RecognitionException {
        try {
            int _type = STDERROR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:252:10: ( 'STDERR' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:252:12: 'STDERR'
            {
            match("STDERR"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STDERROR"

    // $ANTLR start "STDIN"
    public final void mSTDIN() throws RecognitionException {
        try {
            int _type = STDIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:255:7: ( 'STDIN' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:255:9: 'STDIN'
            {
            match("STDIN"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STDIN"

    // $ANTLR start "STDOUT"
    public final void mSTDOUT() throws RecognitionException {
        try {
            int _type = STDOUT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:258:8: ( 'STDOUT' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:258:10: 'STDOUT'
            {
            match("STDOUT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STDOUT"

    // $ANTLR start "LIMIT"
    public final void mLIMIT() throws RecognitionException {
        try {
            int _type = LIMIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:261:7: ( 'LIMIT' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:261:9: 'LIMIT'
            {
            match("LIMIT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LIMIT"

    // $ANTLR start "SAMPLE"
    public final void mSAMPLE() throws RecognitionException {
        try {
            int _type = SAMPLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:264:8: ( 'SAMPLE' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:264:10: 'SAMPLE'
            {
            match("SAMPLE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SAMPLE"

    // $ANTLR start "LEFT"
    public final void mLEFT() throws RecognitionException {
        try {
            int _type = LEFT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:267:6: ( 'LEFT' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:267:8: 'LEFT'
            {
            match("LEFT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LEFT"

    // $ANTLR start "RIGHT"
    public final void mRIGHT() throws RecognitionException {
        try {
            int _type = RIGHT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:270:7: ( 'RIGHT' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:270:9: 'RIGHT'
            {
            match("RIGHT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RIGHT"

    // $ANTLR start "FULL"
    public final void mFULL() throws RecognitionException {
        try {
            int _type = FULL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:273:6: ( 'FULL' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:273:8: 'FULL'
            {
            match("FULL"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FULL"

    // $ANTLR start "CASE"
    public final void mCASE() throws RecognitionException {
        try {
            int _type = CASE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:276:6: ( 'CASE' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:276:8: 'CASE'
            {
            match("CASE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CASE"

    // $ANTLR start "WHEN"
    public final void mWHEN() throws RecognitionException {
        try {
            int _type = WHEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:279:6: ( 'WHEN' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:279:8: 'WHEN'
            {
            match("WHEN"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHEN"

    // $ANTLR start "THEN"
    public final void mTHEN() throws RecognitionException {
        try {
            int _type = THEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:282:6: ( 'THEN' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:282:8: 'THEN'
            {
            match("THEN"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "THEN"

    // $ANTLR start "ELSE"
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:285:6: ( 'ELSE' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:285:8: 'ELSE'
            {
            match("ELSE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ELSE"

    // $ANTLR start "END"
    public final void mEND() throws RecognitionException {
        try {
            int _type = END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:288:5: ( 'END' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:288:7: 'END'
            {
            match("END"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "END"

    // $ANTLR start "STR_OP_EQ"
    public final void mSTR_OP_EQ() throws RecognitionException {
        try {
            int _type = STR_OP_EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:291:11: ( 'EQ' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:291:13: 'EQ'
            {
            match("EQ"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STR_OP_EQ"

    // $ANTLR start "STR_OP_GT"
    public final void mSTR_OP_GT() throws RecognitionException {
        try {
            int _type = STR_OP_GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:294:11: ( 'GT' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:294:13: 'GT'
            {
            match("GT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STR_OP_GT"

    // $ANTLR start "STR_OP_LT"
    public final void mSTR_OP_LT() throws RecognitionException {
        try {
            int _type = STR_OP_LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:297:11: ( 'LT' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:297:13: 'LT'
            {
            match("LT"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STR_OP_LT"

    // $ANTLR start "STR_OP_GTE"
    public final void mSTR_OP_GTE() throws RecognitionException {
        try {
            int _type = STR_OP_GTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:300:12: ( 'GTE' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:300:14: 'GTE'
            {
            match("GTE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STR_OP_GTE"

    // $ANTLR start "STR_OP_LTE"
    public final void mSTR_OP_LTE() throws RecognitionException {
        try {
            int _type = STR_OP_LTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:303:12: ( 'LTE' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:303:14: 'LTE'
            {
            match("LTE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STR_OP_LTE"

    // $ANTLR start "STR_OP_NE"
    public final void mSTR_OP_NE() throws RecognitionException {
        try {
            int _type = STR_OP_NE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:306:11: ( 'NEQ' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:306:13: 'NEQ'
            {
            match("NEQ"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STR_OP_NE"

    // $ANTLR start "STR_OP_MATCHES"
    public final void mSTR_OP_MATCHES() throws RecognitionException {
        try {
            int _type = STR_OP_MATCHES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:309:16: ( 'MATCHES' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:309:18: 'MATCHES'
            {
            match("MATCHES"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STR_OP_MATCHES"

    // $ANTLR start "IN"
    public final void mIN() throws RecognitionException {
        try {
            int _type = IN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:312:4: ( 'IN' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:312:6: 'IN'
            {
            match("IN"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IN"

    // $ANTLR start "TRUE"
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:315:6: ( 'TRUE' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:315:8: 'TRUE'
            {
            match("TRUE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TRUE"

    // $ANTLR start "FALSE"
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:318:7: ( 'FALSE' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:318:9: 'FALSE'
            {
            match("FALSE"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FALSE"

    // $ANTLR start "NUM_OP_EQ"
    public final void mNUM_OP_EQ() throws RecognitionException {
        try {
            int _type = NUM_OP_EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:321:11: ( '==' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:321:13: '=='
            {
            match("=="); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUM_OP_EQ"

    // $ANTLR start "NUM_OP_LT"
    public final void mNUM_OP_LT() throws RecognitionException {
        try {
            int _type = NUM_OP_LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:324:11: ( '<' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:324:13: '<'
            {
            match('<'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUM_OP_LT"

    // $ANTLR start "NUM_OP_LTE"
    public final void mNUM_OP_LTE() throws RecognitionException {
        try {
            int _type = NUM_OP_LTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:327:12: ( '<=' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:327:14: '<='
            {
            match("<="); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUM_OP_LTE"

    // $ANTLR start "NUM_OP_GT"
    public final void mNUM_OP_GT() throws RecognitionException {
        try {
            int _type = NUM_OP_GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:330:11: ( '>' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:330:13: '>'
            {
            match('>'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUM_OP_GT"

    // $ANTLR start "NUM_OP_GTE"
    public final void mNUM_OP_GTE() throws RecognitionException {
        try {
            int _type = NUM_OP_GTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:333:12: ( '>=' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:333:14: '>='
            {
            match(">="); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUM_OP_GTE"

    // $ANTLR start "NUM_OP_NE"
    public final void mNUM_OP_NE() throws RecognitionException {
        try {
            int _type = NUM_OP_NE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:336:11: ( '!=' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:336:13: '!='
            {
            match("!="); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUM_OP_NE"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:339:16: ( '0' .. '9' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                input.consume();
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:342:17: ( 'A' .. 'Z' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z') ) {
                input.consume();
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "SPECIALCHAR"
    public final void mSPECIALCHAR() throws RecognitionException {
        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:345:22: ( '_' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:345:24: '_'
            {
            match('_'); if (state.failed) return ;

            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SPECIALCHAR"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:348:12: ( LETTER ( DIGIT | LETTER | SPECIALCHAR )* )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:348:14: LETTER ( DIGIT | LETTER | SPECIALCHAR )*
            {
            mLETTER(); if (state.failed) return ;


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:348:21: ( DIGIT | LETTER | SPECIALCHAR )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_' ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "DCOLON"
    public final void mDCOLON() throws RecognitionException {
        try {
            int _type = DCOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:351:8: ( '::' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:351:10: '::'
            {
            match("::"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DCOLON"

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:359:7: ( ( ID DCOLON )=> ( ID DCOLON IDENTIFIER ) | ID )
            int alt2=2;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:359:9: ( ID DCOLON )=> ( ID DCOLON IDENTIFIER )
                    {
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:359:26: ( ID DCOLON IDENTIFIER )
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:359:28: ID DCOLON IDENTIFIER
                    {
                    mID(); if (state.failed) return ;


                    mDCOLON(); if (state.failed) return ;


                    mIDENTIFIER(); if (state.failed) return ;


                    }


                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:359:53: ID
                    {
                    mID(); if (state.failed) return ;


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
            if ( state.backtracking==0 ) {
                    if("null".equalsIgnoreCase(getText())){
                        state.type = NULL;
                    }
                }
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IDENTIFIER"

    // $ANTLR start "FLOATINGPOINT"
    public final void mFLOATINGPOINT() throws RecognitionException {
        try {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:362:24: ( INTEGER ( PERIOD INTEGER )? | PERIOD INTEGER )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
                alt4=1;
            }
            else if ( (LA4_0=='.') ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:362:26: INTEGER ( PERIOD INTEGER )?
                    {
                    mINTEGER(); if (state.failed) return ;


                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:362:34: ( PERIOD INTEGER )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0=='.') ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:362:36: PERIOD INTEGER
                            {
                            mPERIOD(); if (state.failed) return ;


                            mINTEGER(); if (state.failed) return ;


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:362:56: PERIOD INTEGER
                    {
                    mPERIOD(); if (state.failed) return ;


                    mINTEGER(); if (state.failed) return ;


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOATINGPOINT"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:365:8: ( ( DIGIT )+ )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:365:10: ( DIGIT )+
            {
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:365:10: ( DIGIT )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "LONGINTEGER"
    public final void mLONGINTEGER() throws RecognitionException {
        try {
            int _type = LONGINTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:368:12: ( INTEGER 'L' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:368:14: INTEGER 'L'
            {
            mINTEGER(); if (state.failed) return ;


            match('L'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LONGINTEGER"

    // $ANTLR start "DOLLARVAR"
    public final void mDOLLARVAR() throws RecognitionException {
        try {
            int _type = DOLLARVAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:371:11: ( DOLLAR INTEGER )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:371:13: DOLLAR INTEGER
            {
            mDOLLAR(); if (state.failed) return ;


            mINTEGER(); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOLLARVAR"

    // $ANTLR start "DOUBLENUMBER"
    public final void mDOUBLENUMBER() throws RecognitionException {
        try {
            int _type = DOUBLENUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:374:14: ( FLOATINGPOINT ( 'E' ( MINUS | PLUS )? INTEGER )? )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:374:16: FLOATINGPOINT ( 'E' ( MINUS | PLUS )? INTEGER )?
            {
            mFLOATINGPOINT(); if (state.failed) return ;


            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:374:30: ( 'E' ( MINUS | PLUS )? INTEGER )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='E') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:374:32: 'E' ( MINUS | PLUS )? INTEGER
                    {
                    match('E'); if (state.failed) return ;

                    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:374:36: ( MINUS | PLUS )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='+'||LA6_0=='-') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:
                            {
                            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                input.consume();
                                state.failed=false;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;
                            }


                            }
                            break;

                    }


                    mINTEGER(); if (state.failed) return ;


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOUBLENUMBER"

    // $ANTLR start "BIGDECIMALNUMBER"
    public final void mBIGDECIMALNUMBER() throws RecognitionException {
        try {
            int _type = BIGDECIMALNUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:377:18: ( DOUBLENUMBER 'BD' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:377:20: DOUBLENUMBER 'BD'
            {
            mDOUBLENUMBER(); if (state.failed) return ;


            match("BD"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BIGDECIMALNUMBER"

    // $ANTLR start "BIGINTEGERNUMBER"
    public final void mBIGINTEGERNUMBER() throws RecognitionException {
        try {
            int _type = BIGINTEGERNUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:380:18: ( INTEGER 'BI' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:380:20: INTEGER 'BI'
            {
            mINTEGER(); if (state.failed) return ;


            match("BI"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BIGINTEGERNUMBER"

    // $ANTLR start "FLOATNUMBER"
    public final void mFLOATNUMBER() throws RecognitionException {
        try {
            int _type = FLOATNUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:383:13: ( DOUBLENUMBER 'F' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:383:15: DOUBLENUMBER 'F'
            {
            mDOUBLENUMBER(); if (state.failed) return ;


            match('F'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOATNUMBER"

    // $ANTLR start "QUOTEDSTRING"
    public final void mQUOTEDSTRING() throws RecognitionException {
        try {
            int _type = QUOTEDSTRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:386:14: ( '\\'' ( (~ ( '\\'' | '\\\\' | '\\n' | '\\r' ) ) | ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' ) ) ) | ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ) )* '\\'' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:386:17: '\\'' ( (~ ( '\\'' | '\\\\' | '\\n' | '\\r' ) ) | ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' ) ) ) | ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ) )* '\\''
            {
            match('\''); if (state.failed) return ;

            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:386:22: ( (~ ( '\\'' | '\\\\' | '\\n' | '\\r' ) ) | ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' ) ) ) | ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ) )*
            loop8:
            do {
                int alt8=4;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0 >= '\u0000' && LA8_0 <= '\t')||(LA8_0 >= '\u000B' && LA8_0 <= '\f')||(LA8_0 >= '\u000E' && LA8_0 <= '&')||(LA8_0 >= '(' && LA8_0 <= '[')||(LA8_0 >= ']' && LA8_0 <= '\uFFFF')) ) {
                    alt8=1;
                }
                else if ( (LA8_0=='\\') ) {
                    int LA8_3 = input.LA(2);

                    if ( (LA8_3=='\''||LA8_3=='B'||LA8_3=='F'||LA8_3=='N'||LA8_3=='R'||LA8_3=='T'||LA8_3=='\\') ) {
                        alt8=2;
                    }
                    else if ( (LA8_3=='U') ) {
                        alt8=3;
                    }


                }


                switch (alt8) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:386:26: (~ ( '\\'' | '\\\\' | '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;
            	case 2 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:387:26: ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' ) ) )
            	    {
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:387:26: ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' ) ) )
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:387:28: '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' ) )
            	    {
            	    match('\\'); if (state.failed) return ;

            	    if ( input.LA(1)=='\''||input.LA(1)=='B'||input.LA(1)=='F'||input.LA(1)=='N'||input.LA(1)=='R'||input.LA(1)=='T'||input.LA(1)=='\\' ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:388:26: ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) )
            	    {
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:388:26: ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) )
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:388:28: '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' )
            	    {
            	    match("\\U"); if (state.failed) return ;



            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            match('\''); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUOTEDSTRING"

    // $ANTLR start "MULTILINE_QUOTEDSTRING"
    public final void mMULTILINE_QUOTEDSTRING() throws RecognitionException {
        try {
            int _type = MULTILINE_QUOTEDSTRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:396:24: ( '\\'' ( (~ ( '\\'' | '\\\\' ) ) | ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' | 'n' | 'r' ) ) ) | ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ) )* '\\'' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:396:27: '\\'' ( (~ ( '\\'' | '\\\\' ) ) | ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' | 'n' | 'r' ) ) ) | ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ) )* '\\''
            {
            match('\''); if (state.failed) return ;

            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:396:32: ( (~ ( '\\'' | '\\\\' ) ) | ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' | 'n' | 'r' ) ) ) | ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ) )*
            loop9:
            do {
                int alt9=4;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0 >= '\u0000' && LA9_0 <= '&')||(LA9_0 >= '(' && LA9_0 <= '[')||(LA9_0 >= ']' && LA9_0 <= '\uFFFF')) ) {
                    alt9=1;
                }
                else if ( (LA9_0=='\\') ) {
                    int LA9_3 = input.LA(2);

                    if ( (LA9_3=='\''||LA9_3=='B'||LA9_3=='F'||LA9_3=='N'||LA9_3=='R'||LA9_3=='T'||LA9_3=='\\'||LA9_3=='n'||LA9_3=='r') ) {
                        alt9=2;
                    }
                    else if ( (LA9_3=='U') ) {
                        alt9=3;
                    }


                }


                switch (alt9) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:396:36: (~ ( '\\'' | '\\\\' ) )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;
            	case 2 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:397:36: ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' | 'n' | 'r' ) ) )
            	    {
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:397:36: ( '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' | 'n' | 'r' ) ) )
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:397:38: '\\\\' ( ( 'N' | 'T' | 'B' | 'R' | 'F' | '\\\\' | '\\'' | 'n' | 'r' ) )
            	    {
            	    match('\\'); if (state.failed) return ;

            	    if ( input.LA(1)=='\''||input.LA(1)=='B'||input.LA(1)=='F'||input.LA(1)=='N'||input.LA(1)=='R'||input.LA(1)=='T'||input.LA(1)=='\\'||input.LA(1)=='n'||input.LA(1)=='r' ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:398:36: ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) )
            	    {
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:398:36: ( '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) )
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:398:38: '\\\\U' ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' ) ( '0' .. '9' | 'A' .. 'F' )
            	    {
            	    match("\\U"); if (state.failed) return ;



            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            match('\''); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MULTILINE_QUOTEDSTRING"

    // $ANTLR start "EXECCOMMAND"
    public final void mEXECCOMMAND() throws RecognitionException {
        try {
            int _type = EXECCOMMAND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:406:13: ( '`' (~ ( '`' ) )* '`' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:406:15: '`' (~ ( '`' ) )* '`'
            {
            match('`'); if (state.failed) return ;

            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:406:19: (~ ( '`' ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0 >= '\u0000' && LA10_0 <= '_')||(LA10_0 >= 'a' && LA10_0 <= '\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '_')||(input.LA(1) >= 'a' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            match('`'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EXECCOMMAND"

    // $ANTLR start "STAR"
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:409:6: ( '*' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:409:8: '*'
            {
            match('*'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STAR"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:412:7: ( ':' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:412:9: ':'
            {
            match(':'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "DOLLAR"
    public final void mDOLLAR() throws RecognitionException {
        try {
            int _type = DOLLAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:415:8: ( '$' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:415:10: '$'
            {
            match('$'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOLLAR"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:418:5: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:418:8: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
            {
            if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
                input.consume();
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( state.backtracking==0 ) { _channel = HIDDEN; }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "SL_COMMENT"
    public final void mSL_COMMENT() throws RecognitionException {
        try {
            int _type = SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:421:12: ( '--' (~ ( '\\r' | '\\n' ) )* )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:421:14: '--' (~ ( '\\r' | '\\n' ) )*
            {
            match("--"); if (state.failed) return ;



            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:421:19: (~ ( '\\r' | '\\n' ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0 >= '\u0000' && LA11_0 <= '\t')||(LA11_0 >= '\u000B' && LA11_0 <= '\f')||(LA11_0 >= '\u000E' && LA11_0 <= '\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            if ( state.backtracking==0 ) { _channel = HIDDEN; }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SL_COMMENT"

    // $ANTLR start "ML_COMMENT"
    public final void mML_COMMENT() throws RecognitionException {
        try {
            int _type = ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:424:12: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:424:14: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); if (state.failed) return ;



            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:424:19: ( options {greedy=false; } : . )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0=='*') ) {
                    int LA12_1 = input.LA(2);

                    if ( (LA12_1=='/') ) {
                        alt12=2;
                    }
                    else if ( ((LA12_1 >= '\u0000' && LA12_1 <= '.')||(LA12_1 >= '0' && LA12_1 <= '\uFFFF')) ) {
                        alt12=1;
                    }


                }
                else if ( ((LA12_0 >= '\u0000' && LA12_0 <= ')')||(LA12_0 >= '+' && LA12_0 <= '\uFFFF')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:424:49: .
            	    {
            	    matchAny(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            match("*/"); if (state.failed) return ;



            if ( state.backtracking==0 ) { _channel = HIDDEN; }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ML_COMMENT"

    // $ANTLR start "SEMI_COLON"
    public final void mSEMI_COLON() throws RecognitionException {
        try {
            int _type = SEMI_COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:427:12: ( ';' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:427:14: ';'
            {
            match(';'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SEMI_COLON"

    // $ANTLR start "LEFT_PAREN"
    public final void mLEFT_PAREN() throws RecognitionException {
        try {
            int _type = LEFT_PAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:430:12: ( '(' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:430:14: '('
            {
            match('('); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LEFT_PAREN"

    // $ANTLR start "RIGHT_PAREN"
    public final void mRIGHT_PAREN() throws RecognitionException {
        try {
            int _type = RIGHT_PAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:433:13: ( ')' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:433:15: ')'
            {
            match(')'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RIGHT_PAREN"

    // $ANTLR start "LEFT_CURLY"
    public final void mLEFT_CURLY() throws RecognitionException {
        try {
            int _type = LEFT_CURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:436:12: ( '{' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:436:14: '{'
            {
            match('{'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LEFT_CURLY"

    // $ANTLR start "RIGHT_CURLY"
    public final void mRIGHT_CURLY() throws RecognitionException {
        try {
            int _type = RIGHT_CURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:439:13: ( '}' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:439:15: '}'
            {
            match('}'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RIGHT_CURLY"

    // $ANTLR start "LEFT_BRACKET"
    public final void mLEFT_BRACKET() throws RecognitionException {
        try {
            int _type = LEFT_BRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:442:14: ( '[' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:442:16: '['
            {
            match('['); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LEFT_BRACKET"

    // $ANTLR start "RIGHT_BRACKET"
    public final void mRIGHT_BRACKET() throws RecognitionException {
        try {
            int _type = RIGHT_BRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:445:15: ( ']' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:445:17: ']'
            {
            match(']'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RIGHT_BRACKET"

    // $ANTLR start "POUND"
    public final void mPOUND() throws RecognitionException {
        try {
            int _type = POUND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:448:7: ( '#' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:448:9: '#'
            {
            match('#'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "POUND"

    // $ANTLR start "EQUAL"
    public final void mEQUAL() throws RecognitionException {
        try {
            int _type = EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:451:7: ( '=' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:451:9: '='
            {
            match('='); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EQUAL"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:454:7: ( ',' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:454:9: ','
            {
            match(','); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "PERIOD"
    public final void mPERIOD() throws RecognitionException {
        try {
            int _type = PERIOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:457:8: ( '.' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:457:10: '.'
            {
            match('.'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PERIOD"

    // $ANTLR start "DOUBLE_PERIOD"
    public final void mDOUBLE_PERIOD() throws RecognitionException {
        try {
            int _type = DOUBLE_PERIOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:460:15: ( '..' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:460:17: '..'
            {
            match(".."); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOUBLE_PERIOD"

    // $ANTLR start "DIV"
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:463:5: ( '/' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:463:7: '/'
            {
            match('/'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIV"

    // $ANTLR start "PERCENT"
    public final void mPERCENT() throws RecognitionException {
        try {
            int _type = PERCENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:466:9: ( '%' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:466:11: '%'
            {
            match('%'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PERCENT"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:469:6: ( '+' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:469:8: '+'
            {
            match('+'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:472:7: ( '-' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:472:9: '-'
            {
            match('-'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "QMARK"
    public final void mQMARK() throws RecognitionException {
        try {
            int _type = QMARK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:475:7: ( '?' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:475:9: '?'
            {
            match('?'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QMARK"

    // $ANTLR start "ARROBA"
    public final void mARROBA() throws RecognitionException {
        try {
            int _type = ARROBA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:478:8: ( '@' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:478:10: '@'
            {
            match('@'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ARROBA"

    // $ANTLR start "AMPERSAND"
    public final void mAMPERSAND() throws RecognitionException {
        try {
            int _type = AMPERSAND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:481:11: ( '&' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:481:13: '&'
            {
            match('&'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AMPERSAND"

    // $ANTLR start "FAT_ARROW"
    public final void mFAT_ARROW() throws RecognitionException {
        try {
            int _type = FAT_ARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:484:11: ( '=>' )
            // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:484:13: '=>'
            {
            match("=>"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FAT_ARROW"

    public void mTokens() throws RecognitionException {
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:8: ( VOID | NULL | IMPORT | REGISTER | RETURNS | DEFINE | LOAD | FILTER | FOREACH | ORDER | RANK | DENSE | CUBE | ROLLUP | INVOKE | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | OTHERWISE | ALL | AS | BY | USING | INNER | OUTER | ONSCHEMA | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | BIGDECIMAL | BIGINTEGER | DOUBLE | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | STREAM | THROUGH | STORE | ASSERT | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | CASE | WHEN | THEN | ELSE | END | STR_OP_EQ | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_NE | STR_OP_MATCHES | IN | TRUE | FALSE | NUM_OP_EQ | NUM_OP_LT | NUM_OP_LTE | NUM_OP_GT | NUM_OP_GTE | NUM_OP_NE | DCOLON | IDENTIFIER | INTEGER | LONGINTEGER | DOLLARVAR | DOUBLENUMBER | BIGDECIMALNUMBER | BIGINTEGERNUMBER | FLOATNUMBER | QUOTEDSTRING | MULTILINE_QUOTEDSTRING | EXECCOMMAND | STAR | COLON | DOLLAR | WS | SL_COMMENT | ML_COMMENT | SEMI_COLON | LEFT_PAREN | RIGHT_PAREN | LEFT_CURLY | RIGHT_CURLY | LEFT_BRACKET | RIGHT_BRACKET | POUND | EQUAL | COMMA | PERIOD | DOUBLE_PERIOD | DIV | PERCENT | PLUS | MINUS | QMARK | ARROBA | AMPERSAND | FAT_ARROW )
        int alt13=131;
        alt13 = dfa13.predict(input);
        switch (alt13) {
            case 1 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:10: VOID
                {
                mVOID(); if (state.failed) return ;


                }
                break;
            case 2 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:15: NULL
                {
                mNULL(); if (state.failed) return ;


                }
                break;
            case 3 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:20: IMPORT
                {
                mIMPORT(); if (state.failed) return ;


                }
                break;
            case 4 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:27: REGISTER
                {
                mREGISTER(); if (state.failed) return ;


                }
                break;
            case 5 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:36: RETURNS
                {
                mRETURNS(); if (state.failed) return ;


                }
                break;
            case 6 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:44: DEFINE
                {
                mDEFINE(); if (state.failed) return ;


                }
                break;
            case 7 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:51: LOAD
                {
                mLOAD(); if (state.failed) return ;


                }
                break;
            case 8 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:56: FILTER
                {
                mFILTER(); if (state.failed) return ;


                }
                break;
            case 9 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:63: FOREACH
                {
                mFOREACH(); if (state.failed) return ;


                }
                break;
            case 10 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:71: ORDER
                {
                mORDER(); if (state.failed) return ;


                }
                break;
            case 11 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:77: RANK
                {
                mRANK(); if (state.failed) return ;


                }
                break;
            case 12 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:82: DENSE
                {
                mDENSE(); if (state.failed) return ;


                }
                break;
            case 13 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:88: CUBE
                {
                mCUBE(); if (state.failed) return ;


                }
                break;
            case 14 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:93: ROLLUP
                {
                mROLLUP(); if (state.failed) return ;


                }
                break;
            case 15 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:100: INVOKE
                {
                mINVOKE(); if (state.failed) return ;


                }
                break;
            case 16 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:107: DISTINCT
                {
                mDISTINCT(); if (state.failed) return ;


                }
                break;
            case 17 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:116: COGROUP
                {
                mCOGROUP(); if (state.failed) return ;


                }
                break;
            case 18 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:124: JOIN
                {
                mJOIN(); if (state.failed) return ;


                }
                break;
            case 19 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:129: CROSS
                {
                mCROSS(); if (state.failed) return ;


                }
                break;
            case 20 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:135: UNION
                {
                mUNION(); if (state.failed) return ;


                }
                break;
            case 21 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:141: SPLIT
                {
                mSPLIT(); if (state.failed) return ;


                }
                break;
            case 22 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:147: INTO
                {
                mINTO(); if (state.failed) return ;


                }
                break;
            case 23 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:152: IF
                {
                mIF(); if (state.failed) return ;


                }
                break;
            case 24 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:155: OTHERWISE
                {
                mOTHERWISE(); if (state.failed) return ;


                }
                break;
            case 25 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:165: ALL
                {
                mALL(); if (state.failed) return ;


                }
                break;
            case 26 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:169: AS
                {
                mAS(); if (state.failed) return ;


                }
                break;
            case 27 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:172: BY
                {
                mBY(); if (state.failed) return ;


                }
                break;
            case 28 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:175: USING
                {
                mUSING(); if (state.failed) return ;


                }
                break;
            case 29 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:181: INNER
                {
                mINNER(); if (state.failed) return ;


                }
                break;
            case 30 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:187: OUTER
                {
                mOUTER(); if (state.failed) return ;


                }
                break;
            case 31 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:193: ONSCHEMA
                {
                mONSCHEMA(); if (state.failed) return ;


                }
                break;
            case 32 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:202: PARALLEL
                {
                mPARALLEL(); if (state.failed) return ;


                }
                break;
            case 33 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:211: PARTITION
                {
                mPARTITION(); if (state.failed) return ;


                }
                break;
            case 34 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:221: GROUP
                {
                mGROUP(); if (state.failed) return ;


                }
                break;
            case 35 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:227: AND
                {
                mAND(); if (state.failed) return ;


                }
                break;
            case 36 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:231: OR
                {
                mOR(); if (state.failed) return ;


                }
                break;
            case 37 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:234: NOT
                {
                mNOT(); if (state.failed) return ;


                }
                break;
            case 38 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:238: GENERATE
                {
                mGENERATE(); if (state.failed) return ;


                }
                break;
            case 39 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:247: FLATTEN
                {
                mFLATTEN(); if (state.failed) return ;


                }
                break;
            case 40 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:255: ASC
                {
                mASC(); if (state.failed) return ;


                }
                break;
            case 41 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:259: DESC
                {
                mDESC(); if (state.failed) return ;


                }
                break;
            case 42 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:264: BOOLEAN
                {
                mBOOLEAN(); if (state.failed) return ;


                }
                break;
            case 43 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:272: INT
                {
                mINT(); if (state.failed) return ;


                }
                break;
            case 44 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:276: LONG
                {
                mLONG(); if (state.failed) return ;


                }
                break;
            case 45 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:281: FLOAT
                {
                mFLOAT(); if (state.failed) return ;


                }
                break;
            case 46 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:287: BIGDECIMAL
                {
                mBIGDECIMAL(); if (state.failed) return ;


                }
                break;
            case 47 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:298: BIGINTEGER
                {
                mBIGINTEGER(); if (state.failed) return ;


                }
                break;
            case 48 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:309: DOUBLE
                {
                mDOUBLE(); if (state.failed) return ;


                }
                break;
            case 49 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:316: DATETIME
                {
                mDATETIME(); if (state.failed) return ;


                }
                break;
            case 50 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:325: CHARARRAY
                {
                mCHARARRAY(); if (state.failed) return ;


                }
                break;
            case 51 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:335: BYTEARRAY
                {
                mBYTEARRAY(); if (state.failed) return ;


                }
                break;
            case 52 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:345: BAG
                {
                mBAG(); if (state.failed) return ;


                }
                break;
            case 53 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:349: TUPLE
                {
                mTUPLE(); if (state.failed) return ;


                }
                break;
            case 54 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:355: MAP
                {
                mMAP(); if (state.failed) return ;


                }
                break;
            case 55 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:359: IS
                {
                mIS(); if (state.failed) return ;


                }
                break;
            case 56 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:362: STREAM
                {
                mSTREAM(); if (state.failed) return ;


                }
                break;
            case 57 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:369: THROUGH
                {
                mTHROUGH(); if (state.failed) return ;


                }
                break;
            case 58 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:377: STORE
                {
                mSTORE(); if (state.failed) return ;


                }
                break;
            case 59 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:383: ASSERT
                {
                mASSERT(); if (state.failed) return ;


                }
                break;
            case 60 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:390: MAPREDUCE
                {
                mMAPREDUCE(); if (state.failed) return ;


                }
                break;
            case 61 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:400: SHIP
                {
                mSHIP(); if (state.failed) return ;


                }
                break;
            case 62 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:405: CACHE
                {
                mCACHE(); if (state.failed) return ;


                }
                break;
            case 63 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:411: INPUT
                {
                mINPUT(); if (state.failed) return ;


                }
                break;
            case 64 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:417: OUTPUT
                {
                mOUTPUT(); if (state.failed) return ;


                }
                break;
            case 65 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:424: STDERROR
                {
                mSTDERROR(); if (state.failed) return ;


                }
                break;
            case 66 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:433: STDIN
                {
                mSTDIN(); if (state.failed) return ;


                }
                break;
            case 67 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:439: STDOUT
                {
                mSTDOUT(); if (state.failed) return ;


                }
                break;
            case 68 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:446: LIMIT
                {
                mLIMIT(); if (state.failed) return ;


                }
                break;
            case 69 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:452: SAMPLE
                {
                mSAMPLE(); if (state.failed) return ;


                }
                break;
            case 70 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:459: LEFT
                {
                mLEFT(); if (state.failed) return ;


                }
                break;
            case 71 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:464: RIGHT
                {
                mRIGHT(); if (state.failed) return ;


                }
                break;
            case 72 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:470: FULL
                {
                mFULL(); if (state.failed) return ;


                }
                break;
            case 73 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:475: CASE
                {
                mCASE(); if (state.failed) return ;


                }
                break;
            case 74 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:480: WHEN
                {
                mWHEN(); if (state.failed) return ;


                }
                break;
            case 75 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:485: THEN
                {
                mTHEN(); if (state.failed) return ;


                }
                break;
            case 76 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:490: ELSE
                {
                mELSE(); if (state.failed) return ;


                }
                break;
            case 77 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:495: END
                {
                mEND(); if (state.failed) return ;


                }
                break;
            case 78 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:499: STR_OP_EQ
                {
                mSTR_OP_EQ(); if (state.failed) return ;


                }
                break;
            case 79 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:509: STR_OP_GT
                {
                mSTR_OP_GT(); if (state.failed) return ;


                }
                break;
            case 80 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:519: STR_OP_LT
                {
                mSTR_OP_LT(); if (state.failed) return ;


                }
                break;
            case 81 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:529: STR_OP_GTE
                {
                mSTR_OP_GTE(); if (state.failed) return ;


                }
                break;
            case 82 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:540: STR_OP_LTE
                {
                mSTR_OP_LTE(); if (state.failed) return ;


                }
                break;
            case 83 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:551: STR_OP_NE
                {
                mSTR_OP_NE(); if (state.failed) return ;


                }
                break;
            case 84 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:561: STR_OP_MATCHES
                {
                mSTR_OP_MATCHES(); if (state.failed) return ;


                }
                break;
            case 85 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:576: IN
                {
                mIN(); if (state.failed) return ;


                }
                break;
            case 86 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:579: TRUE
                {
                mTRUE(); if (state.failed) return ;


                }
                break;
            case 87 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:584: FALSE
                {
                mFALSE(); if (state.failed) return ;


                }
                break;
            case 88 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:590: NUM_OP_EQ
                {
                mNUM_OP_EQ(); if (state.failed) return ;


                }
                break;
            case 89 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:600: NUM_OP_LT
                {
                mNUM_OP_LT(); if (state.failed) return ;


                }
                break;
            case 90 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:610: NUM_OP_LTE
                {
                mNUM_OP_LTE(); if (state.failed) return ;


                }
                break;
            case 91 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:621: NUM_OP_GT
                {
                mNUM_OP_GT(); if (state.failed) return ;


                }
                break;
            case 92 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:631: NUM_OP_GTE
                {
                mNUM_OP_GTE(); if (state.failed) return ;


                }
                break;
            case 93 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:642: NUM_OP_NE
                {
                mNUM_OP_NE(); if (state.failed) return ;


                }
                break;
            case 94 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:652: DCOLON
                {
                mDCOLON(); if (state.failed) return ;


                }
                break;
            case 95 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:659: IDENTIFIER
                {
                mIDENTIFIER(); if (state.failed) return ;


                }
                break;
            case 96 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:670: INTEGER
                {
                mINTEGER(); if (state.failed) return ;


                }
                break;
            case 97 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:678: LONGINTEGER
                {
                mLONGINTEGER(); if (state.failed) return ;


                }
                break;
            case 98 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:690: DOLLARVAR
                {
                mDOLLARVAR(); if (state.failed) return ;


                }
                break;
            case 99 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:700: DOUBLENUMBER
                {
                mDOUBLENUMBER(); if (state.failed) return ;


                }
                break;
            case 100 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:713: BIGDECIMALNUMBER
                {
                mBIGDECIMALNUMBER(); if (state.failed) return ;


                }
                break;
            case 101 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:730: BIGINTEGERNUMBER
                {
                mBIGINTEGERNUMBER(); if (state.failed) return ;


                }
                break;
            case 102 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:747: FLOATNUMBER
                {
                mFLOATNUMBER(); if (state.failed) return ;


                }
                break;
            case 103 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:759: QUOTEDSTRING
                {
                mQUOTEDSTRING(); if (state.failed) return ;


                }
                break;
            case 104 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:772: MULTILINE_QUOTEDSTRING
                {
                mMULTILINE_QUOTEDSTRING(); if (state.failed) return ;


                }
                break;
            case 105 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:795: EXECCOMMAND
                {
                mEXECCOMMAND(); if (state.failed) return ;


                }
                break;
            case 106 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:807: STAR
                {
                mSTAR(); if (state.failed) return ;


                }
                break;
            case 107 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:812: COLON
                {
                mCOLON(); if (state.failed) return ;


                }
                break;
            case 108 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:818: DOLLAR
                {
                mDOLLAR(); if (state.failed) return ;


                }
                break;
            case 109 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:825: WS
                {
                mWS(); if (state.failed) return ;


                }
                break;
            case 110 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:828: SL_COMMENT
                {
                mSL_COMMENT(); if (state.failed) return ;


                }
                break;
            case 111 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:839: ML_COMMENT
                {
                mML_COMMENT(); if (state.failed) return ;


                }
                break;
            case 112 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:850: SEMI_COLON
                {
                mSEMI_COLON(); if (state.failed) return ;


                }
                break;
            case 113 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:861: LEFT_PAREN
                {
                mLEFT_PAREN(); if (state.failed) return ;


                }
                break;
            case 114 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:872: RIGHT_PAREN
                {
                mRIGHT_PAREN(); if (state.failed) return ;


                }
                break;
            case 115 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:884: LEFT_CURLY
                {
                mLEFT_CURLY(); if (state.failed) return ;


                }
                break;
            case 116 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:895: RIGHT_CURLY
                {
                mRIGHT_CURLY(); if (state.failed) return ;


                }
                break;
            case 117 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:907: LEFT_BRACKET
                {
                mLEFT_BRACKET(); if (state.failed) return ;


                }
                break;
            case 118 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:920: RIGHT_BRACKET
                {
                mRIGHT_BRACKET(); if (state.failed) return ;


                }
                break;
            case 119 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:934: POUND
                {
                mPOUND(); if (state.failed) return ;


                }
                break;
            case 120 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:940: EQUAL
                {
                mEQUAL(); if (state.failed) return ;


                }
                break;
            case 121 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:946: COMMA
                {
                mCOMMA(); if (state.failed) return ;


                }
                break;
            case 122 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:952: PERIOD
                {
                mPERIOD(); if (state.failed) return ;


                }
                break;
            case 123 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:959: DOUBLE_PERIOD
                {
                mDOUBLE_PERIOD(); if (state.failed) return ;


                }
                break;
            case 124 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:973: DIV
                {
                mDIV(); if (state.failed) return ;


                }
                break;
            case 125 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:977: PERCENT
                {
                mPERCENT(); if (state.failed) return ;


                }
                break;
            case 126 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:985: PLUS
                {
                mPLUS(); if (state.failed) return ;


                }
                break;
            case 127 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:990: MINUS
                {
                mMINUS(); if (state.failed) return ;


                }
                break;
            case 128 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:996: QMARK
                {
                mQMARK(); if (state.failed) return ;


                }
                break;
            case 129 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:1002: ARROBA
                {
                mARROBA(); if (state.failed) return ;


                }
                break;
            case 130 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:1009: AMPERSAND
                {
                mAMPERSAND(); if (state.failed) return ;


                }
                break;
            case 131 :
                // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:1:1019: FAT_ARROW
                {
                mFAT_ARROW(); if (state.failed) return ;


                }
                break;

        }

    }

    // $ANTLR start synpred1_QueryLexer
    public final void synpred1_QueryLexer_fragment() throws RecognitionException {
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:359:9: ( ID DCOLON )
        // /home/hoang/DATA/pig-0.12.1/src/org/apache/pig/parser/QueryLexer.g:359:11: ID DCOLON
        {
        mID(); if (state.failed) return ;


        mDCOLON(); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred1_QueryLexer

    public final boolean synpred1_QueryLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_QueryLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA2_eotS =
        "\1\uffff\1\2\1\uffff\1\2\1\uffff";
    static final String DFA2_eofS =
        "\5\uffff";
    static final String DFA2_minS =
        "\1\101\1\60\1\uffff\1\60\1\uffff";
    static final String DFA2_maxS =
        "\1\132\1\137\1\uffff\1\137\1\uffff";
    static final String DFA2_acceptS =
        "\2\uffff\1\2\1\uffff\1\1";
    static final String DFA2_specialS =
        "\1\uffff\1\0\1\uffff\1\1\1\uffff}>";
    static final String[] DFA2_transitionS = {
            "\32\1",
            "\12\3\1\4\6\uffff\32\3\4\uffff\1\3",
            "",
            "\12\3\1\4\6\uffff\32\3\4\uffff\1\3",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "354:1: IDENTIFIER : ( ( ID DCOLON )=> ( ID DCOLON IDENTIFIER ) | ID );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA2_1 = input.LA(1);

                         
                        int index2_1 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA2_1 >= '0' && LA2_1 <= '9')||(LA2_1 >= 'A' && LA2_1 <= 'Z')||LA2_1=='_') ) {s = 3;}

                        else if ( (LA2_1==':') && (synpred1_QueryLexer())) {s = 4;}

                        else s = 2;

                         
                        input.seek(index2_1);

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA2_3 = input.LA(1);

                         
                        int index2_3 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA2_3==':') && (synpred1_QueryLexer())) {s = 4;}

                        else if ( ((LA2_3 >= '0' && LA2_3 <= '9')||(LA2_3 >= 'A' && LA2_3 <= 'Z')||LA2_3=='_') ) {s = 3;}

                        else s = 2;

                         
                        input.seek(index2_3);

                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}

            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 2, _s, input);
            error(nvae);
            throw nvae;
        }

    }
    static final String DFA13_eotS =
        "\1\uffff\24\32\1\160\1\162\1\164\1\uffff\1\166\1\uffff\1\167\1\175"+
        "\1\u0080\4\uffff\1\u0087\1\u0089\16\uffff\5\32\1\u0093\1\u0094\1"+
        "\u0095\13\32\1\u00a6\5\32\1\u00ae\20\32\1\u00c4\1\32\1\u00c7\6\32"+
        "\1\u00cf\7\32\1\u00d9\23\uffff\1\u00df\10\uffff\2\32\1\u00e5\1\u00e6"+
        "\2\32\1\u00ea\2\32\3\uffff\17\32\1\u00fc\1\uffff\7\32\1\uffff\22"+
        "\32\1\u0119\1\u011a\1\32\1\uffff\1\u011c\1\32\1\uffff\2\32\1\u0121"+
        "\3\32\1\u0126\1\uffff\4\32\1\u012c\3\32\1\u0130\1\uffff\1\u00df"+
        "\1\uffff\1\u00df\6\uffff\1\u0132\1\u0133\2\uffff\2\32\1\u0136\1"+
        "\uffff\4\32\1\u013b\4\32\1\u0140\3\32\1\u0144\1\u0145\1\32\1\u0147"+
        "\1\uffff\4\32\1\u014c\6\32\1\u0153\4\32\1\u0158\1\u0159\10\32\1"+
        "\u0162\1\32\2\uffff\1\32\1\uffff\4\32\1\uffff\4\32\1\uffff\2\32"+
        "\1\u016f\1\u0170\1\32\1\uffff\1\32\1\u0173\1\u0174\4\uffff\2\32"+
        "\1\uffff\1\u0178\1\u0179\2\32\1\uffff\1\32\1\u017d\1\32\1\u017f"+
        "\1\uffff\3\32\2\uffff\1\u0183\1\uffff\3\32\1\u0187\1\uffff\1\u0188"+
        "\1\u0189\1\32\1\u018b\2\32\1\uffff\1\32\1\u018f\1\32\1\u0191\2\uffff"+
        "\1\u0192\1\u0193\1\u0194\1\32\1\u0196\1\32\1\u0198\1\32\1\uffff"+
        "\10\32\1\u01a2\1\32\1\u01a4\1\32\2\uffff\2\32\3\uffff\1\u01a9\1"+
        "\u01aa\2\uffff\2\32\1\u01ad\1\uffff\1\u01ae\1\uffff\1\32\1\u01b0"+
        "\1\32\1\uffff\1\u01b2\2\32\3\uffff\1\32\1\uffff\1\u01b6\2\32\1\uffff"+
        "\1\32\4\uffff\1\u01ba\1\uffff\1\u01bb\1\uffff\1\u01bc\1\u01bd\1"+
        "\u01be\6\32\1\uffff\1\32\1\uffff\3\32\3\uffff\1\32\1\u01cb\2\uffff"+
        "\1\32\1\uffff\1\32\1\uffff\1\u01ce\1\u01cf\1\32\1\uffff\1\32\1\u01d2"+
        "\1\32\5\uffff\1\32\1\u01d5\5\32\1\u01db\1\32\1\u01dd\1\uffff\1\u01de"+
        "\1\uffff\1\u01df\1\u01e0\2\uffff\1\32\1\u01e2\1\uffff\2\32\1\uffff"+
        "\2\32\1\u01e7\1\32\1\u01e9\1\uffff\1\32\4\uffff\1\u01eb\1\uffff"+
        "\1\u01ec\1\u01ed\2\32\1\uffff\1\u01f0\1\uffff\1\u01f1\3\uffff\1"+
        "\u01f2\1\u01f3\4\uffff";
    static final String DFA13_eofS =
        "\u01f4\uffff";
    static final String DFA13_minS =
        "\1\11\1\117\1\105\1\106\2\101\1\105\1\101\1\116\1\101\1\117\1\116"+
        "\1\101\1\114\2\101\1\105\1\110\1\101\1\110\1\114\3\75\1\uffff\1"+
        "\72\1\uffff\1\56\1\60\1\56\1\0\3\uffff\1\55\1\52\16\uffff\1\111"+
        "\1\114\1\124\1\121\1\120\3\60\1\107\1\116\1\114\1\107\1\106\1\123"+
        "\1\125\1\124\1\101\1\115\1\106\1\60\1\114\1\122\1\101\2\114\1\60"+
        "\1\110\1\124\1\123\1\102\1\107\1\117\1\101\1\103\3\111\1\114\1\104"+
        "\1\111\1\115\1\114\1\60\1\104\1\60\1\117\2\107\1\122\1\117\1\116"+
        "\1\60\1\120\1\105\1\125\1\120\1\105\1\123\1\104\1\60\13\uffff\1"+
        "\60\1\53\1\104\5\uffff\1\60\1\0\1\47\6\uffff\1\104\1\114\2\60\2"+
        "\117\1\60\1\105\1\125\3\uffff\1\111\1\125\1\113\1\114\1\110\1\111"+
        "\1\123\1\103\1\124\1\102\1\105\1\104\1\107\1\111\1\124\1\60\1\uffff"+
        "\1\124\1\105\1\124\1\101\1\114\1\123\1\105\1\uffff\2\105\1\103\1"+
        "\105\1\122\1\123\1\122\1\110\1\105\1\116\1\117\1\116\1\111\1\105"+
        "\1\122\1\105\2\120\2\60\1\105\1\uffff\1\60\1\105\1\uffff\1\114\1"+
        "\104\1\60\1\101\1\125\1\105\1\60\1\uffff\1\114\1\117\1\116\1\105"+
        "\1\60\1\103\1\116\1\105\1\60\1\uffff\3\60\3\uffff\1\0\1\60\1\uffff"+
        "\2\60\2\uffff\1\122\1\113\1\60\1\uffff\1\122\1\124\1\123\1\122\1"+
        "\60\1\125\1\124\1\116\1\105\1\60\1\111\1\114\1\124\2\60\1\124\1"+
        "\60\1\uffff\1\105\1\101\2\124\1\60\1\105\3\122\1\125\1\110\1\60"+
        "\1\117\1\123\1\101\1\105\2\60\1\116\1\107\1\124\1\101\1\105\1\122"+
        "\1\116\1\125\1\60\1\114\2\uffff\1\122\1\uffff\1\101\2\105\1\116"+
        "\1\uffff\1\114\1\111\1\120\1\122\1\uffff\1\105\1\125\2\60\1\105"+
        "\1\uffff\1\110\2\60\1\uffff\1\60\2\uffff\1\124\1\105\1\uffff\2\60"+
        "\1\124\1\116\1\uffff\1\120\1\60\1\105\1\60\1\uffff\1\116\1\105\1"+
        "\111\2\uffff\1\60\1\uffff\1\122\1\103\1\105\1\60\1\uffff\2\60\1"+
        "\127\1\60\1\124\1\105\1\uffff\1\125\1\60\1\122\1\60\2\uffff\3\60"+
        "\1\115\1\60\1\122\1\60\1\124\1\uffff\1\105\1\124\1\122\1\101\1\103"+
        "\1\124\1\114\1\124\1\60\1\101\1\60\1\107\2\uffff\1\104\1\105\2\uffff"+
        "\3\60\2\uffff\1\105\1\123\1\60\1\uffff\1\60\1\uffff\1\103\1\60\1"+
        "\115\1\uffff\1\60\1\110\1\116\3\uffff\1\111\1\uffff\1\60\1\115\1"+
        "\120\1\uffff\1\122\4\uffff\1\60\1\uffff\1\60\1\uffff\3\60\1\122"+
        "\1\116\1\111\2\105\1\111\1\uffff\1\124\1\uffff\1\110\1\125\1\123"+
        "\1\60\2\uffff\1\122\1\60\2\uffff\1\124\1\uffff\1\105\1\uffff\2\60"+
        "\1\123\1\uffff\1\101\1\60\1\101\5\uffff\1\101\1\60\1\115\1\107\1"+
        "\114\1\117\1\105\1\60\1\103\1\60\1\0\1\60\1\uffff\2\60\2\uffff\1"+
        "\105\1\60\1\uffff\2\131\1\uffff\1\101\1\105\1\60\1\116\1\60\1\uffff"+
        "\1\105\4\uffff\1\60\1\uffff\2\60\1\114\1\122\1\uffff\1\60\1\uffff"+
        "\1\60\3\uffff\2\60\4\uffff";
    static final String DFA13_maxS =
        "\1\175\1\117\1\125\1\123\2\117\1\124\3\125\1\117\1\123\1\124\1\123"+
        "\1\131\1\101\1\124\1\125\1\101\1\110\1\121\1\76\2\75\1\uffff\1\72"+
        "\1\uffff\1\114\2\71\1\uffff\3\uffff\1\55\1\52\16\uffff\1\111\1\114"+
        "\1\124\1\121\1\120\3\137\1\124\1\116\1\114\1\107\2\123\1\125\1\124"+
        "\1\116\1\115\1\106\1\137\1\114\1\122\1\117\2\114\1\137\1\110\1\124"+
        "\1\123\1\102\1\107\1\117\1\101\1\123\3\111\1\114\1\122\1\111\1\115"+
        "\1\114\1\137\1\104\1\137\1\117\2\107\1\122\1\117\1\116\1\137\1\120"+
        "\1\122\1\125\1\124\1\105\1\123\1\104\1\137\13\uffff\2\71\1\111\5"+
        "\uffff\1\106\1\uffff\1\162\6\uffff\1\104\1\114\2\137\2\117\1\137"+
        "\1\105\1\125\3\uffff\1\111\1\125\1\113\1\114\1\110\1\111\1\123\1"+
        "\103\1\124\1\102\1\105\1\104\1\107\1\111\1\124\1\137\1\uffff\1\124"+
        "\1\105\1\124\1\101\1\114\1\123\1\105\1\uffff\1\105\1\120\1\103\1"+
        "\105\1\122\1\123\1\122\1\110\1\105\1\116\1\117\1\116\1\111\1\105"+
        "\1\122\1\117\2\120\2\137\1\105\1\uffff\1\137\1\105\1\uffff\1\114"+
        "\1\111\1\137\1\124\1\125\1\105\1\137\1\uffff\1\114\1\117\1\116\1"+
        "\105\1\137\1\103\1\116\1\105\1\137\1\uffff\1\106\1\71\1\106\3\uffff"+
        "\1\uffff\1\106\1\uffff\2\137\2\uffff\1\122\1\113\1\137\1\uffff\1"+
        "\122\1\124\1\123\1\122\1\137\1\125\1\124\1\116\1\105\1\137\1\111"+
        "\1\114\1\124\2\137\1\124\1\137\1\uffff\1\105\1\101\2\124\1\137\1"+
        "\105\3\122\1\125\1\110\1\137\1\117\1\123\1\101\1\105\2\137\1\116"+
        "\1\107\1\124\1\101\1\105\1\122\1\116\1\125\1\137\1\114\2\uffff\1"+
        "\122\1\uffff\1\101\2\105\1\116\1\uffff\1\114\1\111\1\120\1\122\1"+
        "\uffff\1\105\1\125\2\137\1\105\1\uffff\1\110\2\137\1\uffff\1\106"+
        "\2\uffff\1\124\1\105\1\uffff\2\137\1\124\1\116\1\uffff\1\120\1\137"+
        "\1\105\1\137\1\uffff\1\116\1\105\1\111\2\uffff\1\137\1\uffff\1\122"+
        "\1\103\1\105\1\137\1\uffff\2\137\1\127\1\137\1\124\1\105\1\uffff"+
        "\1\125\1\137\1\122\1\137\2\uffff\3\137\1\115\1\137\1\122\1\137\1"+
        "\124\1\uffff\1\105\1\124\1\122\1\101\1\103\1\124\1\114\1\124\1\137"+
        "\1\101\1\137\1\107\2\uffff\1\104\1\105\2\uffff\1\106\2\137\2\uffff"+
        "\1\105\1\123\1\137\1\uffff\1\137\1\uffff\1\103\1\137\1\115\1\uffff"+
        "\1\137\1\110\1\116\3\uffff\1\111\1\uffff\1\137\1\115\1\120\1\uffff"+
        "\1\122\4\uffff\1\137\1\uffff\1\137\1\uffff\3\137\1\122\1\116\1\111"+
        "\2\105\1\111\1\uffff\1\124\1\uffff\1\110\1\125\1\123\1\106\2\uffff"+
        "\1\122\1\137\2\uffff\1\124\1\uffff\1\105\1\uffff\2\137\1\123\1\uffff"+
        "\1\101\1\137\1\101\5\uffff\1\101\1\137\1\115\1\107\1\114\1\117\1"+
        "\105\1\137\1\103\1\137\1\uffff\1\137\1\uffff\2\137\2\uffff\1\105"+
        "\1\137\1\uffff\2\131\1\uffff\1\101\1\105\1\137\1\116\1\137\1\uffff"+
        "\1\105\4\uffff\1\137\1\uffff\2\137\1\114\1\122\1\uffff\1\137\1\uffff"+
        "\1\137\3\uffff\2\137\4\uffff";
    static final String DFA13_acceptS =
        "\30\uffff\1\135\1\uffff\1\137\4\uffff\1\151\1\152\1\155\2\uffff"+
        "\1\160\1\161\1\162\1\163\1\164\1\165\1\166\1\167\1\171\1\175\1\176"+
        "\1\u0080\1\u0081\1\u0082\74\uffff\1\130\1\u0083\1\170\1\132\1\131"+
        "\1\134\1\133\1\136\1\153\1\140\1\141\3\uffff\1\146\1\154\1\142\1"+
        "\173\1\172\3\uffff\1\147\1\150\1\156\1\177\1\157\1\174\11\uffff"+
        "\1\125\1\27\1\67\20\uffff\1\120\7\uffff\1\44\25\uffff\1\32\2\uffff"+
        "\1\33\7\uffff\1\117\11\uffff\1\116\3\uffff\1\144\1\145\1\143\2\uffff"+
        "\1\147\2\uffff\1\45\1\123\3\uffff\1\53\21\uffff\1\122\34\uffff\1"+
        "\31\1\50\1\uffff\1\43\4\uffff\1\64\4\uffff\1\121\5\uffff\1\66\3"+
        "\uffff\1\115\1\uffff\1\1\1\2\2\uffff\1\26\4\uffff\1\13\4\uffff\1"+
        "\51\3\uffff\1\7\1\54\1\uffff\1\106\4\uffff\1\110\6\uffff\1\15\4"+
        "\uffff\1\111\1\22\10\uffff\1\75\14\uffff\1\113\1\126\2\uffff\1\112"+
        "\1\114\3\uffff\1\35\1\77\3\uffff\1\107\1\uffff\1\14\3\uffff\1\104"+
        "\3\uffff\1\55\1\127\1\12\1\uffff\1\36\3\uffff\1\23\1\uffff\1\76"+
        "\1\24\1\34\1\25\1\uffff\1\72\1\uffff\1\102\11\uffff\1\42\1\uffff"+
        "\1\65\4\uffff\1\3\1\17\2\uffff\1\16\1\6\1\uffff\1\60\1\uffff\1\10"+
        "\3\uffff\1\100\3\uffff\1\70\1\101\1\103\1\105\1\73\14\uffff\1\5"+
        "\2\uffff\1\11\1\47\2\uffff\1\21\2\uffff\1\52\5\uffff\1\71\1\uffff"+
        "\1\124\1\4\1\20\1\61\1\uffff\1\37\4\uffff\1\40\1\uffff\1\46\1\uffff"+
        "\1\30\1\62\1\63\2\uffff\1\41\1\74\1\56\1\57";
    static final String DFA13_specialS =
        "\36\uffff\1\3\143\uffff\1\2\135\uffff\1\1\u00e8\uffff\1\0\52\uffff}>";
    static final String[] DFA13_transitionS = {
            "\2\41\1\uffff\2\41\22\uffff\1\41\1\30\1\uffff\1\53\1\34\1\55"+
            "\1\61\1\36\1\45\1\46\1\40\1\56\1\54\1\42\1\35\1\43\12\33\1\31"+
            "\1\44\1\26\1\25\1\27\1\57\1\60\1\15\1\16\1\11\1\5\1\24\1\7\1"+
            "\20\1\32\1\3\1\12\1\32\1\6\1\22\1\2\1\10\1\17\1\32\1\4\1\14"+
            "\1\21\1\13\1\1\1\23\3\32\1\51\1\uffff\1\52\2\uffff\1\37\32\uffff"+
            "\1\47\1\uffff\1\50",
            "\1\62",
            "\1\65\11\uffff\1\64\5\uffff\1\63",
            "\1\70\6\uffff\1\66\1\67\4\uffff\1\71",
            "\1\73\3\uffff\1\72\3\uffff\1\75\5\uffff\1\74",
            "\1\101\3\uffff\1\76\3\uffff\1\77\5\uffff\1\100",
            "\1\104\3\uffff\1\103\5\uffff\1\102\4\uffff\1\105",
            "\1\112\7\uffff\1\106\2\uffff\1\110\2\uffff\1\107\5\uffff\1"+
            "\111",
            "\1\116\3\uffff\1\113\1\uffff\1\114\1\115",
            "\1\123\6\uffff\1\122\6\uffff\1\120\2\uffff\1\121\2\uffff\1"+
            "\117",
            "\1\124",
            "\1\125\4\uffff\1\126",
            "\1\132\6\uffff\1\131\7\uffff\1\127\3\uffff\1\130",
            "\1\133\1\uffff\1\135\4\uffff\1\134",
            "\1\141\7\uffff\1\140\5\uffff\1\137\11\uffff\1\136",
            "\1\142",
            "\1\144\14\uffff\1\143\1\uffff\1\145",
            "\1\147\11\uffff\1\150\2\uffff\1\146",
            "\1\151",
            "\1\152",
            "\1\153\1\uffff\1\154\2\uffff\1\155",
            "\1\156\1\157",
            "\1\161",
            "\1\163",
            "",
            "\1\165",
            "",
            "\1\171\1\uffff\12\33\10\uffff\1\173\2\uffff\1\172\1\174\5\uffff"+
            "\1\170",
            "\12\176",
            "\1\177\1\uffff\12\u0081",
            "\12\u0082\1\u0085\2\u0082\1\u0085\31\u0082\1\u0084\64\u0082"+
            "\1\u0083\uffa3\u0082",
            "",
            "",
            "",
            "\1\u0086",
            "\1\u0088",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\13\32\6\uffff\15\32\1\u0091\1\32\1\u0092\3\32\1\u0090\1\32"+
            "\1\u008f\4\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u0096\14\uffff\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b\7\uffff\1\u009c\4\uffff\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1\14\uffff\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\13\32\6\uffff\4\32\1\u00a5\25\32\4\uffff\1\32",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9\15\uffff\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\13\32\6\uffff\3\32\1\u00ad\26\32\4\uffff\1\32",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6\17\uffff\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00be\12\uffff\1\u00bd\2\uffff\1\u00bc",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\13\32\6\uffff\2\32\1\u00c2\17\32\1\u00c3\7\32\4\uffff\1\32",
            "\1\u00c5",
            "\13\32\6\uffff\23\32\1\u00c6\6\32\4\uffff\1\32",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "\13\32\6\uffff\4\32\1\u00ce\25\32\4\uffff\1\32",
            "\1\u00d0",
            "\1\u00d2\14\uffff\1\u00d1",
            "\1\u00d3",
            "\1\u00d4\3\uffff\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\u00da",
            "\1\u00db\1\uffff\1\u00db\2\uffff\12\u00dc",
            "\1\u00dd\4\uffff\1\u00de",
            "",
            "",
            "",
            "",
            "",
            "\12\u0081\10\uffff\1\u00dd\2\uffff\1\172\1\174",
            "\12\u0082\1\u0085\2\u0082\1\u0085\31\u0082\1\u0084\64\u0082"+
            "\1\u0083\uffa3\u0082",
            "\1\u00e0\32\uffff\1\u00e0\3\uffff\1\u00e0\7\uffff\1\u00e0\3"+
            "\uffff\1\u00e0\1\uffff\1\u00e0\1\u00e1\6\uffff\1\u00e0\21\uffff"+
            "\1\u0085\3\uffff\1\u0085",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00e3",
            "\1\u00e4",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u00e7",
            "\1\u00e8",
            "\13\32\6\uffff\16\32\1\u00e9\13\32\4\uffff\1\32",
            "\1\u00eb",
            "\1\u00ec",
            "",
            "",
            "",
            "\1\u00ed",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "\1\u00f8",
            "\1\u00f9",
            "\1\u00fa",
            "\1\u00fb",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\1\u00fd",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "\1\u0102",
            "\1\u0103",
            "",
            "\1\u0104",
            "\1\u0105\12\uffff\1\u0106",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109",
            "\1\u010a",
            "\1\u010b",
            "\1\u010c",
            "\1\u010d",
            "\1\u010e",
            "\1\u010f",
            "\1\u0110",
            "\1\u0111",
            "\1\u0112",
            "\1\u0113",
            "\1\u0114\3\uffff\1\u0115\5\uffff\1\u0116",
            "\1\u0117",
            "\1\u0118",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u011b",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u011d",
            "",
            "\1\u011e",
            "\1\u011f\4\uffff\1\u0120",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u0122\22\uffff\1\u0123",
            "\1\u0124",
            "\1\u0125",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\1\u0127",
            "\1\u0128",
            "\1\u0129",
            "\1\u012a",
            "\13\32\6\uffff\21\32\1\u012b\10\32\4\uffff\1\32",
            "\1\u012d",
            "\1\u012e",
            "\1\u012f",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\12\u00da\10\uffff\1\u00dd\2\uffff\1\172\1\174",
            "\12\u00dc",
            "\12\u00dc\10\uffff\1\u00dd\3\uffff\1\174",
            "",
            "",
            "",
            "\12\u0082\1\u0085\2\u0082\1\u0085\31\u0082\1\u0084\64\u0082"+
            "\1\u0083\uffa3\u0082",
            "\12\u0131\7\uffff\6\u0131",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "",
            "\1\u0134",
            "\1\u0135",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\1\u0137",
            "\1\u0138",
            "\1\u0139",
            "\1\u013a",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u013c",
            "\1\u013d",
            "\1\u013e",
            "\1\u013f",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u0141",
            "\1\u0142",
            "\1\u0143",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u0146",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\1\u0148",
            "\1\u0149",
            "\1\u014a",
            "\1\u014b",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u014d",
            "\1\u014e",
            "\1\u014f",
            "\1\u0150",
            "\1\u0151",
            "\1\u0152",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u0154",
            "\1\u0155",
            "\1\u0156",
            "\1\u0157",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u015a",
            "\1\u015b",
            "\1\u015c",
            "\1\u015d",
            "\1\u015e",
            "\1\u015f",
            "\1\u0160",
            "\1\u0161",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u0163",
            "",
            "",
            "\1\u0164",
            "",
            "\1\u0165",
            "\1\u0166",
            "\1\u0167",
            "\1\u0168",
            "",
            "\1\u0169",
            "\1\u016a",
            "\1\u016b",
            "\1\u016c",
            "",
            "\1\u016d",
            "\1\u016e",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u0171",
            "",
            "\1\u0172",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\12\u0175\7\uffff\6\u0175",
            "",
            "",
            "\1\u0176",
            "\1\u0177",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u017a",
            "\1\u017b",
            "",
            "\1\u017c",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u017e",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\1\u0180",
            "\1\u0181",
            "\1\u0182",
            "",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\1\u0184",
            "\1\u0185",
            "\1\u0186",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u018a",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u018c",
            "\1\u018d",
            "",
            "\1\u018e",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u0190",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u0195",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u0197",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u0199",
            "",
            "\1\u019a",
            "\1\u019b",
            "\1\u019c",
            "\1\u019d",
            "\1\u019e",
            "\1\u019f",
            "\1\u01a0",
            "\1\u01a1",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u01a3",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u01a5",
            "",
            "",
            "\1\u01a6",
            "\1\u01a7",
            "",
            "",
            "\12\u01a8\7\uffff\6\u01a8",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "",
            "\1\u01ab",
            "\1\u01ac",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\1\u01af",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u01b1",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u01b3",
            "\1\u01b4",
            "",
            "",
            "",
            "\1\u01b5",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u01b7",
            "\1\u01b8",
            "",
            "\1\u01b9",
            "",
            "",
            "",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u01bf",
            "\1\u01c0",
            "\1\u01c1",
            "\1\u01c2",
            "\1\u01c3",
            "\1\u01c4",
            "",
            "\1\u01c5",
            "",
            "\1\u01c6",
            "\1\u01c7",
            "\1\u01c8",
            "\12\u01c9\7\uffff\6\u01c9",
            "",
            "",
            "\1\u01ca",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "",
            "\1\u01cc",
            "",
            "\1\u01cd",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u01d0",
            "",
            "\1\u01d1",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u01d3",
            "",
            "",
            "",
            "",
            "",
            "\1\u01d4",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u01d6",
            "\1\u01d7",
            "\1\u01d8",
            "\1\u01d9",
            "\1\u01da",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u01dc",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\12\u0082\1\u0085\2\u0082\1\u0085\31\u0082\1\u0084\64\u0082"+
            "\1\u0083\uffa3\u0082",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "",
            "\1\u01e1",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\1\u01e3",
            "\1\u01e4",
            "",
            "\1\u01e5",
            "\1\u01e6",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u01e8",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\1\u01ea",
            "",
            "",
            "",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\1\u01ee",
            "\1\u01ef",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "",
            "",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "\13\32\6\uffff\32\32\4\uffff\1\32",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( VOID | NULL | IMPORT | REGISTER | RETURNS | DEFINE | LOAD | FILTER | FOREACH | ORDER | RANK | DENSE | CUBE | ROLLUP | INVOKE | DISTINCT | COGROUP | JOIN | CROSS | UNION | SPLIT | INTO | IF | OTHERWISE | ALL | AS | BY | USING | INNER | OUTER | ONSCHEMA | PARALLEL | PARTITION | GROUP | AND | OR | NOT | GENERATE | FLATTEN | ASC | DESC | BOOLEAN | INT | LONG | FLOAT | BIGDECIMAL | BIGINTEGER | DOUBLE | DATETIME | CHARARRAY | BYTEARRAY | BAG | TUPLE | MAP | IS | STREAM | THROUGH | STORE | ASSERT | MAPREDUCE | SHIP | CACHE | INPUT | OUTPUT | STDERROR | STDIN | STDOUT | LIMIT | SAMPLE | LEFT | RIGHT | FULL | CASE | WHEN | THEN | ELSE | END | STR_OP_EQ | STR_OP_GT | STR_OP_LT | STR_OP_GTE | STR_OP_LTE | STR_OP_NE | STR_OP_MATCHES | IN | TRUE | FALSE | NUM_OP_EQ | NUM_OP_LT | NUM_OP_LTE | NUM_OP_GT | NUM_OP_GTE | NUM_OP_NE | DCOLON | IDENTIFIER | INTEGER | LONGINTEGER | DOLLARVAR | DOUBLENUMBER | BIGDECIMALNUMBER | BIGINTEGERNUMBER | FLOATNUMBER | QUOTEDSTRING | MULTILINE_QUOTEDSTRING | EXECCOMMAND | STAR | COLON | DOLLAR | WS | SL_COMMENT | ML_COMMENT | SEMI_COLON | LEFT_PAREN | RIGHT_PAREN | LEFT_CURLY | RIGHT_CURLY | LEFT_BRACKET | RIGHT_BRACKET | POUND | EQUAL | COMMA | PERIOD | DOUBLE_PERIOD | DIV | PERCENT | PLUS | MINUS | QMARK | ARROBA | AMPERSAND | FAT_ARROW );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA13_457 = input.LA(1);

                        s = -1;
                        if ( (LA13_457=='\'') ) {s = 132;}

                        else if ( ((LA13_457 >= '\u0000' && LA13_457 <= '\t')||(LA13_457 >= '\u000B' && LA13_457 <= '\f')||(LA13_457 >= '\u000E' && LA13_457 <= '&')||(LA13_457 >= '(' && LA13_457 <= '[')||(LA13_457 >= ']' && LA13_457 <= '\uFFFF')) ) {s = 130;}

                        else if ( (LA13_457=='\\') ) {s = 131;}

                        else if ( (LA13_457=='\n'||LA13_457=='\r') ) {s = 133;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA13_224 = input.LA(1);

                        s = -1;
                        if ( (LA13_224=='\'') ) {s = 132;}

                        else if ( ((LA13_224 >= '\u0000' && LA13_224 <= '\t')||(LA13_224 >= '\u000B' && LA13_224 <= '\f')||(LA13_224 >= '\u000E' && LA13_224 <= '&')||(LA13_224 >= '(' && LA13_224 <= '[')||(LA13_224 >= ']' && LA13_224 <= '\uFFFF')) ) {s = 130;}

                        else if ( (LA13_224=='\\') ) {s = 131;}

                        else if ( (LA13_224=='\n'||LA13_224=='\r') ) {s = 133;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA13_130 = input.LA(1);

                        s = -1;
                        if ( (LA13_130=='\'') ) {s = 132;}

                        else if ( ((LA13_130 >= '\u0000' && LA13_130 <= '\t')||(LA13_130 >= '\u000B' && LA13_130 <= '\f')||(LA13_130 >= '\u000E' && LA13_130 <= '&')||(LA13_130 >= '(' && LA13_130 <= '[')||(LA13_130 >= ']' && LA13_130 <= '\uFFFF')) ) {s = 130;}

                        else if ( (LA13_130=='\\') ) {s = 131;}

                        else if ( (LA13_130=='\n'||LA13_130=='\r') ) {s = 133;}

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA13_30 = input.LA(1);

                        s = -1;
                        if ( ((LA13_30 >= '\u0000' && LA13_30 <= '\t')||(LA13_30 >= '\u000B' && LA13_30 <= '\f')||(LA13_30 >= '\u000E' && LA13_30 <= '&')||(LA13_30 >= '(' && LA13_30 <= '[')||(LA13_30 >= ']' && LA13_30 <= '\uFFFF')) ) {s = 130;}

                        else if ( (LA13_30=='\\') ) {s = 131;}

                        else if ( (LA13_30=='\'') ) {s = 132;}

                        else if ( (LA13_30=='\n'||LA13_30=='\r') ) {s = 133;}

                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}

            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 13, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}