from sys import argv
script, filename = argv

vowels =['a','e','i','o','u']
bad_pattern = [ "ab","cd","pq","xy"]
cond1 = False
cond2 = False
count = 0
total_good_strings = 0
occured = 0

with open(filename) as f:
	for line in f:
		last=")"
		middle="/"
		for first in line :
			if last == first :
				cond1=True 
			pair = middle + first
			occured = int(line.count(pair))
			if occured > 1:
				cond2 = True
			if cond2 and cond1:
				total_good_strings=total_good_strings+1
				break;
			last = middle
			middle = first
		cond1 = False
		cond2 = False

print "Total number of good string are: ",total_good_strings
					
				
