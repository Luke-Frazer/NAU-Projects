from hwk5 import select_field
from hwk5 import find_vowel_indexes
from hwk5 import first_factor
from hwk5 import is_prime
from hwk5 import romanize


def test_select_field_simple():
    assert select_field("a, b, c", 1) == "b"


def test_select_field_too_far():
    assert select_field("a, b, c", 700) is None


def test_select_field_one_field():
    assert select_field("happy", 0) == "happy"


def test_select_field_empty_field():
    assert select_field("a, , c", 1) == ""


def test_find_vowel_indexes_simple():
    assert find_vowel_indexes("mom") == [1]


def test_find_vowel_indexes_mixed_case():
    assert find_vowel_indexes("SPongE bOB") == [2, 5, 8]


def test_find_vowel_indexes_y_counts():
    assert find_vowel_indexes("sky") == [2]


def test_find_vowel_indexes_initial_y_doesnt_count():
    assert find_vowel_indexes("yep") == [1]


def test_find_vowel_indexes_no_vowels():
    assert find_vowel_indexes("strč prst skrz krk") == []


def test_first_factor_simple():
    assert first_factor(6) == 2


def test_first_factor_large_first_factor():
    assert first_factor(7048289) == 1153


def test_first_factor_prime():
    assert first_factor(17) == 17


def test_is_prime_with_small_prime():
    assert is_prime(3)


def test_is_prime_with_large_prime():
    assert is_prime(5717)


def test_is_prime_small_composite():
    assert not is_prime(20)


def test_is_prime_large_composite():
    assert not is_prime(7048289)


def test_romanize_no_special_cases():
    assert romanize(33) == "XXXIII"


def test_romanize_fourty_four():
    assert romanize(44) == 'XLIV'


def test_romanize_fifty_five():
    assert romanize(55) == 'LV'


def test_romanize_ninety_nine():
    assert romanize(99) == 'XCIX'


def test_romanize_eighty_eight():
    assert romanize(88) == 'LXXXVIII'


def test_romanize_one_hundred():
    assert romanize(100) == 'C'


