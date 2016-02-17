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

/**
 *
 * @author malbinola
 */
public class CleanerOptions {
	private boolean removeSingleLineComments = true;
	private boolean removeMultiLinesComments = true;
	private boolean expandTabsToSpaces = true;
	//private boolean removeTodos = true;
	
	public CleanerOptions() {}
	
	public void setRemoveSingleLineComments(boolean removeSingleLineComments) {
		this.removeSingleLineComments = removeSingleLineComments;
	}
	
	public boolean getRemoveSingleLineComments() {
		return this.removeSingleLineComments;
	}
	
	public void setRemoveMultiLinesComments(boolean removeMultiLinesComments) {
		this.removeMultiLinesComments = removeMultiLinesComments;
	}
	
	public boolean getRemoveMultiLinesComments() {
		return this.removeMultiLinesComments;
	}
	
	public void setExpandTabsToSpaces(boolean expandTabsToSpaces) {
		this.expandTabsToSpaces = expandTabsToSpaces;
	}
	
	public boolean getExpandTabsToSpaces() {
		return this.expandTabsToSpaces;
	}
	
	/*
	public void setRemoveTodos(boolean removeTodos) {
		this.removeTodos = removeTodos;
	}
	
	public boolean getRemoveTodos() {
		return this.removeTodos;
	}
	*/
}
