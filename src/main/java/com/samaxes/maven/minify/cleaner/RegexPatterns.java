/*
 * Copyright 2016 Sonicle Srl.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.samaxes.maven.minify.cleaner;

import java.util.regex.Pattern;

/**
 *
 * @author malbinola
 */
public class RegexPatterns {
	public static final String REGEX_MULTILINE_COMMENT = "/\\*.*?\\*/";
	public static final Pattern MULTILINE_COMMENT = Pattern.compile(REGEX_MULTILINE_COMMENT, Pattern.DOTALL);

	// String literals: a backslash escapes anything, line continuations included
	private static final String REGEX_JS_DQ_STRING = "\"[^\"\\\\\n]*(?:\\\\[\\s\\S][^\"\\\\\n]*)*\"";
	private static final String REGEX_JS_SQ_STRING = "'[^'\\\\\n]*(?:\\\\[\\s\\S][^'\\\\\n]*)*'";
	private static final String REGEX_JS_TEMPLATE = "`[^`\\\\]*(?:\\\\[\\s\\S][^`\\\\]*)*`";
	// A slash opens a regex literal, rather than being a division, only where
	// an expression is expected: after an operator or after return/typeof/case
	private static final String REGEX_JS_REGEX_PREFIX = "(?:(?<=[=(,:\\[!&|?{;]\\s{0,40})|(?<=\\b(?:return|typeof|case)\\s{0,40}))";
	private static final String REGEX_JS_REGEX_CLASS = "\\[[^\\]\\\\\n]*(?:\\\\.[^\\]\\\\\n]*)*\\]";
	private static final String REGEX_JS_REGEX = REGEX_JS_REGEX_PREFIX + "/(?![*/])[^/\\\\\n\\[]*(?:(?:\\\\.|" + REGEX_JS_REGEX_CLASS + ")[^/\\\\\n\\[]*)*/";

	/**
	 * Splits JavaScript source into the tokens that matter when dropping comments.
	 * Group 1 matches string, template and regex literals, so that comment markers
	 * inside them (eg. 'http://host/path') are not taken as comments; group 2
	 * matches a multi-line comment and group 3 a single-line one.
	 */
	public static final Pattern JS_LITERAL_OR_COMMENT = Pattern.compile(
		"(" + REGEX_JS_DQ_STRING + "|" + REGEX_JS_SQ_STRING + "|" + REGEX_JS_TEMPLATE + "|" + REGEX_JS_REGEX + ")"
		+ "|(/\\*[\\s\\S]*?\\*/)"
		+ "|(//[^\n]*)"
	);
}
