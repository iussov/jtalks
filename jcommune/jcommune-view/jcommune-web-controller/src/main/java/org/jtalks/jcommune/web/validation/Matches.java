/**
 * Copyright (C) 2011  jtalks.org Team
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 * Also add information on how to contact you by electronic and paper mail.
 * Creation date: Apr 12, 2011 / 8:05:19 PM
 * The jtalks.org Project
 */
package org.jtalks.jcommune.web.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Constraint for checking that two properties are equal.
 * This constraint for use with JSR-303 validator.
 *
 * You must annotate your class with {@link Matches} annotation
 * You must fill in the parameters <code>field</code> and <code>verifyField</code>
 * field names to test for equality. Fields must have getters.
 * Constraint can be used with any field types that have correct
 * </code>equals()</code> method.
 *
 * Example:
 * Validate that <code>field1</code> and <code>field2</code> are equals.
 * {@code
 *     &#064;Matches(field = "field1", verifyField = "field2")
 *     class Test {
 *      private String field1;
 *      private String field2;
 *      public String getField1() {
 *          return field1;
 *      }
 *      public String getField2() {
 *          return field2;
 *      }
 *     }
 * }
 *
 * @author Kirill Afonin
 * @see MatchesValidator
 */
@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = MatchesValidator.class)
@Documented
public @interface Matches {
    /**
     * Message for display when validation fails.
     *
     */
    String message() default "{validation.matches}";

    /**
     * Groups
     *
     */
    Class<?>[] groups() default {};

    /**
     * Payload
     *
     */
    Class<? extends Payload>[] payload() default {};

    /**
     * First proerty name for check equality.
     *
     */
    String field();

    /**
     * Second property name for check equality.
     *
     */
    String verifyField();
}