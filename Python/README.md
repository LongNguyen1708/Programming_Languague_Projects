
Password Auditor (SHA-256)

A simple cybersecurity project that audits user passwords against the **RockYou.txt** breach dataset.  
The tool uses **SHA-256 hashing** to securely compare passwords without ever storing them in plaintext.

---

 Features
- Convert the RockYou.txt password list into a secure SHA-256 hashlist  
- Check if a given password appears in that hashlist  
- Fast lookups using Python sets  
- Demonstrates real-world password auditing concepts  

---

 How It Works
1. **Build step**: Convert RockYou.txt into SHA-256 hashes.  
2. **Check step**: Hash the user’s password and compare it against the hashlist.  
3. If the hash exists → **COMPROMISED**  
   If not → **SAFE**  

---

cmd test
```bash
python password_auditor.py --build rockyou.txt rockyou_sha256.txt
python password_auditor.py --hashlist rockyou_sha256.txt --check "123456"
python password_auditor.py --hashlist rockyou_sha256.txt --check "SuperUniqueP@ssword!"


output
SuperUniqueP@ssword! -> SAFE

