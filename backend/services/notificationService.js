const admin = require("firebase-admin");

admin.initializeApp({
    credential: admin.credential.cert(require("./firebase-service-account.json")),
});

exports.sendNotification = async (token, title, body) => {
    const message = {
        notification: { title, body },
        token,
    };

    try {
        await admin.messaging().send(message);
        console.log("Notification sent successfully");
    } catch (error) {
        console.error("Error sending notification:", error);
    }
};