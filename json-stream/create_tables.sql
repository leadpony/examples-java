DROP TABLE IF EXISTS blog_post;

CREATE TABLE blog_post (
    id bigint NOT NULL AUTO_INCREMENT,
    author varchar(100) NOT NULL,
    title varchar(1000) NOT NULL,
    content varchar(10000) NOT NULL,
    posted timestamp DEFAULT CURRENT_TIMESTAMP,
    
    PRIMARY KEY(id)    
);
