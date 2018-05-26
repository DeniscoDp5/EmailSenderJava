Description of the procedure 

1) secondJ.Java
    Set the correct parameter urls

    $ javac -cp : packages/* secondJ.javac
    $ java -cp: :packages/* secondJ > results/1-first.txt

2) removeDuplicates.Java

    $javac removeDuplicates.java
    $java removeDuplicates < results/1-first.txt > results/2-firstNoDuplicates.txt

3) googleWebSearch.Java

    $javac -cp :packages/* googleWebSearch.java
    $java -cp :packages/* googleWebSearch < results/firstNoDuplicates.txt > results/3-webUrl.txt

4) getEmailAddress.java

    $javac getEmailAddress.java
    $java getEmailAddress < results/3-webUrl > results/4-contacts.txt

5)  removeDuplicates.Java

    $java removeDuplicates < results/4-contacts.txt > results/5-contactsNoDuplicates.txt

Now go to results/5-contactsNoDuplicates and remove the eamils you don't want to send currigulum to.
Remove @pec.[com it us ...] and .png .jpej and oters that arent eamils.

6)  MailProjectClass.java

    !IMPORTANT 
        Modify the file by adding your email path to curriculum and the other informations

    $javac -cp packages/* MailProjectClass.java

7)  file.java

    $javac -cp :packages/* file.java

    !IMPORTANT
        make some test
        $java -cp :packages/* file {yourEmail} {yourPassword} < TEST.txt
        The TEST.txt file should have your email in so you send to you your email and check if all is ok
 
    !IMPORTANT
        This comand will send the emails 
    $java -cp :packages/* file {yourEmail} {yourPassword} < 5-contactsNoDuplicates.txt
    es java -cp :packages/* file gino@gmail.com ginosPassword < 5-contactsNoDuplicates.txt

If all worked go to your email and watch the email you sended.