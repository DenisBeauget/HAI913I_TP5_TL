package Processor;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtExecutable;

public class OurProcessor extends AbstractProcessor<CtExecutable<?>> {

	public void process(CtExecutable<?> element) {
		CtCodeSnippetStatement snippet = getFactory().Core().createCodeSnippetStatement();

		// Snippet which contains the log.
		final String value = String.format("System.out.println(\"Enter in the method %s from class %s\")",
				element.getSimpleName(), element.getParent(CtClass.class).getSimpleName());
		snippet.setValue(value);

		// Inserts the snippet at the beginning of the method body.
		if (element.getBody() != null) {
			element.getBody().insertBegin(snippet);
		}
	}


}