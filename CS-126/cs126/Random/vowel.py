
def main():
	remove_vowels("pizza")
	remove_vowels("mississippi")

# remove_vowels("pizza") --> "pzz"
def remove_vowels(string):
	result_string = ""
	for i in range(len(string)):
		if is_vowel(string[i]):
			pass
		else:
			result_string = result_string + string[i]
	print(result_string)
	return result_string

def is_vowel(char):
	char = char.lower()
	return char in 'aeiou'

main()
