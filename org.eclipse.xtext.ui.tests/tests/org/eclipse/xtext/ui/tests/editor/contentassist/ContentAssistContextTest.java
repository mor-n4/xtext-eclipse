/*******************************************************************************
 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist;

import org.eclipse.xtext.testing.InjectWith;
import org.junit.jupiter.api.extension.ExtendWith;
import org.eclipse.xtext.ui.testing.AbstractContentAssistTest;
import org.eclipse.xtext.ui.tests.editor.contentassist.ui.tests.ContentAssistContextTestLanguageUiInjectorProvider;
import org.junit.jupiter.api.Test;
import org.eclipse.xtext.testing.extensions.InjectionExtension;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(ContentAssistContextTestLanguageUiInjectorProvider.class)
@ExtendWith(InjectionExtension.class)
public class ContentAssistContextTest extends AbstractContentAssistTest {


	@Test public void testBug276742_01() throws Exception {
		newBuilder().assertText("A1", "B1");
	}

	@Test public void testBug276742_02() throws Exception {
		newBuilder().append("A1").assertText("A1");
	}

	@Test public void testBug276742_03() throws Exception {
		newBuilder().append("A1 ").assertText("A1", "A2", "Name");
	}

	@Test public void testBug276742_04() throws Exception {
		newBuilder().append("A").assertText("A1");
	}

	@Test public void testBug276742_05() throws Exception {
		newBuilder().append("A1 A1").assertText("A1");
	}

	@Test public void testBug276742_06() throws Exception {
		newBuilder().append("A1 A").assertText(/* "A", */"A1", "A2");
	}

	@Test public void testBug276742_07() throws Exception {
		newBuilder().append("A1 A A2").assertText("A2");
	}

}
