# 个人使用的 spring boot 脚手架

## 项目描述

## 表
```sql
create table zs_article
(
    title       varchar(255) default ''    null comment '标题',
    id          bigint auto_increment comment '主键' primary key,
    content     longtext                   null comment '内容',
    create_time datetime     default NOW() null comment '创建时间'
        
) comment '文章页面';
```


