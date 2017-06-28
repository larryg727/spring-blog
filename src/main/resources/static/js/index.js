/**
 * Created by larryg on 6/27/17.
 */
"use strict";
$(document).ready(function () {
    "use strict";

var request = $.ajax({
   url: "/posts.json"
});
request.done(function(){
    console.log(request.responseJSON);

    request.responseJSON.forEach(function(post){
        var html = "";
        html += "<div>";
        html += "<h2>Title: " + post.title;
        html += "<h3>" + post.body + "</h3>";
        html+= "<p>Posted by: " +  post.user.username + "</p>";
        html+= "<p>Email: " +  post.user.email + "</p>";
        html += "</div>";
        $("#posts").append(html);
    });
});


});