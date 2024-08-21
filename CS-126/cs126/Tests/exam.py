def main():
    print(is_vowel('a'))
    print(is_vowel('b'))
    print(is_vowel('jk'))
    print(is_vowel('ou'))


# This is the function to check
# whether the inputed character
# is a vowel.
def is_vowel(char):
    # First determines if the length of the
    # inputed string is a single character
    # before checking if the inputed character
    # is equal to any of the vowels 'aeiou'.
    if len(char) == 1:
        vowels = ('aeiou')
        for i in range(len(vowels)):
            char = char.lower()
            if char == vowels[i]:
                return True
        # If it checks each of the vowels but
        # none are equal to the inputed character
        # then the function returns False.
        return False
    else:
        # if the length of the inputed string is not
        # a single character, then the function returns
        # None.
        return None


main()
