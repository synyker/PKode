description 'user can list all added articles in BibTex format'
 
scenario "user can list all added articles in BibTexFormat", {
    given 'command list all selected'
    when 'BibTect format selected'
    then 'information should be printed on the screen in BibText format'
}
 
