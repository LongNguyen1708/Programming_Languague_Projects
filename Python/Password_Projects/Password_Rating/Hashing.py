import hashlib

def hash_sha1(password: str) -> str:
    """Return SHA-1 hash of a password (hex string)."""
    return hashlib.sha1(password.encode("utf-8")).hexdigest()

def hash_sha256(password: str) -> str:
    """Return SHA-256 hash of a password (hex string)."""
    return hashlib.sha256(password.encode("utf-8")).hexdigest()

def verify(password: str, stored_hash: str, algo: str = "sha256") -> bool:
    """Check if a password matches a stored hash."""
    if algo == "sha1":
        return hash_sha1(password) == stored_hash.lower()
    elif algo == "sha256":
        return hash_sha256(password) == stored_hash.lower()
    else:
        raise ValueError(f"Unsupported algorithm: {algo}")
