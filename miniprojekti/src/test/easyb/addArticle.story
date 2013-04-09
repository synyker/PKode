description 'user can add an article'
 
scenario "user can login with correct password", {
    given 'command add article selected'
    when 'information for the article to be added is entered'
    then 'information can be found in the database'
}
 
