# Authors: Luke Frazer and Steven Perry
# Date: 6 November 2020


# Creates a fresh new contact database to add to
def new_contact_store():
    return {}


# Adds whatever contact is created within the create_new_contact()
# function to the existing list of contacts.
def add_new_contact(contacts, first_name, last_name, email, phone_number,
                    birthday):
    contacts.update({
        first_name + last_name:
        [first_name, last_name, email, phone_number, birthday]
    })
    return contacts


# Checks to see if the contact exists within the current database.
def has_contact(contacts, first_name, last_name):
    return first_name + last_name in contacts


# Retrieves whatever contact is selected and for the user.
def get_contact_string(contacts, first_name, last_name):
    return contacts.get(first_name + last_name)


# Deletes whatever contact information is listed with the inputed first and
# last name.
def remove_contact(contacts, first_name, last_name):
    contacts.pop(first_name + last_name)
    return contacts


# Gets whatever contact is under the inputed first and last name and replaces
# the first name with a new one that the user gives. Deletes the old contact
# and makes a new on with all of the original information.
def update_contact_first_name(contacts, first_name, last_name,
                              new_field_value):
    contacts.update({new_field_value + last_name: []})
    for item in contacts[first_name + last_name]:
        if item == first_name:
            item = new_field_value
        contacts[new_field_value + last_name].append(item)
    contacts.pop(first_name + last_name)
    return contacts


# Gets whatever contact is under the inputed first and last name and replaces
# the last name with a new one that the user gives. Deletes the old contact and
# makes a new on with all of the original information.
def update_contact_last_name(contacts, first_name, last_name, new_field_value):
    contacts.update({first_name + new_field_value: []})
    for item in contacts[first_name + last_name]:
        if item == last_name:
            item = new_field_value
        contacts[first_name + new_field_value].append(item)
    contacts.pop(first_name + last_name)
    return contacts


# Gets whatever contact is under the inputed first and last name and replaces
# the email with a new one that the user gives. Deletes the old contact and
# makes a new on with all of the original information.
def update_contact_email(contacts, first_name, last_name, new_field_value):
    contacts[first_name + last_name][2] = new_field_value
    return contacts


# Gets whatever contact is under the inputed first and last name and replaces
# the phone number with a new one that the user gives. Deletes the old contact
# and makes a new on with all of the original information.
def update_contact_phone_number(contacts, first_name, last_name,
                                new_field_value):
    contacts[first_name + last_name][3] = new_field_value
    return contacts


# Gets whatever contact is under the inputed first and last name and replaces
# the birthday with a new one that the user gives. Deletes the old contact and
# makes a new on with all of the original information.
def update_contact_birthday(contacts, first_name, last_name, new_field_value):
    contacts[first_name + last_name][4] = new_field_value
    return contacts
