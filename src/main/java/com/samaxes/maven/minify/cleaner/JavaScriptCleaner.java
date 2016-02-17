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

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 *
 * @author malbinola
 */
public class JavaScriptCleaner extends AbstractCleaner {

	public JavaScriptCleaner(Reader reader, CleanerOptions options) throws IOException {
		super(reader, options);
	}

	@Override
	public void process(Writer writer) throws IOException {
		String s = content.toString();
		//Pattern pattern = Pattern.compile("/\\*.*?\\*/", Pattern.DOTALL);
		//s = pattern.matcher(content).replaceAll("");
		
		if(options.getRemoveMultiLinesComments()) {
			s = RegexPatterns.MULTILINE_COMMENT.matcher(s).replaceAll("");
		}
		if(options.getRemoveSingleLineComments()) {
			s = s.replaceAll("//.*", ""); // Remove //comments
		}
		s = s.replaceAll("\\s+\n", "\n"); // Trim trailing whitespace
		if(options.getExpandTabsToSpaces()) {
			s = s.replaceAll("\t", "    "); // Tabs to spaces
		}
		s = s.replaceAll("\n\n", "\n"); // Remove duplicate linefeeds
		s = s.replaceAll("^\n", ""); // Remove leading linefeeds
		
		writer.append(s);
	}
}
