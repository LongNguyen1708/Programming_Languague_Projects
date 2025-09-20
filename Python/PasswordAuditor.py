
import argparse
import hashlib
import sys

def sha256_hex(text: str) -> str:
    return hashlib.sha256(text.encode("utf-8", errors="ignore")).hexdigest()

def build_hash_list(rockyou_path: str, output_path: str):
    count = 0
    with open(rockyou_path, "r", encoding="utf-8", errors="ignore") as infile, \
         open(output_path, "w", encoding="utf-8") as outfile:
        for line in infile:
            pwd = line.strip()
            if not pwd:
                continue
            outfile.write(sha256_hex(pwd) + "\n")
            count += 1
            if count % 500000 == 0:
                print(f"[+] Processed {count:,} passwords...", file=sys.stderr)
    print(f"[+] Done. Saved {count:,} hashes to {output_path}", file=sys.stderr)

def load_hashes(hash_file: str) -> set:
    """Load SHA-256 hashes into a set for quick lookup."""
    with open(hash_file, "r", encoding="utf-8", errors="ignore") as f:
        return {line.strip() for line in f if line.strip()}

def check_password(password: str, hash_set: set) -> str:
    """Check if the password’s SHA-256 is in the breach hash set."""
    h = sha256_hex(password)
    return "COMPROMISED" if h in hash_set else "SAFE"

def main():
    parser = argparse.ArgumentParser(description="Password Auditing Tool (SHA-256)")
    parser.add_argument("--build", nargs=2, metavar=("ROCKYOU.txt", "OUTFILE"),
                        help="Build SHA-256 hash list from RockYou.txt")
    parser.add_argument("--hashlist", help="Path to prebuilt SHA-256 hash list")
    parser.add_argument("--check", help="Password to check")
    args = parser.parse_args()

    ##   Build hash list
    if args.build:
        rockyou, out = args.build
        build_hash_list(rockyou, out)
        return

    ## Check mode
    if not args.hashlist or not args.check:
        parser.error("Must provide --hashlist and --check for checking mode")

    hashes = load_hashes(args.hashlist)
    result = check_password(args.check, hashes)
    print(f"{args.check} → {result}")

if __name__ == "__main__":
    main()
