/**
 * Copyright 2009-2020 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.ibatis.plugin;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The annotation that indicate the method signature.
 *
 * @author Clinton Begin
 * @see Intercepts
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface Signature {
  /**
   * Returns the java type.
   * 需要被拦截的类
   *
   * @return the java type
   */
  Class<?> type();

  /**
   * Returns the method name.
   * 需要被拦截的方法
   *
   * @return the method name
   */
  String method();

  /**
   * Returns java types for method argument.
   * 表示方法参数
   *
   * @return java types for method argument
   */
  Class<?>[] args();


  /*
   * Mybatis提供了4个组件的扩展，所以只有4个
   * 举个例子，如果想拦截Executor类（其他三个类类同）
   *
   * 那么type就指定Executor
   * method就指定Executor类里面有的method
   * 因为Executor类里面方法可能有重载的，所以还需要配合参数来唯一指定，这个arg的类型就是Executor方法的参数的类型
   *
   * */
}
