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

/**
 * Encapsulates the character conversion logics.
 * Each changeable character is represented by an enumeration instance and
 * allows conversion from/to the encoded value.
 */
public enum CharacterConverter {

    SPACE(" ", "&nbsp;"), //
    EXCLAMATION_MARK("!", "&#33;"), //
    QUOTE("\"", "&#34;"), //
    HASH("#", "&#35;"), //
    DOLLAR("$", "&#36;"), //
    PERCENT("%", "&#37;"), //
    AMPERSAND("&", "&amp;"), //
    SINGLE_QUOTE("\'", "&#39;"), //
    LEFT_BRACKET("(", "&#40;"), //
    RIGHT_BRACKET(")", "&#41;"), //
    ASTERISK("*", "&#42;"), //
    PLUS("+", "&#43;"), //
    COMMA(",", "&#44;"), //
    MINUS("-", "&#45;"), //
    DOT(".", "&#46;"), //
    SLASH("/", "&#47;"), //
    ZERO("0", "&#48;"), //
    ONE("1", "&#49;"), //
    TWO("2", "&#50;"), //
    THREE("3", "&#51;"), //
    FOUR("4", "&#52;"), //
    FIVE("5", "&#53;"), //
    SIX("6", "&#54;"), //
    SEVEN("7", "&#55;"), //
    EIGHT("8", "&#56;"), //
    NINE("9", "&#57;"), //
    COLON(":", "&#58;"), //
    SEMICOLON(";", "&#59;"), //
    LT("<", "&#60;"), //
    EQUAL("=", "&#61;"), //
    GT(">", "&#62;"), //
    QUESTION_MARK("?", "&#63;"), //
    AT("@", "&#64;"), //
    CAPITAL_A("A", "&#65;"), //
    CAPITAL_B("B", "&#66;"), //
    CAPITAL_C("C", "&#67;"), //
    CAPITAL_D("D", "&#68;"), //
    CAPITAL_E("E", "&#69;"), //
    CAPITAL_F("F", "&#70;"), //
    CAPITAL_G("G", "&#71;"), //
    CAPITAL_H("H", "&#72;"), //
    CAPITAL_I("I", "&#73;"), //
    CAPITAL_J("J", "&#74;"), //
    CAPITAL_K("K", "&#75;"), //
    CAPITAL_L("L", "&#76;"), //
    CAPITAL_M("M", "&#77;"), //
    CAPITAL_N("N", "&#78;"), //
    CAPITAL_O("O", "&#79;"), //
    CAPITAL_P("P", "&#80;"), //
    CAPITAL_Q("Q", "&#81;"), //
    CAPITAL_R("R", "&#82;"), //
    CAPITAL_S("S", "&#83;"), //
    CAPITAL_T("T", "&#84;"), //
    CAPITAL_U("U", "&#85;"), //
    CAPITAL_V("V", "&#86;"), //
    CAPITAL_W("W", "&#87;"), //
    CAPITAL_X("X", "&#88;"), //
    CAPITAL_Y("Y", "&#89;"), //
    CAPITAL_Z("Z", "&#90;"), //
    LEFT_SQUARE_BRACKET("[", "&#91;"), //
    BACKSLASH("\\", "&#92;"), //
    RIGHT_SQUARE_BRACKET("]", "&#93;"), //
    CIRCUMFLEX("^", "&#94;"), //
    UNDERSCORE("_", "&#95;"), //
    TICK("`", "&#96;"), //
    A("a", "&#97;"), //
    B("b", "&#98;"), //
    C("c", "&#99;"), //
    D("d", "&#100;"), //
    E("e", "&#101;"), //
    F("f", "&#102;"), //
    G("g", "&#103;"), //
    H("h", "&#104;"), //
    I("i", "&#105;"), //
    J("j", "&#106;"), //
    K("k", "&#107;"), //
    L("l", "&#108;"), //
    M("m", "&#109;"), //
    N("n", "&#110;"), //
    O("o", "&#111;"), //
    P("p", "&#112;"), //
    Q("q", "&#113;"), //
    R("r", "&#114;"), //
    S("s", "&#115;"), //
    T("t", "&#116;"), //
    U("u", "&#117;"), //
    V("v", "&#118;"), //
    W("w", "&#119;"), //
    X("x", "&#120;"), //
    Y("y", "&#121;"), //
    Z("z", "&#122;"), //
    LEFT_CURLY_BRACKET("{", "&#123;"), //
    PIPE("|", "&#124;"), //
    RIGHT_CURLY_BRACKET("}", "&#125;"), //
    TILDE("~", "&#126;"), //
    //
    ;

    private final String plain;
    private final String replacement;

    CharacterConverter(final String plain, final String placement) {
        this.plain = plain;
        this.replacement = placement;
    }

    /**
     * @return the plain/not encoded value of that character.
     */
    public String getPlain() {
        return plain;
    }

    /**
     * @return the encoded value of that character.
     */
    public String getReplacement() {
        return replacement;
    }

}
