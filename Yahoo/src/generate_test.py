path = '../file/name.test'
dest_dir = '../file/input/'

data_num = [0, 1, 10, 100, 1000, 10000, 50000]

def write_test(num):
	input_file = open(path, 'r')
	output_file = open(dest_dir + str(num)+ '.test', 'w')
	
	count = 0
	for line in input_file:
		if(count >= num):
			break
		output_file.write(line);
		count += 1

	input_file.close()
	output_file.close()

for num in data_num:
	write_test(num)
