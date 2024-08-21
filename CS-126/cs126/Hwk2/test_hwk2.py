from pytest import approx
import hwk2


def test_pounds_to_kilos_for_zero():
    assert hwk2.pounds_to_kilos(0) == 0


def test_pounds_to_kilos_for_one():
    assert hwk2.pounds_to_kilos(1) == approx(1 / 2.20462)


def test_kilos_to_pounds_for_zero():
    assert hwk2.kilos_to_pounds(0) == 0


def test_kilos_to_pounds_for_one():
    assert hwk2.kilos_to_pounds(1) == approx(2.20462)


def test_fahrenheit_to_celsius_for_freezing():
    assert hwk2.fahrenheit_to_celsius(32) == approx(0)


def test_fahrenheit_to_celsius_for_boiling():
    assert hwk2.fahrenheit_to_celsius(212) == approx(100)


def test_celsius_to_fahrenheit_for_freezing():
    assert hwk2.celsius_to_fahrenheit(0) == approx(32)


def test_celsius_to_fahrenheit_for_boiling():
    assert hwk2.celsius_to_fahrenheit(100) == approx(212)


def test_hms_to_seconds_for_zero():
    assert hwk2.hms_to_seconds(0, 0, 0) == 0


def test_hms_to_seconds_for_one_minute():
    assert hwk2.hms_to_seconds(0, 1, 0) == 60


def test_hms_to_seconds_for_one_hour():
    assert hwk2.hms_to_seconds(1, 0, 0) == 3600


def test_hms_to_seconds_for_one_of_each():
    assert hwk2.hms_to_seconds(1, 1, 1) == 3661


def test_distance_between_points_origin_to_0_5():
    assert hwk2.distance_between_points(0, 0, 0, 5) == approx(5)


def test_distance_between_points_origin_to_neg_5_0():
    assert hwk2.distance_between_points(0, 0, 5, 0) == approx(5)


def test_distance_between_points_pythagorean_triple():
    assert hwk2.distance_between_points(2, 2, 5, 6) == approx(5)


def test_distance_from_origin_to_0_5():
    assert hwk2.distance_from_origin(0, 5) == approx(5)


def test_distance_from_origin_to_neg_5_0():
    assert hwk2.distance_from_origin(5, 0) == approx(5)


def test_distance_from_origin_pythagorean_triple():
    assert hwk2.distance_from_origin(3, 4) == approx(5)


def test_score_to_grade_middle_C():
    assert hwk2.score_to_grade(75) == 'C'


def test_score_to_grade_boundary_A():
    assert hwk2.score_to_grade(90) == 'A'


def test_score_to_grade_boundary_F():
    assert hwk2.score_to_grade(59) == 'F'


def test_score_to_grade_zero():
    assert hwk2.score_to_grade(0) == 'F'


def test_score_to_grade_negative():
    assert hwk2.score_to_grade(-20) == 'F'


def test_score_to_grade_more_than_100():
    assert hwk2.score_to_grade(120) == 'A'


def test_convert_from_pounds_zero():
    assert hwk2.convert(0, 'lb') == approx(0)


def test_convert_from_pounds_one():
    assert hwk2.convert(1, 'lb') == approx(1 / 2.20462)


def test_convert_from_kilos_zero():
    assert hwk2.convert(0, 'kg') == approx(0)


def test_convert_from_kilos_one():
    assert hwk2.convert(1, 'kg') == approx(2.20462)


def test_convert_from_f_freezing():
    assert hwk2.convert(32, 'f') == approx(0)


def test_convert_from_f_boiling():
    assert hwk2.convert(212, 'f') == approx(100)


def test_convert_from_c_freezing():
    assert hwk2.convert(0, 'c') == approx(32)


def test_convert_from_c_boiling():
    assert hwk2.convert(100, 'c') == approx(212)


def test_convert_from_kelvin():
    assert hwk2.convert(0, 'k') == None


def test_sdbtp_1():
    assert hwk2.sdbtp(0, 0, 0, 5, 10, 0) == approx(5)


def test_sdbtp_2():
    assert hwk2.sdbtp(1, 1, 4, 1, 4, 5) == approx(3)


def test_sdbtp_3():
    assert hwk2.sdbtp(4, 1, 4, 5, 1, 1) == approx(3)
