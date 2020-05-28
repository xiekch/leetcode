all:
	@if [ $(suffix $(f)) = .java ];\
	then \
		javac $(f) && java -cp . $(basename $(f));\
	elif [ $(suffix $(f)) = .cpp ];\
	then \
		g++ -std=c++11 -Wall $(f) && ./a.out;\
	elif [ $(suffix $(f)) = .kt ];\
	then \
		kotlinc $(f) && kotlin $(basename $(f))Kt;\
	elif [ $(suffix $(f)) = .py ];\
	then \
		python3 $(f);\
	fi
clean:
	rm *.class *.out