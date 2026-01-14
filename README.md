# AnonChatX Ripple

**AnonChatX Ripple** is the panic-mode trigger for the AnonChatX ecosystem.

It exists for one reason only:

**to let a user silently and immediately alert trusted contacts when they are no longer safe.**

Ripple is not a messenger.
It is a **signal**.

---

## What Panic Mode Means in AnonChatX

Panic Mode is a **deliberate, user-initiated emergency action**.

When Panic Mode is triggered through Ripple:

- AnonChatX is notified immediately
- All configured **panic contacts** are alerted
- A predefined panic message is sent to those contacts
- The user does **not** need to type, unlock chats, or navigate menus
- The action works under stress, coercion, or time pressure

This is about **getting a warning out** when normal communication is no longer possible.

---

## Panic Contacts

AnonChatX allows users to explicitly mark certain contacts as **panic contacts**.

These are people the user trusts to:
- recognize a distress signal
- act quickly
- understand that silence may follow

When Ripple triggers Panic Mode:
- Panic contacts receive a message indicating that the user is in danger
- The message can be pre-defined to avoid improvisation
- No additional confirmation or interaction is required at trigger time
- **The AnonChatX account and all local application data are immediately deleted**

This includes:
- chat history
- contacts and metadata
- local databases and caches
- cryptographic material stored on the device

The design assumes **clarity over deniability** once Panic Mode is activated.

---

## Why Ripple Is a Separate App

Panic functionality is intentionally **not embedded** inside AnonChatX itself.

Ripple exists as a separate app to:
- reduce friction at the moment of activation
- avoid deep navigation inside the protected app
- allow faster access (including launcher shortcuts or gestures)
- isolate panic logic from everyday communication logic

This separation is a security decision.

---

## Threat Model (High-Level)

AnonChatX Ripple is designed for scenarios such as:
- sudden detention or arrest
- device seizure
- coercion to unlock a device
- border crossings
- protests, civil unrest, or hostile environments
- situations where sending a normal message is no longer possible

It is **not** designed to:
- protect against a fully compromised operating system
- defeat forensic analysis after long-term access
- replace operational security practices

Ripple is about **signalling danger early**, not erasing consequences after the fact.

---

## How It Works (Conceptual)

1. The user configures panic contacts in AnonChatX
2. The user installs Ripple
3. In an emergency, the user triggers Panic Mode via Ripple
4. AnonChatX immediately sends the panic signal to panic contacts
5. Contacts are alerted that the user may be at risk

No negotiation.
No explanation required at the moment of activation.

---

## Build & Releases

Local builds are produced using Gradle.

Release builds are cryptographically signed.

Creating a version tag automatically:
- builds a signed release APK
- publishes it on GitHub Releases

See the GitHub Actions workflow in `.github/workflows/release.yml`.

---

## Ripple

This project is a fork of **Ripple by the Guardian Project**.

This fork adapts Ripple specifically for:
- AnonChatX panic-mode semantics
- panic contact signalling
- modern Android tooling
- reproducible, signed releases

All upstream licensing and attribution are preserved.

---

## License

Licensed under the same terms as the upstream Ripple project.
See `LICENSE.txt` for details.

---

## Philosophy

Privacy is not secrecy.
Privacy is the ability to **ask for help without asking for permission**.

AnonChatX Ripple exists for the moment when:
- silence is dangerous
- delay is unacceptable
- safety matters more than appearances

No trackers.
No analytics.
No unnecessary permissions.

---

## Contributing

This is a security-sensitive project.

If you discover a vulnerability or design concern, please report it responsibly.
Public issues should avoid disclosing exploit details.

