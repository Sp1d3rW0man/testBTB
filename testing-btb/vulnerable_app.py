import sqlite3
import os

def connect_db():
    return sqlite3.connect('example.db')

def create_table():
    conn = connect_db()
    cursor = conn.cursor()
    cursor.execute('''CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, username TEXT, password TEXT)''')
    conn.commit()
    conn.close()

def add_user(username, password):
    conn = connect_db()
    cursor = conn.cursor()
    cursor.execute(f"INSERT INTO users (username, password) VALUES ('{username}', '{password}')")
    conn.commit()
    conn.close()

def get_user(username):
    conn = connect_db()
    cursor = conn.cursor()
    query = f"SELECT * FROM users WHERE username = '{username}'"
    cursor.execute(query)
    user = cursor.fetchone()
    conn.close()
    return user

def execute_command(command):
    os.system(command)

def main():
    create_table()
    while True:
        print("1. Add user")
        print("2. Get user")
        print("3. Execute command")
        print("4. Exit")
        choice = input("Enter choice: ")

        if choice == '1':
            username = input("Enter username: ")
            password = input("Enter password: ")
            add_user(username, password)
            print("User added successfully")
        elif choice == '2':
            username = input("Enter username: ")
            user = get_user(username)
            if user:
                print(f"User found: {user}")
            else:
                print("User not found")
        elif choice == '3':
            command = input("Enter command to execute: ")
            execute_command(command)
        elif choice == '4':
            break
        else:
            print("Invalid choice. Please try again.")

if __name__ == "__main__":
    main()
