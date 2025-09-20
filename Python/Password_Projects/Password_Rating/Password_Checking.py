import os
import string
from Hashing import hash_sha1, hash_sha256, verify

COMMON_LIST_PATH = "rockyou.txt"
MAX_COMMON_WORDS = 500_000

symbols = string.punctuation


def load_common_passwords(path: str, cap: int = MAX_COMMON_WORDS) -> set[str]:
    """
    Loads a newline-separated list of common passwords into a set (lowercased).
    If the file doesn't exist, falls back to a small built-in sample.
    """
    fallback = {
        "password", "123456", "123456789", "qwerty", "abc123",
        "password1", "111111", "letmein", "iloveyou", "dragon"
    }
    if not os.path.exists(path):
        print(f"[i] No '{path}' found. Using small built-in list ({len(fallback)} items).")
        return fallback

    common = set()
    with open(path, "r", errors="ignore") as f:
        for i, line in enumerate(f, 1):
            pw = line.strip().lower()
            if pw:
                common.add(pw)
            if i >= cap:
                print(f"[i] Reached cap of {cap} entries from '{path}'.")
                break
    print(f"[i] Loaded {len(common)} common passwords from '{path}'.")
    return common

def check_password(password, common_passwords: set[str]):
    issues = []
    score = 0

    # Immediate fail if in common list (case-insensitive)
    if password.lower() in common_passwords:
        issues.append("This password is too common!")
        return 0, issues

    if any(ch.isupper() for ch in password):
        score += 1
    else:
        issues.append("Missing uppercase letter")

    if any(ch.islower() for ch in password):
        score += 1
    else:
        issues.append("Missing lowercase letter")

    if any(ch.isdigit() for ch in password):
        score += 1
    else:
        issues.append("Missing digit")

    if any(ch in symbols for ch in password):
        score += 1
    else:
        issues.append("Missing symbol")

    if len(password) >= 12:
        score += 1
    else:
        issues.append("Too short (<12 chars)")

    # no identical consecutive characters (aa, 11, !!)
    if not any(a == b for a, b in zip(password, password[1:])):
        score += 1
    else:
        issues.append("Contains identical consecutive characters")

    return score, issues



if __name__ == "__main__":
    common_pw_set = load_common_passwords(COMMON_LIST_PATH)

    pwd = input("Enter your password: ")
    score, issues = check_password(pwd, common_pw_set)

    print(f"\nScore: {score}/6")
    if issues:
        print("Problems found:")
        for i in issues:
            print(" -", i)
    else:
        print("Strong password!")

    # Example: hash a password
    print("\n--- Hashing Demo ---")
    print("SHA-1   :", hash_sha1(pwd))
    print("SHA-256 :", hash_sha256(pwd))

    # Store password securely (simulated)
    stored = hash_sha256(pwd)

    # Verify
    guess = input("\nEnter password guess: ")
    if verify(guess, stored, "sha256"):
        print("✅ Correct password!")
    else:
        print("❌ Wrong password")