require.config({
　　　　paths: {
　　　　	"jquery": "./lib/jquery-2.1.4.min",
    	"blog":"blog"
　　　　}
　　});

require(['jquery','blog'], function ($,blog){
　　　　blog.init();
　　});