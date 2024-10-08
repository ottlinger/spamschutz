/**
 * SpamSchutz - simple way to protect your mail addresses from naïve spammers
 * Copyright (C) 2011, Aiki IT
 * <p/>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.aikiit.spamprotector.converter;

import lombok.Getter;

/**
 * Encapsulates the character conversion logics.
 * Each changeable character is represented by an enumeration instance and
 * allows conversion from/to the encoded value.
 */
@Getter
public enum CharacterConverter {

    /** Space */
    SPACE(" ", "&nbsp;"), //
    /** Exclamation mark */
    EXCLAMATION_MARK("!", "&#33;"), //
    /** Quotation */
    QUOTE("\"", "&#34;"), //
    /** Hash */
    HASH("#", "&#35;"), //
    /** Dollar sign */
    DOLLAR("$", "&#36;"), //
    /** Percent */
    PERCENT("%", "&#37;"), //
    /** Ampersand */
    AMPERSAND("&", "&amp;"), //
    /** Single quotation */
    SINGLE_QUOTE("\'", "&#39;"), //
    /** Left bracket */
    LEFT_BRACKET("(", "&#40;"), //
    /** Right bracket */
    RIGHT_BRACKET(")", "&#41;"), //
    /** Asterisk */
    ASTERISK("*", "&#42;"), //
    /** Plus sign */
    PLUS("+", "&#43;"), //
    /** Comma */
    COMMA(",", "&#44;"), //
    /** Minus sign */
    MINUS("-", "&#45;"), //
    /** Plain dot */
    DOT(".", "&#46;"), //
    /** Single slash */
    SLASH("/", "&#47;"), //
    /** Number 0 */
    ZERO("0", "&#48;"), //
    /** Number 1 */
    ONE("1", "&#49;"), //
    /** Number 2 */
    TWO("2", "&#50;"), //
    /** Number 3 */
    THREE("3", "&#51;"), //
    /** Number 4 */
    FOUR("4", "&#52;"), //
    /** Number 5 */
    FIVE("5", "&#53;"), //
    /** Number 6 */
    SIX("6", "&#54;"), //
    /** Number 7 */
    SEVEN("7", "&#55;"), //
    /** Number 8 */
    EIGHT("8", "&#56;"), //
    /** Number 9 */
    NINE("9", "&#57;"), //
    /** Colon */
    COLON(":", "&#58;"), //
    /** Semicolon */
    SEMICOLON(";", "&#59;"), //
    /** Less than */
    LT("<", "&#60;"), //
    /** Equal sign */
    EQUAL("=", "&#61;"), //
    /** Greater than */
    GT(">", "&#62;"), //
    /** Question mark */
    QUESTION_MARK("?", "&#63;"), //
    /** AT sign */
    AT("@", "&#64;"), //
    /** A */
    CAPITAL_A("A", "&#65;"), //
    /** B */
    CAPITAL_B("B", "&#66;"), //
    /** C */
    CAPITAL_C("C", "&#67;"), //
    /** D */
    CAPITAL_D("D", "&#68;"), //
    /** E */
    CAPITAL_E("E", "&#69;"), //
    /** F */
    CAPITAL_F("F", "&#70;"), //
    /** G */
    CAPITAL_G("G", "&#71;"), //
    /** H */
    CAPITAL_H("H", "&#72;"), //
    /** I */
    CAPITAL_I("I", "&#73;"), //
    /** J */
    CAPITAL_J("J", "&#74;"), //
    /** K */
    CAPITAL_K("K", "&#75;"), //
    /** L */
    CAPITAL_L("L", "&#76;"), //
    /** M */
    CAPITAL_M("M", "&#77;"), //
    /** N */
    CAPITAL_N("N", "&#78;"), //
    /** O */
    CAPITAL_O("O", "&#79;"), //
    /** P */
    CAPITAL_P("P", "&#80;"), //
    /** Q */
    CAPITAL_Q("Q", "&#81;"), //
    /** R */
    CAPITAL_R("R", "&#82;"), //
    /** S */
    CAPITAL_S("S", "&#83;"), //
    /** T */
    CAPITAL_T("T", "&#84;"), //
    /** U */
    CAPITAL_U("U", "&#85;"), //
    /** V */
    CAPITAL_V("V", "&#86;"), //
    /** W */
    CAPITAL_W("W", "&#87;"), //
    /** X */
    CAPITAL_X("X", "&#88;"), //
    /** Y */
    CAPITAL_Y("Y", "&#89;"), //
    /** Z */
    CAPITAL_Z("Z", "&#90;"), //
    /** [ */
    LEFT_SQUARE_BRACKET("[", "&#91;"), //
    /** Backslash */
    BACKSLASH("\\", "&#92;"), //
    /** ] */
    RIGHT_SQUARE_BRACKET("]", "&#93;"), //
    /** Circumflex */
    CIRCUMFLEX("^", "&#94;"), //
    /** Underscore */
    UNDERSCORE("_", "&#95;"), //
    /** Tick */
    TICK("`", "&#96;"), //
    /** a */
    A("a", "&#97;"), //
    /** b */
    B("b", "&#98;"), //
    /** c */
    C("c", "&#99;"), //
    /** d */
    D("d", "&#100;"), //
    /** e */
    E("e", "&#101;"), //
    /** f */
    F("f", "&#102;"), //
    /** g */
    G("g", "&#103;"), //
    /** h */
    H("h", "&#104;"), //
    /** i */
    I("i", "&#105;"), //
    /** j */
    J("j", "&#106;"), //
    /** k */
    K("k", "&#107;"), //
    /** l */
    L("l", "&#108;"), //
    /** m */
    M("m", "&#109;"), //
    /** n */
    N("n", "&#110;"), //
    /** o */
    O("o", "&#111;"), //
    /** p */
    P("p", "&#112;"), //
    /** q */
    Q("q", "&#113;"), //
    /** r */
    R("r", "&#114;"), //
    /** s */
    S("s", "&#115;"), //
    /** t */
    T("t", "&#116;"), //
    /** u */
    U("u", "&#117;"), //
    /** v */
    V("v", "&#118;"), //
    /** w */
    W("w", "&#119;"), //
    /** x */
    X("x", "&#120;"), //
    /** y */
    Y("y", "&#121;"), //
    /** z */
    Z("z", "&#122;"), //
    /** { */
    LEFT_CURLY_BRACKET("{", "&#123;"), //
    /** Pipe */
    PIPE("|", "&#124;"), //
    /** } */
    RIGHT_CURLY_BRACKET("}", "&#125;"), //
    /** Tilde */
    TILDE("~", "&#126;"), //
    //
    ;

    private final String plain;
    private final String replacement;

    CharacterConverter(final String plain, final String placement) {
        this.plain = plain;
        this.replacement = placement;
    }

}
