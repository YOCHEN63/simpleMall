# simpleMall

## 2022/11/21学习记录
 - spring security
 - BCryptPasswordEncoder

### Spring security

1. 配置 `SecurityConfig.java`文件
   ``` java
    @Configuration
    @EnableWebSecurity
    public class SecurityConfig {
        // 通过编写 webSecurityCustomizer 方法完成 webSecurity 的配置
        @Bean
        WebSecurityCustomizer webSecurityCustomizer() {
            return new WebSecurityCustomizer() {
                @Override
                public void customize(WebSecurity web) {
                    // 支持匿名访问的路径
                    web.ignoring().antMatchers("/users/register", "/users/login");
                }
            };

        }

    }
   ```
2. 待补充

### BCryptPasswordEncoder
1. 