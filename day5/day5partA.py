from sys import argv
script, filename = argv

vowels =['a','e','i','o','u']
double_letter = False
bad_pattern = [ "ab","cd","pq","xy"]
bad_String = False
count = 0
total_good_strings = 0

with open(filename) as f:
	for line in f:
		for pat in bad_pattern :
			if pat in line :
				bad_String = True
		if not bad_String:
			for v in vowels:
				count = count + int(line.count( v ))
			if count >= 3 :
				temp=""
				for char in line : 
					if char == temp:
						total_good_strings=total_good_strings+1
						break;
					temp = char
			count = 0
		bad_String = False

print "Total number of good string are: ",total_good_strings
					
				
