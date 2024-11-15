import joblib

# Tải mô hình đã lưu
model = joblib.load('sentiment_model.pkl')

# Dự đoán trên dữ liệu mới
def predict_sentiment(text):
    return model.predict([text])[0]

# Ví dụ dự đoán
new_text = "chất lượng công việc tạm được"
print("Dự đoán cảm xúc:", predict_sentiment(new_text))
