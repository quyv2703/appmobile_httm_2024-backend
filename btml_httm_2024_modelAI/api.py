from flask import Flask, request, jsonify, render_template
import joblib

app = Flask(__name__)

# Tải toàn bộ pipeline đã lưu
pipeline = joblib.load('sentiment_model.pkl')

@app.route('/')
def index():
    return render_template('index.html')  # Route để hiển thị giao diện

@app.route('/predict', methods=['GET'])
def predict():
    text = request.args.get('text')
    if not text:
        return jsonify({'error': 'No text provided'}), 400
    prediction = pipeline.predict([text])[0]
    return jsonify({'sentiment': prediction})

if __name__ == "__main__":
    app.run(host='0.0.0.0', port=5000, debug=True)
