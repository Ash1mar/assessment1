# 159251 Assignment1

## 1.IDs & Names

20007856  Heqing Peng

20007785  Yanpeng Xu



## 2.Directory structure description

### 2.1 Folder structure



assessment1/src/main/java:  All java code

assessment1/src/main/java/print: A package which has Print Functions(dialog)

assessment1/src/main/java/texteditor:  Implementation of text compiler

assessment1/src/main/java/texteditor/about_Window:  About Function

assessment1/src/main/java/texteditor/Format:  Format Function

assessment1/src/main/java/texteditor/KeywordsJava.java:  Highlight Function

assessment1/src/main/java/texteditor/Main:  Main methods

assessment1/src/main/java/texteditor/PrintTest1:  Print Function

assessment1/src/test/java/texteditor/OpenSearchSaveTest:  test the Open,Save and Search Function

assessment1/testfolder:  Store the generated test files(After the test, the file will be deleted automatically)

assessment1/report/pmd:  store PMD file

assessment1/report/metrics:  Code quality report



### 2.2 How to use



At present, we have implemented all the following functions.



When we want to use the New function, click file->new button and  the text editor will generate a new text editor.



When we want to use the Open function, click file->Open button. Then an interface will pop up and choose the file you want to open.



When we want to use the Save function. Firstly, write a paragraph in the text compiler and click file->Save button. Then an interface will pop up and you can choose the path and name the file to save it.



When we want to use the Print function. Firstly, click file->Print button. Then a pop-up window will appear. First, you can write the content you want to print in the text column, and then click print text to print. Print preview is a preview function. Print file supports opening files and printing them. Print frame refers to the details of printing, such as printer selection, number of pages to be printed, printing range. Click exit to exit.



When we want to use the Highlight function. Firstly,  click file->Highlight button. Then write content in the pop-up interface can become automatically highlight, but we only provide individual keywords, such as "public", "protected", "private", "U int9", "float", "double". Try to print a word like "public" to see the effect. However, there is a bug in this function. When we close the highlighted pop-up window, the text compiler will close automatically and need to be reopened.



When we want to use the Exit function. Firstly,  click file->Exit button. The program will close directly.



When we want to use the Cut, Copy and Paste function. Firstly,  click edit->Cut or Copy or Paste button. First write the content in the text compiler, then select the content you write, and click the copy button or cut button to copy or cut. Then click the place where you want to paste the text, and click the paste button to paste.



When we want to use the Search Function. First, write the content in the text compiler, click edit->Search button. Write the content you want to find in search content: and click search to find it. If you need to replace the content, you can write the content you want to replace at replace with: and click Replace. And click the search key again to find the next same content, and repeat the replacement and search operations. (there is a bug here. The pop-up window becomes blurred after search, but it does not affect the use)



When we want to use the Format Function. First, write the content in the text compiler, click Format->Font button. Then you can select the font style, font size and font type you want, and finally click OK or cancel to change or exit. We finished a few functions about format, for example,  Italic and bold, and a few fonts.



When we want to use the About Function. Click Help->About button. The information of our team members will be displayed.



## 3.Commit IDS

Ash1mar is 20007856  Heqing Peng

BoarsX is 20007785  Yanpeng Xu

1.aec29c7e404c4dd6e60e701b53d86eb24290bbca

Heqing Peng upload the basic framework which has basic functions, such as new, open, save, copy, paste, cut, exit and about functions.

2.454491ce75d72666c1cb87bd120f21cfe5bd5eab

Yanpeng Xu upload the Print Function. 

3.6984754f308dadc8b52a7d3ce5d2a45e607b2a3b

Heqing Peng upload the Search Function.

4.8e3e64f6683bb8f90045d41f916bf4ca9690ae12

Yanpeng Xu upload the Highlight Function. 

5.2e8d3dcd3c60b31ff4898315bb82fa7a3c4fbf07

Yanpeng Xu changed some comments.

6.08d8be660d9f28c0695b7167c5198524c2827fd0

Yanpeng Xu modified the Search and Replace Function, add test to Open, Save and Search Function

7.a470b92c04ccf2d2786dcd6f21603e382bd98d01

Yanpeng Xu modified the Open and Save Function to automate testing,upload the Format Function.

8 - 14.Heqing Peng and Yanpeng Xu tried to test on  travis.ci but failed so many times.

17.4ba7b0ef7ca522498167ad897d0da9ebbd457b63

Heqing Peng modified yml file and passed the test.

18.dab611fd0de4a887863000e5cd0880277d2ae949

Heqing Peng added pmd and the result of metrics analysis.



## 4.Interesting Features

There are also some interesting  points we want to mention.

We add a function called Format which can change the format of contents. There are a few choices for the users.

About CI, we used Travis CI. We faced many exceptions about the test. At last we modified yml file which add a xvfb platform to the VM on Travis CI, this solution costs us a lot of time. We tried and committed many times about that.

